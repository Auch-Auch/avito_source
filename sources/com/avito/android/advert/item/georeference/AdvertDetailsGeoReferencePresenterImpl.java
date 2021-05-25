package com.avito.android.advert.item.georeference;

import com.avito.android.advert.item.georeference.AdvertDetailsGeoReferencePresenter;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u000b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenterImpl;", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenter;", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceView;", "view", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceView;Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceItem;I)V", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenter$OpenMapListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenter$OpenMapListener;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenter$OpenMapListener;", "openMapListener", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsGeoReferencePresenterImpl implements AdvertDetailsGeoReferencePresenter {
    public AdvertDetailsGeoReferencePresenter.OpenMapListener a;

    @Override // com.avito.android.advert.item.georeference.AdvertDetailsGeoReferencePresenter
    public void setListener(@NotNull AdvertDetailsGeoReferencePresenter.OpenMapListener openMapListener) {
        Intrinsics.checkNotNullParameter(openMapListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = openMapListener;
    }

    public void bindView(@NotNull AdvertDetailsGeoReferenceView advertDetailsGeoReferenceView, @NotNull AdvertDetailsGeoReferenceItem advertDetailsGeoReferenceItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsGeoReferenceView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsGeoReferenceItem, "item");
        AdvertDetailsGeoReferencePresenter.OpenMapListener openMapListener = this.a;
        if (openMapListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("openMapListener");
        }
        advertDetailsGeoReferenceView.bindContent(advertDetailsGeoReferenceItem, openMapListener);
    }
}
