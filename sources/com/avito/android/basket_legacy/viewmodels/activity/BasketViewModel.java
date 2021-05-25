package com.avito.android.basket_legacy.viewmodels.activity;

import androidx.lifecycle.LiveData;
import com.avito.android.basket_legacy.utils.BasketStep;
import com.avito.android.basket_legacy.utils.ProgressState;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.architecture_components.StartActivityEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/avito/android/basket_legacy/viewmodels/activity/BasketViewModel;", "", "", "onRetryClicked", "()V", "onPerformanceVasSelected", "onVisualVasSelected", "onLfPackageSelected", "onSingleFeeSelected", "onShowSingleFeeInfoClicked", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onDeeplinkClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/basket_legacy/utils/ProgressState;", "getProgressEvents", "()Landroidx/lifecycle/LiveData;", "progressEvents", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/basket_legacy/utils/BasketStep;", "getRouterEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routerEvents", "Lcom/avito/android/util/architecture_components/StartActivityEvent;", "getStartActivityEvents", "startActivityEvents", "basket_release"}, k = 1, mv = {1, 4, 2})
public interface BasketViewModel {
    @NotNull
    LiveData<ProgressState> getProgressEvents();

    @NotNull
    SingleLiveEvent<BasketStep> getRouterEvents();

    @NotNull
    LiveData<StartActivityEvent> getStartActivityEvents();

    void onDeeplinkClicked(@NotNull DeepLink deepLink);

    void onLfPackageSelected();

    void onPerformanceVasSelected();

    void onRetryClicked();

    void onShowSingleFeeInfoClicked();

    void onSingleFeeSelected();

    void onVisualVasSelected();
}
