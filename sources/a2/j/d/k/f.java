package a2.j.d.k;

import com.google.common.reflect.TypeResolver;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;
public class f extends TypeResolver.e {
    public final /* synthetic */ TypeVariable c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(TypeResolver.e eVar, AtomicInteger atomicInteger, TypeVariable typeVariable) {
        super(atomicInteger, null);
        this.c = typeVariable;
    }

    @Override // com.google.common.reflect.TypeResolver.e
    public TypeVariable<?> b(Type[] typeArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
        linkedHashSet.addAll(Arrays.asList(this.c.getBounds()));
        if (linkedHashSet.size() > 1) {
            linkedHashSet.remove(Object.class);
        }
        return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
    }
}
