package org.junit.runners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
public class Suite extends ParentRunner<Runner> {
    public final List<Runner> f;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SuiteClasses {
        Class<?>[] value();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Suite(java.lang.Class<?> r3, org.junit.runners.model.RunnerBuilder r4) throws org.junit.runners.model.InitializationError {
        /*
            r2 = this;
            java.lang.Class<org.junit.runners.Suite$SuiteClasses> r0 = org.junit.runners.Suite.SuiteClasses.class
            java.lang.annotation.Annotation r0 = r3.getAnnotation(r0)
            org.junit.runners.Suite$SuiteClasses r0 = (org.junit.runners.Suite.SuiteClasses) r0
            if (r0 == 0) goto L_0x0012
            java.lang.Class[] r0 = r0.value()
            r2.<init>(r4, r3, r0)
            return
        L_0x0012:
            org.junit.runners.model.InitializationError r4 = new org.junit.runners.model.InitializationError
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            java.lang.String r3 = r3.getName()
            r0[r1] = r3
            java.lang.String r3 = "class '%s' must have a SuiteClasses annotation"
            java.lang.String r3 = java.lang.String.format(r3, r0)
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.runners.Suite.<init>(java.lang.Class, org.junit.runners.model.RunnerBuilder):void");
    }

    public static Runner emptySuite() {
        try {
            return new Suite((Class<?>) null, new Class[0]);
        } catch (InitializationError unused) {
            throw new RuntimeException("This shouldn't be possible");
        }
    }

    @Override // org.junit.runners.ParentRunner
    public List<Runner> getChildren() {
        return this.f;
    }

    public Description describeChild(Runner runner) {
        return runner.getDescription();
    }

    public void runChild(Runner runner, RunNotifier runNotifier) {
        runner.run(runNotifier);
    }

    public Suite(RunnerBuilder runnerBuilder, Class<?>[] clsArr) throws InitializationError {
        this((Class<?>) null, runnerBuilder.runners((Class<?>) null, clsArr));
    }

    public Suite(Class<?> cls, Class<?>[] clsArr) throws InitializationError {
        this(new AllDefaultPossibilitiesBuilder(), cls, clsArr);
    }

    public Suite(RunnerBuilder runnerBuilder, Class<?> cls, Class<?>[] clsArr) throws InitializationError {
        this(cls, runnerBuilder.runners(cls, clsArr));
    }

    public Suite(Class<?> cls, List<Runner> list) throws InitializationError {
        super(cls);
        this.f = Collections.unmodifiableList(list);
    }
}
