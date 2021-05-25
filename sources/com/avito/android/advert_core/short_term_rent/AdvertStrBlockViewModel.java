package com.avito.android.advert_core.short_term_rent;

import androidx.lifecycle.LiveData;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.AdvertSellerShortTermRent;
import com.jakewharton.rxrelay3.PublishRelay;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\tR\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\tR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewModel;", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockView$CalendarButtonClickListener;", "", "isEnabled", "", "onSwitchChanged", "(Z)V", "Landroidx/lifecycle/LiveData;", "getSwitchChanges", "()Landroidx/lifecycle/LiveData;", "switchChanges", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlock;", "getDataChanges", "dataChanges", "Lcom/avito/android/deep_linking/links/DeepLink;", "getShowCalendarChanges", "showCalendarChanges", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/remote/model/AdvertSellerShortTermRent;", "getData", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "data", "", "getSwitchErrorChanges", "switchErrorChanges", "getSwitchEnableChanges", "switchEnableChanges", "getOpenDeepLinkChanges", "openDeepLinkChanges", "DeepLinkRouter", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertStrBlockViewModel extends AdvertStrBlockView.CalendarButtonClickListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewModel$DeepLinkRouter;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "showSellerCalendar", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public interface DeepLinkRouter {
        void openDeepLink(@NotNull DeepLink deepLink);

        void showSellerCalendar(@NotNull DeepLink deepLink);
    }

    @NotNull
    PublishRelay<AdvertSellerShortTermRent> getData();

    @NotNull
    LiveData<AdvertStrBlock> getDataChanges();

    @NotNull
    LiveData<DeepLink> getOpenDeepLinkChanges();

    @NotNull
    LiveData<DeepLink> getShowCalendarChanges();

    @NotNull
    LiveData<Boolean> getSwitchChanges();

    @NotNull
    LiveData<Boolean> getSwitchEnableChanges();

    @NotNull
    LiveData<String> getSwitchErrorChanges();

    void onSwitchChanged(boolean z);
}
