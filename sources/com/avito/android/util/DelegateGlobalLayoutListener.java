package com.avito.android.util;

import android.view.ViewTreeObserver;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/util/DelegateGlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "()V", "Lkotlin/Function0;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function0;", "getDelegate", "()Lkotlin/jvm/functions/Function0;", "setDelegate", "(Lkotlin/jvm/functions/Function0;)V", "delegate", "<init>", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class DelegateGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
    @Nullable
    public Function0<Unit> a;

    @Nullable
    public final Function0<Unit> getDelegate() {
        return this.a;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Function0<Unit> function0 = this.a;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setDelegate(@Nullable Function0<Unit> function0) {
        this.a = function0;
    }
}
