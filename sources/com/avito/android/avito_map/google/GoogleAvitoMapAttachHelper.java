package com.avito.android.avito_map.google;

import android.content.Context;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0010\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/avito_map/google/GoogleAvitoMapAttachHelper;", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "Lcom/avito/android/avito_map/AvitoMap;", "getMap", "()Lcom/avito/android/avito_map/AvitoMap;", "Lcom/avito/android/avito_map/AvitoMapAttachHelper$MapAttachListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setMapAttachedListener", "(Lcom/avito/android/avito_map/AvitoMapAttachHelper$MapAttachListener;)V", "", "viewId", "Landroid/view/View;", "container", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "attachView", "(ILandroid/view/View;Landroidx/fragment/app/FragmentManager;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/avito_map/AvitoMapAttachHelper$MapAttachListener;", "mapAttachListener", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "d", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "onMapReadyCallback", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", AuthSource.BOOKING_ORDER, "Lcom/avito/android/avito_map/AvitoMap;", "map", "<init>", "()V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class GoogleAvitoMapAttachHelper implements AvitoMapAttachHelper {
    public AvitoMapAttachHelper.MapAttachListener a;
    public AvitoMap b;
    public Context c;
    public final OnMapReadyCallback d = new a(this);

    public static final class a implements OnMapReadyCallback {
        public final /* synthetic */ GoogleAvitoMapAttachHelper a;

        public a(GoogleAvitoMapAttachHelper googleAvitoMapAttachHelper) {
            this.a = googleAvitoMapAttachHelper;
        }

        @Override // com.google.android.gms.maps.OnMapReadyCallback
        public final void onMapReady(GoogleMap googleMap) {
            Intrinsics.checkNotNullExpressionValue(googleMap, "googleMap");
            AvitoGoogleMap avitoGoogleMap = new AvitoGoogleMap(googleMap, GoogleAvitoMapAttachHelper.access$getContext$p(this.a));
            this.a.b = avitoGoogleMap;
            AvitoMapAttachHelper.MapAttachListener mapAttachListener = this.a.a;
            if (mapAttachListener != null) {
                mapAttachListener.onMapAttach(avitoGoogleMap);
            }
        }
    }

    public static final /* synthetic */ Context access$getContext$p(GoogleAvitoMapAttachHelper googleAvitoMapAttachHelper) {
        Context context = googleAvitoMapAttachHelper.c;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return context;
    }

    public static final /* synthetic */ AvitoMap access$getMap$p(GoogleAvitoMapAttachHelper googleAvitoMapAttachHelper) {
        AvitoMap avitoMap = googleAvitoMapAttachHelper.b;
        if (avitoMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("map");
        }
        return avitoMap;
    }

    @Override // com.avito.android.avito_map.AvitoMapAttachHelper
    public void attachView(@IdRes int i, @NotNull View view, @NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(view, "container");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "container.context");
        this.c = context;
        Fragment findFragmentById = fragmentManager.findFragmentById(i);
        if (!(findFragmentById instanceof SupportMapFragment)) {
            findFragmentById = null;
        }
        SupportMapFragment supportMapFragment = (SupportMapFragment) findFragmentById;
        if (supportMapFragment == null) {
            supportMapFragment = new SupportMapFragment();
        }
        fragmentManager.beginTransaction().replace(i, supportMapFragment).commit();
        supportMapFragment.getMapAsync(this.d);
    }

    @Override // com.avito.android.avito_map.AvitoMapAttachHelper
    @Nullable
    public AvitoMap getMap() {
        AvitoMap avitoMap = this.b;
        if (avitoMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("map");
        }
        return avitoMap;
    }

    @Override // com.avito.android.avito_map.AvitoMapAttachHelper
    public void setMapAttachedListener(@NotNull AvitoMapAttachHelper.MapAttachListener mapAttachListener) {
        Intrinsics.checkNotNullParameter(mapAttachListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = mapAttachListener;
    }
}
