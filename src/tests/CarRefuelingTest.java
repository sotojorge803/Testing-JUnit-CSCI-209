package tests;
import car.Car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the Car class' refueling methods.
 * 
 * @author Jorge Soto-Ventura
 * @author Caleb Choe
 * @author Jackson Jacobs
 *
 */

class CarRefuelingTest {
	
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
	 * Tests the basic fillTank method.
	 */
	@Test
	void testFillTank() {
		aCar.fillTank();
		assertEquals(10, aCar.getRemainingGas());
		
		aCar.setGear(Car.FORWARD);
		aCar.go(40);
		aCar.fillTank();
		assertEquals(10, aCar.getRemainingGas());
		
		aCar.go(200);
		aCar.fillTank();
		assertEquals(10, aCar.getRemainingGas());
	}
	
	/**
	 * Test the fillTank method if the tank is already full.
	 */
	@Test
	void testFillTankFull() {
		aCar.fillTank();
		aCar.setGear(Car.FORWARD);
		aCar.go(0);
		aCar.fillTank();
		assertEquals(10, aCar.getRemainingGas());
	}
	
	/**
	 * Tests the refuel method.
	 */
	@Test
	void testRefuel() {
		aCar.fillTank(); //sets gas to 10
		aCar.setGear(Car.FORWARD); //gear to forward
		aCar.go(60); //should use 3 gallons of gas
		aCar.refuel(2); //fuel to 9 gallons
		assertEquals(9, aCar.getRemainingGas());
		
		//test boundary case of 0
		aCar.refuel(0);
		assertEquals(9, aCar.getRemainingGas());
		
		//test if the parameter is over the max capacity, should stop at 10
		aCar.refuel(15);
		assertEquals(10, aCar.getRemainingGas());
		
		//test if you call refuel when the car is already full
		aCar.refuel(102);
		assertEquals(10, aCar.getRemainingGas());
	}
}
