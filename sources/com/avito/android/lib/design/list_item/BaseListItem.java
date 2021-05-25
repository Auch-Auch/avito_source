package com.avito.android.lib.design.list_item;

import a2.g.r.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.list_item.layout.AlignmentFrameLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.ViewGroupsKt;
import com.avito.android.util.Views;
import com.avito.android.util.appearance.AppearanceChangeableView;
import com.avito.android.util.drawable.RoundStateDrawable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u00012\u00020\u0002:\u0001XB\u0013\b\u0016\u0012\b\u0010P\u001a\u0004\u0018\u00010O¢\u0006\u0004\bQ\u0010RB\u001d\b\u0016\u0012\b\u0010P\u001a\u0004\u0018\u00010O\u0012\b\u0010T\u001a\u0004\u0018\u00010S¢\u0006\u0004\bQ\u0010UB%\b\u0016\u0012\b\u0010P\u001a\u0004\u0018\u00010O\u0012\b\u0010T\u001a\u0004\u0018\u00010S\u0012\u0006\u0010V\u001a\u00020\n¢\u0006\u0004\bQ\u0010WJ\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\f\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\b\b\u0001\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\rJ\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0014\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\rJ\u0019\u0010\u0018\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u000fJ\r\u0010\u0019\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u0012J\u0017\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\rJ\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\rJ\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u000fJ\r\u0010\u001c\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u0012J\u0017\u0010\u001d\u001a\u00020\u00042\b\b\u0001\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\rJ\u0015\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u0017J\u0019\u0010\u001e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001e\u0010\u000fJ\r\u0010\u001f\u001a\u00020\u0010¢\u0006\u0004\b\u001f\u0010\u0012J\u0017\u0010 \u001a\u00020\u00042\b\b\u0001\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b \u0010\rJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b \u0010\u0017J\u0017\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\nH\u0016¢\u0006\u0004\b*\u0010\rJ\u0017\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\nH\u0016¢\u0006\u0004\b,\u0010\rJ-\u00101\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010/\u001a\u0004\u0018\u00010-2\b\b\u0002\u00100\u001a\u00020\nH\u0004¢\u0006\u0004\b1\u00102J-\u00103\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010/\u001a\u0004\u0018\u00010-2\b\b\u0002\u00100\u001a\u00020\nH\u0004¢\u0006\u0004\b3\u00102J\u0017\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107J1\u00109\u001a\u00020\u0004*\u0002082\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010/\u001a\u0004\u0018\u00010-2\b\b\u0002\u00100\u001a\u00020\nH\u0002¢\u0006\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010<R\u0016\u0010H\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010BR\u0018\u0010L\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010BR\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010GR\u0018\u0010N\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010B¨\u0006Y"}, d2 = {"Lcom/avito/android/lib/design/list_item/BaseListItem;", "Landroid/widget/LinearLayout;", "Lcom/avito/android/util/appearance/AppearanceChangeableView;", "Landroid/view/ViewGroup;", "", "setVisibilityByContent", "(Landroid/view/ViewGroup;)V", "notifyRightContainerVisibilityChanged", "()V", "notifyLeftContainerVisibilityChanged", "", "text", "setTitle", "(I)V", "", "(Ljava/lang/CharSequence;)V", "", "getTitle", "()Ljava/lang/String;", "colorRes", "setTitleColor", "Landroid/content/res/ColorStateList;", "color", "(Landroid/content/res/ColorStateList;)V", "setSubtitle", "getSubtitle", "setSubtitleColor", "setMessage", "getMessage", "setMessageColor", "setLink", "getLink", "setLinkColor", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setLinkClickedListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/text/method/MovementMethod;", "movementMethod", "setLinkMovementMethod", "(Landroid/text/method/MovementMethod;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setAppearance", "minHeight", "setMinimumHeight", "Lcom/avito/android/lib/design/list_item/BaseListItem$Alignment;", "before", "after", "threshold", "setLeftAlignment", "(Lcom/avito/android/lib/design/list_item/BaseListItem$Alignment;Lcom/avito/android/lib/design/list_item/BaseListItem$Alignment;I)V", "setRightAlignment", "Landroid/content/res/TypedArray;", "array", AuthSource.SEND_ABUSE, "(Landroid/content/res/TypedArray;)V", "Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout;", "c", "(Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout;Lcom/avito/android/lib/design/list_item/BaseListItem$Alignment;Lcom/avito/android/lib/design/list_item/BaseListItem$Alignment;I)V", "f", "Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout;", "leftContainer", "Landroid/widget/LinearLayout;", "textContainer", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "messageView", g.a, "rightContainer", "h", "I", "firstLineAlignmentVerticalOffset", AuthSource.BOOKING_ORDER, "titleView", "e", "linkView", "i", "subtitleView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Alignment", "components_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"RtlHardcoded"})
public abstract class BaseListItem extends LinearLayout implements AppearanceChangeableView {
    public LinearLayout a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public AlignmentFrameLayout f;
    public AlignmentFrameLayout g;
    public int h;
    public int i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J#\u0010\u0007\u001a\u00060\u0006R\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/lib/design/list_item/BaseListItem$Alignment;", "", "Lcom/avito/android/lib/design/list_item/BaseListItem;", "listItem", "Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout;", "layout", "Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout$Alignment;", "create", "(Lcom/avito/android/lib/design/list_item/BaseListItem;Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout;)Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout$Alignment;", "CENTER", "FIRST_LINE_CENTER", "TWO_LINES_CENTER", "MIN_HEIGHT_CENTER", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Alignment extends Enum<Alignment> {
        public static final Alignment CENTER;
        public static final Alignment FIRST_LINE_CENTER;
        public static final Alignment MIN_HEIGHT_CENTER;
        public static final Alignment TWO_LINES_CENTER;
        public static final /* synthetic */ Alignment[] a;

