package a2.a.a.n1.x0;

import android.app.Dialog;
import com.avito.android.location_picker.view.LocationPickerViewImpl;
import com.jakewharton.rxrelay3.Relay;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ LocationPickerViewImpl.g a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(LocationPickerViewImpl.g gVar) {
        super(0);
        this.a = gVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        Dialog dialog = this.a.a.z;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.a.a.z = null;
        Relay<Unit> dialogOkButtonClicked = this.a.a.getDialogOkButtonClicked();
        Unit unit = Unit.INSTANCE;
        dialogOkButtonClicked.accept(unit);
        return unit;
    }
}
