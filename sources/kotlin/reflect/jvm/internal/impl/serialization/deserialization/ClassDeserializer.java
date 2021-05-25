package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.x;
import t6.r.a.j;
public final class ClassDeserializer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final Set<ClassId> c = x.setOf(ClassId.topLevel(StandardNames.FqNames.cloneable.toSafe()));
    @NotNull
    public final DeserializationComponents a;
    @NotNull
    public final Function1<a, ClassDescriptor> b;

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Set<ClassId> getBLACK_LIST() {
            return ClassDeserializer.c;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a {
        @NotNull
        public final ClassId a;
        @Nullable
        public final ClassData b;

        public a(@NotNull ClassId classId, @Nullable ClassData classData) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            this.a = classId;
            this.b = classData;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof a) && Intrinsics.areEqual(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public static final class b extends Lambda implements Function1<a, ClassDescriptor> {
        public final /* synthetic */ ClassDeserializer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ClassDeserializer classDeserializer) {
            super(1);
            this.a = classDeserializer;
        }

        @Override // kotlin.jvm.functions.Function1
        public ClassDescriptor invoke(a aVar) {
            a aVar2 = aVar;
            Intrinsics.checkNotNullParameter(aVar2, "key");
            return ClassDeserializer.access$createClass(this.a, aVar2);
        }
    }

    public ClassDeserializer(@NotNull DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "components");
        this.a = deserializationComponents;
        this.b = deserializationComponents.getStorageManager().createMemoizedFunctionWithNullableValues(new b(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c0 A[EDGE_INSN: B:38:0x00c0->B:32:0x00c0 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor access$createClass(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer r12, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.a r13) {
        /*
        // Method dump skipped, instructions count: 248
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.access$createClass(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer$a):kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor");
    }

    public static /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer classDeserializer, ClassId classId, ClassData classData, int i, Object obj) {
        if ((i & 2) != 0) {
            classData = null;
        }
        return classDeserializer.deserializeClass(classId, classData);
    }

    @Nullable
    public final ClassDescriptor deserializeClass(@NotNull ClassId classId, @Nullable ClassData classData) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        return this.b.invoke(new a(classId, classData));
    }
}
