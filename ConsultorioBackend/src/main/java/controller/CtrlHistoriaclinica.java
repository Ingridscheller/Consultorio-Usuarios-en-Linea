package controller;

import DAO.DAOHistoriaclinica;
import TO.TOHistoriaclinica;
import java.util.ArrayList;

public class CtrlHistoriaclinica {
    
    DAOHistoriaclinica historiasclinicas;

    public CtrlHistoriaclinica() {
        historiasclinicas = new DAOHistoriaclinica();
    }
    
    
        public ArrayList<TOHistoriaclinica> consultarHistoriaclinica() {
        
            return historiasclinicas.consultarHistoriasclinicas();
          
    }
    
        public int insertarHistoriaclinica(TOHistoriaclinica historiaclinica) {
        
        return historiasclinicas.insertarHistoriasclinicas(historiaclinica);
        
    }
    
      public boolean modificarHistoriaclinica(TOHistoriaclinica historiaclinica) {
        return historiasclinicas.modificarHistoriasclinicas(historiaclinica);
          
      }
    
    public boolean eliminarHistoriaclinica (int id){
        return historiasclinicas.eliminarHistoriasclinicas(id);
        
    }
    
}