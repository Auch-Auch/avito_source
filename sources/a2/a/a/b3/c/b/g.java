package a2.a.a.b3.c.b;

import android.view.View;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class g implements View.OnClickListener {
    public final /* synthetic */ Consumer a;

    public g(Consumer consumer) {
        this.a = consumer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.accept(Unit.INSTANCE);
    }
}
