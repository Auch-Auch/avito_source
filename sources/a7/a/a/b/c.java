package a7.a.a.b;

import android.view.View;
import com.avito.android.ui_components.R;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
public final class c<T> implements Consumer<Integer> {
    public final /* synthetic */ View a;
    public final /* synthetic */ Function1 b;

    public c(View view, Function1 function1) {
        this.a = view;
        this.b = function1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Integer num) {
        this.b.invoke(Integer.valueOf((num.intValue() - this.a.getResources().getDimensionPixelSize(R.dimen.vas_item_fixed_width)) / 2));
    }
}
