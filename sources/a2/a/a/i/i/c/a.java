package a2.a.a.i.i.c;

import com.avito.android.analytics.screens.tracker.ScreenMemoryMeasureTrackerImpl;
public final class a implements Runnable {
    public final /* synthetic */ ScreenMemoryMeasureTrackerImpl a;

    public a(ScreenMemoryMeasureTrackerImpl screenMemoryMeasureTrackerImpl) {
        this.a = screenMemoryMeasureTrackerImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a();
        this.a.e.restart();
        this.a.restart();
        this.a.g.resume();
        ScreenMemoryMeasureTrackerImpl.access$sendReportDelayed(this.a, 10000);
    }
}
