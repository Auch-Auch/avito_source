package com.avito.android.feedback_adverts;

import com.avito.android.feedback_adverts.FeedbackAdvertsItemPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.feedback.FeedbackAdvertItem;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemPresenterImpl;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemPresenter;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemView;", "view", "Lcom/avito/android/remote/feedback/FeedbackAdvertItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemView;Lcom/avito/android/remote/feedback/FeedbackAdvertItem;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "selectedItemId", "Ldagger/Lazy;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemPresenter$Listener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;Ljava/lang/String;)V", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class FeedbackAdvertsItemPresenterImpl implements FeedbackAdvertsItemPresenter {
    public final Lazy<FeedbackAdvertsItemPresenter.Listener> a;
    public final String b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FeedbackAdvertsItemPresenterImpl a;
        public final /* synthetic */ FeedbackAdvertItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FeedbackAdvertsItemPresenterImpl feedbackAdvertsItemPresenterImpl, FeedbackAdvertItem feedbackAdvertItem) {
            super(0);
            this.a = feedbackAdvertsItemPresenterImpl;
            this.b = feedbackAdvertItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((FeedbackAdvertsItemPresenter.Listener) this.a.a.get()).onAdvertClicked(this.b.getStringId());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public FeedbackAdvertsItemPresenterImpl(@NotNull Lazy<FeedbackAdvertsItemPresenter.Listener> lazy, @Nullable String str) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
        this.b = str;
    }

    public void bindView(@NotNull FeedbackAdvertsItemView feedbackAdvertsItemView, @NotNull FeedbackAdvertItem feedbackAdvertItem, int i) {
        Intrinsics.checkNotNullParameter(feedbackAdvertsItemView, "view");
        Intrinsics.checkNotNullParameter(feedbackAdvertItem, "item");
        feedbackAdvertsItemView.setTitle(feedbackAdvertItem.getTitle());
        feedbackAdvertsItemView.setPrice(feedbackAdvertItem.getPrice());
        feedbackAdvertsItemView.setOnItemClickListener(new a(this, feedbackAdvertItem));
        String str = this.b;
        feedbackAdvertsItemView.setSelected(str != null && Intrinsics.areEqual(str, feedbackAdvertItem.getStringId()));
    }
}
