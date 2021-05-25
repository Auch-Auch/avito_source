package a2.a.a.e3.a;

import android.content.DialogInterface;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.tariff.change.ChangeConfirmationDialogFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ChangeConfirmationDialogFragment.a a;
    public final /* synthetic */ DialogInterface b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ChangeConfirmationDialogFragment.a aVar, DialogInterface dialogInterface) {
        super(0);
        this.a = aVar;
        this.b = dialogInterface;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.b.dismiss();
        PaidServicesRouter paidServicesRouter = this.a.a.a;
        if (paidServicesRouter != null) {
            paidServicesRouter.navigate(this.a.c);
        }
        return Unit.INSTANCE;
    }
}
