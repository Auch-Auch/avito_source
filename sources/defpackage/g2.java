package defpackage;

import com.avito.android.bottom_navigation.BottomNavigationController;
import com.avito.android.bottom_navigation.NavigationTab;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: g2  reason: default package */
public final class g2<T> implements Consumer<Integer> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public g2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Integer num) {
        int i = this.a;
        if (i == 0) {
            Integer num2 = num;
            NavigationTab.FAVORITES favorites = NavigationTab.FAVORITES.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            ((BottomNavigationController) this.b).setTabBadge(favorites, num2.intValue());
        } else if (i == 1) {
            Integer num3 = num;
            NavigationTab.MESSAGE message = NavigationTab.MESSAGE.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(num3, "it");
            ((BottomNavigationController) this.b).setTabBadge(message, num3.intValue());
        } else if (i == 2) {
            Integer num4 = num;
            NavigationTab.PROFILE profile = NavigationTab.PROFILE.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(num4, "it");
            ((BottomNavigationController) this.b).setTabBadge(profile, num4.intValue());
        } else {
            throw null;
        }
    }
}
