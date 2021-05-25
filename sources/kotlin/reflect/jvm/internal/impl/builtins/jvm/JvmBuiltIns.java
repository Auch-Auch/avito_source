package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.avito.android.remote.model.messenger.message.MessageBody;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class JvmBuiltIns extends KotlinBuiltIns {
    public static final /* synthetic */ KProperty<Object>[] h = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltIns.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    @Nullable
    public Function0<Settings> f;
    @NotNull
    public final NotNullLazyValue g;

    public enum Kind {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK
    }

    public static final class Settings {
        @NotNull
        public final ModuleDescriptor a;
        public final boolean b;

        public Settings(@NotNull ModuleDescriptor moduleDescriptor, boolean z) {
            Intrinsics.checkNotNullParameter(moduleDescriptor, "ownerModuleDescriptor");
            this.a = moduleDescriptor;
            this.b = z;
        }

        @NotNull
        public final ModuleDescriptor getOwnerModuleDescriptor() {
            return this.a;
        }

        public final boolean isAdditionalBuiltInsFeatureSupported() {
            return this.b;
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 2, 3};

        static {
            Kind.values();
        }
    }

    public static final class a extends Lambda implements Function0<JvmBuiltInsCustomizer> {
        public final /* synthetic */ JvmBuiltIns a;
        public final /* synthetic */ StorageManager b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(JvmBuiltIns jvmBuiltIns, StorageManager storageManager) {
            super(0);
            this.a = jvmBuiltIns;
            this.b = storageManager;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public JvmBuiltInsCustomizer invoke() {
            ModuleDescriptorImpl builtInsModule = this.a.getBuiltInsModule();
            Intrinsics.checkNotNullExpressionValue(builtInsModule, "builtInsModule");
            return new JvmBuiltInsCustomizer(builtInsModule, this.b, new t6.w.f.a.m.a.a.a(this.a));
        }
    }

    public static final class b extends Lambda implements Function0<Settings> {
        public final /* synthetic */ ModuleDescriptor a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ModuleDescriptor moduleDescriptor, boolean z) {
            super(0);
            this.a = moduleDescriptor;
            this.b = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Settings invoke() {
            return new Settings(this.a, this.b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns(@NotNull StorageManager storageManager, @NotNull Kind kind) {
        super(storageManager);
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kind, MessageBody.Location.KIND);
        this.g = storageManager.createLazyValue(new a(this, storageManager));
        int ordinal = kind.ordinal();
        if (ordinal == 1) {
            createBuiltInsModule(false);
        } else if (ordinal == 2) {
            createBuiltInsModule(true);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    @NotNull
    public AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return getCustomizer();
    }

    @NotNull
    public final JvmBuiltInsCustomizer getCustomizer() {
        return (JvmBuiltInsCustomizer) StorageKt.getValue(this.g, this, h[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    @NotNull
    public PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return getCustomizer();
    }

    public final void initialize(@NotNull ModuleDescriptor moduleDescriptor, boolean z) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        setPostponedSettingsComputation(new b(moduleDescriptor, z));
    }

    public final void setPostponedSettingsComputation(@NotNull Function0<Settings> function0) {
        Intrinsics.checkNotNullParameter(function0, "computation");
        Function0<Settings> function02 = this.f;
        this.f = function0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    @NotNull
    public List<ClassDescriptorFactory> getClassDescriptorFactories() {
        Iterable<ClassDescriptorFactory> classDescriptorFactories = super.getClassDescriptorFactories();
        Intrinsics.checkNotNullExpressionValue(classDescriptorFactories, "super.getClassDescriptorFactories()");
        StorageManager storageManager = getStorageManager();
        Intrinsics.checkNotNullExpressionValue(storageManager, "storageManager");
        ModuleDescriptorImpl builtInsModule = getBuiltInsModule();
        Intrinsics.checkNotNullExpressionValue(builtInsModule, "builtInsModule");
        return CollectionsKt___CollectionsKt.plus(classDescriptorFactories, new JvmBuiltInClassDescriptorFactory(storageManager, builtInsModule, null, 4, null));
    }
}