        public static final class a extends Alignment {
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.avito.android.lib.design.list_item.BaseListItem.Alignment
            @NotNull
            public AlignmentFrameLayout.Alignment create(@NotNull BaseListItem baseListItem, @NotNull AlignmentFrameLayout alignmentFrameLayout) {
                Intrinsics.checkNotNullParameter(baseListItem, "listItem");
                Intrinsics.checkNotNullParameter(alignmentFrameLayout, "layout");
                return BaseListItem.access$createCenter(baseListItem, alignmentFrameLayout);
            }
        }

        public static final class b extends Alignment {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.avito.android.lib.design.list_item.BaseListItem.Alignment
            @NotNull
            public AlignmentFrameLayout.Alignment create(@NotNull BaseListItem baseListItem, @NotNull AlignmentFrameLayout alignmentFrameLayout) {
                Intrinsics.checkNotNullParameter(baseListItem, "listItem");
                Intrinsics.checkNotNullParameter(alignmentFrameLayout, "layout");
                return BaseListItem.access$createFirstLineCenter(baseListItem, alignmentFrameLayout);
            }
        }

        public static final class c extends Alignment {
            public c(String str, int i) {
                super(str, i, null);
            }

            @Override // com.avito.android.lib.design.list_item.BaseListItem.Alignment
            @NotNull
            public AlignmentFrameLayout.Alignment create(@NotNull BaseListItem baseListItem, @NotNull AlignmentFrameLayout alignmentFrameLayout) {
                Intrinsics.checkNotNullParameter(baseListItem, "listItem");
                Intrinsics.checkNotNullParameter(alignmentFrameLayout, "layout");
                return BaseListItem.access$createMinHeightCenter(baseListItem, alignmentFrameLayout);
            }
        }

        public static final class d extends Alignment {
            public d(String str, int i) {
                super(str, i, null);
            }

