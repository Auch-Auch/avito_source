package com.avito.android.lib.design.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.lib.util.ImageViewExtensionsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ImageViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.drawable.RoundStateDrawable;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010z\u001a\u00020y¢\u0006\u0004\b{\u0010|B\u001b\b\u0016\u0012\u0006\u0010z\u001a\u00020y\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b{\u0010}B#\b\u0016\u0012\u0006\u0010z\u001a\u00020y\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b{\u0010~B+\b\u0016\u0012\u0006\u0010z\u001a\u00020y\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b{\u0010J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J-\u0010\f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0003¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00032\b\b\u0001\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0017\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u0017\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u00032\b\b\u0001\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u0018J\u0019\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\u001f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u0005J%\u0010#\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030!H\u0016¢\u0006\u0004\b#\u0010$J%\u0010#\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030!H\u0016¢\u0006\u0004\b#\u0010&J%\u0010'\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030!H\u0016¢\u0006\u0004\b'\u0010$J%\u0010'\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030!H\u0016¢\u0006\u0004\b'\u0010&J%\u0010(\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030!H\u0016¢\u0006\u0004\b(\u0010$J%\u0010(\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030!H\u0016¢\u0006\u0004\b(\u0010&J\u0019\u0010*\u001a\u00020\u00032\b\b\u0001\u0010)\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010\u0018J\u0019\u0010*\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b*\u0010-J\u0017\u0010/\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\tH\u0016¢\u0006\u0004\b/\u0010\u0018J\u0017\u00102\u001a\u00020\u00032\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J/\u00105\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00192\b\b\u0001\u00104\u001a\u00020\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030!H\u0016¢\u0006\u0004\b5\u00106J\u001d\u00108\u001a\u00020\u00032\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00030!H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020\u00032\u0006\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\u00032\b\b\u0001\u00104\u001a\u00020\tH\u0007¢\u0006\u0004\b>\u0010\u0018R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010L\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010DR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010DR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010DR\u0016\u0010Z\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010DR\u0016\u0010\\\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010DR\u0016\u0010^\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010AR\u0016\u0010`\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010DR\u0016\u0010b\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010DR\u0016\u0010d\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010DR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bm\u0010DR\u0016\u0010p\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bo\u0010UR\u0016\u0010r\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010DR\u0016\u0010t\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010HR\u0016\u0010v\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bu\u0010DR\u0016\u0010x\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bw\u0010D¨\u0006\u0001"}, d2 = {"Lcom/avito/android/lib/design/dialog/DialogView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/avito/android/lib/design/dialog/Dialog$View;", "", "f", "()V", "e", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "c", "(Landroid/util/AttributeSet;II)V", "size", "Landroid/graphics/drawable/ShapeDrawable;", AuthSource.BOOKING_ORDER, "(I)Landroid/graphics/drawable/ShapeDrawable;", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)V", "titleRes", "setTitle", "(I)V", "", "title", "(Ljava/lang/String;)V", "subtitleRes", "setSubtitle", MessengerShareContentUtility.SUBTITLE, "removeAllButtons", "textRes", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addPrimaryButton", "(ILkotlin/jvm/functions/Function0;)V", "text", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "addSecondaryButton", "addDefaultButton", "src", "setImage", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "orientation", "setButtonsOrientation", "", "isVisible", "setCloseButtonVisible", "(Z)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "addButton", "(Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "action", "setOnCloseClicked", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", "view", "setCustomView", "(Landroid/view/View;)V", "setCloseButtonAppearance", "Landroid/widget/TextView;", VKApiConst.Q, "Landroid/widget/TextView;", "titleView", "K", "I", "closeIconContainerSize", "Landroid/widget/LinearLayout;", VKApiConst.VERSION, "Landroid/widget/LinearLayout;", "contentContainer", "y", "textsContainer", "textsPadding", "Lcom/avito/android/lib/design/dialog/EdgeScrollView;", "w", "Lcom/avito/android/lib/design/dialog/EdgeScrollView;", "contentScrollView", "H", "buttonsPadding", "Landroid/widget/ImageView;", "s", "Landroid/widget/ImageView;", "imageView", "L", "titlePadding", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "primaryButtonStyle", "F", "dialogSize", "r", "subtitleView", ExifInterface.LONGITUDE_EAST, "dialogMargin", "G", "contentsPadding", "J", "closeIconBackgroundSize", "Landroid/widget/FrameLayout;", "u", "Landroid/widget/FrameLayout;", "closeButtonContainer", "Landroid/view/ViewGroup;", "z", "Landroid/view/ViewGroup;", "customViewContainer", "B", "secondaryButtonStyle", "t", "closeButton", "M", "customViewPadding", "x", "buttonsContainer", "C", "defaultButtonStyle", "D", "dialogPadding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class DialogView extends ConstraintLayout implements Dialog.View {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public final TextView q;
    public final TextView r;
    public final ImageView s;
    public final ImageView t;
    public final FrameLayout u;
    public final LinearLayout v;
    public final EdgeScrollView w;
    public final LinearLayout x;
    public final LinearLayout y;
    public final ViewGroup z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.design_dialog, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        this.q = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.subtitle)");
        this.r = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.image)");
        this.s = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.close_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.close_icon)");
        this.t = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.content_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.content_container)");
        this.v = (LinearLayout) findViewById5;
        View findViewById6 = findViewById(R.id.content_scroll);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.content_scroll)");
        this.w = (EdgeScrollView) findViewById6;
        View findViewById7 = findViewById(R.id.buttons_container);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.buttons_container)");
        this.x = (LinearLayout) findViewById7;
        View findViewById8 = findViewById(R.id.texts_container);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.texts_container)");
        this.y = (LinearLayout) findViewById8;
        View findViewById9 = findViewById(R.id.close_button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.close_button_container)");
        this.u = (FrameLayout) findViewById9;
        View findViewById10 = findViewById(R.id.custom_view_container);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.custom_view_container)");
        this.z = (ViewGroup) findViewById10;
        d(this, null, 0, 0, 6);
    }

    public static /* synthetic */ void d(DialogView dialogView, AttributeSet attributeSet, int i, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        dialogView.c(attributeSet, i, i2);
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void addButton(@NotNull String str, @StyleRes int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        boolean z2 = false;
        if (this.x.getChildCount() >= 3) {
            this.x.removeViewAt(0);
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Button button = new Button(context, null, 0, i);
        button.setText(str);
        button.setOnClickListener(new a(function0));
        this.x.addView(button, new LinearLayout.LayoutParams(-1, -2, 1.0f));
        LinearLayout linearLayout = this.x;
        if (linearLayout.getChildCount() > 0) {
            z2 = true;
        }
        Views.setVisible(linearLayout, z2);
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void addDefaultButton(int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        String string = getContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(textRes)");
        addDefaultButton(string, function0);
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void addPrimaryButton(int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        String string = getContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(textRes)");
        addPrimaryButton(string, function0);
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void addSecondaryButton(int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        String string = getContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(textRes)");
        addSecondaryButton(string, function0);
    }

    public final ShapeDrawable b(int i) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setIntrinsicHeight(i);
        shapeDrawable.setIntrinsicWidth(i);
        Paint paint = shapeDrawable.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "paint");
        paint.setColor(0);
        return shapeDrawable;
    }

    @SuppressLint({"CustomViewStyleable"})
    public final void c(AttributeSet attributeSet, int i, int i2) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.E = context.getResources().getDimensionPixelSize(R.dimen.dialog_margin);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.G = context2.getResources().getDimensionPixelSize(R.dimen.dialog_contentsPadding);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.H = context3.getResources().getDimensionPixelSize(R.dimen.dialog_buttonsPadding);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        this.I = context4.getResources().getDimensionPixelSize(R.dimen.dialog_textsPadding);
        Integer valueOf = Integer.valueOf(i2);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Dialog, i, valueOf != null ? valueOf.intValue() : R.style.Dialog_Default);
        this.A = obtainStyledAttributes.getResourceId(R.styleable.Dialog_dialog_buttonPrimaryStyle, this.A);
        this.B = obtainStyledAttributes.getResourceId(R.styleable.Dialog_dialog_buttonSecondaryStyle, this.B);
        this.C = obtainStyledAttributes.getResourceId(R.styleable.Dialog_dialog_buttonDefaultStyle, this.C);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.Dialog_dialog_closeButton, false);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Dialog_dialog_titleAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.Dialog_dialog_subtitleAppearance, 0);
        int i3 = obtainStyledAttributes.getInt(R.styleable.Dialog_dialog_buttonsOrientation, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Dialog_dialog_cornerRadius, 0);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.Dialog_dialog_backgroundColor);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, AuthSource.SEND_ABUSE);
        int i4 = R.styleable.Dialog_dialog_padding;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.D = obtainStyledAttributes.getDimensionPixelSize(i4, this.D);
        }
        int i5 = R.styleable.Dialog_dialog_customViewPadding;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.M = obtainStyledAttributes.getDimensionPixelSize(i5, this.M);
        }
        int i6 = R.styleable.Dialog_dialog_width;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.F = obtainStyledAttributes.getDimensionPixelSize(i6, this.F);
        }
        int i7 = R.styleable.Dialog_dialog_closeIconBackgroundSize;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.J = obtainStyledAttributes.getDimensionPixelSize(i7, 0);
        }
        int i8 = R.styleable.Dialog_dialog_closeIconContainerSize;
        if (obtainStyledAttributes.hasValue(i8)) {
            this.K = obtainStyledAttributes.getDimensionPixelSize(i8, 0);
            ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = this.K;
            }
            ViewGroup.LayoutParams layoutParams2 = this.u.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = this.K;
            }
            this.u.requestLayout();
        }
        int i9 = R.styleable.Dialog_dialog_closeButtonAppearance;
        if (obtainStyledAttributes.hasValue(i9)) {
            setCloseButtonAppearance(obtainStyledAttributes.getResourceId(i9, 0));
        }
        obtainStyledAttributes.recycle();
        setButtonsOrientation(i3);
        TextViews.setTextAppearanceCompat(this.q, resourceId);
        TextViews.setTextAppearanceCompat(this.r, resourceId2);
        setCloseButtonVisible(z2);
        if (colorStateList != null) {
            RoundStateDrawable.Companion companion = RoundStateDrawable.Companion;
            Views.setBackgroundCompat(this, RoundStateDrawable.Companion.invoke$default(companion, colorStateList, null, dimensionPixelSize, null, 0, 0, 0, 122, null));
            LayerDrawable layerDrawable = new LayerDrawable(new RoundStateDrawable[]{RoundStateDrawable.Companion.invoke$default(companion, colorStateList, null, dimensionPixelSize, null, 0, 0, 0, 122, null)});
            layerDrawable.setLayerInset(0, 0, this.G, 0, 0);
            Views.setBackgroundCompat(this.x, layerDrawable);
            EdgeScrollView edgeScrollView = this.w;
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{colorStateList.getDefaultColor(), ColorUtils.setAlphaComponent(colorStateList.getDefaultColor(), 0)});
            gradientDrawable.setCornerRadius((float) dimensionPixelSize);
            Unit unit = Unit.INSTANCE;
            EdgeScrollView.setEdgeDrawables$default(edgeScrollView, null, gradientDrawable, 1, null);
        }
        LinearLayout linearLayout = this.v;
        int i10 = this.D;
        Views.changePadding$default(linearLayout, i10, i10, i10, 0, 8, null);
        LinearLayout linearLayout2 = this.x;
        int i11 = this.D;
        Views.changePadding$default(linearLayout2, i11, 0, i11, i11, 2, null);
        this.v.setDividerDrawable(b(this.M));
        this.x.setDividerDrawable(b(this.H));
        this.y.setDividerDrawable(b(this.I));
    }

    public final void e() {
        Views.setVisible(this.y, Views.isVisible(this.r) || Views.isVisible(this.q));
    }

    public final void f() {
        int i;
        if (!Views.isVisible(this.q) || Views.isVisible(this.r)) {
            i = this.G;
        } else {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i = context.getResources().getDimensionPixelSize(R.dimen.dialog_titlePadding);
        }
        this.L = i;
        Views.changePadding$default(this.v, 0, 0, 0, i, 7, null);
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void removeAllButtons() {
        this.x.removeAllViews();
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void setButtonsOrientation(int i) {
        this.x.setOrientation(i);
    }

    @SuppressLint({"CustomViewStyleable"})
    public final void setCloseButtonAppearance(@StyleRes int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.Dialog_CloseButton);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        ImageViewsKt.setImageTintListCompat(this.t, obtainStyledAttributes.getColorStateList(R.styleable.Dialog_CloseButton_dialog_closeIconColor));
        int i2 = R.styleable.Dialog_CloseButton_dialog_closeIconBackgroundColor;
        int i3 = (this.K - this.J) / 2;
        ImageViewExtensionsKt.setBackground(this.t, Math.max(0, i3), Math.max(0, i3), obtainStyledAttributes.getColorStateList(i2), obtainStyledAttributes.getColorStateList(R.styleable.Dialog_CloseButton_dialog_closeIconBackgroundRipple));
        obtainStyledAttributes.recycle();
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void setCloseButtonVisible(boolean z2) {
        int i;
        Views.setVisible(this.u, z2);
        if (z2) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i = (context.getResources().getDimensionPixelSize(R.dimen.dialog_titleMarginClose) + this.K) - this.G;
        } else {
            i = 0;
        }
        ViewGroup.LayoutParams layoutParams = this.q.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.rightMargin = i;
        this.q.setLayoutParams(layoutParams2);
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void setCustomView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Views.show(this.z);
        this.z.removeAllViews();
        this.z.addView(view);
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void setImage(@DrawableRes int i) {
        setImage(getContext().getDrawable(i));
    }

    @Override // android.view.View
    public void setLayoutParams(@Nullable ViewGroup.LayoutParams layoutParams) {
        Integer num = null;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) (!(layoutParams instanceof ViewGroup.MarginLayoutParams) ? null : layoutParams);
        if (marginLayoutParams != null) {
            Integer valueOf = Integer.valueOf(marginLayoutParams.topMargin);
            boolean z2 = true;
            if (!(valueOf.intValue() > 0)) {
                valueOf = null;
            }
            marginLayoutParams.topMargin = valueOf != null ? valueOf.intValue() : this.E;
            Integer valueOf2 = Integer.valueOf(marginLayoutParams.bottomMargin);
            if (!(valueOf2.intValue() > 0)) {
                valueOf2 = null;
            }
            marginLayoutParams.bottomMargin = valueOf2 != null ? valueOf2.intValue() : this.E;
            Integer valueOf3 = Integer.valueOf(marginLayoutParams.width);
            if (valueOf3.intValue() <= 0) {
                z2 = false;
            }
            if (z2) {
                num = valueOf3;
            }
            marginLayoutParams.width = num != null ? num.intValue() : this.F;
        }
        super.setLayoutParams(layoutParams);
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void setOnCloseClicked(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.t.setOnClickListener(new b(function0));
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void setSubtitle(@StringRes int i) {
        setSubtitle(getContext().getString(i));
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void setTitle(@StringRes int i) {
        setTitle(getContext().getString(i));
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void addDefaultButton(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        addButton(str, this.C, function0);
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void addPrimaryButton(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        addButton(str, this.A, function0);
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void addSecondaryButton(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        addButton(str, this.B, function0);
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void setImage(@Nullable Drawable drawable) {
        this.s.setImageDrawable(drawable);
        Views.setVisible(this.s, drawable != null);
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void setSubtitle(@Nullable String str) {
        TextViews.bindText$default(this.r, str, false, 2, null);
        e();
        f();
    }

    @Override // com.avito.android.lib.design.dialog.Dialog.View
    public void setTitle(@Nullable String str) {
        TextViews.bindText$default(this.q, str, false, 2, null);
        e();
        f();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.design_dialog, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        this.q = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.subtitle)");
        this.r = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.image)");
        this.s = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.close_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.close_icon)");
        this.t = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.content_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.content_container)");
        this.v = (LinearLayout) findViewById5;
        View findViewById6 = findViewById(R.id.content_scroll);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.content_scroll)");
        this.w = (EdgeScrollView) findViewById6;
        View findViewById7 = findViewById(R.id.buttons_container);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.buttons_container)");
        this.x = (LinearLayout) findViewById7;
        View findViewById8 = findViewById(R.id.texts_container);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.texts_container)");
        this.y = (LinearLayout) findViewById8;
        View findViewById9 = findViewById(R.id.close_button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.close_button_container)");
        this.u = (FrameLayout) findViewById9;
        View findViewById10 = findViewById(R.id.custom_view_container);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.custom_view_container)");
        this.z = (ViewGroup) findViewById10;
        d(this, attributeSet, 0, 0, 6);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.design_dialog, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        this.q = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.subtitle)");
        this.r = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.image)");
        this.s = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.close_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.close_icon)");
        this.t = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.content_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.content_container)");
        this.v = (LinearLayout) findViewById5;
        View findViewById6 = findViewById(R.id.content_scroll);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.content_scroll)");
        this.w = (EdgeScrollView) findViewById6;
        View findViewById7 = findViewById(R.id.buttons_container);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.buttons_container)");
        this.x = (LinearLayout) findViewById7;
        View findViewById8 = findViewById(R.id.texts_container);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.texts_container)");
        this.y = (LinearLayout) findViewById8;
        View findViewById9 = findViewById(R.id.close_button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.close_button_container)");
        this.u = (FrameLayout) findViewById9;
        View findViewById10 = findViewById(R.id.custom_view_container);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.custom_view_container)");
        this.z = (ViewGroup) findViewById10;
        d(this, attributeSet, i, 0, 4);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.design_dialog, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        this.q = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.subtitle)");
        this.r = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.image)");
        this.s = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.close_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.close_icon)");
        this.t = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.content_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.content_container)");
        this.v = (LinearLayout) findViewById5;
        View findViewById6 = findViewById(R.id.content_scroll);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.content_scroll)");
        this.w = (EdgeScrollView) findViewById6;
        View findViewById7 = findViewById(R.id.buttons_container);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.buttons_container)");
        this.x = (LinearLayout) findViewById7;
        View findViewById8 = findViewById(R.id.texts_container);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.texts_container)");
        this.y = (LinearLayout) findViewById8;
        View findViewById9 = findViewById(R.id.close_button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.close_button_container)");
        this.u = (FrameLayout) findViewById9;
        View findViewById10 = findViewById(R.id.custom_view_container);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.custom_view_container)");
        this.z = (ViewGroup) findViewById10;
        c(attributeSet, i, i2);
    }
}
