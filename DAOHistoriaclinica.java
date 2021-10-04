package DAO;

import TO.TOHistoriaclinica;
import db.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOHistoriaclinica {

    private final ConexionDB con;
    private final String nombreTabla;
    private final String nombreVista;

    public DAOHistoriaclinica() {
        this.nombreTabla = "HistoriaClinica";
        this.nombreVista = "vistahistoriaclinica";
        con = new ConexionDB();
        

    }

    public ArrayList<TOHistoriaclinica> consultarHistoriasclinicas() {
        TOHistoriaclinica historiaclinica;
        ArrayList<TOHistoriaclinica> historiasclinicas = new ArrayList<>();
        try {
            ResultSet rs = con.consultar(nombreVista);
            while (rs.next()) {
                historiaclinica = new TOHistoriaclinica();
                historiaclinica.setIdhistoriaClinica(rs.getInt("idhistoriaClinica"));
                historiaclinica.setAntecedentes(rs.getString("antecedentes"));
                historiaclinica.setMotivoConsulta(rs.getString("motivoConsulta"));
                historiaclinica.setSignosVitales(rs.getString("signosVitalesn"));
                historiaclinica.setDiagnostico(rs.getString("diagnostico"));
                historiaclinica.setTratamiento(rs.getString("tratamiento"));
                historiaclinica.setOrdenesMedicas(rs.getString("ordenesMedicas"));
                historiaclinica.setProximoControl(rs.getDate("proximoControl"));
                historiaclinica.setOrdenLaboratorios(rs.getString("ordenLaboratorios"));
                historiaclinica.setOrdenImagenesDiagnosticas(rs.getString("ordenImagenesDiagnosticas"));
                historiaclinica.setIdHistoriaCita(rs.getInt("idHistoriaCita"));
                

                historiasclinicas.add(historiaclinica);
            }
            return historiasclinicas;
        } catch (SQLException ex) {
            System.out.println("Error en DAOHistoriaclinica.consultarHistoriasclinicas: " + ex.getMessage());
            return null;
        }

    }

    public int insertarHistoriasclinicas(TOHistoriaclinica historiasclinica) {
        String[] valores = {String.valueOf(historiasclinica.getIdHistoriaCita()), historiasclinica.getAntecedentes(), historiasclinica.getMotivoConsulta(), historiasclinica.getSignosVitales(), historiasclinica.getDiagnostico(), historiasclinica.getTratamiento(), historiasclinica.getOrdenesMedicas(), historiasclinica.getProximoControl().toString(), historiasclinica.getOrdenLaboratorios(), historiasclinica.getOrdenImagenesDiagnosticas(), String.valueOf(historiasclinica.getIdHistoriaCita())};
        try{
        return con.insertar(nombreTabla, valores);
        }catch(Exception ex){
            System.out.println("Error en DAOHistoriaclinica.insertarHistoriasclinicas: " + ex.getMessage());
            return 0;
        }
    }
    
      public boolean modificarHistoriasclinicas(TOHistoriaclinica historiasclinica) {
        String[] valores = {String.valueOf(historiasclinica.getIdHistoriaCita()), historiasclinica.getAntecedentes(), historiasclinica.getMotivoConsulta(), historiasclinica.getSignosVitales(), historiasclinica.getDiagnostico(), historiasclinica.getTratamiento(), historiasclinica.getOrdenesMedicas(), historiasclinica.getProximoControl().toString(), historiasclinica.getOrdenLaboratorios(), historiasclinica.getOrdenImagenesDiagnosticas(), String.valueOf(historiasclinica.getIdHistoriaCita())};
        try {
            return con.actualizar(nombreTabla, valores, historiasclinica.getIdhistoriaClinica());
          }catch(Exception ex){
            System.out.println("Error en DAOHistoriaclinica.modificarHistoriasclinicas: " + ex.getMessage());
            return false;
        }
      }
        
        public boolean eliminarHistoriasclinicas(int id) {
        try {
            return con.eliminar(nombreTabla,id);
          }catch(Exception ex){
            System.out.println("Error en DAOHistoriaclinica.eliminarHistoriasclinicas: " + ex.getMessage());
            return false;
        }
        }
        
    }
    