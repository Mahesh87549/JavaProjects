package com.payrollSystem;

import java.util.ArrayList;

abstract class Employee{
	
	private String name;
	private int id;
	
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return id;
	}
	
	public abstract double calculateSalry();
	
	@Override
	public String toString() {
		return "Employee[name="+name+",id= "+id+" "+" slary= "+calculateSalry()+"]";
		
	}
}


class FullTimeEmployee extends Employee{
	private double monthlySalary;
	
	
	public FullTimeEmployee(String name, int id, double monthlySalary) {
		super(name, id);
		this.monthlySalary = monthlySalary;
	}


	@Override
	public double calculateSalry() {
				return monthlySalary;
	}
	
}

class PartTimeEmployee extends Employee{
	
	private int hoursWorked;
	private double hourlyRate;
	
	public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
		super(name, id);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	@Override
	public double calculateSalry() {
		return hourlyRate* hoursWorked;
	}
}

class PayrollSystem{
	
	private ArrayList<Employee> employeeList;
	
	public PayrollSystem() {
		employeeList = new ArrayList<Employee>();
	}
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	public void removeEmployee(int id) {
		Employee employeeToRemove = null;
		for(Employee emp:employeeList) {
			if(emp.getID()==id) {
				employeeToRemove = emp;
				break;
			}
		}
		if(employeeToRemove!=null) {
			employeeList.remove(employeeToRemove);
		}
	}
	
	public void displayEmployee() {
		for(Employee emp:employeeList) {
			System.out.println(emp);
		}
	}
	
}


public class Main {

	public static void main(String[] args) {
		FullTimeEmployee  emp1 = new FullTimeEmployee("Mahesh", 1, 40000.00);
		PartTimeEmployee emp2 = new PartTimeEmployee("Mahesh2", 2, 4, 450.00);
		PayrollSystem payrollSystem = new PayrollSystem();
		System.out.println("Initial Employee Details");
		payrollSystem.addEmployee(emp2);
		payrollSystem.addEmployee(emp1);
		payrollSystem.displayEmployee();
		

	}

}
