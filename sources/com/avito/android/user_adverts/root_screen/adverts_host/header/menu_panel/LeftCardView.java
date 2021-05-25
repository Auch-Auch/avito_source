package com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel;

import com.avito.android.user_adverts.root_screen.adverts_host.header.CardData;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\bR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/LeftCardView;", "", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "data", "", "setLeftCardContent", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;)V", "setLeftCardLoading", "()V", "", "text", "showSoaUpdateProgress", "(Ljava/lang/String;)V", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "onDismissClickTarget", "showLeftCardTooltip", "(Ljava/lang/String;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;)V", "collapseSoaUpdateProgress", "Lio/reactivex/Observable;", "getSoaProgressCollapsedEvents", "()Lio/reactivex/Observable;", "soaProgressCollapsedEvents", "getLeftCardClicks", "leftCardClicks", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface LeftCardView {
    void collapseSoaUpdateProgress();

    @NotNull
    Observable<ProfileHeaderView.ClickTarget> getLeftCardClicks();

    @NotNull
    Observable<Unit> getSoaProgressCollapsedEvents();

    void setLeftCardContent(@NotNull CardData cardData);

    void setLeftCardLoading();

    void showLeftCardTooltip(@NotNull String str, @NotNull ProfileHeaderView.ClickTarget clickTarget);

    void showSoaUpdateProgress(@Nullable String str);
}
