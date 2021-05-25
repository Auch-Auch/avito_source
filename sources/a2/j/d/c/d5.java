package a2.j.d.c;

import com.google.common.collect.Multisets;
import com.google.common.collect.TreeMultiset;
public class d5 extends Multisets.e<E> {
    public final /* synthetic */ TreeMultiset.d a;
    public final /* synthetic */ TreeMultiset b;

    public d5(TreeMultiset treeMultiset, TreeMultiset.d dVar) {
        this.b = treeMultiset;
        this.a = dVar;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public int getCount() {
        TreeMultiset.d dVar = this.a;
        int i = dVar.b;
        return i == 0 ? this.b.count(dVar.a) : i;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public E getElement() {
        return this.a.a;
    }
}
