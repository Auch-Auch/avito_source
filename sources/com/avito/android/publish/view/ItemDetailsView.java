package com.avito.android.publish.view;

import com.avito.android.html_editor.EditorNavigationEvent;
import com.avito.android.html_formatter.FormatChange;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.facebook.share.internal.MessengerShareContentUtility;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.OnboardingData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002KLJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH&¢\u0006\u0004\b\u0012\u0010\u000bJ\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\bH&¢\u0006\u0004\b\u0014\u0010\u000bJ\u0019\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0016\u0010\u000bJ#\u0010\u0019\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\u001bH&¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0002H&¢\u0006\u0004\b#\u0010\u0004J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\rH&¢\u0006\u0004\b%\u0010\u0010JA\u0010+\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020)H&¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH&¢\u0006\u0004\b-\u0010\u000bJ\u000f\u0010.\u001a\u00020\u0002H&¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\u0002H&¢\u0006\u0004\b/\u0010\u0004J\u000f\u00100\u001a\u00020\u0002H&¢\u0006\u0004\b0\u0010\u0004J\u000f\u00101\u001a\u00020\u0002H&¢\u0006\u0004\b1\u0010\u0004J\u000f\u00102\u001a\u00020\u0002H&¢\u0006\u0004\b2\u0010\u0004J\u001d\u00104\u001a\u00020\u00022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020)H&¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0002H&¢\u0006\u0004\b6\u0010\u0004J\u0017\u00109\u001a\u00020\u00022\u0006\u00108\u001a\u000207H&¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0002H&¢\u0006\u0004\b;\u0010\u0004J\u000f\u0010<\u001a\u00020\u0002H&¢\u0006\u0004\b<\u0010\u0004J\u0017\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\rH&¢\u0006\u0004\b>\u0010\u0010J\u001f\u0010A\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u001bH&¢\u0006\u0004\bA\u0010BR\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020D0C8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020H0C8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bI\u0010F¨\u0006M"}, d2 = {"Lcom/avito/android/publish/view/ItemDetailsView;", "", "", "showValidationProgress", "()V", "hideValidationProgress", "showProgress", "showRetry", "", "error", "showError", "(Ljava/lang/String;)V", "showContent", "", "id", "setAppBarHomeIcon", "(I)V", "title", "setAppBarTitle", "shortTitle", "setAppBarShortTitle", MessengerShareContentUtility.SUBTITLE, "setAppBarSubtitle", "Lcom/avito/android/publish/view/ItemDetailsView$RightTopButtonStyle;", "buttonStyle", "setAppBarActionButton", "(Ljava/lang/String;Lcom/avito/android/publish/view/ItemDetailsView$RightTopButtonStyle;)V", "", "isEnabled", "setAppbarExpandEnabled", "(Z)V", "itemPosition", "waitForRelayout", "scrollToItem", "(IZ)V", PlatformActions.HIDE_KEYBOARD, "padding", "setBottomPadding", "message", "positiveOption", "negativeOption", "Lkotlin/Function0;", "onPositiveClicked", "showDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "setMainButtonTitle", "hideMainButton", "showMainButton", "showMainButtonDelayed", "disableMainButton", "enableMainButton", "onScroll", "startScrollListening", "(Lkotlin/jvm/functions/Function0;)V", "stopScrollListening", "Lru/avito/component/toolbar/OnboardingData;", "onboardingData", "showActionOnboarding", "(Lru/avito/component/toolbar/OnboardingData;)V", "showHtmlEditorToolbar", "hideHtmlEditorToolbar", "flags", "setEditorToolbarStateFlags", "undoEnabled", "redoEnabled", "setEditorNavigationButtonsStates", "(ZZ)V", "Lio/reactivex/Observable;", "Lcom/avito/android/html_formatter/FormatChange;", "getHtmlPanelStateFlags", "()Lio/reactivex/Observable;", "htmlPanelStateFlags", "Lcom/avito/android/html_editor/EditorNavigationEvent;", "getHtmlPanelNavigationEvent", "htmlPanelNavigationEvent", "Presenter", "RightTopButtonStyle", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface ItemDetailsView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void scrollToItem$default(ItemDetailsView itemDetailsView, int i, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    z = false;
                }
                itemDetailsView.scrollToItem(i, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToItem");
        }

        public static /* synthetic */ void setAppBarActionButton$default(ItemDetailsView itemDetailsView, String str, RightTopButtonStyle rightTopButtonStyle, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                itemDetailsView.setAppBarActionButton(str, rightTopButtonStyle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAppBarActionButton");
        }

        public static /* synthetic */ void showDialog$default(ItemDetailsView itemDetailsView, String str, String str2, String str3, String str4, Function0 function0, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                itemDetailsView.showDialog(str, str2, str3, str4, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDialog");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/view/ItemDetailsView$Presenter;", "", "", "onRetryClick", "()V", "onMainButtonClicked", "", "isImmediatelyCancel", "onCancelClicked", "(Z)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public interface Presenter {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static /* synthetic */ void onCancelClicked$default(Presenter presenter, boolean z, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        z = false;
                    }
                    presenter.onCancelClicked(z);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCancelClicked");
            }
        }

        void onCancelClicked(boolean z);

        void onMainButtonClicked();

        void onRetryClick();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/publish/view/ItemDetailsView$RightTopButtonStyle;", "", "<init>", "(Ljava/lang/String;I)V", "CLOSE", "NONE", "publish_release"}, k = 1, mv = {1, 4, 2})
    public enum RightTopButtonStyle {
        CLOSE,
        NONE
    }

    void disableMainButton();

    void enableMainButton();

    @NotNull
    Observable<EditorNavigationEvent> getHtmlPanelNavigationEvent();

    @NotNull
    Observable<FormatChange> getHtmlPanelStateFlags();

    void hideHtmlEditorToolbar();

    void hideKeyboard();

    void hideMainButton();

    void hideValidationProgress();

    void scrollToItem(int i, boolean z);

    void setAppBarActionButton(@Nullable String str, @NotNull RightTopButtonStyle rightTopButtonStyle);

    void setAppBarHomeIcon(int i);

    void setAppBarShortTitle(@NotNull String str);

    void setAppBarSubtitle(@Nullable String str);

    void setAppBarTitle(@NotNull String str);

    void setAppbarExpandEnabled(boolean z);

    void setBottomPadding(int i);

    void setEditorNavigationButtonsStates(boolean z, boolean z2);

    void setEditorToolbarStateFlags(int i);

    void setMainButtonTitle(@NotNull String str);

    void showActionOnboarding(@NotNull OnboardingData onboardingData);

    void showContent();

    void showDialog(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Function0<Unit> function0);

    void showError(@NotNull String str);

    void showHtmlEditorToolbar();

    void showMainButton();

    void showMainButtonDelayed();

    void showProgress();

    void showRetry();

    void showValidationProgress();

    void startScrollListening(@NotNull Function0<Unit> function0);

    void stopScrollListening();
}
