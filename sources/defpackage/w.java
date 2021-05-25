package defpackage;

import android.view.animation.Animation;
import android.widget.ImageView;
import io.reactivex.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: w  reason: default package */
public final class w<T> implements Consumer<Long> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public w(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Long l) {
        int i = this.a;
        if (i == 0) {
            ((ImageView) this.b).startAnimation((Animation) this.c);
        } else if (i == 1) {
            ((ImageView) this.b).startAnimation((Animation) this.c);
        } else {
            throw null;
        }
    }
}
