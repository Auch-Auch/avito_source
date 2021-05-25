package a2.g.k;

import com.facebook.appevents.AppEvent;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.ArrayList;
import java.util.List;
@AutoHandleExceptions
public class t {
    public List<AppEvent> a = new ArrayList();
    public List<AppEvent> b = new ArrayList();
    public int c;
    public AttributionIdentifiers d;
    public String e;

    public t(AttributionIdentifiers attributionIdentifiers, String str) {
        this.d = attributionIdentifiers;
        this.e = str;
    }

    public synchronized void a(AppEvent appEvent) {
        if (this.a.size() + this.b.size() >= 1000) {
            this.c++;
        } else {
            this.a.add(appEvent);
        }
    }

    public synchronized List<AppEvent> b() {
        List<AppEvent> list;
        list = this.a;
        this.a = new ArrayList();
        return list;
    }
}
