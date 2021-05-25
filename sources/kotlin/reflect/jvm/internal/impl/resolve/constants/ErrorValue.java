package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.r.a.j;
public abstract class ErrorValue extends ConstantValue<Unit> {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ErrorValue create(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new ErrorValueWithMessage(str);
        }

        public Companion(j jVar) {
        }
    }

    public static final class ErrorValueWithMessage extends ErrorValue {
        @NotNull
        public final String b;

        public ErrorValueWithMessage(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.b = str;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
        @NotNull
        public String toString() {
            return this.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
        @NotNull
        public SimpleType getType(@NotNull ModuleDescriptor moduleDescriptor) {
            Intrinsics.checkNotNullParameter(moduleDescriptor, BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
            SimpleType createErrorType = ErrorUtils.createErrorType(this.b);
            Intrinsics.checkNotNullExpressionValue(createErrorType, "createErrorType(message)");
            return createErrorType;
        }
    }

    public ErrorValue() {
        super(Unit.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    @NotNull
    public Unit getValue() {
        throw new UnsupportedOperationException();
    }
}
