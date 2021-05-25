package com.avito.android.payment.processing;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.payment.status.PaymentStatusResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/payment/processing/PaymentStatusPresenterImpl;", "Lcom/avito/android/payment/processing/PaymentStatusPresenter;", "", "getPaymentStatus", "()V", "Lcom/avito/android/payment/processing/PaymentProcessingRouter;", "router", "attachRouter", "(Lcom/avito/android/payment/processing/PaymentProcessingRouter;)V", "detachRouter", "dispose", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/CompositeDisposable;", "lifecycleDisposable", AuthSource.BOOKING_ORDER, "Lcom/avito/android/payment/processing/PaymentProcessingRouter;", "Lcom/avito/android/payment/processing/PaymentStatusInteractor;", "c", "Lcom/avito/android/payment/processing/PaymentStatusInteractor;", "statusInteractor", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/payment/processing/PaymentStatusInteractor;Lcom/avito/android/util/SchedulersFactory;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentStatusPresenterImpl implements PaymentStatusPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public PaymentProcessingRouter b;
    public final PaymentStatusInteractor c;
    public final SchedulersFactory d;

    public static final class a extends Lambda implements Function1<LoadingState<? super PaymentStatusResult>, Unit> {
        public final /* synthetic */ PaymentStatusPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PaymentStatusPresenterImpl paymentStatusPresenterImpl) {
            super(1);
            this.a = paymentStatusPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(LoadingState<? super PaymentStatusResult> loadingState) {
            PaymentProcessingRouter paymentProcessingRouter;
            LoadingState<? super PaymentStatusResult> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                if ((((PaymentStatusResult) loaded.getData()) instanceof PaymentStatusResult.PaymentStatus) && (paymentProcessingRouter = this.a.b) != null) {
                    Object data = loaded.getData();
                    Objects.requireNonNull(data, "null cannot be cast to non-null type com.avito.android.remote.model.payment.status.PaymentStatusResult.PaymentStatus");
                    paymentProcessingRouter.onStatusDelivered((PaymentStatusResult.PaymentStatus) data);
                }
            } else if (loadingState2 instanceof LoadingState.Error) {
                LoadingState.Error error = (LoadingState.Error) loadingState2;
                if (error.getError() instanceof ErrorWithMessage) {
                    PaymentStatusPresenterImpl paymentStatusPresenterImpl = this.a;
                    TypedError error2 = error.getError();
                    Objects.requireNonNull(error2, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorWithMessage");
                    PaymentStatusPresenterImpl.access$handleError(paymentStatusPresenterImpl, ((ErrorWithMessage) error2).getMessage());
                }
            }
            return Unit.INSTANCE;
        }
    }

    public PaymentStatusPresenterImpl(@NotNull PaymentStatusInteractor paymentStatusInteractor, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(paymentStatusInteractor, "statusInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.c = paymentStatusInteractor;
        this.d = schedulersFactory;
    }

    public static final void access$handleError(PaymentStatusPresenterImpl paymentStatusPresenterImpl, String str) {
        PaymentProcessingRouter paymentProcessingRouter = paymentStatusPresenterImpl.b;
        if (paymentProcessingRouter != null) {
            paymentProcessingRouter.onError(str);
        }
    }

    @Override // com.avito.android.payment.processing.PaymentStatusPresenter
    public void attachRouter(@NotNull PaymentProcessingRouter paymentProcessingRouter) {
        Intrinsics.checkNotNullParameter(paymentProcessingRouter, "router");
        this.b = paymentProcessingRouter;
    }

    @Override // com.avito.android.payment.processing.PaymentStatusPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.payment.processing.PaymentStatusPresenter
    public void dispose() {
        this.a.dispose();
    }

    @Override // com.avito.android.payment.processing.PaymentStatusPresenter
    public void getPaymentStatus() {
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.d, this.c.getPaymentStatus(), "statusInteractor.getPaym…(schedulers.mainThread())"), new a(this)));
    }
}
