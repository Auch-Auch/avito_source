package com.avito.android.advert_core.safe_show;

import a2.a.a.g.k.a;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.advert_core.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/advert_core/safe_show/SafeShowDialogFactory;", "", "Landroid/content/Context;", "context", "", "title", "text", "", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "", "Landroid/app/Dialog;", "build", "(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/app/Dialog;", "", AuthSource.SEND_ABUSE, "Z", "isTablet", "<init>", "(Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public class SafeShowDialogFactory {
    public final boolean a;

    public SafeShowDialogFactory(boolean z) {
        this.a = z;
    }

    @NotNull
    public final Dialog build(@NotNull Context context, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Dialog dialog;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(charSequence, "title");
        Intrinsics.checkNotNullParameter(charSequence2, "text");
        if (this.a) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.advert_details_safe_show_bottomshet_layout, (ViewGroup) null);
            dialog = Dialog.Companion.create$default(com.avito.android.lib.design.dialog.Dialog.Companion, context, 0, R.style.SafeShowFloatingDialogStyle, new a(inflate), 2, null);
            View findViewById = inflate.findViewById(R.id.avito_bottom_sheet_notch);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
            Views.setVisible(findViewById, false);
            View findViewById2 = inflate.findViewById(R.id.title);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById2).setText(charSequence);
            View findViewById3 = inflate.findViewById(R.id.text);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById3).setText(charSequence2);
        } else {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, 0, 2, null);
            bottomSheetDialog.setContentView(R.layout.advert_details_safe_show_bottomshet_layout);
            bottomSheetDialog.setTitle((CharSequence) null);
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            if (resources.getConfiguration().orientation == 2) {
                Resources resources2 = context.getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "context.resources");
                bottomSheetDialog.setPeekHeight(resources2.getDisplayMetrics().widthPixels);
            }
            View findViewById4 = bottomSheetDialog.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(id)");
            ((TextView) findViewById4).setText(charSequence);
            View findViewById5 = bottomSheetDialog.findViewById(R.id.text);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(id)");
            ((TextView) findViewById5).setText(charSequence2);
            dialog = bottomSheetDialog;
        }
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    public void show(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "text");
        build(context, str, str2).show();
    }
}
