package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.enums.WorkerLevel;

public class Worker { // class do trabalhador

	private String name;
	private WorkerLevel workerLevel;
	private Double baseSalary;
	
	private Departament departament;
	private List<HourContract> listContracts = new ArrayList<HourContract>();
	
	public Worker() {
	}

	public Worker(String name, WorkerLevel workerLevel, Double baseSalary, Departament departament) {
		this.name = name;
		this.workerLevel = workerLevel;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getWorkerLevel() {
		return workerLevel;
	}

	public void setWorkerLevel(WorkerLevel workerLevel) {
		this.workerLevel = workerLevel;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public void getListContracts() {
		for (HourContract contrato : listContracts) {
			System.out.println("\nData: " + contrato.getDate() + "\nValor por hora: " + contrato.getValuePerHour() + "\nHoras trabalhadas: " + contrato.getHours() + "\nValor do contrato R$:" + contrato.totalValue());
		}
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public void addNewContract(HourContract novoContrato) { 
		
		listContracts.add(novoContrato); 
		System.out.println("\nContrato registrado com sucesso!");
	}
	
	public void income(int year, int month) { // soma quanto o trabalhador irá receber naqele mês, somando todos os contratos daquele mês junto com o salário
		double somaDoValorGanho = baseSalary;
		Calendar calendario = Calendar.getInstance();
		for(HourContract contrato : listContracts) {
			calendario.setTime(calendario.getTime());
			int calendar_year = calendario.get(Calendar.YEAR);
			int calendar_month = calendario.get(Calendar.MONTH);
			if(month == calendar_month && year == calendar_year) {
				somaDoValorGanho += contrato.totalValue();
			}
		}
	}
	
	public String toString() {
		return "==== INFORMAÇÕES DO TRABALHADOR ==== \n" +
				"\nNome: " + name  + "\nDepartamento: " + departament.getName() + "\nNível do cargo: " + workerLevel.getLevel() + "\nBase salarial: R$" + baseSalary; 
	}
}