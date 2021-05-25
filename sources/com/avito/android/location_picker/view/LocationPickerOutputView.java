package com.avito.android.location_picker.view;

import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.location_picker.analytics.ScreenCloseFromBlock;
import com.avito.android.remote.model.SearchRadius;
import com.avito.android.remote.model.location_picker.AddressSuggestion;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0005R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0005R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0005R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0005R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0005R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0005R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0005R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0005R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0005R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0005R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0005R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0005R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0005R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0005R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0005¨\u00066"}, d2 = {"Lcom/avito/android/location_picker/view/LocationPickerOutputView;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/location_picker/analytics/ScreenCloseFromBlock;", "getScreenClosed", "()Lio/reactivex/rxjava3/core/Observable;", "screenClosed", "", "getDialogOkButtonClicked", "dialogOkButtonClicked", "getFindMeClicked", "findMeClicked", "getChooseClicked", "chooseClicked", "getSettingsClicked", "settingsClicked", "Lcom/avito/android/avito_map/AvitoMapBounds;", "getCameraMoveEnd", "cameraMoveEnd", "getMapInitialized", "mapInitialized", "", "getSearchFocus", "searchFocus", "getCleanQueryClicked", "cleanQueryClicked", "", "getSearchClicked", "searchClicked", "getMapConcealerClicked", "mapConcealerClicked", "Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", "getSuggestionClicked", "suggestionClicked", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "getCameraIdlePositionChanged", "cameraIdlePositionChanged", "getTextQueryChanged", "textQueryChanged", "getVisibleRegionChanged", "visibleRegionChanged", "Lcom/avito/android/remote/model/SearchRadius;", "getRadiusClicked", "radiusClicked", "getSelectRadiusButtonClicked", "selectRadiusButtonClicked", "getCameraMoveStart", "cameraMoveStart", "getBackClicked", "backClicked", "getRetryClicked", "retryClicked", "getCameraMovedByGesture", "cameraMovedByGesture", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public interface LocationPickerOutputView {
    @NotNull
    Observable<Unit> getBackClicked();

    @NotNull
    Observable<AvitoMapCameraPosition> getCameraIdlePositionChanged();

    @NotNull
    Observable<AvitoMapBounds> getCameraMoveEnd();

    @NotNull
    Observable<Unit> getCameraMoveStart();

    @NotNull
    Observable<Unit> getCameraMovedByGesture();

    @NotNull
    Observable<Unit> getChooseClicked();

    @NotNull
    Observable<Unit> getCleanQueryClicked();

    @NotNull
    Observable<Unit> getDialogOkButtonClicked();

    @NotNull
    Observable<Unit> getFindMeClicked();

    @NotNull
    Observable<Unit> getMapConcealerClicked();

    @NotNull
    Observable<Unit> getMapInitialized();

    @NotNull
    Observable<SearchRadius> getRadiusClicked();

    @NotNull
    Observable<Unit> getRetryClicked();

    @NotNull
    Observable<ScreenCloseFromBlock> getScreenClosed();

    @NotNull
    Observable<String> getSearchClicked();

    @NotNull
    Observable<Boolean> getSearchFocus();

    @NotNull
    Observable<Unit> getSelectRadiusButtonClicked();

    @NotNull
    Observable<Unit> getSettingsClicked();

    @NotNull
    Observable<AddressSuggestion> getSuggestionClicked();

    @NotNull
    Observable<String> getTextQueryChanged();

    @NotNull
    Observable<AvitoMapBounds> getVisibleRegionChanged();
}
