package defpackage;

import android.view.View;
import com.avito.android.job.interview.Action;
import com.avito.android.job.interview.JobInterviewInvitationRenderer;
/* compiled from: java-style lambda group */
/* renamed from: f2  reason: default package */
public final class f2 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public f2(int i, int i2, Object obj) {
        this.a = i;
        this.b = i2;
        this.c = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            ((JobInterviewInvitationRenderer) this.c).m.accept(new Action.ChangeDate(this.b));
        } else if (i == 1) {
            ((JobInterviewInvitationRenderer) this.c).m.accept(new Action.ChangeTime(this.b));
        } else {
            throw null;
        }
    }
}
