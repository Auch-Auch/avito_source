package a2.a.a.m1;

import com.avito.android.location_list.LocationListInteractorImpl;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.LocationsResponse;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
import java.util.List;
public final class a<T> implements Consumer<LocationsResponse> {
    public final /* synthetic */ LocationListInteractorImpl a;
    public final /* synthetic */ String b;

    public a(LocationListInteractorImpl locationListInteractorImpl, String str) {
        this.a = locationListInteractorImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LocationsResponse locationsResponse) {
        List<Location> locations = locationsResponse.getLocations();
        if (locations != null) {
            this.a.a.put(this.b, locations);
        }
        StringBuilder L = a2.b.a.a.a.L("search put query: ");
        L.append(this.b);
        Logs.debug$default("LocationListInteractor", L.toString(), null, 4, null);
    }
}
