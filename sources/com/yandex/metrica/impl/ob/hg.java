package com.yandex.metrica.impl.ob;

import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.al;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
public class hg extends hi<hu> {
    private final ix a;
    private final Map<al.a, iq<hu>> b = b();
    @Nullable
    private in<hu> c;
    @Nullable
    private in<hu> d;

    public hg(fe feVar) {
        ix ixVar = new ix(feVar);
        this.a = ixVar;
        this.c = new im(ixVar);
    }

    private HashMap<al.a, iq<hu>> b() {
        HashMap<al.a, iq<hu>> hashMap = new HashMap<>();
        hashMap.put(al.a.EVENT_TYPE_ACTIVATION, new il(this.a));
        hashMap.put(al.a.EVENT_TYPE_START, new ja(this.a));
        hashMap.put(al.a.EVENT_TYPE_REGULAR, new iu(this.a));
        is isVar = new is(this.a);
        hashMap.put(al.a.EVENT_TYPE_EXCEPTION_USER, isVar);
        hashMap.put(al.a.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, isVar);
        hashMap.put(al.a.EVENT_TYPE_SEND_REFERRER, isVar);
        hashMap.put(al.a.EVENT_TYPE_STATBOX, isVar);
        hashMap.put(al.a.EVENT_TYPE_CUSTOM_EVENT, isVar);
        hashMap.put(al.a.EVENT_TYPE_APP_OPEN, new iw(this.a));
        hashMap.put(al.a.EVENT_TYPE_PURGE_BUFFER, new it(this.a));
        al.a aVar = al.a.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH;
        ix ixVar = this.a;
        hashMap.put(aVar, new iz(ixVar, ixVar.l()));
        hashMap.put(al.a.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH, new ip(this.a));
        hashMap.put(al.a.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new jc(this.a));
        jb jbVar = new jb(this.a);
        hashMap.put(al.a.EVENT_TYPE_EXCEPTION_UNHANDLED, jbVar);
        hashMap.put(al.a.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, jbVar);
        hashMap.put(al.a.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT, jbVar);
        hashMap.put(al.a.EVENT_TYPE_ANR, isVar);
        hashMap.put(al.a.EVENT_TYPE_IDENTITY, new ir(this.a));
        hashMap.put(al.a.EVENT_TYPE_SET_USER_INFO, new iy(this.a));
        al.a aVar2 = al.a.EVENT_TYPE_REPORT_USER_INFO;
        ix ixVar2 = this.a;
        hashMap.put(aVar2, new iz(ixVar2, ixVar2.g()));
        al.a aVar3 = al.a.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        ix ixVar3 = this.a;
        hashMap.put(aVar3, new iz(ixVar3, ixVar3.i()));
        al.a aVar4 = al.a.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        ix ixVar4 = this.a;
        hashMap.put(aVar4, new iz(ixVar4, ixVar4.j()));
        hashMap.put(al.a.EVENT_TYPE_SEND_USER_PROFILE, isVar);
        al.a aVar5 = al.a.EVENT_TYPE_SET_USER_PROFILE_ID;
        ix ixVar5 = this.a;
        hashMap.put(aVar5, new iz(ixVar5, ixVar5.o()));
        hashMap.put(al.a.EVENT_TYPE_SEND_REVENUE_EVENT, isVar);
        hashMap.put(al.a.EVENT_TYPE_IDENTITY_LIGHT, isVar);
        hashMap.put(al.a.EVENT_TYPE_CLEANUP, isVar);
        hashMap.put(al.a.EVENT_TYPE_VIEW_TREE, isVar);
        return hashMap;
    }

    public void a(al.a aVar, iq<hu> iqVar) {
        this.b.put(aVar, iqVar);
    }

    public ix a() {
        return this.a;
    }

    @Override // com.yandex.metrica.impl.ob.hi
    public hf<hu> a(int i) {
        LinkedList linkedList = new LinkedList();
        al.a a3 = al.a.a(i);
        in<hu> inVar = this.c;
        if (inVar != null) {
            inVar.a(a3, linkedList);
        }
        iq<hu> iqVar = this.b.get(a3);
        if (iqVar != null) {
            iqVar.a(linkedList);
        }
        in<hu> inVar2 = this.d;
        if (inVar2 != null) {
            inVar2.a(a3, linkedList);
        }
        return new he(linkedList);
    }
}
