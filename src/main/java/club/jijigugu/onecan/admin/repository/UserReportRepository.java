package club.jijigugu.onecan.admin.repository;

import club.jijigugu.onecan.admin.domain.UserReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReportRepository extends JpaRepository<UserReport, Integer> {
    String findNameById(int id);
    List<UserReport> findByReportName(String name);
}
