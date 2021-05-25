package com.avito.android.bottom_navigation;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.TabBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"com/avito/android/bottom_navigation/NavigationTabFragmentFactory$Companion$create$1", "Lcom/avito/android/bottom_navigation/NavigationTabFragmentFactory;", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "create", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Lcom/avito/android/ui/fragments/TabBaseFragment;", AuthSource.SEND_ABUSE, "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "getType", "()Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "type", "core_release"}, k = 1, mv = {1, 4, 2})
public final class NavigationTabFragmentFactory$Companion$create$1 implements NavigationTabFragmentFactory {
    @NotNull
    public final NavigationTabSetItem a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ NavigationTabSetItem c;

    public NavigationTabFragmentFactory$Companion$create$1(Function1 function1, NavigationTabSetItem navigationTabSetItem) {
        this.b = function1;
        this.c = navigationTabSetItem;
        this.a = navigationTabSetItem;
    }

    @Override // com.avito.android.bottom_navigation.NavigationTabFragmentFactory
    @NotNull
    public TabBaseFragment create(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return (TabBaseFragment) this.b.invoke(this.c);
    }

    @Override // com.avito.android.bottom_navigation.NavigationTabFragmentFactory
    @NotNull
    public NavigationTabSetItem getType() {
        return this.a;
    }
}
