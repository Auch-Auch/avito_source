package a2.j.d.c;

import com.google.common.collect.EnumMultiset;
import com.google.common.collect.Multisets;
public class r0 extends Multisets.e<E> {
    public final /* synthetic */ int a;
    public final /* synthetic */ EnumMultiset.b b;

    public r0(EnumMultiset.b bVar, int i) {
        this.b = bVar;
        this.a = i;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public int getCount() {
        return EnumMultiset.this.e[this.a];
    }

    @Override // com.google.common.collect.Multiset.Entry
    public Object getElement() {
        return EnumMultiset.this.d[this.a];
    }
}
