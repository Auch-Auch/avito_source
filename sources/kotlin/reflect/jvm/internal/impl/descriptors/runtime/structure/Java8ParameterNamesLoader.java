package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import org.jetbrains.annotations.Nullable;
public final class Java8ParameterNamesLoader {
    @Nullable
    public static Cache a;

    public static final class Cache {
        @Nullable
        public final Method a;
        @Nullable
        public final Method b;

        public Cache(@Nullable Method method, @Nullable Method method2) {
            this.a = method;
            this.b = method2;
        }

        @Nullable
        public final Method getGetName() {
            return this.b;
        }

        @Nullable
        public final Method getGetParameters() {
            return this.a;
        }
    }
}
