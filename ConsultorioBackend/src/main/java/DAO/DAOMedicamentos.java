package DAO;

import TO.TOMedicamentos;
import db.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOMedicamentos {
    private final ConexionDB con;
    private final String nombreTabla;
    private final String nombreVista;

 public DAOMedicamentos() {
        this.nombreTabla = "Medicamentos";
        this.nombreVista = "vistamedicamentos";
        con = new ConexionDB();
       
    }   
   public ArrayList<TOMedicamentos> consultarMedicamentos() {
        TOMedicamentos medicamentos;
        ArrayList<TOMedicamentos> medicamento = new ArrayList<>();
        try {
           ResultSet rs = con.consultar("Medicamentos");
           while (rs.next()){
               medicamentos = new TOMedicamentos();
               medicamentos.setIdMedicamentos(rs.getInt("idmedicamentos"));
               medicamentos.setNombreMedicamento(rs.getString("nombremedicamento"));
               medicamentos.setPresentacion(rs.getString("presentacion"));

               medicamento.add(medicamentos);
            }
                  return medicamento;
        } catch (SQLException ex) {
            System.out.println("Error en DAOMedicamentos.consultarMedicamentos: " + ex.getMessage());
            return null;
        }
   }    
        public int insertarMedicamentos(TOMedicamentos medicamento){
        String[] valores = {String.valueOf(medicamento.getIdMedicamentos()),String.valueOf(medicamento.getNombreMedicamento()),String.valueOf(medicamento.getPresentacion())};
        try{
        return con.insertar(nombreTabla, valores);
        }catch(Exception ex){
            System.out.println("Error en DAOMedicamentos.insertarMedicamento: " + ex.getMessage());
            return 0;
         }      
    }  
    public boolean actualizarMedicamentos(TOMedicamentos medicamentos){
        
        String[] valores = {String.valueOf(medicamentos.getIdMedicamentos()),String.valueOf(medicamentos.getNombreMedicamento()),String.valueOf(medicamentos.getPresentacion())};
        try{
            return con.actualizar(nombreTabla, valores, 0);
        }catch(Exception ex){
            System.out.println("Error en DAOMedicamentos.insertarMedicamentos: " + ex.getMessage());
            return false;
        }
   }
    public boolean eliminarMedicamentos(int id) {
        try {
            return con.eliminar(nombreTabla,id);
          }catch(Exception ex){
            System.out.println("Error en DAOMedicamentos.eliminarMedicamentos: " + ex.getMessage());
            return false;
        }
     }
}


