package com.mos.piwoCRUD.repository;

import com.mos.piwoCRUD.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, String> {
    List<Module> findByBroken(boolean isBroken);

}
