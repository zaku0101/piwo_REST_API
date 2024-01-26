package com.mos.piwoCRUD.api;

import com.mos.piwoCRUD.exception.ResourceNotFoundException;
import com.mos.piwoCRUD.model.Module;
import com.mos.piwoCRUD.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ModuleController {

@Autowired
    ModuleRepository moduleRepository;

@GetMapping("/modules")
    public ResponseEntity<List<Module>> getAllModules(@RequestParam(required = false)String qr){
    List<Module> modules =new ArrayList<Module>();

    if(modules.isEmpty())
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    return new ResponseEntity<>(modules, HttpStatus.OK);
}
@GetMapping("/modules/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable("id") String qr) throws ResourceNotFoundException {
    Module module =moduleRepository.findById(qr)
            .orElseThrow(() -> new ResourceNotFoundException("Not found module with id: "+qr));
return new ResponseEntity<>(module, HttpStatus.OK);
}

@PostMapping("/modules")
public ResponseEntity<Module> createModule(@RequestBody Module module) {
    Module savedModule = moduleRepository.save(new Module(module.getQr(), false));
    return new ResponseEntity<>(savedModule, HttpStatus.CREATED);
    }
@PutMapping("/modules/{id}")
public ResponseEntity<Module> updateModule(@PathVariable("id") String qr, @RequestBody Module module) throws ResourceNotFoundException {
    Module currentModule = moduleRepository.findById(qr)
            .orElseThrow(() -> new ResourceNotFoundException("Not found module with id: "+qr));

    currentModule.setQr(module.getQr());
    currentModule.setBroken(module.isBroken());

    Module updatedModule = moduleRepository.save(currentModule);
    return new ResponseEntity<>(updatedModule, HttpStatus.OK);
}
@DeleteMapping("/modules/{id}")
public ResponseEntity<HttpStatus> deleteModule(@PathVariable("id") String qr) throws ResourceNotFoundException {
    moduleRepository.deleteById(qr);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
@GetMapping("modules/broken")
    public ResponseEntity<List<Module>> getAllBrokenModules(){
    List<Module> modules = moduleRepository.findByBroken(true);
        if(modules.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(modules, HttpStatus.OK);

    }
}
