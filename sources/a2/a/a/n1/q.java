package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinder;
import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerState;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
public final class q<T, R> implements Function<Unit, ObservableSource<? extends Function1<? super LocationPickerState, ? extends LocationPickerState>>> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;
    public final /* synthetic */ b b;
    public final /* synthetic */ d c;

    public q(LocationPickerBinderImpl.a aVar, b bVar, d dVar) {
        this.a = aVar;
        this.b = bVar;
        this.c = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends Function1<? super LocationPickerState, ? extends LocationPickerState>> apply(Unit unit) {
        Single<Function1<LocationPickerState, LocationPickerState>> single;
        Single<Function1<LocationPickerState, LocationPickerState>> timeout;
        if (this.a.a.k.isPermissionGranted()) {
            LocationPickerBinder.Router router = this.a.a.a;
            if (router == null || !router.accessGoogleServices()) {
                Single<Function1<LocationPickerState, LocationPickerState>> a3 = this.b.invoke();
                single = (a3 == null || (timeout = a3.timeout(5, TimeUnit.SECONDS, this.a.a.j.computation())) == null) ? null : timeout.onErrorResumeNext(new p(this));
            } else {
                this.a.a.i.setActivity(this.a.a.x);
                single = this.a.a.i.isDeviceLocationEnabled(false).flatMap(new o(this));
            }
        } else {
            this.a.a.m.trackResolveCoordinates(null, "PERMISSION DENIED");
            single = this.c.invoke();
        }
        if (single != null) {
            return single.toObservable();
        }
        return null;
    }
}
