package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.x;
import t6.n.y;
import t6.r.a.j;
public final class DeserializedDescriptorResolver {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final Set<KotlinClassHeader.Kind> a = x.setOf(KotlinClassHeader.Kind.CLASS);
    @NotNull
    public static final Set<KotlinClassHeader.Kind> b = y.setOf((Object[]) new KotlinClassHeader.Kind[]{KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART});
    @NotNull
    public static final JvmMetadataVersion c = new JvmMetadataVersion(1, 1, 2);
    @NotNull
    public static final JvmMetadataVersion d = new JvmMetadataVersion(1, 1, 11);
    @NotNull
    public static final JvmMetadataVersion e = new JvmMetadataVersion(1, 1, 13);
    public DeserializationComponents components;

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final JvmMetadataVersion getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm() {
            return DeserializedDescriptorResolver.e;
        }

        @NotNull
        public final Set<KotlinClassHeader.Kind> getKOTLIN_CLASS$descriptors_jvm() {
            return DeserializedDescriptorResolver.a;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<Collection<? extends Name>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Collection<? extends Name> invoke() {
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    public static final boolean access$getSkipMetadataVersionCheck(DeserializedDescriptorResolver deserializedDescriptorResolver) {
        return deserializedDescriptorResolver.getComponents().getConfiguration().getSkipMetadataVersionCheck();
    }

    public final DeserializedContainerAbiStability a(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (getComponents().getConfiguration().getAllowUnstableDependencies()) {
            return DeserializedContainerAbiStability.STABLE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().isUnstableFirBinary()) {
            return DeserializedContainerAbiStability.FIR_UNSTABLE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().isUnstableJvmIrBinary()) {
            return DeserializedContainerAbiStability.IR_UNSTABLE;
        }
        return DeserializedContainerAbiStability.STABLE;
    }

    public final IncompatibleVersionErrorData<JvmMetadataVersion> b(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (getComponents().getConfiguration().getSkipMetadataVersionCheck() || kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
            return null;
        }
        return new IncompatibleVersionErrorData<>(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), JvmMetadataVersion.INSTANCE, kotlinJvmBinaryClass.getLocation(), kotlinJvmBinaryClass.getClassId());
    }

    public final boolean c(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (!getComponents().getConfiguration().getReportErrorsOnPreReleaseDependencies() || (!kotlinJvmBinaryClass.getClassHeader().isPreRelease() && !Intrinsics.areEqual(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), c))) {
            if (!(!getComponents().getConfiguration().getSkipPrereleaseCheck() && kotlinJvmBinaryClass.getClassHeader().isPreRelease() && Intrinsics.areEqual(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), d))) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public final MemberScope createKotlinPackagePartScope(@NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        String[] strings;
        Pair<JvmNameResolver, ProtoBuf.Package> pair;
        Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        String[] d2 = d(kotlinJvmBinaryClass, b);
        if (d2 == null || (strings = kotlinJvmBinaryClass.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.INSTANCE;
            pair = JvmProtoBufUtil.readPackageDataFrom(d2, strings);
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalStateException(Intrinsics.stringPlus("Could not read data from ", kotlinJvmBinaryClass.getLocation()), e2);
        } catch (Throwable th) {
            if (access$getSkipMetadataVersionCheck(this) || kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        JvmNameResolver component1 = pair.component1();
        ProtoBuf.Package component2 = pair.component2();
        return new DeserializedPackageMemberScope(packageFragmentDescriptor, component2, component1, kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), new JvmPackagePartSource(kotlinJvmBinaryClass, component2, component1, b(kotlinJvmBinaryClass), c(kotlinJvmBinaryClass), a(kotlinJvmBinaryClass)), getComponents(), a.a);
    }

    public final String[] d(KotlinJvmBinaryClass kotlinJvmBinaryClass, Set<? extends KotlinClassHeader.Kind> set) {
        KotlinClassHeader classHeader = kotlinJvmBinaryClass.getClassHeader();
        String[] data = classHeader.getData();
        if (data == null) {
            data = classHeader.getIncompatibleData();
        }
        if (data != null && set.contains(classHeader.getKind())) {
            return data;
        }
        return null;
    }

    @NotNull
    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents != null) {
            return deserializationComponents;
        }
        Intrinsics.throwUninitializedPropertyAccessException("components");
        throw null;
    }

    @Nullable
    public final ClassData readClassData$descriptors_jvm(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        String[] strings;
        Pair<JvmNameResolver, ProtoBuf.Class> pair;
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        String[] d2 = d(kotlinJvmBinaryClass, Companion.getKOTLIN_CLASS$descriptors_jvm());
        if (d2 == null || (strings = kotlinJvmBinaryClass.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.INSTANCE;
            pair = JvmProtoBufUtil.readClassDataFrom(d2, strings);
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalStateException(Intrinsics.stringPlus("Could not read data from ", kotlinJvmBinaryClass.getLocation()), e2);
        } catch (Throwable th) {
            if (access$getSkipMetadataVersionCheck(this) || kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        return new ClassData(pair.component1(), pair.component2(), kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), new KotlinJvmBinarySourceElement(kotlinJvmBinaryClass, b(kotlinJvmBinaryClass), c(kotlinJvmBinaryClass), a(kotlinJvmBinaryClass)));
    }

    @Nullable
    public final ClassDescriptor resolveClass(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        ClassData readClassData$descriptors_jvm = readClassData$descriptors_jvm(kotlinJvmBinaryClass);
        if (readClassData$descriptors_jvm == null) {
            return null;
        }
        return getComponents().getClassDeserializer().deserializeClass(kotlinJvmBinaryClass.getClassId(), readClassData$descriptors_jvm);
    }

    public final void setComponents(@NotNull DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }

    public final void setComponents(@NotNull DeserializationComponentsForJava deserializationComponentsForJava) {
        Intrinsics.checkNotNullParameter(deserializationComponentsForJava, "components");
        setComponents(deserializationComponentsForJava.getComponents());
    }
}
