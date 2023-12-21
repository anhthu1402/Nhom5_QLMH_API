package com.qlmh.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qlmh.api.DTO.ComplexBodyDTO;
import com.qlmh.api.Model.ComplexBody;
import com.qlmh.api.Model.ComplexBodyFace;
import com.qlmh.api.Service.ComplexBodyService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/comp-bodies")
public class ComplexBodyController {
	@Autowired
	ComplexBodyService complexBodyService;
	
	// create complex body
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ComplexBody createComplexBody(@RequestBody ComplexBody complexBody) {
		return complexBodyService.createComplexBody(complexBody);
	}
	
	// add component
	@RequestMapping(value = "/{comp-body-id}/faces/{face-id}", method = RequestMethod.PUT)
	public ComplexBodyDTO addComponent(@PathVariable(value = "comp-body-id") Integer compBodyId, @RequestBody ComplexBodyFace complexBodyFace, @PathVariable(value = "face-id") Integer faceId) {
		return complexBodyService.addComponent(compBodyId, complexBodyFace, faceId);
	}
}
