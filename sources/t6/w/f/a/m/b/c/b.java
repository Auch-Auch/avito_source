package t6.w.f.a.m.b.c;

import a2.b.a.a.a;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
public class b implements Function0<MemberScope> {
    public final /* synthetic */ AbstractTypeParameterDescriptor.b a;

    public b(AbstractTypeParameterDescriptor.b bVar) {
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public MemberScope invoke() {
        StringBuilder L = a.L("Scope for type parameter ");
        L.append(this.a.a.asString());
        return TypeIntersectionScope.create(L.toString(), AbstractTypeParameterDescriptor.this.getUpperBounds());
    }
}
