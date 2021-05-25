package a2.a.a.n1;

import com.avito.android.location_picker.entities.LocationPickerState;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class o<T, R> implements Function<Boolean, SingleSource<? extends Function1<? super LocationPickerState, ? extends LocationPickerState>>> {
    public final /* synthetic */ q a;

    public o(q qVar) {
        this.a = qVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Function1<? super LocationPickerState, ? extends LocationPickerState>> apply(Boolean bool) {
        Single<Function1<LocationPickerState, LocationPickerState>> timeout;
        Boolean bool2 = bool;
        Intrinsics.checkNotNullExpressionValue(bool2, "locationSettingsEnabled");
        if (!bool2.booleanValue()) {
            return this.a.c.invoke();
        }
        Single<Function1<LocationPickerState, LocationPickerState>> a3 = this.a.b.invoke();
        if (a3 == null || (timeout = a3.timeout(5, TimeUnit.SECONDS, this.a.a.a.j.computation())) == null) {
            return null;
        }
        return timeout.onErrorResumeNext(new n(this));
    }
}
