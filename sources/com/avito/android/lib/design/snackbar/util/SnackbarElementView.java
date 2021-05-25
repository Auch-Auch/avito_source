package com.avito.android.lib.design.snackbar.util;

import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001Ji\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/lib/design/snackbar/util/SnackbarElementView;", "", "", "text", "", "textResId", "actionText", "actionTextResId", "Lkotlin/Function0;", "", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "type", "showSnackbar", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public interface SnackbarElementView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void showSnackbar$default(SnackbarElementView snackbarElementView, String str, int i, String str2, int i2, Function0 function0, int i3, SnackbarPosition snackbarPosition, SnackbarType snackbarType, int i4, Object obj) {
            if (obj == null) {
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
                snackbarElementView.showSnackbar(str3, i6, str4, i5, function02, (i4 & 32) != 0 ? 2750 : i3, (i4 & 64) != 0 ? SnackbarPosition.OVERLAY_VIEW_BOTTOM : snackbarPosition, (i4 & 128) != 0 ? SnackbarType.DEFAULT : snackbarType);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSnackbar");
        }
    }

    void showSnackbar(@NotNull String str, int i, @Nullable String str2, int i2, @Nullable Function0<Unit> function0, int i3, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType);
}
