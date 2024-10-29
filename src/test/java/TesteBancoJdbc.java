import conexaojdbc.SingleConnection;
import dao.UserPosDao;
import junit.framework.TestCase;
import model.UserPosJava;
import org.junit.Test;

import java.util.List;


public class TesteBancoJdbc{

   /* @Test
    public void initBanco(){
        UserPosDao usderPosDao = new UserPosDao();
        UserPosJava userPosJava = new UserPosJava();

        userPosJava.setId(6L);
        userPosJava.setNome("Fulaninho");
        userPosJava.setEmail("emaildofulano@seuprovedor.com");

        usderPosDao.salvar(userPosJava);

    }*/

    @Test
    public void initListar(){
        UserPosDao dao = new UserPosDao();

        try {
            List<UserPosJava> list = dao.listar();

            for(UserPosJava userPosJava : list){
                System.out.println(userPosJava);
                System.out.println("_________________________________________________________________");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
