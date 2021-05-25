package com.avito.android.messenger.map.sharing;

import com.avito.android.messenger.map.sharing.SharingMapView;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"messenger_release"}, k = 2, mv = {1, 4, 2})
public final class SharingMapPresenterKt {
    public static final SharingMapView.State access$resetForceMoveCamera(SharingMapView.State state) {
        if (!(state instanceof SharingMapView.State.Static)) {
            return state;
        }
        SharingMapView.State.Static r0 = (SharingMapView.State.Static) state;
        return r0.getForceMoveCamera() ? r0.withForceMoveCamera(false) : state;
    }
}
