package com.backend.integrador.controller;

import com.backend.integrador.entity.Paciente;
import com.backend.integrador.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    /*@GetMapping("/index")
    public String buscarPacientePorDni(Model model, @RequestParam("dni") String dni){
        Paciente paciente = pacienteService.buscarPacientePorDni(dni);

        //agregar los atributos del objeto al modelo que mostraremos en la vista
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());

        return "index";
    }*/

    //POST
    @PostMapping("/registrar")
    public Paciente registrarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.guardarPaciente(paciente);

    }

    //PUT
    @PutMapping("/actualizar")
    public Paciente actualizarPaciente(@RequestBody Paciente paciente){
        return pacienteService.actualizarPaciente(paciente);
    }

    //GET
    @GetMapping
    public List<Paciente> listarTodos(){
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{id}")
    public Paciente buscarPacientePorId(@PathVariable int id){
        return pacienteService.buscarPacientePorId(id);
    }

    //DELETE
    @DeleteMapping("/eliminar/{id}")
    public void eliminarPaciente(@PathVariable int id){
        pacienteService.eliminarPaciente(id);
    }

}
