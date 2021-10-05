
package DAO;

import TO.TOAgendamedicos;
import db.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author williamsalazar
 */
public class DAOAgendamedicos {
    
    private final ConexionDB con;
    private final String nombreTabla;
    
    DAOAgendamedicos() {
        this.nombreTabla = "Agendamedicos";
        con = new ConexionDB();
        

    }
    
      public ArrayList<TOAgendamedicos> consultarAgendamedicos() {
        TOAgendamedicos agendamedico;
        ArrayList<TOAgendamedicos> agendasmedicos = new ArrayList<>();
        try {
            ResultSet rs = con.consultar("Agendamedicos");
            while (rs.next()) {
                agendamedico = new TOAgendamedicos();
                agendamedico.setIdAgendaMedicos(rs.getInt("idagendaMedicos"));
                agendamedico.setFecha(rs.getDate("fecha"));
                agendamedico.setHora(rs.getString("hora"));
                agendamedico.setEstado(rs.getString("estado"));
                agendamedico.setIdMedicoAgenda(rs.getInt("idmedicoAgenda"));
                

                agendasmedicos.add(agendamedico);
            }
            return agendasmedicos;
        } catch (SQLException ex) {
            System.out.println("Error en DAOAgendamedicos.consultarAgendamedicos: " + ex.getMessage());
            return null;
        }

    }

    public int insertarAgendamedicos(TOAgendamedicos agendamedico) {
        String[] valores = {String.valueOf(agendamedico.getIdAgendaMedicos()), String.valueOf(agendamedico.getIdMedicoAgenda()), agendamedico.getFecha().toString(), agendamedico.getHora(), agendamedico.getEstado()};
        try{
        return con.insertar(nombreTabla, valores);
        }catch(Exception ex){
            System.out.println("Error en DAOAgendamedicos.insertarHistoriasclinicas: " + ex.getMessage());
            return 0;
        }
    }
    
      public boolean modificarAgendamedicos(TOAgendamedicos agendamedico) {
        String[] valores = {String.valueOf(agendamedico.getIdAgendaMedicos()), String.valueOf(agendamedico.getIdMedicoAgenda()), agendamedico.getFecha().toString(), agendamedico.getHora(), agendamedico.getEstado()};
        try{
            return con.actualizar(nombreTabla, valores, agendamedico.getIdAgendaMedicos());
          }catch(Exception ex){
            System.out.println("Error en DAOAgendaMedicos.modificarAgendaMedicos: " + ex.getMessage());
            return false;
        }
      }
        
        public boolean eliminarAgendamedicos(int id) {
        try {
            return con.eliminar(nombreTabla,id);
          }catch(Exception ex){
            System.out.println("Error en DAOAgendamedicos.eliminarAgendamedicos: " + ex.getMessage());
            return false;
        }
        }
        
}
