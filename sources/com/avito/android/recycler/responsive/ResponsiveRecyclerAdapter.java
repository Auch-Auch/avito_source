package com.avito.android.recycler.responsive;

import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/recycler/responsive/ResponsiveRecyclerAdapter;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "holder", "", "onViewAttachedToWindow", "(Lcom/avito/konveyor/adapter/BaseViewHolder;)V", "onViewDetachedFromWindow", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "f", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "holderProvider", "<init>", "(Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;)V", "recycler_release"}, k = 1, mv = {1, 4, 2})
public final class ResponsiveRecyclerAdapter extends SimpleRecyclerAdapter {
    public final ResponsiveAdapterPresenter f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ResponsiveRecyclerAdapter(@NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder) {
        super(responsiveAdapterPresenter, viewHolderBuilder);
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "presenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "holderProvider");
        this.f = responsiveAdapterPresenter;
    }

    public void onViewAttachedToWindow(@NotNull BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        if (baseViewHolder.getAdapterPosition() != -1) {
            this.f.viewAttached(baseViewHolder, baseViewHolder.getAdapterPosition());
        }
    }

    public void onViewDetachedFromWindow(@NotNull BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        if (baseViewHolder.getAdapterPosition() != -1) {
            this.f.viewDetached(baseViewHolder, baseViewHolder.getAdapterPosition());
        }
    }
}
