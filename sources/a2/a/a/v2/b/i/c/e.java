package a2.a.a.v2.b.i.c;

import android.view.View;
import com.avito.android.util.Keyboards;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ View b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Function0 function0, View view) {
        super(0);
        this.a = function0;
        this.b = view;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.invoke();
        View view = this.b;
        if (view == null) {
            return null;
        }
        Keyboards.hideKeyboardWithAttempt$default(view, 0, 0, 3, null);
        return Unit.INSTANCE;
    }
}
