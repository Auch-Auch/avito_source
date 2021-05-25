package a2.a.a.b2.e1;

import com.avito.android.profile.edit.LocationInteractor;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.Profile;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class q<T, R> implements Function<Location, ObservableSource<? extends LocationInteractor.ProfileLocation>> {
    public final /* synthetic */ Profile a;

    public q(Profile profile) {
        this.a = profile;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends LocationInteractor.ProfileLocation> apply(Location location) {
        Location location2 = location;
        Intrinsics.checkNotNullParameter(location2, "location");
        return Observable.just(new LocationInteractor.ProfileLocation(this.a, location2));
    }
}
