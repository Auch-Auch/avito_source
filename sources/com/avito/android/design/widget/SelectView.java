package com.avito.android.design.widget;

import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001^B'\b\u0017\u0012\u0006\u0010X\u001a\u00020W\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u0012\b\b\u0002\u0010[\u001a\u00020\u0013¢\u0006\u0004\b\\\u0010]J\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\nJ\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001a¢\u0006\u0004\b\u001f\u0010\u001dJ\u001d\u0010\"\u001a\u00020\u00042\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u001aH\u0016¢\u0006\u0004\b%\u0010\u001dJ\u0011\u0010'\u001a\u0004\u0018\u00010&H\u0014¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010&H\u0014¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010\u0019J\u000f\u0010-\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010\u0019R\u0016\u00100\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u001e\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010/R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u00104R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u00107R\u0016\u0010J\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010/R\u0016\u0010L\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u00107R\u0016\u0010N\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010/R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u00104R\u001e\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010FR\u0016\u0010U\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010/R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u00104¨\u0006_"}, d2 = {"Lcom/avito/android/design/widget/SelectView;", "Landroid/widget/RelativeLayout;", "Lcom/avito/android/design/widget/PostingView;", "Landroid/widget/TextView;", "", "setNormalOrDisabledTextColor", "(Landroid/widget/TextView;)V", "", "value", "setValue", "(Ljava/lang/CharSequence;)V", "getValue", "()Ljava/lang/CharSequence;", "title", "setTitle", "getTitle", "info", "setInfo", "getInfo", "", "stringRes", "setError", "(I)V", "error", "clearError", "()V", "", "visible", "setIconVisible", "(Z)V", "canBeCleared", "setCanBeCleared", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClearListener", "(Lkotlin/jvm/functions/Function0;)V", "enabled", "setEnabled", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "d", "I", "normalTextColor", "p", "Z", AuthSource.OPEN_CHANNEL_LIST, "Ljava/lang/CharSequence;", "hint", "h", "Landroid/widget/TextView;", "infoLabel", "e", "disabledTextColor", "Landroid/widget/ImageView;", "j", "Landroid/widget/ImageView;", "iconView", "l", "Landroid/view/View$OnClickListener;", "r", "Landroid/view/View$OnClickListener;", "onClearClickListener", "Landroid/view/View;", "i", "Landroid/view/View;", "infoLabelDivider", "f", "floatingLabel", "hintHiddenValueVerticalMargin", g.a, "valueLabel", "c", "errorTextColor", "n", VKApiConst.Q, "Lkotlin/jvm/functions/Function0;", "clearListener", "k", "clearButton", "hintVisibleValueVerticalMargin", "o", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SavedState", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SelectView extends RelativeLayout implements PostingView {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final View i;
    public final ImageView j;
    public final View k;
    public CharSequence l;
    public CharSequence m;
    public CharSequence n;
    public CharSequence o;
    public boolean p;
    public Function0<Unit> q;
    public final View.OnClickListener r;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SelectView a;

        public a(SelectView selectView) {
            this.a = selectView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.setValue(null);
            Function0 function0 = this.a.q;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    @JvmOverloads
    public SelectView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public SelectView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        a aVar = new a(this);
        this.r = aVar;
        this.a = getResources().getDimensionPixelSize(R.dimen.hint_visible_value_vertical_margin);
        this.b = getResources().getDimensionPixelSize(R.dimen.hint_hidden_value_vertical_margin);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SelectView);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SelectView_android_layout, R.layout.posting_select_view), this);
        this.f = (TextView) Views.findById(this, R.id.floating_label);
        this.g = (TextView) Views.findById(this, R.id.value_label);
        this.h = (TextView) Views.findById(this, R.id.info_label);
        this.i = Views.findById(this, R.id.info_label_divider);
        this.j = (ImageView) Views.findById(this, R.id.icon);
        View findById = Views.findById(this, R.id.clear_button);
        this.k = findById;
        findById.setOnClickListener(aVar);
        this.d = obtainStyledAttributes.getColor(R.styleable.SelectView_android_textColor, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.black));
        this.e = obtainStyledAttributes.getColor(R.styleable.SelectView_disableTextColor, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray48));
        this.c = obtainStyledAttributes.getColor(R.styleable.SelectView_errorTextColor, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.red));
        setTitle(obtainStyledAttributes.getString(R.styleable.SelectView_android_hint));
        setInfo(obtainStyledAttributes.getString(R.styleable.SelectView_infoText));
        setValue(obtainStyledAttributes.getString(R.styleable.SelectView_android_text));
        setIconVisible(obtainStyledAttributes.getBoolean(R.styleable.SelectView_iconVisible, true));
        obtainStyledAttributes.recycle();
    }

    private final void setNormalOrDisabledTextColor(TextView textView) {
        if (textView.isEnabled()) {
            textView.setTextColor(this.d);
        } else {
            textView.setTextColor(this.e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
        if ((r0 == null || r0.length() == 0) != false) goto L_0x002c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r5 = this;
            boolean r0 = r5.p
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002b
            java.lang.CharSequence r0 = r5.l
            if (r0 == 0) goto L_0x0017
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            if (r0 == 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x002b
            java.lang.CharSequence r0 = r5.o
            if (r0 == 0) goto L_0x0027
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r0 = 0
            goto L_0x0028
        L_0x0027:
            r0 = 1
        L_0x0028:
            if (r0 == 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            android.view.View r0 = r5.k
            com.avito.android.util.Views.setVisible(r0, r1)
            if (r1 == 0) goto L_0x0036
            int r0 = com.avito.android.ui_components.R.id.clear_button
            goto L_0x0038
        L_0x0036:
            int r0 = com.avito.android.ui_components.R.id.icon
        L_0x0038:
            android.widget.TextView r1 = r5.f
            android.view.ViewGroup$LayoutParams r3 = r1.getLayoutParams()
            if (r3 == 0) goto L_0x004c
            boolean r4 = r3 instanceof android.widget.RelativeLayout.LayoutParams
            if (r4 == 0) goto L_0x004c
            android.widget.RelativeLayout$LayoutParams r3 = (android.widget.RelativeLayout.LayoutParams) r3
            r3.addRule(r2, r0)
            r1.requestLayout()
        L_0x004c:
            android.widget.TextView r1 = r5.g
            android.view.ViewGroup$LayoutParams r3 = r1.getLayoutParams()
            if (r3 == 0) goto L_0x0060
            boolean r4 = r3 instanceof android.widget.RelativeLayout.LayoutParams
            if (r4 == 0) goto L_0x0060
            android.widget.RelativeLayout$LayoutParams r3 = (android.widget.RelativeLayout.LayoutParams) r3
            r3.addRule(r2, r0)
            r1.requestLayout()
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.design.widget.SelectView.a():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if ((r0.length() > 0) != false) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r3 = this;
            java.lang.CharSequence r0 = r3.l
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0012
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            if (r0 == 0) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            if (r1 == 0) goto L_0x001d
            android.widget.TextView r0 = r3.f
            com.avito.android.util.Views.show(r0)
            int r0 = r3.a
            goto L_0x0024
        L_0x001d:
            android.widget.TextView r0 = r3.f
            com.avito.android.util.Views.hide(r0)
            int r0 = r3.b
        L_0x0024:
            android.widget.TextView r1 = r3.g
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams"
            java.util.Objects.requireNonNull(r1, r2)
            android.widget.RelativeLayout$LayoutParams r1 = (android.widget.RelativeLayout.LayoutParams) r1
            int r2 = r1.topMargin
            if (r2 == r0) goto L_0x0042
            int r2 = r1.bottomMargin
            if (r2 == r0) goto L_0x0042
            r1.topMargin = r0
            r1.bottomMargin = r0
            android.widget.TextView r0 = r3.g
            r0.requestLayout()
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.design.widget.SelectView.b():void");
    }

    @Override // com.avito.android.design.widget.PostingView
    public void clearError() {
        setError((CharSequence) null);
    }

    @Override // com.avito.android.design.widget.PostingView
    @Nullable
    public CharSequence getInfo() {
        return this.n;
    }

    @Override // com.avito.android.design.widget.PostingView
    @Nullable
    public CharSequence getTitle() {
        return this.m;
    }

    @Override // com.avito.android.design.widget.PostingView
    @Nullable
    public CharSequence getValue() {
        return this.l;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setTitle(savedState.getHint());
        setInfo(savedState.getInfo());
        setValue(savedState.getValue());
        setError(savedState.getError());
        setCanBeCleared(savedState.getCanBeCleared());
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "super.onSaveInstanceState()!!");
        return new SavedState(this.l, this.m, this.n, this.o, this.p, onSaveInstanceState);
    }

    public final void setCanBeCleared(boolean z) {
        this.p = z;
        a();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.g.setEnabled(z);
        setNormalOrDisabledTextColor(this.g);
        setIconVisible(z);
    }

    @Override // com.avito.android.design.widget.PostingView
    public void setError(int i2) {
        setError(getResources().getString(i2));
    }

    public final void setIconVisible(boolean z) {
        Views.setVisible(this.j, z);
    }

    @Override // com.avito.android.design.widget.PostingView
    public void setInfo(@Nullable CharSequence charSequence) {
        this.n = charSequence;
        this.h.setText(charSequence);
        CharSequence charSequence2 = this.n;
        boolean z = false;
        if (charSequence2 != null) {
            if (charSequence2.length() > 0) {
                z = true;
            }
        }
        if (z) {
            Views.show(this.h);
            Views.show(this.i);
            return;
        }
        Views.hide(this.h);
        Views.hide(this.i);
    }

    public final void setOnClearListener(@Nullable Function0<Unit> function0) {
        this.q = function0;
    }

    @Override // com.avito.android.design.widget.PostingView
    public void setTitle(@Nullable CharSequence charSequence) {
        this.m = charSequence;
        this.f.setText(charSequence);
        this.g.setHint(charSequence);
    }

    @Override // com.avito.android.design.widget.PostingView
    public void setValue(@Nullable CharSequence charSequence) {
        clearError();
        this.l = charSequence;
        this.g.setText(charSequence);
        b();
        a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if ((r3.length() > 0) != false) goto L_0x001e;
     */
    @Override // com.avito.android.design.widget.PostingView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setError(@org.jetbrains.annotations.Nullable java.lang.CharSequence r3) {
        /*
            r2 = this;
            r2.o = r3
            android.widget.TextView r0 = r2.g
            r0.setText(r3)
            r2.b()
            r2.a()
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L_0x001d
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0019
            r3 = 1
            goto L_0x001a
        L_0x0019:
            r3 = 0
        L_0x001a:
            if (r3 == 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            if (r0 == 0) goto L_0x0028
            android.widget.TextView r3 = r2.g
            int r0 = r2.c
            r3.setTextColor(r0)
            goto L_0x002d
        L_0x0028:
            android.widget.TextView r3 = r2.g
            r2.setNormalOrDisabledTextColor(r3)
        L_0x002d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.design.widget.SelectView.setError(java.lang.CharSequence):void");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%BA\b\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"B\u0011\b\u0016\u0012\u0006\u0010#\u001a\u00020\u0002¢\u0006\u0004\b!\u0010$J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\rR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\r¨\u0006&"}, d2 = {"Lcom/avito/android/design/widget/SelectView$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getHint", "()Ljava/lang/String;", "hint", "", "e", "Z", "getCanBeCleared", "()Z", "canBeCleared", AuthSource.SEND_ABUSE, "getValue", "value", "d", "getError", "error", "c", "getInfo", "info", "", "Landroid/os/Parcelable;", "superState", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLandroid/os/Parcelable;)V", "source", "(Landroid/os/Parcel;)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends View.BaseSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @Nullable
        public final String a;
        @Nullable
        public final String b;
        @Nullable
        public final String c;
        @Nullable
        public final String d;
        public final boolean e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/design/widget/SelectView$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/design/widget/SelectView$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, SavedState> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public SavedState invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new SavedState(parcel2);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable CharSequence charSequence3, @Nullable CharSequence charSequence4, boolean z, @NotNull Parcelable parcelable) {
            super(parcelable);
            Intrinsics.checkNotNullParameter(parcelable, "superState");
            String str = null;
            this.a = charSequence != null ? charSequence.toString() : null;
            this.b = charSequence2 != null ? charSequence2.toString() : null;
            this.c = charSequence3 != null ? charSequence3.toString() : null;
            this.d = charSequence4 != null ? charSequence4.toString() : str;
            this.e = z;
        }

        public final boolean getCanBeCleared() {
            return this.e;
        }

        @Nullable
        public final String getError() {
            return this.d;
        }

        @Nullable
        public final String getHint() {
            return this.b;
        }

        @Nullable
        public final String getInfo() {
            return this.c;
        }

        @Nullable
        public final String getValue() {
            return this.a;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            ParcelsKt.writeBool(parcel, this.e);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcel parcel) {
            super(parcel);
            Intrinsics.checkNotNullParameter(parcel, "source");
            this.a = parcel.readString();
            this.b = parcel.readString();
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = ParcelsKt.readBool(parcel);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectView(Context context, AttributeSet attributeSet, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
