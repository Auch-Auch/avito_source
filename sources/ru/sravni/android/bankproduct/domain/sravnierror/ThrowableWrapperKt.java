package ru.sravni.android.bankproduct.domain.sravnierror;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\f\"\u0019\u0010\u0005\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u0010\b\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\u0004\"\u0019\u0010\u000b\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0004¨\u0006\f"}, d2 = {"Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "getNULL_THROWABLE_ERROR", "()Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "NULL_THROWABLE_ERROR", "c", "getDEFAULT_THROWABLE_ERROR", "DEFAULT_THROWABLE_ERROR", AuthSource.BOOKING_ORDER, "getDEFAULT_SRAVNI_ERROR", "DEFAULT_SRAVNI_ERROR", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class ThrowableWrapperKt {
    @NotNull
    public static final ErrorDescription a = new ErrorDescription(2, "null-error", "null error and value in container", null, 8, null);
    @NotNull
    public static final ErrorDescription b = new ErrorDescription(1, "default", "default error wrap", null, 8, null);
    @NotNull
    public static final ErrorDescription c = new ErrorDescription(0, "raw-default", "default throwable wrap", null, 8, null);

    @NotNull
    public static final ErrorDescription getDEFAULT_SRAVNI_ERROR() {
        return b;
    }

    @NotNull
    public static final ErrorDescription getDEFAULT_THROWABLE_ERROR() {
        return c;
    }

    @NotNull
    public static final ErrorDescription getNULL_THROWABLE_ERROR() {
        return a;
    }
}
