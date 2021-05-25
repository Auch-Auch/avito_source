package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
public final class RuntimeModuleData {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final DeserializationComponents a;
    @NotNull
    public final PackagePartScopeCache b;

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final RuntimeModuleData create(@NotNull ClassLoader classLoader) {
            Intrinsics.checkNotNullParameter(classLoader, "classLoader");
            LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("RuntimeModuleData");
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(lockBasedStorageManager, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            Name special = Name.special("<runtime module for " + classLoader + Typography.greater);
            Intrinsics.checkNotNullExpressionValue(special, "special(\"<runtime module for $classLoader>\")");
            ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(special, lockBasedStorageManager, jvmBuiltIns, null, null, null, 56, null);
            jvmBuiltIns.setBuiltInsModule(moduleDescriptorImpl);
            jvmBuiltIns.initialize(moduleDescriptorImpl, true);
            ReflectKotlinClassFinder reflectKotlinClassFinder = new ReflectKotlinClassFinder(classLoader);
            DeserializedDescriptorResolver deserializedDescriptorResolver = new DeserializedDescriptorResolver();
            SingleModuleClassResolver singleModuleClassResolver = new SingleModuleClassResolver();
            NotFoundClasses notFoundClasses = new NotFoundClasses(lockBasedStorageManager, moduleDescriptorImpl);
            LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentFromClassLoaderProvider$default = RuntimeModuleDataKt.makeLazyJavaPackageFragmentFromClassLoaderProvider$default(classLoader, moduleDescriptorImpl, lockBasedStorageManager, notFoundClasses, reflectKotlinClassFinder, deserializedDescriptorResolver, singleModuleClassResolver, null, 128, null);
            DeserializationComponentsForJava makeDeserializationComponentsForJava = RuntimeModuleDataKt.makeDeserializationComponentsForJava(moduleDescriptorImpl, lockBasedStorageManager, notFoundClasses, makeLazyJavaPackageFragmentFromClassLoaderProvider$default, reflectKotlinClassFinder, deserializedDescriptorResolver);
            deserializedDescriptorResolver.setComponents(makeDeserializationComponentsForJava);
            JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
            Intrinsics.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
            JavaDescriptorResolver javaDescriptorResolver = new JavaDescriptorResolver(makeLazyJavaPackageFragmentFromClassLoaderProvider$default, javaResolverCache);
            singleModuleClassResolver.setResolver(javaDescriptorResolver);
            ClassLoader classLoader2 = Unit.class.getClassLoader();
            Intrinsics.checkNotNullExpressionValue(classLoader2, "stdlibClassLoader");
            JvmBuiltInsPackageFragmentProvider jvmBuiltInsPackageFragmentProvider = new JvmBuiltInsPackageFragmentProvider(lockBasedStorageManager, new ReflectKotlinClassFinder(classLoader2), moduleDescriptorImpl, notFoundClasses, jvmBuiltIns.getCustomizer(), jvmBuiltIns.getCustomizer(), DeserializationConfiguration.Default.INSTANCE, NewKotlinTypeChecker.Companion.getDefault(), new SamConversionResolverImpl(lockBasedStorageManager, CollectionsKt__CollectionsKt.emptyList()));
            moduleDescriptorImpl.setDependencies(moduleDescriptorImpl);
            moduleDescriptorImpl.initialize(new CompositePackageFragmentProvider(CollectionsKt__CollectionsKt.listOf((Object[]) new PackageFragmentProviderOptimized[]{javaDescriptorResolver.getPackageFragmentProvider(), jvmBuiltInsPackageFragmentProvider})));
            return new RuntimeModuleData(makeDeserializationComponentsForJava.getComponents(), new PackagePartScopeCache(deserializedDescriptorResolver, reflectKotlinClassFinder), null);
        }

        public Companion(j jVar) {
        }
    }

    public RuntimeModuleData(DeserializationComponents deserializationComponents, PackagePartScopeCache packagePartScopeCache, j jVar) {
        this.a = deserializationComponents;
        this.b = packagePartScopeCache;
    }

    @NotNull
    public final DeserializationComponents getDeserialization() {
        return this.a;
    }

    @NotNull
    public final ModuleDescriptor getModule() {
        return this.a.getModuleDescriptor();
    }

    @NotNull
    public final PackagePartScopeCache getPackagePartScopeCache() {
        return this.b;
    }
}
