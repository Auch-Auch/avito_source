package a2.a.a.j1.b;

import android.view.View;
import com.avito.android.job.interview.Action;
import com.avito.android.job.interview.JobInterviewInvitationRenderer;
import com.avito.android.job.interview.domain.InvitationDraft;
public final class b implements View.OnClickListener {
    public final /* synthetic */ JobInterviewInvitationRenderer a;
    public final /* synthetic */ InvitationDraft b;

    public b(JobInterviewInvitationRenderer jobInterviewInvitationRenderer, InvitationDraft invitationDraft) {
        this.a = jobInterviewInvitationRenderer;
        this.b = invitationDraft;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.m.accept(new Action.PickLocation(this.b.getLocation()));
    }
}
