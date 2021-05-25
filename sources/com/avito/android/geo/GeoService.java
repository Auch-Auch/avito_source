package com.avito.android.geo;

import a2.b.a.a.a;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.geo.GeoProvider;
import com.avito.android.geo.di.DaggerGeoComponent;
import com.avito.android.geo.di.GeoDependencies;
import com.avito.android.util.GeoLocations;
import com.avito.android.util.Logs;
import com.avito.android.util.WeakHandler;
import com.avito.android.util.preferences.GeoContract;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import javax.inject.Inject;
public class GeoService extends Service implements GeoProvider.GeoListener, WeakHandler.MessageListener {
    public GeoProvider a;
    @Inject
    public GeoPositionModel b;
    public WeakHandler c;
    public int d = -1;
    public long e;

    public static Intent createIntent(@NonNull Context context) {
        return createIntent(context, 0, false);
    }

    @Override // com.avito.android.util.WeakHandler.MessageListener
    public void handleMessage(@NonNull Message message) {
        if (message.what == 1) {
            this.a.dismissUpdate();
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DaggerGeoComponent.builder().dependentOn((GeoDependencies) ComponentDependenciesKt.getDependencies(GeoDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Service) this))).build().inject(this);
        this.a = GeoProviderFactory.newInstance(this, this);
        this.c = new WeakHandler(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.d = -1;
        super.onDestroy();
    }

    @Override // com.avito.android.geo.GeoProvider.GeoListener
    public void onLocationImproved(@Nullable Location location) {
        StringBuilder L = a.L("onLocationImproved: ");
        L.append(GeoLocations.print(location));
        Logs.debug("GeoService", L.toString());
        LocalBroadcastManager.getInstance(this).sendBroadcast(GeoBroadcastReceiver.createLocationImprovedEvent(location));
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (intent == null) {
            stopSelf();
            return 2;
        }
        if (this.d == -1) {
            this.d = i2;
            this.e = Math.max(intent.getLongExtra("timeout", SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US), 0L);
            if (intent.getBooleanExtra("force_update", false) || this.b.isLocationExpired()) {
                try {
                    Logs.debug("GeoService", "handleIntent");
                    this.c.sendEmptyMessageDelayed(1, this.e);
                    this.a.startUpdate(this.b.getLocation(), this.e, intent.getIntExtra(GeoContract.ACCURACY, 0));
                } catch (RuntimeException e2) {
                    Logs.error("GeoService", "handleIntent", e2);
                    stopSelf();
                }
            } else {
                stopSelf();
            }
        }
        return 2;
    }

    @Override // com.avito.android.geo.GeoProvider.GeoListener
    public void onUpdateFinished(@Nullable Location location) {
        StringBuilder L = a.L("onUpdateFinished: ");
        L.append(GeoLocations.print(location));
        Logs.debug("GeoService", L.toString());
        this.c.removeCallbacksAndMessages(null);
        this.b.onLocationUpdated(location);
        LocalBroadcastManager.getInstance(this).sendBroadcast(GeoBroadcastReceiver.createUpdateFinishedEvent(location));
        stopSelf();
    }

    public static Intent createIntent(@NonNull Context context, int i) {
        return createIntent(context, i, false);
    }

    public static Intent createIntent(@NonNull Context context, int i, boolean z) {
        return createIntent(context, i, z, SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
    }

    public static Intent createIntent(@NonNull Context context, int i, boolean z, long j) {
        return new Intent(context, GeoService.class).putExtra(GeoContract.ACCURACY, i).putExtra("force_update", z).putExtra("timeout", j);
    }
}
