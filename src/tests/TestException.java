package tests;
import car.Car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for exceptions, specifically IllegalStateException and IllegalArgumentException.
 * 
 * @author Jorge Soto-Ventura
 * @author Caleb Choe
 * @author Jackson Jacobs
 *
 */

public class TestException {
	
	Car aCar= new Car();
	
	/**
	 * Creates a new Car object before each test.
	 */
	@BeforeEach
	void setUp() throws Exception {
		//20 MPG, 10 Gallon capacity
		aCar= new Car();
	}
	
	/**
	 * Tests in case the car is driven without any gas or without enough gas.
	 */
	@Test
	void testNoGas() {
		aCar.fillTank();
		aCar.setGear(Car.FORWARD);
		aCar.go(200);
		//tests if you try to go without any gas
		assertThrows(IllegalStateException.class, () -> {
			aCar.go(10);
		    });
		aCar.fillTank();
		//tests if you try to go more than current gas allows
		assertThrows(IllegalStateException.class, () -> {
			aCar.go(432);
		    });
	}

	/**
	 * Test in case the car is driven in park.
	 */
	@Test
	void testGoInPark() {
		aCar.fillTank();
		aCar.setGear(Car.PARK);
		assertThrows(IllegalStateException.class, () -> {
			aCar.go(20);
		    });
	}
	
	/**
	 * Tests in case the car is given a wrong input for gear.
	 */
	@Test
	void testInputGear() { //test gear if its negative or greater than 2.
		assertThrows(IllegalArgumentException.class,
		() -> {aCar.setGear(-1);
		});
		assertThrows(IllegalArgumentException.class,
				() -> {aCar.setGear(3);
				});
		assertThrows(IllegalArgumentException.class,
				() -> {aCar.setGear(10);
				});

	}
	
	/**
	 * Tests if the car is driven into negative distance.
	 */
	@Test
	void testNegativeDistance() {
		aCar.fillTank();
		aCar.setGear(Car.FORWARD);
		assertThrows(IllegalArgumentException.class, () -> {
			aCar.go(-10);
		    });
	}
	
	/**
	 * Tests if there is a negative parameter passed in the refuel method.
	 */
	@Test
	void testRefuelException() {
		assertThrows(IllegalArgumentException.class, () -> {
			aCar.refuel(-12.5);
		    });
		assertThrows(IllegalArgumentException.class, () -> {
			aCar.refuel(-1);
		    });
		assertThrows(IllegalArgumentException.class, () -> {
			aCar.refuel(-402.42);
		    });
	}
}
