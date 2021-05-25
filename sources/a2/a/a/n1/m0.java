package a2.a.a.n1;

import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.location_picker.LocationPickerBinderImpl;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
public final class m0<T, R> implements Function<Unit, ObservableSource<? extends AvitoMapBounds>> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;

    public m0(LocationPickerBinderImpl.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends AvitoMapBounds> apply(Unit unit) {
        return this.a.a.g.getVisibleRegionChanged().ambWith(Observable.timer(1, TimeUnit.SECONDS).map(l0.a));
    }
}
