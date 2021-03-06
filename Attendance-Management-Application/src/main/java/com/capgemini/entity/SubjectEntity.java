package com.capgemini.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Subjects")
public class SubjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="subjects_generations")
	@SequenceGenerator(name="subjects_generations", sequenceName = "subjects_sequences", allocationSize=1)	
	private int subjectId;
	
	@Column(name="Course_Id")
	@NotNull
	private int courseId;	
	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	@Column(name="Faculty_Id")
	@NotNull
	private int facultyId;
	


	@Column(name="subject_name")
	@NotEmpty
	@Size(max = 50, message = "Not a valid subject name")
	private String subjectName;
	
	@NotEmpty
	private String subjectSemester;
	
	@NotEmpty
	@Size(max = 100)
	private String description;
	

	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name="courses_Id")
	private CourseEntity course;


	
		
	@JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="facultyy_Id")
	private FacultyEntity facultyentity;
	
	
	
	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	public FacultyEntity getFacultyentity() {
		return facultyentity;
	}

	public void setFacultyentity(FacultyEntity facultyentity) {
		this.facultyentity = facultyentity;
	}

	
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectSemester() {
		return subjectSemester;
	}

	public void setSubjectSemester(String subjectSemester) {
		this.subjectSemester = subjectSemester;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public SubjectEntity() {
		super();
	}
	
	public SubjectEntity(int subjectId,
			@NotEmpty @Size(max = 15, message = "Not a valid subject name") String subjectName,
			@NotEmpty String subjectSemester, @NotEmpty @Size(max = 50) String description, CourseEntity course,
			FacultyEntity facultyentity) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectSemester = subjectSemester;
		this.description = description;
     	this.course = course;
		this.facultyentity = facultyentity;
	}	
}