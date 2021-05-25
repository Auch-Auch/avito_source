package t6.w.f.a.m.c.a.c.a;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
public final class b extends Lambda implements Function0<ConstantValue<?>> {
    public final /* synthetic */ LazyJavaScope a;
    public final /* synthetic */ JavaField b;
    public final /* synthetic */ PropertyDescriptorImpl c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(LazyJavaScope lazyJavaScope, JavaField javaField, PropertyDescriptorImpl propertyDescriptorImpl) {
        super(0);
        this.a = lazyJavaScope;
        this.b = javaField;
        this.c = propertyDescriptorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public ConstantValue<?> invoke() {
        return this.a.getC().getComponents().getJavaPropertyInitializerEvaluator().getInitializerConstant(this.b, this.c);
    }
}
