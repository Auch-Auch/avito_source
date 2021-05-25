package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.analytics.ScreenCloseFromBlock;
import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class e0 extends Lambda implements Function2<LocationPickerState, ScreenCloseFromBlock, LocationPickerState> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e0(LocationPickerBinderImpl.a aVar) {
        super(2);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, ScreenCloseFromBlock screenCloseFromBlock) {
        LocationPickerState locationPickerState2 = locationPickerState;
        ScreenCloseFromBlock screenCloseFromBlock2 = screenCloseFromBlock;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        Intrinsics.checkNotNullParameter(screenCloseFromBlock2, "reason");
        this.a.a.t.trackScreenClosed(locationPickerState2, screenCloseFromBlock2);
        return locationPickerState2;
    }
}
