package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public abstract class ReflectJavaAnnotationArgument implements JavaAnnotationArgument {
    @NotNull
    public static final Factory Factory = new Factory(null);
    @Nullable
    public final Name a;

    public static final class Factory {
        public Factory() {
        }

        @NotNull
        public final ReflectJavaAnnotationArgument create(@NotNull Object obj, @Nullable Name name) {
            Intrinsics.checkNotNullParameter(obj, "value");
            if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(obj.getClass())) {
                return new ReflectJavaEnumValueAnnotationArgument(name, (Enum) obj);
            }
            if (obj instanceof Annotation) {
                return new ReflectJavaAnnotationAsAnnotationArgument(name, (Annotation) obj);
            }
            if (obj instanceof Object[]) {
                return new ReflectJavaArrayAnnotationArgument(name, (Object[]) obj);
            }
            if (obj instanceof Class) {
                return new ReflectJavaClassObjectAnnotationArgument(name, (Class) obj);
            }
            return new ReflectJavaLiteralAnnotationArgument(name, obj);
        }

        public Factory(j jVar) {
        }
    }

    public ReflectJavaAnnotationArgument(@Nullable Name name) {
        this.a = name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument
    @Nullable
    public Name getName() {
        return this.a;
    }
}
