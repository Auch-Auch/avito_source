package a2.j.d.c;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.List;
public final class n3 extends ImmutableList<List<E>> {
    public final /* synthetic */ ImmutableList c;

    public n3(ImmutableList immutableList) {
        this.c = immutableList;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return true;
    }

    @Override // java.util.List
    public Object get(int i) {
        return ((ImmutableSet) this.c.get(i)).asList();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c.size();
    }
}
