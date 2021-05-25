package a2.a.a.i3.c.a;

import androidx.lifecycle.Observer;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<Integer> {
    public final /* synthetic */ UserAdvertsHostFragment a;

    public b(UserAdvertsHostFragment userAdvertsHostFragment) {
        this.a = userAdvertsHostFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Integer num) {
        Integer num2 = num;
        ProfileHeaderView access$getProfileHeaderView$p = UserAdvertsHostFragment.access$getProfileHeaderView$p(this.a);
        Intrinsics.checkNotNullExpressionValue(num2, "it");
        access$getProfileHeaderView$p.updateNotificationCounter(num2.intValue());
    }
}
