package com.avito.android.messenger.map.sharing;

import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.messenger.channels.mvi.common.v2.Action;
import com.avito.android.messenger.map.sharing.SharingMapView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/map/sharing/OnReconnectedAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/map/sharing/SharingMapView$State;)V", "Lkotlin/Function1;", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "c", "Lkotlin/jvm/functions/Function1;", "dispatchRetryAddressRequest", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class OnReconnectedAction extends Action<SharingMapView.State> {
    public final Function1<AvitoMapCameraPosition, Unit> c;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.avito_map.AvitoMapCameraPosition, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnReconnectedAction(@NotNull Function1<? super AvitoMapCameraPosition, Unit> function1) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(function1, "dispatchRetryAddressRequest");
        this.c = function1;
    }

    public void invoke(@NotNull SharingMapView.State state) {
        Intrinsics.checkNotNullParameter(state, "curState");
        if (state instanceof SharingMapView.State.Static.Error) {
            SharingMapView.State.Static.Error error = (SharingMapView.State.Static.Error) state;
            this.c.invoke(new AvitoMapCameraPosition(new AvitoMapPoint(error.getCameraState().getLat(), error.getCameraState().getLon()), error.getCameraState().getZoom(), 0.0f, null, null, 28, null));
        }
    }
}
