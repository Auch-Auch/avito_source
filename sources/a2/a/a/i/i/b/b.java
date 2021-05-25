package a2.a.a.i.i.b;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.image.ImageLoadingTrackerImpl;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.lib.design.input.FormatterType;
public final class b implements Runnable {
    public final /* synthetic */ ImageLoadingTrackerImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public b(ImageLoadingTrackerImpl imageLoadingTrackerImpl, String str, String str2) {
        this.a = imageLoadingTrackerImpl;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String networkType = this.a.i.networkType();
        if (this.a.k.getImageStatsdMetrics().invoke().booleanValue()) {
            this.a.d.track(new StatsdEvent.TimeEvent(this.a.e.getPrefixStatsd() + ".chronological" + FormatterType.defaultDecimalSeparator + this.a.g.sessionName() + FormatterType.defaultDecimalSeparator + this.a.b + ".image-drawing" + FormatterType.defaultDecimalSeparator + this.b + FormatterType.defaultDecimalSeparator + networkType + FormatterType.defaultDecimalSeparator + this.c, Long.valueOf(this.a.g.elapsed())));
            StringBuilder sb = new StringBuilder();
            sb.append(this.a.e.getPrefixStatsd());
            sb.append(".chronological");
            sb.append(FormatterType.defaultDecimalSeparator);
            sb.append(this.a.g.sessionName());
            sb.append(FormatterType.defaultDecimalSeparator);
            sb.append(this.a.b);
            sb.append(".-");
            sb.append(".content-drawing");
            sb.append(".image-");
            this.a.d.track(new StatsdEvent.TimeEvent(a.u(sb, this.b, ".page-etc", ".not-placeholder"), Long.valueOf(this.a.g.elapsed())));
        }
    }
}
