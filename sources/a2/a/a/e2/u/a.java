package a2.a.a.e2.u;

import androidx.lifecycle.Observer;
import com.avito.android.publish.edit_advert_request.EditAdvertRequestFragment;
import com.avito.android.publish.edit_advert_request.EditAdvertRequestViewModel;
public final class a<T> implements Observer<EditAdvertRequestViewModel.ViewState> {
    public final /* synthetic */ EditAdvertRequestFragment a;

    public a(EditAdvertRequestFragment editAdvertRequestFragment) {
        this.a = editAdvertRequestFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(EditAdvertRequestViewModel.ViewState viewState) {
        EditAdvertRequestViewModel.ViewState viewState2 = viewState;
        if (viewState2 instanceof EditAdvertRequestViewModel.ViewState.ShowFeesLegacy) {
            EditAdvertRequestFragment.access$showFeesLegacy(this.a, ((EditAdvertRequestViewModel.ViewState.ShowFeesLegacy) viewState2).getItemId());
        } else if (viewState2 instanceof EditAdvertRequestViewModel.ViewState.ShowFees) {
            EditAdvertRequestViewModel.ViewState.ShowFees showFees = (EditAdvertRequestViewModel.ViewState.ShowFees) viewState2;
            EditAdvertRequestFragment.access$showFees(this.a, showFees.getDeeplink(), showFees.getItemId());
        } else if (viewState2 instanceof EditAdvertRequestViewModel.ViewState.FinishEdit) {
            EditAdvertRequestViewModel.ViewState.FinishEdit finishEdit = (EditAdvertRequestViewModel.ViewState.FinishEdit) viewState2;
            this.a.a(finishEdit.getMessage(), finishEdit.getAdvertId());
        } else if (viewState2 instanceof EditAdvertRequestViewModel.ViewState.Loading) {
            this.a.getLoadingProgress().showFullScreenLoading();
        } else if (viewState2 instanceof EditAdvertRequestViewModel.ViewState.Error) {
            this.a.getLoadingProgress().showFullScreenLoadingProblem(((EditAdvertRequestViewModel.ViewState.Error) viewState2).getError().getMessage());
        } else if (viewState2 instanceof EditAdvertRequestViewModel.ViewState.ShowActionDialog) {
            this.a.getLoadingProgress().showContent();
            EditAdvertRequestViewModel.ViewState.ShowActionDialog showActionDialog = (EditAdvertRequestViewModel.ViewState.ShowActionDialog) viewState2;
            EditAdvertRequestFragment.access$showActionDialog(this.a, showActionDialog.getDialogData(), showActionDialog.getOnPositiveClicked());
        } else if (viewState2 instanceof EditAdvertRequestViewModel.ViewState.OpenDeepLinkAndFinish) {
            EditAdvertRequestViewModel.ViewState.OpenDeepLinkAndFinish openDeepLinkAndFinish = (EditAdvertRequestViewModel.ViewState.OpenDeepLinkAndFinish) viewState2;
            EditAdvertRequestFragment.access$openDeepLinkAndFinishEdit(this.a, openDeepLinkAndFinish.getDeepLink(), openDeepLinkAndFinish.getAdvertId());
        }
    }
}
