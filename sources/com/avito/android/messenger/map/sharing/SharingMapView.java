package com.avito.android.messenger.map.sharing;

import a2.b.a.a.a;
import a2.g.r.g;
import androidx.annotation.StringRes;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.messenger.channels.mvi.common.v2.Renderer;
import com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView;
import com.avito.android.messenger.map.MapBottomSheet;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.r.a.j;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001f !J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\u0005J#\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011¨\u0006\""}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapView;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "", "onStart", "()V", "onStop", "onDestroy", "onLowMemory", "showFindLocationError", "", "stringId", "duration", "showError", "(II)V", "Lio/reactivex/rxjava3/core/Observable;", "getFindLocationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "findLocationClicks", "getSendLocationButtonClicks", "sendLocationButtonClicks", "", "getMapIsReadyStream", "mapIsReadyStream", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "getCameraPositionStream", "cameraPositionStream", "getCameraDraggingStartedStream", "cameraDraggingStartedStream", "getEditAddressClicks", "editAddressClicks", "CameraState", "ControlsState", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SharingMapView extends Renderer<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapView$CameraState;", "", "", "component1", "()D", "component2", "", "component3", "()F", "lat", MessageBody.Location.LONGITUDE, "zoom", "copy", "(DDF)Lcom/avito/android/messenger/map/sharing/SharingMapView$CameraState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "F", "getZoom", AuthSource.BOOKING_ORDER, "D", "getLon", AuthSource.SEND_ABUSE, "getLat", "<init>", "(DDF)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class CameraState {
        public final double a;
        public final double b;
        public final float c;

        public CameraState(double d, double d2, float f) {
            this.a = d;
            this.b = d2;
            this.c = f;
        }

        public static /* synthetic */ CameraState copy$default(CameraState cameraState, double d, double d2, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                d = cameraState.a;
            }
            if ((i & 2) != 0) {
                d2 = cameraState.b;
            }
            if ((i & 4) != 0) {
                f = cameraState.c;
            }
            return cameraState.copy(d, d2, f);
        }

        public final double component1() {
            return this.a;
        }

        public final double component2() {
            return this.b;
        }

        public final float component3() {
            return this.c;
        }

        @NotNull
        public final CameraState copy(double d, double d2, float f) {
            return new CameraState(d, d2, f);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CameraState)) {
                return false;
            }
            CameraState cameraState = (CameraState) obj;
            return Double.compare(this.a, cameraState.a) == 0 && Double.compare(this.b, cameraState.b) == 0 && Float.compare(this.c, cameraState.c) == 0;
        }

        public final double getLat() {
            return this.a;
        }

        public final double getLon() {
            return this.b;
        }

        public final float getZoom() {
            return this.c;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.c) + (((b.a(this.a) * 31) + b.a(this.b)) * 31);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("CameraState(lat=");
            L.append(this.a);
            L.append(", lon=");
            L.append(this.b);
            L.append(", zoom=");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u0001\u0003\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState;", "", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/messenger/map/MapBottomSheet$State;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/map/MapBottomSheet$State;", "getBottomSheetState", "()Lcom/avito/android/messenger/map/MapBottomSheet$State;", "bottomSheetState", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "getConnectionErrorIndicatorState", "()Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "connectionErrorIndicatorState", "HideAll", "ShowBottomSheet", "ShowError", "Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState$HideAll;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState$ShowBottomSheet;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState$ShowError;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ControlsState {
        @NotNull
        public final ConnectionErrorIndicatorView.State a;
        @NotNull
        public final MapBottomSheet.State b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState$HideAll;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class HideAll extends ControlsState {
            @NotNull
            public static final HideAll INSTANCE = new HideAll();

            public HideAll() {
                super(ConnectionErrorIndicatorView.State.Hidden.INSTANCE, MapBottomSheet.State.Closed.INSTANCE, null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState$ShowBottomSheet;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState;", "ButtonsDisabled", "ButtonsEnabled", "Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState$ShowBottomSheet$ButtonsEnabled;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState$ShowBottomSheet$ButtonsDisabled;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class ShowBottomSheet extends ControlsState {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState$ShowBottomSheet$ButtonsDisabled;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState$ShowBottomSheet;", "", "title", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class ButtonsDisabled extends ShowBottomSheet {
                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public ButtonsDisabled(@NotNull String str) {
                    super(new MapBottomSheet.State.Expanded("", d.listOf(str), false, false, true, false, 32, null), null);
                    Intrinsics.checkNotNullParameter(str, "title");
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState$ShowBottomSheet$ButtonsEnabled;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState$ShowBottomSheet;", "", "title", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class ButtonsEnabled extends ShowBottomSheet {
                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public ButtonsEnabled(@NotNull String str) {
                    super(new MapBottomSheet.State.Expanded("", d.listOf(str), false, true, true, false, 32, null), null);
                    Intrinsics.checkNotNullParameter(str, "title");
                }
            }

            public ShowBottomSheet(MapBottomSheet.State.Expanded expanded, j jVar) {
                super(ConnectionErrorIndicatorView.State.Hidden.INSTANCE, expanded, null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState$ShowError;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState;", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State$Shown$Error;", "connectionErrorIndicatorState", "<init>", "(Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State$Shown$Error;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShowError extends ControlsState {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ShowError(@NotNull ConnectionErrorIndicatorView.State.Shown.Error error) {
                super(error, MapBottomSheet.State.Closed.INSTANCE, null);
                Intrinsics.checkNotNullParameter(error, "connectionErrorIndicatorState");
            }
        }

        public ControlsState(ConnectionErrorIndicatorView.State state, MapBottomSheet.State state2, j jVar) {
            this.a = state;
            this.b = state2;
        }

        @NotNull
        public final MapBottomSheet.State getBottomSheetState() {
            return this.b;
        }

        @NotNull
        public final ConnectionErrorIndicatorView.State getConnectionErrorIndicatorState() {
            return this.a;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("ControlsState(connectionErrorIndicatorState=");
            L.append(this.a);
            L.append(", bottomSheetState=");
            L.append(this.b);
            L.append(')');
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull SharingMapView sharingMapView, @NotNull State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            Renderer.DefaultImpls.render(sharingMapView, state);
        }

        public static /* synthetic */ void showError$default(SharingMapView sharingMapView, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i2 = 0;
                }
                sharingMapView.showError(i, i2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showError");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u001f !J\u0019\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u0001\u0003\"#$¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "", "Lcom/avito/android/avito_map/AvitoMapPoint;", "newUserPoint", "withNewUserLocation", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "", "awaitingNewUserLocation", "withAwaitingNewUserLocation", "(Z)Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "", "c", "Ljava/lang/String;", "getBottomSheetTitle", "()Ljava/lang/String;", "bottomSheetTitle", AuthSource.SEND_ABUSE, "Lcom/avito/android/avito_map/AvitoMapPoint;", "getUserPoint", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "userPoint", "Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState;", "getControlsState", "()Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState;", "controlsState", "d", "Z", "getAwaitingNewUserLocation", "()Z", "Dragging", "Empty", "Static", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State$Empty;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State$Dragging;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State$Static;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {
        @Nullable
        public final AvitoMapPoint a;
        @NotNull
        public final ControlsState b;
        @NotNull
        public final String c;
        public final boolean d;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapView$State$Dragging;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "newUserPoint", "withNewUserLocation", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Lcom/avito/android/messenger/map/sharing/SharingMapView$State$Dragging;", "", "awaitingNewUserLocation", "withAwaitingNewUserLocation", "(Z)Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$CameraState;", "e", "Lcom/avito/android/messenger/map/sharing/SharingMapView$CameraState;", "getPrevCameraState", "()Lcom/avito/android/messenger/map/sharing/SharingMapView$CameraState;", "prevCameraState", "userPoint", "bottomSheetTitle", "<init>", "(Lcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/String;ZLcom/avito/android/messenger/map/sharing/SharingMapView$CameraState;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Dragging extends State {
            @Nullable
            public final CameraState e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Dragging(@Nullable AvitoMapPoint avitoMapPoint, @NotNull String str, boolean z, @Nullable CameraState cameraState) {
                super(avitoMapPoint, new ControlsState.ShowBottomSheet.ButtonsDisabled(str), str, z, null);
                Intrinsics.checkNotNullParameter(str, "bottomSheetTitle");
                this.e = cameraState;
            }

            @Nullable
            public final CameraState getPrevCameraState() {
                return this.e;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("State.Dragging(\n                    |   userPoint=");
                L.append(getUserPoint());
                L.append(",\n                    |   controlsState=");
                L.append(getControlsState());
                L.append(",\n                    |   bottomSheetTitle=");
                L.append(getBottomSheetTitle());
                L.append(",\n                    |   awaitingNewUserLocation=");
                L.append(getAwaitingNewUserLocation());
                L.append(",\n                    |   prevCameraState=");
                L.append(this.e);
                L.append("\n                    |)");
                return f.trimMargin$default(L.toString(), null, 1, null);
            }

            @Override // com.avito.android.messenger.map.sharing.SharingMapView.State
            @NotNull
            public State withAwaitingNewUserLocation(boolean z) {
                return new Dragging(getUserPoint(), getBottomSheetTitle(), z, this.e);
            }

            @Override // com.avito.android.messenger.map.sharing.SharingMapView.State
            @NotNull
            public Dragging withNewUserLocation(@Nullable AvitoMapPoint avitoMapPoint) {
                return new Dragging(avitoMapPoint, getBottomSheetTitle(), getAwaitingNewUserLocation(), this.e);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0004\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapView$State$Empty;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "newUserPoint", "withNewUserLocation", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "", "awaitingNewUserLocation", "withAwaitingNewUserLocation", "(Z)Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null, ControlsState.HideAll.INSTANCE, "", false, null);
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("State.Empty(\n                    |userPoint=");
                L.append(getUserPoint());
                L.append(",\n                    |controlsState=");
                L.append(getControlsState());
                L.append(",\n                    |bottomSheetTitle=");
                L.append(getBottomSheetTitle());
                L.append(",\n                    |awaitingNewUserLocation=");
                L.append(getAwaitingNewUserLocation());
                L.append("\n                    |)");
                return f.trimMargin$default(L.toString(), null, 1, null);
            }

            @Override // com.avito.android.messenger.map.sharing.SharingMapView.State
            @NotNull
            public State withAwaitingNewUserLocation(boolean z) {
                return this;
            }

            @Override // com.avito.android.messenger.map.sharing.SharingMapView.State
            @NotNull
            public State withNewUserLocation(@Nullable AvitoMapPoint avitoMapPoint) {
                return this;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0019\u001aJ\u0017\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u0001\u0002\u001b\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapView$State$Static;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "", "forceMoveCamera", "withForceMoveCamera", "(Z)Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$CameraState;", "f", "Lcom/avito/android/messenger/map/sharing/SharingMapView$CameraState;", "getCameraState", "()Lcom/avito/android/messenger/map/sharing/SharingMapView$CameraState;", "cameraState", g.a, "Z", "getForceMoveCamera", "()Z", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "e", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "getGeoPosition", "()Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "geoPosition", "Error", "Loaded", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State$Static$Loaded;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State$Static$Error;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Static extends State {
            @NotNull
            public final MessageBody.Location e;
            @NotNull
            public final CameraState f;
            public final boolean g;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapView$State$Static$Error;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State$Static;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "newUserPoint", "withNewUserLocation", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Lcom/avito/android/messenger/map/sharing/SharingMapView$State$Static$Error;", "", "awaitingNewUserLocation", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "withAwaitingNewUserLocation", "(Z)Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "forceMoveCamera", "withForceMoveCamera", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "geoPosition", "Lcom/avito/android/messenger/map/sharing/SharingMapView$CameraState;", "cameraState", "userPoint", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State$Shown$Error;", "connectionErrorIndicatorState", "", "bottomSheetTitle", "<init>", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;Lcom/avito/android/messenger/map/sharing/SharingMapView$CameraState;Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State$Shown$Error;Ljava/lang/String;ZZ)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Error extends Static {
                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Error(@NotNull MessageBody.Location location, @NotNull CameraState cameraState, @Nullable AvitoMapPoint avitoMapPoint, @NotNull ConnectionErrorIndicatorView.State.Shown.Error error, @NotNull String str, boolean z, boolean z2) {
                    super(location, cameraState, avitoMapPoint, new ControlsState.ShowError(error), str, z, z2, null);
                    Intrinsics.checkNotNullParameter(location, "geoPosition");
                    Intrinsics.checkNotNullParameter(cameraState, "cameraState");
                    Intrinsics.checkNotNullParameter(error, "connectionErrorIndicatorState");
                    Intrinsics.checkNotNullParameter(str, "bottomSheetTitle");
                }

                @Override // com.avito.android.messenger.map.sharing.SharingMapView.State
                @NotNull
                public State withAwaitingNewUserLocation(boolean z) {
                    MessageBody.Location geoPosition = getGeoPosition();
                    CameraState cameraState = getCameraState();
                    AvitoMapPoint userPoint = getUserPoint();
                    ConnectionErrorIndicatorView.State connectionErrorIndicatorState = getControlsState().getConnectionErrorIndicatorState();
                    Objects.requireNonNull(connectionErrorIndicatorState, "null cannot be cast to non-null type com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView.State.Shown.Error");
                    return new Error(geoPosition, cameraState, userPoint, (ConnectionErrorIndicatorView.State.Shown.Error) connectionErrorIndicatorState, getBottomSheetTitle(), z, getForceMoveCamera());
                }

                @Override // com.avito.android.messenger.map.sharing.SharingMapView.State.Static
                @NotNull
                public State withForceMoveCamera(boolean z) {
                    MessageBody.Location geoPosition = getGeoPosition();
                    CameraState cameraState = getCameraState();
                    AvitoMapPoint userPoint = getUserPoint();
                    ConnectionErrorIndicatorView.State connectionErrorIndicatorState = getControlsState().getConnectionErrorIndicatorState();
                    Objects.requireNonNull(connectionErrorIndicatorState, "null cannot be cast to non-null type com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView.State.Shown.Error");
                    return new Error(geoPosition, cameraState, userPoint, (ConnectionErrorIndicatorView.State.Shown.Error) connectionErrorIndicatorState, getBottomSheetTitle(), getAwaitingNewUserLocation(), z);
                }

                @Override // com.avito.android.messenger.map.sharing.SharingMapView.State
                @NotNull
                public Error withNewUserLocation(@Nullable AvitoMapPoint avitoMapPoint) {
                    MessageBody.Location geoPosition = getGeoPosition();
                    CameraState cameraState = getCameraState();
                    ConnectionErrorIndicatorView.State connectionErrorIndicatorState = getControlsState().getConnectionErrorIndicatorState();
                    Objects.requireNonNull(connectionErrorIndicatorState, "null cannot be cast to non-null type com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView.State.Shown.Error");
                    return new Error(geoPosition, cameraState, avitoMapPoint, (ConnectionErrorIndicatorView.State.Shown.Error) connectionErrorIndicatorState, getBottomSheetTitle(), getAwaitingNewUserLocation(), getForceMoveCamera());
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapView$State$Static$Loaded;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State$Static;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "newUserPoint", "withNewUserLocation", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Lcom/avito/android/messenger/map/sharing/SharingMapView$State$Static$Loaded;", "", "awaitingNewUserLocation", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "withAwaitingNewUserLocation", "(Z)Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "forceMoveCamera", "withForceMoveCamera", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "geoPosition", "Lcom/avito/android/messenger/map/sharing/SharingMapView$CameraState;", "cameraState", "userPoint", "bottomSheetTitle", "<init>", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;Lcom/avito/android/messenger/map/sharing/SharingMapView$CameraState;Lcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/String;ZZ)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Loaded extends Static {
                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Loaded(@NotNull MessageBody.Location location, @NotNull CameraState cameraState, @Nullable AvitoMapPoint avitoMapPoint, @NotNull String str, boolean z, boolean z2) {
                    super(location, cameraState, avitoMapPoint, new ControlsState.ShowBottomSheet.ButtonsEnabled(str), str, z, z2, null);
                    Intrinsics.checkNotNullParameter(location, "geoPosition");
                    Intrinsics.checkNotNullParameter(cameraState, "cameraState");
                    Intrinsics.checkNotNullParameter(str, "bottomSheetTitle");
                }

                @Override // com.avito.android.messenger.map.sharing.SharingMapView.State.Static
                @NotNull
                public String toString() {
                    StringBuilder L = a.L("State.Static.Loaded(\n                    |geoPosition=");
                    L.append(getGeoPosition());
                    L.append(",\n                    |cameraState=");
                    L.append(getCameraState());
                    L.append(",\n                    |controlsState=");
                    L.append(getControlsState());
                    L.append(",\n                    |bottomSheetTitle=");
                    L.append(getBottomSheetTitle());
                    L.append(",\n                    |awaitingNewUserLocation=");
                    L.append(getAwaitingNewUserLocation());
                    L.append(",\n                    |forceMoveCamera=");
                    L.append(getForceMoveCamera());
                    L.append("\n                    |)");
                    return f.trimMargin$default(L.toString(), null, 1, null);
                }

                @Override // com.avito.android.messenger.map.sharing.SharingMapView.State
                @NotNull
                public State withAwaitingNewUserLocation(boolean z) {
                    return new Loaded(getGeoPosition(), getCameraState(), getUserPoint(), getBottomSheetTitle(), z, getForceMoveCamera());
                }

                @Override // com.avito.android.messenger.map.sharing.SharingMapView.State.Static
                @NotNull
                public State withForceMoveCamera(boolean z) {
                    return new Loaded(getGeoPosition(), getCameraState(), getUserPoint(), getBottomSheetTitle(), getAwaitingNewUserLocation(), z);
                }

                @Override // com.avito.android.messenger.map.sharing.SharingMapView.State
                @NotNull
                public Loaded withNewUserLocation(@Nullable AvitoMapPoint avitoMapPoint) {
                    return new Loaded(getGeoPosition(), getCameraState(), avitoMapPoint, getBottomSheetTitle(), getAwaitingNewUserLocation(), getForceMoveCamera());
                }
            }

            public Static(MessageBody.Location location, CameraState cameraState, AvitoMapPoint avitoMapPoint, ControlsState controlsState, String str, boolean z, boolean z2, j jVar) {
                super(avitoMapPoint, controlsState, str, z, null);
                this.e = location;
                this.f = cameraState;
                this.g = z2;
            }

            @NotNull
            public final CameraState getCameraState() {
                return this.f;
            }

            public final boolean getForceMoveCamera() {
                return this.g;
            }

            @NotNull
            public final MessageBody.Location getGeoPosition() {
                return this.e;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("State.Static.Error(\n                    |geoPosition=");
                L.append(this.e);
                L.append(",\n                    |cameraState=");
                L.append(this.f);
                L.append(",\n                    |controlsState=");
                L.append(getControlsState());
                L.append(",\n                    |bottomSheetTitle=");
                L.append(getBottomSheetTitle());
                L.append(",\n                    |awaitingNewUserLocation=");
                L.append(getAwaitingNewUserLocation());
                L.append("\n                    |)");
                return f.trimMargin$default(L.toString(), null, 1, null);
            }

            @NotNull
            public abstract State withForceMoveCamera(boolean z);
        }

        public State(AvitoMapPoint avitoMapPoint, ControlsState controlsState, String str, boolean z, j jVar) {
            this.a = avitoMapPoint;
            this.b = controlsState;
            this.c = str;
            this.d = z;
        }

        public final boolean getAwaitingNewUserLocation() {
            return this.d;
        }

        @NotNull
        public final String getBottomSheetTitle() {
            return this.c;
        }

        @NotNull
        public final ControlsState getControlsState() {
            return this.b;
        }

        @Nullable
        public final AvitoMapPoint getUserPoint() {
            return this.a;
        }

        @NotNull
        public abstract State withAwaitingNewUserLocation(boolean z);

        @NotNull
        public abstract State withNewUserLocation(@Nullable AvitoMapPoint avitoMapPoint);
    }

    @NotNull
    Observable<Unit> getCameraDraggingStartedStream();

    @NotNull
    Observable<AvitoMapCameraPosition> getCameraPositionStream();

    @NotNull
    Observable<Unit> getEditAddressClicks();

    @NotNull
    Observable<Unit> getFindLocationClicks();

    @NotNull
    Observable<Boolean> getMapIsReadyStream();

    @NotNull
    Observable<Unit> getSendLocationButtonClicks();

    void onDestroy();

    void onLowMemory();

    void onStart();

    void onStop();

    void showError(@StringRes int i, int i2);

    void showFindLocationError();
}
