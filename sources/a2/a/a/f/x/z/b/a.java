package a2.a.a.f.x.z.b;

import android.view.View;
import com.avito.android.component.contact_bar.ContactBar;
import kotlin.jvm.functions.Function1;
public final class a implements View.OnClickListener {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ ContactBar.Action b;

    public a(Function1 function1, ContactBar.Action action, String str) {
        this.a = function1;
        this.b = action;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.invoke(this.b);
    }
}
