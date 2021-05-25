package a2.a.a.b2.e1.c0;

import com.avito.android.profile.edit.avatar.AvatarInteractorImpl;
import com.avito.android.remote.model.Avatar;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
public final class c<T, R> implements Function<MultipartBody.Part, ObservableSource<? extends Avatar>> {
    public final /* synthetic */ AvatarInteractorImpl a;

    public c(AvatarInteractorImpl avatarInteractorImpl) {
        this.a = avatarInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends Avatar> apply(MultipartBody.Part part) {
        MultipartBody.Part part2 = part;
        Intrinsics.checkNotNullParameter(part2, "it");
        return InteropKt.toV2(this.a.a.uploadAvatar(part2));
    }
}
