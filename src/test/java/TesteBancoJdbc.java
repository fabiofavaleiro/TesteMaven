import conexaojdbc.SingleConnection;
import dao.UserPosDao;
import junit.framework.TestCase;
import model.BeanUserFone;
import model.Telefone;
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
            dao.deletar(3L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void initInsertTelefone(){
        Telefone telefone = new Telefone();

        telefone.setNumero("(67) 3596-6733");
        telefone.setTipo("Casa");
        telefone.setUsuario(3L);

        UserPosDao dao = new UserPosDao();
        dao.salvarTelefone(telefone);

    }

    @Test
    public void  cargaFoneUser(){
        UserPosDao dao = new UserPosDao();

        List<BeanUserFone> beanUserFones = dao.listaUserFone(1L);

        for (BeanUserFone beanUserFone : beanUserFones){
            System.out.println(beanUserFone);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

        }


    }

    @Test
    public void deleteUserFone(){
        UserPosDao dao = new UserPosDao();
        dao.deleteFonesPorUser(3L);

    }
}
