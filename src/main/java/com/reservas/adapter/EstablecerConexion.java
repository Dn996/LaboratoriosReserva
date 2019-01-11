package com.reservas.adapter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Dayana
 */
public class EstablecerConexion {
      public  Connection con;
    public Connection getConnection() {
         String sURL = "jdbc:mysql://localhost:3306/reserva_lab?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            con = DriverManager.getConnection(sURL, "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public void CerrarConexion() throws SQLException{
       if (con != null) {
            con.close();
        }
    }
}
