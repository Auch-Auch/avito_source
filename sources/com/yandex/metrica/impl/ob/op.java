package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.vf;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
public interface op<T> {

    public static class a {
        private final HashMap<Class<?>, op<?>> a;
        private final op<yb> b;
        private final op<vf.a> c;
        private final op<List<sr>> d;
        private final op<sk> e;
        private final op<wr> f;

        /* renamed from: com.yandex.metrica.impl.ob.op$a$a  reason: collision with other inner class name */
        public static final class C0339a {
            public static final a a = new a();
        }

        public static <T> op<T> a(Class<T> cls) {
            return C0339a.a.c(cls);
        }

        public static <T> op<Collection<T>> b(Class<T> cls) {
            return C0339a.a.d(cls);
        }

        public <T> op<T> c(Class<T> cls) {
            return (op<T>) this.a.get(cls);
        }

        public <T> op<Collection<T>> d(Class<T> cls) {
            return (op<Collection<T>>) this.a.get(cls);
        }

        private a() {
            HashMap<Class<?>, op<?>> hashMap = new HashMap<>();
            this.a = hashMap;
            AnonymousClass1 r1 = new op<yb>() { // from class: com.yandex.metrica.impl.ob.op.a.1
                @Override // com.yandex.metrica.impl.ob.op
                public mx<yb> a(@NonNull Context context) {
                    return new my("startup_state", lv.a(context).b(), new oo().a(), new od());
                }
            };
            this.b = r1;
            AnonymousClass2 r2 = new op<vf.a>() { // from class: com.yandex.metrica.impl.ob.op.a.2
                @Override // com.yandex.metrica.impl.ob.op
                public mx<vf.a> a(@NonNull Context context) {
                    return new my("provided_request_state", lv.a(context).b(), new oo().e(), new ny());
                }
            };
            this.c = r2;
            AnonymousClass3 r3 = new op<List<sr>>() { // from class: com.yandex.metrica.impl.ob.op.a.3
                @Override // com.yandex.metrica.impl.ob.op
                public mx<List<sr>> a(@NonNull Context context) {
                    return new my("permission_list", lv.a(context).b(), new oo().b(), new nw());
                }
            };
            this.d = r3;
            AnonymousClass4 r4 = new op<sk>() { // from class: com.yandex.metrica.impl.ob.op.a.4
                @Override // com.yandex.metrica.impl.ob.op
                public mx<sk> a(@NonNull Context context) {
                    return new my("app_permissions_state", lv.a(context).b(), new oo().c(), new ne());
                }
            };
            this.e = r4;
            AnonymousClass5 r5 = new op<wr>() { // from class: com.yandex.metrica.impl.ob.op.a.5
                @Override // com.yandex.metrica.impl.ob.op
                public mx<wr> a(@NonNull Context context) {
                    return new my("sdk_fingerprinting", lv.a(context).b(), new oo().d(), new ob());
                }
            };
            this.f = r5;
            hashMap.put(yb.class, r1);
            hashMap.put(vf.a.class, r2);
            hashMap.put(sr.class, r3);
            hashMap.put(sk.class, r4);
            hashMap.put(wr.class, r5);
        }
    }

    mx<T> a(@NonNull Context context);
}
