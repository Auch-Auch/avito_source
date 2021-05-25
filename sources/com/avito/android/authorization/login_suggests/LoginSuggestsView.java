package com.avito.android.authorization.login_suggests;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H&¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0005H&¢\u0006\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/authorization/login_suggests/LoginSuggestsView;", "", "", "", "indexes", "", "setDividers", "(Ljava/lang/Iterable;)V", "Lio/reactivex/Observable;", "navigationClicks", "()Lio/reactivex/Observable;", "notifyItemsChanged", "()V", "", "message", "showSnackbar", "(Ljava/lang/String;)V", "close", "open", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface LoginSuggestsView {
    void close();

    @NotNull
    Observable<Unit> navigationClicks();

    void notifyItemsChanged();

    void open();

    void setDividers(@NotNull Iterable<Integer> iterable);

    void showSnackbar(@NotNull String str);
}
