package com.qlmh.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qlmh.api.DTO.ComplexBodyPropDTO;
import com.qlmh.api.Model.ComplexBodyProp;
import com.qlmh.api.Service.ComplexBodyPropService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/comp-body-props")
public class ComplexBodyPropController {
	@Autowired
	ComplexBodyPropService complexBodyPropService;
	
	// create
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ComplexBodyProp create(@RequestBody ComplexBodyProp complexBodyProp) {
		return complexBodyPropService.create(complexBodyProp);
	}
	
	// get all complex body prop
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<ComplexBodyProp> getAllComplexBodyProps(){
		return complexBodyPropService.getAllComplexBodyProps();
	}
	
	// get complex body prop by id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ComplexBodyPropDTO getById(@PathVariable(value = "id") Integer id) {
		return complexBodyPropService.getById(id);
	}
	
	// get all comp body id
	@RequestMapping(value = "/comp-body/{id}", method = RequestMethod.GET)
	public List<ComplexBodyPropDTO> getAllByCompBodyId(@PathVariable(value = "id") Integer id){
		return complexBodyPropService.getAllByCompBodyId(id);
	}
	
	// add face
	@RequestMapping(value = "/{id}/face/{face-id}", method = RequestMethod.PUT)
	public ComplexBodyPropDTO addFace(@PathVariable(value = "id") Integer id, @PathVariable(value = "face-id") Integer faceId) {
		return complexBodyPropService.addFace(id, faceId);
	}
	
	// delete
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteById(@PathVariable(value = "id") Integer id) {
		return complexBodyPropService.deleteById(id);
	}
}
