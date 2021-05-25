package a2.a.a.q0;

import androidx.lifecycle.Observer;
import com.avito.android.extended_profile.ExtendedProfileViewEvent;
import com.avito.android.extended_profile.ExtendedProfileViewImpl;
public final class i<T> implements Observer<ExtendedProfileViewEvent> {
    public final /* synthetic */ ExtendedProfileViewImpl a;

    public i(ExtendedProfileViewImpl extendedProfileViewImpl) {
        this.a = extendedProfileViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ExtendedProfileViewEvent extendedProfileViewEvent) {
        ExtendedProfileViewEvent extendedProfileViewEvent2 = extendedProfileViewEvent;
        if (extendedProfileViewEvent2 instanceof ExtendedProfileViewEvent.ShowDataEvent) {
            ExtendedProfileViewImpl.access$showData(this.a);
        } else if (extendedProfileViewEvent2 instanceof ExtendedProfileViewEvent.ShowProgressEvent) {
            ExtendedProfileViewImpl.access$showProgress(this.a);
        } else if (extendedProfileViewEvent2 instanceof ExtendedProfileViewEvent.LoadingErrorEvent) {
            ExtendedProfileViewImpl.access$showError(this.a, ((ExtendedProfileViewEvent.LoadingErrorEvent) extendedProfileViewEvent2).getMessage());
        } else if (extendedProfileViewEvent2 instanceof ExtendedProfileViewEvent.ShowProgressAsDialogEvent) {
            ExtendedProfileViewImpl.access$showProgressAsDialog(this.a);
        } else if (extendedProfileViewEvent2 instanceof ExtendedProfileViewEvent.HideProgressAsDialogEvent) {
            ExtendedProfileViewImpl.access$hideProgressAsDialog(this.a);
        } else if (extendedProfileViewEvent2 instanceof ExtendedProfileViewEvent.ConfirmCallEvent) {
            ExtendedProfileViewImpl.access$showPhoneCallConfirmation(this.a, ((ExtendedProfileViewEvent.ConfirmCallEvent) extendedProfileViewEvent2).getDeepLink());
        } else if (extendedProfileViewEvent2 instanceof ExtendedProfileViewEvent.ShowUserBannedEvent) {
            ExtendedProfileViewImpl.access$showUserBanned(this.a, ((ExtendedProfileViewEvent.ShowUserBannedEvent) extendedProfileViewEvent2).getMessage());
        } else if (extendedProfileViewEvent2 instanceof ExtendedProfileViewEvent.ShowUserRemovedEvent) {
            ExtendedProfileViewImpl.access$showUserRemoved(this.a, ((ExtendedProfileViewEvent.ShowUserRemovedEvent) extendedProfileViewEvent2).getMessage());
        } else {
            boolean z = extendedProfileViewEvent2 instanceof ExtendedProfileViewEvent.DoNothing;
        }
    }
}
