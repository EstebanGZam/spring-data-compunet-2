package co.edu.icesi.introspringboot2.controller;

import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final ProfessorService professorService;

    @Autowired
    public CourseController(CourseService courseService, ProfessorService professorService) {
        this.courseService = courseService;
        this.professorService = professorService;
    }

    @GetMapping
    public String index(Model model) {
        var professors = professorService.getAllProfessors();
        var courses = courseService.getAllCourses();
        model.addAttribute("course", new Course());
        model.addAttribute("professors", professors);
        model.addAttribute("courses", courses);
        return "course";
    }

    @PostMapping
    public String createCourse(@ModelAttribute Course course) {
        courseService.createCourse(course);
        return "redirect:/course";
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Course>> create() {
        var list = courseService.listCourseOfStudent(1);
        return ResponseEntity.status(200).body(list);
    }

}
