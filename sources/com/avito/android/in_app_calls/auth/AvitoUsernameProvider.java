package com.avito.android.in_app_calls.auth;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.OptionKt;
import arrow.core.Some;
import com.avito.android.calls.CredentialsStorage;
import com.avito.android.calls.auth.UsernameProvider;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.tracker.errors.CallApiRequestException;
import com.avito.android.calls_shared.utils.ApiUtilsKt;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.auth.AvitoUsernameProvider;
import com.avito.android.remote.CallClientCredentialsResult;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/in_app_calls/auth/AvitoUsernameProvider;", "Lcom/avito/android/calls/auth/UsernameProvider;", "Lio/reactivex/rxjava3/core/Single;", "", "getUsername", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/calls/remote/CallsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls/remote/CallsApi;", "callsApi", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/calls/CredentialsStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls/CredentialsStorage;", "credentialStorage", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "d", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "<init>", "(Lcom/avito/android/calls/remote/CallsApi;Lcom/avito/android/calls/CredentialsStorage;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/communications_common/analytics/ErrorTracker;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoUsernameProvider implements UsernameProvider {
    public final CallsApi a;
    public final CredentialsStorage b;
    public final SchedulersFactory3 c;
    public final ErrorTracker d;

    public static final class a<V> implements Callable<Option<? extends String>> {
        public final /* synthetic */ AvitoUsernameProvider a;

        public a(AvitoUsernameProvider avitoUsernameProvider) {
            this.a = avitoUsernameProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Option<? extends String> call() {
            String username = this.a.b.getUsername();
            String str = null;
            if (username != null) {
                if (m.isBlank(username)) {
                    username = null;
                }
                str = username;
            }
            return OptionKt.toOption(str);
        }
    }

    public static final class b<T, R> implements Function<CallClientCredentialsResult, SingleSource<? extends String>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends String> apply(CallClientCredentialsResult callClientCredentialsResult) {
            String login = callClientCredentialsResult.getLogin();
            if (login == null || m.isBlank(login)) {
                return Single.error(new CallApiRequestException("Can't retrieve login from backend", null));
            }
            return Single.just(login);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ AvitoUsernameProvider a;

        public c(AvitoUsernameProvider avitoUsernameProvider) {
            this.a = avitoUsernameProvider;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            ErrorTracker.DefaultImpls.track$default(this.a.d, new CallApiRequestException("Can't get username", th), null, null, 6, null);
        }
    }

    @Inject
    public AvitoUsernameProvider(@NotNull CallsApi callsApi, @NotNull CredentialsStorage credentialsStorage, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ErrorTracker errorTracker) {
        Intrinsics.checkNotNullParameter(callsApi, "callsApi");
        Intrinsics.checkNotNullParameter(credentialsStorage, "credentialStorage");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        this.a = callsApi;
        this.b = credentialsStorage;
        this.c = schedulersFactory3;
        this.d = errorTracker;
    }

    @Override // com.avito.android.calls.auth.UsernameProvider
    @NotNull
    public Single<String> getUsername() {
        Single fromCallable = Single.fromCallable(new a(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …ll }.toOption()\n        }");
        Single flatMap = fromCallable.flatMap(new Function<Option<? extends T>, SingleSource<? extends R>>(this) { // from class: com.avito.android.in_app_calls.auth.AvitoUsernameProvider$getUsername$$inlined$flatMapFold$1
            public final /* synthetic */ AvitoUsernameProvider a;

            {
                this.a = r1;
            }

            public final SingleSource<? extends R> apply(Option<? extends T> option) {
                if (option instanceof None) {
                    Single<TypedResult<CallClientCredentialsResult>> retryWhen = this.a.a.getCallClientCredentials().observeOn(this.a.c.io()).retryWhen(ApiUtilsKt.inAppCallsExponentialRetry$default(this.a.c, null, 2, null));
                    Intrinsics.checkNotNullExpressionValue(retryWhen, "callsApi.getCallClientCr…nentialRetry(schedulers))");
                    Single<R> flatMap2 = retryWhen.flatMap(AvitoUsernameProvider$$special$$inlined$toTyped$1.INSTANCE);
                    Intrinsics.checkNotNullExpressionValue(flatMap2, "flatMap { it.toTypedSingle() }");
                    Single<R> flatMap3 = flatMap2.flatMap(AvitoUsernameProvider.b.a);
                    Intrinsics.checkNotNullExpressionValue(flatMap3, "callsApi.getCallClientCr…  }\n                    }");
                    return flatMap3;
                } else if (option instanceof Some) {
                    Single just = Single.just((String) ((Some) option).getT());
                    Intrinsics.checkNotNullExpressionValue(just, "Single.just(it)");
                    return just;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            @Override // io.reactivex.rxjava3.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Option) ((Option) obj));
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.fold(ifEmpty, some) }");
        Single<String> doOnError = flatMap.doOnError(new c(this));
        Intrinsics.checkNotNullExpressionValue(doOnError, "Single.fromCallable {\n  …name\", it))\n            }");
        return doOnError;
    }
}
