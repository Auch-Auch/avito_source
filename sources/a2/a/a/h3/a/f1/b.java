package a2.a.a.h3.a.f1;

import android.content.DialogInterface;
import com.avito.android.user_advert.advert.autobooking_block.AutoBookingBlockViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ d a;
    public final /* synthetic */ DialogInterface b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(d dVar, DialogInterface dialogInterface) {
        super(0);
        this.a = dVar;
        this.b = dialogInterface;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        AutoBookingBlockViewModel.m93access$onSwitchChanged$s707517535(this.a.a, false);
        this.b.dismiss();
        return Unit.INSTANCE;
    }
}
