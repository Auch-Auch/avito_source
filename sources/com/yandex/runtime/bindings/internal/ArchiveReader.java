package com.yandex.runtime.bindings.internal;

import android.graphics.PointF;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.ArchivingHandler;
import com.yandex.runtime.bindings.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class ArchiveReader implements Archive {
    private final ByteBuffer data;

    public ArchiveReader(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
        byteBuffer.position(0);
        byteBuffer.order(ByteOrder.nativeOrder());
    }

    private static <T> T create(Class<T> cls) {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Cannot create an instance of class %s. %s", cls.getName(), e.getMessage()));
        }
    }

    private boolean readOptionalFlag() {
        return add(false);
    }

    @Override // com.yandex.runtime.bindings.Archive
    public boolean add(boolean z) {
        byte add = add((byte) 0);
        if (add == 1) {
            return true;
        }
        if (add == 0) {
            return false;
        }
        throw new RuntimeException(String.format("0x%02x is not valid boolean value", Byte.valueOf(add)));
    }

    @Override // com.yandex.runtime.bindings.Archive
    public boolean isReader() {
        return true;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public byte add(byte b) {
        return this.data.get();
    }

    @Override // com.yandex.runtime.bindings.Archive
    public int add(int i) {
        return this.data.getInt();
    }

    @Override // com.yandex.runtime.bindings.Archive
    public long add(long j) {
        return this.data.getLong();
    }

    @Override // com.yandex.runtime.bindings.Archive
    public float add(float f) {
        return this.data.getFloat();
    }

    @Override // com.yandex.runtime.bindings.Archive
    public double add(double d) {
        return this.data.getDouble();
    }

    @Override // com.yandex.runtime.bindings.Archive
    public Boolean add(Boolean bool, boolean z) {
        if (!z || readOptionalFlag()) {
            return Boolean.valueOf(add(false));
        }
        return null;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public Byte add(Byte b, boolean z) {
        if (!z || readOptionalFlag()) {
            return Byte.valueOf(add((byte) 0));
        }
        return null;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public Integer add(Integer num, boolean z) {
        if (!z || readOptionalFlag()) {
            return Integer.valueOf(add(0));
        }
        return null;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public Long add(Long l, boolean z) {
        if (!z || readOptionalFlag()) {
            return Long.valueOf(add(0L));
        }
        return null;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public Float add(Float f, boolean z) {
        if (!z || readOptionalFlag()) {
            return Float.valueOf(add(0.0f));
        }
        return null;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public Double add(Double d, boolean z) {
        if (!z || readOptionalFlag()) {
            return Double.valueOf(add(0.0d));
        }
        return null;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public ByteBuffer add(ByteBuffer byteBuffer) {
        return this.data;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public byte[] add(byte[] bArr, boolean z) {
        if (z && !readOptionalFlag()) {
            return null;
        }
        byte[] bArr2 = new byte[add(0)];
        this.data.get(bArr2);
        return bArr2;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public String add(String str, boolean z) {
        if (z && !readOptionalFlag()) {
            return null;
        }
        try {
            byte[] bArr = new byte[add(0)];
            this.data.get(bArr);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.yandex.runtime.bindings.Archive
    public <T extends Enum<T>> T add(T t, boolean z, Class<T> cls) {
        if (!z || readOptionalFlag()) {
            return cls.getEnumConstants()[add(0)];
        }
        return null;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public <T> List<T> add(List<T> list, boolean z, ArchivingHandler<T> archivingHandler) {
        if (z && !readOptionalFlag()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int add = add(0);
        for (int i = 0; i < add; i++) {
            arrayList.add(archivingHandler.add(null, this));
        }
        return arrayList;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public <Key, Value> Map<Key, Value> add(Map<Key, Value> map, boolean z, ArchivingHandler<Key> archivingHandler, ArchivingHandler<Value> archivingHandler2) {
        if (z && !readOptionalFlag()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        int add = add(0);
        for (int i = 0; i < add; i++) {
            hashMap.put(archivingHandler.add(null, this), archivingHandler2.add(null, this));
        }
        return hashMap;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public <T extends Serializable> T add(T t, boolean z, Class<T> cls) {
        if (z && !readOptionalFlag()) {
            return null;
        }
        T t2 = (T) ((Serializable) create(cls));
        t2.serialize(this);
        return t2;
    }

    @Override // com.yandex.runtime.bindings.Archive
    public <T> T add(T t, ArchivingHandler<T> archivingHandler) {
        return archivingHandler.add(t, this);
    }

    @Override // com.yandex.runtime.bindings.Archive
    public PointF add(PointF pointF, boolean z) {
        if (!z || readOptionalFlag()) {
            return new PointF(add(0.0f), add(0.0f));
        }
        return null;
    }
}
