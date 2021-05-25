package com.sumsub.sns.presentation.adapters.documents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumsub.sns.R;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.presentation.base.adapter.SNSBaseRecyclerAdapter;
import com.sumsub.sns.core.presentation.base.adapter.SNSBaseRecyclerViewHolder;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/presentation/adapters/documents/SNSReviewingDocumentsAdapter;", "Lcom/sumsub/sns/core/presentation/base/adapter/SNSBaseRecyclerAdapter;", "Lcom/sumsub/sns/core/data/model/Document;", "Lcom/sumsub/sns/presentation/adapters/documents/SNSReviewingDocumentsAdapter$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/sumsub/sns/presentation/adapters/documents/SNSReviewingDocumentsAdapter$ViewHolder;", "holder", VKApiConst.POSITION, "", "onBindViewHolder", "(Lcom/sumsub/sns/presentation/adapters/documents/SNSReviewingDocumentsAdapter$ViewHolder;I)V", "<init>", "()V", "ViewHolder", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSReviewingDocumentsAdapter extends SNSBaseRecyclerAdapter<Document, ViewHolder> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/sumsub/sns/presentation/adapters/documents/SNSReviewingDocumentsAdapter$ViewHolder;", "Lcom/sumsub/sns/core/presentation/base/adapter/SNSBaseRecyclerViewHolder;", "Lcom/sumsub/sns/core/data/model/Document;", "item", "", "itemCount", "", "bind", "(Lcom/sumsub/sns/core/data/model/Document;I)V", "Landroid/widget/TextView;", "tvStatus", "Landroid/widget/TextView;", "getTvStatus", "()Landroid/widget/TextView;", "setTvStatus", "(Landroid/widget/TextView;)V", "tvType", "getTvType", "setTvType", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolder extends SNSBaseRecyclerViewHolder<Document> {
        @BindView(2480)
        public TextView tvStatus;
        @BindView(2484)
        public TextView tvType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }

        @NotNull
        public final TextView getTvStatus() {
            TextView textView = this.tvStatus;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
            }
            return textView;
        }

        @NotNull
        public final TextView getTvType() {
            TextView textView = this.tvType;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvType");
            }
            return textView;
        }

        public final void setTvStatus(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvStatus = textView;
        }

        public final void setTvType(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvType = textView;
        }

        public void bind(@NotNull Document document, int i) {
            Intrinsics.checkNotNullParameter(document, "item");
            TextView textView = this.tvType;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvType");
            }
            textView.setText(document.getType().getTitle(getContext()));
            TextView textView2 = this.tvStatus;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
            }
            textView2.setText(ExtensionsKt.getStringResource$default(getContext(), R.string.sns_iddoc_status_reviewing, (String) null, 2, (Object) null));
        }
    }

    public final class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.tvType = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_type, "field 'tvType'", TextView.class);
            viewHolder.tvStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_status, "field 'tvStatus'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder != null) {
                this.a = null;
                viewHolder.tvType = null;
                viewHolder.tvStatus = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Document document = (Document) getItem(i);
        if (document != null) {
            SNSBaseRecyclerViewHolder.bind$default(viewHolder, document, 0, 2, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sns_item_document_reviewing, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…reviewing, parent, false)");
        return new ViewHolder(inflate);
    }
}
