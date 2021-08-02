package com.controller;

import com.entity.Data;
import com.entity.Info;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @GetMapping(value = "/updateData")
    public Data get(Info info) {
        return dealWith(info);
    }

    private Data dealWith(Info info){

        Data data = new Data();

        if(info.getVersionCode()<10000){
            data.setCode(0);
            data.setMsg("code wrong");
            data.setUpdateStatus(1);
            data.setVersionCode(10000);
            data.setVersionName("test");
            data.setModifyContent("for test");
            data.setDownloadUrl("https://github.com/JungleDeeer/SakuraAnime/releases/download/V1.0/PiliPili.apk");
            data.setApkSize(7247);
            data.setApkMd5("2b3dc2744beb159ba478f2f145d6b8e7");

        }
        return data;
    }
}
