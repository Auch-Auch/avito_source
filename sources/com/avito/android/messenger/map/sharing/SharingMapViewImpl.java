package com.avito.android.messenger.map.sharing;

import a2.g.r.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentManager;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapMoveReason;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.AvitoMapUiSettings;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.common.v2.Renderer;
import com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView;
import com.avito.android.messenger.map.MapBottomSheet;
import com.avito.android.messenger.map.MapBottomSheetImpl;
import com.avito.android.messenger.map.sharing.SharingMapView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BackingField;
import com.avito.android.util.Logs;
import com.avito.android.util.ToastsKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jakewharton.rxrelay3.BehaviorRelay;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010`\u001a\u00020_\u0012\u0006\u0010b\u001a\u00020a\u0012\u0006\u0010d\u001a\u00020c¢\u0006\u0004\be\u0010fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\f\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\tH\u0017¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u001b\u0010\u0015\u001a\u00020\u0005*\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u000fJ!\u0010\u001b\u001a\u00020\u00052\b\b\u0001\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010!\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R9\u00107\u001a\u0004\u0018\u00010\t*\b\u0012\u0004\u0012\u00020\t0\b2\b\u00100\u001a\u0004\u0018\u00010\t8V@VX\u0002¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010>\u001a\b\u0012\u0004\u0012\u000209088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u0002098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\"\u0010J\u001a\b\u0012\u0004\u0012\u00020\u0005088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bH\u0010;\u001a\u0004\bI\u0010=R\"\u0010N\u001a\b\u0012\u0004\u0012\u00020K088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bL\u0010;\u001a\u0004\bM\u0010=R\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\"\u0010U\u001a\b\u0012\u0004\u0012\u00020\u0005088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bS\u0010;\u001a\u0004\bT\u0010=R\"\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bV\u0010(\u001a\u0004\bW\u0010*R\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u0002098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010C¨\u0006g"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapViewImpl;", "Lcom/avito/android/messenger/map/sharing/SharingMapView;", "Lcom/avito/android/avito_map/AvitoMapAttachHelper$MapAttachListener;", "Lcom/avito/android/avito_map/AvitoMap;", "map", "", "onMapAttach", "(Lcom/avito/android/avito_map/AvitoMap;)V", "Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "prevState", "curState", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;Lcom/avito/android/messenger/map/sharing/SharingMapView$State;Lcom/avito/android/messenger/map/sharing/SharingMapView$State;)V", "onStart", "()V", "onStop", "onDestroy", "onLowMemory", "Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState;", "prevControlsState", "render", "(Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState;Lcom/avito/android/messenger/map/sharing/SharingMapView$ControlsState;)V", "showFindLocationError", "", "stringId", "duration", "showError", "(II)V", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "c", "Landroid/content/Context;", "context", "Lcom/avito/android/messenger/map/MapBottomSheet;", "f", "Lcom/avito/android/messenger/map/MapBottomSheet;", "bottomSheet", "Lio/reactivex/rxjava3/core/Observable;", "l", "Lio/reactivex/rxjava3/core/Observable;", "getEditAddressClicks", "()Lio/reactivex/rxjava3/core/Observable;", "editAddressClicks", "Lcom/avito/android/avito_map/AvitoMapMarker;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/avito_map/AvitoMapMarker;", "userLocationMarker", "<set-?>", AuthSource.SEND_ABUSE, "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;)Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;Lcom/avito/android/messenger/map/sharing/SharingMapView$State;)V", "lastRenderedState", "Lcom/jakewharton/rxrelay3/Relay;", "", g.a, "Lcom/jakewharton/rxrelay3/Relay;", "getMapIsReadyStream", "()Lcom/jakewharton/rxrelay3/Relay;", "mapIsReadyStream", "p", "I", "mapCenterOffset", "o", "Z", "ignoreOnCameraIdleEvent", AuthSource.BOOKING_ORDER, "Lcom/avito/android/avito_map/AvitoMap;", "mapView", "i", "getCameraDraggingStartedStream", "cameraDraggingStartedStream", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "h", "getCameraPositionStream", "cameraPositionStream", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView;", "e", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView;", "connectionErrorIndicator", "j", "getFindLocationClicks", "findLocationClicks", "k", "getSendLocationButtonClicks", "sendLocationButtonClicks", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "d", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "findLocationButton", "n", "renderedInitialState", "Landroid/view/View;", "rootView", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "mapAttachHelper", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Landroid/view/View;Lcom/avito/android/avito_map/AvitoMapAttachHelper;Landroidx/fragment/app/FragmentManager;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SharingMapViewImpl implements SharingMapView, AvitoMapAttachHelper.MapAttachListener {
    public static final /* synthetic */ KProperty[] q = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(SharingMapViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;)Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", 0))};
    @Nullable
    public final ReadWriteProperty a = new BackingField(null);
    public AvitoMap b;
    public final Context c;
    public final FloatingActionButton d;
    public final ConnectionErrorIndicatorView e;
    public final MapBottomSheet f;
    @NotNull
    public final Relay<Boolean> g;
    @NotNull
    public final Relay<AvitoMapCameraPosition> h;
    @NotNull
    public final Relay<Unit> i;
    @NotNull
    public final Relay<Unit> j;
    @NotNull
    public final Observable<Unit> k;
    @NotNull
    public final Observable<Unit> l;
    public AvitoMapMarker m;
    public boolean n;
    public boolean o;
    public final int p;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SharingMapViewImpl a;

        public a(SharingMapViewImpl sharingMapViewImpl) {
            this.a = sharingMapViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AvitoMap avitoMap;
            if (this.a.m != null) {
                AvitoMapMarker avitoMapMarker = this.a.m;
                AvitoMapPoint avitoMapPoint = null;
                Object data = avitoMapMarker != null ? avitoMapMarker.getData() : null;
                if (data instanceof AvitoMapPoint) {
                    avitoMapPoint = data;
                }
                AvitoMapPoint avitoMapPoint2 = avitoMapPoint;
                if (!(avitoMapPoint2 == null || (avitoMap = this.a.b) == null)) {
                    avitoMap.moveTo(avitoMapPoint2.getLatitude(), avitoMapPoint2.getLongitude(), true, null);
                }
            }
            this.a.getFindLocationClicks().accept(Unit.INSTANCE);
        }
    }

    public SharingMapViewImpl(@NotNull View view, @NotNull AvitoMapAttachHelper avitoMapAttachHelper, @NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(avitoMapAttachHelper, "mapAttachHelper");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.c = view.getContext();
        View findViewById = view.findViewById(R.id.messenger_sharing_map_location_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.google.android.material.floatingactionbutton.FloatingActionButton");
        this.d = (FloatingActionButton) findViewById;
        ConnectionErrorIndicatorView.Companion companion = ConnectionErrorIndicatorView.Companion;
        View findViewById2 = view.findViewById(R.id.messenger_sharing_map_connection_error_indicator);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.e = companion.create(findViewById2);
        MapBottomSheetImpl mapBottomSheetImpl = new MapBottomSheetImpl(view, com.avito.android.lib.design.avito.R.style.Avito_Button_PrimaryLarge, R.string.messenger_share_map_send_location_button, true);
        this.f = mapBottomSheetImpl;
        Relay<Boolean> serialized = BehaviorRelay.createDefault(Boolean.FALSE).toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized, "BehaviorRelay.createDefa…aultValue).toSerialized()");
        this.g = serialized;
        Relay<AvitoMapCameraPosition> serialized2 = PublishRelay.create().toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized2, "PublishRelay.create<T>().toSerialized()");
        this.h = serialized2;
        Relay<Unit> serialized3 = PublishRelay.create().toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized3, "PublishRelay.create<T>().toSerialized()");
        this.i = serialized3;
        Relay<Unit> serialized4 = PublishRelay.create().toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized4, "PublishRelay.create<T>().toSerialized()");
        this.j = serialized4;
        this.k = mapBottomSheetImpl.getActionButtonClicks();
        this.l = mapBottomSheetImpl.getEditDescriptionClicks();
        this.o = true;
        this.p = view.getResources().getDimensionPixelSize(R.dimen.messenger_sharing_map_center_offset);
        avitoMapAttachHelper.setMapAttachedListener(this);
        avitoMapAttachHelper.attachView(R.id.messenger_sharing_map_map_view, view, fragmentManager);
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapView
    @NotNull
    public Observable<Unit> getEditAddressClicks() {
        return this.l;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.Renderer
    @Nullable
    public SharingMapView.State getLastRenderedState(@NotNull Renderer<SharingMapView.State> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return (SharingMapView.State) this.a.getValue(renderer, q[0]);
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapView
    @NotNull
    public Observable<Unit> getSendLocationButtonClicks() {
        return this.k;
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapView
    public void onDestroy() {
        this.b = null;
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapView
    public void onLowMemory() {
        AvitoMap avitoMap = this.b;
        if (avitoMap != null) {
            avitoMap.onLowMemory();
        }
    }

    @Override // com.avito.android.avito_map.AvitoMapAttachHelper.MapAttachListener
    @SuppressLint({"CheckResult"})
    public void onMapAttach(@NotNull AvitoMap avitoMap) {
        Intrinsics.checkNotNullParameter(avitoMap, "map");
        this.b = avitoMap;
        avitoMap.setPadding(0, 0, this.p * 2, 0);
        AvitoMapUiSettings uiSettings = avitoMap.getUiSettings();
        uiSettings.isRotateGesturesEnabled(false);
        uiSettings.isTiltGesturesEnabled(false);
        avitoMap.addMoveEndListener(new AvitoMap.MapMoveEndListener(this) { // from class: com.avito.android.messenger.map.sharing.SharingMapViewImpl$onMapAttach$2
            public final /* synthetic */ SharingMapViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.avito_map.AvitoMap.MapMoveEndListener
            public void onMapSettled(@NotNull AvitoMapCameraPosition avitoMapCameraPosition) {
                Intrinsics.checkNotNullParameter(avitoMapCameraPosition, "mapCameraPosition");
                if (this.a.o) {
                    Logs.verbose$default("SharingMapView", "onCameraIdle(), ignoring", null, 4, null);
                    this.a.o = false;
                    return;
                }
                Logs.verbose$default("SharingMapView", "onCameraIdle(), sending event", null, 4, null);
                this.a.getCameraPositionStream().accept(avitoMapCameraPosition);
            }
        });
        avitoMap.addMoveStartListener(new AvitoMap.MapMoveStartListener(this) { // from class: com.avito.android.messenger.map.sharing.SharingMapViewImpl$onMapAttach$3
            public final /* synthetic */ SharingMapViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.avito_map.AvitoMap.MapMoveStartListener
            public void onMapMoveStarted(@NotNull AvitoMapMoveReason avitoMapMoveReason) {
                Intrinsics.checkNotNullParameter(avitoMapMoveReason, "reason");
                if (avitoMapMoveReason == AvitoMapMoveReason.GESTURE) {
                    Logs.verbose$default("SharingMapView", "OnCameraMoveStarted.REASON_GESTURE", null, 4, null);
                    this.a.getCameraDraggingStartedStream().accept(Unit.INSTANCE);
                }
            }
        });
        this.d.setOnClickListener(new a(this));
        getMapIsReadyStream().accept(Boolean.TRUE);
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapView
    public void onStart() {
        AvitoMap avitoMap = this.b;
        if (avitoMap != null) {
            avitoMap.onStart();
        }
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapView
    public void onStop() {
        AvitoMap avitoMap = this.b;
        if (avitoMap != null) {
            avitoMap.onStop();
        }
    }

    public void render(@NotNull SharingMapView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        SharingMapView.DefaultImpls.render(this, state);
    }

    public void setLastRenderedState(@NotNull Renderer<SharingMapView.State> renderer, @Nullable SharingMapView.State state) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        this.a.setValue(renderer, q[0], state);
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapView
    public void showError(@StringRes int i2, int i3) {
        Context context = this.c;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ToastsKt.showToast(context, i2, i3).show();
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapView
    public void showFindLocationError() {
        SharingMapView.DefaultImpls.showError$default(this, com.avito.android.geo.R.string.location_not_found, 0, 2, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0099, code lost:
        if (r12 != false) goto L_0x009b;
     */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doRender(@org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.common.v2.Renderer<com.avito.android.messenger.map.sharing.SharingMapView.State> r12, @org.jetbrains.annotations.Nullable com.avito.android.messenger.map.sharing.SharingMapView.State r13, @org.jetbrains.annotations.NotNull com.avito.android.messenger.map.sharing.SharingMapView.State r14) {
        /*
        // Method dump skipped, instructions count: 295
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.map.sharing.SharingMapViewImpl.doRender(com.avito.android.messenger.channels.mvi.common.v2.Renderer, com.avito.android.messenger.map.sharing.SharingMapView$State, com.avito.android.messenger.map.sharing.SharingMapView$State):void");
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapView
    @NotNull
    public Relay<Unit> getCameraDraggingStartedStream() {
        return this.i;
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapView
    @NotNull
    public Relay<AvitoMapCameraPosition> getCameraPositionStream() {
        return this.h;
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapView
    @NotNull
    public Relay<Unit> getFindLocationClicks() {
        return this.j;
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapView
    @NotNull
    public Relay<Boolean> getMapIsReadyStream() {
        return this.g;
    }

    public final void render(@NotNull SharingMapView.ControlsState controlsState, @Nullable SharingMapView.ControlsState controlsState2) {
        Intrinsics.checkNotNullParameter(controlsState, "$this$render");
        MapBottomSheet.State state = null;
        this.e.render(controlsState2 != null ? controlsState2.getConnectionErrorIndicatorState() : null, controlsState.getConnectionErrorIndicatorState());
        MapBottomSheet mapBottomSheet = this.f;
        if (controlsState2 != null) {
            state = controlsState2.getBottomSheetState();
        }
        mapBottomSheet.render(state, controlsState.getBottomSheetState());
    }
}
