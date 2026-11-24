package stage.ifm.aspects;

import stage.ifm.entities.Agent;
import stage.ifm.entities.Transaction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) // Appliquer selement sur les methodes
public @interface Cachable {
}
