package com.avito.android.bottom_navigation;

import com.avito.android.bottom_navigation.ui.fragment.TabContainerFragment;
import com.avito.android.bottom_navigation.ui.fragment.TabContainerFragmentImpl;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.TabBaseFragment;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0011\u0010\u0013\u001a\r\u0012\t\u0012\u00070\u000f¢\u0006\u0002\b\u00100\u000e\u0012\u0011\u0010\u0016\u001a\r\u0012\t\u0012\u00070\u0014¢\u0006\u0002\b\u00100\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR!\u0010\u0013\u001a\r\u0012\t\u0012\u00070\u000f¢\u0006\u0002\b\u00100\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R!\u0010\u0016\u001a\r\u0012\t\u0012\u00070\u0014¢\u0006\u0002\b\u00100\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/avito/android/bottom_navigation/TabFragmentFactoryImpl;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory;", "Lcom/avito/android/bottom_navigation/ui/fragment/TabContainerFragment;", "createTabContainer", "()Lcom/avito/android/bottom_navigation/ui/fragment/TabContainerFragment;", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "createRootTabFragment", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "data", "createFragment", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;)Lcom/avito/android/ui/fragments/TabBaseFragment;", "", "Lcom/avito/android/bottom_navigation/NavigationTabFragmentFactory;", "Lkotlin/jvm/JvmSuppressWildcards;", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "navigationTabFactories", "Lcom/avito/android/bottom_navigation/DataTabFragmentFactory;", AuthSource.BOOKING_ORDER, "dataTabFactories", "<init>", "(Ljava/util/Set;Ljava/util/Set;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class TabFragmentFactoryImpl implements TabFragmentFactory {
    public final Set<NavigationTabFragmentFactory> a;
    public final Set<DataTabFragmentFactory> b;

    @Inject
    public TabFragmentFactoryImpl(@NotNull Set<NavigationTabFragmentFactory> set, @NotNull Set<DataTabFragmentFactory> set2) {
        Intrinsics.checkNotNullParameter(set, "navigationTabFactories");
        Intrinsics.checkNotNullParameter(set2, "dataTabFactories");
        this.a = set;
        this.b = set2;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory
    @NotNull
    public TabContainerFragment createTabContainer() {
        return new TabContainerFragmentImpl();
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory
    @NotNull
    public TabBaseFragment createFragment(@NotNull TabFragmentFactory.Data data) {
        T t;
        Intrinsics.checkNotNullParameter(data, "data");
        Iterator<T> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getDataType(), data.getClass())) {
                break;
            }
        }
        if (t != null) {
            return t.create(data);
        }
        throw new IllegalStateException(("No DataTabFragmentFactory for data " + data).toString());
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory
    @NotNull
    public TabBaseFragment createRootTabFragment(@NotNull NavigationTabSetItem navigationTabSetItem) {
        T t;
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        Iterator<T> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getType(), navigationTabSetItem)) {
                break;
            }
        }
        if (t != null) {
            return t.create(navigationTabSetItem);
        }
        throw new IllegalStateException(("No NavigationTabFragmentFactory for tab " + navigationTabSetItem).toString());
    }
}
