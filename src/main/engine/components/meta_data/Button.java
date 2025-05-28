import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RUNTIME)
@Target(FIELD)
@interface Button {
  String label() default "";

  String action(); // method that is called when clicked, or pressed with keyEvent
}
