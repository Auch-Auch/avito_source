package a2.j.b.a.c;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.SendRequest;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Objects;
public final class b extends SendRequest {
    public final TransportContext a;
    public final String b;
    public final Event<?> c;
    public final Transformer<?, byte[]> d;
    public final Encoding e;

    /* renamed from: a2.j.b.a.c.b$b  reason: collision with other inner class name */
    public static final class C0033b extends SendRequest.Builder {
        public TransportContext a;
        public String b;
        public Event<?> c;
        public Transformer<?, byte[]> d;
        public Encoding e;

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder a(Encoding encoding) {
            Objects.requireNonNull(encoding, "Null encoding");
            this.e = encoding;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder b(Event<?> event) {
            Objects.requireNonNull(event, "Null event");
            this.c = event;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest build() {
            String str = this.a == null ? " transportContext" : "";
            if (this.b == null) {
                str = a2.b.a.a.a.c3(str, " transportName");
            }
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " event");
            }
            if (this.d == null) {
                str = a2.b.a.a.a.c3(str, " transformer");
            }
            if (this.e == null) {
                str = a2.b.a.a.a.c3(str, " encoding");
            }
            if (str.isEmpty()) {
                return new b(this.a, this.b, this.c, this.d, this.e, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder c(Transformer<?, byte[]> transformer) {
            Objects.requireNonNull(transformer, "Null transformer");
            this.d = transformer;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder setTransportContext(TransportContext transportContext) {
            Objects.requireNonNull(transportContext, "Null transportContext");
            this.a = transportContext;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder setTransportName(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.b = str;
            return this;
        }
    }

    public b(TransportContext transportContext, String str, Event event, Transformer transformer, Encoding encoding, a aVar) {
        this.a = transportContext;
        this.b = str;
        this.c = event;
        this.d = transformer;
        this.e = encoding;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public Encoding a() {
        return this.e;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public Event<?> b() {
        return this.c;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public Transformer<?, byte[]> c() {
        return this.d;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public TransportContext d() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SendRequest)) {
            return false;
        }
        SendRequest sendRequest = (SendRequest) obj;
        if (!this.a.equals(sendRequest.d()) || !this.b.equals(sendRequest.e()) || !this.c.equals(sendRequest.b()) || !this.d.equals(sendRequest.c()) || !this.e.equals(sendRequest.a())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode();
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("SendRequest{transportContext=");
        L.append(this.a);
        L.append(", transportName=");
        L.append(this.b);
        L.append(", event=");
        L.append(this.c);
        L.append(", transformer=");
        L.append(this.d);
        L.append(", encoding=");
        L.append(this.e);
        L.append("}");
        return L.toString();
    }
}
