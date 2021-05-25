package com.avito.android.payment.top_up.form;

import com.avito.android.payment.top_up.form.items.bubble.BubbleItem;
import com.avito.android.payment.top_up.form.items.input.TopUpInputItem;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011R7\u0010\u001a\u001a#\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00040\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/avito/android/payment/top_up/form/TopUpFormPresenter;", "", "Lcom/avito/android/payment/top_up/form/TopUpFormView;", "view", "", "attachView", "(Lcom/avito/android/payment/top_up/form/TopUpFormView;)V", "detachView", "()V", "Lcom/avito/android/payment/top_up/form/TopUpFormRouter;", "router", "attachRouter", "(Lcom/avito/android/payment/top_up/form/TopUpFormRouter;)V", "detachRouter", "dispose", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lkotlin/Function2;", "Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItem;", "", "Lkotlin/ParameterName;", "name", "newValue", "getInputListener", "()Lkotlin/jvm/functions/Function2;", "inputListener", "Lkotlin/Function1;", "Lcom/avito/android/payment/top_up/form/items/bubble/BubbleItem;", "getBubbleItemListener", "()Lkotlin/jvm/functions/Function1;", "bubbleItemListener", "Lkotlin/Function0;", "getSubmitButtonListener", "()Lkotlin/jvm/functions/Function0;", "submitButtonListener", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface TopUpFormPresenter {
    void attachRouter(@NotNull TopUpFormRouter topUpFormRouter);

    void attachView(@NotNull TopUpFormView topUpFormView);

    void detachRouter();

    void detachView();

    void dispose();

    @NotNull
    Function1<BubbleItem, Unit> getBubbleItemListener();

    @NotNull
    Function2<TopUpInputItem, String, Unit> getInputListener();

    @NotNull
    Function0<Unit> getSubmitButtonListener();

    @NotNull
    Kundle onSaveState();
}
