package com.example.contactproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


public class ContactController implements Initializable {
    @FXML
    ListView<ContactDTO> contactsListView;
    @FXML
    TextField t_contactId;
    @FXML
    TextField t_firstname;
    @FXML
    TextField t_lastname;
    @FXML
    TextField t_homephone;
    @FXML
    TextField t_workphone;
    @FXML
    TextField t_personal_mobile;
    @FXML
    TextField t_work_mobile;
    @FXML
    TextField t_home_address;
    @FXML
    TextField t_work_address;
    @FXML
    TextField t_searchId;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<ContactDTO> contactsList = ContactDAO.findAllContacts();
        assert contactsList != null;
        contactsListView.getItems().addAll(contactsList);

        contactsListView.getSelectionModel().selectedItemProperty().addListener((ov, o, selectedItem) -> {
            if (selectedItem != null) {
                t_contactId.setText(selectedItem.getContact_id() + "");
                t_firstname.setText(selectedItem.getFirst_name());
                t_lastname.setText(selectedItem.getLastname());
                t_homephone.setText(selectedItem.getHome_phone());
                t_workphone.setText(selectedItem.getWork_phone());
                t_personal_mobile.setText(selectedItem.getPersonal_mobile());
                t_work_mobile.setText(selectedItem.getWork_mobile());
                t_home_address.setText(selectedItem.getHome_address());
                t_work_address.setText(selectedItem.getWork_address());
            }
        });
    }

    public void UpsertContact() {
        int contactId = Integer.parseInt(t_contactId.getText());
        ContactDTO contactDTO = ContactDAO.findContactById(contactId);
        if (contactDTO != null) {
            contactDTO.setFirst_name(t_firstname.getText());
            contactDTO.setLastname(t_lastname.getText());
            contactDTO.setHome_phone(t_homephone.getText());
            contactDTO.setWork_phone(t_workphone.getText());
            contactDTO.setPersonal_mobile(t_personal_mobile.getText());
            contactDTO.setWork_phone(t_work_mobile.getText());
            contactDTO.setHome_address(t_home_address.getText());
            contactDTO.setWork_address(t_work_address.getText());
            ContactDAO.updateContact(contactDTO);

        }else{
            String first_name = t_firstname.getText();
            String lastname = t_lastname.getText();
            String home_phone = t_homephone.getText();
            String work_phone = t_workphone.getText();
            String personal_mobile = t_personal_mobile.getText();
            String work_mobile = t_work_mobile.getText();
            String home_address = t_home_address.getText();
            String work_address = t_work_address.getText();
            ContactDTO contactDTO1 = new ContactDTO(contactId, first_name, lastname, home_phone, work_phone,
                    personal_mobile, work_mobile, home_address, work_address);
            ContactDAO.insertContact(contactDTO1);
        }
        contactsListView.getItems().clear();
        contactsListView.getItems().addAll(Objects.requireNonNull(ContactDAO.findAllContacts()));
    }

    public void deleteContact() {
        ContactDAO.deleteContact(Integer.parseInt(t_contactId.getText()));
        contactsListView.getItems().clear();
        contactsListView.getItems().addAll(Objects.requireNonNull(ContactDAO.findAllContacts()));
    }

    public void searchContact() {
        ContactDAO.findContactById(Integer.parseInt(t_searchId.getText()));
        contactsListView.getItems().clear();
        contactsListView.getItems().addAll(Objects.requireNonNull(ContactDAO.findAllContacts()));

    }
        public void exitClicked(){
            System.exit(0);
        }
    }


