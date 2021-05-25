package com.avito.android.advert.closed;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert/closed/ClosedAdvertView;", "", "", "setupToolbar", "()V", "", "message", "showMessage", "(Ljava/lang/String;)V", "", "visible", "setFavoriteVisible", "(Z)V", "Lio/reactivex/rxjava3/core/Observable;", "favoriteButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "upButtonClicks", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface ClosedAdvertView {
    @NotNull
    Observable<Unit> favoriteButtonClicks();

    void setFavoriteVisible(boolean z);

    void setupToolbar();

    void showMessage(@NotNull String str);

    @NotNull
    Observable<Unit> upButtonClicks();
}
