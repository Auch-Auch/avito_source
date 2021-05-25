package defpackage;

import android.view.View;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: j0  reason: default package */
public final class j0 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public j0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            ((Consumer) this.b).accept(Unit.INSTANCE);
        } else if (i == 1) {
            ((Consumer) this.b).accept(Unit.INSTANCE);
        } else if (i == 2) {
            ((Consumer) this.b).accept(Unit.INSTANCE);
        } else {
            throw null;
        }
    }
}
