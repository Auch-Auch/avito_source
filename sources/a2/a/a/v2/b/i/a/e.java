package a2.a.a.v2.b.i.a;

import android.content.DialogInterface;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarDialog;
public final class e implements DialogInterface.OnCancelListener {
    public final /* synthetic */ HotelsCalendarDialog a;

    public e(HotelsCalendarDialog hotelsCalendarDialog) {
        this.a = hotelsCalendarDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.f.invoke();
    }
}
