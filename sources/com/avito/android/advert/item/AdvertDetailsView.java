package com.avito.android.advert.item;

import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryItem;
import com.avito.android.advert.viewed.ViewedAdvertsView;
import com.avito.android.advert_core.advert.AdvertCoreView;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockView;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.bottom_navigation.KeyboardListener;
import com.avito.android.favorite.FavoriteAdvertsView;
import com.avito.android.lib.design.snackbar.util.SnackbarElementView;
import com.avito.android.progress_overlay.OnRefreshListener;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.util.architecture_components.auto_clear.LifecycleDestroyable;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.model.VKAttachments;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH&¢\u0006\u0004\b\u0013\u0010\rJ\u0017\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000fH&¢\u0006\u0004\b\u0019\u0010\u0012J\u000f\u0010\u001a\u001a\u00020\u000bH&¢\u0006\u0004\b\u001a\u0010\rJ\u000f\u0010\u001b\u001a\u00020\u000bH&¢\u0006\u0004\b\u001b\u0010\rJ\u000f\u0010\u001c\u001a\u00020\u000bH&¢\u0006\u0004\b\u001c\u0010\rJC\u0010%\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000f2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H&¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000fH&¢\u0006\u0004\b'\u0010\u0012J\u000f\u0010(\u001a\u00020\u000bH&¢\u0006\u0004\b(\u0010\rJ\u000f\u0010)\u001a\u00020\u000bH&¢\u0006\u0004\b)\u0010\rJ\u0017\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000fH&¢\u0006\u0004\b+\u0010\u0012J9\u00102\u001a\u00020\u000b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\"2\u0006\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u00010.2\b\u00101\u001a\u0004\u0018\u00010.H&¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u000bH&¢\u0006\u0004\b4\u0010\rJ\u000f\u00105\u001a\u00020\u000bH&¢\u0006\u0004\b5\u0010\rJ\u000f\u00106\u001a\u00020\u000bH&¢\u0006\u0004\b6\u0010\rJ\u0015\u00108\u001a\b\u0012\u0004\u0012\u00020.07H&¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u000bH&¢\u0006\u0004\b:\u0010\rJ\u0019\u0010=\u001a\u00020\u000b2\b\u0010<\u001a\u0004\u0018\u00010;H&¢\u0006\u0004\b=\u0010>J%\u0010C\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020?2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000b0AH&¢\u0006\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lcom/avito/android/advert/item/AdvertDetailsView;", "Lcom/avito/android/advert_core/advert/AdvertCoreView;", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView$Listener;", "Lcom/avito/android/progress_overlay/OnRefreshListener;", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "Lcom/avito/android/util/architecture_components/auto_clear/LifecycleDestroyable;", "Lcom/avito/android/advert/viewed/ViewedAdvertsView;", "Lcom/avito/android/advert/item/AdvertDetailsViewScroller;", "Lcom/avito/android/bottom_navigation/KeyboardListener;", "Lcom/avito/android/advert/item/AdvertViewScrollUpdater;", "Lcom/avito/android/lib/design/snackbar/util/SnackbarElementView;", "", "attach", "()V", "detach", "", VKAttachments.TYPE_NOTE, "updateAddNoteResult", "(Ljava/lang/String;)V", "onLoadFailed", "", "e", "onLoadError", "(Ljava/lang/Throwable;)V", "itemId", "showInactiveItem", "showAddressCopied", "onLoadingStart", "onLoadingFinish", BookingInfoActivity.EXTRA_ITEM_ID, IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "title", "", "Lcom/avito/android/remote/model/GeoReference;", "geoReferences", "showAddressOnMap", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Ljava/util/List;)V", "showConsultationForm", "onDataSourceUnavailable", "showEnableNotificationDialog", "message", "showSnackbarAboveContactBar", "Lcom/avito/android/serp/adapter/SpannedItem;", "items", "", "similarsStartPos", "topCommercialPosition", "bottomCommercialPosition", "bindItemsList", "(Ljava/util/List;ILjava/lang/Integer;Ljava/lang/Integer;)V", "removeToolbarShadow", "showPriceSubscriptionInfo", "showNotificationsEnableWarning", "Lio/reactivex/rxjava3/core/Observable;", "scrollStateChanges", "()Lio/reactivex/rxjava3/core/Observable;", "refreshList", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;", "marketplaceDeliveryItem", "updateMarketplaceDeliveryInfoItem", "(Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;)V", "Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;", "errorDialog", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showErrorDialog", "(Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;Lkotlin/jvm/functions/Function0;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsView extends AdvertCoreView, AdvertDeliveryBlockView.Listener, OnRefreshListener, FavoriteAdvertsView, LifecycleDestroyable, ViewedAdvertsView, AdvertDetailsViewScroller, KeyboardListener, AdvertViewScrollUpdater, SnackbarElementView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.avito.android.advert.item.AdvertDetailsView */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void showAddressOnMap$default(AdvertDetailsView advertDetailsView, String str, String str2, Coordinates coordinates, String str3, List list, int i, Object obj) {
            if (obj == null) {
                if ((i & 16) != 0) {
                    list = null;
                }
                advertDetailsView.showAddressOnMap(str, str2, coordinates, str3, list);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAddressOnMap");
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    void attach();

    void bindItemsList(@NotNull List<? extends SpannedItem> list, int i, @Nullable Integer num, @Nullable Integer num2);

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    void detach();

    void onDataSourceUnavailable();

    void onLoadError(@NotNull Throwable th);

    void onLoadFailed();

    void onLoadingFinish();

    void onLoadingStart();

    void refreshList();

    void removeToolbarShadow();

    @NotNull
    Observable<Integer> scrollStateChanges();

    void showAddressCopied();

    void showAddressOnMap(@Nullable String str, @NotNull String str2, @NotNull Coordinates coordinates, @NotNull String str3, @Nullable List<GeoReference> list);

    void showConsultationForm(@NotNull String str);

    void showEnableNotificationDialog();

    void showErrorDialog(@NotNull ErrorResult.ErrorDialog errorDialog, @NotNull Function0<Unit> function0);

    void showInactiveItem(@NotNull String str);

    void showNotificationsEnableWarning();

    void showPriceSubscriptionInfo();

    void showSnackbarAboveContactBar(@NotNull String str);

    void updateAddNoteResult(@Nullable String str);

    void updateMarketplaceDeliveryInfoItem(@Nullable MarketplaceDeliveryItem marketplaceDeliveryItem);
}
