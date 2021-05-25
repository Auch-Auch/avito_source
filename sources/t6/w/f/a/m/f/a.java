package t6.w.f.a.m.f;

import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import t6.n.d;
import t6.n.z;
public final class a extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
        DescriptorRendererOptions descriptorRendererOptions2 = descriptorRendererOptions;
        Intrinsics.checkNotNullParameter(descriptorRendererOptions2, "<this>");
        descriptorRendererOptions2.setExcludedTypeAnnotationClasses(z.plus((Set) descriptorRendererOptions2.getExcludedTypeAnnotationClasses(), (Iterable) d.listOf(StandardNames.FqNames.extensionFunctionType)));
        descriptorRendererOptions2.setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy.ALWAYS_PARENTHESIZED);
        return Unit.INSTANCE;
    }
}
