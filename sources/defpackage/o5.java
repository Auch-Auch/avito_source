package defpackage;

import com.avito.android.job.interview.Action;
import com.avito.android.job.interview.JobInterviewInvitationRenderer;
import com.avito.android.lib.design.input.Input;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: o5  reason: default package */
public final class o5 extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o5(int i, Object obj) {
        super(1);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(String str) {
        int i = this.a;
        if (i == 0) {
            Intrinsics.checkNotNullParameter(str, "it");
            ((Input) this.b).setState(Input.Companion.getSTATE_NORMAL());
            return Unit.INSTANCE;
        } else if (i == 1) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            ((JobInterviewInvitationRenderer) this.b).m.accept(new Action.PhoneChanged(str2));
            return Unit.INSTANCE;
        } else if (i == 2) {
            String str3 = str;
            Intrinsics.checkNotNullParameter(str3, "it");
            ((JobInterviewInvitationRenderer) this.b).m.accept(new Action.MessageChanged(str3));
            return Unit.INSTANCE;
        } else if (i == 3) {
            Intrinsics.checkNotNullParameter(str, "it");
            ((Input) this.b).setState(Input.Companion.getSTATE_NORMAL());
            return Unit.INSTANCE;
        } else if (i == 4) {
            Intrinsics.checkNotNullParameter(str, "it");
            ((Input) this.b).setState(Input.Companion.getSTATE_NORMAL());
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
