package a2.a.a.b3.a;

import com.avito.android.str_calendar.booking.CalendarViewModelImpl;
public final class v implements Runnable {
    public final /* synthetic */ CalendarViewModelImpl.b a;

    public v(CalendarViewModelImpl.b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.getData();
    }
}
