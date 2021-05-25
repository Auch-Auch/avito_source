package com.avito.android.basket.checkout.viewmodel;

import com.avito.android.remote.CheckoutApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CheckoutCommitResult;
import com.avito.android.remote.model.CheckoutContentsResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.RequestUtils;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/basket/checkout/viewmodel/CheckoutRepositoryImpl;", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutRepository;", "", "checkoutContext", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/CheckoutContentsResult;", "getCheckoutContents", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "slugs", "Lcom/avito/android/remote/model/CheckoutCommitResult;", "commitCheckout", "(Ljava/lang/String;Ljava/util/Set;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/CheckoutApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/CheckoutApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Lcom/avito/android/remote/CheckoutApi;Lcom/avito/android/util/SchedulersFactory;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutRepositoryImpl implements CheckoutRepository {
    public final CheckoutApi a;
    public final SchedulersFactory b;

    public static final class a<T, R> implements Function<TypedResult<CheckoutCommitResult>, LoadingState<? super CheckoutCommitResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super CheckoutCommitResult> apply(TypedResult<CheckoutCommitResult> typedResult) {
            TypedResult<CheckoutCommitResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<TypedResult<CheckoutContentsResult>, LoadingState<? super CheckoutContentsResult>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super CheckoutContentsResult> apply(TypedResult<CheckoutContentsResult> typedResult) {
            TypedResult<CheckoutContentsResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Inject
    public CheckoutRepositoryImpl(@NotNull CheckoutApi checkoutApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(checkoutApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = checkoutApi;
        this.b = schedulersFactory;
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutRepository
    @NotNull
    public Observable<LoadingState<CheckoutCommitResult>> commitCheckout(@NotNull String str, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Intrinsics.checkNotNullParameter(set, "slugs");
        Observable<LoadingState<CheckoutCommitResult>> map = InteropKt.toV2(this.a.commitCheckout(str, RequestUtils.INSTANCE.toArrayQueryParams(set, "serviceSlugs"))).subscribeOn(this.b.io()).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.commitCheckout(check…p { it.toLoadingState() }");
        return map;
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutRepository
    @NotNull
    public Observable<LoadingState<CheckoutContentsResult>> getCheckoutContents(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Observable<LoadingState<CheckoutContentsResult>> map = InteropKt.toV2(this.a.getCheckoutContent(str)).subscribeOn(this.b.io()).map(b.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getCheckoutContent(c…p { it.toLoadingState() }");
        return map;
    }
}
