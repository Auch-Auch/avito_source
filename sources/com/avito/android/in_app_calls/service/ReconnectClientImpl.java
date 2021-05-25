package com.avito.android.in_app_calls.service;

import a2.b.a.a.a;
import com.avito.android.in_app_calls.service.ReconnectClient;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Cancellable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/in_app_calls/service/ReconnectClientImpl;", "Lcom/avito/android/in_app_calls/service/ReconnectClient;", "", "url", "callId", "Lio/reactivex/Single;", "", "requestReconnect", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "Lokhttp3/Call$Factory;", AuthSource.SEND_ABUSE, "Lokhttp3/Call$Factory;", "callFactory", "<init>", "(Lokhttp3/Call$Factory;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class ReconnectClientImpl implements ReconnectClient {
    public final Call.Factory a;

    public ReconnectClientImpl(@NotNull Call.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "callFactory");
        this.a = factory;
    }

    @Override // com.avito.android.in_app_calls.service.ReconnectClient
    @NotNull
    public Single<Unit> requestReconnect(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "callId");
        HttpUrl parse = HttpUrl.Companion.parse(str);
        if (parse != null) {
            Single<Unit> create = Single.create(new SingleOnSubscribe<Unit>(this, parse.newBuilder().addQueryParameter("id", str2).build()) { // from class: com.avito.android.in_app_calls.service.ReconnectClientImpl$requestReconnect$1
                public final /* synthetic */ ReconnectClientImpl a;
                public final /* synthetic */ HttpUrl b;

                public static final class a implements Cancellable {
                    public final /* synthetic */ Call a;

                    public a(Call call) {
                        this.a = call;
                    }

                    @Override // io.reactivex.functions.Cancellable
                    public final void cancel() {
                        this.a.cancel();
                    }
                }

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // io.reactivex.SingleOnSubscribe
                public final void subscribe(@NotNull final SingleEmitter<Unit> singleEmitter) {
                    Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
                    Call newCall = this.a.a.newCall(new Request.Builder().get().url(this.b).build());
                    singleEmitter.setCancellable(new a(newCall));
                    newCall.enqueue(new Callback() { // from class: com.avito.android.in_app_calls.service.ReconnectClientImpl$requestReconnect$1.2
                        @Override // okhttp3.Callback
                        public void onFailure(@NotNull Call call, @NotNull IOException iOException) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(iOException, "e");
                            SingleEmitter singleEmitter2 = singleEmitter;
                            Intrinsics.checkNotNullExpressionValue(singleEmitter2, "emitter");
                            if (!singleEmitter2.isDisposed()) {
                                singleEmitter.onError(iOException);
                            }
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: io.reactivex.SingleEmitter */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // okhttp3.Callback
                        public void onResponse(@NotNull Call call, @NotNull Response response) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(response, CommonKt.EXTRA_RESPONSE);
                            SingleEmitter singleEmitter2 = singleEmitter;
                            Intrinsics.checkNotNullExpressionValue(singleEmitter2, "emitter");
                            if (singleEmitter2.isDisposed()) {
                                return;
                            }
                            if (response.isSuccessful()) {
                                singleEmitter.onSuccess(Unit.INSTANCE);
                                return;
                            }
                            SingleEmitter singleEmitter3 = singleEmitter;
                            int code = response.code();
                            StringBuilder L = a2.b.a.a.a.L("Reconnect response returned code ");
                            L.append(response.code());
                            singleEmitter3.onError(new ReconnectClient.ReconnectRequestException(code, L.toString()));
                        }
                    });
                }
            });
            Intrinsics.checkNotNullExpressionValue(create, "Single.create<Unit> { em…}\n            )\n        }");
            return create;
        }
        Single<Unit> error = Single.error(new IllegalArgumentException(a.c3("Invalid reconnect url: ", str)));
        Intrinsics.checkNotNullExpressionValue(error, "Single.error(IllegalArgu…id reconnect url: $url\"))");
        return error;
    }
}
