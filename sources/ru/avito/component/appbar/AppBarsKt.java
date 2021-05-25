package ru.avito.component.appbar;

import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBar;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Lru/avito/component/appbar/AppBar;", "", "setCloseIcon", "(Lru/avito/component/appbar/AppBar;)V", "setBackIcon", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class AppBarsKt {
    public static final void setBackIcon(@NotNull AppBar appBar) {
        Intrinsics.checkNotNullParameter(appBar, "$this$setBackIcon");
        AppBar.DefaultImpls.setNavigationIcon$default(appBar, R.drawable.ic_back_24_blue, null, 2, null);
    }

    public static final void setCloseIcon(@NotNull AppBar appBar) {
        Intrinsics.checkNotNullParameter(appBar, "$this$setCloseIcon");
        AppBar.DefaultImpls.setNavigationIcon$default(appBar, R.drawable.ic_close_24_blue, null, 2, null);
    }
}
