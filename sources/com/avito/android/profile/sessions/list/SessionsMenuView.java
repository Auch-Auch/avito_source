package com.avito.android.profile.sessions.list;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.snackbar.util.OptionalSnackbarElementView;
import com.avito.android.profile.sessions.adapter.session.SessionItem;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/avito/android/profile/sessions/list/SessionsMenuView;", "Lcom/avito/android/lib/design/snackbar/util/OptionalSnackbarElementView;", "", "Lcom/avito/android/profile/sessions/adapter/session/SessionItem$Action;", "actions", "", "showMenu", "(Ljava/util/List;)V", "closeMenu", "()V", "", "isInProgress", "showLogoutInProgress", "(Z)V", "isShowing", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getActionClicks", "()Lio/reactivex/rxjava3/core/Observable;", "actionClicks", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface SessionsMenuView extends OptionalSnackbarElementView {
    void closeMenu();

    @NotNull
    Observable<DeepLink> getActionClicks();

    boolean isShowing();

    void showLogoutInProgress(boolean z);

    void showMenu(@NotNull List<SessionItem.Action> list);
}
