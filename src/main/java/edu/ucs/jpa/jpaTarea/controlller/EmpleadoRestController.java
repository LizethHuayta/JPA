/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucs.jpa.jpaTarea.controlller;

import edu.ucs.jpa.jpaTarea.entity.Empleado;
import edu.ucs.jpa.jpaTarea.service.EmpleadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */

@RestController
@RequestMapping("/emp")
public class EmpleadoRestController {
    
    @Autowired
    private EmpleadoService empleadoService;
    
    @GetMapping("/all")
    public List<Empleado>getPosts(){
        return empleadoService.readAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Empleado>getEmpleado(@PathVariable int id){
        Empleado empleado=empleadoService.read(id);
        return ResponseEntity.ok(empleado);
    }
    
    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable int id){
        empleadoService.delete(id);
    }
    
    @PostMapping("/add")
    public Empleado addEmpleado(@RequestBody Empleado empleado){
        return empleadoService.create(empleado);
    }
    
    @PutMapping("/edit")
    public Empleado editEmpleado(@RequestBody Empleado empleado){
        Empleado emp=new Empleado(empleado.getId(), empleado.getNombres(),empleado.getApellidos(),empleado.getDni());
        System.out.println(empleado.getId()+" , "+empleado.getNombres()+" , "+empleado.getApellidos()+" , "+ empleado.getDni());
        return empleadoService.update(empleado);
    }
}
