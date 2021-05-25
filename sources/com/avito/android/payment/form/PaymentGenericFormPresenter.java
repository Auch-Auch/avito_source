package com.avito.android.payment.form;

import com.avito.android.blueprints.publish.PrimaryParametersListener;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/payment/form/PaymentGenericFormPresenter;", "Lcom/avito/android/payment/form/PaymentGenericFormViewListener;", "Lcom/avito/android/blueprints/publish/PrimaryParametersListener;", "Lcom/avito/android/payment/form/PaymentGenericFormRouter;", "router", "", "attachRouter", "(Lcom/avito/android/payment/form/PaymentGenericFormRouter;)V", "detachRouter", "()V", "Lcom/avito/android/payment/form/PaymentGenericFormView;", "view", "attachView", "(Lcom/avito/android/payment/form/PaymentGenericFormView;)V", "detachView", "dispose", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface PaymentGenericFormPresenter extends PaymentGenericFormViewListener, PrimaryParametersListener {
    void attachRouter(@NotNull PaymentGenericFormRouter paymentGenericFormRouter);

    void attachView(@NotNull PaymentGenericFormView paymentGenericFormView);

    void detachRouter();

    void detachView();

    void dispose();

    @NotNull
    Kundle onSaveState();
}
