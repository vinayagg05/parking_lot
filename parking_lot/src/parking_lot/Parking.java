package parking_lot;

import java.util.*;

public class Parking {

public TreeMap<Integer,Car> parkingSlot = null;
	
	private int maxSizeOfParking;
	
	public  List<Integer>  availableSlots=null;
	
	private List<String> parkedCarRegNoList=null; 
	
	private boolean parkingLotCreated = false;
	
	public boolean parkingLotCreated() {
		return parkingLotCreated;
	}

	
	public void craeteParking(int parkingSize){
		try{
			
		
		if(parkingSize>0){
			maxSizeOfParking = parkingSize;
			parkingSlot = new TreeMap<Integer, Car>();
			availableSlots = new ArrayList<Integer>();
			parkedCarRegNoList = new ArrayList<String>();
		for(int i=1;i<=parkingSize;i++)
			availableSlots.add(i);
			
		System.out.println("Created a parking lot with "+maxSizeOfParking+" slots");
		parkingLotCreated = true;
		}
		else{
			System.out.println("Parking lot size should be greater than 0");
		}
		}
		catch(Exception e){
			System.out.println("Unbale to craete parking Lot");
			
		}
	}

	public void carEnterParking(String regNo,String color){
		if(!parkedCarRegNoList.contains(regNo)){
			
			if(parkingSlot.keySet().size() == maxSizeOfParking){
				System.out.println("Parking is already Full");
			}
			else{
				Car car = new Car(regNo,color);
				
				int parkingPlace = nearestParkingSlot();
				parkingSlot.put(parkingPlace, car);
				availableSlots.remove(availableSlots.indexOf(parkingPlace));
				parkedCarRegNoList.add(regNo);
				System.out.println("Allocated slot number : "+parkingPlace);
			}
		}
		else{
			System.out.println("Car is already parked in parking");	
		}
	}
	
	
	public void carLeaveParking(int parkingSlotNo){
		if(parkingSlot.containsKey(parkingSlotNo)){
			
			String parkedCarRegNo = parkingSlot.get(parkingSlotNo).getCarRegNo();
			parkingSlot.remove(parkingSlotNo);
			parkedCarRegNoList.remove(parkedCarRegNoList.indexOf(parkedCarRegNo));
			availableSlots.add(parkingSlotNo);
			Collections.sort(availableSlots);
			System.out.println("Parking slot no "+parkingSlotNo +" is free " );
					}
		else if(parkingSlotNo > maxSizeOfParking || parkingSlotNo < 0 ){
			System.out.println("Parking slot no is invalid");
		}
		else{
			System.out.println(" Parking slot is empty");
		}
	}
	
	
	public void statusOfParking(){
		Iterator<Integer> itr = parkingSlot.keySet().iterator();
		System.out.println("Slot No"+"     "+"Registration No"+"     "+"Color");
		while(itr.hasNext()){
			Integer parkingSlotNumber = itr.next();
			Car car = parkingSlot.get(parkingSlotNumber);
			System.out.println(parkingSlotNumber +"          "+ car.getCarRegNo()+"          "+car.getCarColor());
		}
	}

	
	public void getRegNoOfCarWithColor(String color){
		String regNoString ="";
		Iterator<Integer> itr = parkingSlot.keySet().iterator();
		while(itr.hasNext()){
			Integer parkingSlotNumber = itr.next();
			Car car = parkingSlot.get(parkingSlotNumber);
			
			if (car.getCarColor().equals(color)){
				regNoString = regNoString + car.getCarRegNo().toString() +", ";
			}
		}
		System.out.println(regNoString.substring(0,regNoString.length()-2));
	}
	
	public void getSlotNoByCarColor(String color){
		String slotNoString="";
		Iterator<Integer> itr = parkingSlot.keySet().iterator();
		while(itr.hasNext()){
			Integer parkingSlotNumber = itr.next();
			Car car = parkingSlot.get(parkingSlotNumber);
			if (car.getCarColor().equals(color)){
			
				slotNoString = slotNoString + parkingSlotNumber.toString()+	", ";
			}
		}
		System.out.println(slotNoString.substring(0,slotNoString.length()-2));
	}
	
	
	public void getSlotNoByCarRegNo(String carRegNo){
		String slotNoString="";
		Iterator<Integer> itr = parkingSlot.keySet().iterator();
		while(itr.hasNext()){
			Integer parkingSlotNumber = itr.next();
			Car car = parkingSlot.get(parkingSlotNumber);
			if(car.getCarRegNo().equals(carRegNo)){
				slotNoString = parkingSlotNumber.toString();
			}
		}
	
		if(slotNoString.equals(""))
			System.out.println("Not found");
		else
			System.out.println(slotNoString);
}
	private int nearestParkingSlot() {
		return availableSlots.get(0);
	}
	
}
