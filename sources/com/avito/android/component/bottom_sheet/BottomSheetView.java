package com.avito.android.component.bottom_sheet;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBar;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/avito/android/component/bottom_sheet/BottomSheetView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "closeEvents", "()Lio/reactivex/rxjava3/core/Observable;", "", "panelStateChanges", "openFullscreen", "()V", "close", "show", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setPeekHeight", "(I)V", "getPanelState", "()I", "Lru/avito/component/appbar/AppBar;", "getAppBar", "()Lru/avito/component/appbar/AppBar;", "appBar", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface BottomSheetView {
    void close();

    @NotNull
    Observable<Unit> closeEvents();

    @Nullable
    AppBar getAppBar();

    int getPanelState();

    void openFullscreen();

    @NotNull
    Observable<Integer> panelStateChanges();

    void setPeekHeight(int i);

    void show();
}
