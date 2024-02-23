/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

    import conexao.Conexao;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;

/**
 *
 * @author User
 */

    import model.Bicicleta;
    import conexao.Conexao;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;

public class Dao {

    public Dao() {
    }
    
    //GRAVAR
    //====================================
    public boolean grava(Bicicleta bicicleta) {
        try {
            PreparedStatement comandoSQL;
            comandoSQL = Conexao.getInstance().prepareStatement(
            "insert into Bicicleta(Id, freio, tipo, estoque,aro) values( ?,  ?,  ?,  ?, ?)");
            comandoSQL.setInt(1, bicicleta.getId());
            comandoSQL.setString(2,bicicleta.getFreio());
            comandoSQL.setString(3, bicicleta.getTipo());
            comandoSQL.setInt(4, bicicleta.getEstoque());
            comandoSQL.setInt(5,bicicleta.getAro());
            comandoSQL.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //ALTERAR
    //====================================
    public boolean atualiza(Bicicleta bicicleta) {
        try {
            PreparedStatement comandoSQL;
            //obs: feita alteração com relação ao documento para que então sejam alterados todos os valores
            comandoSQL = Conexao.getInstance().prepareStatement(
            "update Pessoa set nome =  ?, email = ?, telefone = ? where  id =  ? ");
            comandoSQL.setInt(1, bicicleta.getId());
            comandoSQL.setString(2, bicicleta.getFreio());
            comandoSQL.setString(3, bicicleta.getTipo());
            comandoSQL.setInt(4, bicicleta.getId());
            comandoSQL.execute();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;
    }
    
    //DELETAR
    //=====================================
    public boolean deleta(Bicicleta bicicleta) {
        try {
            PreparedStatement comandoSQL;
            comandoSQL = Conexao.getInstance().prepareStatement(
            "delete from Pessoa where id =  ?");
            comandoSQL.setLong(1, bicicleta.getId());
            comandoSQL.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //LISTAR TODOS
    //=====================================
    public ArrayList lista() {
        try {
            PreparedStatement comandoSQL;
            comandoSQL = Conexao.getInstance().prepareStatement("select * from Bicicleta");
            ResultSet rs = comandoSQL.executeQuery();
            ArrayList arlBicicleta = new ArrayList();
            while (rs.next()) {
                Bicicleta bike = new Bicicleta();
                bike.setId(rs.getInt("id"));
                bike.setFreio(rs.getString("freio"));
                bike.setTipo(rs.getString("Tipo"));
                bike.setEstoque(rs.getInt("estoque"));
                bike.setAro(rs.getInt("Aro"));
                arlBicicleta.add(bike);
            }
            return arlBicicleta;
            // conexao.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
//CONSULTA ESPECIFICA POR CAMPOS
//=====================================
    public Bicicleta consulta(int pk) {
        try {
            PreparedStatement comandoSQL;
            comandoSQL = Conexao.getInstance().prepareStatement("select * from Bicicleta where id=?");
            comandoSQL.setInt(1, pk);
            ResultSet rs = comandoSQL.executeQuery();
            if (rs.next()) {
                Bicicleta bike = new Bicicleta();
                bike.setId(rs.getInt("id"));
                bike.setFreio(rs.getString("freio"));
                bike.setTipo(rs.getString("tipo"));
                bike.setEstoque(rs.getInt("estoque"));
                return bike;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

