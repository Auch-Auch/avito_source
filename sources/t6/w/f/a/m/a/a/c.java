package t6.w.f.a.m.a.a;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
public final class c extends Lambda implements Function0<ClassDescriptor> {
    public final /* synthetic */ LazyJavaClassDescriptor a;
    public final /* synthetic */ ClassDescriptor b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(LazyJavaClassDescriptor lazyJavaClassDescriptor, ClassDescriptor classDescriptor) {
        super(0);
        this.a = lazyJavaClassDescriptor;
        this.b = classDescriptor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public ClassDescriptor invoke() {
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.a;
        JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
        Intrinsics.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
        return lazyJavaClassDescriptor.copy$descriptors_jvm(javaResolverCache, this.b);
    }
}
