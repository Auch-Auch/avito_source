package a7.a.b.a.m;

import a2.b.a.a.a;
import com.avito.android.util.preferences.SessionContract;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class i {
    public final boolean a;
    @NotNull
    public final String b;
    public final boolean c;

    public i(boolean z, @NotNull String str, boolean z2) {
        Intrinsics.checkNotNullParameter(str, SessionContract.SESSION);
        this.a = z;
        this.b = str;
        this.c = z2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.a == iVar.a && Intrinsics.areEqual(this.b, iVar.b) && this.c == iVar.c;
    }

    public int hashCode() {
        boolean z = this.a;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = i2 * 31;
        String str = this.b;
        int hashCode = (i5 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.c;
        if (!z2) {
            i = z2 ? 1 : 0;
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("NetworkAndSession(isNetworkAvailable=");
        L.append(this.a);
        L.append(", session=");
        L.append(this.b);
        L.append(", shouldKeepConnection=");
        return a.B(L, this.c, ")");
    }
}
