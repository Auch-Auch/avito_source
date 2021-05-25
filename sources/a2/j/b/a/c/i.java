package a2.j.b.a.c;

import a2.b.a.a.a;
import a2.j.b.a.c.b;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Objects;
public final class i<T> implements Transport<T> {
    public final TransportContext a;
    public final String b;
    public final Encoding c;
    public final Transformer<T, byte[]> d;
    public final j e;

    public i(TransportContext transportContext, String str, Encoding encoding, Transformer<T, byte[]> transformer, j jVar) {
        this.a = transportContext;
        this.b = str;
        this.c = encoding;
        this.d = transformer;
        this.e = jVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: com.google.android.datatransport.Event<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r11v2. Raw type applied. Possible types: com.google.android.datatransport.Transformer<T, byte[]>, java.lang.Object, com.google.android.datatransport.Transformer<?, byte[]> */
    @Override // com.google.android.datatransport.Transport
    public void schedule(Event<T> event, TransportScheduleCallback transportScheduleCallback) {
        j jVar = this.e;
        b.C0033b bVar = new b.C0033b();
        TransportContext transportContext = this.a;
        Objects.requireNonNull(transportContext, "Null transportContext");
        bVar.a = transportContext;
        Objects.requireNonNull(event, "Null event");
        bVar.c = event;
        String str = this.b;
        Objects.requireNonNull(str, "Null transportName");
        bVar.b = str;
        Transformer transformer = (Transformer<T, byte[]>) this.d;
        Objects.requireNonNull(transformer, "Null transformer");
        bVar.d = transformer;
        Encoding encoding = this.c;
        Objects.requireNonNull(encoding, "Null encoding");
        bVar.e = encoding;
        String str2 = bVar.a == null ? " transportContext" : "";
        if (bVar.b == null) {
            str2 = a.c3(str2, " transportName");
        }
        if (bVar.c == null) {
            str2 = a.c3(str2, " event");
        }
        if (bVar.d == null) {
            str2 = a.c3(str2, " transformer");
        }
        if (bVar.e == null) {
            str2 = a.c3(str2, " encoding");
        }
        if (str2.isEmpty()) {
            jVar.send(new b(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, null), transportScheduleCallback);
            return;
        }
        throw new IllegalStateException(a.c3("Missing required properties:", str2));
    }

    @Override // com.google.android.datatransport.Transport
    public void send(Event<T> event) {
        schedule(event, h.a);
    }
}
