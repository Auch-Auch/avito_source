package com.yandex.runtime.bindings.internal;

import com.yandex.runtime.NativeObject;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.RandomAccess;
public class Vector<E> extends AbstractList<E> implements RandomAccess {
    private ArrayList<E> list;
    private int listSize = sizeNative();
    private NativeObject nativeObject;

    public Vector(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // java.util.AbstractList, java.util.List
    public synchronized E get(int i) {
        E e;
        if (this.list == null) {
            this.list = new ArrayList<>(this.listSize);
            for (int i2 = 0; i2 != this.listSize; i2++) {
                this.list.add(null);
            }
        }
        e = this.list.get(i);
        if (e == null) {
            e = getNative(i);
            this.list.set(i, e);
        }
        return e;
    }

    public native E getNative(int i);

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.listSize;
    }

    public native int sizeNative();
}
