package parking_lot;

public class Car {
private String carRegno;
	
	private String carColor;
	
	public Car(){
		
	}
	
	public Car(String carRegno, String carColor){
		
		this.carRegno = carRegno;
		this.carColor = carColor;
	}

	public String getCarRegNo(){
		return carRegno;
	}

	public void setCarRegno(String carRegno) {
		this.carRegno = carRegno;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	
}

