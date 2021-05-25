package a2.a.a.e2.e0;

import android.content.Context;
import android.os.Handler;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.avito.android.AuthIntentFactory;
import com.avito.android.publish.drafts.PublishDraftAvailableDialogKt;
import com.avito.android.publish.start_publish.StartPublishFragment;
import com.avito.android.publish.start_publish.StartPublishViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DeepLinksDialogInfo;
import com.avito.android.util.ToastsKt;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<StartPublishViewModel.State> {
    public final /* synthetic */ StartPublishFragment a;

    public b(StartPublishFragment startPublishFragment) {
        this.a = startPublishFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(StartPublishViewModel.State state) {
        StartPublishViewModel.State state2 = state;
        if (state2 instanceof StartPublishViewModel.State.UnAuthorized) {
            StartPublishFragment startPublishFragment = this.a;
            startPublishFragment.startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(startPublishFragment.getIntentFactory(), null, AuthSource.CREATE_ADVERT, null, 5, null), 1);
        } else if (state2 instanceof StartPublishViewModel.State.WizardSheet) {
            StartPublishFragment.access$hideLoadingDialog(this.a);
            StartPublishFragment.access$showStartPublishSheet(this.a).setData(((StartPublishViewModel.State.WizardSheet) state2).getData());
        } else if (state2 instanceof StartPublishViewModel.State.DraftDialog) {
            StartPublishFragment.access$hideLoadingDialog(this.a);
            StartPublishViewModel.State.DraftDialog draftDialog = (StartPublishViewModel.State.DraftDialog) state2;
            String sessionId = draftDialog.getSessionId();
            DeepLinksDialogInfo dialogInfo = draftDialog.getDialogInfo();
            FragmentManager childFragmentManager = this.a.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            PublishDraftAvailableDialogKt.showPublishDraftAvailableDialogFragment(sessionId, dialogInfo, childFragmentManager, false);
        } else if (state2 instanceof StartPublishViewModel.State.LoadingSheet) {
            StartPublishFragment.access$showLoadingDialog(this.a);
        } else if (state2 instanceof StartPublishViewModel.State.Error) {
            StartPublishFragment startPublishFragment2 = this.a;
            String message = ((StartPublishViewModel.State.Error) state2).getMessage();
            Context context = startPublishFragment2.getContext();
            if (context != null) {
                ToastsKt.showToast(context, message, 0);
            }
            StartPublishFragment.access$hideLoadingDialog(this.a);
            StartPublishFragment.access$hideStartPublishSheet(this.a);
            new Handler().post(new a(this));
        }
    }
}
