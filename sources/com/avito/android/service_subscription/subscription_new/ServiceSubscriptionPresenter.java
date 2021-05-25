package com.avito.android.service_subscription.subscription_new;

import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.Kundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionPresenter;", "", "Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionView;", "view", "", "attachView", "(Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionView;)V", "detachView", "()V", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "attachBackPressedListener", "(Lcom/avito/android/ui/fragments/OnBackPressedListener;)V", "detachBackPressedListener", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public interface ServiceSubscriptionPresenter {
    void attachBackPressedListener(@NotNull OnBackPressedListener onBackPressedListener);

    void attachView(@NotNull ServiceSubscriptionView serviceSubscriptionView);

    void detachBackPressedListener();

    void detachView();

    @NotNull
    Kundle onSaveState();
}
