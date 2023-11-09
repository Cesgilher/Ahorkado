import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbContext {

    String url ="jdbc:mysql://db-mysql-nyc3-54987-do-user-14007546-0.c.db.ondigitalocean.com:25060/Cesar-Jagoba" ;
    String user ="doadmin";
    String psswd ="AVNS_K-bOyIRFDWCp-Tv6-96" ;

    public ArrayList<Word> GetAllWords(){

        ArrayList<Word> storedWords = new ArrayList<>();


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,psswd);

            String query = "SELECT * FROM Words";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Word word = new Word(resultSet.getString("value"),resultSet.getInt("level"));
                storedWords.add(word);
            }
            resultSet.close();
            statement.close();
            connection.close();

        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return storedWords;


    }
}
