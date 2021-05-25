package com.avito.android.advert_core.advert;

import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.advert.ExpandablePanelLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.util.ParcelsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.model.VKApiUserFull;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u00012\u00020\u0002:\u0002XYB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\bT\u0010UB\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bT\u0010VB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bT\u0010WB+\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\bT\u0010\fJ1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0016\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\"\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\n2\b\b\u0001\u0010$\u001a\u00020\u0007¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\n¢\u0006\u0004\b'\u0010\u0019J\u0017\u0010)\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b,\u0010-J\u0011\u0010.\u001a\u0004\u0018\u00010+H\u0014¢\u0006\u0004\b.\u0010-J\u0015\u00100\u001a\u00020\n2\u0006\u0010/\u001a\u00020+¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\n2\u0006\u0010/\u001a\u00020+H\u0014¢\u0006\u0004\b2\u00101J\u0017\u00104\u001a\u00020\n2\u0006\u00103\u001a\u00020\u0011H\u0016¢\u0006\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u00107R\u0018\u0010<\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u00107R\u0016\u0010E\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010?R\u0016\u0010I\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010DR\u0016\u0010K\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010DR\u0016\u0010N\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u00107¨\u0006Z"}, d2 = {"Lcom/avito/android/advert_core/advert/ExpandablePanelLayout;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "", AuthSource.SEND_ABUSE, "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Lcom/avito/android/advert_core/advert/ExpandablePanelLayout$ExpandLayoutListener;", "layoutListener", "setOnExpandListener", "(Lcom/avito/android/advert_core/advert/ExpandablePanelLayout$ExpandLayoutListener;)V", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, FirebaseAnalytics.Param.INDEX, "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "onFinishInflate", "()V", Tracker.Events.CREATIVE_COLLAPSE, "", "notifyListener", Tracker.Events.CREATIVE_EXPAND, "(Z)V", "", "text", "colorState", "setText", "(Ljava/lang/CharSequence;Z)V", "color", "setTextColor", "(I)V", "showDivider", "count", "setCollapsedLineCount", "(Ljava/lang/Integer;)V", "Landroid/os/Parcelable;", "onSaveState", "()Landroid/os/Parcelable;", "onSaveInstanceState", "state", "onRestoreState", "(Landroid/os/Parcelable;)V", "onRestoreInstanceState", "view", "onClick", "(Landroid/view/View;)V", AuthSource.BOOKING_ORDER, "I", "contentTextViewId", "handleButtonId", "d", "Landroid/view/View;", "divider", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "handleView", "c", "dividerViewId", "l", "Z", "isManualEllipsize", "f", "contentView", "k", "isCollapsingEnabled", g.a, "isExpanded", "h", "Ljava/lang/CharSequence;", "fullText", "j", "Lcom/avito/android/advert_core/advert/ExpandablePanelLayout$ExpandLayoutListener;", "expandLayoutListener", "i", "collapsedLinesCount", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ExpandLayoutListener", "SavedState", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class ExpandablePanelLayout extends LinearLayout implements View.OnClickListener {
    public int a = R.id.expandable_panel_expand_button;
    public int b = R.id.expandable_panel_advert_description;
    public int c = R.id.expandable_panel_divider_top;
    public View d;
    public TextView e;
    public TextView f;
    public boolean g;
    public CharSequence h = "";
    public int i = 4;
    public ExpandLayoutListener j;
    public boolean k;
    public boolean l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_core/advert/ExpandablePanelLayout$ExpandLayoutListener;", "", "Landroid/view/View;", "handle", "content", "", "onExpand", "(Landroid/view/View;Landroid/view/View;)V", "onCollapse", "onExpandExist", "()V", "onCopyText", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public interface ExpandLayoutListener {
        void onCollapse(@Nullable View view, @NotNull View view2);

        void onCopyText();

        void onExpand(@Nullable View view, @NotNull View view2);

        void onExpandExist();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\n8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert_core/advert/ExpandablePanelLayout$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Z", "getExpanded$advert_core_release", "()Z", "setExpanded$advert_core_release", "(Z)V", PanelStateKt.PANEL_EXPANDED, AuthSource.BOOKING_ORDER, "isCollapsingEnabled$advert_core_release", "setCollapsingEnabled$advert_core_release", "isCollapsingEnabled", "superState", "<init>", "(Landroid/os/Parcelable;)V", "Companion", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends View.BaseSavedState implements Parcelable {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = new ExpandablePanelLayout$SavedState$Companion$CREATOR$1();
        @NotNull
        public static final Companion Companion = new Companion(null);
        public boolean a;
        public boolean b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/advert_core/advert/ExpandablePanelLayout$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/advert_core/advert/ExpandablePanelLayout$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcelable parcelable) {
            super(parcelable);
            Intrinsics.checkNotNullParameter(parcelable, "superState");
        }

        public final boolean getExpanded$advert_core_release() {
            return this.a;
        }

        public final boolean isCollapsingEnabled$advert_core_release() {
            return this.b;
        }

        public final void setCollapsingEnabled$advert_core_release(boolean z) {
            this.b = z;
        }

        public final void setExpanded$advert_core_release(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            super.writeToParcel(parcel, i);
            ParcelsKt.writeBool(parcel, this.a);
            ParcelsKt.writeBool(parcel, this.b);
        }

        public SavedState(Parcel parcel, j jVar) {
            super(parcel);
            this.a = ParcelsKt.readBool(parcel);
            this.b = ParcelsKt.readBool(parcel);
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ ExpandablePanelLayout a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ boolean c;

        public a(ExpandablePanelLayout expandablePanelLayout, TextView textView, boolean z) {
            this.a = expandablePanelLayout;
            this.b = textView;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.b.getLineCount() == 0 && (!this.a.g)) {
                this.b.measure(View.MeasureSpec.makeMeasureSpec(this.a.getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            }
            if (this.b.getLineCount() <= this.a.i || this.a.g) {
                this.b.setMaxLines(Integer.MAX_VALUE);
                TextView textView = this.a.e;
                if (textView != null) {
                    textView.setVisibility(this.a.k ? 0 : 8);
                }
            } else {
                this.b.setMaxLines(this.a.i);
                if (this.a.l && this.a.i > 0 && this.a.h.length() > 2) {
                    SpannableStringBuilder append = new SpannableStringBuilder(this.a.h.subSequence(0, this.b.getLayout().getLineEnd(this.a.i - 1) - 1)).append((CharSequence) "…");
                    Intrinsics.checkNotNullExpressionValue(append, "SpannableStringBuilder(f…             .append(END)");
                    this.b.setText(append);
                }
                TextView textView2 = this.a.e;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                ExpandLayoutListener expandLayoutListener = this.a.j;
                if (expandLayoutListener != null) {
                    expandLayoutListener.onExpandExist();
                }
            }
            if (this.c) {
                TextView textView3 = this.a.e;
                if (textView3 != null) {
                    textView3.setBackgroundResource(0);
                }
                TextView textView4 = this.a.e;
                if (textView4 != null) {
                    textView4.setTextColor(ContextCompat.getColorStateList(this.a.getContext(), com.avito.android.ui_components.R.color.params_link));
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandablePanelLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, null, 0, 0);
    }

    public static /* synthetic */ void expand$default(ExpandablePanelLayout expandablePanelLayout, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        expandablePanelLayout.expand(z);
    }

    public static /* synthetic */ void setText$default(ExpandablePanelLayout expandablePanelLayout, CharSequence charSequence, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        expandablePanelLayout.setText(charSequence, z);
    }

    public final void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.avito.android.ui_components.R.styleable.ExpandablePanelLayout, i2, i3);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, Navigation.ATTRIBUTES);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == com.avito.android.ui_components.R.styleable.ExpandablePanelLayout_handleId) {
                this.a = obtainStyledAttributes.getResourceId(index, this.a);
            } else if (index == com.avito.android.ui_components.R.styleable.ExpandablePanelLayout_contentId) {
                this.b = obtainStyledAttributes.getResourceId(index, this.b);
            } else if (index == com.avito.android.ui_components.R.styleable.ExpandablePanelLayout_topDividerId) {
                this.c = obtainStyledAttributes.getResourceId(index, this.c);
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View view, int i2, @Nullable ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        Intrinsics.checkNotNull(view);
        int id = view.getId();
        if (id == this.a) {
            this.e = (TextView) view;
        } else if (id == this.b) {
            this.f = (TextView) view;
        } else if (id == this.c) {
            this.d = view;
        }
    }

    public final void collapse() {
        TextView textView = this.f;
        if (textView != null) {
            this.g = false;
            textView.setMaxLines(this.i);
            ExpandLayoutListener expandLayoutListener = this.j;
            if (expandLayoutListener != null) {
                expandLayoutListener.onCollapse(this.e, textView);
            }
        }
    }

    public final void expand(boolean z) {
        ExpandLayoutListener expandLayoutListener;
        TextView textView = this.f;
        if (textView != null) {
            this.g = true;
            textView.setMaxLines(Integer.MAX_VALUE);
            if (this.l) {
                textView.setText(this.h);
            }
            if (z && (expandLayoutListener = this.j) != null) {
                expandLayoutListener.onExpand(this.e, textView);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id != this.a && id != this.b) {
            return;
        }
        if (!this.g) {
            expand$default(this, false, 1, null);
        } else if (this.k) {
            collapse();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        boolean z;
        ViewGroup.LayoutParams layoutParams;
        super.onFinishInflate();
        TextView textView = this.e;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            textView2.setCustomSelectionActionModeCallback(new ActionMode.Callback(this) { // from class: com.avito.android.advert_core.advert.ExpandablePanelLayout$onFinishInflate$1
                public final /* synthetic */ ExpandablePanelLayout a;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.a = r1;
                }

                @Override // android.view.ActionMode.Callback
                public boolean onActionItemClicked(@Nullable ActionMode actionMode, @Nullable MenuItem menuItem) {
                    ExpandablePanelLayout.ExpandLayoutListener expandLayoutListener;
                    if (menuItem == null || menuItem.getItemId() != 16908321 || (expandLayoutListener = this.a.j) == null) {
                        return false;
                    }
                    expandLayoutListener.onCopyText();
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(@Nullable ActionMode actionMode, @Nullable Menu menu) {
                    return true;
                }

                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(@Nullable ActionMode actionMode) {
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(@Nullable ActionMode actionMode, @Nullable Menu menu) {
                    return true;
                }
            });
        }
        TextView textView3 = this.f;
        if (!(textView3 == null || (layoutParams = textView3.getLayoutParams()) == null || layoutParams.width != -2)) {
            TextView textView4 = this.f;
            if ((textView4 != null ? textView4.getEllipsize() : null) == TextUtils.TruncateAt.END) {
                z = true;
                this.l = z;
            }
        }
        z = false;
        this.l = z;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@NotNull Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "state");
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.g = savedState.getExpanded$advert_core_release();
        this.k = savedState.isCollapsingEnabled$advert_core_release();
        if (this.g) {
            expand(false);
        }
    }

    public final void onRestoreState(@NotNull Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "state");
        onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "super.onSaveInstanceState()!!");
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.setExpanded$advert_core_release(this.g);
        savedState.setCollapsingEnabled$advert_core_release(this.k);
        return savedState;
    }

    @Nullable
    public final Parcelable onSaveState() {
        return onSaveInstanceState();
    }

    public final void setCollapsedLineCount(@Nullable Integer num) {
        if (num != null) {
            this.i = num.intValue();
        }
    }

    public final void setOnExpandListener(@NotNull ExpandLayoutListener expandLayoutListener) {
        Intrinsics.checkNotNullParameter(expandLayoutListener, "layoutListener");
        this.j = expandLayoutListener;
    }

    public final void setText(@Nullable CharSequence charSequence, boolean z) {
        TextView textView = this.f;
        if (textView != null && !Intrinsics.areEqual(charSequence, this.h)) {
            textView.setText(charSequence);
            if (charSequence == null) {
                charSequence = "";
            }
            this.h = charSequence;
            textView.post(new a(this, textView, z));
        }
    }

    public final void setTextColor(@ColorInt int i2) {
        TextView textView = this.f;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public final void showDivider() {
        View view = this.d;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandablePanelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, attributeSet, 0, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandablePanelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, attributeSet, i2, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandablePanelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, attributeSet, i2, i3);
    }
}
