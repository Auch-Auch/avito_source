package a2.a.a.b2.e1;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.remote.model.ProfileInfo;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a0<T, R> implements Function<ProfileInfo, CompletableSource> {
    public final /* synthetic */ b0 a;

    public a0(b0 b0Var) {
        this.a = b0Var;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(ProfileInfo profileInfo) {
        ProfileInfo profileInfo2 = profileInfo;
        Intrinsics.checkNotNullParameter(profileInfo2, "profile");
        return InteropKt.toV2(AccountStorageInteractor.DefaultImpls.save$default(this.a.a.b, new ProfileInfo(profileInfo2.getUserId(), this.a.b, profileInfo2.getEmail(), profileInfo2.getImage()), null, 2, null));
    }
}
