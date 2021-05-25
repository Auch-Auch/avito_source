package com.avito.android.imv.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.webview.WebViewWithScrollListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import io.reactivex.functions.Function4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\tJ!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0005\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/avito/android/imv/widget/BottomSheetWebView;", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "", "layoutResId", "", "setContentView", "(I)V", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "Landroid/view/ViewGroup$LayoutParams;", "params", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "Lcom/avito/android/webview/WebViewWithScrollListener;", "webView", "setupWebView", "(Lcom/avito/android/webview/WebViewWithScrollListener;)V", "c", "()V", "s", "I", "webViewScrollY", "Landroid/content/Context;", "context", "theme", "<init>", "(Landroid/content/Context;I)V", "imv-webview-bottomsheet_release"}, k = 1, mv = {1, 4, 2})
public final class BottomSheetWebView extends BottomSheetDialog {
    public int s;

    public static final class a<T1, T2, T3, T4, R> implements Function4<Integer, Integer, Integer, Integer, Unit> {
        public final /* synthetic */ BottomSheetWebView a;

        public a(BottomSheetWebView bottomSheetWebView) {
            this.a = bottomSheetWebView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.functions.Function4
        public Unit apply(Integer num, Integer num2, Integer num3, Integer num4) {
            num.intValue();
            int intValue = num2.intValue();
            num3.intValue();
            num4.intValue();
            this.a.s = intValue;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetWebView(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void c() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!context.getResources().getBoolean(R.bool.is_tablet)) {
            View findViewById = findViewById(R.id.bottom_sheet);
            Intrinsics.checkNotNull(findViewById);
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            from.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback(from, this) { // from class: com.avito.android.imv.widget.BottomSheetWebView$setupBottomSheetBehaviour$$inlined$let$lambda$1
                public final /* synthetic */ BottomSheetBehavior a;
                public final /* synthetic */ BottomSheetWebView b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public void onSlide(@NotNull View view, float f) {
                    Intrinsics.checkNotNullParameter(view, "bottomSheet");
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public void onStateChanged(@NotNull View view, int i) {
                    Intrinsics.checkNotNullParameter(view, "bottomSheet");
                    if (i == 1 && this.b.s > 0) {
                        this.a.setState(3);
                    } else if (i == 5) {
                        this.b.close();
                    }
                }
            });
        }
    }

    @Override // com.avito.android.lib.design.bottom_sheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(i);
        c();
    }

    public final void setupWebView(@NotNull WebViewWithScrollListener webViewWithScrollListener) {
        Intrinsics.checkNotNullParameter(webViewWithScrollListener, "webView");
        webViewWithScrollListener.addScrollChangeListener(new a(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BottomSheetWebView(Context context, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? 0 : i);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setContentView(view);
        c();
    }

    @Override // com.avito.android.lib.design.bottom_sheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(@NotNull View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setContentView(view, layoutParams);
        c();
    }
}
