package com.avito.android.rating.publish.review_input;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.abuse.AbuseSendingResult;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H&¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H&¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b\u0013\u0010\fJ\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000eH&¢\u0006\u0004\b\u0015\u0010\u0011J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000eH&¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000eH&¢\u0006\u0004\b\u0019\u0010\u0011J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002H&¢\u0006\u0004\b\u001a\u0010\u0005J\u0019\u0010\u001c\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u001c\u0010\u0011J\u000f\u0010\u001d\u001a\u00020\u0003H&¢\u0006\u0004\b\u001d\u0010\fJ\u000f\u0010\u001e\u001a\u00020\u0003H&¢\u0006\u0004\b\u001e\u0010\fJ\u000f\u0010\u001f\u001a\u00020\u0003H&¢\u0006\u0004\b\u001f\u0010\fJ\u0017\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0007H&¢\u0006\u0004\b!\u0010\n¨\u0006\""}, d2 = {"Lcom/avito/android/rating/publish/review_input/ReviewInputView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "buttonClicks", "", "isEnabled", "setButtonEnabled", "(Z)V", "showContinueButton", "()V", "showSendButton", "", "title", "setTitle", "(Ljava/lang/String;)V", "showDescription", "hideDescription", "description", "setDescription", InternalConstsKt.PLACEHOLDER, "setPlaceholder", AbuseSendingResult.COMMENT, "setComment", "commentChanges", "message", "setCommentError", "hideCommentError", PlatformActions.HIDE_KEYBOARD, "showKeyboard", "isLoading", "showLoadingState", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface ReviewInputView {
    @NotNull
    Observable<Unit> buttonClicks();

    @NotNull
    Observable<String> commentChanges();

    void hideCommentError();

    void hideDescription();

    void hideKeyboard();

    @NotNull
    Observable<Unit> navigationClicks();

    void setButtonEnabled(boolean z);

    void setComment(@NotNull String str);

    void setCommentError(@Nullable String str);

    void setDescription(@NotNull String str);

    void setPlaceholder(@NotNull String str);

    void setTitle(@NotNull String str);

    void showContinueButton();

    void showDescription();

    void showKeyboard();

    void showLoadingState(boolean z);

    void showSendButton();
}
