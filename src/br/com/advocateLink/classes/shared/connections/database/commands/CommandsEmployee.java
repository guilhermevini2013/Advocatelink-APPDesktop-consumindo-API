package br.com.advocateLink.classes.shared.connections.database.commands;

import br.com.advocateLink.classes.interfaces.IDatabase;
import br.com.advocateLink.classes.models.Employee;
import br.com.advocateLink.classes.shared.connections.database.ConnectionDataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandsEmployee extends ConnectionDataBase implements IDatabase<Employee> {
    private final String deletePerson ="DELETE FROM advocatelink.person WHERE id = ?;";
    private final String deleteAddress ="DELETE FROM advocatelink.address WHERE id_person = ?;";
    private final String deleteContact ="DELETE FROM advocatelink.contact WHERE id = ?;";
    private final String selectQuery = "SELECT * FROM person WHERE id = ?";
    private final String updateUrl="UPDATE person SET name = ?,cpf = ?,urlphoto = ?,salary = ?,role = ?,oab = ? WHERE id = ? ;";
    private final String insertPerson="INSERT INTO advocatelink.person(name,cpf,urlphoto,salary,role) VALUE (?,?,?,?,?);";
    private final String insertAddress="INSERT INTO advocatelink.address(rua,number,bairro,id_person) VALUE (?,?,?,?);";
    private final String insertContact="INSERT INTO advocatelink.contact(telephone,email,id_person) VALUE (?,?,?);";
    PreparedStatement PREPARED_STATEMENT;
    @Override
    public Boolean deleteRow(Employee employee) throws SQLException {
        PREPARED_STATEMENT = super.connectionDB().prepareStatement(deleteAddress);
        PREPARED_STATEMENT.setLong(1,employee.getId());
        PREPARED_STATEMENT.executeUpdate();
        PREPARED_STATEMENT = super.getConnection().prepareStatement(deleteContact);
        PREPARED_STATEMENT.setLong(1,employee.getId());
        PREPARED_STATEMENT.executeUpdate();
        PREPARED_STATEMENT = super.getConnection().prepareStatement(deletePerson);
        PREPARED_STATEMENT.setLong(1,employee.getId());
        PREPARED_STATEMENT.executeUpdate();
        super.closeDB();
        return true;
    }

    @Override
    public Boolean searchRow(Employee employee) {
        return null;
    }

    @Override
    public Boolean updateRow(Employee employee) {
        return null;
    }

    @Override
    public Boolean insertRow(Employee employee) throws SQLException {
        PREPARED_STATEMENT = super.connectionDB().prepareStatement(insertPerson,Statement.RETURN_GENERATED_KEYS);
        PREPARED_STATEMENT.setString(1,employee.getNome());
        PREPARED_STATEMENT.setString(2,employee.getCpf());
        PREPARED_STATEMENT.setString(3,employee.getUrlfoto());
        PREPARED_STATEMENT.setDouble(4,employee.getSalary());
        PREPARED_STATEMENT.setString(5,employee.getRole());
        PREPARED_STATEMENT.executeUpdate();
        ResultSet generatedKeys = PREPARED_STATEMENT.getGeneratedKeys();
        Long key = -1l;
        if (generatedKeys.next()) {
            key = generatedKeys.getLong(1);
            PREPARED_STATEMENT = super.getConnection().prepareStatement(insertAddress);
            PREPARED_STATEMENT.setString(1, employee.getEndereco().getRua());
            PREPARED_STATEMENT.setInt(2, employee.getEndereco().getNumero());
            PREPARED_STATEMENT.setString(3, employee.getEndereco().getBairro());
            PREPARED_STATEMENT.setLong(4,key);
            PREPARED_STATEMENT.execute();
            PREPARED_STATEMENT = super.getConnection().prepareStatement(insertContact);
            PREPARED_STATEMENT.setLong(1, employee.getContato().getTelefone());
            PREPARED_STATEMENT.setString(2, employee.getContato().getEmail());
            PREPARED_STATEMENT.setLong(3,key);
            PREPARED_STATEMENT.execute();
        }
        return true;
    }
}