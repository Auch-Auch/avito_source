package com.avito.android.advert_core.safedeal;

import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesInteractor;", "", "", "serviceID", "", "isEnabled", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "", "toggleService", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface MyAdvertSafeDealServicesInteractor {
    @NotNull
    Observable<LoadingState<Unit>> toggleService(@NotNull String str, boolean z);
}
