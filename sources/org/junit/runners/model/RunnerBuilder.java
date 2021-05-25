package org.junit.runners.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Description;
import org.junit.runner.OrderWith;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Ordering;
public abstract class RunnerBuilder {
    public final Set<Class<?>> a = new HashSet();

    public abstract Runner runnerForClass(Class<?> cls) throws Throwable;

    public List<Runner> runners(Class<?> cls, Class<?>[] clsArr) throws InitializationError {
        if (this.a.add(cls)) {
            try {
                ArrayList arrayList = new ArrayList();
                for (Class<?> cls2 : clsArr) {
                    Runner safeRunnerForClass = safeRunnerForClass(cls2);
                    if (safeRunnerForClass != null) {
                        arrayList.add(safeRunnerForClass);
                    }
                }
                return arrayList;
            } finally {
                this.a.remove(cls);
            }
        } else {
            throw new InitializationError(String.format("class '%s' (possibly indirectly) contains itself as a SuiteClass", cls.getName()));
        }
    }

    public Runner safeRunnerForClass(Class<?> cls) {
        try {
            Runner runnerForClass = runnerForClass(cls);
            if (runnerForClass != null) {
                Description description = runnerForClass.getDescription();
                OrderWith orderWith = (OrderWith) description.getAnnotation(OrderWith.class);
                if (orderWith != null) {
                    Ordering.definedBy(orderWith.value(), description).apply(runnerForClass);
                }
            }
            return runnerForClass;
        } catch (Throwable th) {
            return new ErrorReportingRunner(cls, th);
        }
    }

    public List<Runner> runners(Class<?> cls, List<Class<?>> list) throws InitializationError {
        return runners(cls, (Class[]) list.toArray(new Class[0]));
    }
}
