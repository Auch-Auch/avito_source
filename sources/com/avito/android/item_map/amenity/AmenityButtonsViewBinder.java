package com.avito.android.item_map.amenity;

import com.avito.android.item_map.remote.model.AmenityButton;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/item_map/amenity/AmenityButtonsViewBinder;", "", "", "Lcom/avito/android/item_map/remote/model/AmenityButton;", "amenityButtons", "Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;", "presenter", "", "bindData", "(Ljava/util/List;Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;)V", "", "type", "", "loading", "showLoading", "(Ljava/lang/String;Z)V", "Lcom/avito/android/item_map/amenity/ButtonViewState;", "viewState", "setButtonColors", "(Ljava/lang/String;Lcom/avito/android/item_map/amenity/ButtonViewState;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
public interface AmenityButtonsViewBinder {
    void bindData(@NotNull List<AmenityButton> list, @NotNull AmenityButtonsPresenter amenityButtonsPresenter);

    void setButtonColors(@NotNull String str, @NotNull ButtonViewState buttonViewState);

    void showLoading(@NotNull String str, boolean z);
}
