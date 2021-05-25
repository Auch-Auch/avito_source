package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
public final class TypeSystemContextKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 2, 3};

        static {
            Variance.values();
        }
    }

    @NotNull
    public static final TypeVariance convertVariance(@NotNull Variance variance) {
        Intrinsics.checkNotNullParameter(variance, "<this>");
        int ordinal = variance.ordinal();
        if (ordinal == 0) {
            return TypeVariance.INV;
        }
        if (ordinal == 1) {
            return TypeVariance.IN;
        }
        if (ordinal == 2) {
            return TypeVariance.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }
}
