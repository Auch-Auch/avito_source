package kotlin.reflect.jvm.internal.impl.load.java;

import a2.b.a.a.a;
import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public interface JavaClassFinder {
    @Nullable
    JavaClass findClass(@NotNull Request request);

    @Nullable
    JavaPackage findPackage(@NotNull FqName fqName);

    @Nullable
    Set<String> knownClassNamesInPackage(@NotNull FqName fqName);

    public static final class Request {
        @NotNull
        public final ClassId a;
        @Nullable
        public final byte[] b;
        @Nullable
        public final JavaClass c;

        public Request(@NotNull ClassId classId, @Nullable byte[] bArr, @Nullable JavaClass javaClass) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            this.a = classId;
            this.b = bArr;
            this.c = javaClass;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return Intrinsics.areEqual(this.a, request.a) && Intrinsics.areEqual(this.b, request.b) && Intrinsics.areEqual(this.c, request.c);
        }

        @NotNull
        public final ClassId getClassId() {
            return this.a;
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            byte[] bArr = this.b;
            int i = 0;
            int hashCode2 = (hashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            JavaClass javaClass = this.c;
            if (javaClass != null) {
                i = javaClass.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Request(classId=");
            L.append(this.a);
            L.append(", previouslyFoundClassFileContent=");
            L.append(Arrays.toString(this.b));
            L.append(", outerClass=");
            L.append(this.c);
            L.append(')');
            return L.toString();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Request(ClassId classId, byte[] bArr, JavaClass javaClass, int i, j jVar) {
            this(classId, (i & 2) != 0 ? null : bArr, (i & 4) != 0 ? null : javaClass);
        }
    }
}
