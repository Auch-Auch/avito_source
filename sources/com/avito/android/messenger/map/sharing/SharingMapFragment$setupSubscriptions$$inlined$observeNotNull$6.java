package com.avito.android.messenger.map.sharing;

import android.location.Location;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "com/avito/android/util/architecture_components/LiveDatasKt$observeNotNull$$inlined$observe$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$6<T> implements Observer<T> {
    public final /* synthetic */ SharingMapFragment a;

    public SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$6(SharingMapFragment sharingMapFragment) {
        this.a = sharingMapFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        if (t != null) {
            SharingMapFragment sharingMapFragment = this.a;
            FindLocationPresenter findLocationPresenter = sharingMapFragment.getFindLocationPresenter();
            FragmentActivity requireActivity = sharingMapFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            Disposable subscribe = FindLocationPresenter.DefaultImpls.findLocation$default(findLocationPresenter, requireActivity, false, 2, null).subscribe(new Consumer<Location>(sharingMapFragment) { // from class: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$6$lambda$1
                public final /* synthetic */ SharingMapFragment a;

                {
                    this.a = r1;
                }

                public final void accept(Location location) {
                    LocationAnalyticsInteractor.DefaultImpls.trackResolveCoordinates$default(this.a.getLocationAnalyticsInteractor(), location, null, 2, null);
                    SharingMapPresenter presenter = this.a.getPresenter();
                    Intrinsics.checkNotNullExpressionValue(location, "userLocation");
                    presenter.userLocationChanged(new AvitoMapPoint(location.getLatitude(), location.getLongitude()));
                }
            }, new Consumer<Throwable>(sharingMapFragment) { // from class: com.avito.android.messenger.map.sharing.SharingMapFragment$setupSubscriptions$$inlined$observeNotNull$6$lambda$2
                public final /* synthetic */ SharingMapFragment a;

                {
                    this.a = r1;
                }

                public final void accept(Throwable th) {
                    this.a.getLocationAnalyticsInteractor().trackResolveCoordinates(null, th.getMessage());
                    SharingMapFragment.access$getMapView$p(this.a).showFindLocationError();
                    Logs.error$default(SharingMapFragment.TAG, "mapView.locationFabClicks subscription in SharingMapFragment encountered error: " + th, null, 4, null);
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe, "findLocationPresenter.fi…         )\n            })");
            DisposableKt.addTo(subscribe, sharingMapFragment.d);
        }
    }
}
