package a2.j.d.c;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
public class w extends ImmutableList<E> {
    public final /* synthetic */ int c;
    public final /* synthetic */ x d;

    public w(x xVar, int i) {
        this.d = xVar;
        this.c = i;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return true;
    }

    @Override // java.util.List
    public E get(int i) {
        Preconditions.checkElementIndex(i, size());
        x xVar = this.d;
        return this.d.a.get(i).get((this.c / xVar.b[i + 1]) % xVar.a.get(i).size());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.d.a.size();
    }
}