            @Override // com.avito.android.lib.design.list_item.BaseListItem.Alignment
            @NotNull
            public AlignmentFrameLayout.Alignment create(@NotNull BaseListItem baseListItem, @NotNull AlignmentFrameLayout alignmentFrameLayout) {
                Intrinsics.checkNotNullParameter(baseListItem, "listItem");
                Intrinsics.checkNotNullParameter(alignmentFrameLayout, "layout");
                return BaseListItem.access$createTwoLinesCenter(baseListItem, alignmentFrameLayout);
            }
        }

        static {
            a aVar = new a("CENTER", 0);
            CENTER = aVar;
            b bVar = new b("FIRST_LINE_CENTER", 1);
            FIRST_LINE_CENTER = bVar;
            d dVar = new d("TWO_LINES_CENTER", 2);
            TWO_LINES_CENTER = dVar;
            c cVar = new c("MIN_HEIGHT_CENTER", 3);
            MIN_HEIGHT_CENTER = cVar;
            a = new Alignment[]{aVar, bVar, dVar, cVar};
        }

        public Alignment(String str, int i, j jVar) {
            super(str, i);
        }

        public static Alignment valueOf(String str) {
            return (Alignment) Enum.valueOf(Alignment.class, str);
        }

        public static Alignment[] values() {
            return (Alignment[]) a.clone();
        }

