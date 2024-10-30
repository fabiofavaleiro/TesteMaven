package dao;

import conexaojdbc.SingleConnection;
import model.UserPosJava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserPosDao {

    private Connection connection;

    public UserPosDao() {
        connection = SingleConnection.getConnection();
    }

    public void salvar(UserPosJava userPosJava){

        try {
            String sql = "insert into userposjava (nome, email) values (?,?)";
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1,userPosJava.getNome());
            insert.setString(2,userPosJava.getEmail());
            insert.execute();
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public List<UserPosJava> listar() throws Exception{
        List<UserPosJava> list = new ArrayList<UserPosJava>();

        String sql = "select * from userposjava";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();

        while (resultado.next()){
            UserPosJava userPosJava = new UserPosJava();
            userPosJava.setId(resultado.getLong("id"));
            userPosJava.setNome(resultado.getString("nome"));
            userPosJava.setEmail(resultado.getString("email"));
            list.add(userPosJava);
        }

        return list;
    }

    public UserPosJava buscar(Long id) throws Exception{
        UserPosJava userPosJava1 = new UserPosJava();

        String sql = "select * from userposjava where id = " + id;

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();

        while (resultado.next()){

            userPosJava1.setId(resultado.getLong("id"));
            userPosJava1.setNome(resultado.getString("nome"));
            userPosJava1.setEmail(resultado.getString("email"));

        }

        return userPosJava1;
    }

    public void atualizar (UserPosJava userPosJava){
        try {
            String sql = "update userposjava set nome = ? where id = " + userPosJava.getId();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userPosJava.getNome());

            statement.execute();
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
            e.printStackTrace();
        }


    }

    public void deletar(Long id){
        try{

            String sql = "delete from userposjava where id = " +id;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            connection.commit();

        } catch (SQLException e) {

            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        }

    }

}
