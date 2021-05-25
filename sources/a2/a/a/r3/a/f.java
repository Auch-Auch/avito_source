package a2.a.a.r3.a;

import android.view.View;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.verification.verification_status.VerificationStatusScreenData;
import com.avito.android.verification.verification_status.VerificationStatusViewImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ VerificationStatusScreenData.Action a;
    public final /* synthetic */ g b;
    public final /* synthetic */ BottomSheetMenuDialog c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(VerificationStatusScreenData.Action action, g gVar, BottomSheetMenuDialog bottomSheetMenuDialog) {
        super(1);
        this.a = action;
        this.b = gVar;
        this.c = bottomSheetMenuDialog;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        this.c.close();
        VerificationStatusViewImpl.access$getView$p(this.b.a).postDelayed(new e(this), 200);
        return Unit.INSTANCE;
    }
}
