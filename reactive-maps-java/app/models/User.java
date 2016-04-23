package models;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.db.ebean.Model.Finder;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name="user")
public class User extends Model {
  
  /**
   * Convenience Finder for 'active record' style.
   */
  public static final Finder<Long,User> find = new Finder<>(Long.class, User.class);
    
  @OneToMany
  List<PostModel> posts;
  @Id
  UUID id; 
  
  @Column(length=100)
  String name;

  LocalDate registered;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getRegistered() {
    return registered;
  }

  public void setRegistered(LocalDate registered) {
    this.registered = registered;
  }

  public List<PostModel> getPosts() {
    return posts;
  }

// Turn into Friends eventually
//  public List<Contact> getContacts() {
//    return contacts;
//  }

//  public void setContacts(List<Contact> contacts) {
//    this.contacts = contacts;
//  }
//
//  /**
//   * Helper method to add a contact to the customer.
//   */
//  public void addContact(Contact contact) {
//    if (contacts == null) {
//      contacts = new ArrayList<>();
//    }
//    // setting the customer is automatically done when Ebean does
//    // a cascade save from customer to contacts. 
//    contact.setCustomer(this);
//    contacts.add(contact);
//  }
  
}


