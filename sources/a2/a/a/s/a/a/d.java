package a2.a.a.s.a.a;

import com.avito.android.beduin.ui.fragment.BeduinFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Unit> {
    public final /* synthetic */ BeduinFragment a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(BeduinFragment beduinFragment) {
        super(0);
        this.a = beduinFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.getBeduinViewModel().fetchData();
        return Unit.INSTANCE;
    }
}
