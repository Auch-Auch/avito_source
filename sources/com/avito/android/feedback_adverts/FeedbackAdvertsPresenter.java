package com.avito.android.feedback_adverts;

import com.avito.android.feedback_adverts.FeedbackAdvertsItemPresenter;
import com.avito.android.feedback_adverts.FeedbackAdvertsView;
import com.avito.android.ui.adapter.AppendingListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenter;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsView$Callback;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemPresenter$Listener;", "Lcom/avito/android/ui/adapter/AppendingListener;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsView;", "view", "", "attachView", "(Lcom/avito/android/feedback_adverts/FeedbackAdvertsView;)V", "detachView", "()V", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsRouter;", "router", "attachRouter", "(Lcom/avito/android/feedback_adverts/FeedbackAdvertsRouter;)V", "detachRouter", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenterState;", "onSaveState", "()Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenterState;", "", "success", "onLoginComplete", "(Z)V", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface FeedbackAdvertsPresenter extends FeedbackAdvertsView.Callback, FeedbackAdvertsItemPresenter.Listener, AppendingListener {
    void attachRouter(@NotNull FeedbackAdvertsRouter feedbackAdvertsRouter);

    void attachView(@NotNull FeedbackAdvertsView feedbackAdvertsView);

    void detachRouter();

    void detachView();

    void onLoginComplete(boolean z);

    @NotNull
    FeedbackAdvertsPresenterState onSaveState();
}
