package com.avito.android.in_app_calls.service;

import com.avito.android.in_app_calls.service.binder.CallState;
import com.avito.android.remote.CallInfo;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/in_app_calls/service/CallInfoLoader;", "", "", "callUuid", "", "requestCallInfo", "(Ljava/lang/String;)V", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/in_app_calls/service/binder/CallState;", "callStateStream", "Lio/reactivex/rxjava3/disposables/Disposable;", "processRequests", "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/disposables/Disposable;", "Lcom/avito/android/remote/CallInfo;", "getResultStream", "()Lio/reactivex/rxjava3/core/Observable;", "resultStream", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallInfoLoader {
    @NotNull
    Observable<CallInfo> getResultStream();

    @NotNull
    Disposable processRequests(@NotNull Observable<CallState> observable);

    void requestCallInfo(@NotNull String str);
}
