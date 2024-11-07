package ru.klyanchin.testsecurity2dbthemeleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.klyanchin.testsecurity2dbthemeleaf.entity.Student;
import ru.klyanchin.testsecurity2dbthemeleaf.repository.StudentRepository;

import java.security.Security;
import java.util.Optional;

@Slf4j
@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    public String GetCurrUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @GetMapping("/list")
    public ModelAndView getAllStudent() {
        log.info("/list -> connection");
        ModelAndView mav = new ModelAndView("list-students");
        mav.addObject("students", studentRepository.findAll());
        return mav;
    }
    @GetMapping("/addStudentForm")
    public ModelAndView addStudentForm()
    {
        ModelAndView mav = new ModelAndView("add-student-form");
        Student student = new Student();
        mav.addObject("student", student);
        return mav;
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student)
    {
        studentRepository.save(student);
        return "redirect:/list";
    }
    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long studentId)
    {
        ModelAndView mav = new ModelAndView("add-student-form");
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Student student = new Student();
        if(optionalStudent.isPresent())
        {
            student = optionalStudent.get();
        }
        mav.addObject("student", student);
        return mav;
    }
    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam Long studentId)
    {
        studentRepository.deleteById(studentId);
        return "redirect:/list";
    }
}