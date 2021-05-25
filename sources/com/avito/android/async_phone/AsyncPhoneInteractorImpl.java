package com.avito.android.async_phone;

import com.avito.android.async_phone_core.UtilsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.AsyncPhoneApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.FailurePhoneResponse;
import com.avito.android.remote.model.PhoneResponse;
import com.avito.android.remote.model.SuccessPhoneResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedResultException;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/async_phone/AsyncPhoneInteractorImpl;", "Lcom/avito/android/async_phone/AsyncPhoneInteractor;", "", "itemId", "context", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/deep_linking/links/DeepLink;", "loadPhone", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/AsyncPhoneApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/AsyncPhoneApi;", "api", "<init>", "(Lcom/avito/android/remote/AsyncPhoneApi;Lcom/avito/android/util/SchedulersFactory3;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AsyncPhoneInteractorImpl implements AsyncPhoneInteractor {
    public final AsyncPhoneApi a;
    public final SchedulersFactory3 b;

    public static final class a<T, R> implements Function<TypedResult<PhoneResponse>, LoadingState<? super DeepLink>> {
        public final /* synthetic */ AsyncPhoneInteractorImpl a;

        public a(AsyncPhoneInteractorImpl asyncPhoneInteractorImpl) {
            this.a = asyncPhoneInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super DeepLink> apply(TypedResult<PhoneResponse> typedResult) {
            TypedResult<PhoneResponse> typedResult2 = typedResult;
            AsyncPhoneInteractorImpl asyncPhoneInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            return AsyncPhoneInteractorImpl.access$toLoadingState(asyncPhoneInteractorImpl, typedResult2);
        }
    }

    @Inject
    public AsyncPhoneInteractorImpl(@NotNull AsyncPhoneApi asyncPhoneApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(asyncPhoneApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = asyncPhoneApi;
        this.b = schedulersFactory3;
    }

    public static final LoadingState access$toLoadingState(AsyncPhoneInteractorImpl asyncPhoneInteractorImpl, TypedResult typedResult) {
        Objects.requireNonNull(asyncPhoneInteractorImpl);
        if (typedResult instanceof TypedResult.OfResult) {
            PhoneResponse phoneResponse = (PhoneResponse) ((TypedResult.OfResult) typedResult).getResult();
            if (phoneResponse instanceof SuccessPhoneResponse) {
                return new LoadingState.Loaded(((SuccessPhoneResponse) phoneResponse).getAction().getDeepLink());
            }
            if (phoneResponse instanceof FailurePhoneResponse) {
                return new LoadingState.Loaded(UtilsKt.toDialogDeepLink(((FailurePhoneResponse) phoneResponse).getDialogInfo()));
            }
            throw new NoWhenBranchMatchedException();
        } else if (typedResult instanceof TypedResult.OfError) {
            throw new TypedResultException(((TypedResult.OfError) typedResult).getError());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.avito.android.async_phone.AsyncPhoneInteractor
    @NotNull
    public Observable<LoadingState<DeepLink>> loadPhone(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return a2.b.a.a.a.a2(this.b, this.a.getPhoneAction(str, str2).timeout(2500, TimeUnit.MILLISECONDS, this.b.computation()).map(new a(this)), "api.getPhoneAction(itemI…scribeOn(schedulers.io())");
    }
}
