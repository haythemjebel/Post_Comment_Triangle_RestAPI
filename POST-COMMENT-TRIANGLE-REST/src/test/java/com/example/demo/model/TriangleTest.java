package com.example.demo.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.demo.contollers.TriangleController;


public class TriangleTest {

	private TriangleController triangleController = new TriangleController();

	@Test
	public void testTypeTriangleIsocele() {
		Triangle t = new Triangle(10, 11, 10);
		String type = triangleController.afficherTypeTriangle(t);
		assertEquals("Triangle isocèle", type);
	}

	@Test
	public void testTypeTriangleScalene() {
		Triangle t = new Triangle(12, 11, 10);
		String type = triangleController.afficherTypeTriangle(t);
		assertEquals("Triangle scalène", type);
	}

	@Test
	public void testTypeTriangleEquilateral() {
		Triangle t = new Triangle(10, 10, 10);
		String type = triangleController.afficherTypeTriangle(t);
		assertEquals("Triangle équilatéral", type);
	}

	@Test
	public void testTypeTriangleWithNullCote() {
		Triangle t = new Triangle(10, 0, 10);
		String type = triangleController.afficherTypeTriangle(t);
		assertEquals("Paramètres incorrects", type);
	}

	@Test
	public void testTypeTriangleWithNegativeCote() {
		Triangle t = new Triangle(10, -11, 10);
		String type = triangleController.afficherTypeTriangle(t);
		assertEquals("Paramètres incorrects", type);
	}
}
