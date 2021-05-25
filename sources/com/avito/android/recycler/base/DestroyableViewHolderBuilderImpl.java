package com.avito.android.recycler.base;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0004\b\u0018\u0010\u0019J5\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/recycler/base/DestroyableViewHolderBuilderImpl;", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lkotlin/Function1;", "Landroid/view/View;", "inflateFunc", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "buildViewHolder", "(Landroid/view/ViewGroup;ILkotlin/jvm/functions/Function1;)Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "destroy", "()V", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "delegate", "", "Lcom/avito/android/recycler/base/DestroyableViewHolder;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "list", "<init>", "(Lcom/avito/konveyor/blueprint/ViewHolderBuilder;)V", "recycler_release"}, k = 1, mv = {1, 4, 2})
public final class DestroyableViewHolderBuilderImpl implements DestroyableViewHolderBuilder {
    public final List<DestroyableViewHolder> a = new ArrayList();
    public final ViewHolderBuilder<BaseViewHolder> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.konveyor.blueprint.ViewHolderBuilder<? extends com.avito.konveyor.adapter.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public DestroyableViewHolderBuilderImpl(@NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder) {
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "delegate");
        this.b = viewHolderBuilder;
    }

    @Override // com.avito.konveyor.blueprint.ViewHolderBuilder
    @Nullable
    public BaseViewHolder buildViewHolder(@NotNull ViewGroup viewGroup, int i, @NotNull Function1<? super Integer, ? extends View> function1) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(function1, "inflateFunc");
        BaseViewHolder buildViewHolder = this.b.buildViewHolder(viewGroup, i, function1);
        if (buildViewHolder instanceof DestroyableViewHolder) {
            this.a.add(buildViewHolder);
        }
        return buildViewHolder;
    }

    @Override // com.avito.android.recycler.base.DestroyableViewHolderBuilder
    public void destroy() {
        List<DestroyableViewHolder> list = this.a;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        list.clear();
    }
}
