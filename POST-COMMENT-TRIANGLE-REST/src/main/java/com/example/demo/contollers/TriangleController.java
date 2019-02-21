package com.example.demo.contollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Triangle;
import com.example.demo.repository.TriangleRepository;

@RestController
@RequestMapping("/triangle")
public class TriangleController {
	
	@Autowired
	private TriangleRepository triangleRepository;

	@GetMapping("/alltriangle")
	public List<Triangle> getAllTriangles() {
		return triangleRepository.findAll();
	}

	@GetMapping("/triangle/{id}")
	public Optional<Triangle> findTriangleById(@PathVariable("id") Long id) {
		return triangleRepository.findById(id);
	}

	@PostMapping("/triangle")
	public Triangle createTriangle(@RequestBody Triangle t) {
		String type = afficherTypeTriangle(t);
		Triangle t1 = new Triangle();
		t1.setA(t.getA());
		t1.setB(t.getB());
		t1.setC(t.getC());
		t1.setType(type);
		triangleRepository.save(t1);
		return t1;
	}

	@RequestMapping("/type")
	public String afficherTypeTriangle(@RequestBody Triangle t) {
		String type = null;

		if (t.getA() <= 0 || t.getB() <= 0 || t.getC() <= 0) {
			type = "Paramètres incorrects";
		}

		else if (t.getA() == t.getB() && t.getA() == t.getC()) {
			type = "Triangle équilatéral";
		}

		else if (t.getA() == t.getB() || t.getA() == t.getC() || t.getC() == t.getB()) {
			type = "Triangle isocèle";
		}

		else if (t.getA() != t.getB() && t.getA() != t.getC() && t.getB() != t.getC()) {
			type = "Triangle scalène";
		}

		return type;
	}

}
