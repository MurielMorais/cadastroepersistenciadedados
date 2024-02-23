package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
    // atributos

    private static Connection conexao = null;
//esta   a vari vel fonte recebe o mesmo nome da base de dados
//criada no postgresql
    private String fonte = "MiniCurso";
//Conexao Para a Base de Dados do PostgresSQL utilizando JDBC

    private Conexao() {

        try {
            //Driver para fazer conexao com um Banco postgresql
            Class.forName("org.postgresql.Driver");
            //comando para fazer conexao via JDBC com um banco postgresql
            //sendo informado o servidor e sua porta, no caso localhost na porta 5432
            // + o nome da base de dados, o usuario e a senha.
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost/"
                    + fonte, "postgres", "38knit12");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro de class n o encontrada!!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro na conexao com o banco de dados !!!");
        }
    }

    public static Connection getInstance() {
        if (conexao == null) {
            new Conexao();
        }
        return conexao;
    }
}
