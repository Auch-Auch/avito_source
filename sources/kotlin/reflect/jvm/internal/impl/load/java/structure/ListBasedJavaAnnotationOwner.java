package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public interface ListBasedJavaAnnotationOwner extends JavaAnnotationOwner {

    public static final class DefaultImpls {
        @Nullable
        public static JavaAnnotation findAnnotation(@NotNull ListBasedJavaAnnotationOwner listBasedJavaAnnotationOwner, @NotNull FqName fqName) {
            FqName fqName2;
            Intrinsics.checkNotNullParameter(listBasedJavaAnnotationOwner, "this");
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Iterator<T> it = listBasedJavaAnnotationOwner.getAnnotations().iterator();
            while (true) {
                fqName2 = null;
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                ClassId classId = next.getClassId();
                if (classId != null) {
                    fqName2 = classId.asSingleFqName();
                }
                if (Intrinsics.areEqual(fqName2, fqName)) {
                    fqName2 = next;
                    break;
                }
            }
            return (JavaAnnotation) fqName2;
        }
    }
}
