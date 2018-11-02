package club.jijigugu.onecan.admin.domain;

import javax.persistence.*;

@Entity
@Table
public class UserReport {
    @Id
    @SequenceGenerator(name = "userreport", sequenceName = "user_report_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="userreport")
    private int id;

    private int reportId;

    private int suspectId;

    private String reportName;

    private String suspectName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getSuspectId() {
        return suspectId;
    }

    public void setSuspectId(int suspectId) {
        this.suspectId = suspectId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getSuspectName() {
        return suspectName;
    }

    public void setSuspectName(String suspectName) {
        this.suspectName = suspectName;
    }
}
