package com.avito.android.rating.publish.radio_select;

import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H&¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0003H&¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H&¢\u0006\u0004\b\u0018\u0010\rJ\u000f\u0010\u0019\u001a\u00020\u0003H&¢\u0006\u0004\b\u0019\u0010\rJ\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0014H&¢\u0006\u0004\b\u001b\u0010\u0017J\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\bH&¢\u0006\u0004\b\u001d\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/rating/publish/radio_select/RadioSelectView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "retryClicks", "continueClicks", "", "message", "showError", "(Ljava/lang/String;)V", "showProgress", "()V", "hideProgress", "notifyItemsChanged", "", VKApiConst.POSITION, "notifyItemChanged", "(I)V", "", "isEnabled", "setButtonEnabled", "(Z)V", "showContinueButton", "showSendButton", "isLoading", "showLoadingState", "title", "setTitle", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface RadioSelectView {
    @NotNull
    Observable<Unit> continueClicks();

    void hideProgress();

    @NotNull
    Observable<Unit> navigationClicks();

    void notifyItemChanged(int i);

    void notifyItemsChanged();

    @NotNull
    Observable<Unit> retryClicks();

    void setButtonEnabled(boolean z);

    void setTitle(@NotNull String str);

    void showContinueButton();

    void showError(@NotNull String str);

    void showLoadingState(boolean z);

    void showProgress();

    void showSendButton();
}
