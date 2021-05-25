package a2.a.a.j1.b.j;

import com.avito.android.job.interview.pickers.TimePickerDialog;
import com.avito.android.lib.design.picker.Picker;
import com.avito.android.lib.design.picker.WheelData;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function2<WheelData<?>, WheelData<?>, Unit> {
    public final /* synthetic */ Picker a;
    public final /* synthetic */ WheelData b;
    public final /* synthetic */ WheelData c;
    public final /* synthetic */ TimePickerDialog d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Picker picker, WheelData wheelData, WheelData wheelData2, TimePickerDialog timePickerDialog) {
        super(2);
        this.a = picker;
        this.b = wheelData;
        this.c = wheelData2;
        this.d = timePickerDialog;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(WheelData<?> wheelData, WheelData<?> wheelData2) {
        WheelData<?> wheelData3 = wheelData;
        WheelData<?> wheelData4 = wheelData2;
        if (!(!Intrinsics.areEqual(wheelData3, this.b)) && !(!Intrinsics.areEqual(wheelData4, this.c))) {
            TimePickerDialog.access$verifyInterval(this.d, this.a, wheelData3, wheelData4);
            this.a.clearOnSelection();
            this.a.setOnSelection(new b(this));
        }
        return Unit.INSTANCE;
    }
}
