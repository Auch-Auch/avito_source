package com.avito.android.geo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import androidx.annotation.Nullable;
import com.avito.android.geo.GeoProvider;
public class GeoBroadcastReceiver extends BroadcastReceiver {
    @Nullable
    public GeoProvider.GeoListener a;

    public GeoBroadcastReceiver() {
    }

    public static IntentFilter createIntentFilter() {
        return new IntentFilter("ACTION_GEO_UPDATE");
    }

    public static Intent createLocationImprovedEvent(@Nullable Location location) {
        Intent intent = new Intent("ACTION_GEO_UPDATE");
        intent.putExtra("event", "location_improved");
        intent.putExtra("location", location);
        return intent;
    }

    public static Intent createUpdateFinishedEvent(@Nullable Location location) {
        Intent intent = new Intent("ACTION_GEO_UPDATE");
        intent.putExtra("event", "update_finished");
        intent.putExtra("location", location);
        return intent;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.a != null) {
            String stringExtra = intent.getStringExtra("event");
            Location location = (Location) intent.getParcelableExtra("location");
            String valueOf = String.valueOf(stringExtra);
            if (valueOf.equals("update_finished")) {
                this.a.onUpdateFinished(location);
            } else if (valueOf.equals("location_improved")) {
                this.a.onLocationImproved(location);
            }
        }
    }

    public void setListener(@Nullable GeoProvider.GeoListener geoListener) {
        this.a = geoListener;
    }

    public GeoBroadcastReceiver(@Nullable GeoProvider.GeoListener geoListener) {
        this.a = geoListener;
    }
}
