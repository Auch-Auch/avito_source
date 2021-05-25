package com.avito.android.payment.form;

import com.avito.android.payment.ModalErrorView;
import com.avito.android.payment.processing.ProcessingResult;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/avito/android/payment/form/PaymentStatusProcessingPresenterImpl;", "Lcom/avito/android/payment/form/PaymentStatusProcessingPresenter;", "Lcom/avito/android/payment/ModalErrorView;", "view", "", "attachView", "(Lcom/avito/android/payment/ModalErrorView;)V", "Lcom/avito/android/payment/form/PaymentStatusProcessingRouter;", "router", "attachRouter", "(Lcom/avito/android/payment/form/PaymentStatusProcessingRouter;)V", "detachView", "()V", "detachRouter", "Lcom/avito/android/payment/processing/ProcessingResult;", "result", "processPayment", "(Lcom/avito/android/payment/processing/ProcessingResult;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/ModalErrorView;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/payment/form/PaymentStatusProcessingRouter;", "<init>", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentStatusProcessingPresenterImpl implements PaymentStatusProcessingPresenter {
    public ModalErrorView a;
    public PaymentStatusProcessingRouter b;

    @Override // com.avito.android.payment.form.PaymentStatusProcessingPresenter
    public void attachRouter(@NotNull PaymentStatusProcessingRouter paymentStatusProcessingRouter) {
        Intrinsics.checkNotNullParameter(paymentStatusProcessingRouter, "router");
        this.b = paymentStatusProcessingRouter;
    }

    @Override // com.avito.android.payment.form.PaymentStatusProcessingPresenter
    public void attachView(@NotNull ModalErrorView modalErrorView) {
        Intrinsics.checkNotNullParameter(modalErrorView, "view");
        this.a = modalErrorView;
    }

    @Override // com.avito.android.payment.form.PaymentStatusProcessingPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.payment.form.PaymentStatusProcessingPresenter
    public void detachView() {
        this.a = null;
    }

    @Override // com.avito.android.payment.form.PaymentStatusProcessingPresenter
    public void processPayment(@NotNull ProcessingResult processingResult) {
        Intrinsics.checkNotNullParameter(processingResult, "result");
        if (processingResult instanceof ProcessingResult.Finished) {
            PaymentStatusProcessingRouter paymentStatusProcessingRouter = this.b;
            if (paymentStatusProcessingRouter != null) {
                paymentStatusProcessingRouter.onSuccess(((ProcessingResult.Finished) processingResult).getPaymentStatus());
            }
        } else if (processingResult instanceof ProcessingResult.Redirect) {
            PaymentStatusProcessingRouter paymentStatusProcessingRouter2 = this.b;
            if (paymentStatusProcessingRouter2 != null) {
                paymentStatusProcessingRouter2.onRedirect(((ProcessingResult.Redirect) processingResult).getUriString());
            }
        } else if (processingResult instanceof ProcessingResult.Error) {
            ModalErrorView modalErrorView = this.a;
            if (modalErrorView != null) {
                modalErrorView.showModalError(((ProcessingResult.Error) processingResult).getMessage());
            }
        } else {
            boolean z = processingResult instanceof ProcessingResult.Canceled;
        }
    }
}
