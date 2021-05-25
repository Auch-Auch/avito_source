package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.al;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
public class ou implements ov, ow {
    private final Set<Integer> a;
    private AtomicLong b;

    public ou(@NonNull lr lrVar) {
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        hashSet.add(Integer.valueOf(al.a.EVENT_TYPE_FIRST_ACTIVATION.a()));
        hashSet.add(Integer.valueOf(al.a.EVENT_TYPE_APP_UPDATE.a()));
        hashSet.add(Integer.valueOf(al.a.EVENT_TYPE_INIT.a()));
        hashSet.add(Integer.valueOf(al.a.EVENT_TYPE_IDENTITY.a()));
        hashSet.add(Integer.valueOf(al.a.EVENT_TYPE_SEND_REFERRER.a()));
        lrVar.a(this);
        this.b = new AtomicLong(lrVar.a(hashSet));
    }

    @Override // com.yandex.metrica.impl.ob.ov
    public boolean a() {
        return this.b.get() > 0;
    }

    @Override // com.yandex.metrica.impl.ob.ow
    public void b(@NonNull List<Integer> list) {
        int i = 0;
        for (Integer num : list) {
            if (this.a.contains(Integer.valueOf(num.intValue()))) {
                i++;
            }
        }
        this.b.addAndGet((long) (-i));
    }

    @Override // com.yandex.metrica.impl.ob.ow
    public void a(@NonNull List<Integer> list) {
        int i = 0;
        for (Integer num : list) {
            if (this.a.contains(Integer.valueOf(num.intValue()))) {
                i++;
            }
        }
        this.b.addAndGet((long) i);
    }
}
