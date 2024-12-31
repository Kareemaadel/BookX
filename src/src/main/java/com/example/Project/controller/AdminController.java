package com.example.Project.controller;

import com.example.Project.model.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Project.service.ReportsService;

import java.util.List;

@Controller()
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
  private ReportsService reportsService;
    @GetMapping
    public String adminPage() {
        return "Admin"; // Ensure you have an Admin.html template
    }
    @GetMapping("/reports")
    public String handleReports(Model model) {
        List<Report> reports = reportsService.getAllReports();
        model.addAttribute("reports", reports);
        return "reports"; // Ensure you have a reports.html template
    }



    }
