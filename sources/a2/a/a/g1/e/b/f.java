package a2.a.a.g1.e.b;

import android.content.DialogInterface;
import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog;
public final class f implements DialogInterface.OnDismissListener {
    public final /* synthetic */ InlineFiltersCalendarDialog a;

    public f(InlineFiltersCalendarDialog inlineFiltersCalendarDialog) {
        this.a = inlineFiltersCalendarDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.f.invoke();
    }
}
