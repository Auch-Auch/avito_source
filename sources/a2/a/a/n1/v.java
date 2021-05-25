package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class v<T, R> implements Function<Unit, Unit> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;

    public v(LocationPickerBinderImpl.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Unit apply(Unit unit) {
        LocationPickerBinderImpl.access$trackFindCoordinates(this.a.a);
        return Unit.INSTANCE;
    }
}
