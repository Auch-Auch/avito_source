package a2.a.a.j1.b.j;

import com.avito.android.job.interview.pickers.TimePickerDialog;
import com.avito.android.lib.design.picker.WheelData;
import com.avito.android.util.Views;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function2<WheelData<?>, WheelData<?>, Unit> {
    public final /* synthetic */ TimePickerDialog a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(TimePickerDialog timePickerDialog) {
        super(2);
        this.a = timePickerDialog;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(WheelData<?> wheelData, WheelData<?> wheelData2) {
        WheelData<?> wheelData3 = wheelData2;
        if (!(wheelData == null || wheelData3 == null)) {
            Views.enable(this.a.w);
        }
        return Unit.INSTANCE;
    }
}
