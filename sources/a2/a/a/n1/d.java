package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.remote.model.location_picker.CoordinatesCurrentResult;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Single<Function1<? super LocationPickerState, ? extends LocationPickerState>>> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;

    public static final class a<T, R> implements Function<CoordinatesCurrentResult, Function1<? super LocationPickerState, ? extends LocationPickerState>> {
        public final /* synthetic */ d a;

        public a(d dVar) {
            this.a = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Function1<? super LocationPickerState, ? extends LocationPickerState> apply(CoordinatesCurrentResult coordinatesCurrentResult) {
            return new c(this, coordinatesCurrentResult);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(LocationPickerBinderImpl.a aVar) {
        super(0);
        this.a = aVar;
    }

    /* renamed from: a */
    public final Single<Function1<LocationPickerState, LocationPickerState>> invoke() {
        return this.a.a.h.getCurrentCoordinates().subscribeOn(this.a.a.j.io()).map(new a(this));
    }
}
