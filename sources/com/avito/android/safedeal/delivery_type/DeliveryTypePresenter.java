package com.avito.android.safedeal.delivery_type;

import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/DeliveryTypePresenter;", "Lcom/avito/android/safedeal/delivery_type/RetryListener;", "Lcom/avito/android/safedeal/delivery_type/ButtonClickListener;", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeView;", "view", "", "attachView", "(Lcom/avito/android/safedeal/delivery_type/DeliveryTypeView;)V", "detachView", "()V", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeRouter;", "router", "attachRouter", "(Lcom/avito/android/safedeal/delivery_type/DeliveryTypeRouter;)V", "detachRouter", "onStart", "onStop", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "state", "restoreState", "(Landroid/os/Bundle;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryTypePresenter extends RetryListener, ButtonClickListener {
    void attachRouter(@Nullable DeliveryTypeRouter deliveryTypeRouter);

    void attachView(@NotNull DeliveryTypeView deliveryTypeView);

    void detachRouter();

    void detachView();

    void onStart();

    void onStop();

    void restoreState(@Nullable Bundle bundle);

    @NotNull
    Bundle saveState();
}
