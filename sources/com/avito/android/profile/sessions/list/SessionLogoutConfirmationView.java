package com.avito.android.profile.sessions.list;

import com.avito.android.lib.design.snackbar.util.OptionalSnackbarElementView;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/profile/sessions/list/SessionLogoutConfirmationView;", "Lcom/avito/android/lib/design/snackbar/util/OptionalSnackbarElementView;", "", "description", "", "showConfirmationMenu", "(Ljava/lang/String;)V", "closeConfirmationMenu", "()V", "Lio/reactivex/rxjava3/core/Observable;", "getChangePasswordClicks", "()Lio/reactivex/rxjava3/core/Observable;", "changePasswordClicks", "getDismissEvents", "dismissEvents", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface SessionLogoutConfirmationView extends OptionalSnackbarElementView {
    void closeConfirmationMenu();

    @NotNull
    Observable<Unit> getChangePasswordClicks();

    @NotNull
    Observable<Unit> getDismissEvents();

    void showConfirmationMenu(@NotNull String str);
}
