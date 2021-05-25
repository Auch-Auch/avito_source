package defpackage;

import com.avito.android.in_app_calls.ui.callReview.CallReviewAnswer;
import com.avito.android.in_app_calls.ui.callReview.CallReviewFragment;
import com.avito.android.in_app_calls.ui.callReview.CallReviewPresenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: s4  reason: default package */
public final class s4 extends Lambda implements Function1<CallReviewAnswer, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s4(int i, Object obj) {
        super(1);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(CallReviewAnswer callReviewAnswer) {
        int i = this.a;
        if (i == 0) {
            CallReviewAnswer callReviewAnswer2 = callReviewAnswer;
            Intrinsics.checkNotNullParameter(callReviewAnswer2, "reason");
            if (callReviewAnswer2.isCustom()) {
                ((CallReviewFragment) this.b).getPresenter().onTypeChanged(CallReviewPresenter.CallReviewAnswerType.CUSTOM);
            } else {
                ((CallReviewFragment) this.b).getPresenter().onAnswerSelected(callReviewAnswer2);
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            CallReviewAnswer callReviewAnswer3 = callReviewAnswer;
            Intrinsics.checkNotNullParameter(callReviewAnswer3, "it");
            ((CallReviewFragment) this.b).getPresenter().onAnswerSelected(callReviewAnswer3);
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
