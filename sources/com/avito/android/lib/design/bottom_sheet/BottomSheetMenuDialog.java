package com.avito.android.lib.design.bottom_sheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.avito.android.image_loader.Picture;
import com.avito.android.image_loader.fresco.SimpleDraweeViewsKt;
import com.avito.android.lib.design.R;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.util.Contexts;
import com.avito.android.util.ImageViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010)\u001a\u00020(\u0012\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b+\u0010,J0\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\t\u0010\nJ&\u0010\u000b\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\r\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\r\u0010\fJj\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00102#\b\u0002\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006-"}, d2 = {"Lcom/avito/android/lib/design/bottom_sheet/BottomSheetMenuDialog;", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "", "withBottomMargin", "Lkotlin/Function1;", "Landroid/widget/TextView;", "", "Lkotlin/ExtensionFunctionType;", "setup", "addHeader", "(ZLkotlin/jvm/functions/Function1;)V", "addText", "(Lkotlin/jvm/functions/Function1;)V", "addHint", "", "title", "", "icon", "iconTintColor", "Lcom/avito/android/image_loader/Picture;", "thumbnail", "labelIcon", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "onClickListener", "addMenuItem", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/avito/android/image_loader/Picture;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "Landroid/widget/LinearLayout$LayoutParams;", "c", "()Landroid/widget/LinearLayout$LayoutParams;", "", "s", "F", "density", "Landroid/widget/LinearLayout;", "d", "()Landroid/widget/LinearLayout;", "itemsContainer", "Landroid/content/Context;", "context", "dialogSetup", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class BottomSheetMenuDialog extends BottomSheetDialog {
    public final float s;

    public static final class a extends Lambda implements Function1<View, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            Intrinsics.checkNotNullParameter(view, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function1 a;

        public b(Function1 function1) {
            this.a = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = this.a;
            Intrinsics.checkNotNullExpressionValue(view, "it");
            function1.invoke(view);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetMenuDialog(@NotNull Context context, @NotNull Function1<? super BottomSheetMenuDialog, Unit> function1) {
        super(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "dialogSetup");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        this.s = resources.getDisplayMetrics().density;
        setContentView(R.layout.design_bottom_sheet_menu_scrollable_content, true);
        function1.invoke(this);
    }

    public static /* synthetic */ void addHeader$default(BottomSheetMenuDialog bottomSheetMenuDialog, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        bottomSheetMenuDialog.addHeader(z, function1);
    }

    public static /* synthetic */ void addMenuItem$default(BottomSheetMenuDialog bottomSheetMenuDialog, String str, Integer num, Integer num2, Picture picture, Integer num3, Function1 function1, int i, Object obj) {
        Integer num4 = null;
        Integer num5 = (i & 2) != 0 ? null : num;
        Integer num6 = (i & 4) != 0 ? null : num2;
        Picture picture2 = (i & 8) != 0 ? null : picture;
        if ((i & 16) == 0) {
            num4 = num3;
        }
        bottomSheetMenuDialog.addMenuItem(str, num5, num6, picture2, num4, (i & 32) != 0 ? a.a : function1);
    }

    public final void addHeader(boolean z, @NotNull Function1<? super TextView, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "setup");
        int i = R.style.Design_TextAppearance_Avito_Heading_Large;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        appCompatTextView.setId(View.generateViewId());
        appCompatTextView.setTag(TariffPackageInfoConverterKt.HEADER_STRING_ID);
        TextViewCompat.setTextAppearance(appCompatTextView, i);
        function1.invoke(appCompatTextView);
        LinearLayout.LayoutParams c = c();
        int roundToInt = c.roundToInt(this.s * ((float) 8));
        float f = (float) 16;
        int roundToInt2 = c.roundToInt(this.s * f);
        c.setMargins(roundToInt2, roundToInt, roundToInt2, z ? c.roundToInt(this.s * f) : 0);
        LinearLayout d = d();
        if (d != null) {
            d.addView(appCompatTextView, c);
        }
    }

    public final void addHint(@NotNull Function1<? super TextView, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "setup");
        int i = R.style.Design_TextAppearance_Avito_Body_Small_Dense;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        appCompatTextView.setId(View.generateViewId());
        appCompatTextView.setTag("hint");
        TextViewCompat.setTextAppearance(appCompatTextView, i);
        function1.invoke(appCompatTextView);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        appCompatTextView.setTextColor(Contexts.getColorByAttr(context, R.attr.gray48));
        function1.invoke(appCompatTextView);
        LinearLayout.LayoutParams c = c();
        int roundToInt = c.roundToInt(this.s * ((float) 16));
        int roundToInt2 = c.roundToInt(this.s * ((float) 8));
        c.setMargins(roundToInt, roundToInt2, roundToInt, roundToInt2);
        LinearLayout d = d();
        if (d != null) {
            d.addView(appCompatTextView, c);
        }
    }

    public final void addMenuItem(@NotNull String str, @DrawableRes @Nullable Integer num, @ColorInt @Nullable Integer num2, @Nullable Picture picture, @DrawableRes @Nullable Integer num3, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function1, "onClickListener");
        View inflate = getLayoutInflater().inflate(R.layout.design_bottom_sheet_menu_item_with_badge, (ViewGroup) d(), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
        inflate.setId(View.generateViewId());
        inflate.setTag("menu_item");
        View findViewById = inflate.findViewById(R.id.menu_item_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.menu_item_icon)");
        ImageView imageView = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.menu_item_thumbnail);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.menu_item_thumbnail)");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.menu_item_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.menu_item_title)");
        TextView textView = (TextView) findViewById3;
        textView.setText(str);
        if (picture != null) {
            Views.show(simpleDraweeView);
            SimpleDraweeViewsKt.loadPicture(simpleDraweeView, picture);
        } else {
            Views.hide(simpleDraweeView);
        }
        if (num != null) {
            Views.show(imageView);
            imageView.setImageResource(num.intValue());
            if (num2 != null) {
                ImageViewsKt.setImageTintListCompat(imageView, ColorStateList.valueOf(num2.intValue()));
            }
        } else {
            Views.hide(imageView);
        }
        if (num3 != null) {
            TextViews.setCompoundDrawables$default(textView, 0, 0, num3.intValue(), 0, 11, (Object) null);
        } else {
            TextViews.setCompoundDrawables$default(textView, 0, 0, 0, 0, 11, (Object) null);
        }
        inflate.setOnClickListener(new b(function1));
        LinearLayout d = d();
        if (d != null) {
            d.addView(inflate);
        }
    }

    public final void addText(@NotNull Function1<? super TextView, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "setup");
        int i = R.style.Design_TextAppearance_Avito_Body;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        appCompatTextView.setId(View.generateViewId());
        appCompatTextView.setTag("text");
        TextViewCompat.setTextAppearance(appCompatTextView, i);
        function1.invoke(appCompatTextView);
        LinearLayout.LayoutParams c = c();
        int roundToInt = c.roundToInt(this.s * ((float) 16));
        int roundToInt2 = c.roundToInt(this.s * ((float) 8));
        c.setMargins(roundToInt, roundToInt2, roundToInt, roundToInt2);
        LinearLayout d = d();
        if (d != null) {
            d.addView(appCompatTextView, c);
        }
    }

    public final LinearLayout.LayoutParams c() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public final LinearLayout d() {
        return (LinearLayout) findViewById(R.id.menu_content);
    }
}
