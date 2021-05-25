package com.avito.android.blocked_ip;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J]\u0010\f\u001a\u00020\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/blocked_ip/BlockedIpDialogView;", "", "", "image", "title", "message", "negativeButtonText", "positiveButtonText", "Lkotlin/Function0;", "", "cancelListener", "agreeListener", "showDialog", "(IIIIILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "blocked-ip_release"}, k = 1, mv = {1, 4, 2})
public interface BlockedIpDialogView {
    void showDialog(@DrawableRes int i, @StringRes int i2, @StringRes int i3, @StringRes int i4, @StringRes int i5, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);
}
