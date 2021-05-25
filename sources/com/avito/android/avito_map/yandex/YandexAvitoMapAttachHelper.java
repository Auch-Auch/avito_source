package com.avito.android.avito_map.yandex;

import a2.b.a.a.a;
import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.fragment.app.FragmentManager;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapView;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.mapview.MapView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0010\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/avito_map/yandex/YandexAvitoMapAttachHelper;", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "Lcom/avito/android/avito_map/AvitoMap;", "getMap", "()Lcom/avito/android/avito_map/AvitoMap;", "Lcom/avito/android/avito_map/AvitoMapAttachHelper$MapAttachListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setMapAttachedListener", "(Lcom/avito/android/avito_map/AvitoMapAttachHelper$MapAttachListener;)V", "", "viewId", "Landroid/view/View;", "container", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "attachView", "(ILandroid/view/View;Landroidx/fragment/app/FragmentManager;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/avito_map/AvitoMap;", "map", AuthSource.BOOKING_ORDER, "Lcom/avito/android/avito_map/AvitoMapAttachHelper$MapAttachListener;", "mapAttachListener", "<init>", "()V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class YandexAvitoMapAttachHelper implements AvitoMapAttachHelper {
    public AvitoMap a;
    public AvitoMapAttachHelper.MapAttachListener b;

    @Override // com.avito.android.avito_map.AvitoMapAttachHelper
    public void attachView(@IdRes int i, @NotNull View view, @NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(view, "container");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Context context = view.getContext();
        if (Build.VERSION.SDK_INT == 21) {
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            Intrinsics.checkNotNullExpressionValue(context, "context");
            currentThread.setContextClassLoader(context.getClassLoader());
        }
        AvitoMapView avitoMapView = (AvitoMapView) view.findViewById(i);
        if (avitoMapView != null) {
            MapView mapView = null;
            int i2 = 0;
            int childCount = avitoMapView.getChildCount();
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = avitoMapView.getChildAt(i2);
                if (childAt instanceof MapView) {
                    mapView = (MapView) childAt;
                    break;
                }
                i2++;
            }
            if (mapView == null) {
                mapView = new MapView(context);
                avitoMapView.addView(mapView);
            }
            mapView.onStart();
            MapKitFactory.getInstance().onStart();
            AvitoYandexMap avitoYandexMap = new AvitoYandexMap(mapView);
            this.a = avitoYandexMap;
            AvitoMapAttachHelper.MapAttachListener mapAttachListener = this.b;
            if (mapAttachListener != null) {
                mapAttachListener.onMapAttach(avitoYandexMap);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(a.M2("No view found with provided id: ", i));
    }

    @Override // com.avito.android.avito_map.AvitoMapAttachHelper
    @Nullable
    public AvitoMap getMap() {
        AvitoMap avitoMap = this.a;
        if (avitoMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("map");
        }
        return avitoMap;
    }

    @Override // com.avito.android.avito_map.AvitoMapAttachHelper
    public void setMapAttachedListener(@NotNull AvitoMapAttachHelper.MapAttachListener mapAttachListener) {
        Intrinsics.checkNotNullParameter(mapAttachListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = mapAttachListener;
    }
}
