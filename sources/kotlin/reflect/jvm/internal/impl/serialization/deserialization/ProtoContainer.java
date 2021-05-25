package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public abstract class ProtoContainer {
    @NotNull
    public final NameResolver a;
    @NotNull
    public final TypeTable b;
    @Nullable
    public final SourceElement c;

    public static final class Class extends ProtoContainer {
        @NotNull
        public final ProtoBuf.Class d;
        @Nullable
        public final Class e;
        @NotNull
        public final ClassId f;
        @NotNull
        public final ProtoBuf.Class.Kind g;
        public final boolean h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Class(@NotNull ProtoBuf.Class r2, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @Nullable SourceElement sourceElement, @Nullable Class r62) {
            super(nameResolver, typeTable, sourceElement, null);
            Intrinsics.checkNotNullParameter(r2, "classProto");
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics.checkNotNullParameter(typeTable, "typeTable");
            this.d = r2;
            this.e = r62;
            this.f = NameResolverUtilKt.getClassId(nameResolver, r2.getFqName());
            ProtoBuf.Class.Kind kind = Flags.CLASS_KIND.get(r2.getFlags());
            this.g = kind == null ? ProtoBuf.Class.Kind.CLASS : kind;
            Boolean bool = Flags.IS_INNER.get(r2.getFlags());
            Intrinsics.checkNotNullExpressionValue(bool, "IS_INNER.get(classProto.flags)");
            this.h = bool.booleanValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        @NotNull
        public FqName debugFqName() {
            FqName asSingleFqName = this.f.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName, "classId.asSingleFqName()");
            return asSingleFqName;
        }

        @NotNull
        public final ClassId getClassId() {
            return this.f;
        }

        @NotNull
        public final ProtoBuf.Class getClassProto() {
            return this.d;
        }

        @NotNull
        public final ProtoBuf.Class.Kind getKind() {
            return this.g;
        }

        @Nullable
        public final Class getOuterClass() {
            return this.e;
        }

        public final boolean isInner() {
            return this.h;
        }
    }

    public static final class Package extends ProtoContainer {
        @NotNull
        public final FqName d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Package(@NotNull FqName fqName, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @Nullable SourceElement sourceElement) {
            super(nameResolver, typeTable, sourceElement, null);
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics.checkNotNullParameter(typeTable, "typeTable");
            this.d = fqName;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        @NotNull
        public FqName debugFqName() {
            return this.d;
        }
    }

    public ProtoContainer(NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement, j jVar) {
        this.a = nameResolver;
        this.b = typeTable;
        this.c = sourceElement;
    }

    @NotNull
    public abstract FqName debugFqName();

    @NotNull
    public final NameResolver getNameResolver() {
        return this.a;
    }

    @Nullable
    public final SourceElement getSource() {
        return this.c;
    }

    @NotNull
    public final TypeTable getTypeTable() {
        return this.b;
    }

    @NotNull
    public String toString() {
        return ((Object) getClass().getSimpleName()) + ": " + debugFqName();
    }
}
