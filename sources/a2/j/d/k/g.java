package a2.j.d.k;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;
public class g extends TypeToken.i.c<K> {
    public g(TypeToken.i iVar, TypeToken.i iVar2) {
        super(iVar2);
    }

    @Override // com.google.common.reflect.TypeToken.i
    public ImmutableList<K> b(Iterable<? extends K> iterable) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Object obj : iterable) {
            if (!d(obj).isInterface()) {
                builder.add((ImmutableList.Builder) obj);
            }
        }
        return super.b(builder.build());
    }

    @Override // com.google.common.reflect.TypeToken.i
    public Iterable<? extends K> c(K k) {
        return ImmutableSet.of();
    }
}
