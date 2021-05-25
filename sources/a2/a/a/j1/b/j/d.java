package a2.a.a.j1.b.j;

import com.avito.android.job.interview.pickers.TimePickerDialog;
import com.avito.android.util.Views;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Unit> {
    public final /* synthetic */ TimePickerDialog a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(TimePickerDialog timePickerDialog) {
        super(0);
        this.a = timePickerDialog;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        Views.disable(this.a.w);
        this.a.w.setText(this.a.s);
        return Unit.INSTANCE;
    }
}
