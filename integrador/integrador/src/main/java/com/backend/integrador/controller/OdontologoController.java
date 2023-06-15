package com.backend.integrador.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

/*
    private OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }



    //GET
    @GetMapping()
    public List<Odontologo> listarOdontologos() {
        return odontologoService.listarOdontologos();
    }

    @GetMapping("/{id}")
    public Odontologo buscarOdontologoPorId(@PathVariable int id) {
        return odontologoService.buscarOdontologoPorId(id);
    }

    //POST
    @PostMapping("/registrar")
    public Odontologo registrarOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.registrarOdontologo(odontologo);
    }

    //PUT
    @PutMapping("/actualizar")
    public Odontologo actualizarOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.actualizarOdontologo(odontologo);
    }

    //DELETE
    @DeleteMapping("/eliminar/{id}")
    public void eliminarOdontologo(@PathVariable int id) {
        odontologoService.eliminarOdontologo(id);
    }
*/
}
