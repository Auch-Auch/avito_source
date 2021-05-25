package a2.a.a.w0;

import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.avito.android.geo.GeoProvider;
import com.avito.android.geo.SimpleLocationListener;
import com.avito.android.geo.util.LocationManagers;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.WeakHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
public class b extends a {
    @NonNull
    public final LocationManager g;
    @NonNull
    public final a h;
    @NonNull
    public final Map<String, Boolean> i;

    public static final class a extends SimpleLocationListener {
        @NonNull
        public final WeakReference<a> a;
        @NonNull
        public final WeakReference<Map<String, Boolean>> b;

        public a(@NonNull a aVar, @NonNull Map<String, Boolean> map) {
            this.a = new WeakReference<>(aVar);
            this.b = new WeakReference<>(map);
        }

        @Override // com.avito.android.geo.SimpleLocationListener, android.location.LocationListener
        public void onLocationChanged(Location location) {
            a aVar = this.a.get();
            if (aVar != null) {
                aVar.b(location);
            }
        }

        @Override // com.avito.android.geo.SimpleLocationListener, android.location.LocationListener
        public void onProviderEnabled(String str) {
            Map<String, Boolean> map = this.b.get();
            if (map != null && map.containsKey(str) && !map.get(str).booleanValue()) {
                map.put(str, Boolean.TRUE);
                this.a.get().d(str);
            }
        }
    }

    public b(@Nullable GeoProvider.GeoListener geoListener, @NonNull WeakHandler weakHandler, @NonNull TimeSource timeSource, @NonNull LocationManager locationManager) {
        super(geoListener, weakHandler, timeSource);
        HashMap hashMap = new HashMap();
        this.i = hashMap;
        this.g = locationManager;
        this.h = new a(this, hashMap);
    }

    @Override // a2.a.a.w0.a
    public void a() {
        LocationManagers.safeRemoveUpdates(this.g, this.h);
    }

    @Override // a2.a.a.w0.a
    public void c() {
        b(this.g.getLastKnownLocation("passive"));
        b(this.g.getLastKnownLocation("network"));
        b(this.g.getLastKnownLocation("gps"));
        d("passive");
        d("network");
        if (this.e == 1) {
            d("gps");
        }
    }

    @Override // a2.a.a.w0.a
    public void d(@NonNull String str) {
        if (this.g.isProviderEnabled(str)) {
            this.g.requestLocationUpdates(str, 100, 1.0f, this.h);
            this.i.put(str, Boolean.TRUE);
            return;
        }
        this.i.put(str, Boolean.FALSE);
    }
}
