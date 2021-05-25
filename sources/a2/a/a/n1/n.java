package a2.a.a.n1;

import com.avito.android.location_picker.entities.LocationPickerState;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.functions.Function1;
public final class n<T, R> implements Function<Throwable, SingleSource<? extends Function1<? super LocationPickerState, ? extends LocationPickerState>>> {
    public final /* synthetic */ o a;

    public n(o oVar) {
        this.a = oVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Function1<? super LocationPickerState, ? extends LocationPickerState>> apply(Throwable th) {
        String message = th.getMessage();
        if (message != null) {
            this.a.a.a.a.m.trackResolveCoordinates(null, message);
        }
        return this.a.a.c.invoke();
    }
}
