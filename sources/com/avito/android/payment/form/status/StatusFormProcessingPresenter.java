package com.avito.android.payment.form.status;

import com.avito.android.payment.ModalView;
import com.avito.android.payment.form.PaymentStatusProcessingPresenter;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/form/status/StatusFormProcessingPresenter;", "Lcom/avito/android/payment/form/PaymentStatusProcessingPresenter;", "Lcom/avito/android/payment/ModalView;", "view", "", "attachModalView", "(Lcom/avito/android/payment/ModalView;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface StatusFormProcessingPresenter extends PaymentStatusProcessingPresenter {
    void attachModalView(@NotNull ModalView modalView);

    @NotNull
    Kundle onSaveState();
}
