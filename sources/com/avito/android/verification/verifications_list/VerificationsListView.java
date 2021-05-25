package com.avito.android.verification.verifications_list;

import com.avito.conveyor_item.Item;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0006J\u001d\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/verification/verifications_list/VerificationsListView;", "", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "showLoading", "()V", "showContent", "error", "showError", "", "Lcom/avito/conveyor_item/Item;", "items", "updateItems", "(Ljava/util/List;)V", "Lio/reactivex/rxjava3/core/Observable;", "getRetryClicks", "()Lio/reactivex/rxjava3/core/Observable;", "retryClicks", "getBackClicks", "backClicks", "getRefreshes", "refreshes", "verification_release"}, k = 1, mv = {1, 4, 2})
public interface VerificationsListView {
    @NotNull
    Observable<Unit> getBackClicks();

    @NotNull
    Observable<Unit> getRefreshes();

    @NotNull
    Observable<Unit> getRetryClicks();

    void setTitle(@NotNull String str);

    void showContent();

    void showError(@NotNull String str);

    void showLoading();

    void updateItems(@NotNull List<? extends Item> list);
}
