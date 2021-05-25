package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
public abstract class CheckResult {
    public final boolean a;

    public static final class IllegalFunctionName extends CheckResult {
        @NotNull
        public static final IllegalFunctionName INSTANCE = new IllegalFunctionName();

        public IllegalFunctionName() {
            super(false, null);
        }
    }

    public static final class IllegalSignature extends CheckResult {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IllegalSignature(@NotNull String str) {
            super(false, null);
            Intrinsics.checkNotNullParameter(str, "error");
        }
    }

    public static final class SuccessCheck extends CheckResult {
        @NotNull
        public static final SuccessCheck INSTANCE = new SuccessCheck();

        public SuccessCheck() {
            super(true, null);
        }
    }

    public CheckResult(boolean z, j jVar) {
        this.a = z;
    }

    public final boolean isSuccess() {
        return this.a;
    }
}
