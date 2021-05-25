package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerState;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class u0<T, R> implements Function<Unit, ObservableSource<? extends LocationPickerState>> {
    public final /* synthetic */ LocationPickerBinderImpl a;

    public u0(LocationPickerBinderImpl locationPickerBinderImpl) {
        this.a = locationPickerBinderImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [a2.a.a.n1.v0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // io.reactivex.rxjava3.functions.Function
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.core.ObservableSource<? extends com.avito.android.location_picker.entities.LocationPickerState> apply(kotlin.Unit r5) {
        /*
            r4 = this;
            kotlin.Unit r5 = (kotlin.Unit) r5
            com.avito.android.location_picker.LocationPickerBinderImpl r5 = r4.a
            com.jakewharton.rxrelay3.BehaviorRelay r5 = com.avito.android.location_picker.LocationPickerBinderImpl.access$getStateRelay$p(r5)
            com.avito.android.location_picker.LocationPickerBinderImpl r0 = r4.a
            kotlin.jvm.functions.Function1 r0 = com.avito.android.location_picker.LocationPickerBinderImpl.access$getCombinedStateChanges$p(r0)
            if (r0 == 0) goto L_0x0016
            a2.a.a.n1.v0 r1 = new a2.a.a.n1.v0
            r1.<init>(r0)
            r0 = r1
        L_0x0016:
            io.reactivex.rxjava3.functions.Function r0 = (io.reactivex.rxjava3.functions.Function) r0
            io.reactivex.rxjava3.core.Observable r5 = r5.switchMap(r0)
            com.avito.android.location_picker.LocationPickerBinderImpl r0 = r4.a
            com.jakewharton.rxrelay3.BehaviorRelay r0 = com.avito.android.location_picker.LocationPickerBinderImpl.access$getStateRelay$p(r0)
            java.lang.Object r0 = r0.getValue()
            com.avito.android.location_picker.entities.LocationPickerState r0 = (com.avito.android.location_picker.entities.LocationPickerState) r0
            if (r0 == 0) goto L_0x002b
            goto L_0x0031
        L_0x002b:
            com.avito.android.location_picker.LocationPickerBinderImpl r0 = r4.a
            com.avito.android.location_picker.entities.LocationPickerState r0 = com.avito.android.location_picker.LocationPickerBinderImpl.access$getInitialState$p(r0)
        L_0x0031:
            a2.a.a.n1.t0 r1 = a2.a.a.n1.t0.a
            io.reactivex.rxjava3.core.Observable r5 = r5.scan(r0, r1)
            java.lang.String r0 = "stateRelay.switchMap(com…e -> stateChange(state) }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            com.avito.android.location_picker.LocationPickerBinderImpl r0 = r4.a
            com.avito.android.util.BuildInfo r0 = com.avito.android.location_picker.LocationPickerBinderImpl.access$getBuild$p(r0)
            io.reactivex.rxjava3.core.Observable r5 = com.avito.android.location_picker.UtilsKt.logDiffIfDebug(r5, r0)
            r0 = 300(0x12c, double:1.48E-321)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.avito.android.location_picker.LocationPickerBinderImpl r3 = r4.a
            com.avito.android.util.SchedulersFactory3 r3 = com.avito.android.location_picker.LocationPickerBinderImpl.access$getSchedulers$p(r3)
            io.reactivex.rxjava3.core.Scheduler r3 = r3.computation()
            io.reactivex.rxjava3.core.Observable r5 = r5.debounce(r0, r2, r3)
            io.reactivex.rxjava3.core.Observable r5 = r5.distinctUntilChanged()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.a.n1.u0.apply(java.lang.Object):java.lang.Object");
    }
}
