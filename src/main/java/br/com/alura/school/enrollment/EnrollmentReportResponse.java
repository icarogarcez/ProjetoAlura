package br.com.alura.school.enrollment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnrollmentReportResponse {
    
    @JsonProperty
    private String email;

    @JsonProperty ("quantidade_matriculas")
    private long amountEnroll;

    public EnrollmentReportResponse() {
    }

    public EnrollmentReportResponse(EnrollmentReport enrollmentReport){
        this.email = enrollmentReport.getEmail();
        this.amountEnroll = enrollmentReport.getQuantity();
    }
}
