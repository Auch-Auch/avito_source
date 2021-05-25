package org.junit.internal.builders;

import java.util.Arrays;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;
public class AllDefaultPossibilitiesBuilder extends RunnerBuilder {
    public final boolean b;

    public AllDefaultPossibilitiesBuilder() {
        this.b = true;
    }

    public AnnotatedBuilder annotatedBuilder() {
        return new AnnotatedBuilder(this);
    }

    public IgnoredBuilder ignoredBuilder() {
        return new IgnoredBuilder();
    }

    public JUnit3Builder junit3Builder() {
        return new JUnit3Builder();
    }

    public JUnit4Builder junit4Builder() {
        return new JUnit4Builder();
    }

    @Override // org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class<?> cls) throws Throwable {
        for (RunnerBuilder runnerBuilder : Arrays.asList(ignoredBuilder(), annotatedBuilder(), suiteMethodBuilder(), junit3Builder(), junit4Builder())) {
            Runner safeRunnerForClass = runnerBuilder.safeRunnerForClass(cls);
            if (safeRunnerForClass != null) {
                return safeRunnerForClass;
            }
        }
        return null;
    }

    public RunnerBuilder suiteMethodBuilder() {
        if (this.b) {
            return new SuiteMethodBuilder();
        }
        return new NullBuilder();
    }

    @Deprecated
    public AllDefaultPossibilitiesBuilder(boolean z) {
        this.b = z;
    }
}
