package a2.a.a.v2.b.i.c;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ View a;
    public final /* synthetic */ Function0 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view, Function0 function0) {
        super(0);
        this.a = view;
        this.b = function0;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.b.invoke();
        return Unit.INSTANCE;
    }
}
