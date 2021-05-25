package com.avito.android.payment.form;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/payment/form/PaymentGenericFormView;", "", "Lio/reactivex/Observable;", "", "getToolbarUpClicks", "()Lio/reactivex/Observable;", "toolbarUpClicks", "getRetryClicks", "retryClicks", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/payment/form/ScreenState;", "getScreenBinding", "()Lio/reactivex/functions/Consumer;", "screenBinding", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface PaymentGenericFormView {
    @NotNull
    Observable<Unit> getRetryClicks();

    @NotNull
    Consumer<ScreenState> getScreenBinding();

    @NotNull
    Observable<Unit> getToolbarUpClicks();
}
