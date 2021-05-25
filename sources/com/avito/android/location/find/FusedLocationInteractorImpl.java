package com.avito.android.location.find;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.location.Location;
import com.avito.android.geo.GeoStorage;
import com.avito.android.location.find.FusedLocationInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\b.\u0010/J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0017¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/avito/android/location/find/FusedLocationInteractorImpl;", "Lcom/avito/android/location/find/FusedLocationInteractor;", "Lcom/google/android/gms/location/LocationCallback;", "", "showLocationEnableDialog", "Lio/reactivex/rxjava3/core/Single;", "isDeviceLocationEnabled", "(Z)Lio/reactivex/rxjava3/core/Single;", "accessGoogleServices", "()Z", "Landroid/app/Activity;", "activity", "", "setActivity", "(Landroid/app/Activity;)V", "Landroid/location/Location;", "requestDeviceLocation", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/google/android/gms/location/LocationResult;", "locationResult", "onLocationResult", "(Lcom/google/android/gms/location/LocationResult;)V", "Lcom/google/android/gms/location/LocationAvailability;", "locationAvailability", "onLocationAvailability", "(Lcom/google/android/gms/location/LocationAvailability;)V", "Ljava/lang/ref/WeakReference;", "c", "Ljava/lang/ref/WeakReference;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/google/android/gms/location/LocationRequest;", "d", "Lcom/google/android/gms/location/LocationRequest;", "locationRequest", "Lcom/avito/android/geo/GeoStorage;", "e", "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "Lio/reactivex/rxjava3/core/SingleEmitter;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/core/SingleEmitter;", "activeLocationEmitter", "Lcom/google/android/gms/location/FusedLocationProviderClient;", AuthSource.BOOKING_ORDER, "Lcom/google/android/gms/location/FusedLocationProviderClient;", "locationProviderClient", "<init>", "(Lcom/avito/android/geo/GeoStorage;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class FusedLocationInteractorImpl extends LocationCallback implements FusedLocationInteractor {
    public SingleEmitter<Location> a;
    public FusedLocationProviderClient b;
    public WeakReference<Activity> c;
    public final LocationRequest d;
    public final GeoStorage e;

    public static final class a<T> implements SingleOnSubscribe<Boolean> {
        public final /* synthetic */ FusedLocationInteractorImpl a;
        public final /* synthetic */ boolean b;

        /* renamed from: com.avito.android.location.find.FusedLocationInteractorImpl$a$a  reason: collision with other inner class name */
        public static final class C0143a<TResult> implements OnCompleteListener<LocationSettingsResponse> {
            public final /* synthetic */ Activity a;
            public final /* synthetic */ a b;
            public final /* synthetic */ SingleEmitter c;

            public C0143a(Activity activity, a aVar, LocationSettingsRequest locationSettingsRequest, SingleEmitter singleEmitter) {
                this.a = activity;
                this.b = aVar;
                this.c = singleEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: io.reactivex.rxjava3.core.SingleEmitter */
            /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: io.reactivex.rxjava3.core.SingleEmitter */
            /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: io.reactivex.rxjava3.core.SingleEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(@NotNull Task<LocationSettingsResponse> task) {
                Intrinsics.checkNotNullParameter(task, "it");
                try {
                    task.getResult(ApiException.class);
                    this.c.onSuccess(Boolean.TRUE);
                } catch (ApiException e) {
                    if (e.getStatusCode() != 6) {
                        this.c.onSuccess(Boolean.FALSE);
                        return;
                    }
                    a aVar = this.b;
                    if (aVar.b) {
                        ((ResolvableApiException) e).startResolutionForResult(this.a, aVar.a.getEnableLocationRequestCode());
                    }
                    this.c.onSuccess(Boolean.FALSE);
                }
            }
        }

        public a(FusedLocationInteractorImpl fusedLocationInteractorImpl, boolean z) {
            this.a = fusedLocationInteractorImpl;
            this.b = z;
        }

        @Override // io.reactivex.rxjava3.core.SingleOnSubscribe
        public final void subscribe(SingleEmitter<Boolean> singleEmitter) {
            Activity activity;
            LocationSettingsRequest build = new LocationSettingsRequest.Builder().addLocationRequest(this.a.d).setAlwaysShow(true).build();
            WeakReference weakReference = this.a.c;
            if (weakReference == null || (activity = (Activity) weakReference.get()) == null || LocationServices.getSettingsClient(activity).checkLocationSettings(build).addOnCompleteListener(new C0143a(activity, this, build, singleEmitter)) == null) {
                singleEmitter.onSuccess(Boolean.FALSE);
            }
        }
    }

    public static final class b<T> implements SingleOnSubscribe<Location> {
        public final /* synthetic */ FusedLocationInteractorImpl a;

        public static final class a implements Cancellable {
            public final /* synthetic */ b a;
            public final /* synthetic */ WeakCallback b;

            public a(b bVar, WeakCallback weakCallback) {
                this.a = bVar;
                this.b = weakCallback;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                FusedLocationProviderClient fusedLocationProviderClient = this.a.a.b;
                if (fusedLocationProviderClient != null) {
                    fusedLocationProviderClient.removeLocationUpdates(this.b);
                }
                this.a.a.a = null;
            }
        }

        public b(FusedLocationInteractorImpl fusedLocationInteractorImpl) {
            this.a = fusedLocationInteractorImpl;
        }

        @Override // io.reactivex.rxjava3.core.SingleOnSubscribe
        public final void subscribe(SingleEmitter<Location> singleEmitter) {
            Activity activity;
            WeakCallback weakCallback = new WeakCallback(this.a);
            this.a.a = singleEmitter;
            WeakReference weakReference = this.a.c;
            if (!(weakReference == null || (activity = (Activity) weakReference.get()) == null)) {
                this.a.b = LocationServices.getFusedLocationProviderClient(activity);
                FusedLocationProviderClient fusedLocationProviderClient = this.a.b;
                if (fusedLocationProviderClient != null) {
                    fusedLocationProviderClient.requestLocationUpdates(this.a.d, weakCallback, null);
                }
            }
            singleEmitter.setCancellable(new a(this, weakCallback));
        }
    }

    @Inject
    public FusedLocationInteractorImpl(@NotNull GeoStorage geoStorage) {
        Intrinsics.checkNotNullParameter(geoStorage, "geoStorage");
        this.e = geoStorage;
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setPriority(102);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        locationRequest.setFastestInterval(timeUnit.convert(5, timeUnit2));
        locationRequest.setInterval(timeUnit.convert(10, timeUnit2));
        Unit unit = Unit.INSTANCE;
        this.d = locationRequest;
    }

    @Override // com.avito.android.location.find.FusedLocationInteractor
    public boolean accessGoogleServices() {
        Activity activity;
        WeakReference<Activity> weakReference = this.c;
        if (weakReference == null || (activity = weakReference.get()) == null || GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity) != 0) {
            return false;
        }
        return true;
    }

    @Override // com.avito.android.location.find.FusedLocationInteractor
    public int getEnableLocationRequestCode() {
        return FusedLocationInteractor.DefaultImpls.getEnableLocationRequestCode(this);
    }

    @Override // com.avito.android.location.find.FusedLocationInteractor
    @NotNull
    public Single<Boolean> isDeviceLocationEnabled(boolean z) {
        Single<Boolean> create = Single.create(new a(this, z));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create { emitter …nSuccess(false)\n        }");
        return create;
    }

    @Override // com.google.android.gms.location.LocationCallback
    public void onLocationAvailability(@Nullable LocationAvailability locationAvailability) {
        SingleEmitter<Location> singleEmitter;
        if (locationAvailability != null && !locationAvailability.isLocationAvailable() && (singleEmitter = this.a) != null) {
            singleEmitter.onError(new IllegalStateException("location is not available"));
        }
    }

    @Override // com.google.android.gms.location.LocationCallback
    public void onLocationResult(@NotNull LocationResult locationResult) {
        Intrinsics.checkNotNullParameter(locationResult, "locationResult");
        Location lastLocation = locationResult.getLastLocation();
        GeoStorage geoStorage = this.e;
        Intrinsics.checkNotNullExpressionValue(lastLocation, "location");
        geoStorage.saveLocation(lastLocation);
        Logs.debug$default("Get fused Coordinates: " + lastLocation, null, 2, null);
        SingleEmitter<Location> singleEmitter = this.a;
        if (singleEmitter != null) {
            singleEmitter.onSuccess(lastLocation);
        }
    }

    @Override // com.avito.android.location.find.FusedLocationInteractor
    @SuppressLint({"MissingPermission"})
    @NotNull
    public Single<Location> requestDeviceLocation() {
        Single<Location> create = Single.create(new b(this));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create { emitter …er = null\n        }\n    }");
        return create;
    }

    @Override // com.avito.android.location.find.FusedLocationInteractor
    public void setActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.c = new WeakReference<>(activity);
    }
}
