package com.avito.android.util;

import android.app.Dialog;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.SimpleUserDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/SimpleUserDialog;", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lkotlin/Function0;", "", "dismissListener", "Landroid/app/Dialog;", "show", "(Lcom/avito/android/remote/model/SimpleUserDialog;Lcom/avito/android/util/DialogRouter;Lkotlin/jvm/functions/Function0;)Landroid/app/Dialog;", "core_release"}, k = 2, mv = {1, 4, 2})
public final class SimpleUserDialogsKt {

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

    @NotNull
    public static final Dialog show(@NotNull SimpleUserDialog simpleUserDialog, @NotNull DialogRouter dialogRouter, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(simpleUserDialog, "$this$show");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(function0, "dismissListener");
        List<Action> actions = simpleUserDialog.getActions();
        String title = (actions == null || !(actions.isEmpty() ^ true)) ? null : actions.get(0).getTitle();
        if (title != null) {
            return dialogRouter.showSimpleNotifyingDismissDialog(simpleUserDialog.getTitle(), simpleUserDialog.getMessage(), title, function0);
        }
        return dialogRouter.showSimpleNotifyingDismissDialog(simpleUserDialog.getTitle(), simpleUserDialog.getMessage(), function0);
    }

    public static /* synthetic */ Dialog show$default(SimpleUserDialog simpleUserDialog, DialogRouter dialogRouter, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = a.a;
        }
        return show(simpleUserDialog, dialogRouter, function0);
    }
}
