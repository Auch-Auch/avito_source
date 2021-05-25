package a2.a.a.l0.a.c;

import android.view.MenuItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<MenuItem, Unit> {
    public static final b a = new b();

    public b() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        Intrinsics.checkNotNullParameter(menuItem2, "menuItem");
        menuItem2.setVisible(false);
        return Unit.INSTANCE;
    }
}
