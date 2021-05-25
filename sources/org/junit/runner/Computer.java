package org.junit.runner;

import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
public class Computer {

    public class a extends RunnerBuilder {
        public final /* synthetic */ RunnerBuilder b;

        public a(RunnerBuilder runnerBuilder) {
            this.b = runnerBuilder;
        }

        @Override // org.junit.runners.model.RunnerBuilder
        public Runner runnerForClass(Class<?> cls) throws Throwable {
            return Computer.this.getRunner(this.b, cls);
        }
    }

    public class b extends Suite {
        public b(Computer computer, RunnerBuilder runnerBuilder, Class[] clsArr) {
            super(runnerBuilder, clsArr);
        }

        @Override // org.junit.runners.ParentRunner
        public String getName() {
            return "classes";
        }
    }

    public static Computer serial() {
        return new Computer();
    }

    public Runner getRunner(RunnerBuilder runnerBuilder, Class<?> cls) throws Throwable {
        return runnerBuilder.runnerForClass(cls);
    }

    public Runner getSuite(RunnerBuilder runnerBuilder, Class<?>[] clsArr) throws InitializationError {
        return new b(this, new a(runnerBuilder), clsArr);
    }
}
