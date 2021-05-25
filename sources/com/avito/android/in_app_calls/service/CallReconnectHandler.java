package com.avito.android.in_app_calls.service;

import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.calls_shared.AppCallResult;
import com.avito.android.in_app_calls.service.binder.CallState;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0010\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH&¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/avito/android/in_app_calls/service/CallReconnectHandler;", "", "Lcom/avito/android/calls_shared/AppCallInfo;", "call", "Lcom/avito/android/calls_shared/AppCallResult;", "result", "", "url", "", "requestReconnect", "(Lcom/avito/android/calls_shared/AppCallInfo;Lcom/avito/android/calls_shared/AppCallResult;Ljava/lang/String;)Z", "Lio/reactivex/Observable;", "clientConnectedStream", "Lcom/avito/android/in_app_calls/service/binder/CallState;", "callStateStream", "Lio/reactivex/disposables/Disposable;", "processReconnectRequests", "(Lio/reactivex/Observable;Lio/reactivex/Observable;)Lio/reactivex/disposables/Disposable;", "getReconnectFailures", "()Lio/reactivex/Observable;", "reconnectFailures", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallReconnectHandler {
    @NotNull
    Observable<String> getReconnectFailures();

    @NotNull
    Disposable processReconnectRequests(@NotNull Observable<Boolean> observable, @NotNull Observable<CallState> observable2);

    boolean requestReconnect(@NotNull AppCallInfo appCallInfo, @NotNull AppCallResult appCallResult, @Nullable String str);
}
