package t6.w.f.a.m.b.c;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
public class a implements Function1<KotlinTypeRefiner, SimpleType> {
    public final /* synthetic */ AbstractClassDescriptor.a a;

    public a(AbstractClassDescriptor.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
        KotlinTypeRefiner kotlinTypeRefiner2 = kotlinTypeRefiner;
        ClassifierDescriptor refineDescriptor = kotlinTypeRefiner2.refineDescriptor(AbstractClassDescriptor.this);
        if (refineDescriptor == null) {
            return (SimpleType) AbstractClassDescriptor.this.defaultType.invoke();
        }
        if (refineDescriptor instanceof TypeAliasDescriptor) {
            return KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) refineDescriptor, TypeUtils.getDefaultTypeProjections(refineDescriptor.getTypeConstructor().getParameters()));
        }
        if (refineDescriptor instanceof ModuleAwareClassDescriptor) {
            return TypeUtils.makeUnsubstitutedType(refineDescriptor.getTypeConstructor().refine(kotlinTypeRefiner2), ((ModuleAwareClassDescriptor) refineDescriptor).getUnsubstitutedMemberScope(kotlinTypeRefiner2), this);
        }
        return refineDescriptor.getDefaultType();
    }
}
