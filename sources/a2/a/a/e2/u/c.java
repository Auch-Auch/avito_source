package a2.a.a.e2.u;

import com.avito.android.publish.edit_advert_request.EditAdvertRequestFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function0<Unit> {
    public final /* synthetic */ EditAdvertRequestFragment a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(EditAdvertRequestFragment editAdvertRequestFragment) {
        super(0);
        this.a = editAdvertRequestFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        EditAdvertRequestFragment.access$getViewModel$p(this.a).goPrevious();
        return Unit.INSTANCE;
    }
}
