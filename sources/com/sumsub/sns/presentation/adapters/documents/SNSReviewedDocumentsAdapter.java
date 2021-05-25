package com.sumsub.sns.presentation.adapters.documents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.sumsub.sns.R;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.DocumentType;
import com.sumsub.sns.core.data.model.ReviewAnswerType;
import com.sumsub.sns.core.presentation.base.adapter.SNSBaseRecyclerAdapter;
import com.sumsub.sns.core.presentation.base.adapter.SNSBaseRecyclerViewHolder;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0017B\u001b\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u00020\u000e2\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/presentation/adapters/documents/SNSReviewedDocumentsAdapter;", "Lcom/sumsub/sns/core/presentation/base/adapter/SNSBaseRecyclerAdapter;", "Lcom/sumsub/sns/core/data/model/Document;", "Lcom/sumsub/sns/presentation/adapters/documents/SNSReviewedDocumentsAdapter$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/sumsub/sns/presentation/adapters/documents/SNSReviewedDocumentsAdapter$ViewHolder;", VKApiConst.POSITION, "getItemViewType", "(I)I", "holder", "", "onBindViewHolder", "(Lcom/sumsub/sns/presentation/adapters/documents/SNSReviewedDocumentsAdapter$ViewHolder;I)V", "Lkotlin/Function1;", "d", "Lkotlin/jvm/functions/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lkotlin/jvm/functions/Function1;)V", "ViewHolder", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSReviewedDocumentsAdapter extends SNSBaseRecyclerAdapter<Document, ViewHolder> {
    public final Function1<Document, Unit> d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 ¨\u0006("}, d2 = {"Lcom/sumsub/sns/presentation/adapters/documents/SNSReviewedDocumentsAdapter$ViewHolder;", "Lcom/sumsub/sns/core/presentation/base/adapter/SNSBaseRecyclerViewHolder;", "Lcom/sumsub/sns/core/data/model/Document;", "item", "", "itemCount", "", "bind", "(Lcom/sumsub/sns/core/data/model/Document;I)V", "Landroid/widget/TextView;", "tvType", "Landroid/widget/TextView;", "getTvType", "()Landroid/widget/TextView;", "setTvType", "(Landroid/widget/TextView;)V", "Landroid/view/ViewGroup;", "vgRoot", "Landroid/view/ViewGroup;", "getVgRoot", "()Landroid/view/ViewGroup;", "setVgRoot", "(Landroid/view/ViewGroup;)V", "tvStatus", "getTvStatus", "setTvStatus", "Landroid/widget/ImageView;", "ivOpen", "Landroid/widget/ImageView;", "getIvOpen", "()Landroid/widget/ImageView;", "setIvOpen", "(Landroid/widget/ImageView;)V", "ivStatus", "getIvStatus", "setIvStatus", "Landroid/view/View;", "itemView", "<init>", "(Lcom/sumsub/sns/presentation/adapters/documents/SNSReviewedDocumentsAdapter;Landroid/view/View;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public final class ViewHolder extends SNSBaseRecyclerViewHolder<Document> {
        @BindView(2239)
        public ImageView ivOpen;
        @BindView(2243)
        public ImageView ivStatus;
        public final /* synthetic */ SNSReviewedDocumentsAdapter s;
        @BindView(2480)
        public TextView tvStatus;
        @BindView(2484)
        public TextView tvType;
        @BindView(2500)
        public ViewGroup vgRoot;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                ReviewAnswerType.values();
                int[] iArr = new int[3];
                $EnumSwitchMapping$0 = iArr;
                ReviewAnswerType reviewAnswerType = ReviewAnswerType.Green;
                iArr[0] = 1;
                ReviewAnswerType reviewAnswerType2 = ReviewAnswerType.Red;
                iArr[1] = 2;
            }
        }

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ ViewHolder a;
            public final /* synthetic */ Document b;

            public a(ViewHolder viewHolder, Document document) {
                this.a = viewHolder;
                this.b = document;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.s.d.invoke(this.b);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull SNSReviewedDocumentsAdapter sNSReviewedDocumentsAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.s = sNSReviewedDocumentsAdapter;
        }

        @NotNull
        public final ImageView getIvOpen() {
            ImageView imageView = this.ivOpen;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivOpen");
            }
            return imageView;
        }

        @NotNull
        public final ImageView getIvStatus() {
            ImageView imageView = this.ivStatus;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivStatus");
            }
            return imageView;
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

        @NotNull
        public final ViewGroup getVgRoot() {
            ViewGroup viewGroup = this.vgRoot;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vgRoot");
            }
            return viewGroup;
        }

        public final void setIvOpen(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.ivOpen = imageView;
        }

        public final void setIvStatus(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.ivStatus = imageView;
        }

        public final void setTvStatus(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvStatus = textView;
        }

        public final void setTvType(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvType = textView;
        }

        public final void setVgRoot(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.vgRoot = viewGroup;
        }

        public void bind(@NotNull Document document, int i) {
            String str;
            Intrinsics.checkNotNullParameter(document, "item");
            String str2 = null;
            if (document.isReviewing()) {
                TextView textView = this.tvStatus;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
                }
                TextView textView2 = this.tvStatus;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
                }
                Context context = textView2.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "tvStatus.context");
                textView.setText(ExtensionsKt.getStringResource$default(context, R.string.sns_iddoc_status_submitted, (String) null, 2, (Object) null));
            } else {
                Document.Result.Review review = document.getReview();
                ReviewAnswerType answer = review != null ? review.getAnswer() : null;
                if (answer != null) {
                    int ordinal = answer.ordinal();
                    if (ordinal != 0) {
                        boolean z = true;
                        if (ordinal == 1) {
                            String moderationComment = review.getModerationComment();
                            if (moderationComment != null) {
                                int lastIndex = StringsKt__StringsKt.getLastIndex(moderationComment);
                                while (true) {
                                    if (lastIndex < 0) {
                                        str = "";
                                        break;
                                    }
                                    if (!(moderationComment.charAt(lastIndex) == '\n')) {
                                        str = moderationComment.substring(0, lastIndex + 1);
                                        Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                        break;
                                    }
                                    lastIndex--;
                                }
                                if (str != null) {
                                    str2 = StringsKt__StringsKt.trim(str).toString();
                                }
                            }
                            TextView textView3 = this.tvStatus;
                            if (textView3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
                            }
                            textView3.setText(str2);
                            TextView textView4 = this.tvStatus;
                            if (textView4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
                            }
                            if (!(str2 == null || str2.length() == 0)) {
                                z = false;
                            }
                            textView4.setVisibility(z ? 8 : 0);
                            ImageView imageView = this.ivOpen;
                            if (imageView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("ivOpen");
                            }
                            imageView.setVisibility(0);
                        }
                    } else {
                        TextView textView5 = this.tvStatus;
                        if (textView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
                        }
                        textView5.setText((CharSequence) null);
                    }
                }
                TextView textView6 = this.tvStatus;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
                }
                TextView textView7 = this.tvStatus;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
                }
                Context context2 = textView7.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "tvStatus.context");
                textView6.setText(ExtensionsKt.getStringResource$default(context2, R.string.sns_iddoc_status_notSubmitted, (String) null, 2, (Object) null));
            }
            DocumentType type = document.getType();
            TextView textView8 = this.tvType;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvType");
            }
            textView8.setText(type.getTitle(getContext()));
            this.itemView.setOnClickListener(new a(this, document));
        }
    }

    public final class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.vgRoot = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.vg_root, "field 'vgRoot'", ViewGroup.class);
            viewHolder.ivStatus = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_status, "field 'ivStatus'", ImageView.class);
            viewHolder.tvStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_status, "field 'tvStatus'", TextView.class);
            viewHolder.tvType = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_type, "field 'tvType'", TextView.class);
            viewHolder.ivOpen = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_open, "field 'ivOpen'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder != null) {
                this.a = null;
                viewHolder.vgRoot = null;
                viewHolder.ivStatus = null;
                viewHolder.tvStatus = null;
                viewHolder.tvType = null;
                viewHolder.ivOpen = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super com.sumsub.sns.core.data.model.Document, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public SNSReviewedDocumentsAdapter(@NotNull Function1<? super Document, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        Document.Result.Review review;
        Document.Result.Review review2;
        Document document = (Document) getItem(i);
        if (document != null && document.isReviewing()) {
            return R.layout.sns_item_document_submitted;
        }
        ReviewAnswerType reviewAnswerType = null;
        if (((document == null || (review2 = document.getReview()) == null) ? null : review2.getAnswer()) == ReviewAnswerType.Red) {
            return R.layout.sns_item_document_reviewed_red;
        }
        if (!(document == null || (review = document.getReview()) == null)) {
            reviewAnswerType = review.getAnswer();
        }
        if (reviewAnswerType == ReviewAnswerType.Green) {
            return R.layout.sns_item_document_reviewed_green;
        }
        return R.layout.sns_item_document_reviewed_red;
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
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(viewType, parent, false)");
        return new ViewHolder(this, inflate);
    }
}
