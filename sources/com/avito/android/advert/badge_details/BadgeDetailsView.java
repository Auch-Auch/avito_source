package com.avito.android.advert.badge_details;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert/badge_details/BadgeDetailsView;", "", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "text", "setButtonText", "showLoading", "()V", "showContent", "showError", "Lio/reactivex/rxjava3/core/Observable;", "getButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "buttonClicks", "getDialogDismisses", "dialogDismisses", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface BadgeDetailsView {
    @NotNull
    Observable<Unit> getButtonClicks();

    @NotNull
    Observable<Unit> getDialogDismisses();

    void setButtonText(@Nullable String str);

    void setDescription(@NotNull String str);

    void setTitle(@NotNull String str);

    void showContent();

    void showError(@NotNull String str);

    void showLoading();
}
