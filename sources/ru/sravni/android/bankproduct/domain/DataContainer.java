package ru.sravni.android.bankproduct.domain;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u001b\u0012\b\u0010\r\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00018\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/domain/DataContainer;", "T", "", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "getError", "()Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "error", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "value", "<init>", "(Ljava/lang/Object;Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DataContainer<T> {
    @Nullable
    public final T a;
    @Nullable
    public final SravniError b;

    public DataContainer(@Nullable T t, @Nullable SravniError sravniError) {
        this.a = t;
        this.b = sravniError;
    }

    @Nullable
    public final SravniError getError() {
        return this.b;
    }

    @Nullable
    public final T getValue() {
        return this.a;
    }
}
