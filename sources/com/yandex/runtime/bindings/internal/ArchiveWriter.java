package com.yandex.runtime.bindings.internal;

import android.graphics.PointF;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.ArchivingHandler;
import com.yandex.runtime.bindings.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Map;
public final class ArchiveWriter implements Archive {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DEFAULT_SIZE = 16384;
    private ByteBuffer data = allocate(16384);

    private static ByteBuffer allocate(int i) {
        return ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
    }

    private void ensureSize(int i) {
        int position = this.data.position();
        int capacity = this.data.capacity();
        int i2 = i + position;
        if (i2 > capacity) {
            ByteBuffer allocate = allocate(Math.max((int) (((double) capacity) * 1.6d), i2));
            this.data.position(0);
            allocate.put(this.data);
            allocate.position(position);
            this.data = allocate;
        }
    }

    private <T> boolean writeOptionalFlag(boolean z, T t) {
        boolean z2 = true;
        if (!z) {
            return true;
        }
        if (t == null) {
            z2 = false;
        }
        return add(z2);
    }

    @Override // com.yandex.runtime.bindings.Archive
    public boolean add(boolean z) {
        add(z ? (byte) 1 : 0);
        return z;
    }

    public ByteBuffer data() {
        return this.data;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public boolean isReader() {
        return false;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public byte add(byte b) {
        ensureSize(1);
        this.data.put(b);
        return b;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public int add(int i) {
        ensureSize(4);
        this.data.putInt(i);
        return i;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public long add(long j) {
        ensureSize(8);
        this.data.putLong(j);
        return j;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public float add(float f) {
        ensureSize(4);
        this.data.putFloat(f);
        return f;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public double add(double d) {
        ensureSize(8);
        this.data.putDouble(d);
        return d;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public Boolean add(Boolean bool, boolean z) {
        if (!writeOptionalFlag(z, bool)) {
            return null;
        }
        return Boolean.valueOf(add(bool.booleanValue()));
    }

    @Override // com.yandex.runtime.bindings.Archive
    public Byte add(Byte b, boolean z) {
        if (!writeOptionalFlag(z, b)) {
            return null;
        }
        return Byte.valueOf(add(b.byteValue()));
    }

    @Override // com.yandex.runtime.bindings.Archive
    public Integer add(Integer num, boolean z) {
        if (!writeOptionalFlag(z, num)) {
            return null;
        }
        return Integer.valueOf(add(num.intValue()));
    }

    @Override // com.yandex.runtime.bindings.Archive
    public Long add(Long l, boolean z) {
        if (!writeOptionalFlag(z, l)) {
            return null;
        }
        return Long.valueOf(add(l.longValue()));
    }

    @Override // com.yandex.runtime.bindings.Archive
    public Float add(Float f, boolean z) {
        if (!writeOptionalFlag(z, f)) {
            return null;
        }
        return Float.valueOf(add(f.floatValue()));
    }

    @Override // com.yandex.runtime.bindings.Archive
    public Double add(Double d, boolean z) {
        if (!writeOptionalFlag(z, d)) {
            return null;
        }
        return Double.valueOf(add(d.doubleValue()));
    }

    @Override // com.yandex.runtime.bindings.Archive
    public ByteBuffer add(ByteBuffer byteBuffer) {
        ensureSize(byteBuffer.capacity());
        this.data.put(byteBuffer);
        return this.data;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public byte[] add(byte[] bArr, boolean z) {
        if (!writeOptionalFlag(z, bArr)) {
            return null;
        }
        add(bArr.length);
        ensureSize(bArr.length);
        this.data.put(bArr);
        return bArr;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public String add(String str, boolean z) {
        if (!writeOptionalFlag(z, str)) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            add(bytes.length);
            ensureSize(bytes.length);
            this.data.put(bytes);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.yandex.runtime.bindings.Archive
    public <T extends Enum<T>> T add(T t, boolean z, Class<T> cls) {
        if (!writeOptionalFlag(z, t)) {
            return null;
        }
        add(t.ordinal());
        return t;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public <T> List<T> add(List<T> list, boolean z, ArchivingHandler<T> archivingHandler) {
        if (!writeOptionalFlag(z, list)) {
            return null;
        }
        add(list.size());
        for (T t : list) {
            archivingHandler.add(t, this);
        }
        return list;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public <Key, Value> Map<Key, Value> add(Map<Key, Value> map, boolean z, ArchivingHandler<Key> archivingHandler, ArchivingHandler<Value> archivingHandler2) {
        if (!writeOptionalFlag(z, map)) {
            return null;
        }
        add(map.size());
        for (Map.Entry<Key, Value> entry : map.entrySet()) {
            archivingHandler.add(entry.getKey(), this);
            archivingHandler2.add(entry.getValue(), this);
        }
        return map;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public <T extends Serializable> T add(T t, boolean z, Class<T> cls) {
        if (!writeOptionalFlag(z, t)) {
            return null;
        }
        t.serialize(this);
        return t;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public <T> T add(T t, ArchivingHandler<T> archivingHandler) {
        return archivingHandler.add(t, this);
    }

    @Override // com.yandex.runtime.bindings.Archive
    public PointF add(PointF pointF, boolean z) {
        if (!writeOptionalFlag(z, pointF)) {
            return null;
        }
        add(pointF.x);
        add(pointF.y);
        return pointF;
    }
}
