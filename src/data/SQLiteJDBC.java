package data;


import java.sql.*;
/**
 * Created by Vladimir on 26.11.2016.
 */

public class SQLiteJDBC {

/* База данных,построена на SQLite
    addUser -добавление пользователя
    getID - получить ид
    getName - получить имя
    getPassword  - получить пароль
    deleteUser - удалить юзера
    printAllList - список всех юзеров



    Как работает? Сложный вопрос,но главное что работает.В подробности прошу не вникать,тут Фродо нес кольцо,
     споткнулся об этот код и умер!
     **/



    public boolean isPresent(String user) {
        int id = -1;
        Connection c = null;

        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:datachat.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String strid = "SELECT * FROM CHAT where NAME='" + user + "';";
            ResultSet rs = stmt.executeQuery(strid);
            while (rs.next()) {
                id = rs.getInt("id");
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
if(id!=-1){return true;} else {return false;}
    }

    public void addUser(int id, String user, String password) {
        {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:datachat.db");
                c.setAutoCommit(false);

                String s = "VALUES (" + id + ",'" + user + "', '" + password + "');";
                System.out.println(s);

                stmt = c.createStatement();
                String sql = "INSERT INTO CHAT (ID,NAME,PASSWORD) " +
                        s;
                stmt.executeUpdate(sql);
                stmt.close();
                c.commit();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Records created successfully");
        }
    }


    public int getID(String user) {
        int id = -1;
        Connection c = null;

        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:datachat.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String strid = "SELECT * FROM CHAT where NAME='" + user + "';";
            ResultSet rs = stmt.executeQuery(strid);
            while (rs.next()) {
                id = rs.getInt("id");
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return id;
    }

    public String getName( int id) {
        String s = null;
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:datachat.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String strid = "SELECT * FROM CHAT where ID=" + id + ";";
            ResultSet rs = stmt.executeQuery(strid);
            while (rs.next()) {
                String name = rs.getString("name");
                s = name;

            }
            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return s;
    }


    public String getPassword(int id) {
        String s= null;
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:datachat.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String strid = "SELECT * FROM CHAT where ID=" + id + ";";
            ResultSet rs = stmt.executeQuery(strid);
            while (rs.next()) {
                String password = rs.getString("password");
                s = password;
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return s;
    }

    public void deleteUser(int ids) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:datachat.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String strid = "DELETE from CHAT where ID=" + ids + ";";
            stmt.executeUpdate(strid);
            c.commit();

            ResultSet rs = stmt.executeQuery("SELECT * FROM CHAT;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("PASSWORD = " + password);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public void printAllList() {

        {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:datachat.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM CHAT;");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");

                    String password = rs.getString("password");

                    System.out.println("ID = " + id);
                    System.out.println("NAME = " + name);
                    System.out.println("PASSWORD = " + password);
                    System.out.println();
                }
                rs.close();
                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Operation done successfully");
        }
    }
}

