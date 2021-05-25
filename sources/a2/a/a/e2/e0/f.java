package a2.a.a.e2.e0;

import com.avito.android.publish.start_publish.StartPublishInteractor;
import com.avito.android.publish.start_publish.StartPublishViewModel;
import com.avito.android.remote.model.PublishDraftResponse;
import io.reactivex.rxjava3.functions.Consumer;
public final class f<T> implements Consumer<StartPublishInteractor.ScreenData> {
    public final /* synthetic */ StartPublishViewModel a;

    public f(StartPublishViewModel startPublishViewModel) {
        this.a = startPublishViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(StartPublishInteractor.ScreenData screenData) {
        StartPublishInteractor.ScreenData screenData2 = screenData;
        PublishDraftResponse draftResponse = screenData2.getDraftResponse();
        if (draftResponse instanceof PublishDraftResponse.Ok) {
            this.a.d.setValue(new StartPublishViewModel.State.DraftDialog(((PublishDraftResponse.Ok) screenData2.getDraftResponse()).getDraft().getSessionId(), ((PublishDraftResponse.Ok) screenData2.getDraftResponse()).getDialogInfo()));
        } else if (draftResponse instanceof PublishDraftResponse.NotFound) {
            StartPublishViewModel.access$showPublishSheet(this.a, screenData2.getShortcuts());
        }
    }
}
