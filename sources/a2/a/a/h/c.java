package a2.a.a.h;

import android.view.View;
import com.avito.android.remote.model.Action;
public final class c implements View.OnClickListener {
    public final /* synthetic */ h a;
    public final /* synthetic */ Action b;

    public c(h hVar, Action action) {
        this.a = hVar;
        this.b = action;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.a.getViewModel().onButtonClicked(this.b.getDeepLink());
    }
}
