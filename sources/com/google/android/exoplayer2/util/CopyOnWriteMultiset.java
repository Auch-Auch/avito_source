package com.google.android.exoplayer2.util;

import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
public final class CopyOnWriteMultiset<E> implements Iterable<E> {
    public final Object a = new Object();
    @GuardedBy("lock")
    public final Map<E, Integer> b = new HashMap();
    @GuardedBy("lock")
    public Set<E> c = Collections.emptySet();
    @GuardedBy("lock")
    public List<E> d = Collections.emptyList();

    public void add(E e) {
        synchronized (this.a) {
            ArrayList arrayList = new ArrayList(this.d);
            arrayList.add(e);
            this.d = Collections.unmodifiableList(arrayList);
            Integer num = this.b.get(e);
            if (num == null) {
                HashSet hashSet = new HashSet(this.c);
                hashSet.add(e);
                this.c = Collections.unmodifiableSet(hashSet);
            }
            Map<E, Integer> map = this.b;
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            map.put(e, Integer.valueOf(i));
        }
    }

    public Set<E> elementSet() {
        Set<E> set;
        synchronized (this.a) {
            set = this.c;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.a) {
            it = this.d.iterator();
        }
        return it;
    }

    public void remove(E e) {
        synchronized (this.a) {
            Integer num = this.b.get(e);
            if (num != null) {
                ArrayList arrayList = new ArrayList(this.d);
                arrayList.remove(e);
                this.d = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.b.remove(e);
                    HashSet hashSet = new HashSet(this.c);
                    hashSet.remove(e);
                    this.c = Collections.unmodifiableSet(hashSet);
                } else {
                    this.b.put(e, Integer.valueOf(num.intValue() - 1));
                }
            }
        }
    }
}
