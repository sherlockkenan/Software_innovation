package com.example.resume1;

public class ResumeInfo {
    private String template;
    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    //basics
    private String basicname;
    private String basiclabel;
    private String basicemail;
    private String basicphone;
    private String basiclocationaddress;
    private String basiclocationpostalcode;
    private String basiclocationcity;
    private String basiclocationcountrycode;
    private String basiclocationregion;

    //work
    private String workcompany;
    private String workposition;
    private String workwebsite;
    private String workstartdate;
    private String workenddate;
    private String worksummary;

    //education
    private String educationinstitution;
    private String educationarea;
    private String educationstudytype;
    private String educationstartdate;
    private String educationenddate;

    //awards
    private String awardtitle;
    private String awarddate;
    private String awardwarder;

    //publications
    private String publicationname;
    private String publicationpublicsher;
    private String publicationreleasedate;
    private String publicationwebsite;
    private String publicationsummary;

    //interests
    private String interestname;
    private String interestkeyword1;
    private String interestkeyword2;
    private String interestkeyword3;

    public ResumeInfo()
    {

    }

    public ResumeInfo(String[] strs)
    {
        this.template=strs[0];
        this.basicname=strs[1];
        this.basiclabel=strs[2];
        this.basicemail=strs[3];
        this.basicphone=strs[4];
        this.basiclocationaddress=strs[5];
        this.basiclocationpostalcode=strs[6];
        this.basiclocationcity=strs[7];
        this.basiclocationcountrycode=strs[8];
        this.basiclocationregion=strs[9];
        this.workcompany=strs[10];
        this.workposition=strs[11];
        this.workwebsite=strs[12];
        this.workstartdate=strs[13];
        this.workenddate=strs[14];
        this.worksummary=strs[15];
        this.educationinstitution=strs[16];
        this.educationarea=strs[17];
        this.educationstudytype=strs[18];
        this.educationstartdate=strs[19];
        this.educationenddate=strs[20];
        this.awardtitle=strs[21];
        this.awarddate=strs[22];
        this.awardwarder=strs[23];
        this.publicationname=strs[24];
        this.publicationpublicsher=strs[25];
        this.publicationreleasedate=strs[26];
        this.publicationwebsite=strs[27];
        this.publicationsummary=strs[28];
        this.interestname=strs[29];
        this.interestkeyword1=strs[30];
        this.interestkeyword2=strs[31];
        this.interestkeyword3=strs[32];
    }

    public String getInterestname() {
        return interestname;
    }

    public void setInterestname(String interestname) {
        this.interestname = interestname;
    }

    public String getInterestkeyword1() {
        return interestkeyword1;
    }

    public void setInterestkeyword1(String interestkeyword1) {
        this.interestkeyword1 = interestkeyword1;
    }

    public String getInterestkeyword2() {
        return interestkeyword2;
    }

    public void setInterestkeyword2(String interestkeyword2) {
        this.interestkeyword2 = interestkeyword2;
    }

    public String getInterestkeyword3() {
        return interestkeyword3;
    }

    public void setInterestkeyword3(String interestkeyword3) {
        this.interestkeyword3 = interestkeyword3;
    }
    public String getPublicationname() {
        return publicationname;
    }

    public void setPublicationname(String publicationname) {
        this.publicationname = publicationname;
    }

    public String getPublicationpublicsher() {
        return publicationpublicsher;
    }

    public void setPublicationpublicsher(String publicationpublicsher) {
        this.publicationpublicsher = publicationpublicsher;
    }

    public String getPublicationreleasedate() {
        return publicationreleasedate;
    }

    public void setPublicationreleasedate(String publicationreleasedate) {
        this.publicationreleasedate = publicationreleasedate;
    }

    public String getPublicationwebsite() {
        return publicationwebsite;
    }

    public void setPublicationwebsite(String publicationwebsite) {
        this.publicationwebsite = publicationwebsite;
    }

    public String getPublicationsummary() {
        return publicationsummary;
    }

