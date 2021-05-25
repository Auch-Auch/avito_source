package com.avito.android.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0019¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001e\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/category/CategoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/category/BaseViewHolderImpl;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/avito/android/category/BaseViewHolderImpl;", "holder", VKApiConst.POSITION, "", "onBindViewHolder", "(Lcom/avito/android/category/BaseViewHolderImpl;I)V", "", "getItemId", "(I)J", "getItemCount", "()I", "getItemViewType", "(I)I", "layoutId", "Landroid/view/View;", AuthSource.SEND_ABUSE, "(Landroid/view/ViewGroup;I)Landroid/view/View;", "Lcom/avito/android/category/CategoryItemPresenter;", "c", "Lcom/avito/android/category/CategoryItemPresenter;", "getPresenter", "()Lcom/avito/android/category/CategoryItemPresenter;", "presenter", "<init>", "(Lcom/avito/android/category/CategoryItemPresenter;)V", "category_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryAdapter extends RecyclerView.Adapter<BaseViewHolderImpl> {
    @NotNull
    public final CategoryItemPresenter c;

    public CategoryAdapter(@NotNull CategoryItemPresenter categoryItemPresenter) {
        Intrinsics.checkNotNullParameter(categoryItemPresenter, "presenter");
        this.c = categoryItemPresenter;
    }

    public final View a(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : null).inflate(i, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(pare…(layoutId, parent, false)");
        return inflate;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.getCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.c.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.c.getItemViewType(i);
    }

    @NotNull
    public final CategoryItemPresenter getPresenter() {
        return this.c;
    }

    public void onBindViewHolder(@NotNull BaseViewHolderImpl baseViewHolderImpl, int i) {
        Intrinsics.checkNotNullParameter(baseViewHolderImpl, "holder");
        this.c.bindView(baseViewHolderImpl, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public BaseViewHolderImpl onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            return new HeaderViewHolderImpl(a(viewGroup, R.layout.item_category_header));
        }
        if (i == 1) {
            return new CategoryViewHolderImpl(a(viewGroup, R.layout.item_category));
        }
        if (i == 2) {
            return new SubcategoryViewHolderImpl(a(viewGroup, R.layout.item_subcategory));
        }
        if (i == 3) {
            return new ShopsViewHolderImpl(a(viewGroup, R.layout.item_category_shops));
        }
        throw new IllegalArgumentException("This viewType is not supported!");
    }
}
