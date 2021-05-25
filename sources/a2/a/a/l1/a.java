package a2.a.a.l1;

import com.avito.android.location.LocationSource;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.SavedLocationInteractorImpl;
import com.avito.android.remote.model.Location;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<Location> {
    public final /* synthetic */ SavedLocationInteractorImpl a;

    public a(SavedLocationInteractorImpl savedLocationInteractorImpl) {
        this.a = savedLocationInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Location location) {
        SavedLocationInteractor.DefaultImpls.saveLocation$default(this.a, location, LocationSource.LOCATION_FROM_LIST, false, 4, null);
    }
}
