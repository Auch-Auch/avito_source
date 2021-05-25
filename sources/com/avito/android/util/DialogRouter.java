package com.avito.android.util;

import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.ListAdapter;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\n\u0010\u000eJ3\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0013\u0010\u0016J-\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u0013\u0010\u0019J5\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u0013\u0010\u001aJ-\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u001b\u0010\u0019J5\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u001b\u0010\u001aJ]\u0010#\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010!\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b#\u0010$Je\u0010'\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020\f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH&¢\u0006\u0004\b'\u0010$J-\u0010+\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0(2\u0006\u0010\u0018\u001a\u00020*H&¢\u0006\u0004\b+\u0010,J'\u00100\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020*H&¢\u0006\u0004\b0\u00101J=\u00106\u001a\u00020\u00062\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001e0(2\u0006\u00104\u001a\u0002032\u0006\u0010\u0018\u001a\u0002052\u0006\u0010\u0011\u001a\u00020*2\u0006\u0010 \u001a\u00020*H&¢\u0006\u0004\b6\u00107J1\u00108\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0(2\b\u0010\u0018\u001a\u0004\u0018\u00010*H&¢\u0006\u0004\b8\u0010,J)\u0010:\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010\u001eH&¢\u0006\u0004\b:\u0010;Js\u0010?\u001a\u00020\u00062\b\b\u0001\u0010<\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00022\b\b\u0001\u0010\u001f\u001a\u00020\u00022\b\b\u0001\u0010!\u001a\u00020\u00022\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u00100=2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u00100=2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b?\u0010@Jg\u0010?\u001a\u00020\u00062\b\b\u0001\u0010<\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00022\b\b\u0001\u0010\u001f\u001a\u00020\u00022\b\b\u0001\u0010!\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b?\u0010A¨\u0006B"}, d2 = {"Lcom/avito/android/util/DialogRouter;", "", "", "attr", "resolveAttr", "(I)I", "Landroid/app/Dialog;", "showSimpleWaitingDialog", "()Landroid/app/Dialog;", "id", "showSimpleWaitingDialogWithMessage", "(I)Landroid/app/Dialog;", "", "message", "(Ljava/lang/String;)Landroid/app/Dialog;", "Lkotlin/Function0;", "", "okListener", "dismissListener", "showSimpleNotifyingDialog", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroid/app/Dialog;", "title", "(Ljava/lang/String;Ljava/lang/String;)Landroid/app/Dialog;", "buttonText", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Landroid/app/Dialog;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Landroid/app/Dialog;", "showSimpleNotifyingDismissDialog", "", "cancelable", "", "negativeButtonText", "cancelListener", "positiveButtonText", "agreeListener", "showCancelableNotifyingDialog", "(Ljava/lang/String;ZLjava/lang/CharSequence;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Landroid/app/Dialog;", "positiveListener", "negativeListener", "showNotifyingDialog", "", "itemsNames", "Landroid/content/DialogInterface$OnClickListener;", "showChooseNotifyingDialog", "(Ljava/lang/String;[Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;", "Landroid/widget/ListAdapter;", "adapter", "checkedPosition", "showSingleChoiceDialog", "(Landroid/widget/ListAdapter;ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;", "items", "", "checkedItems", "Landroid/content/DialogInterface$OnMultiChoiceClickListener;", "showMultiChoiceDialog", "([Ljava/lang/CharSequence;[ZLandroid/content/DialogInterface$OnMultiChoiceClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;", "showChooseNotifyingDialogWithButtons", "embeddedLink", "showNotifyingDialogWithEmbeddedLink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/app/Dialog;", "imgRes", "Lkotlin/Function1;", "Landroidx/appcompat/app/AlertDialog;", "showNotifyingDialogWithImage", "(IIIIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)Landroid/app/Dialog;", "(IIIIILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Z)Landroid/app/Dialog;", "deprecated-components_release"}, k = 1, mv = {1, 4, 2})
public interface DialogRouter {
    int resolveAttr(@AttrRes int i);

    @NotNull
    Dialog showCancelableNotifyingDialog(@Nullable String str, boolean z, @Nullable CharSequence charSequence, @NotNull String str2, @NotNull Function0<Unit> function0, @NotNull String str3, @NotNull Function0<Unit> function02);

