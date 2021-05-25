package a2.a.a.g1.e.d;

import com.avito.android.inline_filters.dialog.select.GroupSelectFilterDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ GroupSelectFilterDialog a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(GroupSelectFilterDialog groupSelectFilterDialog) {
        super(1);
        this.a = groupSelectFilterDialog;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        this.a.getDialog().setActionButtonActive(bool.booleanValue());
        return Unit.INSTANCE;
    }
}
