package org.junit.validator;

import java.util.Collections;
import java.util.List;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;
public abstract class AnnotationValidator {
    public static final List<Exception> a = Collections.emptyList();

    public List<Exception> validateAnnotatedClass(TestClass testClass) {
        return a;
    }

    public List<Exception> validateAnnotatedField(FrameworkField frameworkField) {
        return a;
    }

    public List<Exception> validateAnnotatedMethod(FrameworkMethod frameworkMethod) {
        return a;
    }
}
