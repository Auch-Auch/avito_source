package com.avito.android.messenger.conversation.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.messenger.R;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/avito/android/lib/design/bottom_sheet/BottomSheetMenuDialog;", "", "invoke", "(Lcom/avito/android/lib/design/bottom_sheet/BottomSheetMenuDialog;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class BottomSheetsKt$showLinkBottomSheetMenuDialog$1 extends Lambda implements Function1<BottomSheetMenuDialog, Unit> {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ int e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetsKt$showLinkBottomSheetMenuDialog$1(Context context, String str, Function1 function1, Function1 function12, int i) {
        super(1);
        this.a = context;
        this.b = str;
        this.c = function1;
        this.d = function12;
        this.e = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BottomSheetMenuDialog bottomSheetMenuDialog) {
        invoke(bottomSheetMenuDialog);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull BottomSheetMenuDialog bottomSheetMenuDialog) {
        Intrinsics.checkNotNullParameter(bottomSheetMenuDialog, "$receiver");
        bottomSheetMenuDialog.addHint(new Function1<TextView, Unit>(this) { // from class: com.avito.android.messenger.conversation.adapter.BottomSheetsKt$showLinkBottomSheetMenuDialog$1.1
            public final /* synthetic */ BottomSheetsKt$showLinkBottomSheetMenuDialog$1 a;

            {
                this.a = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                invoke(textView);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "$this$addHint");
                textView.setMaxLines(10);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setText(this.a.b);
                Views.show(textView);
            }
        });
        String string = this.a.getString(R.string.messenger_chat_link_menu_open_in_browser);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.messe…ink_menu_open_in_browser)");
        BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog, string, Integer.valueOf(R.drawable.ic_messenger_link_menu_open_in_browser), null, null, null, this.c, 28, null);
        String string2 = this.a.getString(R.string.messenger_chat_link_menu_copy);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.messenger_chat_link_menu_copy)");
        BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog, string2, Integer.valueOf(R.drawable.ic_messenger_link_menu_copy), null, null, null, this.d, 28, null);
        bottomSheetMenuDialog.setPeekHeight(this.e);
        bottomSheetMenuDialog.show();
    }
}
