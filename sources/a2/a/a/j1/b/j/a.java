package a2.a.a.j1.b.j;

import com.avito.android.job.interview.pickers.DatePickerDialog;
import com.avito.android.lib.design.picker.WheelData;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function2<WheelData<?>, WheelData<?>, Unit> {
    public final /* synthetic */ DatePickerDialog.b a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(DatePickerDialog.b bVar) {
        super(2);
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(WheelData<?> wheelData, WheelData<?> wheelData2) {
        DatePickerDialog.b bVar = this.a;
        DatePickerDialog.access$verifyDate(bVar.e, bVar.a, wheelData, wheelData2, bVar.d, bVar.f);
        return Unit.INSTANCE;
    }
}
