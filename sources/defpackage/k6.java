package defpackage;

import android.content.DialogInterface;
import com.avito.android.messenger.conversation.confirmation_dialog.ConfirmationDialogView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: k6  reason: default package */
public final class k6 extends Lambda implements Function1<DialogInterface, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k6(int i, Object obj) {
        super(1);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(DialogInterface dialogInterface) {
        int i = this.a;
        if (i == 0) {
            Intrinsics.checkNotNullParameter(dialogInterface, "it");
            ((ConfirmationDialogView.b) this.b).d.invoke();
            return Unit.INSTANCE;
        } else if (i == 1) {
            Intrinsics.checkNotNullParameter(dialogInterface, "it");
            ((ConfirmationDialogView.b) this.b).d.invoke();
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
