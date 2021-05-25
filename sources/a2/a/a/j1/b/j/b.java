package a2.a.a.j1.b.j;

import com.avito.android.job.interview.pickers.TimePickerDialog;
import com.avito.android.lib.design.picker.WheelData;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function2<WheelData<?>, WheelData<?>, Unit> {
    public final /* synthetic */ c a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(c cVar) {
        super(2);
        this.a = cVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(WheelData<?> wheelData, WheelData<?> wheelData2) {
        c cVar = this.a;
        TimePickerDialog.access$verifyInterval(cVar.d, cVar.a, wheelData, wheelData2);
        return Unit.INSTANCE;
    }
}
