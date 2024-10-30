import conexaojdbc.SingleConnection;
import dao.UserPosDao;
import junit.framework.TestCase;
import model.UserPosJava;
import org.junit.Test;

import java.util.List;


public class TesteBancoJdbc{

    @Test
    public void initBanco(){
        UserPosDao usderPosDao = new UserPosDao();
        UserPosJava userPosJava = new UserPosJava();


        userPosJava.setNome("Fulaninho");
        userPosJava.setEmail("emaildofulano@seuprovedor.com");

        usderPosDao.salvar(userPosJava);

    }

    @Test
    public void initListar(){
        UserPosDao dao = new UserPosDao();

        try {
            List<UserPosJava> list = dao.listar();

            for(UserPosJava userPosJava : list){
                System.out.println(userPosJava);
                System.out.println("__________________________________________________________________________________");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void initBuscar(){
        UserPosDao dao = new UserPosDao();

        try {
            UserPosJava userPosJava = dao.buscar(6L);
            System.out.println(userPosJava);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void initAtualizar(){

        try {

            UserPosDao dao = new UserPosDao();

            UserPosJava objetoBanco = dao.buscar(9L);



            objetoBanco.setNome("Nome mudado com metodo atualizar");

            dao.atualizar(objetoBanco);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void initDeletar(){
        try{


            UserPosDao dao = new UserPosDao();
            dao.deletar(5L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
