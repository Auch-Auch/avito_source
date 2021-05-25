package a2.a.a.b2.e1;

import com.avito.android.profile.edit.LocationInteractor;
import com.avito.android.profile.edit.LocationInteractorImpl;
import com.avito.android.remote.model.Profile;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class r<T, R> implements Function<Profile, ObservableSource<? extends LocationInteractor.ProfileLocation>> {
    public final /* synthetic */ LocationInteractorImpl a;

    public r(LocationInteractorImpl locationInteractorImpl) {
        this.a = locationInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends LocationInteractor.ProfileLocation> apply(Profile profile) {
        Profile profile2 = profile;
        Intrinsics.checkNotNullParameter(profile2, "profile");
        String locationId = profile2.getLocationId();
        if (locationId == null) {
            return Observable.just(new LocationInteractor.ProfileLocation(profile2, null));
        }
        return LocationInteractorImpl.access$requestLocation(this.a, profile2, locationId);
    }
}
