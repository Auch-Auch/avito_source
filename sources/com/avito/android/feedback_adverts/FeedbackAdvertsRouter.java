package com.avito.android.feedback_adverts;

import com.avito.android.remote.feedback.FeedbackAdvertItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/feedback_adverts/FeedbackAdvertsRouter;", "", "", "onAuthRequired", "()V", "closeScreen", "Lcom/avito/android/remote/feedback/FeedbackAdvertItem;", "item", "onAdvertSelected", "(Lcom/avito/android/remote/feedback/FeedbackAdvertItem;)V", "onBackButtonPressed", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface FeedbackAdvertsRouter {
    void closeScreen();

    void onAdvertSelected(@NotNull FeedbackAdvertItem feedbackAdvertItem);

    void onAuthRequired();

    void onBackButtonPressed();
}
