package com.avito.android.advert.item.questionnaire;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.advert_details.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert/item/questionnaire/QuestionnaireView;", "", "Lcom/avito/android/remote/model/Questionnaire$Question;", "question", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/Questionnaire$Answer;", "", "onSelected", "setQuestion", "(Lcom/avito/android/remote/model/Questionnaire$Question;Lkotlin/jvm/functions/Function1;)V", "Landroid/view/ViewGroup;", AuthSource.BOOKING_ORDER, "Landroid/view/ViewGroup;", "answerContainer", "Landroid/view/View;", "c", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "questionView", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class QuestionnaireView {
    public final TextView a;
    public final ViewGroup b;
    @NotNull
    public final View c;

    public QuestionnaireView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.c = view;
        View findViewById = view.findViewById(R.id.question);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.question)");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.answer_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.answer_container)");
        this.b = (ViewGroup) findViewById2;
    }

    @NotNull
    public final View getView() {
        return this.c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0088 A[LOOP:0: B:14:0x0082->B:16:0x0088, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setQuestion(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.Questionnaire.Question r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.avito.android.remote.model.Questionnaire.Answer, kotlin.Unit> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "question"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "onSelected"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = r9.getText()
            android.widget.TextView r1 = r8.a
            java.lang.CharSequence r1 = r1.getText()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0025
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0020
            r1 = 1
            goto L_0x0021
        L_0x0020:
            r1 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x0025
            r1 = 1
            goto L_0x0026
        L_0x0025:
            r1 = 0
        L_0x0026:
            android.widget.TextView r4 = r8.a
            r4.clearAnimation()
            if (r1 == 0) goto L_0x0070
            android.widget.TextView r1 = r8.a
            android.util.Property r4 = android.view.View.ALPHA
            r5 = 2
            float[] r6 = new float[r5]
            r6 = {x00be: FILL_ARRAY_DATA  , data: [1065353216, 0} // fill-array
            android.animation.ObjectAnimator r1 = android.animation.ObjectAnimator.ofFloat(r1, r4, r6)
            long r6 = com.avito.android.advert.item.questionnaire.QuestionnaireViewKt.access$getFADE_ANIMATION_DURATION$p()
            r1.setDuration(r6)
            android.widget.TextView r4 = r8.a
            android.util.Property r6 = android.view.View.ALPHA
            float[] r7 = new float[r5]
            r7 = {x00c6: FILL_ARRAY_DATA  , data: [0, 1065353216} // fill-array
            android.animation.ObjectAnimator r4 = android.animation.ObjectAnimator.ofFloat(r4, r6, r7)
            long r6 = com.avito.android.advert.item.questionnaire.QuestionnaireViewKt.access$getFADE_ANIMATION_DURATION$p()
            r4.setDuration(r6)
            com.avito.android.advert.item.questionnaire.QuestionnaireView$setQuestionText$$inlined$apply$lambda$1 r6 = new com.avito.android.advert.item.questionnaire.QuestionnaireView$setQuestionText$$inlined$apply$lambda$1
            r6.<init>(r0)
            r4.addListener(r6)
            android.animation.AnimatorSet r0 = new android.animation.AnimatorSet
            r0.<init>()
            android.animation.Animator[] r5 = new android.animation.Animator[r5]
            r5[r3] = r1
            r5[r2] = r4
            r0.playSequentially(r5)
            r0.start()
            goto L_0x0075
        L_0x0070:
            android.widget.TextView r1 = r8.a
            r1.setText(r0)
        L_0x0075:
            java.util.List r9 = r9.getAnswers()
            android.view.ViewGroup r0 = r8.b
            r0.removeAllViews()
            java.util.Iterator r9 = r9.iterator()
        L_0x0082:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x00bc
            java.lang.Object r0 = r9.next()
            com.avito.android.remote.model.Questionnaire$Answer r0 = (com.avito.android.remote.model.Questionnaire.Answer) r0
            android.view.View r1 = r8.c
            android.content.Context r1 = r1.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            int r2 = com.avito.android.advert_details.R.layout.advert_questionnaire_answer
            android.view.ViewGroup r4 = r8.b
            android.view.View r1 = r1.inflate(r2, r4, r3)
            java.lang.String r2 = "null cannot be cast to non-null type com.avito.android.lib.design.button.Button"
            java.util.Objects.requireNonNull(r1, r2)
            com.avito.android.lib.design.button.Button r1 = (com.avito.android.lib.design.button.Button) r1
            android.view.ViewGroup r2 = r8.b
            r2.addView(r1)
            java.lang.String r2 = r0.getText()
            r1.setText(r2)
            a2.a.a.f.x.y.e r2 = new a2.a.a.f.x.y.e
            r2.<init>(r0, r8, r10)
            r1.setOnClickListener(r2)
            goto L_0x0082
        L_0x00bc:
            return
            fill-array 0x00be: FILL_ARRAY_DATA  , data: [1065353216, 0]
            fill-array 0x00c6: FILL_ARRAY_DATA  , data: [0, 1065353216]
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.questionnaire.QuestionnaireView.setQuestion(com.avito.android.remote.model.Questionnaire$Question, kotlin.jvm.functions.Function1):void");
    }
}
