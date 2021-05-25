package a2.a.a.n1;

import android.location.Location;
import com.avito.android.location_picker.LocationPickerBinder;
import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerState;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
public final class b extends Lambda implements Function0<Single<Function1<? super LocationPickerState, ? extends LocationPickerState>>> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;
    public final /* synthetic */ LocationPickerState b;

    public static final class a<T, R> implements Function<Location, Function1<? super LocationPickerState, ? extends LocationPickerState>> {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Function1<? super LocationPickerState, ? extends LocationPickerState> apply(Location location) {
            Location location2 = location;
            Intrinsics.checkNotNullParameter(location2, "userLocation");
            return new a(this, location2);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(LocationPickerBinderImpl.a aVar, LocationPickerState locationPickerState) {
        super(0);
        this.a = aVar;
        this.b = locationPickerState;
    }

    @Nullable
    /* renamed from: a */
    public final Single<Function1<LocationPickerState, LocationPickerState>> invoke() {
        Single<Location> single;
        LocationPickerBinder.Router access$getRouter$p = LocationPickerBinderImpl.access$getRouter$p(this.a.a);
        if (access$getRouter$p == null || !access$getRouter$p.accessGoogleServices()) {
            LocationPickerBinder.Router access$getRouter$p2 = LocationPickerBinderImpl.access$getRouter$p(this.a.a);
            single = access$getRouter$p2 != null ? access$getRouter$p2.findLocation() : null;
        } else {
            single = LocationPickerBinderImpl.access$getFusedLocation$p(this.a.a).requestDeviceLocation();
        }
        if (single != null) {
            return single.map(new a(this));
        }
        return null;
    }
}
