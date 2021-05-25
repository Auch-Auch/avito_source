package org.junit.experimental.theories;

import a2.b.a.a.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.internal.Assignments;
import org.junit.experimental.theories.internal.ParameterizedAssertionError;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;
public class Theories extends BlockJUnit4ClassRunner {

    public static class TheoryAnchor extends Statement {
        public int a = 0;
        public final FrameworkMethod b;
        public final TestClass c;
        public List<AssumptionViolatedException> d = new ArrayList();

        public class a extends BlockJUnit4ClassRunner {
            public final /* synthetic */ Assignments i;

            /* renamed from: org.junit.experimental.theories.Theories$TheoryAnchor$a$a  reason: collision with other inner class name */
            public class C0547a extends Statement {
                public final /* synthetic */ Statement a;

                public C0547a(Statement statement) {
                    this.a = statement;
                }

                @Override // org.junit.runners.model.Statement
                public void evaluate() throws Throwable {
                    try {
                        this.a.evaluate();
                        TheoryAnchor.this.handleDataPointSuccess();
                    } catch (AssumptionViolatedException e) {
                        TheoryAnchor.this.handleAssumptionViolation(e);
                    } catch (Throwable th) {
                        a aVar = a.this;
                        TheoryAnchor theoryAnchor = TheoryAnchor.this;
                        theoryAnchor.reportParameterizedError(th, aVar.i.getArgumentStrings(TheoryAnchor.a(theoryAnchor)));
                    }
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(TestClass testClass, Assignments assignments) {
                super(testClass);
                this.i = assignments;
            }

            @Override // org.junit.runners.BlockJUnit4ClassRunner, org.junit.runners.ParentRunner
            public void collectInitializationErrors(List<Throwable> list) {
            }

            @Override // org.junit.runners.BlockJUnit4ClassRunner
            public Object createTest() throws Exception {
                Object[] constructorArguments = this.i.getConstructorArguments();
                if (!TheoryAnchor.a(TheoryAnchor.this)) {
                    Assume.assumeNotNull(constructorArguments);
                }
                return getTestClass().getOnlyConstructor().newInstance(constructorArguments);
            }

            @Override // org.junit.runners.BlockJUnit4ClassRunner
            public Statement methodBlock(FrameworkMethod frameworkMethod) {
                return new C0547a(super.methodBlock(frameworkMethod));
            }

            @Override // org.junit.runners.BlockJUnit4ClassRunner
            public Statement methodInvoker(FrameworkMethod frameworkMethod, Object obj) {
                TheoryAnchor theoryAnchor = TheoryAnchor.this;
                Assignments assignments = this.i;
                Objects.requireNonNull(theoryAnchor);
                return new x6.c.a.d.a(theoryAnchor, assignments, frameworkMethod, obj);
            }
        }

        public TheoryAnchor(FrameworkMethod frameworkMethod, TestClass testClass) {
            this.b = frameworkMethod;
            this.c = testClass;
        }

        public static boolean a(TheoryAnchor theoryAnchor) {
            Theory theory = (Theory) theoryAnchor.b.getMethod().getAnnotation(Theory.class);
            if (theory == null) {
                return false;
            }
            return theory.nullsAccepted();
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() throws Throwable {
            runWithAssignment(Assignments.allUnassigned(this.b.getMethod(), this.c));
            boolean z = this.b.getAnnotation(Theory.class) != null;
            if (this.a == 0 && z) {
                StringBuilder L = a2.b.a.a.a.L("Never found parameters that satisfied method assumptions.  Violated assumptions: ");
                L.append(this.d);
                Assert.fail(L.toString());
            }
        }

        public void handleAssumptionViolation(AssumptionViolatedException assumptionViolatedException) {
            this.d.add(assumptionViolatedException);
        }

        public void handleDataPointSuccess() {
            this.a++;
        }

        public void reportParameterizedError(Throwable th, Object... objArr) throws Throwable {
            if (objArr.length == 0) {
                throw th;
            }
            throw new ParameterizedAssertionError(th, this.b.getName(), objArr);
        }

        public void runWithAssignment(Assignments assignments) throws Throwable {
            if (!assignments.isComplete()) {
                runWithIncompleteAssignment(assignments);
            } else {
                runWithCompleteAssignment(assignments);
            }
        }

        public void runWithCompleteAssignment(Assignments assignments) throws Throwable {
            new a(this.c, assignments).methodBlock(this.b).evaluate();
        }

        public void runWithIncompleteAssignment(Assignments assignments) throws Throwable {
            for (PotentialAssignment potentialAssignment : assignments.potentialsForNextUnassigned()) {
                runWithAssignment(assignments.assignNext(potentialAssignment));
            }
        }
    }

