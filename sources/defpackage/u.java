package defpackage;

import android.view.View;
import com.avito.android.design.widget.search_view.ToolbarSearchViewImpl;
/* compiled from: java-style lambda group */
/* renamed from: u  reason: default package */
public final class u implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public u(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            ((ToolbarSearchViewImpl) this.b).c.clearFocus();
        } else if (i == 1) {
            ToolbarSearchViewImpl.access$showSearch((ToolbarSearchViewImpl) this.b);
        } else {
            throw null;
        }
    }
}
