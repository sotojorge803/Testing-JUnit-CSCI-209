package tests;
import car.Car;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the compareTo and toString methods
 * 
 * @author Jorge Soto-Ventura
 * @author Caleb Choe
 * @author Jackson Jacobs
 *
 */

public class CarStringCompareTest {
	
	private Car aCar;
	
	/**
	 * Creates a new Car object before each test.
	 */
	@BeforeEach
	void setUp() throws Exception {
		//20 MPG, 10 Gallon capacity
		aCar= new Car();
	}
	
	/**
	 * Tests the toString method, should return proper string output
	 */
	//
	@Test
	void testToString() {
		//set the state of aCar
		aCar.fillTank();
		aCar.setGear(Car.FORWARD);
		aCar.go(10);
		aCar.fillTank();
        String expected = "Tank Capacity: 10"
        		+ "\nMPG: 20"
        		+ "\nGas left: 10"
        		+ "\nGear: Forward"
        		+ "\nLocation: 10";
        assertEquals(expected, aCar.toString());
	}
	
	
	/**
	 * Tests the compareTo method, should return 
	 */
	//
	@Test
	void testCompareTo() {
		//set state of aCar
		aCar.fillTank();
		aCar.setGear(Car.FORWARD);
		aCar.go(25);
		
		//initiate and set state of different car
		Car differentCar= new Car();
		differentCar.fillTank();
		differentCar.setGear(Car.FORWARD);
		differentCar.go(5);
		
		//compare differentCar
		assertEquals(-1, differentCar.compareTo(aCar));
		assertEquals(1, aCar.compareTo(differentCar));
		
		//set state of sameCar
		Car sameCar= new Car();
		sameCar.fillTank();
		sameCar.setGear(Car.FORWARD);
		sameCar.go(25);
		
		//compare sameCar
		assertEquals(0, sameCar.compareTo(aCar));
		assertEquals(0, aCar.compareTo(sameCar));
	}
}
