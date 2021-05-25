package com.avito.android.payment.form;

import com.avito.android.payment.ModalErrorView;
import com.avito.android.payment.processing.ProcessingResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/payment/form/PaymentStatusProcessingPresenter;", "", "Lcom/avito/android/payment/ModalErrorView;", "view", "", "attachView", "(Lcom/avito/android/payment/ModalErrorView;)V", "Lcom/avito/android/payment/form/PaymentStatusProcessingRouter;", "router", "attachRouter", "(Lcom/avito/android/payment/form/PaymentStatusProcessingRouter;)V", "detachView", "()V", "detachRouter", "Lcom/avito/android/payment/processing/ProcessingResult;", "result", "processPayment", "(Lcom/avito/android/payment/processing/ProcessingResult;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface PaymentStatusProcessingPresenter {
    void attachRouter(@NotNull PaymentStatusProcessingRouter paymentStatusProcessingRouter);

    void attachView(@NotNull ModalErrorView modalErrorView);

    void detachRouter();

    void detachView();

    void processPayment(@NotNull ProcessingResult processingResult);
}
