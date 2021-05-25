package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class q0 extends Lambda implements Function1<LocationPickerState, LocationPickerState> {
    public final /* synthetic */ LocationPickerBinderImpl.c a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q0(LocationPickerBinderImpl.c cVar, Object obj) {
        super(1);
        this.a = cVar;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public LocationPickerState invoke(LocationPickerState locationPickerState) {
        LocationPickerState locationPickerState2 = locationPickerState;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        return (LocationPickerState) this.a.a.invoke(locationPickerState2, this.b);
    }
}
