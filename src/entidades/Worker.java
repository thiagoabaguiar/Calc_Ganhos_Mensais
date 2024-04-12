package entidades;

import java.util.ArrayList;
import java.util.Arrays;

public class Worker {

	private String name;
	private String level;
	private Double baseSalary;
	private Integer qtyHourContracts;
	private Contrato[] contracts;
	private String department;

	public Worker(String name, String level, Double baseSalary, Integer qtyHourContracts, String department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.qtyHourContracts = qtyHourContracts;
		this.department = department;
		this.contracts = new Contrato[qtyHourContracts];
	}

	public Contrato addContract(Contrato newHourContract) {

		for (int i = 0; i < this.contracts.length; i++) {

			if (this.contracts[i] == null) {
				this.contracts[i] = newHourContract;
				return newHourContract;
			}

		}

		return null;
	}

	public Contrato removeContract(Integer idContractToRemove) {

		int indexOfHourContractToRemove = 0;

		for (Contrato contract : this.contracts) {

			if (contract.getIdContract() == idContractToRemove) {

				ArrayList<Contrato> temporaryListOfHourContracts = new ArrayList<>();
				for (Contrato e : this.contracts) {
					temporaryListOfHourContracts.add(e);
				}

				indexOfHourContractToRemove = temporaryListOfHourContracts.indexOf(contract);

				Contrato contractToRemove = this.contracts[indexOfHourContractToRemove];

				this.contracts[indexOfHourContractToRemove] = null;

				return contractToRemove;

			}
		}

		return null;

	}

	public Double income(Integer month, Integer year) {
		return null;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", level=" + level + ", baseSalary=" + baseSalary + ", qtyHourContracts="
				+ qtyHourContracts + ", contracts=" + Arrays.toString(contracts) + ", department=" + department + "]";
	}
	
}