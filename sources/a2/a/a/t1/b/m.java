package a2.a.a.t1.b;

import android.view.View;
import com.avito.android.util.Keyboards;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class m extends Lambda implements Function1<View, Unit> {
    public static final m a = new m();

    public m() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        View view2 = view;
        if (view2 != null) {
            Keyboards.showKeyboardDelayed(view2, 2);
        }
        return Unit.INSTANCE;
    }
}
