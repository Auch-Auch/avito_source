package com.avito.android.lib.design.bottom_sheet;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.avito.android.search.map.view.PanelStateKt;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u0000 I2\u00020\u0001:\u0001IJ;\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\b2\b\b\u0001\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u000f\u001a\u00020\bH&¢\u0006\u0004\b\u000f\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH&¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0018H&¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0005H&¢\u0006\u0004\b\u001d\u0010\u0011J\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0005H&¢\u0006\u0004\b\u001f\u0010\u0011J\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0005H&¢\u0006\u0004\b!\u0010\u0011J\u001d\u0010!\u001a\u00020\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\"H&¢\u0006\u0004\b!\u0010#J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0005H&¢\u0006\u0004\b%\u0010\u0011J\u0017\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0005H&¢\u0006\u0004\b'\u0010\u0011J\u0019\u0010)\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\u0012H&¢\u0006\u0004\b)\u0010\u0015J\u0017\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0012H&¢\u0006\u0004\b+\u0010\u0015J\u0019\u0010-\u001a\u00020\b2\b\b\u0001\u0010,\u001a\u00020\u0012H&¢\u0006\u0004\b-\u0010\u0015J\u000f\u0010.\u001a\u00020\bH&¢\u0006\u0004\b.\u0010\u0016J\u0017\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0005H&¢\u0006\u0004\b0\u0010\u0011J\u0017\u00102\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0005H&¢\u0006\u0004\b2\u0010\u0011J\u0017\u00103\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b3\u0010\u000eJ\u000f\u00104\u001a\u00020\bH&¢\u0006\u0004\b4\u0010\u0016R$\u00108\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\"8&@&X¦\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u0010#R$\u0010;\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\"8&@&X¦\u000e¢\u0006\f\u001a\u0004\b9\u00106\"\u0004\b:\u0010#R$\u0010>\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\"8&@&X¦\u000e¢\u0006\f\u001a\u0004\b<\u00106\"\u0004\b=\u0010#R0\u0010D\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b\u0018\u00010?8&@&X¦\u000e¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR0\u0010H\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\b\u0018\u00010?8&@&X¦\u000e¢\u0006\f\u001a\u0004\bF\u0010A\"\u0004\bG\u0010C¨\u0006J"}, d2 = {"Lcom/avito/android/lib/design/bottom_sheet/ModalBottomSheetView;", "", "", "title", "actionTitle", "", "showCloseButton", "showHeaderThumb", "", "setHeaderParams", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZ)V", "Landroid/view/View;", "view", "setCustomHeader", "(Landroid/view/View;)V", "show", "showActionButton", "(Z)V", "", "iconId", "setCloseButtonIcon", "(I)V", "()V", "dismiss", "Landroid/widget/FrameLayout;", "getContentView", "()Landroid/widget/FrameLayout;", "getFooterView", "hideable", "setHideable", "active", "setActionButtonActive", "cancelOnTouchOutside", "setCancelOnTouchOutside", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "manuallyDismiss", "setManualDismissOnCancelClick", "skipCollapsed", "setSkipCollapsed", "peekHeight", "setPeekHeight", "thumbHeight", "setThumbLayoutHeight", "color", "setScrimBackgroundColor", Tracker.Events.CREATIVE_EXPAND, PanelStateKt.PANEL_EXPANDED, "setForceExpandedState", "shouldFit", "setFitContentPeekHeight", "setScrimBackgroundView", "forceShowHeaderThumb", "getOnCloseListener", "()Lkotlin/jvm/functions/Function0;", "setOnCloseListener", "onCloseListener", "getOnClickOutsideViewListener", "setOnClickOutsideViewListener", "onClickOutsideViewListener", "getOnActionClickListener", "setOnActionClickListener", "onActionClickListener", "Lkotlin/Function2;", "getOnStateChangedListener", "()Lkotlin/jvm/functions/Function2;", "setOnStateChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "onStateChangedListener", "", "getOnSlideListener", "setOnSlideListener", "onSlideListener", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
public interface ModalBottomSheetView {
    @NotNull
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/lib/design/bottom_sheet/ModalBottomSheetView$Companion;", "", "Landroid/view/ViewGroup;", "layout", "", "isTablet", "Lcom/avito/android/lib/design/bottom_sheet/ModalBottomSheetView;", "create", "(Landroid/view/ViewGroup;Z)Lcom/avito/android/lib/design/bottom_sheet/ModalBottomSheetView;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        public static /* synthetic */ ModalBottomSheetView create$default(Companion companion, ViewGroup viewGroup, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.create(viewGroup, z);
        }

        @NotNull
        public final ModalBottomSheetView create(@NotNull ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(viewGroup, "layout");
            return z ? new TabletBottomSheetView(viewGroup) : new ModalBottomSheetViewImpl(viewGroup);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void setHeaderParams$default(ModalBottomSheetView modalBottomSheetView, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    charSequence = null;
                }
                if ((i & 2) != 0) {
                    charSequence2 = null;
                }
                if ((i & 4) != 0) {
                    z = false;
                }
                if ((i & 8) != 0) {
                    z2 = false;
                }
                modalBottomSheetView.setHeaderParams(charSequence, charSequence2, z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeaderParams");
        }

        public static /* synthetic */ void setPeekHeight$default(ModalBottomSheetView modalBottomSheetView, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = -1;
                }
                modalBottomSheetView.setPeekHeight(i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPeekHeight");
        }
    }

    void dismiss();

    void expand();

    void forceShowHeaderThumb();

    @NotNull
    FrameLayout getContentView();

    @NotNull
    FrameLayout getFooterView();

    @Nullable
    Function0<Unit> getOnActionClickListener();

    @Nullable
    Function0<Unit> getOnClickOutsideViewListener();

    @Nullable
    Function0<Unit> getOnCloseListener();

    @Nullable
    Function2<View, Float, Unit> getOnSlideListener();

    @Nullable
    Function2<View, Integer, Unit> getOnStateChangedListener();

    void setActionButtonActive(boolean z);

    void setCancelOnTouchOutside(@NotNull Function0<Boolean> function0);

    void setCancelOnTouchOutside(boolean z);

    void setCloseButtonIcon(@DrawableRes int i);

    void setCustomHeader(@NotNull View view);

    void setFitContentPeekHeight(boolean z);

    void setForceExpandedState(boolean z);

    void setHeaderParams(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z, boolean z2);

    void setHideable(boolean z);

    void setManualDismissOnCancelClick(boolean z);

    void setOnActionClickListener(@Nullable Function0<Unit> function0);

    void setOnClickOutsideViewListener(@Nullable Function0<Unit> function0);

    void setOnCloseListener(@Nullable Function0<Unit> function0);

    void setOnSlideListener(@Nullable Function2<? super View, ? super Float, Unit> function2);

    void setOnStateChangedListener(@Nullable Function2<? super View, ? super Integer, Unit> function2);

    void setPeekHeight(int i);

    void setScrimBackgroundColor(@ColorInt int i);

    void setScrimBackgroundView(@NotNull View view);

    void setSkipCollapsed(boolean z);

    void setThumbLayoutHeight(int i);

    void show();

    void showActionButton(boolean z);
}
