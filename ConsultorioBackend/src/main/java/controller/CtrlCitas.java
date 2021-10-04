package controller;
import DAO.DAOCitas;
import TO.TOCitas;
import TO.TOHistoriaclinica;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CtrlCitas {
    DAOCitas citasDAO;

    public CtrlCitas() {
        citasDAO = new DAOCitas();
    }
    
    
        public ArrayList<TOCitas> consultarCitas() {
        
            return citasDAO.consultarCitas();
          
    }
    
        public int insertarCitas(TOCitas citas) {
        
        return citasDAO.insertarCitas(citas);
        
    }
    
      public boolean modificarCita(TOCitas citas) {
        return citasDAO.modificarCitas(citas);
          
      }
    
    public boolean eliminarCita (int id){
        return citasDAO.eliminarCitas(id);
        
    }
    
}

