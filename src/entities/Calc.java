package entities;

public class Calc {

	public static void main(String[] args) {

		HourContract contrato1 = new HourContract(100, 150d);
		HourContract contrato2 = new HourContract(10, 77d);			
		
		Worker worker1 = new Worker("Thiago",WorkerLevel.JUNIOR,100d);
		System.out.println(worker1);		
		worker1.addContract(contrato1);
		System.out.println(worker1);
		worker1.addContract(contrato2);
		System.out.println(worker1);
	}

}
