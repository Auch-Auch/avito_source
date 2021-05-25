package com.avito.android.messenger.map.sharing;

import androidx.lifecycle.MutableLiveData;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.map.sharing.SharingMapView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/map/sharing/MyLocationButtonClickedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/map/sharing/SharingMapView$State;)Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "Landroidx/lifecycle/MutableLiveData;", "", "c", "Landroidx/lifecycle/MutableLiveData;", "requestLocationStream", "<init>", "(Landroidx/lifecycle/MutableLiveData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MyLocationButtonClickedMutator extends Mutator<SharingMapView.State> {
    public final MutableLiveData<Unit> c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MyLocationButtonClickedMutator(@NotNull MutableLiveData<Unit> mutableLiveData) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(mutableLiveData, "requestLocationStream");
        this.c = mutableLiveData;
    }

    @NotNull
    public SharingMapView.State invoke(@NotNull SharingMapView.State state) {
        Intrinsics.checkNotNullParameter(state, "oldState");
        if ((state instanceof SharingMapView.State.Dragging) && !state.getAwaitingNewUserLocation()) {
            return state;
        }
        this.c.postValue(Unit.INSTANCE);
        if (state.getAwaitingNewUserLocation()) {
            return state;
        }
        SharingMapView.State withAwaitingNewUserLocation = state.withAwaitingNewUserLocation(true);
        if (!(withAwaitingNewUserLocation instanceof SharingMapView.State.Static)) {
            return withAwaitingNewUserLocation;
        }
        SharingMapView.State.Static r0 = (SharingMapView.State.Static) withAwaitingNewUserLocation;
        return r0.getForceMoveCamera() ? r0.withForceMoveCamera(false) : withAwaitingNewUserLocation;
    }
}
