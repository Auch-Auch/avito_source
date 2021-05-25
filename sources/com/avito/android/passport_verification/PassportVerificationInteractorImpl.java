package com.avito.android.passport_verification;

import com.avito.android.remote.VerificationApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SumSubSdkTokenResult;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/passport_verification/PassportVerificationInteractorImpl;", "Lcom/avito/android/passport_verification/PassportVerificationInteractor;", "Lio/reactivex/rxjava3/core/Single;", "", "requestAccessToken", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/VerificationApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/VerificationApi;", "api", "<init>", "(Lcom/avito/android/remote/VerificationApi;)V", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
public final class PassportVerificationInteractorImpl implements PassportVerificationInteractor {
    public final VerificationApi a;

    public static final class a<T, R> implements Function<SumSubSdkTokenResult, String> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(SumSubSdkTokenResult sumSubSdkTokenResult) {
            return sumSubSdkTokenResult.getToken();
        }
    }

    @Inject
    public PassportVerificationInteractorImpl(@NotNull VerificationApi verificationApi) {
        Intrinsics.checkNotNullParameter(verificationApi, "api");
        this.a = verificationApi;
    }

    @Override // com.avito.android.passport_verification.PassportVerificationInteractor
    @NotNull
    public Single<String> requestAccessToken() {
        Single<R> flatMap = this.a.getSumsubSdkToken().flatMap(PassportVerificationInteractorImpl$requestAccessToken$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        Single<R> map = flatMap.map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getSumsubSdkToken()\n…        .map { it.token }");
        return map;
    }
}
