package ru.avito.component.shortcut_navigation_bar.adapter.skeleton;

import android.view.View;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/skeleton/SkeletonViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lru/avito/component/shortcut_navigation_bar/adapter/skeleton/SkeletonView;", "Landroid/view/View;", "s", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SkeletonViewImpl extends BaseViewHolder implements SkeletonView {
    @NotNull
    public final View s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SkeletonViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = view;
    }

    @NotNull
    public final View getView() {
        return this.s;
    }
}
