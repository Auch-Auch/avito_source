package a2.a.a.e2.a0;

import androidx.lifecycle.Observer;
import com.avito.android.publish.publish_advert_request.PublishAdvertRequestFragment;
import com.avito.android.publish.publish_advert_request.PublishAdvertRequestViewModel;
public final class a<T> implements Observer<PublishAdvertRequestViewModel.ViewState> {
    public final /* synthetic */ PublishAdvertRequestFragment a;

    public a(PublishAdvertRequestFragment publishAdvertRequestFragment) {
        this.a = publishAdvertRequestFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(PublishAdvertRequestViewModel.ViewState viewState) {
        PublishAdvertRequestViewModel.ViewState viewState2 = viewState;
        if (viewState2 instanceof PublishAdvertRequestViewModel.ViewState.PhotosUploading) {
            PublishAdvertRequestFragment.access$showPhotoUploadingContent(this.a, (PublishAdvertRequestViewModel.ViewState.PhotosUploading) viewState2);
        } else if (viewState2 instanceof PublishAdvertRequestViewModel.ViewState.PhotosUploaded) {
            this.a.getLoadingProgress().showFullScreenLoading();
        } else if (viewState2 instanceof PublishAdvertRequestViewModel.ViewState.PhotoUploadError) {
            PublishAdvertRequestFragment.access$showPhotoUploadErrorDialog(this.a);
        } else if (viewState2 instanceof PublishAdvertRequestViewModel.ViewState.Loading) {
            this.a.getLoadingProgress().showFullScreenLoading();
        } else if (viewState2 instanceof PublishAdvertRequestViewModel.ViewState.Error) {
            this.a.getLoadingProgress().showFullScreenLoadingProblem(((PublishAdvertRequestViewModel.ViewState.Error) viewState2).getError().getMessage());
        }
    }
}
