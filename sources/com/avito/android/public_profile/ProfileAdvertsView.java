package com.avito.android.public_profile;

import com.avito.android.advert.viewed.ViewedAdvertsView;
import com.avito.android.favorite.FavoriteAdvertsView;
import com.avito.android.legacy_mvp.ErrorMessageView;
import com.avito.android.ui.adapter.AppendingListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/public_profile/ProfileAdvertsView;", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "Lcom/avito/android/legacy_mvp/ErrorMessageView;", "Lcom/avito/android/advert/viewed/ViewedAdvertsView;", "", "showProgress", "()V", "showAdverts", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "onDataChanged", "(Lcom/avito/android/ui/adapter/AppendingListener;)V", "", "count", "setColumnsCount", "(I)V", "", "error", "showError", "(Ljava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileAdvertsView extends FavoriteAdvertsView, ErrorMessageView, ViewedAdvertsView {
    void onDataChanged(@NotNull AppendingListener appendingListener);

    void setColumnsCount(int i);

    void showAdverts();

    @Override // com.avito.android.legacy_mvp.ErrorMessageView
    void showError(@NotNull String str);

    void showProgress();
}
