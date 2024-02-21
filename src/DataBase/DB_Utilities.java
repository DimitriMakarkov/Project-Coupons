package DataBase;

import SQL_Commands.DB_TableCreation;

import java.sql.*;
import java.util.Map;

public class DB_Utilities {
    public DB_Utilities() {
    }

    public static boolean RunCommand(String UserCommand) {
        Connection Hibur = null;

        try {
            Hibur = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = Hibur.prepareStatement(UserCommand);
            preparedStatement.execute();
            return true;
        } catch (InterruptedException | SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConnectionPool.getInstance().ReturnConnection(Hibur);
        }


    }


    public static boolean RunCommand(String UserCommand, Map<Integer, Object> Units) {
        Connection Hibur = null;
        try {
            Hibur = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = Hibur.prepareStatement(UserCommand);
            Units.forEach((key, value) -> {
                try {
                    if (value instanceof Integer) {
                        preparedStatement.setInt(key, (Integer) value);
                    } else if (value instanceof String) {
                        preparedStatement.setString(key, String.valueOf(value));
                    } else if (value instanceof Date) {
                        preparedStatement.setDate(key, (Date) value);
                    } else if (value instanceof Double) {
                        preparedStatement.setDouble(key, (Double) value);
                    } else if (value instanceof Boolean) {
                        preparedStatement.setBoolean(key, (Boolean) value);
                    } else if (value instanceof Float) {
                        preparedStatement.setFloat(key, (Float) value);
                    }

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            preparedStatement.execute();
            return true;
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConnectionPool.getInstance().ReturnConnection(Hibur);
        }
    }

    public static ResultSet RunCommandFromResult(String UserCommand) {
        Connection Hibur = null;

        try {
            Hibur = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = Hibur.prepareStatement(UserCommand);
            return preparedStatement.executeQuery();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet RunCommandWithParameter(String UserCommand, Object Parameter) {
        Connection Hibur = null;

        try {
            Hibur = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = Hibur.prepareStatement(UserCommand);
            preparedStatement.setObject(1, Parameter);
            return preparedStatement.executeQuery();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet RunCommandWithResult(String UserCommand, Map<Integer, Object> params) {
        Connection Hibur = null;
        try {
            Hibur = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = Hibur.prepareStatement(UserCommand);
            params.forEach((key, value) -> {
                try {
                    if (value instanceof Integer) {
                        preparedStatement.setInt(key, (Integer) value);
                    } else if (value instanceof String) {
                        preparedStatement.setString(key, String.valueOf(value));
                    } else if (value instanceof Date) {
                        preparedStatement.setDate(key, (Date) value);
                    } else if (value instanceof Double) {
                        preparedStatement.setDouble(key, (Double) value);
                    } else if (value instanceof Boolean) {
                        preparedStatement.setBoolean(key, (Boolean) value);
                    } else if (value instanceof Float) {
                        preparedStatement.setFloat(key, (Float) value);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            return preparedStatement.executeQuery();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
