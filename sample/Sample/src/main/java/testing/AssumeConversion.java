package testing;


import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
@ExtendWith(AssumeConversionCondition.class)
public @interface AssumeConversion {

}