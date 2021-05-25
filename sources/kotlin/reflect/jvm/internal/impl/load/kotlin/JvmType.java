package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public abstract class JvmType {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final Primitive a = new Primitive(JvmPrimitiveType.BOOLEAN);
    @NotNull
    public static final Primitive b = new Primitive(JvmPrimitiveType.CHAR);
    @NotNull
    public static final Primitive c = new Primitive(JvmPrimitiveType.BYTE);
    @NotNull
    public static final Primitive d = new Primitive(JvmPrimitiveType.SHORT);
    @NotNull
    public static final Primitive e = new Primitive(JvmPrimitiveType.INT);
    @NotNull
    public static final Primitive f = new Primitive(JvmPrimitiveType.FLOAT);
    @NotNull
    public static final Primitive g = new Primitive(JvmPrimitiveType.LONG);
    @NotNull
    public static final Primitive h = new Primitive(JvmPrimitiveType.DOUBLE);

    public static final class Array extends JvmType {
        @NotNull
        public final JvmType i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Array(@NotNull JvmType jvmType) {
            super(null);
            Intrinsics.checkNotNullParameter(jvmType, "elementType");
            this.i = jvmType;
        }

        @NotNull
        public final JvmType getElementType() {
            return this.i;
        }
    }

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Primitive getBOOLEAN$descriptors_jvm() {
            return JvmType.a;
        }

        @NotNull
        public final Primitive getBYTE$descriptors_jvm() {
            return JvmType.c;
        }

        @NotNull
        public final Primitive getCHAR$descriptors_jvm() {
            return JvmType.b;
        }

        @NotNull
        public final Primitive getDOUBLE$descriptors_jvm() {
            return JvmType.h;
        }

        @NotNull
        public final Primitive getFLOAT$descriptors_jvm() {
            return JvmType.f;
        }

        @NotNull
        public final Primitive getINT$descriptors_jvm() {
            return JvmType.e;
        }

        @NotNull
        public final Primitive getLONG$descriptors_jvm() {
            return JvmType.g;
        }

        @NotNull
        public final Primitive getSHORT$descriptors_jvm() {
            return JvmType.d;
        }

        public Companion(j jVar) {
        }
    }

    public static final class Object extends JvmType {
        @NotNull
        public final String i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Object(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "internalName");
            this.i = str;
        }

        @NotNull
        public final String getInternalName() {
            return this.i;
        }
    }

    public static final class Primitive extends JvmType {
        @Nullable
        public final JvmPrimitiveType i;

        public Primitive(@Nullable JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.i = jvmPrimitiveType;
        }

        @Nullable
        public final JvmPrimitiveType getJvmPrimitiveType() {
            return this.i;
        }
    }

    public JvmType() {
    }

    @NotNull
    public String toString() {
        return JvmTypeFactoryImpl.a.toString(this);
    }

    public JvmType(j jVar) {
    }
}
