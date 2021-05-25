package a2.a.a.j1.b;

import com.avito.android.job.interview.JobInterviewInvitationViewModel;
import com.avito.android.job.interview.State;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<Disposable> {
    public final /* synthetic */ JobInterviewInvitationViewModel a;

    public d(JobInterviewInvitationViewModel jobInterviewInvitationViewModel) {
        this.a = jobInterviewInvitationViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        this.a.d.postValue(State.Loading.INSTANCE);
    }
}
