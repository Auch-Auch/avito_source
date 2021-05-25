package a2.a.a.e2.w;

import com.avito.android.publish.input_vin.InputVinViewModel;
import com.avito.android.validation.SubmissionListener;
import io.reactivex.functions.Consumer;
public final class l<T> implements Consumer<SubmissionListener.SubmissionState> {
    public final /* synthetic */ InputVinViewModel a;

    public l(InputVinViewModel inputVinViewModel) {
        this.a = inputVinViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX DEBUG: Multi-variable search result rejected for r3v10, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(SubmissionListener.SubmissionState submissionState) {
        SubmissionListener.SubmissionState submissionState2 = submissionState;
        if (submissionState2 instanceof SubmissionListener.SubmissionState.Available) {
            InputVinViewModel.access$loadCategoryParametersByVinAndContinue(this.a);
        } else if (submissionState2 instanceof SubmissionListener.SubmissionState.Unavailable) {
            SubmissionListener.SubmissionState.Unavailable unavailable = (SubmissionListener.SubmissionState.Unavailable) submissionState2;
            if (unavailable.getHasWarningsOnFlowFinish() && this.a.j == 0) {
                this.a.n.trackPublishInputError(unavailable.getFailures(), InputVinViewModel.access$getPublishViewModel$p(this.a).getNavigation());
                InputVinViewModel inputVinViewModel = this.a;
                inputVinViewModel.j = inputVinViewModel.j + 1;
                this.a.d.setValue(new InputVinViewModel.InputVinEvents.ShowErrorMessage(this.a.p.getWarningsOnFlowFinishNotification()));
            } else if (unavailable.getHasErrors()) {
                this.a.n.trackPublishInputError(unavailable.getFailures(), InputVinViewModel.access$getPublishViewModel$p(this.a).getNavigation());
                this.a.d.setValue(new InputVinViewModel.InputVinEvents.ShowErrorMessage(this.a.p.getFixErrors()));
            } else {
                InputVinViewModel.access$loadCategoryParametersByVinAndContinue(this.a);
            }
        }
    }
}
