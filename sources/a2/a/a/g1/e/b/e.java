package a2.a.a.g1.e.b;

import android.content.DialogInterface;
import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog;
public final class e implements DialogInterface.OnCancelListener {
    public final /* synthetic */ InlineFiltersCalendarDialog a;

    public e(InlineFiltersCalendarDialog inlineFiltersCalendarDialog) {
        this.a = inlineFiltersCalendarDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.f.invoke();
    }
}
