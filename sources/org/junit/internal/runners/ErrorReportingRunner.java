package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.InvalidTestClassError;
public class ErrorReportingRunner extends Runner {
    public final List<Throwable> a;
    public final String b;

    public ErrorReportingRunner(Class<?> cls, Throwable th) {
        this(th, cls);
    }

    public final List<Throwable> a(Throwable th) {
        if (th instanceof InvocationTargetException) {
            return a(th.getCause());
        }
        if (th instanceof InvalidTestClassError) {
            return Collections.singletonList(th);
        }
        if (th instanceof InitializationError) {
            return ((InitializationError) th).getCauses();
        }
        if (th instanceof InitializationError) {
            return ((InitializationError) th).getCauses();
        }
        return Collections.singletonList(th);
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        Description createSuiteDescription = Description.createSuiteDescription(this.b, new Annotation[0]);
        for (Throwable th : this.a) {
            createSuiteDescription.addChild(Description.createTestDescription(this.b, "initializationError", new Annotation[0]));
        }
        return createSuiteDescription;
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        for (Throwable th : this.a) {
            Description createTestDescription = Description.createTestDescription(this.b, "initializationError", new Annotation[0]);
            runNotifier.fireTestStarted(createTestDescription);
            runNotifier.fireTestFailure(new Failure(createTestDescription, th));
            runNotifier.fireTestFinished(createTestDescription);
        }
    }

    public ErrorReportingRunner(Throwable th, Class<?>... clsArr) {
        if (clsArr == null || clsArr.length == 0) {
            throw new NullPointerException("Test classes cannot be null or empty");
        }
        for (Class<?> cls : clsArr) {
            Objects.requireNonNull(cls, "Test class cannot be null");
        }
        StringBuilder sb = new StringBuilder();
        for (Class<?> cls2 : clsArr) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(cls2.getName());
        }
        this.b = sb.toString();
        this.a = a(th);
    }
}
