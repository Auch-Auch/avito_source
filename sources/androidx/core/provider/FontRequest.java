package androidx.core.provider;

import a2.b.a.a.a;
import android.util.Base64;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.List;
public final class FontRequest {
    public final String a;
    public final String b;
    public final String c;
    public final List<List<byte[]>> d;
    public final int e;
    public final String f;

    public FontRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<List<byte[]>> list) {
        String str4 = (String) Preconditions.checkNotNull(str);
        this.a = str4;
        String str5 = (String) Preconditions.checkNotNull(str2);
        this.b = str5;
        String str6 = (String) Preconditions.checkNotNull(str3);
        this.c = str6;
        this.d = (List) Preconditions.checkNotNull(list);
        this.e = 0;
        this.f = str4 + "-" + str5 + "-" + str6;
    }

    @Nullable
    public List<List<byte[]>> getCertificates() {
        return this.d;
    }

    @ArrayRes
    public int getCertificatesArrayResId() {
        return this.e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public String getIdentifier() {
        return this.f;
    }

    @NonNull
    public String getProviderAuthority() {
        return this.a;
    }

    @NonNull
    public String getProviderPackage() {
        return this.b;
    }

    @NonNull
    public String getQuery() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder L = a.L("FontRequest {mProviderAuthority: ");
        L.append(this.a);
        L.append(", mProviderPackage: ");
        L.append(this.b);
        L.append(", mQuery: ");
        L.append(this.c);
        L.append(", mCertificates:");
        sb.append(L.toString());
        for (int i = 0; i < this.d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e);
        return sb.toString();
    }

    public FontRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @ArrayRes int i) {
        String str4 = (String) Preconditions.checkNotNull(str);
        this.a = str4;
        String str5 = (String) Preconditions.checkNotNull(str2);
        this.b = str5;
        String str6 = (String) Preconditions.checkNotNull(str3);
        this.c = str6;
        this.d = null;
        Preconditions.checkArgument(i != 0);
        this.e = i;
        this.f = str4 + "-" + str5 + "-" + str6;
    }
}
