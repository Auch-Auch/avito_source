package a2.a.a.c2.f;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class i extends Lambda implements Function0<Unit> {
    public final /* synthetic */ DialogInterface a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(DialogInterface dialogInterface) {
        super(0);
        this.a = dialogInterface;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.dismiss();
        return Unit.INSTANCE;
    }
}
