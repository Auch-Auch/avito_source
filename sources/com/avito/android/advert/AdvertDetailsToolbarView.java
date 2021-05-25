package com.avito.android.advert;

import androidx.annotation.StringRes;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\tJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH&¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH&¢\u0006\u0004\b\u0014\u0010\u0011J\u0019\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H&¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H&¢\u0006\u0004\b\u001c\u0010\u001aJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H&¢\u0006\u0004\b\u001d\u0010\u001aJ\u000f\u0010\u001e\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0002H&¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0002H&¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u000eH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u000eH&¢\u0006\u0004\b$\u0010\u0011¨\u0006%"}, d2 = {"Lcom/avito/android/advert/AdvertDetailsToolbarView;", "", "", "setupCollapsedToolbar", "()V", "setupExpandedToolbar", "", "title", "setToolbarTitle", "(Ljava/lang/String;)V", "setupToolbar", "setupUpButton", "message", "showMessage", "", "favorite", "setFavorite", "(Z)V", "visible", "setSharingVisible", "setAddNoteMenuItemVisible", "", "setAddNoteMenuItemTitle", "(I)V", "Lio/reactivex/rxjava3/core/Observable;", "favoriteButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "shareButtonClicks", "addNoteMenuItemClicks", "upButtonClicks", "showInfoBubble", "showWarningBubble", "detach", "getIsExpanded", "()Z", "isExpanded", "setupExpandedState", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsToolbarView {
    @NotNull
    Observable<Unit> addNoteMenuItemClicks();

    void detach();

    @NotNull
    Observable<Unit> favoriteButtonClicks();

    boolean getIsExpanded();

    void setAddNoteMenuItemTitle(@StringRes int i);

    void setAddNoteMenuItemVisible(boolean z);

    void setFavorite(boolean z);

    void setSharingVisible(boolean z);

    void setToolbarTitle(@NotNull String str);

    void setupCollapsedToolbar();

    void setupExpandedState(boolean z);

    void setupExpandedToolbar();

    void setupToolbar();

    void setupUpButton();

    @NotNull
    Observable<Unit> shareButtonClicks();

    void showInfoBubble();

    void showMessage(@NotNull String str);

    void showWarningBubble();

    @NotNull
    Observable<Unit> upButtonClicks();
}
