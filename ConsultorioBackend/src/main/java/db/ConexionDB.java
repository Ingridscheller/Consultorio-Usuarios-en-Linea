package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {

    private String DB_driver;
    private String url;
    private String db;
    private String host;
    private String username;
    private String password;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public ConexionDB() {
        DB_driver = "com.mysql.jdbc.Driver";
        db = "consultorio en linea";
        host = "localhost:3306";
        username = "root";
        password = "R1nr1nr3nacuajo*";
        url = "jdbc:mysql://" + host + "/" + db;
        ArrayList<String> columnas = new ArrayList<>();

        try {
            Class.forName(DB_driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(url, username, password);
            con.setTransactionIsolation(8);
            System.out.println("BD conectada");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getconnection() {
        try {
            con.setAutoCommit(true);
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public boolean commitDB() {
        try {
            con.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean rollbackDB() {
        try {
            con.rollback();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ResultSet consultar(String nombreTabla) {
        String query = " SELECT * FROM " + nombreTabla;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<String> getColumns(String nombreTabla) {
        String query = " SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = '" + db + "' AND TABLE_NAME = '" + nombreTabla + "' order by ORDINAL_POSITION'";
        ArrayList<String> columnas = new ArrayList<>();
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (!rs.getString("COLUMN_NAME").equals("id" + nombreTabla)) {
                    columnas.add(rs.getString("COLUMN_NAME"));
                }
            }
            return columnas;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ResultSet consultarXId(String nombreTabla, int id) {
        String query = " SELECT * FROM " + nombreTabla + "WHERE id" + nombreTabla + "=" + id;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);

            return null;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);

            return null;
        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);

            return null;
        }
    }

    public ResultSet consultarWhere(String nombreTabla, String condiciones) {
        String query = " SELECT * FROM " + nombreTabla + "WHERE " + condiciones;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);

            return null;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);

            return null;
        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);

            return null;
        }
    }

    public int insertar(String nombreTabla, String[] valores) {
        StringBuilder query = new StringBuilder("INSERT INTO ");
        query.append(nombreTabla);
        query.append("(");
        ArrayList<String> columnas = getColumns(nombreTabla);
        for (int i = 0; i < columnas.size(); i++) {
            query.append(columnas.get(i));
            if (i != (columnas.size() - 1)) {
                query.append(",");
            }
        }
        query.append(") VALUES (");
        for (int i = 0; i < valores.length; i++) {
            query.append("´");
            query.append(valores[i]);
            query.append("´");
            if (i != (valores.length - 1)) {
                query.append("´");
            }
            query.append(",");

        }

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query.toString());
            return rs.getInt("id" + nombreTabla);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);

            return 0;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);

            return 0;
        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);

            return 0;
        }

    }

    public boolean actualizar(String nombreTabla, String[] valores, int id) {
        ArrayList<String> columnas = getColumns(nombreTabla);
        StringBuilder query = new StringBuilder("UPDATE ");
        query.append(nombreTabla);
        query.append("SET");
        for (int i = 0; i < valores.length; i++) {
            query.append(columnas.get(i));
            query.append(" = ");
            query.append("'");
            query.append(valores[i]);
            query.append("'");
            if (i != (valores.length - 1)) {
                query.append(",");
            }
            query.append("WHERE id");
            query.append(nombreTabla);
            query.append(" = ");
            query.append(id);

        }
        try {
            stmt = con.createStatement();
            return stmt.execute(query.toString());

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);

            return false;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);

            return false;
        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public boolean eliminar(String nombreTabla, int id) {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        query.append(nombreTabla);
        query.append("WHERE id");
        query.append(nombreTabla);
        query.append(" = ");
        query.append(id);
        try {
            stmt = con.createStatement();
            return stmt.execute(query.toString());

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);

            return false;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);

            return false;
        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class
                    .getName()).log(Level.SEVERE, null, ex);

            return false;
        }

    }

    public int actualizar(String nombreTabla, String[] valores) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}