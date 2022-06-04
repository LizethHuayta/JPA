
package edu.ucs.jpa.jpaTarea.service;

import edu.ucs.jpa.jpaTarea.entity.Empleado;
import java.util.List;

/**
 *
 * @author HP
 */
public interface EmpleadoService {
    Empleado create(Empleado empleado);
    Empleado update(Empleado empleado);
    void delete(int id);
    Empleado read(int id);
    List<Empleado>readAll();
    
}
