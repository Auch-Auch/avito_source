package com.avito.android.autoteka_details;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetailsView;", "", "", "startLoad", "()V", "Lcom/avito/android/autoteka_details/AutotekaDetails;", "data", "showData", "(Lcom/avito/android/autoteka_details/AutotekaDetails;)V", "showError", "Lio/reactivex/Observable;", "getRefreshClick", "()Lio/reactivex/Observable;", "refreshClick", "Lcom/avito/android/autoteka_details/AutotekaDetailsNavigation;", "getNavigationClick", "navigationClick", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
public interface AutotekaDetailsView {
    @NotNull
    Observable<AutotekaDetailsNavigation> getNavigationClick();

    @NotNull
    Observable<Unit> getRefreshClick();

    void showData(@NotNull AutotekaDetails autotekaDetails);

    void showError();

    void startLoad();
}
