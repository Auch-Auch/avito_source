package com.avito.android.messenger.map.viewing.view;

import a2.b.a.a.a;
import a2.g.r.g;
import androidx.annotation.StringRes;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapCameraUpdate;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.messenger.channels.mvi.common.v2.Renderer;
import com.avito.android.messenger.map.MapBottomSheet;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.rxjava3.core.Observable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.bottom_sheet.BottomSheet;
import t6.n.y;
import t6.r.a.j;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\u0005J#\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0011R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0011¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/map/viewing/view/PlatformMapView;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;", "Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State;", "", "onStart", "()V", "onStop", "onDestroy", "onLowMemory", "showFindLocationError", "", "stringId", "duration", "showError", "(II)V", "Lio/reactivex/rxjava3/core/Observable;", "getFindLocationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "findLocationClicks", "Lcom/avito/android/messenger/map/viewing/view/Pin;", "getPinClicks", "pinClicks", "getCreateRouteButtonClicks", "createRouteButtonClicks", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", "getBottomSheetVisibilityStream", "bottomSheetVisibilityStream", "", "getMapIsReady", "mapIsReady", "getCameraDraggingStartedStream", "cameraDraggingStartedStream", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "getCameraPosition", "cameraPosition", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface PlatformMapView extends Renderer<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull PlatformMapView platformMapView, @NotNull State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            Renderer.DefaultImpls.render(platformMapView, state);
        }

        public static /* synthetic */ void showError$default(PlatformMapView platformMapView, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i2 = 0;
                }
                platformMapView.showError(i, i2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showError");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u001b\b\b\u0018\u0000 :2\u00020\u0001:\u0001:BI\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0012¢\u0006\u0004\b8\u00109J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0014J`\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0018\u001a\u00020\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u0012HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\bR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u000eR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0011R\u0019\u0010\u001c\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0014R\u0019\u0010\u001b\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b2\u00100\u001a\u0004\b\u001b\u0010\u0014R\u0019\u0010\u0018\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u000bR\u0019\u0010\u001d\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b6\u00100\u001a\u0004\b7\u0010\u0014¨\u0006;"}, d2 = {"Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State;", "", "", "toString", "()Ljava/lang/String;", "", "Lcom/avito/android/messenger/map/viewing/view/Pin;", "component1", "()Ljava/util/Set;", "Lcom/avito/android/messenger/map/MapBottomSheet$State;", "component2", "()Lcom/avito/android/messenger/map/MapBottomSheet$State;", "Lcom/avito/android/avito_map/AvitoMapCameraUpdate;", "component3", "()Lcom/avito/android/avito_map/AvitoMapCameraUpdate;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "component4", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "", "component5", "()Z", "component6", "component7", "pins", "bottomSheetState", "cameraUpdate", "userPoint", "isDragging", "awaitingNewUserLocation", "forceMoveCamera", "copy", "(Ljava/util/Set;Lcom/avito/android/messenger/map/MapBottomSheet$State;Lcom/avito/android/avito_map/AvitoMapCameraUpdate;Lcom/avito/android/avito_map/AvitoMapPoint;ZZZ)Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "getPins", "c", "Lcom/avito/android/avito_map/AvitoMapCameraUpdate;", "getCameraUpdate", "d", "Lcom/avito/android/avito_map/AvitoMapPoint;", "getUserPoint", "f", "Z", "getAwaitingNewUserLocation", "e", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/map/MapBottomSheet$State;", "getBottomSheetState", g.a, "getForceMoveCamera", "<init>", "(Ljava/util/Set;Lcom/avito/android/messenger/map/MapBottomSheet$State;Lcom/avito/android/avito_map/AvitoMapCameraUpdate;Lcom/avito/android/avito_map/AvitoMapPoint;ZZZ)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final State h = new State(y.emptySet(), MapBottomSheet.State.Closed.INSTANCE, null, null, false, false, false);
        @NotNull
        public final Set<Pin> a;
        @NotNull
        public final MapBottomSheet.State b;
        @Nullable
        public final AvitoMapCameraUpdate c;
        @Nullable
        public final AvitoMapPoint d;
        public final boolean e;
        public final boolean f;
        public final boolean g;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State$Companion;", "", "Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State;", "EMPTY", "Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State;", "getEMPTY", "()Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final State getEMPTY() {
                return State.h;
            }

            public Companion(j jVar) {
            }
        }

        public State(@NotNull Set<Pin> set, @NotNull MapBottomSheet.State state, @Nullable AvitoMapCameraUpdate avitoMapCameraUpdate, @Nullable AvitoMapPoint avitoMapPoint, boolean z, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(set, "pins");
            Intrinsics.checkNotNullParameter(state, "bottomSheetState");
            this.a = set;
            this.b = state;
            this.c = avitoMapCameraUpdate;
            this.d = avitoMapPoint;
            this.e = z;
            this.f = z2;
            this.g = z3;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.messenger.map.viewing.view.PlatformMapView$State */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Set set, MapBottomSheet.State state2, AvitoMapCameraUpdate avitoMapCameraUpdate, AvitoMapPoint avitoMapPoint, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                set = state.a;
            }
            if ((i & 2) != 0) {
                state2 = state.b;
            }
            if ((i & 4) != 0) {
                avitoMapCameraUpdate = state.c;
            }
            if ((i & 8) != 0) {
                avitoMapPoint = state.d;
            }
            if ((i & 16) != 0) {
                z = state.e;
            }
            if ((i & 32) != 0) {
                z2 = state.f;
            }
            if ((i & 64) != 0) {
                z3 = state.g;
            }
            return state.copy(set, state2, avitoMapCameraUpdate, avitoMapPoint, z, z2, z3);
        }

        @NotNull
        public final Set<Pin> component1() {
            return this.a;
        }

        @NotNull
        public final MapBottomSheet.State component2() {
            return this.b;
        }

        @Nullable
        public final AvitoMapCameraUpdate component3() {
            return this.c;
        }

        @Nullable
        public final AvitoMapPoint component4() {
            return this.d;
        }

        public final boolean component5() {
            return this.e;
        }

        public final boolean component6() {
            return this.f;
        }

        public final boolean component7() {
            return this.g;
        }

        @NotNull
        public final State copy(@NotNull Set<Pin> set, @NotNull MapBottomSheet.State state, @Nullable AvitoMapCameraUpdate avitoMapCameraUpdate, @Nullable AvitoMapPoint avitoMapPoint, boolean z, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(set, "pins");
            Intrinsics.checkNotNullParameter(state, "bottomSheetState");
            return new State(set, state, avitoMapCameraUpdate, avitoMapPoint, z, z2, z3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && Intrinsics.areEqual(this.b, state.b) && Intrinsics.areEqual(this.c, state.c) && Intrinsics.areEqual(this.d, state.d) && this.e == state.e && this.f == state.f && this.g == state.g;
        }

        public final boolean getAwaitingNewUserLocation() {
            return this.f;
        }

        @NotNull
        public final MapBottomSheet.State getBottomSheetState() {
            return this.b;
        }

        @Nullable
        public final AvitoMapCameraUpdate getCameraUpdate() {
            return this.c;
        }

        public final boolean getForceMoveCamera() {
            return this.g;
        }

        @NotNull
        public final Set<Pin> getPins() {
            return this.a;
        }

        @Nullable
        public final AvitoMapPoint getUserPoint() {
            return this.d;
        }

        public int hashCode() {
            Set<Pin> set = this.a;
            int i = 0;
            int hashCode = (set != null ? set.hashCode() : 0) * 31;
            MapBottomSheet.State state = this.b;
            int hashCode2 = (hashCode + (state != null ? state.hashCode() : 0)) * 31;
            AvitoMapCameraUpdate avitoMapCameraUpdate = this.c;
            int hashCode3 = (hashCode2 + (avitoMapCameraUpdate != null ? avitoMapCameraUpdate.hashCode() : 0)) * 31;
            AvitoMapPoint avitoMapPoint = this.d;
            if (avitoMapPoint != null) {
                i = avitoMapPoint.hashCode();
            }
            int i2 = (hashCode3 + i) * 31;
            boolean z = this.e;
            int i3 = 1;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = (i2 + i4) * 31;
            boolean z2 = this.f;
            if (z2) {
                z2 = true;
            }
            int i8 = z2 ? 1 : 0;
            int i9 = z2 ? 1 : 0;
            int i10 = z2 ? 1 : 0;
            int i11 = (i7 + i8) * 31;
            boolean z3 = this.g;
            if (!z3) {
                i3 = z3 ? 1 : 0;
            }
            return i11 + i3;
        }

        public final boolean isDragging() {
            return this.e;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(\n                |   pins=");
            L.append(this.a);
            L.append(",\n                |   bottomSheetState=");
            L.append(this.b);
            L.append(",\n                |   cameraUpdate=");
            L.append(this.c);
            L.append(",\n                |   isDragging=");
            L.append(this.e);
            L.append(",\n                |   awaitingNewUserLocation=");
            L.append(this.f);
            L.append(",\n                |   forceMoveCamera=");
            return f.trimMargin$default(a.B(L, this.g, "\n                |)"), null, 1, null);
        }
    }

    @NotNull
    Observable<BottomSheet.Visibility> getBottomSheetVisibilityStream();

    @NotNull
    Observable<Unit> getCameraDraggingStartedStream();

    @NotNull
    Observable<AvitoMapCameraPosition> getCameraPosition();

    @NotNull
    Observable<Unit> getCreateRouteButtonClicks();

    @NotNull
    Observable<Unit> getFindLocationClicks();

    @NotNull
    Observable<Boolean> getMapIsReady();

    @NotNull
    Observable<Pin> getPinClicks();

    void onDestroy();

    void onLowMemory();

    void onStart();

    void onStop();

    void showError(@StringRes int i, int i2);

    void showFindLocationError();
}
