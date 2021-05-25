package com.avito.android.async_phone;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/async_phone/AsyncPhoneView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "showPhoneLoadError", "()Lio/reactivex/rxjava3/core/Observable;", "dismissPhoneLoadError", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface AsyncPhoneView {
    void dismissPhoneLoadError();

    @NotNull
    Observable<Unit> showPhoneLoadError();
}
