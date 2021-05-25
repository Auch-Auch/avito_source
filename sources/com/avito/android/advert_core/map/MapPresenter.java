package com.avito.android.advert_core.map;

import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert_core/map/MapPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert_core/map/MapView;", "Lcom/avito/android/advert_core/map/MapItem;", "Lcom/avito/android/advert_core/map/MapPreviewRouter;", "router", "", "attachRouter", "(Lcom/avito/android/advert_core/map/MapPreviewRouter;)V", "detachRouter", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface MapPresenter extends ItemPresenter<MapView, MapItem> {
    void attachRouter(@Nullable MapPreviewRouter mapPreviewRouter);

    void detachRouter();
}
