package entities;

import java.util.Arrays;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private HourContract[] contracts = new HourContract[10];
	
	public Worker(String name, WorkerLevel level, Double baseSalary) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.contracts[0] = new HourContract(0,0d);
	}

	public void addContract(HourContract newContract) {
		contracts[contracts.length-1] = newContract;
	}

	public void removeContract(HourContract contractToRemove) {
		contracts[contracts.length - 1] = null;
	}

	public Double income(Integer month, Integer year) {		
		return null;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", level=" + level + ", baseSalary=" + baseSalary + ", contracts="
				+ Arrays.toString(contracts) + "]";
	}
	
}
