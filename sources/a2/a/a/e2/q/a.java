package a2.a.a.e2.q;

import android.view.View;
import com.avito.android.publish.date_picker.DatePickerSheetDialog;
public final class a implements View.OnClickListener {
    public final /* synthetic */ DatePickerSheetDialog a;

    public a(DatePickerSheetDialog datePickerSheetDialog) {
        this.a = datePickerSheetDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Long currentValue = DatePickerSheetDialog.access$getDatePicker$p(this.a).getCurrentValue();
        if (currentValue != null) {
            this.a.x.invoke(Long.valueOf(currentValue.longValue()));
        }
        this.a.close();
    }
}
