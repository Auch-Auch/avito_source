package a2.a.a.e3.c;

import com.avito.android.tariff.dialog.TariffDialogFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ TariffDialogFragment.b a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(TariffDialogFragment.b bVar) {
        super(0);
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.a.dismiss();
        return Unit.INSTANCE;
    }
}
