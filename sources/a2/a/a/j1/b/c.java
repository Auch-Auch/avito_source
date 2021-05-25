package a2.a.a.j1.b;

import android.view.View;
import com.avito.android.job.interview.Action;
import com.avito.android.job.interview.JobInterviewInvitationRenderer;
public final class c implements View.OnClickListener {
    public final /* synthetic */ JobInterviewInvitationRenderer a;

    public c(JobInterviewInvitationRenderer jobInterviewInvitationRenderer) {
        this.a = jobInterviewInvitationRenderer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.m.accept(Action.Invite.INSTANCE);
    }
}
