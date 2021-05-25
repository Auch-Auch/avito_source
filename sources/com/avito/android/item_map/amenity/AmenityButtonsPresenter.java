package com.avito.android.item_map.amenity;

import com.avito.android.item_map.view.ItemMapView;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;", "", "Lcom/avito/android/item_map/view/ItemMapView;", "view", "", "attachMapView", "(Lcom/avito/android/item_map/view/ItemMapView;)V", "Lcom/avito/android/item_map/amenity/AmenityButtonsViewBinder;", "attachButtonsView", "(Lcom/avito/android/item_map/amenity/AmenityButtonsViewBinder;)V", "detachViews", "()V", "Lcom/avito/android/util/Kundle;", "kundle", "onRestoreState", "(Lcom/avito/android/util/Kundle;)V", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "type", "onAmenityButtonClick", "(Ljava/lang/String;)V", "Lcom/avito/android/item_map/amenity/ButtonViewState;", "getAmenityButtonViewState", "(Ljava/lang/String;)Lcom/avito/android/item_map/amenity/ButtonViewState;", "item-map_release"}, k = 1, mv = {1, 4, 2})
public interface AmenityButtonsPresenter {
    void attachButtonsView(@Nullable AmenityButtonsViewBinder amenityButtonsViewBinder);

    void attachMapView(@Nullable ItemMapView itemMapView);

    void detachViews();

    @NotNull
    ButtonViewState getAmenityButtonViewState(@NotNull String str);

    void onAmenityButtonClick(@NotNull String str);

    void onRestoreState(@Nullable Kundle kundle);

    @NotNull
    Kundle onSaveState();
}
