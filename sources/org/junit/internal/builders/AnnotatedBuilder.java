package org.junit.internal.builders;

import java.lang.reflect.Modifier;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
public class AnnotatedBuilder extends RunnerBuilder {
    public final RunnerBuilder b;

    public AnnotatedBuilder(RunnerBuilder runnerBuilder) {
        this.b = runnerBuilder;
    }

    public Runner buildRunner(Class<? extends Runner> cls, Class<?> cls2) throws Exception {
        try {
            return (Runner) cls.getConstructor(Class.class).newInstance(cls2);
        } catch (NoSuchMethodException unused) {
            try {
                return (Runner) cls.getConstructor(Class.class, RunnerBuilder.class).newInstance(cls2, this.b);
            } catch (NoSuchMethodException unused2) {
                String simpleName = cls.getSimpleName();
                throw new InitializationError(String.format("Custom runner class %s should have a public constructor with signature %s(Class testClass)", simpleName, simpleName));
            }
        }
    }

    @Override // org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class<?> cls) throws Exception {
        Class<?> cls2 = cls;
        while (cls2 != null) {
            RunWith runWith = (RunWith) cls2.getAnnotation(RunWith.class);
            if (runWith != null) {
                return buildRunner(runWith.value(), cls);
            }
            cls2 = (!cls2.isMemberClass() || Modifier.isStatic(cls2.getModifiers())) ? null : cls2.getEnclosingClass();
        }
        return null;
    }
}
