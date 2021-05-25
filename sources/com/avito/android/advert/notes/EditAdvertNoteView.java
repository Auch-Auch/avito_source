package com.avito.android.advert.notes;

import androidx.annotation.StringRes;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.vk.sdk.api.model.VKAttachments;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert/notes/EditAdvertNoteView;", "", "", "startLoad", "()V", "", VKAttachments.TYPE_NOTE, "showData", "(Ljava/lang/String;)V", "showError", "showKeyboard", PlatformActions.HIDE_KEYBOARD, "", "isEnabled", "setMenuItemEnabled", "(Z)V", "", "text", "showToast", "(I)V", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/advert/notes/EditAdvertNoteScreenNavigation;", "getNavigationClick", "()Lio/reactivex/rxjava3/core/Observable;", "navigationClick", "getTextChanged", "textChanged", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface EditAdvertNoteView {
    @NotNull
    Observable<EditAdvertNoteScreenNavigation> getNavigationClick();

    @NotNull
    Observable<String> getTextChanged();

    void hideKeyboard();

    void setMenuItemEnabled(boolean z);

    void showData(@Nullable String str);

    void showError();

    void showKeyboard();

    void showToast(@StringRes int i);

    void startLoad();
}
