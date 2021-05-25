package com.avito.android.app_rater.fragment;

import android.view.View;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/avito/android/app_rater/fragment/AppRaterDialogView;", "", "Lio/reactivex/Observable;", "", "getNegativeButtonClicks", "()Lio/reactivex/Observable;", "negativeButtonClicks", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "getPositiveButtonClicks", "positiveButtonClicks", "app-rater_release"}, k = 1, mv = {1, 4, 2})
public interface AppRaterDialogView {
    @NotNull
    Observable<Integer> getNegativeButtonClicks();

    @NotNull
    Observable<Integer> getPositiveButtonClicks();

    @NotNull
    View getView();
}
