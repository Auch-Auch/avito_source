package a2.j.b.a.c.l;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import java.util.Arrays;
import java.util.Objects;
public final class a extends BackendRequest {
    public final Iterable<EventInternal> a;
    public final byte[] b;

    public static final class b extends BackendRequest.Builder {
        public Iterable<EventInternal> a;
        public byte[] b;

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public BackendRequest build() {
            String str = this.a == null ? " events" : "";
            if (str.isEmpty()) {
                return new a(this.a, this.b, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public BackendRequest.Builder setEvents(Iterable<EventInternal> iterable) {
            Objects.requireNonNull(iterable, "Null events");
            this.a = iterable;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public BackendRequest.Builder setExtras(@Nullable byte[] bArr) {
            this.b = bArr;
            return this;
        }
    }

    public a(Iterable iterable, byte[] bArr, C0034a aVar) {
        this.a = iterable;
        this.b = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendRequest)) {
            return false;
        }
        BackendRequest backendRequest = (BackendRequest) obj;
        if (this.a.equals(backendRequest.getEvents())) {
            if (Arrays.equals(this.b, backendRequest instanceof a ? ((a) backendRequest).b : backendRequest.getExtras())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRequest
    public Iterable<EventInternal> getEvents() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRequest
    @Nullable
    public byte[] getExtras() {
        return this.b;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("BackendRequest{events=");
        L.append(this.a);
        L.append(", extras=");
        L.append(Arrays.toString(this.b));
        L.append("}");
        return L.toString();
    }
}
