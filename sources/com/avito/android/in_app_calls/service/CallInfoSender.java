package com.avito.android.in_app_calls.service;

import io.reactivex.rxjava3.core.Completable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/in_app_calls/service/CallInfoSender;", "", "", "callId", "itemId", "caller", "recepient", "Lio/reactivex/rxjava3/core/Completable;", "sendCallInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallInfoSender {
    @NotNull
    Completable sendCallInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);
}
