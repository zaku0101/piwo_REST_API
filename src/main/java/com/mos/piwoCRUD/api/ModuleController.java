package com.mos.piwoCRUD.api;

import com.mos.piwoCRUD.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api")
@RestController
public class ModuleController {
    private final ModuleService moduleService;
@Autowired
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }
    

}
