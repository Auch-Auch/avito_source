package kotlin.reflect.jvm.internal.impl.types.checker;

import com.avito.android.remote.auth.AuthSource;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;
public final class StrictEqualityTypeChecker {
    @NotNull
    public static final StrictEqualityTypeChecker INSTANCE = new StrictEqualityTypeChecker();

    public final boolean strictEqualTypes(@NotNull UnwrappedType unwrappedType, @NotNull UnwrappedType unwrappedType2) {
        Intrinsics.checkNotNullParameter(unwrappedType, AuthSource.SEND_ABUSE);
        Intrinsics.checkNotNullParameter(unwrappedType2, AuthSource.BOOKING_ORDER);
        return AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(SimpleClassicTypeSystemContext.INSTANCE, unwrappedType, unwrappedType2);
    }
}
