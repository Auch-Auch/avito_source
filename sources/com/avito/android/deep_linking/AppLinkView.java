package com.avito.android.deep_linking;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\b\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/deep_linking/AppLinkView;", "", "Lio/reactivex/Observable;", "", "getRefreshes", "()Lio/reactivex/Observable;", "showLoading", "()V", "showError", "", "message", "(Ljava/lang/String;)V", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public interface AppLinkView {
    @NotNull
    Observable<Unit> getRefreshes();

    void showError();

    void showError(@NotNull String str);

    void showLoading();
}
