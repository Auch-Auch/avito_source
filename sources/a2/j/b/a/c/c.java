package a2.j.b.a.c;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Arrays;
import java.util.Objects;
public final class c extends TransportContext {
    public final String a;
    public final byte[] b;
    public final Priority c;

    public static final class b extends TransportContext.Builder {
        public String a;
        public byte[] b;
        public Priority c;

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext build() {
            String str = this.a == null ? " backendName" : "";
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " priority");
            }
            if (str.isEmpty()) {
                return new c(this.a, this.b, this.c, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext.Builder setBackendName(String str) {
            Objects.requireNonNull(str, "Null backendName");
            this.a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext.Builder setExtras(@Nullable byte[] bArr) {
            this.b = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext.Builder setPriority(Priority priority) {
            Objects.requireNonNull(priority, "Null priority");
            this.c = priority;
            return this;
        }
    }

    public c(String str, byte[] bArr, Priority priority, a aVar) {
        this.a = str;
        this.b = bArr;
        this.c = priority;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransportContext)) {
            return false;
        }
        TransportContext transportContext = (TransportContext) obj;
        if (this.a.equals(transportContext.getBackendName())) {
            if (Arrays.equals(this.b, transportContext instanceof c ? ((c) transportContext).b : transportContext.getExtras()) && this.c.equals(transportContext.getPriority())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public String getBackendName() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    @Nullable
    public byte[] getExtras() {
        return this.b;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Priority getPriority() {
        return this.c;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b)) * 1000003) ^ this.c.hashCode();
    }
}
