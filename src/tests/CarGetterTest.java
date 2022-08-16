package tests;
import car.Car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the Car class' getter methods, as well as go and setGear.
 * 
 * @author Jorge Soto-Ventura
 * @author Caleb Choe
 * @author Jackson Jacobs
 *
 */

class CarGetterTest {
	
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
	 * Tests the getCapacity method, should return 10.
	 */
	@Test
	void testGetCapacity() { 
		assertEquals(10, aCar.getCapacity());
	}
	
	/**
	 * Tests the getMPG method, should return 20.
	 */
	@Test
	void testGetMPG() {
		assertEquals(20, aCar.getMPG());
	}
	
	/**
	 * Tests the go method to see how many many miles the car has went.
	 */
	@Test
	void testGo() {
		aCar.setGear(Car.FORWARD);
		aCar.fillTank();
		aCar.go(10); //tells car to go 10 miles
		assertEquals(10, aCar.getLocation());
		
		aCar.setGear(Car.REVERSE);
		aCar.go(10);
		assertEquals(0, aCar.getLocation());
		
		aCar.setGear(Car.FORWARD);
		aCar.fillTank();
		aCar.go(200);
		assertEquals(200, aCar.getLocation());
	}

	/**
	 * Tests the setGear method to see what gear the car is in
	 */
	@Test
	void testSetGear() {
		aCar.setGear(Car.FORWARD); // car should be in forward gear
		assertEquals(Car.FORWARD, aCar.getGear());
		
		aCar.setGear(Car.REVERSE);// car should be in reverse gear
		assertEquals(Car.REVERSE, aCar.getGear());
		
		aCar.setGear(Car.PARK); //car should be in park gear
		assertEquals(Car.PARK, aCar.getGear());
	}

	/**
	 * Tests the getReamainingGas method, should return 10, 8, 0.
	 */
	@Test
	void testGetRemainingGas() {
		aCar.fillTank(); //fill the tank
		assertEquals(10, aCar.getRemainingGas());
		
		aCar.setGear(Car.FORWARD); //put it into gear
		aCar.go(40); //drive 40 miles, should use 2 gallons
		assertEquals(8, aCar.getRemainingGas()); 
		
		aCar.go(160); //should bring the car to empty
		assertEquals(0, aCar.getRemainingGas());
	}
	
	
	/**
	 * Tests the getGear method.
	 */
	@Test
	void testGetGear() {
		aCar.setGear(Car.PARK);
		assertEquals(Car.PARK, aCar.getGear());
	}
	
	/**
	 * Tests the getLocation method.
	 */
	@Test
	void testGetLocation() {
		aCar.fillTank();// fills the tank
		aCar.setGear(Car.FORWARD);// sets the gear to FORWARD, puts it in forward.
		aCar.go(40);// car drives 40 miles
		assertEquals(40, aCar.getLocation());// gets the location of the car, should be 40 miles.
	}
}