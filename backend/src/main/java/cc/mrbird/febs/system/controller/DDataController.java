package cc.mrbird.febs.system.controller;


import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.FebsResponse;
import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.system.domain.DData;
import cc.mrbird.febs.system.service.DDataService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("ddata")
public class DDataController extends BaseController {

    @Autowired
    private DDataService dDataService;


    @GetMapping
    @Log("查询数据列表")
    public Map<String,Object> ddataList(QueryRequest queryRequest,DData dData){
        return super.selectByPageNumSize(queryRequest,()-> this.dDataService.findDData(queryRequest,dData));
    }


    @PostMapping("/create")
    public void createData(@Valid  DData dData){
        this.dDataService.createDData(dData);
    }

    @PostMapping("/update")
    public FebsResponse updateData(@Valid DData dData) throws FebsException {
        if(dData.getDataStatus().equals("finish")){
            try {
                this.dDataService.finishData(dData);
            } catch (Exception e) {
                log.error("数据转化异常",e);
                throw new FebsException("数据归档异常");
            }
            return new FebsResponse().message("数据已归档");
        }
        this.dDataService.updateDData(dData);
        return new FebsResponse().message("成功");
    }

    @GetMapping("/delete/{dataId}")
    @RequiresPermissions("data:delete")
    public FebsResponse deleteData(@PathVariable Integer dataId){
        this.dDataService.deleteDData(dataId);
        return new FebsResponse().message("已删除数据编号"+dataId);
    }


}
