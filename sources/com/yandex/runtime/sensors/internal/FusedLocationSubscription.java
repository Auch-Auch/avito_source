package com.yandex.runtime.sensors.internal;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.Runtime;
public class FusedLocationSubscription extends LocationCallback implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static final String LOG_TAG = "com.yandex.runtime.sensors.internal.FusedLocationSubscription";
    private FusedLocationProviderClient fusedLocationProviderClient = null;
    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    public NativeObject nativeObject;

    public FusedLocationSubscription(float f, int i, NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
        this.googleApiClient = new GoogleApiClient.Builder(Runtime.getApplicationContext()).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
        this.locationRequest = LocationRequest.create().setSmallestDisplacement(f).setInterval((long) i).setPriority(100);
        this.googleApiClient.connect();
    }

    public static final boolean fusedLocationProviderAvailable() {
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Runtime.getApplicationContext()) == 0 && getPlayServicesVersion() >= 11600000) {
            return true;
        }
        return false;
    }

    private static long getPlayServicesVersion() {
        try {
            return (long) Runtime.getApplicationContext().getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static native void locationChanged(NativeObject nativeObject2, Location location);

    public static native void statusChanged(NativeObject nativeObject2, boolean z);

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(Runtime.getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            FusedLocationProviderClient fusedLocationProviderClient2 = LocationServices.getFusedLocationProviderClient(Runtime.getApplicationContext());
            this.fusedLocationProviderClient = fusedLocationProviderClient2;
            fusedLocationProviderClient2.requestLocationUpdates(this.locationRequest, this, Looper.getMainLooper());
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        statusChanged(this.nativeObject, false);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        statusChanged(this.nativeObject, false);
    }

    @Override // com.google.android.gms.location.LocationCallback
    public void onLocationResult(LocationResult locationResult) {
        locationChanged(this.nativeObject, locationResult.getLastLocation());
    }

    public void stop() {
        statusChanged(this.nativeObject, false);
        FusedLocationProviderClient fusedLocationProviderClient2 = this.fusedLocationProviderClient;
        if (fusedLocationProviderClient2 != null) {
            fusedLocationProviderClient2.removeLocationUpdates(this);
        }
        this.googleApiClient.disconnect();
    }
}
