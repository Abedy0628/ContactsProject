package com.example.contactproject;

public class ContactDTO {

    private int contact_id;
    private String first_name;
    private String lastname;
    private String home_phone;
    private String work_phone;
    private String personal_mobile;
    private String work_mobile;
    private String home_address;
    private String work_address;

    public ContactDTO(int contactId, String name) {
    }

    public ContactDTO(int contact_id, String first_name, String lastname, String home_phone, String work_phone, String personal_mobile, String work_mobile, String home_address, String work_address) {
        this.contact_id = contact_id;
        this.first_name = first_name;
        this.lastname = lastname;
        this.home_phone = home_phone;
        this.work_phone = work_phone;
        this.personal_mobile = personal_mobile;
        this.work_mobile = work_mobile;
        this.home_address = home_address;
        this.work_address = work_address;
    }

    public ContactDTO() {

    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    public String getWork_phone() {
        return work_phone;
    }

    public void setWork_phone(String work_phone) {
        this.work_phone = work_phone;
    }

    public String getPersonal_mobile() {
        return personal_mobile;
    }

    public void setPersonal_mobile(String personal_mobile) {
        this.personal_mobile = personal_mobile;
    }

    public String getWork_mobile() {
        return work_mobile;
    }

    public void setWork_mobile(String work_mobile) {
        this.work_mobile = work_mobile;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public String getWork_address() {
        return work_address;
    }

    public void setWork_address(String work_address) {
        this.work_address = work_address;
    }

    @Override
    public String toString() {
        return String.format(" %s %s ", first_name, lastname);
    }
}
