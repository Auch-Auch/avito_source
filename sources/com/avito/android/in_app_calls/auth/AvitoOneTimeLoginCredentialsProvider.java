package com.avito.android.in_app_calls.auth;

import arrow.core.Option;
import com.avito.android.calls.OneTimeLoginCredentialsProvider;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.tracker.errors.CallApiRequestException;
import com.avito.android.calls_shared.utils.ApiUtilsKt;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.remote.OneTimeLoginKeyResult;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/in_app_calls/auth/AvitoOneTimeLoginCredentialsProvider;", "Lcom/avito/android/calls/OneTimeLoginCredentialsProvider;", "", "oneTimeKey", "Lio/reactivex/Single;", "Larrow/core/Option;", "getOneTimeLoginKey", "(Ljava/lang/String;)Lio/reactivex/Single;", "Lcom/avito/android/calls/remote/CallsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls/remote/CallsApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "c", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "<init>", "(Lcom/avito/android/calls/remote/CallsApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/communications_common/analytics/ErrorTracker;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoOneTimeLoginCredentialsProvider implements OneTimeLoginCredentialsProvider {
    public final CallsApi a;
    public final SchedulersFactory3 b;
    public final ErrorTracker c;

    public static final class a<T, R> implements Function<TypedResult<OneTimeLoginKeyResult>, Option<? extends String>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends String> apply(TypedResult<OneTimeLoginKeyResult> typedResult) {
            TypedResult<OneTimeLoginKeyResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "result");
            if (typedResult2 instanceof TypedResult.OfError) {
                return Option.Companion.empty();
            }
            if (typedResult2 instanceof TypedResult.OfResult) {
                return Option.Companion.just(((OneTimeLoginKeyResult) ((TypedResult.OfResult) typedResult2).getResult()).getToken());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, Option<? extends String>> {
        public final /* synthetic */ AvitoOneTimeLoginCredentialsProvider a;

        public b(AvitoOneTimeLoginCredentialsProvider avitoOneTimeLoginCredentialsProvider) {
            this.a = avitoOneTimeLoginCredentialsProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends String> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            ErrorTracker.DefaultImpls.track$default(this.a.c, new CallApiRequestException("Can't get one time key for login", th2), null, null, 6, null);
            return Option.Companion.empty();
        }
    }

    @Inject
    public AvitoOneTimeLoginCredentialsProvider(@NotNull CallsApi callsApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ErrorTracker errorTracker) {
        Intrinsics.checkNotNullParameter(callsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        this.a = callsApi;
        this.b = schedulersFactory3;
        this.c = errorTracker;
    }

    @Override // com.avito.android.calls.OneTimeLoginCredentialsProvider
    @NotNull
    public Single<Option<String>> getOneTimeLoginKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "oneTimeKey");
        io.reactivex.rxjava3.core.Single<TypedResult<OneTimeLoginKeyResult>> retryWhen = this.a.calculateOneTimeLoginKey(str).subscribeOn(this.b.io()).retryWhen(ApiUtilsKt.inAppCallsExponentialRetry$default(this.b, null, 2, null));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "api.calculateOneTimeLogi…nentialRetry(schedulers))");
        Single<Option<String>> onErrorReturn = InteropKt.toV2(retryWhen).map(a.a).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.calculateOneTimeLogi…ion.empty()\n            }");
        return onErrorReturn;
    }
}
