package com.yandex.metrica.n;

import android.location.Location;
import android.location.LocationListener;
import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnSuccessListener;
public class b implements OnSuccessListener<Location> {
    @NonNull
    public final LocationListener a;

    public b(@NonNull LocationListener locationListener) {
        this.a = locationListener;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Location location) {
        Location location2 = location;
        String str = "onSuccess: " + location2;
        this.a.onLocationChanged(location2);
    }
}
