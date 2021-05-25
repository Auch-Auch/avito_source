package com.avito.android.messenger.conversation.mvi.deeplinks.payout;

import android.net.Uri;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.delivery.DeliveryCourierPayoutRedirectResponse;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/DeliveryCourierPayoutInteractor;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInteractor;", "", "purchaseId", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Landroid/net/Uri;", "getPayoutUrl", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/remote/DeliveryApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/DeliveryApi;", "deliveryApi", "<init>", "(Lcom/avito/android/remote/DeliveryApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierPayoutInteractor implements PayoutInteractor {
    public final DeliveryApi a;
    public final SchedulersFactory b;
    public final TypedErrorThrowableConverter c;

    public static final class a<T, R> implements Function<TypedResult<DeliveryCourierPayoutRedirectResponse>, LoadingState<? super Uri>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super Uri> apply(TypedResult<DeliveryCourierPayoutRedirectResponse> typedResult) {
            TypedResult<DeliveryCourierPayoutRedirectResponse> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((DeliveryCourierPayoutRedirectResponse) ((TypedResult.OfResult) typedResult2).getResult()).getPayoutUrl());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super Uri>> {
        public final /* synthetic */ DeliveryCourierPayoutInteractor a;

        public b(DeliveryCourierPayoutInteractor deliveryCourierPayoutInteractor) {
            this.a = deliveryCourierPayoutInteractor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super Uri> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    public DeliveryCourierPayoutInteractor(@NotNull DeliveryApi deliveryApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(deliveryApi, "deliveryApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        this.a = deliveryApi;
        this.b = schedulersFactory;
        this.c = typedErrorThrowableConverter;
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.payout.PayoutInteractor
    @NotNull
    public Observable<LoadingState<Uri>> getPayoutUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "purchaseId");
        Observable<LoadingState<Uri>> startWith = InteropKt.toV2(this.a.getDeliveryCourierPayoutProceedUrl(str)).subscribeOn(this.b.io()).map(a.a).onErrorReturn(new b(this)).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "deliveryApi.getDeliveryC…ith(LoadingState.Loading)");
        return startWith;
    }
}
