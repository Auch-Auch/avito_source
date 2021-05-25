package a2.a.a.v2.b.i.a;

import android.content.DialogInterface;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarDialog;
public final class f implements DialogInterface.OnDismissListener {
    public final /* synthetic */ HotelsCalendarDialog a;

    public f(HotelsCalendarDialog hotelsCalendarDialog) {
        this.a = hotelsCalendarDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.f.invoke();
    }
}
