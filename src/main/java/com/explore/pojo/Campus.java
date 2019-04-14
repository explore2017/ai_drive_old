package com.explore.pojo;

public class Campus {
    private Integer id;

    private String name;

    private String position;

    private Integer organId;

    private Integer coachSum;

    private Integer studentSum;

    private Integer vehicleSum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Integer getOrganId() {
        return organId;
    }

    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public Integer getCoachSum() {
        return coachSum;
    }

    public void setCoachSum(Integer coachSum) {
        this.coachSum = coachSum;
    }

    public Integer getStudentSum() {
        return studentSum;
    }

    public void setStudentSum(Integer studentSum) {
        this.studentSum = studentSum;
    }

    public Integer getVehicleSum() {
        return vehicleSum;
    }

    public void setVehicleSum(Integer vehicleSum) {
        this.vehicleSum = vehicleSum;
    }
}