package a2.a.a.i.i.b;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.perfomance.ScreenFirstImageDrawingEvent;
import com.avito.android.analytics.screens.image.ImageLoadingTrackerImpl;
public final class a implements Runnable {
    public final /* synthetic */ ImageLoadingTrackerImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ String g;

    public a(ImageLoadingTrackerImpl imageLoadingTrackerImpl, String str, int i, int i2, String str2, boolean z, String str3) {
        this.a = imageLoadingTrackerImpl;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = str2;
        this.f = z;
        this.g = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String networkType = this.a.i.networkType();
        if (this.a.k.getImageMetricToDwh().invoke().booleanValue() || (this.a.f.getHasSmallEventsCount() && this.a.k.getSendSmallMetrics().invoke().booleanValue())) {
            Analytics analytics = this.a.d;
            String str = this.a.b;
            String str2 = this.b;
            long lastClickTimestamp = this.a.m.lastClickTimestamp();
            long timestampSince1970 = this.a.m.timestampSince1970();
            int i = this.c;
            int i2 = this.d;
            analytics.track(new ScreenFirstImageDrawingEvent(str, networkType, str2, lastClickTimestamp, this.a.m.startupTimeTimestamp(), this.g, this.e, this.f, i, i2, timestampSince1970));
        }
    }
}
