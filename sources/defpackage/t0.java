package defpackage;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.UtilsKt;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: t0  reason: default package */
public final class t0<T, R> implements Function<Unit, MaybeSource<? extends Unit>> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public t0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public final MaybeSource<? extends Unit> apply(Unit unit) {
        int i = this.a;
        if (i == 0) {
            return UtilsKt.toMaybe(((LocationPickerBinderImpl.a) this.b).a.k.isPermissionGranted());
        }
        if (i == 1) {
            return UtilsKt.toMaybe(((LocationPickerBinderImpl.a) this.b).a.k.isPermissionGranted());
        }
        throw null;
    }
}
