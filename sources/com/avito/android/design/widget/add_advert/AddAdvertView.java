package com.avito.android.design.widget.add_advert;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.deep_linking.links.DeepLink;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.floating_add_advert.AdvertShortcut;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001&J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H&¢\u0006\u0004\b\u000b\u0010\u0005J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H&¢\u0006\u0004\b\r\u0010\u0005J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002H&¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0003H&¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0006H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H&¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0006H&¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000eH&¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0006H&¢\u0006\u0004\b%\u0010\u001b¨\u0006'"}, d2 = {"Lcom/avito/android/design/widget/add_advert/AddAdvertView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "openCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "", "aboutToBeOpenedCallbacks", "addClicks", "collapseClicks", "Lcom/avito/android/design/widget/add_advert/AddAdvertView$FinishReason;", "finishCallbacks", "Lru/avito/component/floating_add_advert/AdvertShortcut;", "publishVerticalCallbacks", "Lcom/avito/android/deep_linking/links/DeepLink;", "advertClicks", "handleBack", "()Z", "resizeButton", "setResizeButton", "(Z)V", "", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, "initButtons", "(Ljava/util/List;)V", "showProgress", "hideProgress", "()V", "handleAdvertShortcutsLoaded", "openButton", "deepLink", "openLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "message", "showError", "(Ljava/lang/String;)V", "showFatalError", "FinishReason", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface AddAdvertView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/design/widget/add_advert/AddAdvertView$FinishReason;", "", "<init>", "(Ljava/lang/String;I)V", "GO_TO_FLOW", "GO_BACK", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public enum FinishReason {
        GO_TO_FLOW,
        GO_BACK
    }

    @NotNull
    Observable<Unit> aboutToBeOpenedCallbacks();

    @NotNull
    Observable<Unit> addClicks();

    @NotNull
    Observable<DeepLink> advertClicks();

    @NotNull
    Observable<Unit> collapseClicks();

    @NotNull
    Observable<FinishReason> finishCallbacks();

    void handleAdvertShortcutsLoaded();

    boolean handleBack();

    void hideProgress();

    void initButtons(@NotNull List<AdvertShortcut> list);

    void openButton();

    @NotNull
    Observable<Boolean> openCallbacks();

    void openLink(@NotNull DeepLink deepLink);

    @NotNull
    Observable<AdvertShortcut> publishVerticalCallbacks();

    void setResizeButton(boolean z);

    void showError(@NotNull String str);

    void showFatalError();

    @NotNull
    Observable<Unit> showProgress();
}
