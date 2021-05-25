package defpackage;

import com.avito.android.location.find.FusedLocationInteractor;
import com.avito.android.location_picker.LocationPickerBinderImpl;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: f1  reason: default package */
public final class f1<T, R> implements Function<Unit, ObservableSource<? extends Boolean>> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public f1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public final ObservableSource<? extends Boolean> apply(Unit unit) {
        int i = this.a;
        if (i == 0) {
            return ((LocationPickerBinderImpl.a) this.b).a.k.isPermissionsGrantedDialog().toObservable();
        }
        if (i == 1) {
            return ((LocationPickerBinderImpl.a) this.b).a.k.isPermissionsGrantedDialog().toObservable();
        }
        if (i == 2) {
            ((LocationPickerBinderImpl.a) this.b).a.i.setActivity(((LocationPickerBinderImpl.a) this.b).a.x);
            return FusedLocationInteractor.DefaultImpls.isDeviceLocationEnabled$default(((LocationPickerBinderImpl.a) this.b).a.i, false, 1, null).toObservable();
        }
        throw null;
    }
}
