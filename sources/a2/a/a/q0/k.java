package a2.a.a.q0;

import com.avito.android.extended_profile.ExtendedProfileViewImpl;
import com.avito.android.extended_profile.tracker.ExtendedProfileTracker;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class k<T> implements Consumer<Disposable> {
    public final /* synthetic */ ExtendedProfileViewImpl a;
    public final /* synthetic */ ExtendedProfileTracker.TrackFlow b;

    public k(ExtendedProfileViewImpl extendedProfileViewImpl, ExtendedProfileTracker.TrackFlow trackFlow) {
        this.a = extendedProfileViewImpl;
        this.b = trackFlow;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        ExtendedProfileViewImpl.access$onStartDraw(this.a, this.b);
    }
}
