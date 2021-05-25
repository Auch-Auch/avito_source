package com.avito.android.in_app_calls.service;

import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/in_app_calls/service/SystemCallStateProvider;", "", "", "isIdle", "()Z", "isOffHook", "Lio/reactivex/Observable;", "offHookStateChanges", "()Lio/reactivex/Observable;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface SystemCallStateProvider {
    boolean isIdle();

    boolean isOffHook();

    @NotNull
    Observable<Boolean> offHookStateChanges();
}
