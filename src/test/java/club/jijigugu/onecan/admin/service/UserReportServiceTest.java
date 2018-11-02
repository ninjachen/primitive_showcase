package club.jijigugu.onecan.admin.service;

import club.jijigugu.onecan.admin.domain.UserReport;
import club.jijigugu.onecan.admin.repository.UserReportRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * Test use h2, a in-mem database.It will create when test start and dop when test finish.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserReportServiceTest {

    @Autowired
    UserReportRepository reportRepository;

    @Before
    public void addFakeData(){
        UserReport userReport = new UserReport();
        userReport.setReportId(1);
        userReport.setReportName("im ninja");
        userReport.setSuspectName("Im robot");
        reportRepository.save(userReport);
    }

    @Test
    public void testH2DataBaseWork(){
        List<UserReport> list = reportRepository.findByReportName("im ninja");
        Assert.assertNotNull(list);
    }
}