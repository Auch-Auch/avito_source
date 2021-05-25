package a2.a.a.a1;

import com.avito.android.home.HomePresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
public final class z<T> implements Consumer<ShortcutNavigationItem> {
    public final /* synthetic */ HomePresenterImpl a;

    public z(HomePresenterImpl homePresenterImpl) {
        this.a = homePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(ShortcutNavigationItem shortcutNavigationItem) {
        ShortcutNavigationItem shortcutNavigationItem2 = shortcutNavigationItem;
        HomePresenterImpl homePresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(shortcutNavigationItem2, "it");
        HomePresenterImpl.access$openShortcut(homePresenterImpl, shortcutNavigationItem2);
    }
}
