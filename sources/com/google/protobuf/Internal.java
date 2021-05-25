package com.google.protobuf;

import a2.j.i.n;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
public final class Internal {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM;
    public static final Charset a = Charset.forName("UTF-8");
    public static final Charset b = Charset.forName("ISO-8859-1");

    public interface BooleanList extends ProtobufList<Boolean> {
        void addBoolean(boolean z);

        boolean getBoolean(int i);

        BooleanList mutableCopyWithCapacity(int i);

        boolean setBoolean(int i, boolean z);
    }

    public interface DoubleList extends ProtobufList<Double> {
        void addDouble(double d);

        double getDouble(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        DoubleList mutableCopyWithCapacity(int i);

        double setDouble(int i, double d);
    }

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i);
    }

    public interface FloatList extends ProtobufList<Float> {
        void addFloat(float f);

        float getFloat(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        FloatList mutableCopyWithCapacity(int i);

        float setFloat(int i, float f);
    }

    public interface IntList extends ProtobufList<Integer> {
        void addInt(int i);

        int getInt(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        IntList mutableCopyWithCapacity(int i);

        int setInt(int i, int i2);
    }

    public static class ListAdapter<F, T> extends AbstractList<T> {
        public final List<F> a;
        public final Converter<F, T> b;

        public interface Converter<F, T> {
            T convert(F f);
        }

        public ListAdapter(List<F> list, Converter<F, T> converter) {
            this.a = list;
            this.b = converter;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return this.b.convert(this.a.get(i));
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.a.size();
        }
    }

    public interface LongList extends ProtobufList<Long> {
        void addLong(long j);

        long getLong(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        LongList mutableCopyWithCapacity(int i);

        long setLong(int i, long j);
    }

    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {
        public final Map<K, RealValue> a;
        public final Converter<RealValue, V> b;

        public interface Converter<A, B> {
            A doBackward(B b);

            B doForward(A a);
        }

        public static class a implements Converter<Integer, T> {
            public final /* synthetic */ EnumLiteMap a;
            public final /* synthetic */ EnumLite b;

            public a(EnumLiteMap enumLiteMap, EnumLite enumLite) {
                this.a = enumLiteMap;
                this.b = enumLite;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.google.protobuf.Internal.MapAdapter.Converter
            public Integer doBackward(Object obj) {
                return Integer.valueOf(((EnumLite) obj).getNumber());
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.protobuf.Internal.MapAdapter.Converter
            public Object doForward(Integer num) {
                EnumLite findValueByNumber = this.a.findValueByNumber(num.intValue());
                return findValueByNumber == null ? this.b : findValueByNumber;
            }
        }

        public class b implements Map.Entry<K, V> {
            public final Map.Entry<K, RealValue> a;

            public b(Map.Entry<K, RealValue> entry) {
                this.a = entry;
            }

            @Override // java.util.Map.Entry
            public K getKey() {
                return this.a.getKey();
            }

            @Override // java.util.Map.Entry
            public V getValue() {
                return MapAdapter.this.b.doForward(this.a.getValue());
            }

            @Override // java.util.Map.Entry
            public V setValue(V v) {
                RealValue value = this.a.setValue(MapAdapter.this.b.doBackward(v));
                if (value == null) {
                    return null;
                }
                return MapAdapter.this.b.doForward(value);
            }
        }

        public class c implements Iterator<Map.Entry<K, V>> {
            public final Iterator<Map.Entry<K, RealValue>> a;

            public c(Iterator<Map.Entry<K, RealValue>> it) {
                this.a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                return new b(this.a.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.a.remove();
            }
        }

        public class d extends AbstractSet<Map.Entry<K, V>> {
            public final Set<Map.Entry<K, RealValue>> a;

            public d(Set<Map.Entry<K, RealValue>> set) {
                this.a = set;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<K, V>> iterator() {
                return new c(this.a.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.a.size();
            }
        }

        public MapAdapter(Map<K, RealValue> map, Converter<RealValue, V> converter) {
            this.a = map;
            this.b = converter;
        }

        public static <T extends EnumLite> Converter<Integer, T> newEnumConverter(EnumLiteMap<T> enumLiteMap, T t) {
            return new a(enumLiteMap, t);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new d(this.a.entrySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            RealValue realvalue = this.a.get(obj);
            if (realvalue == null) {
                return null;
            }
            return this.b.doForward(realvalue);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            RealValue put = this.a.put(k, this.b.doBackward(v));
            if (put == null) {
                return null;
            }
            return this.b.doForward(put);
        }
    }

    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        @Override // com.google.protobuf.Internal.BooleanList
        ProtobufList<E> mutableCopyWithCapacity(int i);
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(bArr);
    }

    public static int a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static byte[] byteArrayDefaultValue(String str) {
        return str.getBytes(b);
    }

    public static ByteBuffer byteBufferDefaultValue(String str) {
        return ByteBuffer.wrap(byteArrayDefaultValue(str));
    }

    public static ByteString bytesDefaultValue(String str) {
        return ByteString.copyFrom(str.getBytes(b));
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        ByteBuffer allocate = ByteBuffer.allocate(duplicate.capacity());
        allocate.put(duplicate);
        allocate.clear();
        return allocate;
    }

    public static boolean equals(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer.capacity() != byteBuffer2.capacity()) {
            return false;
        }
        return byteBuffer.duplicate().clear().equals(byteBuffer2.duplicate().clear());
    }

    public static <T extends MessageLite> T getDefaultInstance(Class<T> cls) {
        try {
            Method method = cls.getMethod("getDefaultInstance", new Class[0]);
            return (T) ((MessageLite) method.invoke(method, new Object[0]));
        } catch (Exception e) {
            throw new RuntimeException("Failed to get default instance for " + cls, e);
        }
    }

    public static int hashBoolean(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int hashCode(List<byte[]> list) {
        int i = 1;
        for (byte[] bArr : list) {
            i = (i * 31) + hashCode(bArr);
        }
        return i;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> list) {
        int i = 1;
        for (ByteBuffer byteBuffer : list) {
            i = (i * 31) + hashCodeByteBuffer(byteBuffer);
        }
        return i;
    }

    public static int hashEnum(EnumLite enumLite) {
        return enumLite.getNumber();
    }

    public static int hashEnumList(List<? extends EnumLite> list) {
        int i = 1;
        for (EnumLite enumLite : list) {
            i = (i * 31) + hashEnum(enumLite);
        }
        return i;
    }

    public static int hashLong(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static boolean isValidUtf8(byte[] bArr) {
        if (n.a.e(0, bArr, 0, bArr.length) == 0) {
            return true;
        }
        return false;
    }

    public static String stringDefaultValue(String str) {
        return new String(str.getBytes(b), a);
    }

    public static byte[] toByteArray(String str) {
        return str.getBytes(a);
    }

    public static String toStringUtf8(byte[] bArr) {
        return new String(bArr, a);
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> list, List<ByteBuffer> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!equalsByteBuffer(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int a3 = a(length, bArr, 0, length);
        if (a3 == 0) {
            return 1;
        }
        return a3;
    }

    public static int hashCodeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int a3 = a(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            if (a3 == 0) {
                return 1;
            }
            return a3;
        }
        int i = 4096;
        if (byteBuffer.capacity() <= 4096) {
            i = byteBuffer.capacity();
        }
        byte[] bArr = new byte[i];
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        int capacity = byteBuffer.capacity();
        while (duplicate.remaining() > 0) {
            int remaining = duplicate.remaining() <= i ? duplicate.remaining() : i;
            duplicate.get(bArr, 0, remaining);
            capacity = a(capacity, bArr, 0, remaining);
        }
        if (capacity == 0) {
            return 1;
        }
        return capacity;
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.isValidUtf8();
    }
}
