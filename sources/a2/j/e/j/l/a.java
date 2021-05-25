package a2.j.e.j.l;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import java.util.Objects;
public final class a extends PersistedInstallationEntry {
    public final String a;
    public final PersistedInstallation.RegistrationStatus b;
    public final String c;
    public final String d;
    public final long e;
    public final long f;
    public final String g;

    public static final class b extends PersistedInstallationEntry.Builder {
        public String a;
        public PersistedInstallation.RegistrationStatus b;
        public String c;
        public String d;
        public Long e;
        public Long f;
        public String g;

        public b() {
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry build() {
            String str = this.b == null ? " registrationStatus" : "";
            if (this.e == null) {
                str = a2.b.a.a.a.c3(str, " expiresInSecs");
            }
            if (this.f == null) {
                str = a2.b.a.a.a.c3(str, " tokenCreationEpochInSecs");
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b, this.c, this.d, this.e.longValue(), this.f.longValue(), this.g, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder setAuthToken(@Nullable String str) {
            this.c = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder setExpiresInSecs(long j) {
            this.e = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder setFirebaseInstallationId(String str) {
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder setFisError(@Nullable String str) {
            this.g = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder setRefreshToken(@Nullable String str) {
            this.d = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder setRegistrationStatus(PersistedInstallation.RegistrationStatus registrationStatus) {
            Objects.requireNonNull(registrationStatus, "Null registrationStatus");
            this.b = registrationStatus;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder setTokenCreationEpochInSecs(long j) {
            this.f = Long.valueOf(j);
            return this;
        }

        public b(PersistedInstallationEntry persistedInstallationEntry, C0082a aVar) {
            a aVar2 = (a) persistedInstallationEntry;
            this.a = aVar2.a;
            this.b = aVar2.b;
            this.c = aVar2.c;
            this.d = aVar2.d;
            this.e = Long.valueOf(aVar2.e);
            this.f = Long.valueOf(aVar2.f);
            this.g = aVar2.g;
        }
    }

    public a(String str, PersistedInstallation.RegistrationStatus registrationStatus, String str2, String str3, long j, long j2, String str4, C0082a aVar) {
        this.a = str;
        this.b = registrationStatus;
        this.c = str2;
        this.d = str3;
        this.e = j;
        this.f = j2;
        this.g = str4;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedInstallationEntry)) {
            return false;
        }
        PersistedInstallationEntry persistedInstallationEntry = (PersistedInstallationEntry) obj;
        String str3 = this.a;
        if (str3 != null ? str3.equals(persistedInstallationEntry.getFirebaseInstallationId()) : persistedInstallationEntry.getFirebaseInstallationId() == null) {
            if (this.b.equals(persistedInstallationEntry.getRegistrationStatus()) && ((str = this.c) != null ? str.equals(persistedInstallationEntry.getAuthToken()) : persistedInstallationEntry.getAuthToken() == null) && ((str2 = this.d) != null ? str2.equals(persistedInstallationEntry.getRefreshToken()) : persistedInstallationEntry.getRefreshToken() == null) && this.e == persistedInstallationEntry.getExpiresInSecs() && this.f == persistedInstallationEntry.getTokenCreationEpochInSecs()) {
                String str4 = this.g;
                if (str4 == null) {
                    if (persistedInstallationEntry.getFisError() == null) {
                        return true;
                    }
                } else if (str4.equals(persistedInstallationEntry.getFisError())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    @Nullable
    public String getAuthToken() {
        return this.c;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public long getExpiresInSecs() {
        return this.e;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    @Nullable
    public String getFirebaseInstallationId() {
        return this.a;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    @Nullable
    public String getFisError() {
        return this.g;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    @Nullable
    public String getRefreshToken() {
        return this.d;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    @NonNull
    public PersistedInstallation.RegistrationStatus getRegistrationStatus() {
        return this.b;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public long getTokenCreationEpochInSecs() {
        return this.f;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        String str2 = this.c;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.d;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        long j = this.e;
        long j2 = this.f;
        int i2 = (((((hashCode2 ^ hashCode3) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.g;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return i2 ^ i;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public PersistedInstallationEntry.Builder toBuilder() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("PersistedInstallationEntry{firebaseInstallationId=");
        L.append(this.a);
        L.append(", registrationStatus=");
        L.append(this.b);
        L.append(", authToken=");
        L.append(this.c);
        L.append(", refreshToken=");
        L.append(this.d);
        L.append(", expiresInSecs=");
        L.append(this.e);
        L.append(", tokenCreationEpochInSecs=");
        L.append(this.f);
        L.append(", fisError=");
        return a2.b.a.a.a.t(L, this.g, "}");
    }
}