    public void setPublicationsummary(String publicationsummary) {
        this.publicationsummary = publicationsummary;
    }

    public String getAwardtitle() {
        return awardtitle;
    }

    public void setAwardtitle(String awardtitle) {
        this.awardtitle = awardtitle;
    }

    public String getAwarddate() {
        return awarddate;
    }

    public void setAwarddate(String awarddate) {
        this.awarddate = awarddate;
    }

    public String getAwardwarder() {
        return awardwarder;
    }

    public void setAwardwarder(String awardwarder) {
        this.awardwarder = awardwarder;
    }

    public String getEducationinstitution() {
        return educationinstitution;
    }

    public void setEducationinstitution(String educationinstitution) {
        this.educationinstitution = educationinstitution;
    }

    public String getEducationarea() {
        return educationarea;
    }

    public void setEducationarea(String educationarea) {
        this.educationarea = educationarea;
    }

    public String getEducationstudytype() {
        return educationstudytype;
    }

    public void setEducationstudytype(String educationstudytype) {
        this.educationstudytype = educationstudytype;
    }

    public String getEducationstartdate() {
        return educationstartdate;
    }

    public void setEducationstartdate(String educationstartdate) {
        this.educationstartdate = educationstartdate;
    }

    public String getEducationenddate() {
        return educationenddate;
    }

    public void setEducationenddate(String educationenddate) {
        this.educationenddate = educationenddate;
    }

    public String getWorkcompany() {
        return workcompany;
    }

    public void setWorkcompany(String workcompany) {
        this.workcompany = workcompany;
    }

    public String getWorkposition() {
        return workposition;
    }

    public void setWorkposition(String workposition) {
        this.workposition = workposition;
    }

    public String getWorkwebsite() {
        return workwebsite;
    }

    public void setWorkwebsite(String workwebsite) {
        this.workwebsite = workwebsite;
    }

    public String getWorkstartdate() {
        return workstartdate;
    }

    public void setWorkstartdate(String workstartdate) {
        this.workstartdate = workstartdate;
    }

    public String getWorkenddate() {
        return workenddate;
    }

    public void setWorkenddate(String workenddate) {
        this.workenddate = workenddate;
    }

    public String getWorksummary() {
        return worksummary;
    }

    public void setWorksummary(String worksummary) {
        this.worksummary = worksummary;
    }

    public String getBasicname() {
        return basicname;
    }

    public void setBasicname(String basicname) {
        this.basicname = basicname;
    }

    public String getBasiclabel() {
        return basiclabel;
    }

    public void setBasiclabel(String basiclabel) {
        this.basiclabel = basiclabel;
    }

    public String getBasicemail() {
        return basicemail;
    }

    public void setBasicemail(String basicemail) {
        this.basicemail = basicemail;
    }

    public String getBasicphone() {
        return basicphone;
    }

    public void setBasicphone(String basicphone) {
        this.basicphone = basicphone;
    }

    public String getBasiclocationaddress() {
        return basiclocationaddress;
    }

    public void setBasiclocationaddress(String basiclocationaddress) {
        this.basiclocationaddress = basiclocationaddress;
    }

    public String getBasiclocationpostalcode() {
        return basiclocationpostalcode;
    }

    public void setBasiclocationpostalcode(String basiclocationpostalcode) {
        this.basiclocationpostalcode = basiclocationpostalcode;
    }

    public String getBasiclocationcity() {
        return basiclocationcity;
    }

    public void setBasiclocationcity(String basiclocationcity) {
        this.basiclocationcity = basiclocationcity;
    }

    public String getBasiclocationcountrycode() {
        return basiclocationcountrycode;
    }

    public void setBasiclocationcountrycode(String basiclocationcountrycode) {
        this.basiclocationcountrycode = basiclocationcountrycode;
    }

    public String getBasiclocationregion() {
        return basiclocationregion;
    }

    public void setBasiclocationregion(String basiclocationregion) {
        this.basiclocationregion = basiclocationregion;
    }
}
