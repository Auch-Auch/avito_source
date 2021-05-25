package com.avito.android.extended_profile;

import androidx.lifecycle.LiveData;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.avito.android.extended_profile.tracker.ExtendedProfileTracker;
import com.avito.android.public_profile.ui.SubscriptionStateListener;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J+\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000bH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH&¢\u0006\u0004\b\u0018\u0010\u0010J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010!R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020&0\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010!R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010!R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010!¨\u0006/"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewModel;", "Lcom/avito/android/public_profile/ui/SubscriptionStateListener;", "Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/extended_profile/adapter/action/ExtendedProfileItemAction;", "itemsClicks", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "galleryClicks", "", "observeClicks", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;)V", "", "isRefreshing", "loadData", "(Z)V", "refreshState", "()V", "onBackClicked", "onShareMenuClick", "()Z", "Lcom/avito/android/deep_linking/links/PhoneLink$Call;", "phoneLink", "onPhoneCallConfirmed", "(Lcom/avito/android/deep_linking/links/PhoneLink$Call;)V", "onPhoneCallCanceled", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "handleDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Landroidx/lifecycle/LiveData;", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "getContactActions", "()Landroidx/lifecycle/LiveData;", "contactActions", "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent;", "getViewEvents", "viewEvents", "Lcom/avito/android/extended_profile/DataChangeEvent;", "getDataToDisplayChanges", "dataToDisplayChanges", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent;", "getSingleLiveEvents", "singleLiveEvents", "", "getChangedItemsIndexes", "changedItemsIndexes", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public interface ExtendedProfileViewModel extends SubscriptionStateListener, ExtendedProfileTracker {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void loadData$default(ExtendedProfileViewModel extendedProfileViewModel, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                extendedProfileViewModel.loadData(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadData");
        }
    }

    @NotNull
    LiveData<Integer> getChangedItemsIndexes();

    @NotNull
    LiveData<List<ContactBar.Action>> getContactActions();

    @NotNull
    LiveData<DataChangeEvent> getDataToDisplayChanges();

    @NotNull
    LiveData<ExtendedProfileViewSingleLiveEvent> getSingleLiveEvents();

    @NotNull
    LiveData<ExtendedProfileViewEvent> getViewEvents();

    void handleDeepLink(@NotNull DeepLink deepLink);

    void loadData(boolean z);

    void observeClicks(@NotNull Observable<ExtendedProfileItemAction> observable, @NotNull Observable<TnsGalleryItemClickAction> observable2);

    void onBackClicked();

    void onPhoneCallCanceled();

    void onPhoneCallConfirmed(@NotNull PhoneLink.Call call);

    boolean onShareMenuClick();

    void refreshState();
}
