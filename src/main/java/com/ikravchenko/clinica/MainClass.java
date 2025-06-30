//package com.ikravchenko.clinica;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//public class MainClass {
//
//    public static void main(String[] args) {
//        Empleado empl = new Empleado("illia", 2300100, 001, 100000, Cargo.ADMINISTRADOR, "2025-01-12");
//
//        empl.telefono = "0328271744";
//        empl.mostrarInformacion();
//
//        Paciente paciente = new Paciente("illia", 21212, Arrays.asList(Alergia.GLUTEN, Alergia.LACTOSA), GrupoSanguineo.AB_POS);
//        paciente.mostrarInformacion();
//
//        Administrativo adm = new Administrativo("illia", 12311212, 23, 20000, Cargo.RECEPCIONISTA, "2001-12-31", Area.ADMINISTRACION);
//        System.out.println(adm.getArea());
//        adm.mostrarInformacion();
//
//        Enfermero enf = new Enfermero("illia", 12311212, 23, 20000, Cargo.MEDICO, "2021-06-31", Turno.NOCHE);
//        enf.mostrarInformacion();
//
//        Map<String, String> horarios = new HashMap<>();
//        horarios.put("Lunes", "08:00-12:00");
//        horarios.put("Martes", "10:00-14:00");
//
//
//        Medico med = new Medico("illia", 12311212, 23, 20000, Cargo.MEDICO, "2021-06-31", Especialidad.CARDIOLOGIA, "MT121212", horarios);
//        Map<String, String> hor = med.getHorarioAtencion();
//        for (String dia : hor.keySet()) {
//            System.out.println(dia + ": " + hor.get(dia));
//        }
//    }
//}
