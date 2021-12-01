package be.intec.repositories.jdbc;


import be.intec.models.entities.Employee;
import be.intec.models.entities.IUser;
import be.intec.repositories.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJDBCRepository implements IUserRepository {

    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet results = null;


    private Connection getConnection() throws SQLException {

        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }


    public Boolean existsByExample(IUser user) throws SQLException {

        connection = getConnection();

        String query = "SELECT id, first_name, last_name, username, passcode, salary" +
                " FROM employee WHERE first_name LIKE ? OR last_name LIKE ? OR username = ?";

        // WE ARE BUILDING THE SQL QUERY
        statement = connection.prepareStatement(query);
        // INDEX FOR QUERY PARAMS START FROM 1 (ONE) NOT ZERO (0)
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getUsername());

        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }


    @Override
    public Long save(IUser userToCreate) throws SQLException {

        long lastSavedId = 0L;

        // IF_USER_DOES_NOT_EXIST
        Boolean exist = existsByExample(userToCreate);
        if (!exist) {

            connection = getConnection();

            // WE ARE BUILDING A QUERY WITH PARAMETERS
            // PARAMETER = VARIABLE
            String query = "INSERT INTO employee" +
                    " (first_name, last_name, username, passcode, salary)" +
                    " VALUES" +
                    " ( ?, ?, ?, ?, ? )";

            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userToCreate.getFirstName());
            statement.setString(2, userToCreate.getLastName());
            statement.setString(3, userToCreate.getUsername());
            statement.setString(4, userToCreate.getPassword());
            statement.setFloat(5, userToCreate.getSalary());

            // SAVE NEW RECORD
            int noOfRecordsCreated = statement.executeUpdate();

            if (noOfRecordsCreated > 0) {

                ResultSet generatedKeys = statement.getGeneratedKeys();
                lastSavedId = generatedKeys.getLong(1);

            }

        }

        return lastSavedId;

    }

    public Boolean existsById(Long id) throws SQLException {

        connection = getConnection();

        String query = "SELECT id, first_name, last_name, username, passcode, salary" +
                " FROM employee WHERE id=?";

        // WE ARE BUILDING THE SQL QUERY
        statement = connection.prepareStatement(query);
        // INDEX FOR QUERY PARAMS START FROM 1 (ONE) NOT ZERO (0)
        statement.setLong(1, id);


        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    @Override
    public Long update(IUser userToUpdate) throws SQLException {

        if (existsById(userToUpdate.getId())) {

            connection = getConnection();

            String query = "UPDATE employee SET  " +
                    "first_name=?, last_name=?, username=?, passcode=?, salary=? " +
                    "WHERE id=?";

            statement.setString(1, userToUpdate.getFirstName());
            statement.setString(2, userToUpdate.getLastName());
            statement.setString(3, userToUpdate.getUsername());
            statement.setString(4, userToUpdate.getPassword());
            statement.setFloat(5, userToUpdate.getSalary());
            statement.setLong(6, userToUpdate.getId());

            statement = connection.prepareStatement(query);

            int noOfRecordsUpdated = statement.executeUpdate();//aantal van records die updated

            if (noOfRecordsUpdated > 0) {
                return userToUpdate.getId();
            }
        }
        return 0L;
    }


    @Override
    public Long delete(IUser userToDelete) throws SQLException {

        connection = getConnection();
        String query = "DELETE FROM employee " +
                "WHERE first_name=? OR last_name=?OR username=?";
        statement.setString(1, userToDelete.getFirstName());
        statement.setString(2, userToDelete.getLastName());
        statement.setString(3, userToDelete.getUsername());

        statement = connection.prepareStatement(query);

        int noOfRecordsDeleted=statement.executeUpdate();

        return (long) noOfRecordsDeleted;
    }


    @Override
    public Boolean delete(Long id) throws SQLException {


        connection = getConnection();
        String query = "DELETE FROM employee WHERE id=?";
        statement.setLong(1, id);
        statement = connection.prepareStatement(query);
        int noOfRecordsDeleted=statement.executeUpdate();

        return (noOfRecordsDeleted>0);
    }


    @Override
    public List<IUser> findAll() throws SQLException {

        connection = getConnection();

        String query = "SELECT id, first_name, last_name, username, passcode, salary" +
                " FROM employee";

        ResultSet resultSet = statement.executeQuery(query);

        List<IUser> employeeList = new ArrayList<>();
        // there is no element

        while (resultSet.next()) {

            // MAKE A NEW INSTANCE OF Employee, then fill the information
            Employee employee = new Employee();
            employee.setId(resultSet.getLong("id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setUsername(resultSet.getString("username"));
            employee.setPassword(resultSet.getString("passcode"));
            employee.setSalary(resultSet.getFloat("salary"));


            // ADD THE NEW RECORD TO THE LIST
            employeeList.add(employee);

        }

        return employeeList;
    }


    @Override
    public List<IUser> search(String keyword) throws SQLException {
        connection = getConnection();

        String query = "SELECT id, first_name, last_name, username, passcode, salary" +
                " FROM employee WHERE first_name LIKE ? OR last_name = ? OR username = ?";

        statement.setString(1, keyword);
        statement.setString(2, keyword);
        statement.setString(3, keyword);

        ResultSet resultSet = statement.executeQuery(query);

        List<IUser> employeeList = new ArrayList<>();
        // there is no element

        while (resultSet.next()) {

            // MAKE A NEW INSTANCE OF Employee, then fill the information
            Employee employee = new Employee();
            employee.setId(resultSet.getLong("id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setUsername(resultSet.getString("username"));
            employee.setPassword(resultSet.getString("passcode"));
            employee.setSalary(resultSet.getFloat("salary"));


            // ADD THE NEW RECORD TO THE LIST
            employeeList.add(employee);

        }

        return employeeList;
    }


    @Override
    public IUser findById(Long id) throws SQLException {

        connection = getConnection();

        String query = "SELECT id, first_name, last_name, username, passcode, salary" +
                " FROM employee WHERE id = ?";

        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery(query);

        IUser employee = null;
        // there is no element

        while (resultSet.next()) {

            // MAKE A NEW INSTANCE OF Employee, then fill the information
            employee = new Employee();

            employee.setId(resultSet.getLong("id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setUsername(resultSet.getString("username"));
            employee.setPassword(resultSet.getString("passcode"));
            employee.setSalary(resultSet.getFloat("salary"));

        }

        return employee;
    }

}
