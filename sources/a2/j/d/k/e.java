package a2.j.d.k;

import com.google.common.reflect.TypeResolver;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
public class e extends TypeResolver.c {
    public final /* synthetic */ TypeVariable b;
    public final /* synthetic */ TypeResolver.c c;

    public e(TypeResolver.c cVar, TypeVariable typeVariable, TypeResolver.c cVar2) {
        this.b = typeVariable;
        this.c = cVar2;
    }

    @Override // com.google.common.reflect.TypeResolver.c
    public Type a(TypeVariable<?> typeVariable, TypeResolver.c cVar) {
        if (typeVariable.getGenericDeclaration().equals(this.b.getGenericDeclaration())) {
            return typeVariable;
        }
        return this.c.a(typeVariable, cVar);
    }
}
