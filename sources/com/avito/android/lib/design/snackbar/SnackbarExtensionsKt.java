package com.avito.android.lib.design.snackbar;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ak\u0010\u0010\u001a\u00020\u000f*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011\u001ak\u0010\u0010\u001a\u00020\u000f*\u00020\u00122\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/fragment/app/Fragment;", "", "text", "", "textResId", "actionText", "actionTextResId", "Lkotlin/Function0;", "", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "type", "Lcom/avito/android/lib/design/snackbar/Snackbar;", "showSnackbar", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)Lcom/avito/android/lib/design/snackbar/Snackbar;", "Landroid/view/View;", "(Landroid/view/View;Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)Lcom/avito/android/lib/design/snackbar/Snackbar;", "components_release"}, k = 2, mv = {1, 4, 2})
public final class SnackbarExtensionsKt {
    @NotNull
    public static final Snackbar showSnackbar(@NotNull Fragment fragment, @NotNull String str, int i, @Nullable String str2, int i2, @Nullable Function0<Unit> function0, int i3, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(fragment, "$this$showSnackbar");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        if (i != 0) {
            str = fragment.requireContext().getString(i);
            Intrinsics.checkNotNullExpressionValue(str, "requireContext().getString(textResId)");
        }
        if (i2 != 0) {
            str2 = fragment.requireContext().getString(i2);
        }
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Snackbar actionText = new Snackbar(requireContext, str).setAction(function0).setActionText(str2);
        View requireView = fragment.requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
        return actionText.setAnchorView(requireView).setType(snackbarType).setPosition(snackbarPosition).setDuration(i3).show();
    }

    public static /* synthetic */ Snackbar showSnackbar$default(Fragment fragment, String str, int i, String str2, int i2, Function0 function0, int i3, SnackbarPosition snackbarPosition, SnackbarType snackbarType, int i4, Object obj) {
        String str3 = (i4 & 1) != 0 ? "" : str;
        int i5 = 0;
        int i6 = (i4 & 2) != 0 ? 0 : i;
        Function0 function02 = null;
        String str4 = (i4 & 4) != 0 ? null : str2;
        if ((i4 & 8) == 0) {
            i5 = i2;
        }
        if ((i4 & 16) == 0) {
            function02 = function0;
        }
        return showSnackbar(fragment, str3, i6, str4, i5, function02, (i4 & 32) != 0 ? 2750 : i3, (i4 & 64) != 0 ? SnackbarPosition.OVERLAY_VIEW_BOTTOM : snackbarPosition, (i4 & 128) != 0 ? SnackbarType.DEFAULT : snackbarType);
    }

    public static /* synthetic */ Snackbar showSnackbar$default(View view, String str, int i, String str2, int i2, Function0 function0, int i3, SnackbarPosition snackbarPosition, SnackbarType snackbarType, int i4, Object obj) {
        String str3 = (i4 & 1) != 0 ? "" : str;
        int i5 = 0;
        int i6 = (i4 & 2) != 0 ? 0 : i;
        Function0 function02 = null;
        String str4 = (i4 & 4) != 0 ? null : str2;
        if ((i4 & 8) == 0) {
            i5 = i2;
        }
        if ((i4 & 16) == 0) {
            function02 = function0;
        }
        return showSnackbar(view, str3, i6, str4, i5, function02, (i4 & 32) != 0 ? 2750 : i3, (i4 & 64) != 0 ? SnackbarPosition.OVERLAY_VIEW_BOTTOM : snackbarPosition, (i4 & 128) != 0 ? SnackbarType.DEFAULT : snackbarType);
    }

    @NotNull
    public static final Snackbar showSnackbar(@NotNull View view, @NotNull String str, int i, @Nullable String str2, int i2, @Nullable Function0<Unit> function0, int i3, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(view, "$this$showSnackbar");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        if (i != 0) {
            str = view.getContext().getString(i);
            Intrinsics.checkNotNullExpressionValue(str, "context.getString(textResId)");
        }
        if (i2 != 0) {
            str2 = view.getContext().getString(i2);
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new Snackbar(context, str).setAction(function0).setActionText(str2).setAnchorView(view).setType(snackbarType).setPosition(snackbarPosition).setDuration(i3).show();
    }
}
