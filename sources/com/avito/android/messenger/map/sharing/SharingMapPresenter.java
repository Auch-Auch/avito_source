package com.avito.android.messenger.map.sharing;

import androidx.lifecycle.LiveData;
import com.avito.android.authorization.event.SocialButtonClickedEventKt;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.map.sharing.SharingMapView;
import com.avito.android.remote.model.messenger.geo.GeoSearchSuggest;
import com.avito.android.remote.model.messenger.message.MessageBody;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H&¢\u0006\u0004\b\u0016\u0010\rJ\u000f\u0010\u0017\u001a\u00020\u0005H&¢\u0006\u0004\b\u0017\u0010\rR\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001aR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001a¨\u0006\""}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "", "causedByNewUserLocation", "", "cameraDraggingStarted", "(Z)V", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "newCameraPosition", "cameraPositionChanged", "(Lcom/avito/android/avito_map/AvitoMapCameraPosition;Z)V", "myLocationButtonClicked", "()V", "Lcom/avito/android/avito_map/AvitoMapPoint;", "point", "userLocationChanged", "(Lcom/avito/android/avito_map/AvitoMapPoint;)V", "Lcom/avito/android/remote/model/messenger/geo/GeoSearchSuggest;", SocialButtonClickedEventKt.SUGGEST, "selectedSearchSuggest", "(Lcom/avito/android/remote/model/messenger/geo/GeoSearchSuggest;)V", "editAddressClicked", "sendLocationButtonClicked", "Landroidx/lifecycle/LiveData;", "getRequestLocationStream", "()Landroidx/lifecycle/LiveData;", "requestLocationStream", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "getSendLocationEventsStream", "sendLocationEventsStream", "", "getEditAddressStream", "editAddressStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SharingMapPresenter extends MviEntity<SharingMapView.State> {
    void cameraDraggingStarted(boolean z);

    void cameraPositionChanged(@NotNull AvitoMapCameraPosition avitoMapCameraPosition, boolean z);

    void editAddressClicked();

    @NotNull
    LiveData<String> getEditAddressStream();

    @NotNull
    LiveData<Unit> getRequestLocationStream();

    @NotNull
    LiveData<MessageBody.Location> getSendLocationEventsStream();

    void myLocationButtonClicked();

    void selectedSearchSuggest(@NotNull GeoSearchSuggest geoSearchSuggest);

    void sendLocationButtonClicked();

    void userLocationChanged(@NotNull AvitoMapPoint avitoMapPoint);
}
