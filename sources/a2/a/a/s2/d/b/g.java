package a2.a.a.s2.d.b;

import com.avito.android.deep_linking.links.DeepLink;
import io.reactivex.rxjava3.functions.Function;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
public final class g<T, R> implements Function<ShortcutNavigationItem, DeepLink> {
    public static final g a = new g();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public DeepLink apply(ShortcutNavigationItem shortcutNavigationItem) {
        return shortcutNavigationItem.getDeepLink();
    }
}
