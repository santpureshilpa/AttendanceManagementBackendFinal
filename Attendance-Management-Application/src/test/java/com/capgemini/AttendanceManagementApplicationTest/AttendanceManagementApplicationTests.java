package com.capgemini.AttendanceManagementApplicationTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.capgemini.entity.AttendanceEntity;
import com.capgemini.entity.CourseEntity;
import com.capgemini.entity.FacultyEntity;
import com.capgemini.entity.StudentEntity;
import com.capgemini.entity.SubjectEntity;
import com.capgemini.exception.AttendanceIdNotFoundException;
import com.capgemini.exception.CourseIdNotFoundException;
import com.capgemini.exception.DuplicateRecordException;
import com.capgemini.exception.FacultyIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.StudentNotFoundException;
import com.capgemini.exception.SubjectNotFoundException;
import com.capgemini.repository.CourseRepository;
import com.capgemini.repository.FacultyRepository;
import com.capgemini.repository.StudentRepository;
import com.capgemini.repository.SubjectRepository;
import com.capgemini.service.AttendanceService;
import com.capgemini.service.CourseService;
import com.capgemini.service.FacultyService;
import com.capgemini.service.StudentService;
import com.capgemini.service.SubjectService;
import com.capgemini.repository.AttendanceRepository;

@SpringBootTest
class AttendanceManagementApplicationTest  {

//-------------------------------------------Attendance---------------------------------------------------------------------------
	
		
}