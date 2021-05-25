package a2.a.a.k.c;

import com.avito.android.app_rater.fragment.AppRaterDialogFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ AppRaterDialogFragment.d a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(AppRaterDialogFragment.d dVar) {
        super(0);
        this.a = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        AppRaterDialogFragment.access$getViewModel$p(this.a.a).close();
        return Unit.INSTANCE;
    }
}
