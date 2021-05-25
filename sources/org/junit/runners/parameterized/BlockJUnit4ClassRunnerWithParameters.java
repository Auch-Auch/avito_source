package org.junit.runners.parameterized;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Parameterized;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
public class BlockJUnit4ClassRunnerWithParameters extends BlockJUnit4ClassRunner {
    public final Object[] i;
    public final String j;

    public enum a {
        CONSTRUCTOR,
        FIELD
    }

    public class b extends RunAfters {
        public b(Statement statement, List<FrameworkMethod> list) {
            super(statement, list, null);
        }

        @Override // org.junit.internal.runners.statements.RunAfters
        public void invokeMethod(FrameworkMethod frameworkMethod) throws Throwable {
            Object[] objArr;
            if (frameworkMethod.getMethod().getParameterTypes().length == 0) {
                objArr = null;
            } else {
                objArr = BlockJUnit4ClassRunnerWithParameters.this.i;
            }
            frameworkMethod.invokeExplosively(null, objArr);
        }
    }

    public class c extends RunBefores {
        public c(Statement statement, List<FrameworkMethod> list) {
            super(statement, list, null);
        }

        @Override // org.junit.internal.runners.statements.RunBefores
        public void invokeMethod(FrameworkMethod frameworkMethod) throws Throwable {
            Object[] objArr;
            if (frameworkMethod.getMethod().getParameterTypes().length == 0) {
                objArr = null;
            } else {
                objArr = BlockJUnit4ClassRunnerWithParameters.this.i;
            }
            frameworkMethod.invokeExplosively(null, objArr);
        }
    }

    public BlockJUnit4ClassRunnerWithParameters(TestWithParameters testWithParameters) throws InitializationError {
        super(testWithParameters.getTestClass());
        this.i = testWithParameters.getParameters().toArray(new Object[testWithParameters.getParameters().size()]);
        this.j = testWithParameters.getName();
    }

    public final List<FrameworkField> c() {
        return getTestClass().getAnnotatedFields(Parameterized.Parameter.class);
    }

    @Override // org.junit.runners.ParentRunner
    public Statement classBlock(RunNotifier runNotifier) {
        Statement childrenInvoker = childrenInvoker(runNotifier);
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(Parameterized.BeforeParam.class);
        if (!annotatedMethods.isEmpty()) {
            childrenInvoker = new c(childrenInvoker, annotatedMethods);
        }
        List<FrameworkMethod> annotatedMethods2 = getTestClass().getAnnotatedMethods(Parameterized.AfterParam.class);
        return annotatedMethods2.isEmpty() ? childrenInvoker : new b(childrenInvoker, annotatedMethods2);
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public Object createTest() throws Exception {
        a d = d();
        int ordinal = d.ordinal();
        if (ordinal == 0) {
            return getTestClass().getOnlyConstructor().newInstance(this.i);
        }
        if (ordinal == 1) {
            List<FrameworkField> c2 = c();
            if (c2.size() == this.i.length) {
                Object newInstance = getTestClass().getJavaClass().newInstance();
                for (FrameworkField frameworkField : c2) {
                    Field field = frameworkField.getField();
                    int value = ((Parameterized.Parameter) field.getAnnotation(Parameterized.Parameter.class)).value();
                    try {
                        field.set(newInstance, this.i[value]);
                    } catch (IllegalAccessException e) {
                        StringBuilder L = a2.b.a.a.a.L("Cannot set parameter '");
                        L.append(field.getName());
                        L.append("'. Ensure that the field '");
                        L.append(field.getName());
                        L.append("' is public.");
                        IllegalAccessException illegalAccessException = new IllegalAccessException(L.toString());
                        illegalAccessException.initCause(e);
                        throw illegalAccessException;
                    } catch (IllegalArgumentException e2) {
                        throw new Exception(getTestClass().getName() + ": Trying to set " + field.getName() + " with the value " + this.i[value] + " that is not the right type (" + this.i[value].getClass().getSimpleName() + " instead of " + field.getType().getSimpleName() + ").", e2);
                    }
                }
                return newInstance;
            }
            StringBuilder L2 = a2.b.a.a.a.L("Wrong number of parameters and @Parameter fields. @Parameter fields counted: ");
            L2.append(c2.size());
            L2.append(", available parameters: ");
            throw new Exception(a2.b.a.a.a.j(L2, this.i.length, "."));
        }
        throw new IllegalStateException("The injection type " + d + " is not supported.");
    }

    public final a d() {
        if (!c().isEmpty()) {
            return a.FIELD;
        }
        return a.CONSTRUCTOR;
    }

    @Override // org.junit.runners.ParentRunner
    public String getName() {
        return this.j;
    }

    @Override // org.junit.runners.ParentRunner
    public Annotation[] getRunnerAnnotations() {
        Annotation[] runnerAnnotations = super.getRunnerAnnotations();
        Annotation[] annotationArr = new Annotation[(runnerAnnotations.length - 1)];
        int i2 = 0;
        for (Annotation annotation : runnerAnnotations) {
            if (!annotation.annotationType().equals(RunWith.class)) {
                annotationArr[i2] = annotation;
                i2++;
            }
        }
        return annotationArr;
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public String testName(FrameworkMethod frameworkMethod) {
        return frameworkMethod.getName() + getName();
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public void validateConstructor(List<Throwable> list) {
        validateOnlyOneConstructor(list);
        if (d() != a.CONSTRUCTOR) {
            validateZeroArgConstructor(list);
        }
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public void validateFields(List<Throwable> list) {
        super.validateFields(list);
        if (d() == a.FIELD) {
            List<FrameworkField> c2 = c();
            int size = c2.size();
            int[] iArr = new int[size];
            for (FrameworkField frameworkField : c2) {
                int value = ((Parameterized.Parameter) frameworkField.getField().getAnnotation(Parameterized.Parameter.class)).value();
                if (value < 0 || value > c2.size() - 1) {
                    StringBuilder M = a2.b.a.a.a.M("Invalid @Parameter value: ", value, ". @Parameter fields counted: ");
                    M.append(c2.size());
                    M.append(". Please use an index between 0 and ");
                    M.append(c2.size() - 1);
                    M.append(".");
                    list.add(new Exception(M.toString()));
                } else {
                    iArr[value] = iArr[value] + 1;
                }
            }
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (i3 == 0) {
                    list.add(new Exception(a2.b.a.a.a.Q2("@Parameter(", i2, ") is never used.")));
                } else if (i3 > 1) {
                    list.add(new Exception(a2.b.a.a.a.S2("@Parameter(", i2, ") is used more than once (", i3, ").")));
                }
            }
        }
    }
}
