package com.avito.android.advert_core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JU\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert_core/SnackBarListener;", "", "", "text", "", "length", "maxLine", "actionTitle", "Lkotlin/Function0;", "", "Lcom/avito/android/util/ActionHandler;", "action", "", "error", "showSnackBar", "(Ljava/lang/String;IILjava/lang/String;Lkotlin/jvm/functions/Function0;Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface SnackBarListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void showSnackBar$default(SnackBarListener snackBarListener, String str, int i, int i2, String str2, Function0 function0, boolean z, int i3, Object obj) {
            if (obj == null) {
                snackBarListener.showSnackBar(str, i, (i3 & 4) != 0 ? 2 : i2, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : function0, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSnackBar");
        }
    }

    void showSnackBar(@NotNull String str, int i, int i2, @Nullable String str2, @Nullable Function0<Unit> function0, boolean z);
}
