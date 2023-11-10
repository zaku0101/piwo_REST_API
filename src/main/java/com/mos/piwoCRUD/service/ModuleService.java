package com.mos.piwoCRUD.service;

import com.mos.piwoCRUD.dao.ModuleDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ModuleService {
private final ModuleDAO moduleDAO;

    public ModuleService(@Qualifier("postgres") ModuleDAO moduleDAO) {
        this.moduleDAO = moduleDAO;
    }

}
