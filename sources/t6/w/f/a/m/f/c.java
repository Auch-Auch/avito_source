package t6.w.f.a.m.f;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
public final class c extends Lambda implements Function1<KotlinType, CharSequence> {
    public final /* synthetic */ DescriptorRendererImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(DescriptorRendererImpl descriptorRendererImpl) {
        super(1);
        this.a = descriptorRendererImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(KotlinType kotlinType) {
        KotlinType kotlinType2 = kotlinType;
        DescriptorRendererImpl descriptorRendererImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(kotlinType2, "it");
        return descriptorRendererImpl.renderType(kotlinType2);
    }
}
