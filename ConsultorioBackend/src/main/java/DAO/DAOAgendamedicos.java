package DAO;

import TO.TOAgendamedicos;
import db.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOAgendamedicos {
    
    private final ConexionDB con;
    private final String nombreTabla;
    private final String nombreVista;
    
    
 public DAOAgendamedicos() {
        this.nombreTabla = " Agendamedicos";
        this.nombreVista = "Vistaagendamedicos";
        con = new ConexionDB();        
    }


public ArrayList<TOAgendamedicos> consultarAgenda() {
        TOAgendamedicos agendamedico;
        ArrayList<TOAgendamedicos> agendamedicos = new ArrayList<>();
                       
        try {
            ResultSet rs = con.consultar("agendamedico");
            while (rs.next()) {
                
            agendamedico = new TOAgendamedicos();
            agendamedico.setIdAgendaMedicos(rs.getInt("idAgendamedico"));
            agendamedico.setIdMedicoAgenda(rs.getInt("idMedicoAgenda"));
            agendamedico.setFecha(rs.getDate("fecha"));
            agendamedico.setHora(rs.getString("hora")); 
            agendamedico.setEstado(rs.getString("estado"));       
                
              agendamedicos.add(agendamedico) ;
            }
            return agendamedicos;
            
        } catch (SQLException ex) {
            System.out.println("Error en DAOAgendamedicos.consultarAgendaMedicos: " + ex.getMessage());
            return null;
        }
    }

public int insertarAgendamedicos(TOAgendamedicos agendamedico) {
        String[] valores = {String.valueOf(agendamedico.getIdAgendaMedicos()),String.valueOf(agendamedico.getIdMedicoAgenda()),String.valueOf(agendamedico.getFecha()),String.valueOf(agendamedico.getHora()),String.valueOf(agendamedico.getEstado())};
        try{
        return con.insertar(nombreTabla, valores);
        }catch(Exception ex){
        System.out.println("Error en DAOAgendaMedicos.insertarAgendamedicos: " + ex.getMessage());
            return 0;
        }
    }
    
      public boolean modificarAgendamedicos(TOAgendamedicos agendamedico) {
        String[] valores = {String.valueOf(agendamedico.getIdAgendaMedicos()),String.valueOf(agendamedico.getIdMedicoAgenda()),String.valueOf(agendamedico.getFecha()),String.valueOf(agendamedico.getHora()),String.valueOf(agendamedico.getEstado())};
        try{
        return con.actualizar(nombreTabla, valores,agendamedico.getIdAgendaMedicos());
        }catch(Exception ex){
        System.out.println("Error en DAOAgendaMedicos.insertarAgendamedicos: " + ex.getMessage());
            return false;
        }
      }
        
        public boolean eliminarAgendamedicos(int id) {
        try {
            return con.eliminar(nombreTabla,id);
          }catch(Exception ex){
            System.out.println("Error en DAOHistoriaclinica.eliminarHistoriasclinicas: " + ex.getMessage());
            return false;
        }
        }
        
    }



    

    