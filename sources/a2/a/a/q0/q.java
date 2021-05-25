package a2.a.a.q0;

import com.avito.android.extended_profile.ExtendedProfileViewModelImpl;
import io.reactivex.rxjava3.functions.Action;
public final class q implements Action {
    public final /* synthetic */ ExtendedProfileViewModelImpl a;

    public q(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        this.a = extendedProfileViewModelImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.a.B.startProfilePreparing();
    }
}
