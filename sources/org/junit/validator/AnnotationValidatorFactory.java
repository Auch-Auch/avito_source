package org.junit.validator;

import a2.b.a.a.a;
import java.util.concurrent.ConcurrentHashMap;
public class AnnotationValidatorFactory {
    public static final ConcurrentHashMap<ValidateWith, AnnotationValidator> a = new ConcurrentHashMap<>();

    public AnnotationValidator createAnnotationValidator(ValidateWith validateWith) {
        ConcurrentHashMap<ValidateWith, AnnotationValidator> concurrentHashMap = a;
        AnnotationValidator annotationValidator = concurrentHashMap.get(validateWith);
        if (annotationValidator != null) {
            return annotationValidator;
        }
        Class<? extends AnnotationValidator> value = validateWith.value();
        try {
            concurrentHashMap.putIfAbsent(validateWith, (AnnotationValidator) value.newInstance());
            return concurrentHashMap.get(validateWith);
        } catch (Exception e) {
            throw new RuntimeException(a.B2(value, a.L("Exception received when creating AnnotationValidator class ")), e);
        }
    }
}
