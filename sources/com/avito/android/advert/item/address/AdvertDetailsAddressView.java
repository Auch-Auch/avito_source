package com.avito.android.advert.item.address;

import com.avito.android.advert_core.analytics.address.GeoFromBlock;
import com.avito.android.remote.model.Coordinates;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000fJC\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/item/address/AdvertDetailsAddressView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "advertTitle", "", "hasReducedPadding", "showArrow", "Lcom/avito/android/advert/item/address/AdvertDetailsAddressView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showAddress", "(Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;ZZLcom/avito/android/advert/item/address/AdvertDetailsAddressView$Listener;)V", "Listener", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsAddressView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsAddressView advertDetailsAddressView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsAddressView);
        }

        public static /* synthetic */ void showAddress$default(AdvertDetailsAddressView advertDetailsAddressView, String str, Coordinates coordinates, String str2, boolean z, boolean z2, Listener listener, int i, Object obj) {
            if (obj == null) {
                advertDetailsAddressView.showAddress(str, coordinates, str2, (i & 8) != 0 ? false : z, z2, listener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAddress");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/item/address/AdvertDetailsAddressView$Listener;", "", "", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "title", "Lcom/avito/android/advert_core/analytics/address/GeoFromBlock;", "from", "", "onAddressClick", "(Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Lcom/avito/android/advert_core/analytics/address/GeoFromBlock;)V", "onAddressLongClick", "(Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onAddressClick(@NotNull String str, @NotNull Coordinates coordinates, @NotNull String str2, @NotNull GeoFromBlock geoFromBlock);

        void onAddressLongClick(@NotNull String str);
    }

    void showAddress(@NotNull String str, @Nullable Coordinates coordinates, @NotNull String str2, boolean z, boolean z2, @NotNull Listener listener);
}
