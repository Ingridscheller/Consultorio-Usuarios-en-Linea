package controller;

import DAO.DAOAgendamedicos;
import TO.TOAgendamedicos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CtrlAgendamedicos {
     DAOAgendamedicos agendamedicosDAO;

    public CtrlAgendamedicos() {
        agendamedicosDAO = new DAOAgendamedicos();
    }
    
    
        public ArrayList<TOAgendamedicos> consultarAgenda() {
        
            return agendamedicosDAO.consultarAgenda();
          
    }
    
        public int insertarAgendaMedicos(TOAgendamedicos agendamedicos) {
        
        return agendamedicosDAO.insertarAgendamedicos(agendamedicos);
        
    }
    
      public boolean modificarAgendamedicos(TOAgendamedicos agendamedicos) {
        return agendamedicosDAO.modificarAgendamedicos(agendamedicos);
          
      }
    
    public boolean eliminarAgendamedicos (int id){
        return agendamedicosDAO.eliminarAgendamedicos(id);
        
    }
    
}

    

