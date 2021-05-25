package a2.g.k;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import java.util.HashMap;
import java.util.Set;
public class e {
    public final HashMap<a, t> a = new HashMap<>();

    public final synchronized t a(a aVar) {
        t tVar;
        tVar = this.a.get(aVar);
        if (tVar == null) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            tVar = new t(AttributionIdentifiers.getAttributionIdentifiers(applicationContext), AppEventsLogger.getAnonymousAppDeviceGUID(applicationContext));
        }
        this.a.put(aVar, tVar);
        return tVar;
    }

    public synchronized Set<a> b() {
        return this.a.keySet();
    }
}
