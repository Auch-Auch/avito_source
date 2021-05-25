package a2.a.a.a1;

import com.avito.android.home.HomeInteractorImpl;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.remote.model.Location;
import io.reactivex.rxjava3.functions.Consumer;
public final class g<T> implements Consumer<Location> {
    public final /* synthetic */ HomeInteractorImpl.k a;

    public g(HomeInteractorImpl.k kVar) {
        this.a = kVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Location location) {
        Location location2 = location;
        if (location2 != null) {
            SavedLocationInteractor.DefaultImpls.saveLocation$default(this.a.a.k, location2, null, false, 6, null);
        }
    }
}
