package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionPool {
    private static final int NUMBER_OF_CONNECTIONS = 10;
    public static ConnectionPool instance = null;
    private static Stack<Connection> Hiburim = new Stack();

    private ConnectionPool() {
        System.out.println("~~~~~~~~~~Connection Pool Created~~~~~~~~~~\n");

        try {
            this.OpenAllConnection();
        } catch (SQLException var2) {
            System.out.println(var2.getMessage());
        }

    }

    private void OpenAllConnection() throws SQLException {
        for(int counter = 0; counter < 10; ++counter) {
            Connection Hibur = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "12345678");
            Hiburim.push(Hibur);
        }

    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            Class var0 = ConnectionPool.class;
            synchronized(ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }

        return instance;
    }

    public void CloseAllConnections() throws InterruptedException {
        synchronized(Hiburim) {
            while(Hiburim.size() < 10) {
                Hiburim.wait();
            }

            Hiburim.removeAllElements();
        }
    }

    public Connection getConnection() throws InterruptedException {
        synchronized(Hiburim) {
            if (Hiburim.isEmpty()) {
                Hiburim.wait();
            }

            return (Connection)Hiburim.pop();
        }
    }

    public void ReturnConnection(Connection Hibur) {
        synchronized(Hiburim) {
            Hiburim.push(Hibur);
            Hiburim.notify();
        }
    }
}
