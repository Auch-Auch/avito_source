package com.avito.android.photo_view.blueprints;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.photo_view.ImageListPresenter;
import com.avito.android.photo_view.ImageListViewImpl;
import com.avito.android.photo_view.MainPhotoDecoration;
import com.avito.android.photo_view.PhotoUploaderPaddingDecoration;
import com.avito.android.photo_view.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/avito/android/photo_view/blueprints/MultiStatePhotoItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/photo_view/blueprints/MultiStatePhotoItemView;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "Lcom/avito/android/photo_view/ImageListPresenter;", "presenter", "attachPresenter", "(Lcom/avito/android/photo_view/ImageListPresenter;)V", "message", "setErrorState", "setWarningState", "setNormalState", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "u", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "container", "", "s", "I", "topPaddingWithTitle", "t", "topPaddingWithoutTitle", "Landroidx/recyclerview/widget/RecyclerView;", VKApiConst.VERSION, "Landroidx/recyclerview/widget/RecyclerView;", "imageListRoot", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public final class MultiStatePhotoItemViewHolder extends BaseViewHolder implements MultiStatePhotoItemView {
    public final int s;
    public final int t;
    public final ComponentContainer u;
    public final RecyclerView v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiStatePhotoItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = view.getResources().getDimensionPixelSize(R.dimen.photo_with_title_padding_top);
        this.t = view.getResources().getDimensionPixelSize(R.dimen.photo_without_title_padding_top);
        View findViewById = view.findViewById(R.id.photo_param_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.photo_param_container)");
        this.u = (ComponentContainer) findViewById;
        View findViewById2 = view.findViewById(R.id.image_list_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.v = recyclerView;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        recyclerView.addItemDecoration(new MainPhotoDecoration(context));
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        recyclerView.addItemDecoration(new PhotoUploaderPaddingDecoration(context2, 0, 0, 6, null));
    }

    @Override // com.avito.android.photo_view.blueprints.MultiStatePhotoItemView
    public void attachPresenter(@NotNull ImageListPresenter imageListPresenter) {
        Intrinsics.checkNotNullParameter(imageListPresenter, "presenter");
        imageListPresenter.attachView(new ImageListViewImpl(this.v, imageListPresenter));
    }

    @Override // com.avito.android.photo_view.blueprints.MultiStatePhotoItemView
    public void setErrorState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showErrorForAll$default(this.u, charSequence, null, 2, null);
    }

    @Override // com.avito.android.photo_view.blueprints.MultiStatePhotoItemView
    public void setNormalState(@Nullable CharSequence charSequence) {
        this.u.showNormalForAll(charSequence);
    }

    @Override // com.avito.android.photo_view.blueprints.MultiStatePhotoItemView
    public void setTitle(@Nullable CharSequence charSequence) {
        int i;
        this.u.setTitle(charSequence);
        if (charSequence == null || charSequence.length() == 0) {
            i = this.t;
        } else {
            i = this.s;
        }
        ComponentContainer componentContainer = this.u;
        componentContainer.setPadding(componentContainer.getPaddingLeft(), i, this.u.getPaddingRight(), this.u.getPaddingBottom());
    }

    @Override // com.avito.android.photo_view.blueprints.MultiStatePhotoItemView
    public void setWarningState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showWarningForAll$default(this.u, charSequence, null, 2, null);
    }
}
