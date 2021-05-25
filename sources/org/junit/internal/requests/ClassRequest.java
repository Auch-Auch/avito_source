package org.junit.internal.requests;

import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.internal.builders.SuiteMethodBuilder;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;
public class ClassRequest extends x6.c.b.d.a {
    public final Class<?> c;
    public final boolean d;

    public class b extends AllDefaultPossibilitiesBuilder {
        public b(a aVar) {
        }

        @Override // org.junit.internal.builders.AllDefaultPossibilitiesBuilder
        public RunnerBuilder suiteMethodBuilder() {
            return new c(null);
        }
    }

    public class c extends SuiteMethodBuilder {
        public c(a aVar) {
        }

        @Override // org.junit.internal.builders.SuiteMethodBuilder, org.junit.runners.model.RunnerBuilder
        public Runner runnerForClass(Class<?> cls) throws Throwable {
            ClassRequest classRequest = ClassRequest.this;
            if (cls != classRequest.c || classRequest.d) {
                return super.runnerForClass(cls);
            }
            return null;
        }
    }

    public ClassRequest(Class<?> cls, boolean z) {
        this.c = cls;
        this.d = z;
    }

    @Override // x6.c.b.d.a
    public Runner createRunner() {
        return new b(null).safeRunnerForClass(this.c);
    }

    public ClassRequest(Class<?> cls) {
        this(cls, true);
    }
}
