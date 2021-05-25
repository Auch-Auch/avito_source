package com.avito.android.rating.review_details.reply;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003H&¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003H&¢\u0006\u0004\b\u0013\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/avito/android/rating/review_details/reply/ReviewReplyView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "textChanges", "()Lio/reactivex/rxjava3/core/Observable;", "", "buttonClicks", "reply", "setReplyText", "(Ljava/lang/String;)V", "", "isLoading", "setLoading", "(Z)V", "message", "showErrorMessage", "hideErrorMessage", "()V", "showSnackbar", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface ReviewReplyView {
    @NotNull
    Observable<Unit> buttonClicks();

    void hideErrorMessage();

    void setLoading(boolean z);

    void setReplyText(@NotNull String str);

    void showErrorMessage(@NotNull String str);

    void showSnackbar(@NotNull String str);

    @NotNull
    Observable<String> textChanges();
}
