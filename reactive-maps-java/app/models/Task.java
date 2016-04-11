package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity 
@MappedSuperclass
public class Task extends Model {

  @Id
  @Constraints.Min(10)
  public Long id;
  
  @Constraints.Required
  public String name;
  
  public boolean done;
  
  public static Finder<Long,Task> find = new Finder<>(
    Long.class, Task.class
  ); 

}
