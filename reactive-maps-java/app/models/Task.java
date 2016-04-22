package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
@Table(name="zy")
public class Task {

  @Id
  public Long id;

  @Required
  public String label;


}