/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.ArrayList;

public class ClasseDadosGravacao {

    private static ClasseDadosGravacao uniqueinstance;
    public static ArrayList<Laboratorio> listaLaboratorio = new ArrayList<>();
    public static ArrayList<Exame> listaExames= new ArrayList<>();
    public static ArrayList<Ala> listaAla= new ArrayList<>();
    public static ArrayList<Internacao> listaInternacao= new ArrayList<>();
    public static ArrayList<Quarto> listaQuarto= new ArrayList<>();
    public static ArrayList<Jornada> listaJornada= new ArrayList<>();
    public static ArrayList<Acompanhante> listaAcompanhante= new ArrayList<>();
    public static ArrayList<Medicamento> listaMedicamento= new ArrayList<>();
    public static ArrayList<Usuario> listaUsuario= new ArrayList<>();
    public static ArrayList<Receita> listaReceita= new ArrayList<>();
    public static ArrayList<Medico> listaMedico = new ArrayList<>();
     public static ArrayList<Farmaceutico> listaFarmaceutico = new ArrayList<>();
    

    private ClasseDadosGravacao() {
    }

    public static synchronized ClasseDadosGravacao getInstance() {

        if (uniqueinstance == null) {
            uniqueinstance = new ClasseDadosGravacao();
        }

        return uniqueinstance;
    }

}

