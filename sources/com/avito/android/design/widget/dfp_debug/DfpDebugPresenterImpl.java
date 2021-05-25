package com.avito.android.design.widget.dfp_debug;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenterImpl;", "Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;", "Lcom/avito/android/design/widget/dfp_debug/DfpDebugRouter;", "router", "", "attachRouter", "(Lcom/avito/android/design/widget/dfp_debug/DfpDebugRouter;)V", "detachRouter", "()V", "", "adUnitId", "Lcom/avito/android/design/widget/dfp_debug/DfpDebuggableView;", "debuggableView", "setupDebugMenu", "(Ljava/lang/String;Lcom/avito/android/design/widget/dfp_debug/DfpDebuggableView;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/design/widget/dfp_debug/DfpDebugRouter;", "<init>", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class DfpDebugPresenterImpl implements DfpDebugPresenter {
    public DfpDebugRouter a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DfpDebugPresenterImpl a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DfpDebugPresenterImpl dfpDebugPresenterImpl, String str) {
            super(0);
            this.a = dfpDebugPresenterImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            DfpDebugRouter dfpDebugRouter = this.a.a;
            if (dfpDebugRouter != null) {
                dfpDebugRouter.openDebugMenu(this.b);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.design.widget.dfp_debug.DfpDebugPresenter
    public void attachRouter(@NotNull DfpDebugRouter dfpDebugRouter) {
        Intrinsics.checkNotNullParameter(dfpDebugRouter, "router");
        this.a = dfpDebugRouter;
    }

    @Override // com.avito.android.design.widget.dfp_debug.DfpDebugPresenter
    public void detachRouter() {
        this.a = null;
    }

    @Override // com.avito.android.design.widget.dfp_debug.DfpDebugPresenter
    public void setupDebugMenu(@NotNull String str, @NotNull DfpDebuggableView dfpDebuggableView) {
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        Intrinsics.checkNotNullParameter(dfpDebuggableView, "debuggableView");
        dfpDebuggableView.setDebugListener(new a(this, str));
    }
}
