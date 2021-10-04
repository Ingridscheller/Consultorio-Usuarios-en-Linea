package controller;

import DAO.DAOMedicamentos;
import TO.TOCitas;
import TO.TOMedicamentos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CtrlMedicamentos {
     DAOMedicamentos medicamentosDAO;

    public CtrlMedicamentos() {
        medicamentosDAO = new DAOMedicamentos();
    }
    
    
        public ArrayList<TOMedicamentos> consultarMedicamentos() {
        
            return medicamentosDAO.consultarMedicamentos();
          
    }
    
        public int insertarMedicamentos(TOMedicamentos medicamentos) {
        
        return medicamentosDAO.insertarMedicamentos(medicamentos);
        
    }
    
      public boolean modificarMedicamentos(TOMedicamentos medicamentos) {
        return medicamentosDAO.actualizarMedicamentos(medicamentos);
          
      }
    
    public boolean eliminarMedicamentos (int id){
        return medicamentosDAO.eliminarMedicamentos(id);
        
    }
    
}
    

