package com.avito.android.call_feedback.list.title;

import android.view.View;
import android.widget.TextView;
import com.avito.android.call_feedback.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitleView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Impl", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
public interface CallFeedbackListTitleView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull CallFeedbackListTitleView callFeedbackListTitleView) {
            ItemView.DefaultImpls.onUnbind(callFeedbackListTitleView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitleView$Impl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitleView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "s", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements CallFeedbackListTitleView {
        public final TextView s;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.s = (TextView) view.findViewById(R.id.title);
        }

        @Override // com.avito.android.call_feedback.list.title.CallFeedbackListTitleView
        public void setTitle(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            TextView textView = this.s;
            Intrinsics.checkNotNullExpressionValue(textView, "titleView");
            textView.setText(str);
        }
    }

    void setTitle(@NotNull String str);
}
