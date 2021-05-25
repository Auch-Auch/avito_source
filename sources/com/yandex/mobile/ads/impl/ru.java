package com.yandex.mobile.ads.impl;

import android.os.Handler;
import java.util.concurrent.Executor;
public final class ru implements sb {
    private final Executor a;

    public class a implements Runnable {
        private final ry b;
        private final sa c;
        private final Runnable d;

        public a(ry ryVar, sa saVar, Runnable runnable) {
            this.b = ryVar;
            this.c = saVar;
            this.d = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.b.j()) {
                this.b.g();
                return;
            }
            sa saVar = this.c;
            sl slVar = saVar.c;
            if (slVar == null) {
                this.b.b((ry) saVar.a);
            } else {
                this.b.b(slVar);
            }
            if (!this.c.d) {
                this.b.g();
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public ru(final Handler handler) {
        this.a = new Executor() { // from class: com.yandex.mobile.ads.impl.ru.1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // com.yandex.mobile.ads.impl.sb
    public final void a(ry<?> ryVar, sa<?> saVar) {
        a(ryVar, saVar, null);
    }

    @Override // com.yandex.mobile.ads.impl.sb
    public final void a(ry<?> ryVar, sa<?> saVar, Runnable runnable) {
        ryVar.r();
        this.a.execute(new a(ryVar, saVar, runnable));
    }

    @Override // com.yandex.mobile.ads.impl.sb
    public final void a(ry<?> ryVar, sl slVar) {
        this.a.execute(new a(ryVar, sa.a(slVar), null));
    }
}
