package com.example.contactproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    public static List<ContactDTO> findAllContacts() {
        String query = "select * from contacts order by contact_id";
        try {
            PreparedStatement ps = OracleDatabase.getPreparedStatement(query);
            ResultSet rs = ps.executeQuery(query);
            List<ContactDTO> list = new ArrayList<>();
            while (rs.next()) {
                ContactDTO contactDto = new ContactDTO();
                contactDto.setContact_id(rs.getInt(1));
                contactDto.setFirst_name(rs.getString(2));
                contactDto.setLastname(rs.getString(3));
                contactDto.setHome_phone(rs.getString(4));
                contactDto.setWork_phone(rs.getString(5));
                contactDto.setPersonal_mobile(rs.getString(6));
                contactDto.setWork_mobile(rs.getString(7));
                contactDto.setHome_address(rs.getString(8));
                contactDto.setWork_address(rs.getString(9));
                list.add(contactDto);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean insertContact(ContactDTO contactDTO) {
        String query = "insert into contacts values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = OracleDatabase.getPreparedStatement(query);
            ps.setInt(1, contactDTO.getContact_id());
            ps.setString(2, contactDTO.getFirst_name());
            ps.setString(3, contactDTO.getLastname());
            ps.setString(4, contactDTO.getHome_phone());
            ps.setString(5, contactDTO.getWork_phone());
            ps.setString(6, contactDTO.getPersonal_mobile());
            ps.setString(7, contactDTO.getWork_mobile());
            ps.setString(8, contactDTO.getHome_address());
            ps.setString(9, contactDTO.getWork_address());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteContact(int id) {
        String query = "DELETE FROM contacts WHERE contact_id=?";
        try {
            PreparedStatement ps = OracleDatabase.getPreparedStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ContactDTO findContactById(int contact_id) {
        String query = "select * from contacts where contact_id = ?";
        try {
            PreparedStatement ps = OracleDatabase.getPreparedStatement(query);
            ps.setInt(1, contact_id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                int contactId = Integer.parseInt(result.getString(1));
                String firstName = result.getString(2);
                String lastName = result.getString(3);
                String homePhone = result.getString(4);
                String workPhone = result.getString(5);
                String personalMobile = result.getString(6);
                String workMobile = result.getString(7);
                String homeAddress = result.getString(8);
                String workAddress = result.getString(9);
                ContactDTO contactDTO = new ContactDTO(contactId, firstName,
                        lastName, homePhone, workPhone, personalMobile, workMobile,
                        homeAddress, workAddress);
                return contactDTO;
            }
            result.close();
            ps.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean updateContact(ContactDTO contactDTO) {
        String query = "UPDATE contacts SET first_name = ?, last_name = ?," +
                "home_phone= ?,work_phone= ?,personal_mobile= ?,work_mobile= ?,home_address= ?" +
                ",work_address= ? where contact_id= ?";
        try {
            PreparedStatement ps = OracleDatabase.getPreparedStatement(query);
            ps.setString(1, contactDTO.getFirst_name());
            ps.setString(2, contactDTO.getLastname());
            ps.setString(3, contactDTO.getHome_phone());
            ps.setString(4, contactDTO.getWork_phone());
            ps.setString(5, contactDTO.getPersonal_mobile());
            ps.setString(6, contactDTO.getWork_mobile());
            ps.setString(7, contactDTO.getHome_address());
            ps.setString(8, contactDTO.getWork_address());
            ps.setInt(9, contactDTO.getContact_id());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void searchContacts(ContactDTO contacts) {

    }
}







