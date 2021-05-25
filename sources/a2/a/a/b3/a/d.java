package a2.a.a.b3.a;

import android.view.View;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class d implements View.OnClickListener {
    public final /* synthetic */ Consumer a;

    public d(Consumer consumer) {
        this.a = consumer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.accept(Unit.INSTANCE);
    }
}
