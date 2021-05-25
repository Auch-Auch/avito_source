package a2.j.e.j.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.installations.remote.TokenResult;
public final class b extends TokenResult {
    public final String a;
    public final long b;
    public final TokenResult.ResponseCode c;

    /* renamed from: a2.j.e.j.m.b$b  reason: collision with other inner class name */
    public static final class C0084b extends TokenResult.Builder {
        public String a;
        public Long b;
        public TokenResult.ResponseCode c;

        public C0084b() {
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult build() {
            String str = this.b == null ? " tokenExpirationTimestamp" : "";
            if (str.isEmpty()) {
                return new b(this.a, this.b.longValue(), this.c, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder setResponseCode(TokenResult.ResponseCode responseCode) {
            this.c = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder setToken(String str) {
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder setTokenExpirationTimestamp(long j) {
            this.b = Long.valueOf(j);
            return this;
        }

        public C0084b(TokenResult tokenResult, a aVar) {
            b bVar = (b) tokenResult;
            this.a = bVar.a;
            this.b = Long.valueOf(bVar.b);
            this.c = bVar.c;
        }
    }

    public b(String str, long j, TokenResult.ResponseCode responseCode, a aVar) {
        this.a = str;
        this.b = j;
        this.c = responseCode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.a;
        if (str != null ? str.equals(tokenResult.getToken()) : tokenResult.getToken() == null) {
            if (this.b == tokenResult.getTokenExpirationTimestamp()) {
                TokenResult.ResponseCode responseCode = this.c;
                if (responseCode == null) {
                    if (tokenResult.getResponseCode() == null) {
                        return true;
                    }
                } else if (responseCode.equals(tokenResult.getResponseCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    @Nullable
    public TokenResult.ResponseCode getResponseCode() {
        return this.c;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    @Nullable
    public String getToken() {
        return this.a;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    @NonNull
    public long getTokenExpirationTimestamp() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.b;
        int i2 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        TokenResult.ResponseCode responseCode = this.c;
        if (responseCode != null) {
            i = responseCode.hashCode();
        }
        return i2 ^ i;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public TokenResult.Builder toBuilder() {
        return new C0084b(this, null);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("TokenResult{token=");
        L.append(this.a);
        L.append(", tokenExpirationTimestamp=");
        L.append(this.b);
        L.append(", responseCode=");
        L.append(this.c);
        L.append("}");
        return L.toString();
    }
}
