package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(name="user_account")
public class Accounts extends Model {

    @Id
    @Constraints.Required
    public Long acc_id;

    @Constraints.Required
    @Formats.NonEmpty
    public String email_address;

    @Constraints.Required
    @Formats.NonEmpty
    public String password;

    @Constraints.Required
    public int group_id;

    // Queries

    public static Finder<Long,Accounts> find = new Finder<Long,Accounts>(Long.class, Accounts.class);

    public static Accounts authenticate(String email_address, String password) {

        System.out.println(email_address + " " + password); // Check if form data is passed.

        return find.where()
                .eq("email_address", email_address)
                .eq("password", password)
                .findUnique();

    }

}