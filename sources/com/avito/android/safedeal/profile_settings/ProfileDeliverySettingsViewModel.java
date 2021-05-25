package com.avito.android.safedeal.profile_settings;

import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItem;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR(\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0019R\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\fR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\f¨\u0006#"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsViewModel;", "", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "fetchSettings", "()V", "Landroidx/lifecycle/LiveData;", "", "getToolbarTitleChanges", "()Landroidx/lifecycle/LiveData;", "toolbarTitleChanges", "Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Pair;", "", "getSwitcherLoadingStateObservable", "()Lio/reactivex/rxjava3/core/Observable;", "switcherLoadingStateObservable", "getFullScreenErrorChanges", "fullScreenErrorChanges", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItem;", "getSwitcherClicks", "()Lio/reactivex/rxjava3/functions/Consumer;", "switcherClicks", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLinkClicks", "deepLinkClicks", "", "getActivityResultChanges", "activityResultChanges", "getDeepLinkChanges", "deepLinkChanges", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileDeliverySettingsViewModel {
    void fetchSettings();

    @NotNull
    LiveData<Integer> getActivityResultChanges();

    @NotNull
    LiveData<DeepLink> getDeepLinkChanges();

    @NotNull
    Consumer<DeepLink> getDeepLinkClicks();

    @NotNull
    LiveData<String> getFullScreenErrorChanges();

    @NotNull
    Consumer<SwitcherItem> getSwitcherClicks();

    @NotNull
    Observable<Pair<String, Boolean>> getSwitcherLoadingStateObservable();

    @NotNull
    LiveData<String> getToolbarTitleChanges();

    void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter);
}
