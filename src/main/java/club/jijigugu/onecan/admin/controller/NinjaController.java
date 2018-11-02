package club.jijigugu.onecan.admin.controller;

import club.jijigugu.onecan.admin.domain.UserReport;
import club.jijigugu.onecan.admin.repository.UserReportRepository;
import club.jijigugu.onecan.admin.service.UserReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class NinjaController {

    @Autowired
    public UserReportService userReportService;

    @GetMapping("/ninja")
    public String hello() {
        UserReport userReport = new UserReport();
        userReport.setReportId(1);
        userReport.setReportName("name");
        userReport.setSuspectName("Im robot");
        userReportService.add(userReport);
        userReport = new UserReport();
        userReport.setReportId(1);
        userReport.setReportName("name");
        userReport.setSuspectName("Im robot");
        userReportService.add(userReport);
        userReport = new UserReport();
        userReport.setReportId(1);
        userReport.setReportName("name");
        userReport.setSuspectName("Im robot");
        userReportService.add(userReport);
        return "Hi, ninja!";
    }
}