    public Theories(Class<?> cls) throws InitializationError {
        super(cls);
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner, org.junit.runners.ParentRunner
    public void collectInitializationErrors(List<Throwable> list) {
        super.collectInitializationErrors(list);
        Field[] declaredFields = getTestClass().getJavaClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(DataPoint.class) != null || field.getAnnotation(DataPoints.class) != null) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    StringBuilder L = a.L("DataPoint field ");
                    L.append(field.getName());
                    L.append(" must be static");
                    list.add(new Error(L.toString()));
                }
                if (!Modifier.isPublic(field.getModifiers())) {
                    StringBuilder L2 = a.L("DataPoint field ");
                    L2.append(field.getName());
                    L2.append(" must be public");
                    list.add(new Error(L2.toString()));
                }
            }
        }
        Method[] declaredMethods = getTestClass().getJavaClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.getAnnotation(DataPoint.class) != null || method.getAnnotation(DataPoints.class) != null) {
                if (!Modifier.isStatic(method.getModifiers())) {
                    StringBuilder L3 = a.L("DataPoint method ");
                    L3.append(method.getName());
                    L3.append(" must be static");
                    list.add(new Error(L3.toString()));
                }
                if (!Modifier.isPublic(method.getModifiers())) {
                    StringBuilder L4 = a.L("DataPoint method ");
                    L4.append(method.getName());
                    L4.append(" must be public");
                    list.add(new Error(L4.toString()));
                }
            }
        }
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public List<FrameworkMethod> computeTestMethods() {
        ArrayList arrayList = new ArrayList(super.computeTestMethods());
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(Theory.class);
        arrayList.removeAll(annotatedMethods);
        arrayList.addAll(annotatedMethods);
        return arrayList;
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public Statement methodBlock(FrameworkMethod frameworkMethod) {
        return new TheoryAnchor(frameworkMethod, getTestClass());
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public void validateConstructor(List<Throwable> list) {
        validateOnlyOneConstructor(list);
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public void validateTestMethods(List<Throwable> list) {
        for (FrameworkMethod frameworkMethod : computeTestMethods()) {
            if (frameworkMethod.getAnnotation(Theory.class) != null) {
                frameworkMethod.validatePublicVoid(false, list);
                frameworkMethod.validateNoTypeParametersOnArgs(list);
            } else {
                frameworkMethod.validatePublicVoidNoArg(false, list);
            }
            Iterator<ParameterSignature> it = ParameterSignature.signatures(frameworkMethod.getMethod()).iterator();
            while (it.hasNext()) {
                ParametersSuppliedBy parametersSuppliedBy = (ParametersSuppliedBy) it.next().findDeepAnnotation(ParametersSuppliedBy.class);
                if (parametersSuppliedBy != null) {
                    Class<? extends ParameterSupplier> value = parametersSuppliedBy.value();
                    Constructor<?>[] constructors = value.getConstructors();
                    if (constructors.length != 1) {
                        list.add(new Error(a.D2(value, a.L("ParameterSupplier "), " must have only one constructor (either empty or taking only a TestClass)")));
                    } else {
                        Class<?>[] parameterTypes = constructors[0].getParameterTypes();
                        if (parameterTypes.length != 0 && !parameterTypes[0].equals(TestClass.class)) {
                            list.add(new Error(a.D2(value, a.L("ParameterSupplier "), " constructor must take either nothing or a single TestClass instance")));
                        }
                    }
                }
            }
        }
    }

    public Theories(TestClass testClass) throws InitializationError {
        super(testClass);
    }
}
