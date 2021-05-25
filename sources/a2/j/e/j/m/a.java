package a2.j.e.j.m;

import androidx.annotation.Nullable;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
public final class a extends InstallationResponse {
    public final String a;
    public final String b;
    public final String c;
    public final TokenResult d;
    public final InstallationResponse.ResponseCode e;

    public static final class b extends InstallationResponse.Builder {
        public String a;
        public String b;
        public String c;
        public TokenResult d;
        public InstallationResponse.ResponseCode e;

        public b() {
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse build() {
            return new a(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder setAuthToken(TokenResult tokenResult) {
            this.d = tokenResult;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder setFid(String str) {
            this.b = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder setRefreshToken(String str) {
            this.c = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder setResponseCode(InstallationResponse.ResponseCode responseCode) {
            this.e = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder setUri(String str) {
            this.a = str;
            return this;
        }

        public b(InstallationResponse installationResponse, C0083a aVar) {
            a aVar2 = (a) installationResponse;
            this.a = aVar2.a;
            this.b = aVar2.b;
            this.c = aVar2.c;
            this.d = aVar2.d;
            this.e = aVar2.e;
        }
    }

    public a(String str, String str2, String str3, TokenResult tokenResult, InstallationResponse.ResponseCode responseCode, C0083a aVar) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = tokenResult;
        this.e = responseCode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.a;
        if (str != null ? str.equals(installationResponse.getUri()) : installationResponse.getUri() == null) {
            String str2 = this.b;
            if (str2 != null ? str2.equals(installationResponse.getFid()) : installationResponse.getFid() == null) {
                String str3 = this.c;
                if (str3 != null ? str3.equals(installationResponse.getRefreshToken()) : installationResponse.getRefreshToken() == null) {
                    TokenResult tokenResult = this.d;
                    if (tokenResult != null ? tokenResult.equals(installationResponse.getAuthToken()) : installationResponse.getAuthToken() == null) {
                        InstallationResponse.ResponseCode responseCode = this.e;
                        if (responseCode == null) {
                            if (installationResponse.getResponseCode() == null) {
                                return true;
                            }
                        } else if (responseCode.equals(installationResponse.getResponseCode())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    @Nullable
    public TokenResult getAuthToken() {
        return this.d;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    @Nullable
    public String getFid() {
        return this.b;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    @Nullable
    public String getRefreshToken() {
        return this.c;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    @Nullable
    public InstallationResponse.ResponseCode getResponseCode() {
        return this.e;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    @Nullable
    public String getUri() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.c;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        TokenResult tokenResult = this.d;
        int hashCode4 = (hashCode3 ^ (tokenResult == null ? 0 : tokenResult.hashCode())) * 1000003;
        InstallationResponse.ResponseCode responseCode = this.e;
        if (responseCode != null) {
            i = responseCode.hashCode();
        }
        return hashCode4 ^ i;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public InstallationResponse.Builder toBuilder() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("InstallationResponse{uri=");
        L.append(this.a);
        L.append(", fid=");
        L.append(this.b);
        L.append(", refreshToken=");
        L.append(this.c);
        L.append(", authToken=");
        L.append(this.d);
        L.append(", responseCode=");
        L.append(this.e);
        L.append("}");
        return L.toString();
    }
}
