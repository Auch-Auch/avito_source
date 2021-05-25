package com.avito.android.advert.item.show_on_map;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapItem;", "item", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addClickListener", "(Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapItem;Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapView$Listener;)V", "Listener", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsShowOnMapView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsShowOnMapView advertDetailsShowOnMapView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsShowOnMapView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapView$Listener;", "", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapItem;", "item", "", "onShowOnMapClick", "(Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapItem;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onShowOnMapClick(@NotNull AdvertDetailsShowOnMapItem advertDetailsShowOnMapItem);
    }

    void addClickListener(@NotNull AdvertDetailsShowOnMapItem advertDetailsShowOnMapItem, @NotNull Listener listener);
}
