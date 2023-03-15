import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        final String URL = "Jdbc:mysql://localhost:3306/evento";
        final String USER = "root";
        final String PASSAWORD = "root";
        final String CONSULTA="select * from eventosgeek";


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL,USER,PASSAWORD);
            System.out.println("Connectado");

            Statement st = con.createStatement();
            System.out.println("Stratement criado");


            String query= "insert into EventosGeek(nomes,lugar,dia,participantes) values (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(query);

            String nomes= JOptionPane.showInputDialog("Digite o nome do evento");
            String lugar= JOptionPane.showInputDialog("Insira o local do evento");
            String dia = JOptionPane.showInputDialog("Insira a data do evento");
            String participantes = JOptionPane.showInputDialog("Insira o numero de participantes do evento ");

            stmt.setString(1,nomes);
            stmt.setString(2,lugar);
            stmt.setString(3,dia);
            stmt.setString(4,participantes);

            int LinhaAfetadas = stmt.executeUpdate();
            System.out.println("Dados inseridos");

            ResultSet resultSet= stmt.executeQuery(CONSULTA);

            while (resultSet.next()){
                System.out.println(resultSet.getString("nomes"));
                System.out.println(resultSet.getString("lugar"));
                System.out.println(resultSet.getString("dia"));
                System.out.println(resultSet.getString("participantes"));
            }



        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }




    }
}