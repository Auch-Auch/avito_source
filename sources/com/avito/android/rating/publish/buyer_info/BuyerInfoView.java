package com.avito.android.rating.publish.buyer_info;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H&¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H&¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u0003H&¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/rating/publish/buyer_info/BuyerInfoView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "text", "setText", "(Ljava/lang/String;)V", "textChanges", PlatformActions.HIDE_KEYBOARD, "()V", "showKeyboard", "buttonClicks", "showContinueButton", "showSendButton", "", "isLoading", "showLoadingState", "(Z)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface BuyerInfoView {
    @NotNull
    Observable<Unit> buttonClicks();

    void hideKeyboard();

    @NotNull
    Observable<Unit> navigationClicks();

    void setText(@NotNull String str);

    void showContinueButton();

    void showKeyboard();

    void showLoadingState(boolean z);

    void showSendButton();

    @NotNull
    Observable<String> textChanges();
}
