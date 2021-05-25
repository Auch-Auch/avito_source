package a2.j.i;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
public final class i<E> extends a<E> {
    public static final i<Object> c;
    public final List<E> b;

    static {
        i<Object> iVar = new i<>();
        c = iVar;
        iVar.makeImmutable();
    }

    public i() {
        this.b = new ArrayList(10);
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        ensureIsMutable();
        this.b.add(i, e);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        return this.b.get(i);
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public Internal.ProtobufList mutableCopyWithCapacity(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.b);
            return new i(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public E remove(int i) {
        ensureIsMutable();
        E remove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        return remove;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        ensureIsMutable();
        E e2 = this.b.set(i, e);
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.b.size();
    }

    public i(List<E> list) {
        this.b = list;
    }
}
