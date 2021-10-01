
package controller;

import DAO.DAOHistoriaclinica;
import TO.TOHistoriaclinica;
import java.util.ArrayList;

/**
 *
 * @author williamsalazar
 */
public class CtrlHistoriaclinica {
    
    DAOHistoriaclinica historiasclinica;

    public CtrlHistoriaclinica() {
        historiasclinica = new DAOHistoriaclinica();
    }
    
    
        public ArrayList<TOHistoriaclinica> consultarHistoriaclinica() {
        
            return historiasclinica.consultarHistoriaclinica();
          
    }
    
        public int insertarHistoriaclinica(TOHistoriaclinica historiaclinica) {
        
        return historiasclinica.insertarHistoriaclinica(historiaclinica);
        
    }
    
      public boolean modificarHistoriaclinica(TOHistoriaclinica historiaclinica) {
        return historiasclinica.modificarHistoriaclinica(historiaclinica);
          
      }
    
    public boolean eliminarHistoriaclinica (int id){
        return historiasclinica.eliminarHistoriaclinica(id);
        
    }
    
}
