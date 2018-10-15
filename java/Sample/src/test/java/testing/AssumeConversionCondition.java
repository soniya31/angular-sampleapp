package testing;


import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Optional;

import static org.junit.platform.commons.support.AnnotationSupport.findAnnotation;

public class AssumeConversionCondition implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        Optional<AssumeConversion> annotation = findAnnotation(context.getElement(), AssumeConversion.class);
        if (annotation.isPresent()) {
            AccessCQServer accessCQServer = new AccessCQServer();
            if (!accessCQServer.callCqServerForAFJsons()) {
                return ConditionEvaluationResult.disabled("Issue with the setUp. Skipping test!");
            } else {
                return ConditionEvaluationResult.enabled("Conversion Successful. Continuing test!");
            }
        }
        return ConditionEvaluationResult.enabled("No AssumeConversion annotation found. Continuing test.");
    }
}