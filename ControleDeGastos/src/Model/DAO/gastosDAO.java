/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Connection.ConnectionFactory;
import Model.bean.Gastos;
//import java.awt.List;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PTBR05
 */
public class gastosDAO {
    
    public void create(Gastos i){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt= null;
        
            try {
                stmt = con.prepareStatement("INSERT into gastos (data, lugar, valor) VALUES (?, ? ,?)");
                stmt.setString(1, i.getData());
                stmt.setString(2, i.getLugar());
                stmt.setFloat(3, i.getValor());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
    
    }
    
   public List<Gastos> read(){
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt= null;
        ResultSet rs = null;
        
        List<Gastos> Gastos = new ArrayList();
                    try {
                stmt = con.prepareStatement("SELECT * FROM gastos");
         
                rs = stmt.executeQuery();
                
                while(rs.next()){
                        Gastos gastos = new Gastos();
                        
                        gastos.setData(rs.getString("data"));
                        gastos.setLugar(rs.getString("lugar"));
                        gastos.setValor(rs.getFloat("valor"));
                        
                    //listaFilmes.add(new Filmes(id, titulo, autor, preco, ano, genero, data, alugado));
                    Gastos.add(gastos);
                    }
                
                
            } catch (SQLException ex) {
                
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
                    return Gastos;
    }
   
       public void delete(Gastos i){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt= null;
        
            try {
                stmt = con.prepareStatement("DELETE FROM gastos WHERE lugar = ?");
                stmt.setString(1, i.getLugar());
  
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Gasto deletado!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir"+ex);
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
    
    }
    
}