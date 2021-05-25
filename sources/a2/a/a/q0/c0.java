package a2.a.a.q0;

import com.avito.android.extended_profile.ExtendedProfileViewModelImpl;
import com.avito.android.public_profile.remote.model.ExtendedPublicUserProfile;
import com.avito.android.public_profile.remote.model.PublicUserProfile;
import com.avito.android.remote.model.Sharing;
import com.avito.android.util.LoadingState;
import com.avito.android.util.LoadingStateKt;
import com.avito.android.util.TypedResultException;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class c0<T, R> implements Function<LoadingState<? super PublicUserProfile>, Unit> {
    public final /* synthetic */ ExtendedProfileViewModelImpl a;
    public final /* synthetic */ boolean b;

    public c0(ExtendedProfileViewModelImpl extendedProfileViewModelImpl, boolean z) {
        this.a = extendedProfileViewModelImpl;
        this.b = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Unit apply(LoadingState<? super PublicUserProfile> loadingState) {
        LoadingState<? super PublicUserProfile> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            Object dataOrNull = LoadingStateKt.dataOrNull(loadingState2);
            Sharing sharing = null;
            if (!(dataOrNull instanceof ExtendedPublicUserProfile)) {
                dataOrNull = null;
            }
            ExtendedPublicUserProfile extendedPublicUserProfile = (ExtendedPublicUserProfile) dataOrNull;
            if (extendedPublicUserProfile != null) {
                this.a.p = extendedPublicUserProfile;
                this.a.c(extendedPublicUserProfile);
                ExtendedProfileViewModelImpl extendedProfileViewModelImpl = this.a;
                ExtendedPublicUserProfile extendedPublicUserProfile2 = extendedProfileViewModelImpl.p;
                if (extendedPublicUserProfile2 != null) {
                    sharing = extendedPublicUserProfile2.getSharing();
                }
                ExtendedProfileViewModelImpl.access$updateShareMenuVisibility(extendedProfileViewModelImpl, sharing != null);
            } else {
                throw new IllegalStateException("Must be correct ExtendedProfile object");
            }
        } else if (loadingState2 instanceof LoadingState.Loading) {
            if (!this.b) {
                ExtendedProfileViewModelImpl.access$showProgress(this.a);
            }
        } else if (loadingState2 instanceof LoadingState.Error) {
            throw new TypedResultException(((LoadingState.Error) loadingState2).getError());
        }
        return Unit.INSTANCE;
    }
}
