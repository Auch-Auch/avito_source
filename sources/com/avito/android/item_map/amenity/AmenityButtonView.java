package com.avito.android.item_map.amenity;

import com.avito.android.item_map.remote.model.AmenityButton;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/item_map/amenity/AmenityButtonView;", "", "Lcom/avito/android/item_map/remote/model/AmenityButton;", "data", "Lcom/avito/android/item_map/amenity/ButtonViewState;", "buttonViewState", "Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "bind", "(Lcom/avito/android/item_map/remote/model/AmenityButton;Lcom/avito/android/item_map/amenity/ButtonViewState;Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;)V", "", "loading", "showLoading", "(Z)V", "viewState", "setButtonColors", "(Lcom/avito/android/item_map/amenity/ButtonViewState;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
public interface AmenityButtonView {
    void bind(@NotNull AmenityButton amenityButton, @NotNull ButtonViewState buttonViewState, @NotNull AmenityButtonsPresenter amenityButtonsPresenter);

    void setButtonColors(@NotNull ButtonViewState buttonViewState);

    void showLoading(boolean z);
}
