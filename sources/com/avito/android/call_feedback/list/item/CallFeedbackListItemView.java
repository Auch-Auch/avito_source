package com.avito.android.call_feedback.list.item;

import android.view.View;
import android.widget.TextView;
import com.avito.android.call_feedback.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001:\u0001\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000b\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setUnbindListener", "Impl", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
public interface CallFeedbackListItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull CallFeedbackListItemView callFeedbackListItemView) {
            ItemView.DefaultImpls.onUnbind(callFeedbackListItemView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0012¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000e\u0010\rR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0016\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001a\u001a\n \u0013*\u0004\u0018\u00010\u00170\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemView$Impl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemView;", "", "onUnbind", "()V", "", "title", "setTitle", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setUnbindListener", "u", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/View;", "kotlin.jvm.PlatformType", "s", "Landroid/view/View;", "containerView", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "titleView", "view", "<init>", "(Landroid/view/View;)V", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements CallFeedbackListItemView {
        public final View s;
        public final TextView t;
        public Function0<Unit> u;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ Function0 a;

            public a(Function0 function0) {
                this.a = function0;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.invoke();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.s = view.findViewById(R.id.container);
            this.t = (TextView) view.findViewById(R.id.title);
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            Function0<Unit> function0 = this.u;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // com.avito.android.call_feedback.list.item.CallFeedbackListItemView
        public void setClickListener(@Nullable Function0<Unit> function0) {
            if (function0 == null) {
                this.s.setOnClickListener(null);
            } else {
                this.s.setOnClickListener(new a(function0));
            }
        }

        @Override // com.avito.android.call_feedback.list.item.CallFeedbackListItemView
        public void setTitle(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            TextView textView = this.t;
            Intrinsics.checkNotNullExpressionValue(textView, "titleView");
            textView.setText(str);
        }

        @Override // com.avito.android.call_feedback.list.item.CallFeedbackListItemView
        public void setUnbindListener(@Nullable Function0<Unit> function0) {
            this.u = function0;
        }
    }

    void setClickListener(@Nullable Function0<Unit> function0);

    void setTitle(@NotNull String str);

    void setUnbindListener(@Nullable Function0<Unit> function0);
}