        @NotNull
        public abstract AlignmentFrameLayout.Alignment create(@NotNull BaseListItem baseListItem, @NotNull AlignmentFrameLayout alignmentFrameLayout);
    }

    public BaseListItem(@Nullable Context context) {
        this(context, null);
    }

    public static final AlignmentFrameLayout.Alignment access$createCenter(BaseListItem baseListItem, AlignmentFrameLayout alignmentFrameLayout) {
        Objects.requireNonNull(baseListItem);
        return new AlignmentFrameLayout.Center(alignmentFrameLayout, 0.0f, 1, null);
    }

    public static final AlignmentFrameLayout.Alignment access$createFirstLineCenter(BaseListItem baseListItem, AlignmentFrameLayout alignmentFrameLayout) {
        TextPaint paint;
        Paint.FontMetrics fontMetrics;
        TextPaint paint2;
        Paint.FontMetrics fontMetrics2;
        TextPaint paint3;
        Paint.FontMetrics fontMetrics3;
        TextPaint paint4;
        Paint.FontMetrics fontMetrics4;
        LinearLayout linearLayout = baseListItem.a;
        float f2 = 0.0f;
        float paddingTop = (linearLayout != null ? (float) linearLayout.getPaddingTop() : 0.0f) + ((float) baseListItem.h);
        TextView textView = baseListItem.b;
        float f3 = (textView == null || (paint4 = textView.getPaint()) == null || (fontMetrics4 = paint4.getFontMetrics()) == null) ? 0.0f : fontMetrics4.ascent;
        TextView textView2 = baseListItem.b;
        float f4 = (f3 - ((textView2 == null || (paint3 = textView2.getPaint()) == null || (fontMetrics3 = paint3.getFontMetrics()) == null) ? 0.0f : fontMetrics3.top)) + paddingTop;
        TextView textView3 = baseListItem.b;
        float f5 = (textView3 == null || (paint2 = textView3.getPaint()) == null || (fontMetrics2 = paint2.getFontMetrics()) == null) ? 0.0f : fontMetrics2.descent;
        TextView textView4 = baseListItem.b;
        if (!(textView4 == null || (paint = textView4.getPaint()) == null || (fontMetrics = paint.getFontMetrics()) == null)) {
            f2 = fontMetrics.ascent;
        }
        return new AlignmentFrameLayout.Center(((f5 - f2) / 2.0f) + f4);
    }

    public static final AlignmentFrameLayout.Alignment access$createMinHeightCenter(BaseListItem baseListItem, AlignmentFrameLayout alignmentFrameLayout) {
        return new AlignmentFrameLayout.Center(((float) baseListItem.i) / 2.0f);
    }

    public static final AlignmentFrameLayout.Alignment access$createTwoLinesCenter(BaseListItem baseListItem, AlignmentFrameLayout alignmentFrameLayout) {
        TextPaint paint;
        Paint.FontMetrics fontMetrics;
        TextPaint paint2;
        Paint.FontMetrics fontMetrics2;
        TextPaint paint3;
        Paint.FontMetrics fontMetrics3;
        TextPaint paint4;
        Paint.FontMetrics fontMetrics4;
        LinearLayout linearLayout = baseListItem.a;
        int i2 = 0;
        int paddingTop = linearLayout != null ? linearLayout.getPaddingTop() : 0;
        LinearLayout linearLayout2 = baseListItem.a;
        if (linearLayout2 != null) {
            i2 = linearLayout2.getPaddingBottom();
        }
        TextView textView = baseListItem.b;
        float f2 = 0.0f;
        float f3 = (textView == null || (paint4 = textView.getPaint()) == null || (fontMetrics4 = paint4.getFontMetrics()) == null) ? 0.0f : fontMetrics4.bottom;
        TextView textView2 = baseListItem.b;
        float f4 = f3 - ((textView2 == null || (paint3 = textView2.getPaint()) == null || (fontMetrics3 = paint3.getFontMetrics()) == null) ? 0.0f : fontMetrics3.top);
        TextView textView3 = baseListItem.c;
        float f5 = (textView3 == null || (paint2 = textView3.getPaint()) == null || (fontMetrics2 = paint2.getFontMetrics()) == null) ? 0.0f : fontMetrics2.bottom;
        TextView textView4 = baseListItem.c;
        if (!(textView4 == null || (paint = textView4.getPaint()) == null || (fontMetrics = paint.getFontMetrics()) == null)) {
            f2 = fontMetrics.top;
        }
        return new AlignmentFrameLayout.Center((((((float) paddingTop) + f4) + (f5 - f2)) + ((float) i2)) / 2.0f);
    }

    public static void b(BaseListItem baseListItem, View view, int i2, int i3, int i4, int i5, int i6, Object obj) {
        int i7;
        if ((i6 & 1) != 0) {
            i2 = -1;
        }
        if ((i6 & 2) != 0) {
            i3 = -1;
        }
        if ((i6 & 4) != 0) {
            i4 = -1;
        }
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            if (i2 < 0) {
                i2 = marginLayoutParams.leftMargin;
            }
            if (i3 >= 0) {
                i7 = i4;
            } else {
                i7 = marginLayoutParams.topMargin;
            }
            if (i4 < 0) {
                i4 = marginLayoutParams.rightMargin;
            }
            if (i5 < 0) {
                i5 = marginLayoutParams.bottomMargin;
            }
            marginLayoutParams.setMargins(i2, i7, i4, i5);
            view.requestLayout();
        }
    }

    public static /* synthetic */ void setLeftAlignment$default(BaseListItem baseListItem, Alignment alignment, Alignment alignment2, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                i2 = -1;
            }
            baseListItem.setLeftAlignment(alignment, alignment2, i2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLeftAlignment");
    }

    public static /* synthetic */ void setRightAlignment$default(BaseListItem baseListItem, Alignment alignment, Alignment alignment2, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                i2 = -1;
            }
            baseListItem.setRightAlignment(alignment, alignment2, i2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRightAlignment");
    }

    private final void setVisibilityByContent(ViewGroup viewGroup) {
        View view;
        Iterator<View> it = ViewGroupsKt.getIterableChildren(viewGroup).iterator();
        while (true) {
            if (!it.hasNext()) {
                view = null;
                break;
            }
            view = it.next();
            if (Views.isVisible(view)) {
                break;
            }
        }
        Views.setVisible(viewGroup, view != null);
    }

    public final void a(TypedArray typedArray) {
        Integer num;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        int[] iArr = {R.styleable.BaseListItem_listItem_backgroundColor, R.styleable.BaseListItem_listItem_backgroundRipple};
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                num = null;
                break;
            }
            int i3 = iArr[i2];
            if (typedArray.hasValue(i3)) {
                num = Integer.valueOf(i3);
                break;
            }
            i2++;
        }
        if (num != null) {
            num.intValue();
            Views.setBackgroundCompat(this, RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, typedArray.getColorStateList(R.styleable.BaseListItem_listItem_backgroundColor), typedArray.getColorStateList(R.styleable.BaseListItem_listItem_backgroundRipple), 0, null, 0, 0, 0, 124, null));
        }
        int i4 = R.styleable.BaseListItem_listItem_titleAppearance;
        if (typedArray.hasValue(i4) && (textView8 = this.b) != null) {
            TextViews.setTextAppearanceCompat(textView8, typedArray.getResourceId(i4, 0));
        }
        int i5 = R.styleable.BaseListItem_listItem_subtitleAppearance;
        if (typedArray.hasValue(i5) && (textView7 = this.c) != null) {
            TextViews.setTextAppearanceCompat(textView7, typedArray.getResourceId(i5, 0));
        }
        int i6 = R.styleable.BaseListItem_listItem_messageAppearance;
        if (typedArray.hasValue(i6) && (textView6 = this.d) != null) {
            TextViews.setTextAppearanceCompat(textView6, typedArray.getResourceId(i6, 0));
        }
        int i7 = R.styleable.BaseListItem_listItem_linkAppearance;
        if (typedArray.hasValue(i7) && (textView5 = this.e) != null) {
            TextViews.setTextAppearanceCompat(textView5, typedArray.getResourceId(i7, 0));
        }
        int i8 = R.styleable.BaseListItem_listItem_titleColor;
        if (typedArray.hasValue(i8) && (textView4 = this.b) != null) {
            textView4.setTextColor(typedArray.getColorStateList(i8));
        }
        int i9 = R.styleable.BaseListItem_listItem_subtitleColor;
        if (typedArray.hasValue(i9) && (textView3 = this.c) != null) {
            textView3.setTextColor(typedArray.getColorStateList(i9));
        }
        int i10 = R.styleable.BaseListItem_listItem_messageColor;
        if (typedArray.hasValue(i10) && (textView2 = this.d) != null) {
            textView2.setTextColor(typedArray.getColorStateList(i10));
        }
        int i11 = R.styleable.BaseListItem_listItem_linkColor;
        if (typedArray.hasValue(i11) && (textView = this.e) != null) {
            textView.setTextColor(typedArray.getColorStateList(i11));
        }
        int i12 = R.styleable.BaseListItem_listItem_contentMinHeight;
        if (typedArray.hasValue(i12)) {
            setMinimumHeight(typedArray.getDimensionPixelSize(i12, 0));
        }
        int i13 = R.styleable.BaseListItem_listItem_contentSpacing;
        if (typedArray.hasValue(i13)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i13, 0);
            AlignmentFrameLayout alignmentFrameLayout = this.f;
            if (alignmentFrameLayout != null) {
                b(this, alignmentFrameLayout, 0, 0, dimensionPixelSize, 0, 11, null);
            }
            AlignmentFrameLayout alignmentFrameLayout2 = this.g;
            if (alignmentFrameLayout2 != null) {
                b(this, alignmentFrameLayout2, dimensionPixelSize, 0, 0, 0, 14, null);
            }
        }
        int i14 = R.styleable.BaseListItem_listItem_textMarginTop;
        if (typedArray.hasValue(i14) && (linearLayout3 = this.a) != null) {
            Views.changePadding$default(linearLayout3, 0, typedArray.getDimensionPixelSize(i14, 0), 0, 0, 13, null);
        }
        int i15 = R.styleable.BaseListItem_listItem_textMarginBottom;
        if (typedArray.hasValue(i15) && (linearLayout2 = this.a) != null) {
            Views.changePadding$default(linearLayout2, 0, 0, 0, typedArray.getDimensionPixelSize(i15, 0), 7, null);
        }
        int i16 = R.styleable.BaseListItem_listItem_textSpacing;
        if (typedArray.hasValue(i16) && (linearLayout = this.a) != null) {
            linearLayout.setDividerDrawable(ViewGroupsKt.spacing(typedArray.getDimensionPixelSize(i16, 0)));
        }
        int i17 = R.styleable.BaseListItem_listItem_firstLineAlignmentVerticalOffset;
        if (typedArray.hasValue(i17)) {
            this.h = typedArray.getDimensionPixelSize(i17, 0);
        }
        int i18 = R.styleable.BaseListItem_listItem_threshold;
        if (typedArray.hasValue(i18)) {
            int dimensionPixelSize2 = typedArray.getDimensionPixelSize(i18, 0);
            AlignmentFrameLayout alignmentFrameLayout3 = this.f;
            if (alignmentFrameLayout3 != null) {
                AlignmentFrameLayout.setAlignment$default(alignmentFrameLayout3, null, null, dimensionPixelSize2, 3, null);
            }
            AlignmentFrameLayout alignmentFrameLayout4 = this.g;
            if (alignmentFrameLayout4 != null) {
                AlignmentFrameLayout.setAlignment$default(alignmentFrameLayout4, null, null, dimensionPixelSize2, 3, null);
            }
        }
    }

    public final void c(AlignmentFrameLayout alignmentFrameLayout, Alignment alignment, Alignment alignment2, int i2) {
        if (alignment != null) {
            AlignmentFrameLayout.setAlignment$default(alignmentFrameLayout, alignment.create(this, alignmentFrameLayout), null, 0, 6, null);
        }
        if (alignment2 != null) {
            AlignmentFrameLayout.setAlignment$default(alignmentFrameLayout, null, alignment2.create(this, alignmentFrameLayout), 0, 5, null);
        }
        if (i2 >= 0) {
            AlignmentFrameLayout.setAlignment$default(alignmentFrameLayout, null, null, i2, 3, null);
        }
    }

    @NotNull
    public final String getLink() {
        CharSequence text;
        String obj;
        TextView textView = this.e;
        if (textView != null) {
            if (!Views.isVisible(textView)) {
                textView = null;
            }
            if (textView != null && (text = textView.getText()) != null && (obj = text.toString()) != null) {
                return obj;
            }
        }
        return "";
    }

    @NotNull
    public final String getMessage() {
        CharSequence text;
        String obj;
        TextView textView = this.d;
        if (textView != null) {
            if (!Views.isVisible(textView)) {
                textView = null;
            }
            if (textView != null && (text = textView.getText()) != null && (obj = text.toString()) != null) {
                return obj;
            }
        }
        return "";
    }

    @NotNull
    public final String getSubtitle() {
        CharSequence text;
        String obj;
        TextView textView = this.c;
        if (textView != null) {
            if (!Views.isVisible(textView)) {
                textView = null;
            }
            if (textView != null && (text = textView.getText()) != null && (obj = text.toString()) != null) {
                return obj;
            }
        }
        return "";
    }

    @NotNull
    public final String getTitle() {
        CharSequence text;
        String obj;
        TextView textView = this.b;
        if (textView != null) {
            if (!Views.isVisible(textView)) {
                textView = null;
            }
            if (textView != null && (text = textView.getText()) != null && (obj = text.toString()) != null) {
                return obj;
            }
        }
        return "";
    }

    public final void notifyLeftContainerVisibilityChanged() {
        AlignmentFrameLayout alignmentFrameLayout = this.f;
        if (alignmentFrameLayout != null) {
            setVisibilityByContent(alignmentFrameLayout);
        }
    }

    public final void notifyRightContainerVisibilityChanged() {
        AlignmentFrameLayout alignmentFrameLayout = this.g;
        if (alignmentFrameLayout != null) {
            setVisibilityByContent(alignmentFrameLayout);
        }
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i2, R.styleable.BaseListItem);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearanceFromAttr(@AttrRes int i2) {
        AppearanceChangeableView.DefaultImpls.setAppearanceFromAttr(this, i2);
    }

    public final void setLeftAlignment(@Nullable Alignment alignment, @Nullable Alignment alignment2, int i2) {
        AlignmentFrameLayout alignmentFrameLayout = this.f;
        if (alignmentFrameLayout != null) {
            c(alignmentFrameLayout, alignment, alignment2, i2);
        }
    }

    public void setLink(@Nullable CharSequence charSequence) {
        TextView textView = this.e;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
    }

    public final void setLinkClickedListener(@Nullable View.OnClickListener onClickListener) {
        TextView textView = this.e;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public final void setLinkColor(@ColorRes int i2) {
        ColorStateList colorStateListCompat = Contexts.getColorStateListCompat(getContext(), i2);
        if (colorStateListCompat != null) {
            setLinkColor(colorStateListCompat);
        }
    }

    public final void setLinkMovementMethod(@NotNull MovementMethod movementMethod) {
        Intrinsics.checkNotNullParameter(movementMethod, "movementMethod");
        TextView textView = this.e;
        if (textView != null) {
            textView.setMovementMethod(movementMethod);
        }
    }

    public final void setMessage(@StringRes int i2) {
        setMessage(getContext().getString(i2));
    }

    public final void setMessageColor(@ColorRes int i2) {
        ColorStateList colorStateListCompat = Contexts.getColorStateListCompat(getContext(), i2);
        if (colorStateListCompat != null) {
            setMessageColor(colorStateListCompat);
        }
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        super.setMinimumHeight(i2);
        this.i = i2;
        LinearLayout linearLayout = this.a;
        if (linearLayout != null) {
            linearLayout.setMinimumHeight(i2);
        }
    }

    public final void setRightAlignment(@Nullable Alignment alignment, @Nullable Alignment alignment2, int i2) {
        AlignmentFrameLayout alignmentFrameLayout = this.g;
        if (alignmentFrameLayout != null) {
            c(alignmentFrameLayout, alignment, alignment2, i2);
        }
    }

    public final void setSubtitle(@StringRes int i2) {
        setSubtitle(getContext().getString(i2));
    }

    public final void setSubtitleColor(@ColorRes int i2) {
        ColorStateList colorStateListCompat = Contexts.getColorStateListCompat(getContext(), i2);
        if (colorStateListCompat != null) {
            setSubtitleColor(colorStateListCompat);
        }
    }

    public final void setTitle(@StringRes int i2) {
        setTitle(getContext().getString(i2));
    }

    public final void setTitleColor(@ColorRes int i2) {
        ColorStateList colorStateListCompat = Contexts.getColorStateListCompat(getContext(), i2);
        if (colorStateListCompat != null) {
            setTitleColor(colorStateListCompat);
        }
    }

    public BaseListItem(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setMessage(@Nullable CharSequence charSequence) {
        TextView textView = this.d;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
    }

    public void setSubtitle(@Nullable CharSequence charSequence) {
        TextView textView = this.c;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        TextView textView = this.b;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BaseListItem(@org.jetbrains.annotations.Nullable android.content.Context r6, @org.jetbrains.annotations.Nullable android.util.AttributeSet r7, int r8) {
        /*
        // Method dump skipped, instructions count: 284
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.list_item.BaseListItem.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public final void setLinkColor(@NotNull ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "color");
        TextView textView = this.e;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public final void setMessageColor(@NotNull ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "color");
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public final void setSubtitleColor(@NotNull ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "color");
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public final void setTitleColor(@NotNull ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "color");
        TextView textView = this.b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
