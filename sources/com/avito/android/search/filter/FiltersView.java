package com.avito.android.search.filter;

import android.view.View;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H&¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H&¢\u0006\u0004\b\u0017\u0010\tJ\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000bH&¢\u0006\u0004\b\u0019\u0010\u000eJ\u001d\u0010\u001d\u001a\u00020\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0003H&¢\u0006\u0004\b\u001f\u0010\tJ\u000f\u0010 \u001a\u00020\u0003H&¢\u0006\u0004\b \u0010\tJ\u000f\u0010!\u001a\u00020\u0003H&¢\u0006\u0004\b!\u0010\tJ\u000f\u0010\"\u001a\u00020\u0003H&¢\u0006\u0004\b\"\u0010\t¨\u0006#"}, d2 = {"Lcom/avito/android/search/filter/FiltersView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "upClicks", "()Lio/reactivex/rxjava3/core/Observable;", "showClicks", "refreshClicks", "showLiveSearchProgress", "()V", "hideLiveSearchProgress", "", "title", "setButtonTitle", "(Ljava/lang/String;)V", "", "isEnabled", "setShowButtonEnabled", "(Z)V", "showProgress", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "hideProgress", "message", "showMessage", "", "Lkotlin/ranges/IntRange;", "ranges", "setGroupsBounds", "(Ljava/util/List;)V", "onDataChanged", "showLoadingFailure", PlatformActions.HIDE_KEYBOARD, "dispose", "filter_release"}, k = 1, mv = {1, 4, 2})
public interface FiltersView {
    void dispose();

    @NotNull
    View getRootView();

    void hideKeyboard();

    void hideLiveSearchProgress();

    void hideProgress();

    void onDataChanged();

    @NotNull
    Observable<Unit> refreshClicks();

    void setButtonTitle(@NotNull String str);

    void setGroupsBounds(@NotNull List<IntRange> list);

    void setShowButtonEnabled(boolean z);

    @NotNull
    Observable<Unit> showClicks();

    void showLiveSearchProgress();

    void showLoadingFailure();

    void showMessage(@NotNull String str);

    void showProgress();

    @NotNull
    Observable<Unit> upClicks();
}
