package club.jijigugu.onecan.admin.service;

import club.jijigugu.onecan.admin.domain.UserReport;
import club.jijigugu.onecan.admin.repository.UserReportRepository;
import org.springframework.stereotype.Service;

@Service
public class UserReportService {
    private UserReportRepository reportRepository;

    public UserReportService(UserReportRepository reportRepository){
        this.reportRepository = reportRepository;
    }

    public void add(UserReport userReport){
        reportRepository.save(userReport);
    }
}
