package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import a2.b.a.a.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class IncompatibleVersionErrorData<T> {
    public final T a;
    public final T b;
    @NotNull
    public final String c;
    @NotNull
    public final ClassId d;

    public IncompatibleVersionErrorData(T t, T t2, @NotNull String str, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Intrinsics.checkNotNullParameter(classId, "classId");
        this.a = t;
        this.b = t2;
        this.c = str;
        this.d = classId;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IncompatibleVersionErrorData)) {
            return false;
        }
        IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
        return Intrinsics.areEqual(this.a, incompatibleVersionErrorData.a) && Intrinsics.areEqual(this.b, incompatibleVersionErrorData.b) && Intrinsics.areEqual(this.c, incompatibleVersionErrorData.c) && Intrinsics.areEqual(this.d, incompatibleVersionErrorData.d);
    }

    public int hashCode() {
        T t = this.a;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return this.d.hashCode() + a.B0(this.c, (hashCode + i) * 31, 31);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("IncompatibleVersionErrorData(actualVersion=");
        L.append((Object) this.a);
        L.append(", expectedVersion=");
        L.append((Object) this.b);
        L.append(", filePath=");
        L.append(this.c);
        L.append(", classId=");
        L.append(this.d);
        L.append(')');
        return L.toString();
    }
}
