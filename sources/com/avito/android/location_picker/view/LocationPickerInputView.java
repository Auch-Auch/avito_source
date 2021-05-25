package com.avito.android.location_picker.view;

import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.location_picker.entities.ChangeAdvertsCountUpdate;
import com.avito.android.location_picker.entities.ChangeRadiusUpdate;
import com.avito.android.location_picker.entities.LocationPickerNotification;
import com.avito.android.location_picker.entities.RadiusWidgetUpdate;
import com.avito.android.remote.model.SearchRadius;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.location_picker.AddressSuggestion;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0005R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0005R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0005R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0005R\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0005R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0005R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020$0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0005R\u001e\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0005R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0005R\"\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0005¨\u00060"}, d2 = {"Lcom/avito/android/location_picker/view/LocationPickerInputView;", "", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/location_picker/entities/LocationPickerNotification;", "getChangeNotification", "()Lio/reactivex/rxjava3/functions/Consumer;", "changeNotification", "", "getCleanSearchQuery", "cleanSearchQuery", "", "getChangeChooseButtonIsActive", "changeChooseButtonIsActive", "getChangeProgressVisibility", "changeProgressVisibility", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "getCloseWithResults", "closeWithResults", "Lcom/avito/android/location_picker/entities/ChangeRadiusUpdate;", "getSelectRadiusBubble", "selectRadiusBubble", "", "getChangeSearchQuery", "changeSearchQuery", "getShowAddressValidationError", "showAddressValidationError", "getChangeRadiusVisibility", "changeRadiusVisibility", "Lcom/avito/android/location_picker/entities/RadiusWidgetUpdate;", "getChangeRadiusWidgetSize", "changeRadiusWidgetSize", "getLoadingIndicatorOnButton", "loadingIndicatorOnButton", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "getChangeCameraPosition", "changeCameraPosition", "Lcom/avito/android/location_picker/entities/ChangeAdvertsCountUpdate;", "getChangeAdvertsCount", "changeAdvertsCount", "Lcom/avito/android/remote/model/SearchRadius;", "getCloseWithRadiusResults", "closeWithRadiusResults", "getChangeSearchFocus", "changeSearchFocus", "", "Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", "getChangeShownSuggestions", "changeShownSuggestions", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public interface LocationPickerInputView {
    @NotNull
    Consumer<ChangeAdvertsCountUpdate> getChangeAdvertsCount();

    @NotNull
    Consumer<AvitoMapCameraPosition> getChangeCameraPosition();

    @NotNull
    Consumer<Boolean> getChangeChooseButtonIsActive();

    @NotNull
    Consumer<LocationPickerNotification> getChangeNotification();

    @NotNull
    Consumer<Boolean> getChangeProgressVisibility();

    @NotNull
    Consumer<Boolean> getChangeRadiusVisibility();

    @NotNull
    Consumer<RadiusWidgetUpdate> getChangeRadiusWidgetSize();

    @NotNull
    Consumer<Boolean> getChangeSearchFocus();

    @NotNull
    Consumer<String> getChangeSearchQuery();

    @NotNull
    Consumer<List<AddressSuggestion>> getChangeShownSuggestions();

    @NotNull
    Consumer<Unit> getCleanSearchQuery();

    @NotNull
    Consumer<SearchRadius> getCloseWithRadiusResults();

    @NotNull
    Consumer<AddressParameter.Value> getCloseWithResults();

    @NotNull
    Consumer<Boolean> getLoadingIndicatorOnButton();

    @NotNull
    Consumer<ChangeRadiusUpdate> getSelectRadiusBubble();

    @NotNull
    Consumer<String> getShowAddressValidationError();
}
