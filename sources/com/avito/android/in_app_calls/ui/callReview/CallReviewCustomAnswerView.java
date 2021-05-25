package com.avito.android.in_app_calls.ui.callReview;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.avito.android.in_app_calls.R;
import com.avito.android.in_app_calls.ui.callReview.CallReviewAnswer;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.input.Input;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Keyboards;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewCustomAnswerView;", "Landroid/widget/FrameLayout;", "", "activate", "()V", "Lkotlin/Function1;", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", "getSendClickListener", "()Lkotlin/jvm/functions/Function1;", "setSendClickListener", "(Lkotlin/jvm/functions/Function1;)V", "sendClickListener", "Lcom/avito/android/lib/design/input/Input;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/input/Input;", "getInput", "()Lcom/avito/android/lib/design/input/Input;", "input", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallReviewCustomAnswerView extends FrameLayout {
    @Nullable
    public Function1<? super CallReviewAnswer, Unit> a;
    @NotNull
    public final Input b;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i != 0) {
                String str = null;
                if (i == 1) {
                    CallReviewAnswer.Companion companion = CallReviewAnswer.Companion;
                    Editable text = ((CallReviewCustomAnswerView) this.b).getInput().m90getText();
                    if (text != null) {
                        str = text.toString();
                    }
                    if (str == null) {
                        str = "";
                    }
                    CallReviewCustomAnswerView.access$onNewAnswer((CallReviewCustomAnswerView) this.b, companion.customAnswer(str));
                    return;
                }
                throw null;
            }
            CallReviewCustomAnswerView.access$onNewAnswer((CallReviewCustomAnswerView) this.b, CallReviewAnswer.Companion.noAnswer());
        }
    }

    @JvmOverloads
    public CallReviewCustomAnswerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public CallReviewCustomAnswerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallReviewCustomAnswerView(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void access$onNewAnswer(CallReviewCustomAnswerView callReviewCustomAnswerView, CallReviewAnswer callReviewAnswer) {
        Keyboards.hideKeyboard(callReviewCustomAnswerView.b, true);
        Function1<? super CallReviewAnswer, Unit> function1 = callReviewCustomAnswerView.a;
        if (function1 != null) {
            function1.invoke(callReviewAnswer);
        }
    }

    public final void activate() {
        this.b.showKeyboard();
    }

    @NotNull
    public final Input getInput() {
        return this.b;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.avito.android.in_app_calls.ui.callReview.CallReviewAnswer, kotlin.Unit>, kotlin.jvm.functions.Function1<com.avito.android.in_app_calls.ui.callReview.CallReviewAnswer, kotlin.Unit> */
    @Nullable
    public final Function1<CallReviewAnswer, Unit> getSendClickListener() {
        return this.a;
    }

    public final void setSendClickListener(@Nullable Function1<? super CallReviewAnswer, Unit> function1) {
        this.a = function1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CallReviewCustomAnswerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.call_review_custom_answer_view, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.call_review_close);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        ((ImageView) findViewById).setOnClickListener(new a(0, this));
        View findViewById2 = findViewById(R.id.call_review_answer);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        this.b = (Input) findViewById2;
        View findViewById3 = findViewById(R.id.call_review_send);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        ((Button) findViewById3).setOnClickListener(new a(1, this));
    }
}
