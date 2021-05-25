package com.avito.android.select;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H&¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\fH&¢\u0006\u0004\b\u0014\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H&¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0004J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0017\u0010\u000fJ\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\fH&¢\u0006\u0004\b\u0019\u0010\u000fJ\u000f\u0010\u001a\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u0004R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001dR\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001dR\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001d¨\u0006)"}, d2 = {"Lcom/avito/android/select/SelectDialogView;", "Lcom/avito/android/select/SelectVariantsView;", "", "clearSearchTextAndHideKeyboard", "()V", "", "isVisible", "setExitSearchButtonVisibility", "(Z)V", "showSearchView", "requestSearchViewFocus", "hideSearchView", "", "title", "showSubmitButton", "(Ljava/lang/String;)V", "enabled", "setSubmitButtonEnabled", "hideSubmitButton", "actionTitle", "showClearAction", "setClearActionEnabled", "hideClearAction", "setTitle", "text", "setSearchText", PlatformActions.HIDE_KEYBOARD, "Lio/reactivex/rxjava3/core/Observable;", "getMainButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "mainButtonClicks", "getSearchTextChanges", "searchTextChanges", "getClearSearchEvents", "clearSearchEvents", "getClearButtonClicks", "clearButtonClicks", "getBackClickEvents", "backClickEvents", "getSearchActiveEvents", "searchActiveEvents", "select_release"}, k = 1, mv = {1, 4, 2})
public interface SelectDialogView extends SelectVariantsView {
    void clearSearchTextAndHideKeyboard();

    @NotNull
    Observable<Unit> getBackClickEvents();

    @NotNull
    Observable<Unit> getClearButtonClicks();

    @NotNull
    Observable<Unit> getClearSearchEvents();

    @NotNull
    Observable<Unit> getMainButtonClicks();

    @NotNull
    Observable<Boolean> getSearchActiveEvents();

    @NotNull
    Observable<String> getSearchTextChanges();

    void hideClearAction();

    void hideKeyboard();

    void hideSearchView();

    void hideSubmitButton();

    void requestSearchViewFocus();

    void setClearActionEnabled(boolean z);

    void setExitSearchButtonVisibility(boolean z);

    void setSearchText(@NotNull String str);

    void setSubmitButtonEnabled(boolean z);

    void setTitle(@NotNull String str);

    void showClearAction(@NotNull String str);

    void showSearchView();

    void showSubmitButton(@NotNull String str);
}
