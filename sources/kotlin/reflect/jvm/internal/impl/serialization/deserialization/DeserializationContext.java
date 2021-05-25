package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import a2.b.a.a.a;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionSpecificBehaviorKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class DeserializationContext {
    @NotNull
    public final DeserializationComponents a;
    @NotNull
    public final NameResolver b;
    @NotNull
    public final DeclarationDescriptor c;
    @NotNull
    public final TypeTable d;
    @NotNull
    public final VersionRequirementTable e;
    @NotNull
    public final BinaryVersion f;
    @Nullable
    public final DeserializedContainerSource g;
    @NotNull
    public final TypeDeserializer h;
    @NotNull
    public final MemberDeserializer i;

    public DeserializationContext(@NotNull DeserializationComponents deserializationComponents, @NotNull NameResolver nameResolver, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull TypeTable typeTable, @NotNull VersionRequirementTable versionRequirementTable, @NotNull BinaryVersion binaryVersion, @Nullable DeserializedContainerSource deserializedContainerSource, @Nullable TypeDeserializer typeDeserializer, @NotNull List<ProtoBuf.TypeParameter> list) {
        String str;
        String presentableString;
        Intrinsics.checkNotNullParameter(deserializationComponents, "components");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(versionRequirementTable, "versionRequirementTable");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(list, "typeParameters");
        this.a = deserializationComponents;
        this.b = nameResolver;
        this.c = declarationDescriptor;
        this.d = typeTable;
        this.e = versionRequirementTable;
        this.f = binaryVersion;
        this.g = deserializedContainerSource;
        StringBuilder L = a.L("Deserializer for \"");
        L.append(declarationDescriptor.getName());
        L.append(Typography.quote);
        String sb = L.toString();
        if (deserializedContainerSource == null || (presentableString = deserializedContainerSource.getPresentableString()) == null) {
            str = "[container not found]";
        } else {
            str = presentableString;
        }
        this.h = new TypeDeserializer(this, typeDeserializer, list, sb, str, false, 32, null);
        this.i = new MemberDeserializer(this);
    }

    public static /* synthetic */ DeserializationContext childContext$default(DeserializationContext deserializationContext, DeclarationDescriptor declarationDescriptor, List list, NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, BinaryVersion binaryVersion, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            nameResolver = deserializationContext.b;
        }
        if ((i2 & 8) != 0) {
            typeTable = deserializationContext.d;
        }
        if ((i2 & 16) != 0) {
            versionRequirementTable = deserializationContext.e;
        }
        if ((i2 & 32) != 0) {
            binaryVersion = deserializationContext.f;
        }
        return deserializationContext.childContext(declarationDescriptor, list, nameResolver, typeTable, versionRequirementTable, binaryVersion);
    }

    @NotNull
    public final DeserializationContext childContext(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull List<ProtoBuf.TypeParameter> list, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @NotNull VersionRequirementTable versionRequirementTable, @NotNull BinaryVersion binaryVersion) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(list, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        VersionRequirementTable versionRequirementTable2 = versionRequirementTable;
        Intrinsics.checkNotNullParameter(versionRequirementTable2, "versionRequirementTable");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        DeserializationComponents deserializationComponents = this.a;
        if (!VersionSpecificBehaviorKt.isVersionRequirementTableWrittenCorrectly(binaryVersion)) {
            versionRequirementTable2 = this.e;
        }
        return new DeserializationContext(deserializationComponents, nameResolver, declarationDescriptor, typeTable, versionRequirementTable2, binaryVersion, this.g, this.h, list);
    }

    @NotNull
    public final DeserializationComponents getComponents() {
        return this.a;
    }

    @Nullable
    public final DeserializedContainerSource getContainerSource() {
        return this.g;
    }

    @NotNull
    public final DeclarationDescriptor getContainingDeclaration() {
        return this.c;
    }

    @NotNull
    public final MemberDeserializer getMemberDeserializer() {
        return this.i;
    }

    @NotNull
    public final NameResolver getNameResolver() {
        return this.b;
    }

    @NotNull
    public final StorageManager getStorageManager() {
        return this.a.getStorageManager();
    }

    @NotNull
    public final TypeDeserializer getTypeDeserializer() {
        return this.h;
    }

    @NotNull
    public final TypeTable getTypeTable() {
        return this.d;
    }

    @NotNull
    public final VersionRequirementTable getVersionRequirementTable() {
        return this.e;
    }
}
