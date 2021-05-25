package com.avito.android.messenger.conversation.confirmation_dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.ActionConfirmation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\nJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/conversation/confirmation_dialog/ConfirmationDialogView;", "", "Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "confirmation", "Lkotlin/Function0;", "", "onConfirm", "show", "(Lcom/avito/android/remote/model/messenger/ActionConfirmation;Lkotlin/jvm/functions/Function0;)V", "onDismiss", "(Lcom/avito/android/remote/model/messenger/ActionConfirmation;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "dismiss", "()V", "Lcom/avito/android/lib/design/dialog/Dialog;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/dialog/Dialog;", "dialog", "Landroid/content/Context;", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ConfirmationDialogView {
    public Dialog a;
    public final Context b;

    public static final class a extends Lambda implements Function0<Unit> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
        public final /* synthetic */ ConfirmationDialogView a;
        public final /* synthetic */ ActionConfirmation b;
        public final /* synthetic */ Function0 c;
        public final /* synthetic */ Function0 d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ConfirmationDialogView confirmationDialogView, ActionConfirmation actionConfirmation, Function0 function0, Function0 function02) {
            super(2);
            this.a = confirmationDialogView;
            this.b = actionConfirmation;
            this.c = function0;
            this.d = function02;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
            Dialog.Config config2 = config;
            DialogInterface dialogInterface2 = dialogInterface;
            Intrinsics.checkNotNullParameter(config2, "$receiver");
            Intrinsics.checkNotNullParameter(dialogInterface2, "dialog");
            config2.setTitle(this.b.getTitle());
            config2.setSubtitle(this.b.getMessage());
            config2.setButtonsOrientation(1);
            config2.addPrimaryButton(this.b.getConfirmButtonText(), new b5(0, this, dialogInterface2));
            config2.addSecondaryButton(this.b.getCancelButtonText(), new b5(1, this, dialogInterface2));
            config2.setOnDismissListener(new k6(0, this));
            config2.enableCancelable(new k6(1, this));
            return Unit.INSTANCE;
        }
    }

    public ConfirmationDialogView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = context;
    }

    public final void dismiss() {
        Dialog dialog = this.a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public final void show(@NotNull ActionConfirmation actionConfirmation, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(actionConfirmation, "confirmation");
        Intrinsics.checkNotNullParameter(function0, "onConfirm");
        show(actionConfirmation, function0, a.a);
    }

    public final void show(@NotNull ActionConfirmation actionConfirmation, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(actionConfirmation, "confirmation");
        Intrinsics.checkNotNullParameter(function0, "onConfirm");
        Intrinsics.checkNotNullParameter(function02, "onDismiss");
        dismiss();
        Dialog create$default = Dialog.Companion.create$default(Dialog.Companion, this.b, 0, 0, new b(this, actionConfirmation, function0, function02), 6, null);
        this.a = create$default;
        if (create$default != null) {
            create$default.show();
        }
    }
}
