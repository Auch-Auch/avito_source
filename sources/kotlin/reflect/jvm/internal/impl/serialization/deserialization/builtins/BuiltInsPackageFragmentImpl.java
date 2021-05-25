package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
public final class BuiltInsPackageFragmentImpl extends DeserializedPackageFragmentImpl implements BuiltInsPackageFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0070, code lost:
            r11 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0071, code lost:
            kotlin.io.CloseableKt.closeFinally(r13, r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0074, code lost:
            throw r11;
         */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl create(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.FqName r10, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.storage.StorageManager r11, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r12, @org.jetbrains.annotations.NotNull java.io.InputStream r13, boolean r14) {
            /*
                r9 = this;
                java.lang.String r0 = "fqName"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                java.lang.String r0 = "storageManager"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                java.lang.String r0 = "module"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                java.lang.String r0 = "inputStream"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
                kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion$Companion r0 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion.Companion     // Catch:{ all -> 0x006e }
                kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion r6 = r0.readFrom(r13)     // Catch:{ all -> 0x006e }
                r0 = 0
                if (r6 == 0) goto L_0x0067
                boolean r1 = r6.isCompatible()     // Catch:{ all -> 0x006e }
                if (r1 == 0) goto L_0x0041
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol.INSTANCE     // Catch:{ all -> 0x006e }
                kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r1 = r1.getExtensionRegistry()     // Catch:{ all -> 0x006e }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.parseFrom(r13, r1)     // Catch:{ all -> 0x006e }
                kotlin.io.CloseableKt.closeFinally(r13, r0)
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl r13 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl
                java.lang.String r0 = "proto"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                r8 = 0
                r1 = r13
                r2 = r10
                r3 = r11
                r4 = r12
                r7 = r14
                r1.<init>(r2, r3, r4, r5, r6, r7, r8)
                return r13
            L_0x0041:
                java.lang.UnsupportedOperationException r10 = new java.lang.UnsupportedOperationException
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r12 = "Kotlin built-in definition format version is not supported: expected "
                r11.append(r12)
                kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion r12 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion.INSTANCE
                r11.append(r12)
                java.lang.String r12 = ", actual "
                r11.append(r12)
                r11.append(r6)
                java.lang.String r12 = ". Please update Kotlin"
                r11.append(r12)
                java.lang.String r11 = r11.toString()
                r10.<init>(r11)
                throw r10
            L_0x0067:
                java.lang.String r10 = "version"
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
                throw r0
            L_0x006e:
                r10 = move-exception
                throw r10     // Catch:{ all -> 0x0070 }
            L_0x0070:
                r11 = move-exception
                kotlin.io.CloseableKt.closeFinally(r13, r10)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl.Companion.create(kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, java.io.InputStream, boolean):kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl");
        }

        public Companion(j jVar) {
        }
    }

    public BuiltInsPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf.PackageFragment packageFragment, BuiltInsBinaryVersion builtInsBinaryVersion, boolean z, j jVar) {
        super(fqName, storageManager, moduleDescriptor, packageFragment, builtInsBinaryVersion, null);
    }
}
