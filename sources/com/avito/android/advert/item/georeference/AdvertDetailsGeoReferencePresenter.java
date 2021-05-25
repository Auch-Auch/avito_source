package com.avito.android.advert.item.georeference;

import com.avito.android.remote.model.Coordinates;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceView;", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceItem;", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenter$OpenMapListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setListener", "(Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenter$OpenMapListener;)V", "OpenMapListener", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsGeoReferencePresenter extends ItemPresenter<AdvertDetailsGeoReferenceView, AdvertDetailsGeoReferenceItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenter$OpenMapListener;", "", "", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "title", "", "onOpenMap", "(Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface OpenMapListener {
        void onOpenMap(@NotNull String str, @NotNull Coordinates coordinates, @NotNull String str2);
    }

    void setListener(@NotNull OpenMapListener openMapListener);
}
