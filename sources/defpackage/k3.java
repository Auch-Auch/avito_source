package defpackage;

import android.view.View;
import com.avito.android.component.contact_bar.ContactBar;
import kotlin.jvm.functions.Function1;
/* compiled from: java-style lambda group */
/* renamed from: k3  reason: default package */
public final class k3 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public k3(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            ((Function1) this.b).invoke((ContactBar.Action) this.c);
        } else if (i == 1) {
            ((Function1) this.b).invoke((ContactBar.Action) this.c);
        } else {
            throw null;
        }
    }
}
