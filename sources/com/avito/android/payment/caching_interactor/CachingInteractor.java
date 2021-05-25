package com.avito.android.payment.caching_interactor;

import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000b2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/payment/caching_interactor/CachingInteractor;", "T", "", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "forceUpdate", "", "", "nativeMethods", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "load", "(ZLjava/util/Set;)Lio/reactivex/Observable;", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public interface CachingInteractor<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.payment.caching_interactor.CachingInteractor */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable load$default(CachingInteractor cachingInteractor, boolean z, Set set, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    set = y.emptySet();
                }
                return cachingInteractor.load(z, set);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: load");
        }
    }

    @NotNull
    Observable<LoadingState<T>> load(boolean z, @NotNull Set<String> set);

    @NotNull
    Kundle onSaveState();
}
