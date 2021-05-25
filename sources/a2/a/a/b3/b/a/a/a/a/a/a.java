package a2.a.a.b3.b.a.a.a.a.a;

import android.view.View;
import io.reactivex.functions.Consumer;
import java.util.Date;
public final class a implements View.OnClickListener {
    public final /* synthetic */ Consumer a;
    public final /* synthetic */ Date b;

    public a(Consumer consumer, Date date) {
        this.a = consumer;
        this.b = date;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.accept(this.b);
    }
}
