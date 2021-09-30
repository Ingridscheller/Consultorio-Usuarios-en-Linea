package controller;

import DAO.DAOUsuarios;
import TO.TOUsuarios;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CtrlUsuarios {
    
    DAOUsuarios usuariosDAO;

    public CtrlUsuarios() {
        usuariosDAO = new DAOUsuarios();
    }
    
    
        public ArrayList<TOUsuarios> consultarUsuarios() {
        
            return usuariosDAO.consultarUsuarios();
          
    }
    
        public int insertarUsuarios(TOUsuarios usuario) {
        
        return usuariosDAO.insertarUsuarios(usuario);
        
    }
    
      public boolean modificarUsuarios(TOUsuarios usuario) {
        return usuariosDAO.modificarUsuarios(usuario);
          
      }
    
    public boolean eliminarUsuarios (int id){
        return usuariosDAO.eliminarUsuarios(id);
        
    }
    
}
