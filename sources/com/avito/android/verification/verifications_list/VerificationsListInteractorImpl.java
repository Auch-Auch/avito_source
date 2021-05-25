package com.avito.android.verification.verifications_list;

import com.avito.android.remote.VerificationApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.VerificationOptionsListResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/verification/verifications_list/VerificationsListInteractorImpl;", "Lcom/avito/android/verification/verifications_list/VerificationsListInteractor;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/VerificationOptionsListResult;", "getVerificationsList", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/VerificationApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/VerificationApi;", "verificationApi", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/VerificationApi;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationsListInteractorImpl implements VerificationsListInteractor {
    public final SchedulersFactory3 a;
    public final VerificationApi b;
    public final TypedErrorThrowableConverter c;

    public static final class a<T, R> implements Function<TypedResult<VerificationOptionsListResult>, LoadingState<? super VerificationOptionsListResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super VerificationOptionsListResult> apply(TypedResult<VerificationOptionsListResult> typedResult) {
            TypedResult<VerificationOptionsListResult> typedResult2 = typedResult;
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

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super VerificationOptionsListResult>> {
        public final /* synthetic */ VerificationsListInteractorImpl a;

        public b(VerificationsListInteractorImpl verificationsListInteractorImpl) {
            this.a = verificationsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super VerificationOptionsListResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.c;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public VerificationsListInteractorImpl(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull VerificationApi verificationApi, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(verificationApi, "verificationApi");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        this.a = schedulersFactory3;
        this.b = verificationApi;
        this.c = typedErrorThrowableConverter;
    }

    @Override // com.avito.android.verification.verifications_list.VerificationsListInteractor
    @NotNull
    public Single<LoadingState<VerificationOptionsListResult>> getVerificationsList() {
        return a2.b.a.a.a.e2(this.a, this.b.getVerificationOptionsList().map(a.a).onErrorReturn(new b(this)), "verificationApi\n        …scribeOn(schedulers.io())");
    }
}
