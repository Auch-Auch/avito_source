package com.avito.android.abuse.category;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0003H&¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H&¢\u0006\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/abuse/category/AbuseCategoryView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "backClicks", "()Lio/reactivex/rxjava3/core/Observable;", "retryClicks", "showBackIcon", "()V", "showCloseIcon", "showLoading", "showContent", "", "error", "showError", "(Ljava/lang/String;)V", "notifyDataChanged", "abuse_release"}, k = 1, mv = {1, 4, 2})
public interface AbuseCategoryView {
    @NotNull
    Observable<Unit> backClicks();

    void notifyDataChanged();

    @NotNull
    Observable<Unit> retryClicks();

    void showBackIcon();

    void showCloseIcon();

    void showContent();

    void showError(@NotNull String str);

    void showLoading();
}
