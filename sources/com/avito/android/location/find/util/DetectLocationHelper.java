package com.avito.android.location.find.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.avito.android.lastclick.LastClick;
import com.avito.android.permissions.R;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.util.WeakHandler;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
public class DetectLocationHelper implements LocationListener {
    public WeakReference<Activity> a;
    public WeakReference<ActivityInteractor> b;
    public LocationManager c;
    public final WeakHandler d;
    public OnLocationAvailableListener e;
    public Timer f;
    public Location g;
    public boolean h;
    public boolean i;
    public boolean j;

    public interface OnLocationAvailableListener {
        void onLocationAvailable(Location location);

        void onLocationDetectTimeout();
    }

    public class a extends TimerTask {

        /* renamed from: com.avito.android.location.find.util.DetectLocationHelper$a$a  reason: collision with other inner class name */
        public class RunnableC0144a implements Runnable {
            public RunnableC0144a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                DetectLocationHelper.this.e.onLocationDetectTimeout();
            }
        }

        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            DetectLocationHelper.this.cancelDetecting();
            DetectLocationHelper detectLocationHelper = DetectLocationHelper.this;
            if (detectLocationHelper.e != null) {
                detectLocationHelper.d.post(new RunnableC0144a());
            }
        }
    }

    public DetectLocationHelper(@NonNull Activity activity, @NonNull ActivityInteractor activityInteractor, WeakHandler weakHandler) {
        this.a = new WeakReference<>(activity);
        this.b = new WeakReference<>(activityInteractor);
        this.c = (LocationManager) activity.getSystemService("location");
        this.d = weakHandler;
    }

    public final boolean a(OnLocationAvailableListener onLocationAvailableListener, boolean z, boolean z2) {
        this.e = onLocationAvailableListener;
        this.h = z;
        this.i = z2;
        this.g = null;
        boolean isProviderEnabled = this.c.isProviderEnabled("gps");
        boolean isProviderEnabled2 = this.c.isProviderEnabled("network");
        if ((!this.h || !isProviderEnabled) && (!this.i || !isProviderEnabled2)) {
            b();
            return false;
        }
        Location lastKnownLocation = this.c.getLastKnownLocation("gps");
        this.g = lastKnownLocation;
        if (lastKnownLocation == null) {
            this.g = this.c.getLastKnownLocation("network");
        }
        Location location = this.g;
        if (location == null) {
            if (this.h && isProviderEnabled) {
                this.c.requestLocationUpdates("gps", 0, 0.0f, this);
                this.j = true;
            }
            if (this.i && isProviderEnabled2) {
                this.c.requestLocationUpdates("network", 0, 0.0f, this);
                this.j = true;
            }
            return true;
        }
        OnLocationAvailableListener onLocationAvailableListener2 = this.e;
        if (onLocationAvailableListener2 != null) {
            onLocationAvailableListener2.onLocationAvailable(location);
        }
        return false;
    }

    public final void b() {
        Activity activity = this.a.get();
        ActivityInteractor activityInteractor = this.b.get();
        if (activity != null && activityInteractor != null) {
            new AlertDialog.Builder(activity).setMessage(activity.getString(R.string.loc_providers_unavailable_message)).setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() { // from class: a2.a.a.l1.c.a.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    ActivityInteractor activityInteractor2 = ActivityInteractor.this;
                    LastClick.Updater.update();
                    activityInteractor2.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 2);
                }
            }).setNegativeButton(R.string.cancel, a2.a.a.l1.c.a.a.a).create().show();
        }
    }

    public void cancelDetecting() {
        if (isDetecting()) {
            this.c.removeUpdates(this);
            this.j = false;
            Timer timer = this.f;
            if (timer != null) {
                timer.cancel();
                this.f = null;
            }
        }
    }

    public boolean checkLocationSettings(boolean z, boolean z2, boolean z3) {
        boolean z4 = (z && this.c.isProviderEnabled("gps")) || (z2 && this.c.isProviderEnabled("network"));
        if (!z4 && z3) {
            b();
        }
        return z4;
    }

    public boolean detectLocation(OnLocationAvailableListener onLocationAvailableListener, boolean z, boolean z2, int i2) {
        boolean a3 = a(onLocationAvailableListener, z, z2);
        if (a3) {
            Timer timer = new Timer(true);
            this.f = timer;
            timer.schedule(new a(), (long) i2);
        }
        return a3;
    }

    public Location getLastKnownLocation() {
        Location lastKnownLocation = this.c.getLastKnownLocation("gps");
        return lastKnownLocation == null ? this.c.getLastKnownLocation("network") : lastKnownLocation;
    }

    public void handleLocationSettingsResult() {
        a(this.e, this.h, this.i);
    }

    public boolean isDetecting() {
        return this.j;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        this.c.removeUpdates(this);
        this.g = location;
        OnLocationAvailableListener onLocationAvailableListener = this.e;
        if (onLocationAvailableListener != null) {
            onLocationAvailableListener.onLocationAvailable(location);
        }
        this.j = false;
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i2, Bundle bundle) {
    }

    public void removeListener() {
        this.e = null;
    }
}
