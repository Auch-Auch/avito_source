package kotlin;

import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\b\u0007\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\u001fB\u0019\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0014R\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\fR\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0019\u0010\u0010\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\fR\u0019\u0010\u0013\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\f¨\u0006\""}, d2 = {"Lkotlin/KotlinVersion;", "", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "compareTo", "(Lkotlin/KotlinVersion;)I", "major", "minor", "isAtLeast", "(II)Z", "patch", "(III)Z", AuthSource.BOOKING_ORDER, "I", "getMajor", AuthSource.SEND_ABUSE, "version", "c", "getMinor", "d", "getPatch", "<init>", "(III)V", "(II)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class KotlinVersion implements Comparable<KotlinVersion> {
    @JvmField
    @NotNull
    public static final KotlinVersion CURRENT = new KotlinVersion(1, 4, 32);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int MAX_COMPONENT_VALUE = 255;
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlin/KotlinVersion$Companion;", "", "Lkotlin/KotlinVersion;", "CURRENT", "Lkotlin/KotlinVersion;", "", "MAX_COMPONENT_VALUE", "I", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public KotlinVersion(int i, int i2, int i3) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        if (i >= 0 && 255 >= i && i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3) {
            this.a = (i << 16) + (i2 << 8) + i3;
            return;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + FormatterType.defaultDecimalSeparator + i2 + FormatterType.defaultDecimalSeparator + i3).toString());
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KotlinVersion)) {
            obj = null;
        }
        KotlinVersion kotlinVersion = (KotlinVersion) obj;
        if (kotlinVersion == null || this.a != kotlinVersion.a) {
            return false;
        }
        return true;
    }

    public final int getMajor() {
        return this.b;
    }

    public final int getMinor() {
        return this.c;
    }

    public final int getPatch() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a;
    }

    public final boolean isAtLeast(int i, int i2) {
        int i3 = this.b;
        return i3 > i || (i3 == i && this.c >= i2);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0005: IGET  (r1v0 int) = (r3v0 'this' kotlin.KotlinVersion A[IMMUTABLE_TYPE, THIS]) kotlin.KotlinVersion.b int), (wrap: char : ?: SGET   com.avito.android.lib.design.input.FormatterType.defaultDecimalSeparator char), (wrap: int : 0x000f: IGET  (r2v0 int) = (r3v0 'this' kotlin.KotlinVersion A[IMMUTABLE_TYPE, THIS]) kotlin.KotlinVersion.c int), (wrap: char : ?: SGET   com.avito.android.lib.design.input.FormatterType.defaultDecimalSeparator char), (wrap: int : 0x0017: IGET  (r1v2 int) = (r3v0 'this' kotlin.KotlinVersion A[IMMUTABLE_TYPE, THIS]) kotlin.KotlinVersion.d int)] */
    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append(FormatterType.defaultDecimalSeparator);
        sb.append(this.c);
        sb.append(FormatterType.defaultDecimalSeparator);
        sb.append(this.d);
        return sb.toString();
    }

    public int compareTo(@NotNull KotlinVersion kotlinVersion) {
        Intrinsics.checkNotNullParameter(kotlinVersion, "other");
        return this.a - kotlinVersion.a;
    }

    public final boolean isAtLeast(int i, int i2, int i3) {
        int i4;
        int i5 = this.b;
        return i5 > i || (i5 == i && ((i4 = this.c) > i2 || (i4 == i2 && this.d >= i3)));
    }

    public KotlinVersion(int i, int i2) {
        this(i, i2, 0);
    }
}
