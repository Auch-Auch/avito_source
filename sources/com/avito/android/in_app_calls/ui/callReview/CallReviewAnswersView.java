package com.avito.android.in_app_calls.ui.callReview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ViewSizeKt;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J%\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R0\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswersView;", "Landroid/widget/FrameLayout;", "", "titleRes", "", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewItem;", "items", "", "bind", "(ILjava/util/List;)V", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "answersHeader", "Landroid/view/ViewGroup;", AuthSource.SEND_ABUSE, "Landroid/view/ViewGroup;", "answersContainer", "Lkotlin/Function1;", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", "c", "Lkotlin/jvm/functions/Function1;", "getAnswerSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setAnswerSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "answerSelectedListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallReviewAnswersView extends FrameLayout {
    public final ViewGroup a;
    public final TextView b;
    @Nullable
    public Function1<? super CallReviewAnswer, Unit> c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ CallReviewAnswersView a;

        public a(CallReviewAnswersView callReviewAnswersView) {
            this.a = callReviewAnswersView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1<CallReviewAnswer, Unit> answerSelectedListener = this.a.getAnswerSelectedListener();
            if (answerSelectedListener != null) {
                answerSelectedListener.invoke(CallReviewAnswer.Companion.noAnswer());
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CallReviewItem a;
        public final /* synthetic */ CallReviewAnswersView b;

        public b(CallReviewItem callReviewItem, CallReviewAnswersView callReviewAnswersView, LinearLayout.LayoutParams layoutParams) {
            this.a = callReviewItem;
            this.b = callReviewAnswersView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1<CallReviewAnswer, Unit> answerSelectedListener = this.b.getAnswerSelectedListener();
            if (answerSelectedListener != null) {
                answerSelectedListener.invoke(this.a.getAnswer());
            }
        }
    }

    @JvmOverloads
    public CallReviewAnswersView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public CallReviewAnswersView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallReviewAnswersView(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void bind(@StringRes int i, @NotNull List<CallReviewItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.b.setText(i);
        this.a.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ViewSizeKt.getDp(48));
        layoutParams.setMargins(0, ViewSizeKt.getDp(10), 0, 0);
        for (T t : list) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Button button = new Button(context, null, R.attr.buttonDefaultInverseMedium);
            button.setText(t.getTitle());
            button.setOnClickListener(new b(t, this, layoutParams));
            button.setLayoutParams(layoutParams);
            this.a.addView(button);
        }
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.avito.android.in_app_calls.ui.callReview.CallReviewAnswer, kotlin.Unit>, kotlin.jvm.functions.Function1<com.avito.android.in_app_calls.ui.callReview.CallReviewAnswer, kotlin.Unit> */
    @Nullable
    public final Function1<CallReviewAnswer, Unit> getAnswerSelectedListener() {
        return this.c;
    }

    public final void setAnswerSelectedListener(@Nullable Function1<? super CallReviewAnswer, Unit> function1) {
        this.c = function1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CallReviewAnswersView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(com.avito.android.in_app_calls.R.layout.call_review_answers_view, (ViewGroup) this, true);
        View findViewById = findViewById(com.avito.android.in_app_calls.R.id.call_review_answers_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        this.a = (ViewGroup) findViewById;
        View findViewById2 = findViewById(com.avito.android.in_app_calls.R.id.call_review_header);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = findViewById(com.avito.android.in_app_calls.R.id.call_review_close);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        ((ImageView) findViewById3).setOnClickListener(new a(this));
    }
}
