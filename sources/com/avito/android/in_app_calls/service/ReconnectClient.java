package com.avito.android.in_app_calls.service;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/in_app_calls/service/ReconnectClient;", "", "", "url", "callId", "Lio/reactivex/Single;", "", "requestReconnect", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "ReconnectRequestException", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface ReconnectClient {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/service/ReconnectClient$ReconnectRequestException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "", AuthSource.SEND_ABUSE, "I", "getCode", "()I", "code", "", "message", "<init>", "(ILjava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class ReconnectRequestException extends IllegalStateException {
        public final int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ReconnectRequestException(int i, @NotNull String str) {
            super(str);
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = i;
        }

        public final int getCode() {
            return this.a;
        }
    }

    @NotNull
    Single<Unit> requestReconnect(@NotNull String str, @NotNull String str2);
}
