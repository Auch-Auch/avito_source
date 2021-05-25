package a2.j.e.j;

import androidx.annotation.NonNull;
import com.google.firebase.installations.InstallationTokenResult;
import java.util.Objects;
public final class a extends InstallationTokenResult {
    public final String a;
    public final long b;
    public final long c;

    public static final class b extends InstallationTokenResult.Builder {
        public String a;
        public Long b;
        public Long c;

        public b() {
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult build() {
            String str = this.a == null ? " token" : "";
            if (this.b == null) {
                str = a2.b.a.a.a.c3(str, " tokenExpirationTimestamp");
            }
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " tokenCreationTimestamp");
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b.longValue(), this.c.longValue(), null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult.Builder setToken(String str) {
            Objects.requireNonNull(str, "Null token");
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult.Builder setTokenCreationTimestamp(long j) {
            this.c = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult.Builder setTokenExpirationTimestamp(long j) {
            this.b = Long.valueOf(j);
            return this;
        }

        public b(InstallationTokenResult installationTokenResult, C0081a aVar) {
            a aVar2 = (a) installationTokenResult;
            this.a = aVar2.a;
            this.b = Long.valueOf(aVar2.b);
            this.c = Long.valueOf(aVar2.c);
        }
    }

    public a(String str, long j, long j2, C0081a aVar) {
        this.a = str;
        this.b = j;
        this.c = j2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationTokenResult)) {
            return false;
        }
        InstallationTokenResult installationTokenResult = (InstallationTokenResult) obj;
        if (this.a.equals(installationTokenResult.getToken()) && this.b == installationTokenResult.getTokenExpirationTimestamp() && this.c == installationTokenResult.getTokenCreationTimestamp()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    @NonNull
    public String getToken() {
        return this.a;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    @NonNull
    public long getTokenCreationTimestamp() {
        return this.c;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    @NonNull
    public long getTokenExpirationTimestamp() {
        return this.b;
    }

    public int hashCode() {
        long j = this.b;
        long j2 = this.c;
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public InstallationTokenResult.Builder toBuilder() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("InstallationTokenResult{token=");
        L.append(this.a);
        L.append(", tokenExpirationTimestamp=");
        L.append(this.b);
        L.append(", tokenCreationTimestamp=");
        return a2.b.a.a.a.l(L, this.c, "}");
    }
}
