package defpackage;

import android.view.View;
import com.avito.android.location_picker.view.LocationPickerViewImpl;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: b2  reason: default package */
public final class b2 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public b2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            ((LocationPickerViewImpl.g) this.b).a.getRetryClicked().accept(Unit.INSTANCE);
        } else if (i == 1) {
            ((LocationPickerViewImpl.g) this.b).a.getSettingsClicked().accept(Unit.INSTANCE);
            LocationPickerViewImpl.access$openSettingsScreen(((LocationPickerViewImpl.g) this.b).a);
        } else if (i == 2) {
            ((LocationPickerViewImpl.g) this.b).a.getRetryClicked().accept(Unit.INSTANCE);
        } else if (i == 3) {
            ((LocationPickerViewImpl.g) this.b).a.getRetryClicked().accept(Unit.INSTANCE);
        } else {
            throw null;
        }
    }
}
