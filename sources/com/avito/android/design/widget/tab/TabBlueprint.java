package com.avito.android.design.widget.tab;

import androidx.fragment.app.Fragment;
import com.avito.android.design.widget.tab.Tab;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0001H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/design/widget/tab/TabBlueprint;", "Lcom/avito/android/design/widget/tab/Tab;", "T", "", "item", "Landroidx/fragment/app/Fragment;", "createFragment", "(Lcom/avito/android/design/widget/tab/Tab;)Landroidx/fragment/app/Fragment;", "onCreateFragment", "", "isRelevantItem", "(Lcom/avito/android/design/widget/tab/Tab;)Z", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface TabBlueprint<T extends Tab> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.design.widget.tab.Tab */
        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public static <T extends Tab> Fragment createFragment(@NotNull TabBlueprint<T> tabBlueprint, @NotNull Tab tab) {
            Intrinsics.checkNotNullParameter(tab, "item");
            return tabBlueprint.onCreateFragment(tab);
        }
    }

    @Nullable
    Fragment createFragment(@NotNull Tab tab);

    boolean isRelevantItem(@NotNull Tab tab);

    @Nullable
    Fragment onCreateFragment(@NotNull T t);
}
