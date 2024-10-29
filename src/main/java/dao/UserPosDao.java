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
            String sql = "insert into userposjava (id, nome, email) values (?,?,?)";
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setLong(1, userPosJava.getId());
            insert.setString(2,userPosJava.getNome());
            insert.setString(3,userPosJava.getEmail());
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



}
