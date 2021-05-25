package a2.a.a.q0;

import com.avito.android.extended_profile.ExtendedProfileViewModelImpl;
import com.avito.android.extended_profile.data.ExtendedProfileDataItem;
import com.avito.android.extended_profile.tracker.ExtendedProfileTracker;
import com.avito.android.util.LoadingState;
import com.avito.android.util.TypedResultException;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
public final class u<T> implements Consumer<LoadingState<? super List<? extends ExtendedProfileDataItem>>> {
    public final /* synthetic */ ExtendedProfileViewModelImpl a;

    public u(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        this.a = extendedProfileViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super List<? extends ExtendedProfileDataItem>> loadingState) {
        LoadingState<? super List<? extends ExtendedProfileDataItem>> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.l = (List) ((LoadingState.Loaded) loadingState2).getData();
            this.a.h(ExtendedProfileTracker.TrackFlow.EXTENDED_PROFILE_SUCCESS);
        } else if (loadingState2 instanceof LoadingState.Error) {
            throw new TypedResultException(((LoadingState.Error) loadingState2).getError());
        }
    }
}
