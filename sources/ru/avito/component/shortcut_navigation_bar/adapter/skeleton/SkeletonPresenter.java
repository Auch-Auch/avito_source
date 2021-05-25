package ru.avito.component.shortcut_navigation_bar.adapter.skeleton;

import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.shortcut_navigation_bar.adapter.SkeletonItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/skeleton/SkeletonPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lru/avito/component/shortcut_navigation_bar/adapter/skeleton/SkeletonView;", "Lru/avito/component/shortcut_navigation_bar/adapter/SkeletonItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lru/avito/component/shortcut_navigation_bar/adapter/skeleton/SkeletonView;Lru/avito/component/shortcut_navigation_bar/adapter/SkeletonItem;I)V", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SkeletonPresenter implements ItemPresenter<SkeletonView, SkeletonItem> {
    public void bindView(@NotNull SkeletonView skeletonView, @NotNull SkeletonItem skeletonItem, int i) {
        Intrinsics.checkNotNullParameter(skeletonView, "view");
        Intrinsics.checkNotNullParameter(skeletonItem, "item");
    }
}
