package DAO;

import TO.TOCitas;
import db.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOCitas {
   
    private final ConexionDB con;
    private final String nombreTabla;
    private final String vistaTabla;
    
    public DAOCitas() {
        this.nombreTabla = "Citas";
        this.vistaTabla = "vistacitas";
        con = new ConexionDB();
      
    }
     public ArrayList<TOCitas> consultarCitas() {
        TOCitas cita;
        ArrayList<TOCitas> citas = new ArrayList<>();
        
        try{         
            ResultSet rs = con.consultar("Citas");
            while (rs.next()){
                cita= new TOCitas();
                cita.setIdCitas(rs.getInt("idcitas"));                       
                cita.setIdPacientesCitas(rs.getInt("idpacientescitas"));
                cita.setIdAgendaMedico(rs.getInt("idagendamedico"));
                
                citas.add(cita); 
            }
            return citas;
        } catch (SQLException ex) {
            System.out.println("Error en DAOHistoriaclinica.consultarHistoriasclinicas: " + ex.getMessage());
            return null;
        }

    }
     public int insertarCitas(TOCitas cita){
        String[]valores ={String.valueOf(cita.getIdCitas()),String.valueOf(cita.getIdPacientesCitas()),String.valueOf(cita.getIdAgendaMedico())};   
        try{
        return con.insertar(nombreTabla, valores);
        }catch(Exception ex){
            System.out.println("Error en DAOCitas.insertarCitas: " + ex.getMessage());
            return 0;
        }
    }
     
    public boolean modificarCitas(TOCitas cita) {
        String[] valores = {String.valueOf(cita.getIdCitas()), String.valueOf(cita.getIdPacientesCitas()), String.valueOf(cita.getIdAgendaMedico())};
        try{
            return con.actualizar(nombreTabla, valores,cita.getIdCitas());
            } catch (Exception ex) {
            System.out.println("Error en DAOCitas.modificarCitas: " + ex.getMessage());
            return false;
        }
     }
        
     public boolean eliminarCitas(int id) {
        try {
            return con.eliminar(nombreTabla, id);
        } catch (Exception ex) {
            System.out.println("Error en DAOCitas.eliminarCitas: " + ex.getMessage());
            return false;
        }
        }
        
    }

