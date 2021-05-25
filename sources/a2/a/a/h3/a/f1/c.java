package a2.a.a.h3.a.f1;

import android.content.DialogInterface;
import com.avito.android.user_advert.advert.switcher_block.SwitcherState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<DialogInterface, Unit> {
    public final /* synthetic */ d a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar) {
        super(1);
        this.a = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "it");
        this.a.a.getSwitcherState().postValue(new SwitcherState.Specified(true));
        return Unit.INSTANCE;
    }
}
