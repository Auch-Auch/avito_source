package a2.a.a.i3.c.a;

import androidx.lifecycle.Observer;
import com.avito.android.remote.model.ProfileInfo;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Observer<ProfileInfo> {
    public final /* synthetic */ UserAdvertsHostFragment a;

    public c(UserAdvertsHostFragment userAdvertsHostFragment) {
        this.a = userAdvertsHostFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ProfileInfo profileInfo) {
        ProfileInfo profileInfo2 = profileInfo;
        ProfileHeaderView access$getProfileHeaderView$p = UserAdvertsHostFragment.access$getProfileHeaderView$p(this.a);
        Intrinsics.checkNotNullExpressionValue(profileInfo2, "it");
        access$getProfileHeaderView$p.setProfileInfo(profileInfo2);
    }
}
