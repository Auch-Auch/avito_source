package org.junit.experimental.categories;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runners.model.FrameworkMethod;
import org.junit.validator.AnnotationValidator;
public final class CategoryValidator extends AnnotationValidator {
    public static final Set<Class<? extends Annotation>> b = Collections.unmodifiableSet(new HashSet(Arrays.asList(BeforeClass.class, AfterClass.class, Before.class, After.class)));

    @Override // org.junit.validator.AnnotationValidator
    public List<Exception> validateAnnotatedMethod(FrameworkMethod frameworkMethod) {
        ArrayList arrayList = new ArrayList();
        Annotation[] annotations = frameworkMethod.getAnnotations();
        for (Annotation annotation : annotations) {
            for (Class<? extends Annotation> cls : b) {
                if (annotation.annotationType().isAssignableFrom(cls)) {
                    arrayList.add(new Exception(String.format("@%s can not be combined with @Category", cls.getSimpleName())));
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}
