package com.avito.android.payment.processing;

import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PaymentStatusLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.payment.generic.PaymentGenericResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/payment/processing/PaymentGenericPresenterImpl;", "Lcom/avito/android/payment/processing/PaymentGenericPresenter;", "", "initPayment", "()V", "Lcom/avito/android/payment/processing/PaymentProcessingRouter;", "router", "attachRouter", "(Lcom/avito/android/payment/processing/PaymentProcessingRouter;)V", "detachRouter", "dispose", "Lcom/avito/android/payment/processing/PaymentStatusPollingInteractor;", "d", "Lcom/avito/android/payment/processing/PaymentStatusPollingInteractor;", "statusPollingInteractor", "Lcom/avito/android/payment/processing/PaymentGenericInteractor;", "c", "Lcom/avito/android/payment/processing/PaymentGenericInteractor;", "genericInteractor", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/CompositeDisposable;", "lifecycleDisposable", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", AuthSource.BOOKING_ORDER, "Lcom/avito/android/payment/processing/PaymentProcessingRouter;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "e", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "<init>", "(Lcom/avito/android/payment/processing/PaymentGenericInteractor;Lcom/avito/android/payment/processing/PaymentStatusPollingInteractor;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/util/SchedulersFactory;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentGenericPresenterImpl implements PaymentGenericPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public PaymentProcessingRouter b;
    public final PaymentGenericInteractor c;
    public final PaymentStatusPollingInteractor d;
    public final DeepLinkFactory e;
    public final SchedulersFactory f;

    public static final class a extends Lambda implements Function1<LoadingState<? super PaymentGenericResult>, Unit> {
        public final /* synthetic */ PaymentGenericPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PaymentGenericPresenterImpl paymentGenericPresenterImpl) {
            super(1);
            this.a = paymentGenericPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(LoadingState<? super PaymentGenericResult> loadingState) {
            LoadingState<? super PaymentGenericResult> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                PaymentGenericResult paymentGenericResult = (PaymentGenericResult) loaded.getData();
                if (paymentGenericResult instanceof PaymentGenericResult.Ok) {
                    Object data = loaded.getData();
                    Objects.requireNonNull(data, "null cannot be cast to non-null type com.avito.android.remote.model.payment.generic.PaymentGenericResult.Ok");
                    String uri = ((PaymentGenericResult.Ok) data).getUri();
                    DeepLink createFromUri = this.a.e.createFromUri(uri);
                    if (createFromUri instanceof PaymentStatusLink) {
                        PaymentStatusLink paymentStatusLink = (PaymentStatusLink) createFromUri;
                        if (paymentStatusLink.getShouldPoll()) {
                            PaymentGenericPresenterImpl.access$getPaymentStatusPolling(this.a, 1, paymentStatusLink.getOrderId(), uri);
                        }
                    }
                    PaymentProcessingRouter paymentProcessingRouter = this.a.b;
                    if (paymentProcessingRouter != null) {
                        paymentProcessingRouter.onPaymentResult(uri);
                    }
                } else if (paymentGenericResult instanceof PaymentGenericResult.FormIncorrectData) {
                    PaymentGenericPresenterImpl paymentGenericPresenterImpl = this.a;
                    Object data2 = loaded.getData();
                    Objects.requireNonNull(data2, "null cannot be cast to non-null type com.avito.android.remote.model.payment.generic.PaymentGenericResult.FormIncorrectData");
                    PaymentGenericPresenterImpl.access$handleError(paymentGenericPresenterImpl, (String) CollectionsKt___CollectionsKt.first(((PaymentGenericResult.FormIncorrectData) data2).getMessages().values()));
                } else if (paymentGenericResult instanceof PaymentGenericResult.DuplicatePayment) {
                    PaymentGenericPresenterImpl paymentGenericPresenterImpl2 = this.a;
                    Object data3 = loaded.getData();
                    Objects.requireNonNull(data3, "null cannot be cast to non-null type com.avito.android.remote.model.payment.generic.PaymentGenericResult.DuplicatePayment");
                    PaymentGenericPresenterImpl.access$handleError(paymentGenericPresenterImpl2, ((PaymentGenericResult.DuplicatePayment) data3).getMessage());
                } else if (paymentGenericResult instanceof PaymentGenericResult.ForbiddenPayment) {
                    PaymentGenericPresenterImpl paymentGenericPresenterImpl3 = this.a;
                    Object data4 = loaded.getData();
                    Objects.requireNonNull(data4, "null cannot be cast to non-null type com.avito.android.remote.model.payment.generic.PaymentGenericResult.ForbiddenPayment");
                    PaymentGenericPresenterImpl.access$handleError(paymentGenericPresenterImpl3, ((PaymentGenericResult.ForbiddenPayment) data4).getMessage());
                }
            } else if (loadingState2 instanceof LoadingState.Error) {
                LoadingState.Error error = (LoadingState.Error) loadingState2;
                if (error.getError() instanceof ErrorWithMessage) {
                    PaymentGenericPresenterImpl paymentGenericPresenterImpl4 = this.a;
                    TypedError error2 = error.getError();
                    Objects.requireNonNull(error2, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorWithMessage");
                    PaymentGenericPresenterImpl.access$handleError(paymentGenericPresenterImpl4, ((ErrorWithMessage) error2).getMessage());
                }
            }
            return Unit.INSTANCE;
        }
    }

    public PaymentGenericPresenterImpl(@NotNull PaymentGenericInteractor paymentGenericInteractor, @NotNull PaymentStatusPollingInteractor paymentStatusPollingInteractor, @NotNull DeepLinkFactory deepLinkFactory, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(paymentGenericInteractor, "genericInteractor");
        Intrinsics.checkNotNullParameter(paymentStatusPollingInteractor, "statusPollingInteractor");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.c = paymentGenericInteractor;
        this.d = paymentStatusPollingInteractor;
        this.e = deepLinkFactory;
        this.f = schedulersFactory;
    }

    public static final void access$getPaymentStatusPolling(PaymentGenericPresenterImpl paymentGenericPresenterImpl, int i, String str, String str2) {
        CompositeDisposable compositeDisposable = paymentGenericPresenterImpl.a;
        Disposable subscribe = paymentGenericPresenterImpl.d.getPaymentStatus(str).delay(c.roundToLong((float) Math.pow((double) 2.0f, (double) i)), TimeUnit.SECONDS, paymentGenericPresenterImpl.f.computation()).subscribeOn(paymentGenericPresenterImpl.f.io()).observeOn(paymentGenericPresenterImpl.f.mainThread()).subscribe(new a2.a.a.t1.d.a(paymentGenericPresenterImpl, i, str, str2));
        Intrinsics.checkNotNullExpressionValue(subscribe, "statusPollingInteractor.…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$handleError(PaymentGenericPresenterImpl paymentGenericPresenterImpl, String str) {
        PaymentProcessingRouter paymentProcessingRouter = paymentGenericPresenterImpl.b;
        if (paymentProcessingRouter != null) {
            paymentProcessingRouter.onError(str);
        }
    }

    @Override // com.avito.android.payment.processing.PaymentGenericPresenter
    public void attachRouter(@NotNull PaymentProcessingRouter paymentProcessingRouter) {
        Intrinsics.checkNotNullParameter(paymentProcessingRouter, "router");
        this.b = paymentProcessingRouter;
    }

    @Override // com.avito.android.payment.processing.PaymentGenericPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.payment.processing.PaymentGenericPresenter
    public void dispose() {
        this.a.dispose();
    }

    @Override // com.avito.android.payment.processing.PaymentGenericPresenter
    public void initPayment() {
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.f, this.c.initPayment(), "genericInteractor.initPa…(schedulers.mainThread())"), new a(this)));
    }
}
