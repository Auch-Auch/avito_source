package a2.a.a.o1.e.d;

import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class a<T> implements Consumer<GeoMarker[]> {
    public static final a a = new a();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(GeoMarker[] geoMarkerArr) {
        StringBuilder L = a2.b.a.a.a.L("Got GeoMarkers from server: ");
        L.append(geoMarkerArr);
        Logs.verbose$default("PlatformMapInteractor", L.toString(), null, 4, null);
    }
}
