package org.junit.experimental;

import org.junit.runner.Computer;
import org.junit.runner.Runner;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
import x6.c.a.a;
public class ParallelComputer extends Computer {
    public final boolean a;
    public final boolean b;

    public ParallelComputer(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public static Computer classes() {
        return new ParallelComputer(true, false);
    }

    public static Computer methods() {
        return new ParallelComputer(false, true);
    }

    @Override // org.junit.runner.Computer
    public Runner getRunner(RunnerBuilder runnerBuilder, Class<?> cls) throws Throwable {
        Runner runner = super.getRunner(runnerBuilder, cls);
        if (this.b && (runner instanceof ParentRunner)) {
            ((ParentRunner) runner).setScheduler(new a());
        }
        return runner;
    }

    @Override // org.junit.runner.Computer
    public Runner getSuite(RunnerBuilder runnerBuilder, Class<?>[] clsArr) throws InitializationError {
        Runner suite = super.getSuite(runnerBuilder, clsArr);
        if (this.a && (suite instanceof ParentRunner)) {
            ((ParentRunner) suite).setScheduler(new a());
        }
        return suite;
    }
}
