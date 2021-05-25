package com.avito.android.search.filter;

import android.app.Dialog;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/search/filter/DialogDismissListenerImpl;", "Lcom/avito/android/search/filter/DialogDismissListener;", "", "dismiss", "()V", "Landroid/app/Dialog;", AuthSource.SEND_ABUSE, "Landroid/app/Dialog;", "dialog", "<init>", "(Landroid/app/Dialog;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class DialogDismissListenerImpl implements DialogDismissListener {
    public final Dialog a;

    public DialogDismissListenerImpl(@NotNull Dialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this.a = dialog;
    }

    @Override // com.avito.android.search.filter.DialogDismissListener
    public void dismiss() {
        this.a.dismiss();
    }
}
