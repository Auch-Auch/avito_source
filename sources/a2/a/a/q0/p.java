package a2.a.a.q0;

import com.avito.android.extended_profile.ExtendedProfileViewModelImpl;
import com.avito.android.extended_profile.tracker.ExtendedProfileTracker;
import io.reactivex.rxjava3.functions.Action;
public final class p implements Action {
    public final /* synthetic */ ExtendedProfileViewModelImpl a;

    public p(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        this.a = extendedProfileViewModelImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.a.B.trackProfilePreparing();
        this.a.B.startExtendedProfilePreparing();
        this.a.h(ExtendedProfileTracker.TrackFlow.EXTENDED_PROFILE_SUCCESS);
    }
}
