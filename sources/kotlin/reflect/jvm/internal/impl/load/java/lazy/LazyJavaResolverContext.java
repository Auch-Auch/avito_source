package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class LazyJavaResolverContext {
    @NotNull
    public final JavaResolverComponents a;
    @NotNull
    public final TypeParameterResolver b;
    @NotNull
    public final Lazy<JavaTypeQualifiersByElementType> c;
    @NotNull
    public final Lazy d;
    @NotNull
    public final JavaTypeResolver e;

    public LazyJavaResolverContext(@NotNull JavaResolverComponents javaResolverComponents, @NotNull TypeParameterResolver typeParameterResolver, @NotNull Lazy<JavaTypeQualifiersByElementType> lazy) {
        Intrinsics.checkNotNullParameter(javaResolverComponents, "components");
        Intrinsics.checkNotNullParameter(typeParameterResolver, "typeParameterResolver");
        Intrinsics.checkNotNullParameter(lazy, "delegateForDefaultTypeQualifiers");
        this.a = javaResolverComponents;
        this.b = typeParameterResolver;
        this.c = lazy;
        this.d = lazy;
        this.e = new JavaTypeResolver(this, typeParameterResolver);
    }

    @NotNull
    public final JavaResolverComponents getComponents() {
        return this.a;
    }

    @Nullable
    public final JavaTypeQualifiersByElementType getDefaultTypeQualifiers() {
        return (JavaTypeQualifiersByElementType) this.d.getValue();
    }

    @NotNull
    public final Lazy<JavaTypeQualifiersByElementType> getDelegateForDefaultTypeQualifiers$descriptors_jvm() {
        return this.c;
    }

    @NotNull
    public final ModuleDescriptor getModule() {
        return this.a.getModule();
    }

    @NotNull
    public final StorageManager getStorageManager() {
        return this.a.getStorageManager();
    }

    @NotNull
    public final TypeParameterResolver getTypeParameterResolver() {
        return this.b;
    }

    @NotNull
    public final JavaTypeResolver getTypeResolver() {
        return this.e;
    }
}
