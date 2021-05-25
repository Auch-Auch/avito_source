package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class r0 extends Lambda implements Function1<LocationPickerState, LocationPickerState> {
    public final /* synthetic */ LocationPickerBinderImpl.d a;
    public final /* synthetic */ Throwable b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r0(LocationPickerBinderImpl.d dVar, Throwable th) {
        super(1);
        this.a = dVar;
        this.b = th;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public LocationPickerState invoke(LocationPickerState locationPickerState) {
        LocationPickerState locationPickerState2 = locationPickerState;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        Function2 function2 = this.a.a;
        Throwable th = this.b;
        Intrinsics.checkNotNullExpressionValue(th, "error");
        return (LocationPickerState) function2.invoke(locationPickerState2, th);
    }
}
