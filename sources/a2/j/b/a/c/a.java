package a2.j.b.a.c;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import java.util.Map;
import java.util.Objects;
public final class a extends EventInternal {
    public final String a;
    public final Integer b;
    public final EncodedPayload c;
    public final long d;
    public final long e;
    public final Map<String, String> f;

    public static final class b extends EventInternal.Builder {
        public String a;
        public Integer b;
        public EncodedPayload c;
        public Long d;
        public Long e;
        public Map<String, String> f;

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal build() {
            String str = this.a == null ? " transportName" : "";
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " encodedPayload");
            }
            if (this.d == null) {
                str = a2.b.a.a.a.c3(str, " eventMillis");
            }
            if (this.e == null) {
                str = a2.b.a.a.a.c3(str, " uptimeMillis");
            }
            if (this.f == null) {
                str = a2.b.a.a.a.c3(str, " autoMetadata");
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b, this.c, this.d.longValue(), this.e.longValue(), this.f, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public Map<String, String> getAutoMetadata() {
            Map<String, String> map = this.f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder setAutoMetadata(Map<String, String> map) {
            this.f = map;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder setCode(Integer num) {
            this.b = num;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder setEncodedPayload(EncodedPayload encodedPayload) {
            Objects.requireNonNull(encodedPayload, "Null encodedPayload");
            this.c = encodedPayload;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder setEventMillis(long j) {
            this.d = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder setTransportName(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder setUptimeMillis(long j) {
            this.e = Long.valueOf(j);
            return this;
        }
    }

    public a(String str, Integer num, EncodedPayload encodedPayload, long j, long j2, Map map, C0032a aVar) {
        this.a = str;
        this.b = num;
        this.c = encodedPayload;
        this.d = j;
        this.e = j2;
        this.f = map;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventInternal)) {
            return false;
        }
        EventInternal eventInternal = (EventInternal) obj;
        if (!this.a.equals(eventInternal.getTransportName()) || ((num = this.b) != null ? !num.equals(eventInternal.getCode()) : eventInternal.getCode() != null) || !this.c.equals(eventInternal.getEncodedPayload()) || this.d != eventInternal.getEventMillis() || this.e != eventInternal.getUptimeMillis() || !this.f.equals(eventInternal.getAutoMetadata())) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public Map<String, String> getAutoMetadata() {
        return this.f;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    @Nullable
    public Integer getCode() {
        return this.b;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public EncodedPayload getEncodedPayload() {
        return this.c;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public long getEventMillis() {
        return this.d;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public String getTransportName() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public long getUptimeMillis() {
        return this.e;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.b;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j = this.d;
        long j2 = this.e;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.c.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f.hashCode();
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("EventInternal{transportName=");
        L.append(this.a);
        L.append(", code=");
        L.append(this.b);
        L.append(", encodedPayload=");
        L.append(this.c);
        L.append(", eventMillis=");
        L.append(this.d);
        L.append(", uptimeMillis=");
        L.append(this.e);
        L.append(", autoMetadata=");
        return a2.b.a.a.a.x(L, this.f, "}");
    }
}
