package com.avito.android.rating.publish.select_advert;

import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/SelectAdvertView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "queryStream", "searchButtonClicks", "notifyItemsChanged", "()V", "", VKApiConst.POSITION, "scrollToPosition", "(I)V", "query", "setQuery", "(Ljava/lang/String;)V", "", "show", "showSearchInputState", "(Z)V", "showEmptyState", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface SelectAdvertView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull SelectAdvertView selectAdvertView) {
            ItemView.DefaultImpls.onUnbind(selectAdvertView);
        }
    }

    @NotNull
    Observable<Unit> navigationClicks();

    void notifyItemsChanged();

    @NotNull
    Observable<String> queryStream();

    void scrollToPosition(int i);

    @NotNull
    Observable<Unit> searchButtonClicks();

    void setQuery(@Nullable String str);

    void showEmptyState(boolean z);

    void showSearchInputState(boolean z);
}
