package co.edu.icesi.introspringboot2.controller;

import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;


    public StudentController(@Qualifier("studentServiceImpl") StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity< List<Student> > all() {
        var list = studentService.getByProgram("SIS");
        return ResponseEntity.status(200).body(list);
    }

    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestBody Student student) {
        studentService.createStudent(student);
        return "Creando un estudiante " + student.getName();
    }


    @GetMapping("/all/{page}")
    @ResponseBody
    public ResponseEntity<Page<Student>> getStudents(@PathVariable int page) {
        var pageResponse = studentService.findAll(page);
        return ResponseEntity.status(200).body(pageResponse);
    }


}
