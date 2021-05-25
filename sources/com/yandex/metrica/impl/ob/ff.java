package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ew;
import com.yandex.metrica.impl.ob.fd;
import com.yandex.metrica.impl.ob.fw;
import com.yandex.metrica.impl.ob.ju;
import com.yandex.metrica.impl.ob.we;
import java.util.List;
public class ff {
    @NonNull
    public final Context a;
    @NonNull
    private final a b;
    @NonNull
    private final b c;
    @NonNull
    private final fb d;
    @NonNull
    private final ew.a e;
    @NonNull
    private final ye f;
    @NonNull
    private final yb g;
    @NonNull
    private final we.d h;
    @NonNull
    private final ack i;
    @NonNull
    private final act j;
    private final int k;

    public static class a {
        @Nullable
        private final String a;

        public a(@Nullable String str) {
            this.a = str;
        }

        public abl a() {
            return abd.a(this.a);
        }

        public abb b() {
            return abd.b(this.a);
        }
    }

    public static class b {
        @NonNull
        private final fb a;
        @NonNull
        private final lv b;

        public b(@NonNull Context context, @NonNull fb fbVar) {
            this(fbVar, lv.a(context));
        }

        @NonNull
        public mm a() {
            return new mm(this.b.b(this.a));
        }

        @NonNull
        public mo b() {
            return new mo(this.b.b(this.a));
        }

        @NonNull
        public mq c() {
            return new mq(this.b.c());
        }

        @VisibleForTesting
        public b(@NonNull fb fbVar, @NonNull lv lvVar) {
            this.a = fbVar;
            this.b = lvVar;
        }
    }

    public ff(@NonNull Context context, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull ye yeVar, @NonNull yb ybVar, @NonNull we.d dVar, @NonNull act act, int i2) {
        this(context, fbVar, aVar, yeVar, ybVar, dVar, act, new ack(), i2, new a(aVar.d), new b(context, fbVar));
    }

    @NonNull
    public a a() {
        return this.b;
    }

    @NonNull
    public b b() {
        return this.c;
    }

    @NonNull
    public jf c() {
        return new jf(this.a, this.d, this.k);
    }

    @NonNull
    public hg d(@NonNull fe feVar) {
        return new hg(feVar);
    }

    @NonNull
    public fd.a e(@NonNull fe feVar) {
        return new fd.a(feVar);
    }

    @VisibleForTesting
    public ff(@NonNull Context context, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull ye yeVar, @NonNull yb ybVar, @NonNull we.d dVar, @NonNull act act, @NonNull ack ack, int i2, @NonNull a aVar2, @NonNull b bVar) {
        this.a = context;
        this.d = fbVar;
        this.e = aVar;
        this.f = yeVar;
        this.g = ybVar;
        this.h = dVar;
        this.j = act;
        this.i = ack;
        this.k = i2;
        this.b = aVar2;
        this.c = bVar;
    }

    @NonNull
    public lr a(@NonNull fe feVar) {
        return new lr(feVar, lv.a(this.a).a(this.d));
    }

    @NonNull
    public cr<fe> b(@NonNull fe feVar) {
        return new cr<>(feVar, this.f.a(), this.j);
    }

    @NonNull
    public fv c(@NonNull fe feVar) {
        return new fv(new we.c(feVar, this.h), this.g, new we.a(this.e));
    }

    @NonNull
    public ju a(@NonNull fe feVar, @NonNull mo moVar, @NonNull ju.a aVar) {
        return new ju(feVar, new jt(moVar), aVar);
    }

    @NonNull
    public fw a(@NonNull mo moVar, @NonNull ju juVar, @NonNull lr lrVar, @NonNull i iVar, @NonNull final cr crVar) {
        return new fw(moVar, juVar, lrVar, iVar, this.i, this.k, new fw.a() { // from class: com.yandex.metrica.impl.ob.ff.1
            @Override // com.yandex.metrica.impl.ob.fw.a
            public void a() {
                crVar.b();
            }
        });
    }

    @NonNull
    public hj<hu, fe> a(@NonNull fe feVar, @NonNull hg hgVar) {
        return new hj<>(hgVar, feVar);
    }

    @NonNull
    public ou a(@NonNull lr lrVar) {
        return new ou(lrVar);
    }

    @NonNull
    public oz a(@NonNull lr lrVar, @NonNull fv fvVar) {
        return new oz(lrVar, fvVar);
    }

    @NonNull
    public ox a(@NonNull List<ov> list, @NonNull oy oyVar) {
        return new ox(list, oyVar);
    }

    @NonNull
    public s a(@NonNull mo moVar) {
        return new s(this.a, moVar);
    }
}
