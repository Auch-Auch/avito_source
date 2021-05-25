package com.avito.android.verification.verification_status;

import com.avito.android.remote.VerificationApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SimpleMessageResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.VerificationStatusResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\bR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusInteractorImpl;", "Lcom/avito/android/verification/verification_status/VerificationStatusInteractor;", "", "type", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/VerificationStatusResult;", "getVerificationStatus", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/SimpleMessageResult;", "removeVerification", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/remote/VerificationApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/VerificationApi;", "verificationApi", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/VerificationApi;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationStatusInteractorImpl implements VerificationStatusInteractor {
    public final SchedulersFactory3 a;
    public final VerificationApi b;
    public final TypedErrorThrowableConverter c;

    public static final class a<T, R> implements Function<TypedResult<VerificationStatusResult>, LoadingState<? super VerificationStatusResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super VerificationStatusResult> apply(TypedResult<VerificationStatusResult> typedResult) {
            TypedResult<VerificationStatusResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super VerificationStatusResult>> {
        public final /* synthetic */ VerificationStatusInteractorImpl a;

        public b(VerificationStatusInteractorImpl verificationStatusInteractorImpl) {
            this.a = verificationStatusInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super VerificationStatusResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.c;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public VerificationStatusInteractorImpl(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull VerificationApi verificationApi, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(verificationApi, "verificationApi");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        this.a = schedulersFactory3;
        this.b = verificationApi;
        this.c = typedErrorThrowableConverter;
    }

    @Override // com.avito.android.verification.verification_status.VerificationStatusInteractor
    @NotNull
    public Single<LoadingState<VerificationStatusResult>> getVerificationStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return a2.b.a.a.a.e2(this.a, this.b.getVerificationStatus(str).map(a.a).onErrorReturn(new b(this)), "verificationApi\n        …scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.verification.verification_status.VerificationStatusInteractor
    @NotNull
    public Single<SimpleMessageResult> removeVerification(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        Single<R> flatMap = this.b.removeVerificationStatus(str).flatMap(VerificationStatusInteractorImpl$removeVerification$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        return a2.b.a.a.a.e2(this.a, flatMap, "verificationApi\n        …scribeOn(schedulers.io())");
    }
}
