/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersi = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observacion, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {

        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);

        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtenEsp(atenEsp);
        masco.setObservaciones(observacion);
        masco.setUnDuenio(duenio);

        controlPersi.guardar(duenio, masco);

    }

    public List<Mascota> traetMascotas() {
        return controlPersi.traerMascotas();
    }

    public void borrarMascota(int numCliente) {
        controlPersi.borrarMascota(numCliente);
    }

    public Mascota traerMascota(int numCliente) {
        return controlPersi.traerMascota(numCliente);
    }

    public void modificarMascota(Mascota masco,String nombreMasco, String raza, String color, String observacion, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observacion);
        masco.setAlergico(alergico);
        masco.setAtenEsp(atenEsp);
        
        controlPersi.modificarMascota(masco);
        
        Duenio duenio = this.buscarDuenio(masco.getUnDuenio().getIdDuenio());
        duenio.setCelDuenio(celDuenio);
        duenio.setNombre(nombreDuenio);
        
        this.modificarDuenio(duenio);
        
    }

    private Duenio buscarDuenio(int idDuenio) {
        return controlPersi.traerDuenio(idDuenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersi.modificarDuenio(duenio);
    }

}
