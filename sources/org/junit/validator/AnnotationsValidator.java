package org.junit.validator;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.junit.runners.model.Annotatable;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;
public final class AnnotationsValidator implements TestClassValidator {
    public static final List<b<?>> a = Arrays.asList(new c(null), new e(null), new d(null));

    public static abstract class b<T extends Annotatable> {
        public static final AnnotationValidatorFactory a = new AnnotationValidatorFactory();

        public b() {
        }

        public abstract Iterable<T> a(TestClass testClass);

        public abstract List<Exception> b(AnnotationValidator annotationValidator, T t);

        public b(a aVar) {
        }
    }

    public static class c extends b<TestClass> {
        public c(a aVar) {
            super(null);
        }

        @Override // org.junit.validator.AnnotationsValidator.b
        public Iterable<TestClass> a(TestClass testClass) {
            return Collections.singletonList(testClass);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [org.junit.validator.AnnotationValidator, org.junit.runners.model.Annotatable] */
        @Override // org.junit.validator.AnnotationsValidator.b
        public List b(AnnotationValidator annotationValidator, TestClass testClass) {
            return annotationValidator.validateAnnotatedClass(testClass);
        }
    }

    public static class d extends b<FrameworkField> {
        public d(a aVar) {
            super(null);
        }

        @Override // org.junit.validator.AnnotationsValidator.b
        public Iterable<FrameworkField> a(TestClass testClass) {
            return testClass.getAnnotatedFields();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [org.junit.validator.AnnotationValidator, org.junit.runners.model.Annotatable] */
        @Override // org.junit.validator.AnnotationsValidator.b
        public List b(AnnotationValidator annotationValidator, FrameworkField frameworkField) {
            return annotationValidator.validateAnnotatedField(frameworkField);
        }
    }

    public static class e extends b<FrameworkMethod> {
        public e(a aVar) {
            super(null);
        }

        @Override // org.junit.validator.AnnotationsValidator.b
        public Iterable<FrameworkMethod> a(TestClass testClass) {
            return testClass.getAnnotatedMethods();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [org.junit.validator.AnnotationValidator, org.junit.runners.model.Annotatable] */
        @Override // org.junit.validator.AnnotationsValidator.b
        public List b(AnnotationValidator annotationValidator, FrameworkMethod frameworkMethod) {
            return annotationValidator.validateAnnotatedMethod(frameworkMethod);
        }
    }

    @Override // org.junit.validator.TestClassValidator
    public List<Exception> validateTestClass(TestClass testClass) {
        ArrayList arrayList = new ArrayList();
        for (b<?> bVar : a) {
            Objects.requireNonNull(bVar);
            ArrayList arrayList2 = new ArrayList();
            Iterator<?> it = bVar.a(testClass).iterator();
            while (it.hasNext()) {
                Annotatable annotatable = (Annotatable) it.next();
                ArrayList arrayList3 = new ArrayList();
                for (Annotation annotation : annotatable.getAnnotations()) {
                    ValidateWith validateWith = (ValidateWith) annotation.annotationType().getAnnotation(ValidateWith.class);
                    if (validateWith != null) {
                        arrayList3.addAll(bVar.b(b.a.createAnnotationValidator(validateWith), annotatable));
                    }
                }
                arrayList2.addAll(arrayList3);
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }
}
