package br.com.ListadTarefas.Dao;

import br.com.ListadTarefas.Model.TarefasModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TarefasDao {

    public void createTarefas(TarefasModel tarefamodel){
        String SQL = "INSERT INTO TASK (NAMETASK,STATUSTASK) VALUES (?,?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, tarefamodel.getNametask());
            preparedStatement.setString(2,tarefamodel.getStatusTask());

            preparedStatement.execute();

            connection.close();


        }catch (Exception e){
            System.out.println("ERRO"+e.getMessage());
        }

    }

    public List<TarefasModel> read(){
        String SQL = "SELECT * FROM TASK";
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<TarefasModel> tarefas = new ArrayList<>();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("nametask");
                String status = resultSet.getString("statustask");
                TarefasModel tarefa = new TarefasModel(id,name,status);
                tarefas.add(tarefa);
            }
            connection.close();
            return tarefas;

        }catch (Exception e){
            System.out.println("ERROR"+e.getMessage());
            return Collections.emptyList();
        }
    }

    public void deleteById(String id){
        String SQL = "DELETE TASK WHERE ID = ?";
        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1,id);
            preparedStatement.execute();
            connection.close();

        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void updateTarefas(TarefasModel task){
        String sql = "UPDATE TASK SET NAMETASK = ? , STATUSTASK = ? WHERE ID = ? ";

        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, task.getNametask());
            preparedStatement.setString(2, task.getStatusTask());
            preparedStatement.setString(3, task.getId());
            preparedStatement.execute();
            connection.close();

        }catch (Exception e){
            System.out.println("ERROR:"+e.getMessage());
        }
    }
}
