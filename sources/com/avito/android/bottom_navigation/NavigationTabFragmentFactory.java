package com.avito.android.bottom_navigation;

import com.avito.android.ui.fragments.TabBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/bottom_navigation/NavigationTabFragmentFactory;", "", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "create", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Lcom/avito/android/ui/fragments/TabBaseFragment;", "getType", "()Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "type", "Companion", "core_release"}, k = 1, mv = {1, 4, 2})
public interface NavigationTabFragmentFactory {
    @NotNull
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/bottom_navigation/NavigationTabFragmentFactory$Companion;", "", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "TAB", "type", "Lkotlin/Function1;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "create", "Lcom/avito/android/bottom_navigation/NavigationTabFragmentFactory;", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;Lkotlin/jvm/functions/Function1;)Lcom/avito/android/bottom_navigation/NavigationTabFragmentFactory;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final <TAB extends NavigationTabSetItem> NavigationTabFragmentFactory create(@NotNull TAB tab, @NotNull Function1<? super TAB, ? extends TabBaseFragment> function1) {
            Intrinsics.checkNotNullParameter(tab, "type");
            Intrinsics.checkNotNullParameter(function1, "create");
            return new NavigationTabFragmentFactory$Companion$create$1(function1, tab);
        }
    }

    @NotNull
    TabBaseFragment create(@NotNull NavigationTabSetItem navigationTabSetItem);

    @NotNull
    NavigationTabSetItem getType();
}
