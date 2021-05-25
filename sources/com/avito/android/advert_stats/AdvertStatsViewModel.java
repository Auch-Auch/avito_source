package com.avito.android.advert_stats;

import androidx.lifecycle.LiveData;
import com.avito.android.advert_stats.item.BarItem;
import com.avito.android.advert_stats.item.WeekItem;
import com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerItem;
import com.avito.android.advert_stats.recycler.ListUpdate;
import com.avito.android.deep_linking.DeeplinkClickStreamProvider;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Action;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.Event;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH&¢\u0006\u0004\b\u0010\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\tH&¢\u0006\u0004\b\u0012\u0010\rJ\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001e\u001a\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\tH&¢\u0006\u0004\b\u001e\u0010\rR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R \u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030$0\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\"R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020*0\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\"R \u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\"¨\u00060"}, d2 = {"Lcom/avito/android/advert_stats/AdvertStatsViewModel;", "", "", "onRetryClicked", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "onButtonClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lio/reactivex/Observable;", "Lcom/avito/android/advert_stats/item/WeekItem;", "weeksObservable", "subscribeToWeekSelection", "(Lio/reactivex/Observable;)V", "Lcom/avito/android/advert_stats/item/BarItem;", "barObservable", "subscribeToBarSelection", "observable", "subscribeToWeekScrolling", "Lcom/avito/android/deep_linking/DeeplinkClickStreamProvider;", "deeplinkClickStreamProvider", "subscribeToItemClicks", "(Lcom/avito/android/deep_linking/DeeplinkClickStreamProvider;)V", "", "requestCode", "resultCode", "handleResult", "(II)V", "Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerItem;", "bannerClicks", "subscribeStatisticsBannerClicks", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/remote/model/Action;", "getButtonActionChanges", "()Landroidx/lifecycle/LiveData;", "buttonActionChanges", "Lcom/avito/android/util/architecture_components/Event;", "getRoutingEvents", "routingEvents", "", "getTitleVisibilityChanges", "titleVisibilityChanges", "Lcom/avito/android/advert_stats/recycler/ListUpdate;", "getDataChanges", "dataChanges", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "progressChanges", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertStatsViewModel {
    @NotNull
    LiveData<Action> getButtonActionChanges();

    @NotNull
    LiveData<ListUpdate> getDataChanges();

    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    @NotNull
    LiveData<Event<?>> getRoutingEvents();

    @NotNull
    LiveData<Boolean> getTitleVisibilityChanges();

    void handleResult(int i, int i2);

    void onButtonClicked(@NotNull DeepLink deepLink);

    void onRetryClicked();

    void subscribeStatisticsBannerClicks(@NotNull Observable<NewStatisticsBannerItem> observable);

    void subscribeToBarSelection(@NotNull Observable<BarItem> observable);

    void subscribeToItemClicks(@NotNull DeeplinkClickStreamProvider deeplinkClickStreamProvider);

    void subscribeToWeekScrolling(@NotNull Observable<Unit> observable);

    void subscribeToWeekSelection(@NotNull Observable<WeekItem> observable);
}
