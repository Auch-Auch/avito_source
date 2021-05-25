package org.junit.runners;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;
import org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParametersFactory;
import org.junit.runners.parameterized.ParametersRunnerFactory;
import org.junit.runners.parameterized.TestWithParameters;
public class Parameterized extends Suite {

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AfterParam {
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface BeforeParam {
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Parameter {
        int value() default 0;
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Parameters {
        String name() default "{index}";
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UseParametersRunnerFactory {
        Class<? extends ParametersRunnerFactory> value() default BlockJUnit4ClassRunnerWithParametersFactory.class;
    }

    public static class b extends Runner {
        public final Description a;
        public final AssumptionViolatedException b;

        public b(TestClass testClass, String str, AssumptionViolatedException assumptionViolatedException) {
            Class<?> javaClass = testClass.getJavaClass();
            this.a = Description.createTestDescription(javaClass, str + "() assumption violation");
            this.b = assumptionViolatedException;
        }

        @Override // org.junit.runner.Runner, org.junit.runner.Describable
        public Description getDescription() {
            return this.a;
        }

        @Override // org.junit.runner.Runner
        public void run(RunNotifier runNotifier) {
            runNotifier.fireTestAssumptionFailed(new Failure(this.a, this.b));
        }
    }

    public static class c {
        public static final ParametersRunnerFactory f = new BlockJUnit4ClassRunnerWithParametersFactory();
        public final TestClass a;
        public final FrameworkMethod b;
        public final List<Object> c;
        public final int d;
        public final Runner e;

        public c(Class cls, a aVar) throws Throwable {
            List<Object> list;
            TestClass testClass = new TestClass(cls);
            this.a = testClass;
            for (FrameworkMethod frameworkMethod : testClass.getAnnotatedMethods(Parameters.class)) {
                if (frameworkMethod.isStatic() && frameworkMethod.isPublic()) {
                    this.b = frameworkMethod;
                    b bVar = null;
                    try {
                        list = a(this.a, frameworkMethod);
                    } catch (AssumptionViolatedException e2) {
                        list = Collections.emptyList();
                        bVar = new b(this.a, this.b.getName(), e2);
                    }
                    this.c = list;
                    this.e = bVar;
                    int i = 0;
                    if (!list.isEmpty()) {
                        Object obj = list.get(0);
                        i = (obj instanceof Object[] ? (Object[]) obj : new Object[]{obj}).length;
                    }
                    this.d = i;
                    return;
                }
            }
            StringBuilder L = a2.b.a.a.a.L("No public static parameters method on class ");
            L.append(testClass.getName());
            throw new Exception(L.toString());
        }

        public static List<Object> a(TestClass testClass, FrameworkMethod frameworkMethod) throws Throwable {
            Object invokeExplosively = frameworkMethod.invokeExplosively(null, new Object[0]);
            if (invokeExplosively instanceof List) {
                return (List) invokeExplosively;
            }
            if (invokeExplosively instanceof Collection) {
                return new ArrayList((Collection) invokeExplosively);
            }
            if (invokeExplosively instanceof Iterable) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : (Iterable) invokeExplosively) {
                    arrayList.add(obj);
                }
                return arrayList;
            } else if (invokeExplosively instanceof Object[]) {
                return Arrays.asList((Object[]) invokeExplosively);
            } else {
                throw c(testClass, frameworkMethod);
            }
        }

        public static Exception c(TestClass testClass, FrameworkMethod frameworkMethod) throws Exception {
            return new Exception(MessageFormat.format("{0}.{1}() must return an Iterable of arrays.", testClass.getName(), frameworkMethod.getName()));
        }

        public final List<TestWithParameters> b(Iterable<Object> iterable, String str) throws Exception {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object obj : iterable) {
                int i2 = i + 1;
                Object[] objArr = obj instanceof Object[] ? (Object[]) obj : new Object[]{obj};
                arrayList.add(new TestWithParameters(a2.b.a.a.a.e3("[", MessageFormat.format(str.replaceAll("\\{index\\}", Integer.toString(i)), objArr), "]"), this.a, Arrays.asList(objArr)));
                i = i2;
            }
            return arrayList;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Parameterized(java.lang.Class<?> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            org.junit.runners.Parameterized$c r0 = new org.junit.runners.Parameterized$c
            r1 = 0
            r0.<init>(r6, r1)
            org.junit.runner.Runner r1 = r0.e
            if (r1 == 0) goto L_0x000f
            java.util.List r1 = java.util.Collections.singletonList(r1)
            goto L_0x005f
        L_0x000f:
            org.junit.runners.model.FrameworkMethod r1 = r0.b
            java.lang.Class<org.junit.runners.Parameterized$Parameters> r2 = org.junit.runners.Parameterized.Parameters.class
            java.lang.annotation.Annotation r1 = r1.getAnnotation(r2)
            org.junit.runners.Parameterized$Parameters r1 = (org.junit.runners.Parameterized.Parameters) r1
            java.util.List<java.lang.Object> r2 = r0.c
            java.lang.String r1 = r1.name()
            org.junit.runners.model.TestClass r3 = r0.a
            java.lang.Class<org.junit.runners.Parameterized$UseParametersRunnerFactory> r4 = org.junit.runners.Parameterized.UseParametersRunnerFactory.class
            java.lang.annotation.Annotation r3 = r3.getAnnotation(r4)
            org.junit.runners.Parameterized$UseParametersRunnerFactory r3 = (org.junit.runners.Parameterized.UseParametersRunnerFactory) r3
            if (r3 != 0) goto L_0x002e
            org.junit.runners.parameterized.ParametersRunnerFactory r3 = org.junit.runners.Parameterized.c.f
            goto L_0x0038
        L_0x002e:
            java.lang.Class r3 = r3.value()
            java.lang.Object r3 = r3.newInstance()
            org.junit.runners.parameterized.ParametersRunnerFactory r3 = (org.junit.runners.parameterized.ParametersRunnerFactory) r3
        L_0x0038:
            java.util.List r1 = r0.b(r2, r1)     // Catch:{ ClassCastException -> 0x008c }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ ClassCastException -> 0x008c }
            r2.<init>()     // Catch:{ ClassCastException -> 0x008c }
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0047:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x005b
            java.lang.Object r4 = r1.next()
            org.junit.runners.parameterized.TestWithParameters r4 = (org.junit.runners.parameterized.TestWithParameters) r4
            org.junit.runner.Runner r4 = r3.createRunnerForTestWithParameters(r4)
            r2.add(r4)
            goto L_0x0047
        L_0x005b:
            java.util.List r1 = java.util.Collections.unmodifiableList(r2)
        L_0x005f:
            r5.<init>(r6, r1)
            int r6 = r0.d
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Class<org.junit.runners.Parameterized$BeforeParam> r1 = org.junit.runners.Parameterized.BeforeParam.class
            r5.b(r1, r6, r0)
            java.lang.Class<org.junit.runners.Parameterized$AfterParam> r1 = org.junit.runners.Parameterized.AfterParam.class
            r5.b(r1, r6, r0)
            boolean r6 = r0.isEmpty()
            if (r6 == 0) goto L_0x007e
            return
        L_0x007e:
            org.junit.runners.model.InvalidTestClassError r6 = new org.junit.runners.model.InvalidTestClassError
            org.junit.runners.model.TestClass r1 = r5.getTestClass()
            java.lang.Class r1 = r1.getJavaClass()
            r6.<init>(r1, r0)
            throw r6
        L_0x008c:
            org.junit.runners.model.TestClass r6 = r0.a
            org.junit.runners.model.FrameworkMethod r0 = r0.b
            java.lang.Exception r6 = org.junit.runners.Parameterized.c.c(r6, r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.runners.Parameterized.<init>(java.lang.Class):void");
    }

    public final void b(Class<? extends Annotation> cls, Integer num, List<Throwable> list) {
        int length;
        for (FrameworkMethod frameworkMethod : getTestClass().getAnnotatedMethods(cls)) {
            frameworkMethod.validatePublicVoid(true, list);
            if (!(num == null || (length = frameworkMethod.getMethod().getParameterTypes().length) == 0 || length == num.intValue())) {
                StringBuilder L = a2.b.a.a.a.L("Method ");
                L.append(frameworkMethod.getName());
                L.append("() should have 0 or ");
                L.append(num);
                L.append(" parameter(s)");
                list.add(new Exception(L.toString()));
            }
        }
    }
}
