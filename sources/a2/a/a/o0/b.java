package a2.a.a.o0;

import com.avito.android.dialog.DialogWithDeeplinkActions;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ DialogWithDeeplinkActions.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(DialogWithDeeplinkActions.a aVar) {
        super(0);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.a.onCloseButtonClicked();
        return Unit.INSTANCE;
    }
}
