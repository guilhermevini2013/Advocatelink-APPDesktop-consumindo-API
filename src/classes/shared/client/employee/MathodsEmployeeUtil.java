package classes.shared.client.employee;

import classes.interfaces.ObjectMethods;
import classes.models.Employee;

import java.util.ArrayList;
import java.util.List;

public abstract class MathodsEmployeeUtil implements ObjectMethods<Employee> {
    public static List<Employee> employeeslList = new ArrayList<>();

    //Pega Referencia
    @Override
    public Employee search(Employee tempEmployee) throws NullPointerException {

        for (Employee employee:employeeslList) {
            if (employee.getNome().equals(tempEmployee.getNome())){
                return employee;
            }
        }
        throw new NullPointerException();
    }
    //DELETA O FUNCIONARIO
    @Override
    public Employee delete(Employee tempEmployee)throws NullPointerException {
        for (Employee employee:employeeslList){
            if (employee.getNome().equals(tempEmployee.getNome())){
                employeeslList.remove(tempEmployee.getIdEmployee());
                return null;
            }
        }
        throw new NullPointerException();
    }
    // ALTERA AS INFORMACOES DO FUNCIONARIO
    @Override
    public Employee alter(Employee tempEmployee) throws NullPointerException {
        for (Employee employee:employeeslList){
            if (employee.getNome().equals(tempEmployee.getNome())){
                employee.setNome(tempEmployee.getNome());
                employee.setContato(tempEmployee.getContato());
                employee.setEndereco(tempEmployee.getEndereco());
                employee.setSalary(tempEmployee.getSalary());
                employee.setCpf(tempEmployee.getCpf());
                employee.setRole(tempEmployee.getRole());
                employee.setUrlfoto(tempEmployee.getUrlfoto());
                return null;
            }
        }
        throw new NullPointerException();
    }
}