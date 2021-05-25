package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class LazyJavaTypeParameterResolver implements TypeParameterResolver {
    @NotNull
    public final LazyJavaResolverContext a;
    @NotNull
    public final DeclarationDescriptor b;
    public final int c;
    @NotNull
    public final Map<JavaTypeParameter, Integer> d;
    @NotNull
    public final MemoizedFunctionToNullable<JavaTypeParameter, LazyJavaTypeParameterDescriptor> e;

    public static final class a extends Lambda implements Function1<JavaTypeParameter, LazyJavaTypeParameterDescriptor> {
        public final /* synthetic */ LazyJavaTypeParameterResolver a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver) {
            super(1);
            this.a = lazyJavaTypeParameterResolver;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public LazyJavaTypeParameterDescriptor invoke(JavaTypeParameter javaTypeParameter) {
            JavaTypeParameter javaTypeParameter2 = javaTypeParameter;
            Intrinsics.checkNotNullParameter(javaTypeParameter2, "typeParameter");
            Integer num = (Integer) this.a.d.get(javaTypeParameter2);
            if (num == null) {
                return null;
            }
            LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver = this.a;
            return new LazyJavaTypeParameterDescriptor(ContextKt.copyWithNewDefaultTypeQualifiers(ContextKt.child(lazyJavaTypeParameterResolver.a, lazyJavaTypeParameterResolver), lazyJavaTypeParameterResolver.b.getAnnotations()), javaTypeParameter2, lazyJavaTypeParameterResolver.c + num.intValue(), lazyJavaTypeParameterResolver.b);
        }
    }

    public LazyJavaTypeParameterResolver(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull JavaTypeParameterListOwner javaTypeParameterListOwner, int i) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics.checkNotNullParameter(javaTypeParameterListOwner, "typeParameterOwner");
        this.a = lazyJavaResolverContext;
        this.b = declarationDescriptor;
        this.c = i;
        this.d = CollectionsKt.mapToIndex(javaTypeParameterListOwner.getTypeParameters());
        this.e = lazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues(new a(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
    @Nullable
    public TypeParameterDescriptor resolveTypeParameter(@NotNull JavaTypeParameter javaTypeParameter) {
        Intrinsics.checkNotNullParameter(javaTypeParameter, "javaTypeParameter");
        LazyJavaTypeParameterDescriptor invoke = this.e.invoke(javaTypeParameter);
        return invoke == null ? this.a.getTypeParameterResolver().resolveTypeParameter(javaTypeParameter) : invoke;
    }
}
