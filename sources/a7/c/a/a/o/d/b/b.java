package a7.c.a.a.o.d.b;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.presentation.dialogerror.view.ErrorDialogFragment;
public final class b extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, ErrorDialogFragment> {
    public final /* synthetic */ ErrorDialogFragment.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ErrorDialogFragment.a aVar) {
        super(1);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public ErrorDialogFragment invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein, "$receiver");
        return this.a.a;
    }
}
