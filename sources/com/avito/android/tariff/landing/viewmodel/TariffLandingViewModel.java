package com.avito.android.tariff.landing.viewmodel;

import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.LoadingState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/tariff/landing/viewmodel/TariffLandingViewModel;", "", "", "onRetryButtonClick", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onContinueButtonClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/tariff/landing/viewmodel/TariffLanding;", "getProgressChanges", "()Landroidx/lifecycle/LiveData;", "progressChanges", "getRoutingEvents", "routingEvents", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface TariffLandingViewModel {
    @NotNull
    LiveData<LoadingState<TariffLanding>> getProgressChanges();

    @NotNull
    LiveData<DeepLink> getRoutingEvents();

    void onContinueButtonClick(@NotNull DeepLink deepLink);

    void onRetryButtonClick();
}
