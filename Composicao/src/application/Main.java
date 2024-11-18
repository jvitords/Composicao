package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main { public static void main(String[] args) throws ParseException {

	Scanner digitar = new Scanner(System.in);
	
	System.out.println("========= Cadastro de funcionáerio =========\n");
	System.out.println("Insira as informações a seguir:\n");
	
	System.out.print("Nome: ");
	String nomeDoTrabalahdor = digitar.nextLine(); // Nome do trabalhador
	
	System.out.print("\nDepartamento: ");
	String departamentoDigitado = digitar.nextLine(); // Departamento do trabalhador
	
	System.out.print("\nNível do cargo: ");
	String nivelDoCargo = digitar.nextLine().toLowerCase(); // Nível dp cargo do trabalhador
	
	System.out.print("\nBase salarial: ");
	Double baseSalary = digitar.nextDouble(); // Salário do trabalhador
	
	WorkerLevel workerLevel = null;
	
	switch (nivelDoCargo) {  // verifica o nível do cargo
	case "junior": 
		workerLevel = WorkerLevel.JUNIOR;
		break;
	case "pleno":
		workerLevel = WorkerLevel.PLENO;
		break;
	case "senior":
		workerLevel = WorkerLevel.SENIOR;
		break;
	default:
		System.out.print("Cargo incorreto");
		break;
	}
	
	// vamos instanciar um novo trabalhador abaixo:
	Worker trabalhador = new Worker(nomeDoTrabalahdor, workerLevel, baseSalary, new Departament(departamentoDigitado));
	System.out.println(trabalhador);
	System.out.println("\n");
	
	System.out.println("===== REGISTRO DE CONTRATO =====\n");
	SimpleDateFormat formatoDaData = new SimpleDateFormat("dd/MM/yyyy");
	System.out.print("Data do contrato: ");
	Date dataDoContrato = formatoDaData.parse(digitar.next());
	System.out.print("Valor por hora: ");
	double valorPorHora = digitar.nextInt();
	System.out.print("horas trabalhadas: ");
	int horasTrabalhadas = digitar.nextInt();
	
	HourContract novoContrato = new HourContract(dataDoContrato, valorPorHora, horasTrabalhadas);
	
	trabalhador.addNewContract(novoContrato);
	//trabalhador.getListContracts();	
	//trabalhador.removeContract();
	//trabalhador.getListContracts();
	
	digitar.close();
	}
}