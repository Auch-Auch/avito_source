package a2.j.b.a.c.l;

import a2.b.a.a.a;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import java.util.Objects;
public final class b extends BackendResponse {
    public final BackendResponse.Status a;
    public final long b;

    public b(BackendResponse.Status status, long j) {
        Objects.requireNonNull(status, "Null status");
        this.a = status;
        this.b = j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        if (!this.a.equals(backendResponse.getStatus()) || this.b != backendResponse.getNextRequestWaitMillis()) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public long getNextRequestWaitMillis() {
        return this.b;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public BackendResponse.Status getStatus() {
        return this.a;
    }

    public int hashCode() {
        long j = this.b;
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder L = a.L("BackendResponse{status=");
        L.append(this.a);
        L.append(", nextRequestWaitMillis=");
        return a.l(L, this.b, "}");
    }
}
