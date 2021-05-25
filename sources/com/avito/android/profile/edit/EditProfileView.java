package com.avito.android.profile.edit;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u001d\u0010\f\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0015\u0010\u0005J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0003H&¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0003H&¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0003H&¢\u0006\u0004\b\u0019\u0010\u0014J\u000f\u0010\u001a\u001a\u00020\u0003H&¢\u0006\u0004\b\u001a\u0010\u0014J\u000f\u0010\u001b\u001a\u00020\u0003H&¢\u0006\u0004\b\u001b\u0010\u0014J\u0017\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H&¢\u0006\u0004\b \u0010\u0014J\u0017\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u000eH&¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/avito/android/profile/edit/EditProfileView;", "", "Lio/reactivex/Observable;", "", "navigationClicks", "()Lio/reactivex/Observable;", "takePhotoClicks", "deleteAvatarClicks", "pickerEmptySpaceClicks", "", "", "indexes", "setDividers", "(Ljava/lang/Iterable;)V", "", "deleteButtonVisible", "animate", "showAvatarPicker", "(ZZ)V", "hideAvatarPicker", "()V", "saveClicks", "refreshClicks", PlatformActions.HIDE_KEYBOARD, "showContent", "showProgress", "showSavingProgress", "showAvatarError", "", "error", "showSavingError", "(Ljava/lang/String;)V", "showError", "enabled", "setSaveEnabled", "(Z)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface EditProfileView {
    @NotNull
    Observable<Unit> deleteAvatarClicks();

    void hideAvatarPicker();

    void hideKeyboard();

    @NotNull
    Observable<Unit> navigationClicks();

    @NotNull
    Observable<Unit> pickerEmptySpaceClicks();

    @NotNull
    Observable<Unit> refreshClicks();

    @NotNull
    Observable<Unit> saveClicks();

    void setDividers(@NotNull Iterable<Integer> iterable);

    void setSaveEnabled(boolean z);

    void showAvatarError();

    void showAvatarPicker(boolean z, boolean z2);

    void showContent();

    void showError();

    void showProgress();

    void showSavingError(@NotNull String str);

    void showSavingProgress();

    @NotNull
    Observable<Unit> takePhotoClicks();
}
