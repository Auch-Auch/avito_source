package a2.a.a.o0;

import android.content.DialogInterface;
import com.avito.android.dialog.DialogWithDeeplinkActions;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<DialogInterface, Unit> {
    public final /* synthetic */ DialogWithDeeplinkActions.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(DialogWithDeeplinkActions.a aVar) {
        super(1);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "it");
        this.a.a.a();
        return Unit.INSTANCE;
    }
}
