package a2.a.a.c2.b;

import android.view.View;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ ConfirmPhoneFragment a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(ConfirmPhoneFragment confirmPhoneFragment) {
        super(1);
        this.a = confirmPhoneFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        ConfirmPhoneFragment.access$getViewModel$p(this.a).onNewCodeClicked();
        return Unit.INSTANCE;
    }
}
