package com.avito.android.lib.design.bottom_sheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a1\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\u000b\u001a\u00020\t*\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "", "title", "", "showCloseButton", "showHeaderThumb", "", "setRightCrossHeader", "(Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;Ljava/lang/CharSequence;ZZ)V", "", "attr", AuthSource.SEND_ABUSE, "(Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;I)I", "components_release"}, k = 2, mv = {1, 4, 2})
public final class RightCrossHeaderKt {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BottomSheetDialog a;

        public a(BottomSheetDialog bottomSheetDialog) {
            this.a = bottomSheetDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.close();
        }
    }

    public static final int a(BottomSheetDialog bottomSheetDialog, int i) {
        int i2;
        Context context = bottomSheetDialog.getContext();
        TypedValue typedValue = new TypedValue();
        Context context2 = bottomSheetDialog.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        if (context2.getTheme().resolveAttribute(R.attr.bottomSheetDialog, typedValue, true)) {
            i2 = typedValue.resourceId;
        } else {
            i2 = R.style.Design_Widget_BottomSheetDialog;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, new int[]{i});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static final void setRightCrossHeader(@NotNull BottomSheetDialog bottomSheetDialog, @Nullable CharSequence charSequence, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(bottomSheetDialog, "$this$setRightCrossHeader");
        Object systemService = bottomSheetDialog.getContext().getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View inflate = ((LayoutInflater) systemService).inflate(R.layout.design_bottom_sheet_right_cross_header, (ViewGroup) null);
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, null, null, false, z2, 7, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        bottomSheetDialog.setCustomHeader(inflate);
        View findViewById = inflate.findViewById(R.id.bottom_sheet_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.bottom_sheet_close_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById2;
        if (charSequence != null) {
            textView.setText(charSequence);
        } else {
            Views.hide(textView);
        }
        Views.setVisible(imageView, z);
        imageView.setOnClickListener(new a(bottomSheetDialog));
        if (z2) {
            Views.changeMargin$default(inflate, 0, a(bottomSheetDialog, R.attr.bottomSheet_rightCrossLayoutTopMargin), 0, 0, 13, null);
        } else {
            bottomSheetDialog.setThumbLayoutHeight(a(bottomSheetDialog, R.attr.bottomSheet_rightCrossThumbLayoutHeight));
        }
    }

    public static /* synthetic */ void setRightCrossHeader$default(BottomSheetDialog bottomSheetDialog, CharSequence charSequence, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        setRightCrossHeader(bottomSheetDialog, charSequence, z, z2);
    }
}
