package a2.a.a.i3.c.a.i;

import a2.b.a.a.a;
import com.avito.android.user_adverts.SoaProgressState;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class d {
    public final boolean a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final SoaProgressState d;

    public d(boolean z, @Nullable String str, @Nullable String str2, @Nullable SoaProgressState soaProgressState) {
        this.a = z;
        this.b = str;
        this.c = str2;
        this.d = soaProgressState;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && Intrinsics.areEqual(this.b, dVar.b) && Intrinsics.areEqual(this.c, dVar.c) && Intrinsics.areEqual(this.d, dVar.d);
    }

    public int hashCode() {
        boolean z = this.a;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i * 31;
        String str = this.b;
        int i5 = 0;
        int hashCode = (i4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        SoaProgressState soaProgressState = this.d;
        if (soaProgressState != null) {
            i5 = soaProgressState.hashCode();
        }
        return hashCode2 + i5;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SoaUpdateParams(delayUpdate=");
        L.append(this.a);
        L.append(", updateText=");
        L.append(this.b);
        L.append(", soaAdvertId=");
        L.append(this.c);
        L.append(", animationState=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }
}
