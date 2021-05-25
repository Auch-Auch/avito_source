package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
public class LazyStringArrayList extends a2.j.i.a<String> implements LazyStringList, RandomAccess {
    public static final LazyStringList EMPTY;
    public static final LazyStringArrayList c;
    public final List<Object> b;

    public static class a extends AbstractList<byte[]> implements RandomAccess {
        public final LazyStringArrayList a;

        public a(LazyStringArrayList lazyStringArrayList) {
            this.a = lazyStringArrayList;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, Object obj) {
            LazyStringArrayList.a(this.a, i, (byte[]) obj);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            return this.a.getByteArray(i);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object remove(int i) {
            String remove = this.a.remove(i);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.c(remove);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i, Object obj) {
            LazyStringArrayList lazyStringArrayList = this.a;
            LazyStringArrayList lazyStringArrayList2 = LazyStringArrayList.c;
            lazyStringArrayList.ensureIsMutable();
            Object obj2 = lazyStringArrayList.b.set(i, (byte[]) obj);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.c(obj2);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.a.size();
        }
    }

    public static class b extends AbstractList<ByteString> implements RandomAccess {
        public final LazyStringArrayList a;

        public b(LazyStringArrayList lazyStringArrayList) {
            this.a = lazyStringArrayList;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, Object obj) {
            LazyStringArrayList.b(this.a, i, (ByteString) obj);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            return this.a.getByteString(i);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object remove(int i) {
            String remove = this.a.remove(i);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.d(remove);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i, Object obj) {
            LazyStringArrayList lazyStringArrayList = this.a;
            LazyStringArrayList lazyStringArrayList2 = LazyStringArrayList.c;
            lazyStringArrayList.ensureIsMutable();
            Object obj2 = lazyStringArrayList.b.set(i, (ByteString) obj);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.d(obj2);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.a.size();
        }
    }

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
        c = lazyStringArrayList;
        lazyStringArrayList.makeImmutable();
        EMPTY = lazyStringArrayList;
    }

    public LazyStringArrayList() {
        this(10);
    }

    public static void a(LazyStringArrayList lazyStringArrayList, int i, byte[] bArr) {
        lazyStringArrayList.ensureIsMutable();
        lazyStringArrayList.b.add(i, bArr);
        ((AbstractList) lazyStringArrayList).modCount++;
    }

    public static void b(LazyStringArrayList lazyStringArrayList, int i, ByteString byteString) {
        lazyStringArrayList.ensureIsMutable();
        lazyStringArrayList.b.add(i, byteString);
        ((AbstractList) lazyStringArrayList).modCount++;
    }

    public static byte[] c(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return Internal.toByteArray((String) obj);
        }
        return ((ByteString) obj).toByteArray();
    }

    public static ByteString d(Object obj) {
        if (obj instanceof ByteString) {
            return (ByteString) obj;
        }
        if (obj instanceof String) {
            return ByteString.copyFromUtf8((String) obj);
        }
        return ByteString.copyFrom((byte[]) obj);
    }

    public static String e(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).toStringUtf8();
        }
        return Internal.toStringUtf8((byte[]) obj);
    }

    @Override // a2.j.i.a, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> collection) {
        ensureIsMutable();
        boolean addAll = this.b.addAll(collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        ensureIsMutable();
        boolean addAll = this.b.addAll(collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return new a(this);
    }

    @Override // com.google.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return new b(this);
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public void clear() {
        ensureIsMutable();
        this.b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: byte[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.LazyStringList
    public byte[] getByteArray(int i) {
        Object obj = this.b.get(i);
        byte[] c2 = c(obj);
        if (c2 != obj) {
            this.b.set(i, c2);
        }
        return c2;
    }

    @Override // com.google.protobuf.LazyStringList
    public ByteString getByteString(int i) {
        Object obj = this.b.get(i);
        ByteString d = d(obj);
        if (d != obj) {
            this.b.set(i, d);
        }
        return d;
    }

    @Override // com.google.protobuf.LazyStringList
    public Object getRaw(int i) {
        return this.b.get(i);
    }

    @Override // com.google.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.b);
    }

    @Override // com.google.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return isModifiable() ? new UnmodifiableLazyStringList(this) : this;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // a2.j.i.a, com.google.protobuf.Internal.ProtobufList
    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    @Override // com.google.protobuf.LazyStringList
    public void mergeFrom(LazyStringList lazyStringList) {
        ensureIsMutable();
        for (Object obj : lazyStringList.getUnderlyingElements()) {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                this.b.add(Arrays.copyOf(bArr, bArr.length));
            } else {
                this.b.add(obj);
            }
        }
    }

    @Override // a2.j.i.a, java.util.AbstractCollection, java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // a2.j.i.a, java.util.AbstractCollection, java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.b.size();
    }

    public LazyStringArrayList(int i) {
        this.b = new ArrayList(i);
    }

    public void add(int i, String str) {
        ensureIsMutable();
        this.b.add(i, str);
        ((AbstractList) this).modCount++;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends String> collection) {
        ensureIsMutable();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean addAll = this.b.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        Object obj = this.b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.b.set(i, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String stringUtf82 = Internal.toStringUtf8(bArr);
        if (Internal.isValidUtf8(bArr)) {
            this.b.set(i, stringUtf82);
        }
        return stringUtf82;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public LazyStringArrayList mutableCopyWithCapacity(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.b);
            return new LazyStringArrayList((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // a2.j.i.a, java.util.AbstractCollection, java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public String set(int i, String str) {
        ensureIsMutable();
        return e(this.b.set(i, str));
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public String remove(int i) {
        ensureIsMutable();
        Object remove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        return e(remove);
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.b = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(ByteString byteString) {
        ensureIsMutable();
        this.b.add(byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int i, ByteString byteString) {
        ensureIsMutable();
        this.b.set(i, byteString);
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int i, byte[] bArr) {
        ensureIsMutable();
        this.b.set(i, bArr);
    }

    public LazyStringArrayList(List<String> list) {
        this.b = new ArrayList(list);
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(byte[] bArr) {
        ensureIsMutable();
        this.b.add(bArr);
        ((AbstractList) this).modCount++;
    }

    public LazyStringArrayList(ArrayList<Object> arrayList) {
        this.b = arrayList;
    }
}
