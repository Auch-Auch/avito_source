package com.avito.android.grouping_adverts;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH&¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u001b\u0010\tJ\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0018H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0010H&¢\u0006\u0004\b \u0010\u0013J\u000f\u0010!\u001a\u00020\u0002H&¢\u0006\u0004\b!\u0010\u0004¨\u0006\""}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingAdvertsView;", "", "", "showProgress", "()V", "hideProgress", "", "message", "showLoadingError", "(Ljava/lang/String;)V", "notifyDataChanged", "Lio/reactivex/rxjava3/core/Observable;", "getRetryButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "getUpButtonClicks", "filterButtonClicks", "", "spanCount", "updateSpanCount", "(I)V", "phoneNumber", "Lkotlin/Function0;", "okHandler", "cancelHandler", "", "showCallDialog", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Z", "showToastMessage", "isWhite", "setWhiteBackground", "(Z)V", "itemIndex", "onItemChanged", "showFilters", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface GroupingAdvertsView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void showLoadingError$default(GroupingAdvertsView groupingAdvertsView, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = "";
                }
                groupingAdvertsView.showLoadingError(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoadingError");
        }
    }

    @NotNull
    Observable<Unit> filterButtonClicks();

    @NotNull
    Observable<Unit> getRetryButtonClicks();

    @NotNull
    Observable<Unit> getUpButtonClicks();

    void hideProgress();

    void notifyDataChanged();

    void onItemChanged(int i);

    void setWhiteBackground(boolean z);

    boolean showCallDialog(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);

    void showFilters();

    void showLoadingError(@NotNull String str);

    void showProgress();

    void showToastMessage(@NotNull String str);

    void updateSpanCount(int i);
}
