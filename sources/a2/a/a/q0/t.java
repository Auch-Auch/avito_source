package a2.a.a.q0;

import com.avito.android.extended_profile.ExtendedProfileViewModelImpl;
import com.avito.android.extended_profile.adapter.progress.ProgressItem;
import com.avito.android.extended_profile.tracker.ExtendedProfileTracker;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import t6.n.d;
public final class t<T> implements Consumer<Disposable> {
    public final /* synthetic */ ExtendedProfileViewModelImpl a;

    public t(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        this.a = extendedProfileViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        this.a.l = d.listOf(new ProgressItem(null, null, 3, null));
        this.a.h(ExtendedProfileTracker.TrackFlow.PROFILE_SUCCESS);
        this.a.B.startExtendedProfileLoading();
    }
}
