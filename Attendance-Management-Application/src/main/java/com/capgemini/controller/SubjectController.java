package com.capgemini.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.entity.SubjectEntity;
import com.capgemini.exception.CourseIdNotFoundException;
import com.capgemini.exception.DuplicateRecordException;
import com.capgemini.exception.FacultyIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.SubjectNotFoundException;
import com.capgemini.service.SubjectService;

@CrossOrigin
@RestController
@RequestMapping("/attendancemanagement")
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	
	@PostMapping(path="/subject") 
	public ResponseEntity<SubjectEntity> addSubject(@Valid @RequestBody SubjectEntity se) throws DuplicateRecordException 
	{
		SubjectEntity se1 = subjectService.addSubject(se);
		
		return ResponseEntity.ok(se1);
	}
	
	@PutMapping(path="/subject/{subjectId}")
	public ResponseEntity<SubjectEntity> updateSubjectById(@Valid @PathVariable int subjectId, @Valid @RequestBody SubjectEntity fe)
	throws SubjectNotFoundException
	{
		SubjectEntity se = subjectService.updateSubjectById(subjectId, fe);
		return ResponseEntity.ok(se);
	}
	
	@GetMapping(path="/subject/{subjectId}") 
	public ResponseEntity <SubjectEntity> getSubjectById(@PathVariable int subjectId) throws SubjectNotFoundException
	{
		SubjectEntity se = subjectService.getSubjectById(subjectId);
		return ResponseEntity.ok(se);
	}
	
	@GetMapping(path="/subject")
	public ResponseEntity<List<SubjectEntity>> getAllSubjects() throws RecordNotFoundException
	{		
		List<SubjectEntity> se = subjectService.getAllSubjects();
		return ResponseEntity.ok(se);
		
	}

	
	  @GetMapping(path="/subject/byname/{subjectName}") 
	  public ResponseEntity<List<SubjectEntity>> findSubjectByName(@PathVariable String subjectName)
	         throws RecordNotFoundException
	 {
		  List<SubjectEntity> se=subjectService.findSubjectByName(subjectName);
		  ResponseEntity<List<SubjectEntity>> re=ResponseEntity.ok(se);
		  return re;
	  
	  
	  }
	 
	@DeleteMapping(path="/subject/{subjectId}")
	public ResponseEntity<String> deleteSubById(@Valid @PathVariable int subjectId) throws RecordNotFoundException
	{
		subjectService.deleteSubById(subjectId);
		return ResponseEntity.ok("Deleted");
	}
	
	
	@GetMapping(path="/getSubjectsBySemester/{subjectSemester}") 
	public ResponseEntity<List<SubjectEntity>> findSubjectBySemester(String subjectSemester) 
			throws RecordNotFoundException{ 
		  List<SubjectEntity>se=subjectService.findSubjectBySemester(subjectSemester); 
		  return new ResponseEntity<List<SubjectEntity>>(se,HttpStatus.FOUND); 
	   }
}