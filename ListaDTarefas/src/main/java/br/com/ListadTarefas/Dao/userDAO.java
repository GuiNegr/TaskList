package br.com.ListadTarefas.Dao;


import br.com.ListadTarefas.Model.UserModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class userDAO {

    public void CreateUser(UserModel userModel){
        String SQL = "INSERT INTO userTAREFAS (user_email , user_senha,username)values(?,?,?)";
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1,userModel.getUserEmail());
            preparedStatement.setString(2,userModel.getUserPass());
            preparedStatement.setString(3,userModel.getUserName());
            preparedStatement.execute();
            connection.close();
            System.out.println("cadastro concluido");
        }catch (Exception e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    public boolean check(UserModel userModel){
        String sql = "SELECT * FROM USERTAREFAS";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();
            List<UserModel> users = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getNString("ID");
                String userEmail = resultSet.getNString("USER_EMAIL");
                String userPass = resultSet.getNString("USER_SENHA");
                String username = resultSet.getNString("username");
                UserModel user = new UserModel(id,username,userEmail,userPass);
                users.add(user);
            }

            List<String> emails = emailsinbd();
            List<String> pass = passInBd();

            if(emails.contains(userModel.getUserEmail())){
                int pos = emails.indexOf(userModel.getUserEmail());
                String senha = pass.get(pos);
                    if (senha.equals(userModel.getUserPass())){
                        return true;
                    }else {
                        return false;
                    }
            }else {
                return false;
            }
        }catch (Exception e){
            System.out.println("error: "+e.getMessage());
            return false;
        }
    }
    public List<String> emailsinbd(){
        String sql = "SELECT * FROM USERTAREFAS";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> usersEmails = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getNString("ID");
                String userEmail = resultSet.getNString("USER_EMAIL");
                String userPass = resultSet.getNString("USER_SENHA");
                String username = resultSet.getNString("username");
                UserModel user = new UserModel(id,username,userEmail,userPass);
                usersEmails.add(user.getUserEmail());
            }
        return usersEmails;
        }
        catch(Exception e){
            System.out.println("ERRO: "+e.getMessage());
            return null;
        }
    }

    public List<String> passInBd(){
        String sql = "SELECT * FROM USERTAREFAS";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> usersEmails = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getNString("ID");
                String userEmail = resultSet.getNString("USER_EMAIL");
                String userPass = resultSet.getNString("USER_SENHA");
                String username = resultSet.getNString("username");
                UserModel user = new UserModel(id,username,userEmail,userPass);
                usersEmails.add(user.getUserPass());
            }
            return usersEmails;
        }
        catch(Exception e){
            System.out.println("ERRO: "+e.getMessage());
            return null;
        }
    }
}
