package com.avito.android.advert.item.show_on_map;

import com.avito.android.advert.item.show_on_map.AdvertDetailsShowOnMapView;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapPresenterImpl;", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapPresenter;", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapView;", "view", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapView;Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapItem;I)V", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setShowOnMapListener", "(Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapView$Listener;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapView$Listener;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsShowOnMapPresenterImpl implements AdvertDetailsShowOnMapPresenter {
    public AdvertDetailsShowOnMapView.Listener a;

    @Override // com.avito.android.advert.item.show_on_map.AdvertDetailsShowOnMapPresenter
    public void setShowOnMapListener(@NotNull AdvertDetailsShowOnMapView.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = listener;
    }

    public void bindView(@NotNull AdvertDetailsShowOnMapView advertDetailsShowOnMapView, @NotNull AdvertDetailsShowOnMapItem advertDetailsShowOnMapItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsShowOnMapView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsShowOnMapItem, "item");
        AdvertDetailsShowOnMapView.Listener listener = this.a;
        if (listener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
        advertDetailsShowOnMapView.addClickListener(advertDetailsShowOnMapItem, listener);
    }
}
