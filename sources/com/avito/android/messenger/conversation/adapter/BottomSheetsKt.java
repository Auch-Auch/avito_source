package com.avito.android.messenger.conversation.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.util.Contexts;
import com.avito.android.util.ViewTreeObservers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001aq\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032#\b\b\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052#\b\b\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a1\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00062\u0014\b\u0004\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\"\u0016\u0010\u0014\u001a\u00020\u00038\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, d2 = {"Landroid/content/Context;", "", "url", "", "peekHeight", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "onOpenInBrowserClick", "onCopyClick", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetMenuDialog;", "showLinkBottomSheetMenuDialog", "(Landroid/content/Context;Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lcom/avito/android/lib/design/bottom_sheet/BottomSheetMenuDialog;", "rootView", "peekHeightSetter", "initializeLinkBottomSheetPeekHeight", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "MAX_URL_LINES_IN_MENU", "I", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class BottomSheetsKt {
    public static final int MAX_URL_LINES_IN_MENU = 10;

    public static final void initializeLinkBottomSheetPeekHeight(@NotNull View view, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(function1, "peekHeightSetter");
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(view, function1) { // from class: com.avito.android.messenger.conversation.adapter.BottomSheetsKt$initializeLinkBottomSheetPeekHeight$1
            public final /* synthetic */ View a;
            public final /* synthetic */ Function1 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "rootView.viewTreeObserver");
                ViewTreeObservers.removeGlobalLayoutListener(viewTreeObserver, this);
                Function1 function12 = this.b;
                Context context = this.a.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                function12.invoke(Integer.valueOf((Contexts.getDisplayHeight(context) * 2) / 3));
            }
        });
    }

    @NotNull
    public static final BottomSheetMenuDialog showLinkBottomSheetMenuDialog(@NotNull Context context, @NotNull String str, int i, @NotNull Function1<? super View, Unit> function1, @NotNull Function1<? super View, Unit> function12) {
        Intrinsics.checkNotNullParameter(context, "$this$showLinkBottomSheetMenuDialog");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(function1, "onOpenInBrowserClick");
        Intrinsics.checkNotNullParameter(function12, "onCopyClick");
        return new BottomSheetMenuDialog(context, new BottomSheetsKt$showLinkBottomSheetMenuDialog$1(context, str, function1, function12, i));
    }
}
