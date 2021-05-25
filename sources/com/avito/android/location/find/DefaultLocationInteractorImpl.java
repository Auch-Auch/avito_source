package com.avito.android.location.find;

import a2.g.r.g;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.avito.android.geo.GeoBroadcastReceiver;
import com.avito.android.geo.GeoProvider;
import com.avito.android.geo.GeoService;
import com.avito.android.geo.GeoStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.preferences.GeoContract;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006*\u0001#\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u00102\u001a\u00020/¢\u0006\u0004\b3\u00104J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R*\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/avito/android/location/find/DefaultLocationInteractorImpl;", "Lcom/avito/android/location/find/DefaultLocationInteractor;", "Landroid/app/Activity;", "activity", "", "setActivity", "(Landroid/app/Activity;)V", "Lio/reactivex/rxjava3/core/Single;", "Landroid/location/Location;", "findLocation", "()Lio/reactivex/rxjava3/core/Single;", "Landroid/content/Context;", "context", "registerLocationReceiver", "(Landroid/content/Context;)V", "unregisterLocationReceiver", "", "accessGoogleServices", "()Z", "Lcom/avito/android/geo/GeoBroadcastReceiver;", "d", "Lcom/avito/android/geo/GeoBroadcastReceiver;", "locationBroadcastReceiver", "Ljava/lang/ref/WeakReference;", AuthSource.BOOKING_ORDER, "Ljava/lang/ref/WeakReference;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/reactivex/rxjava3/core/SingleEmitter;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/core/SingleEmitter;", "getActiveLocation", "()Lio/reactivex/rxjava3/core/SingleEmitter;", "setActiveLocation", "(Lio/reactivex/rxjava3/core/SingleEmitter;)V", "activeLocation", "com/avito/android/location/find/DefaultLocationInteractorImpl$geoListener$1", "c", "Lcom/avito/android/location/find/DefaultLocationInteractorImpl$geoListener$1;", "geoListener", "", "f", "J", "timeoutMs", "Lcom/avito/android/geo/GeoStorage;", "e", "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "", g.a, "I", GeoContract.ACCURACY, "<init>", "(Lcom/avito/android/geo/GeoStorage;JI)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultLocationInteractorImpl implements DefaultLocationInteractor {
    @Nullable
    public SingleEmitter<Location> a;
    public WeakReference<Activity> b;
    public final DefaultLocationInteractorImpl$geoListener$1 c;
    public final GeoBroadcastReceiver d;
    public final GeoStorage e;
    public final long f;
    public final int g;

    public static final class a<T> implements SingleOnSubscribe<Location> {
        public final /* synthetic */ DefaultLocationInteractorImpl a;

        public a(DefaultLocationInteractorImpl defaultLocationInteractorImpl) {
            this.a = defaultLocationInteractorImpl;
        }

        @Override // io.reactivex.rxjava3.core.SingleOnSubscribe
        public final void subscribe(SingleEmitter<Location> singleEmitter) {
            Activity activity;
            this.a.setActiveLocation(singleEmitter);
            WeakReference weakReference = this.a.b;
            if (weakReference != null && (activity = (Activity) weakReference.get()) != null) {
                activity.startService(GeoService.createIntent(activity, this.a.g, true, this.a.f));
            }
        }
    }

    public DefaultLocationInteractorImpl(@NotNull GeoStorage geoStorage, long j, int i) {
        Intrinsics.checkNotNullParameter(geoStorage, "geoStorage");
        this.e = geoStorage;
        this.f = j;
        this.g = i;
        DefaultLocationInteractorImpl$geoListener$1 defaultLocationInteractorImpl$geoListener$1 = new GeoProvider.GeoListener(this) { // from class: com.avito.android.location.find.DefaultLocationInteractorImpl$geoListener$1
            public final /* synthetic */ DefaultLocationInteractorImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.geo.GeoProvider.GeoListener
            public void onLocationImproved(@Nullable Location location) {
                SingleEmitter<Location> activeLocation;
                if (location != null) {
                    WeakReference weakReference = this.a.b;
                    if ((weakReference != null ? (Activity) weakReference.get() : null) != null && (activeLocation = this.a.getActiveLocation()) != null) {
                        activeLocation.onSuccess(location);
                    }
                }
            }

            @Override // com.avito.android.geo.GeoProvider.GeoListener
            public void onUpdateFinished(@Nullable Location location) {
                if (location != null) {
                    WeakReference weakReference = this.a.b;
                    if ((weakReference != null ? (Activity) weakReference.get() : null) != null) {
                        this.a.e.saveLocation(location);
                        Logs.debug$default("Get gps coordinates: " + location, null, 2, null);
                        SingleEmitter<Location> activeLocation = this.a.getActiveLocation();
                        if (activeLocation != null) {
                            activeLocation.onSuccess(location);
                        }
                    }
                }
            }
        };
        this.c = defaultLocationInteractorImpl$geoListener$1;
        this.d = new GeoBroadcastReceiver(defaultLocationInteractorImpl$geoListener$1);
    }

    @Override // com.avito.android.location.find.DefaultLocationInteractor
    public boolean accessGoogleServices() {
        Activity activity;
        WeakReference<Activity> weakReference = this.b;
        if (weakReference == null || (activity = weakReference.get()) == null || GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity) != 0) {
            return false;
        }
        return true;
    }

    @Override // com.avito.android.location.find.DefaultLocationInteractor
    @NotNull
    public Single<Location> findLocation() {
        Single<Location> create = Single.create(new a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create<Location> …e(intent)\n        }\n    }");
        return create;
    }

    @Override // com.avito.android.location.find.DefaultLocationInteractor
    @Nullable
    public SingleEmitter<Location> getActiveLocation() {
        return this.a;
    }

    @Override // com.avito.android.location.find.DefaultLocationInteractor
    public void registerLocationReceiver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!accessGoogleServices()) {
            LocalBroadcastManager instance = LocalBroadcastManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(instance, "LocalBroadcastManager.getInstance(context)");
            instance.registerReceiver(this.d, GeoBroadcastReceiver.createIntentFilter());
        }
    }

    public void setActiveLocation(@Nullable SingleEmitter<Location> singleEmitter) {
        this.a = singleEmitter;
    }

    @Override // com.avito.android.location.find.DefaultLocationInteractor
    public void setActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = new WeakReference<>(activity);
    }

    @Override // com.avito.android.location.find.DefaultLocationInteractor
    public void unregisterLocationReceiver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!accessGoogleServices()) {
            LocalBroadcastManager instance = LocalBroadcastManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(instance, "LocalBroadcastManager.getInstance(context)");
            instance.unregisterReceiver(this.d);
            this.b = null;
        }
    }
}
