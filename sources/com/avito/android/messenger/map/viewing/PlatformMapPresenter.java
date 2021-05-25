package com.avito.android.messenger.map.viewing;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.map.viewing.view.Pin;
import com.avito.android.messenger.map.viewing.view.PlatformMapView;
import com.avito.android.remote.model.Coordinates;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.bottom_sheet.BottomSheet;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\tJ\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H&¢\u0006\u0004\b\u0015\u0010\tJ\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001dR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001dR\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020$0\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001dR\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001d¨\u0006*"}, d2 = {"Lcom/avito/android/messenger/map/viewing/PlatformMapPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State;", "Lcom/avito/android/messenger/map/viewing/view/Pin;", "clickedPin", "", "pinClicked", "(Lcom/avito/android/messenger/map/viewing/view/Pin;)V", "cameraDraggingStarted", "()V", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "newCameraPosition", "", "causedByNewUserLocation", "cameraPositionChanged", "(Lcom/avito/android/avito_map/AvitoMapCameraPosition;Z)V", "myLocationButtonClicked", "Lcom/avito/android/avito_map/AvitoMapPoint;", "point", "userLocationChanged", "(Lcom/avito/android/avito_map/AvitoMapPoint;)V", "createRouteButtonClicked", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "bottomSheetVisibilityChanged", "(Lru/avito/component/bottom_sheet/BottomSheet$Visibility;)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLinkClicksStream", "()Landroidx/lifecycle/LiveData;", "deepLinkClicksStream", "", "getGeoMarkersLoadingErrorsStream", "geoMarkersLoadingErrorsStream", "getRequestLocationStream", "requestLocationStream", "Lcom/avito/android/remote/model/Coordinates;", "getCreateRouteClicksStream", "createRouteClicksStream", "Landroid/net/Uri;", "getUriClicksStream", "uriClicksStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface PlatformMapPresenter extends MviEntity<PlatformMapView.State> {
    void bottomSheetVisibilityChanged(@NotNull BottomSheet.Visibility visibility);

    void cameraDraggingStarted();

    void cameraPositionChanged(@NotNull AvitoMapCameraPosition avitoMapCameraPosition, boolean z);

    void createRouteButtonClicked();

    @NotNull
    LiveData<Coordinates> getCreateRouteClicksStream();

    @NotNull
    LiveData<DeepLink> getDeepLinkClicksStream();

    @NotNull
    LiveData<String> getGeoMarkersLoadingErrorsStream();

    @NotNull
    LiveData<Unit> getRequestLocationStream();

    @NotNull
    LiveData<Uri> getUriClicksStream();

    void myLocationButtonClicked();

    void pinClicked(@NotNull Pin pin);

    void userLocationChanged(@NotNull AvitoMapPoint avitoMapPoint);
}
