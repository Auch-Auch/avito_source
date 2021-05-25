package a2.a.a.i3.c.a;

import androidx.lifecycle.Observer;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Observer<Boolean> {
    public final /* synthetic */ UserAdvertsHostFragment a;

    public a(UserAdvertsHostFragment userAdvertsHostFragment) {
        this.a = userAdvertsHostFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        ProfileHeaderView access$getProfileHeaderView$p = UserAdvertsHostFragment.access$getProfileHeaderView$p(this.a);
        Intrinsics.checkNotNullExpressionValue(bool2, "it");
        access$getProfileHeaderView$p.showItemsSearch(bool2.booleanValue());
    }
}
