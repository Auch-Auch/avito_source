package com.avito.android.payment.top_up.form;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/avito/android/payment/top_up/form/TopUpFormView;", "", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/payment/top_up/form/ScreenState;", "getScreenBinding", "()Lio/reactivex/functions/Consumer;", "screenBinding", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface TopUpFormView {
    @NotNull
    Consumer<ScreenState> getScreenBinding();
}
