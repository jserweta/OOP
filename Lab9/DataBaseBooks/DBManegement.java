import java.sql.*;

public class DBManegement {

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;


    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/serweta",
                            "serweta","hZCqdxhqM6nUJznQ");



        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){e.printStackTrace();}
    }

    public void selectAll(){
        try {
            connect();
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = stmt.executeQuery("SELECT * FROM books");
            boolean ifExists = false;
            while(rs.next()){
                ifExists = true;
                String isbn = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String date = rs.getString(4);
                System.out.println(isbn + " | " + title + " | " + author + " | " + date);
            }

            if(ifExists == false){
                System.out.println("Żadna książka nie pasuje do podanych kryteriów!");
            }
        }catch (SQLException ex){
            // handle any errors

        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
    }

    public void selectByAuthor(String author){
        try {
            connect();
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = stmt.executeQuery("SELECT * FROM books WHERE author like '" + author + "'");

            boolean ifExists = false;

            while(rs.next()){
                ifExists = true;
                String isbn = rs.getString(1);
                String title = rs.getString(2);
                String date = rs.getString(4);
                System.out.println(isbn + " | " + title + " | " + author + " | " + date);
            }

            if(ifExists == false){
                System.out.println("Żadna książka nie pasuje do podanych kryteriów!");
            }

        }catch (SQLException ex){
            // handle any errors

        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
    }

    public void selectByIsbn(String isbn){
        try {
            connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books WHERE isbn like '" + isbn +"'");

            boolean ifExists = false;

            while(rs.next()){
                ifExists = true;
                String title = rs.getString(2);
                String author = rs.getString(3);
                String date = rs.getString(4);
                System.out.println(isbn + " | " + title + " | " + author + " | " + date);
            }

            if(ifExists == false){
                System.out.println("Żadna książka nie pasuje do podanych kryteriów!");
            }


        }catch (SQLException ex){
            // handle any errors

        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
    }
    public boolean selectIsbn(String isbn) throws SQLException {
            connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT isbn FROM books WHERE isbn like '" + isbn +"'");

            boolean ifExists = false;

            if(rs.next()){
                ifExists = true;
            }

            return ifExists;

    }

    public void selectByAuthorSurname(String surname){
        try {
            connect();
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = stmt.executeQuery("SELECT * FROM books WHERE author similar to '% " + surname + "'");

            boolean ifExists = false;

            while(rs.next()){
                ifExists = true;
                String isbn = rs.getString(1);
                String title = rs.getString(2);
                String name = rs.getString(3);
                String date = rs.getString(4);
                System.out.println(isbn + " | " + title + " | " + name + " | " + date);
            }

            if(ifExists == false){
                System.out.println("Żadna książka nie pasuje do podanych kryteriów!");
            }

        }catch (SQLException ex){
            // handle any errors

        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
    }

    public void addNewBook(String isbn, String author, String title, String date){

        try {
            connect();
            stmt = conn.createStatement();
            stmt.executeUpdate(
                    "INSERT INTO books "
                            + "values ('"+ isbn +"','"+ title +"','"+ author +"','"+ date+" ')");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }

    }
}
