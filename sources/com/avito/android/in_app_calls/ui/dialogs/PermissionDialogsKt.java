package com.avito.android.in_app_calls.ui.dialogs;

import android.content.Context;
import android.content.DialogInterface;
import com.avito.android.in_app_calls.R;
import com.avito.android.lib.design.dialog.Dialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a;\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", "context", "", "needShowSettings", "Lkotlin/Function0;", "", "onPositive", "onNegative", "showMicPermissionDialog", "(Landroid/content/Context;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "in-app-calls_release"}, k = 2, mv = {1, 4, 2})
public final class PermissionDialogsKt {

    public static final class a extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ Function0 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Function0 function0, Function0 function02) {
            super(2);
            this.a = i;
            this.b = function0;
            this.c = function02;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
            Dialog.Config config2 = config;
            DialogInterface dialogInterface2 = dialogInterface;
            Intrinsics.checkNotNullParameter(config2, "$receiver");
            Intrinsics.checkNotNullParameter(dialogInterface2, "dialog");
            config2.setImage(R.drawable.img_mic_popup);
            config2.setTitle(R.string.calls_mic_permission_dialog_title);
            config2.setSubtitle(R.string.calls_mic_permission_dialog_body);
            config2.setButtonsOrientation(1);
            config2.addPrimaryButton(this.a, new t4(0, this, dialogInterface2));
            config2.addSecondaryButton(R.string.calls_mic_permission_dialog_no, new t4(1, this, dialogInterface2));
            return Unit.INSTANCE;
        }
    }

    public static final void showMicPermissionDialog(@NotNull Context context, boolean z, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "onPositive");
        Intrinsics.checkNotNullParameter(function02, "onNegative");
        if (z) {
            i = R.string.calls_mic_permission_dialog_settings;
        } else {
            i = R.string.calls_mic_permission_dialog_ok;
        }
        Dialog.Companion.create$default(Dialog.Companion, context, 0, 0, new a(i, function0, function02), 6, null).show();
    }
}
