package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import a2.b.a.a.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class ClassData {
    @NotNull
    public final NameResolver a;
    @NotNull
    public final ProtoBuf.Class b;
    @NotNull
    public final BinaryVersion c;
    @NotNull
    public final SourceElement d;

    public ClassData(@NotNull NameResolver nameResolver, @NotNull ProtoBuf.Class r3, @NotNull BinaryVersion binaryVersion, @NotNull SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(r3, "classProto");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(sourceElement, "sourceElement");
        this.a = nameResolver;
        this.b = r3;
        this.c = binaryVersion;
        this.d = sourceElement;
    }

    @NotNull
    public final NameResolver component1() {
        return this.a;
    }

    @NotNull
    public final ProtoBuf.Class component2() {
        return this.b;
    }

    @NotNull
    public final BinaryVersion component3() {
        return this.c;
    }

    @NotNull
    public final SourceElement component4() {
        return this.d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassData)) {
            return false;
        }
        ClassData classData = (ClassData) obj;
        return Intrinsics.areEqual(this.a, classData.a) && Intrinsics.areEqual(this.b, classData.b) && Intrinsics.areEqual(this.c, classData.c) && Intrinsics.areEqual(this.d, classData.d);
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        return this.d.hashCode() + ((hashCode2 + ((hashCode + (this.a.hashCode() * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ClassData(nameResolver=");
        L.append(this.a);
        L.append(", classProto=");
        L.append(this.b);
        L.append(", metadataVersion=");
        L.append(this.c);
        L.append(", sourceElement=");
        L.append(this.d);
        L.append(')');
        return L.toString();
    }
}