    @NotNull
    Dialog showChooseNotifyingDialog(@NotNull String str, @NotNull String[] strArr, @NotNull DialogInterface.OnClickListener onClickListener);

    @Nullable
    Dialog showChooseNotifyingDialogWithButtons(@NotNull String str, @NotNull String[] strArr, @Nullable DialogInterface.OnClickListener onClickListener);

    @NotNull
    Dialog showMultiChoiceDialog(@NotNull CharSequence[] charSequenceArr, @NotNull boolean[] zArr, @NotNull DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener, @NotNull DialogInterface.OnClickListener onClickListener, @NotNull DialogInterface.OnClickListener onClickListener2);

    @NotNull
    Dialog showNotifyingDialog(@Nullable String str, boolean z, @Nullable CharSequence charSequence, @NotNull String str2, @NotNull Function0<Unit> function0, @Nullable String str3, @Nullable Function0<Unit> function02);

    @NotNull
    Dialog showNotifyingDialogWithEmbeddedLink(@NotNull String str, @NotNull String str2, @Nullable CharSequence charSequence);

    @NotNull
    Dialog showNotifyingDialogWithImage(@DrawableRes int i, @StringRes int i2, @StringRes int i3, @StringRes int i4, @StringRes int i5, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, boolean z);

    @NotNull
    Dialog showNotifyingDialogWithImage(@DrawableRes int i, @StringRes int i2, @StringRes int i3, @StringRes int i4, @StringRes int i5, @NotNull Function1<? super AlertDialog, Unit> function1, @NotNull Function1<? super AlertDialog, Unit> function12, boolean z);

    @NotNull
    Dialog showSimpleNotifyingDialog(@NotNull String str, @NotNull String str2);

    @NotNull
    Dialog showSimpleNotifyingDialog(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0);

    @NotNull
    Dialog showSimpleNotifyingDialog(@NotNull String str, @NotNull String str2, @NotNull Function0<Unit> function0);

    @NotNull
    Dialog showSimpleNotifyingDialog(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);

    @NotNull
    Dialog showSimpleNotifyingDismissDialog(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0);

    @NotNull
    Dialog showSimpleNotifyingDismissDialog(@NotNull String str, @NotNull String str2, @NotNull Function0<Unit> function0);

    @NotNull
    Dialog showSimpleWaitingDialog();

    @NotNull
    Dialog showSimpleWaitingDialogWithMessage(@StringRes int i);

    @NotNull
    Dialog showSimpleWaitingDialogWithMessage(@NotNull String str);

    @NotNull
    Dialog showSingleChoiceDialog(@NotNull ListAdapter listAdapter, int i, @NotNull DialogInterface.OnClickListener onClickListener);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Dialog showCancelableNotifyingDialog$default(DialogRouter dialogRouter, String str, boolean z, CharSequence charSequence, String str2, Function0 function0, String str3, Function0 function02, int i, Object obj) {
            if (obj == null) {
                return dialogRouter.showCancelableNotifyingDialog((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : charSequence, str2, function0, str3, function02);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCancelableNotifyingDialog");
        }

        public static /* synthetic */ Dialog showNotifyingDialog$default(DialogRouter dialogRouter, String str, boolean z, CharSequence charSequence, String str2, Function0 function0, String str3, Function0 function02, int i, Object obj) {
            if (obj == null) {
                return dialogRouter.showNotifyingDialog((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : charSequence, str2, function0, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : function02);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNotifyingDialog");
        }

        public static /* synthetic */ Dialog showNotifyingDialogWithImage$default(DialogRouter dialogRouter, int i, int i2, int i3, int i4, int i5, Function1 function1, Function1 function12, boolean z, int i6, Object obj) {
            if (obj == null) {
                return dialogRouter.showNotifyingDialogWithImage(i, i2, i3, i4, i5, function1, function12, (i6 & 128) != 0 ? true : z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNotifyingDialogWithImage");
        }

        public static /* synthetic */ Dialog showNotifyingDialogWithImage$default(DialogRouter dialogRouter, int i, int i2, int i3, int i4, int i5, Function0 function0, Function0 function02, boolean z, int i6, Object obj) {
            if (obj == null) {
                return dialogRouter.showNotifyingDialogWithImage(i, i2, i3, i4, i5, function0, function02, (i6 & 128) != 0 ? true : z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNotifyingDialogWithImage");
        }
    }
}
