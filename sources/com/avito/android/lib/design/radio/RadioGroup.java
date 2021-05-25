package com.avito.android.lib.design.radio;

import a2.g.r.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import com.avito.android.authorization.auth.tracker.check.CheckTrackerModule;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.radio.RadioCheckable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.util.Parcels;
import com.avito.android.util.TextViews;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004\u0011z\u0007{B\u0011\b\u0016\u0012\u0006\u0010t\u001a\u00020s¢\u0006\u0004\bu\u0010vB\u001b\b\u0016\u0012\u0006\u0010t\u001a\u00020s\u0012\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\bu\u0010wB#\b\u0017\u0012\u0006\u0010t\u001a\u00020s\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010x\u001a\u00020\u0002¢\u0006\u0004\bu\u0010yJ!\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\bJ-\u0010\u0011\u001a\u00020\u0006*\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\u00020\u0006*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u001a\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0018H\u0014¢\u0006\u0004\b&\u0010'J\u0017\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H\u0014¢\u0006\u0004\b2\u00103J\u0019\u00105\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u000101H\u0014¢\u0006\u0004\b5\u00106J/\u0010;\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u0002H\u0016¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u0006¢\u0006\u0004\b=\u0010\u001dJ\u0017\u0010>\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0002H\u0007¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u00062\b\u0010B\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001a\u00020\r¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020\u00062\b\u0010G\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bH\u0010DJ\r\u0010I\u001a\u00020\r¢\u0006\u0004\bI\u0010FJ\u0017\u0010K\u001a\u00020\u00062\b\u0010J\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bK\u0010DJ\r\u0010L\u001a\u00020\r¢\u0006\u0004\bL\u0010FJ\u0017\u0010N\u001a\u00020\u00062\b\b\u0001\u0010M\u001a\u00020\u0002¢\u0006\u0004\bN\u0010?J\u0017\u0010O\u001a\u00020\u00062\b\b\u0001\u0010M\u001a\u00020\u0002¢\u0006\u0004\bO\u0010?J\r\u0010P\u001a\u00020\u0006¢\u0006\u0004\bP\u0010\u001dR$\u0010X\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001a\u0010\\\u001a\u00060YR\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010]R\u0016\u0010_\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010]R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR2\u0010h\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150dj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015`e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010k\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010n\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010o\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010]R\u0016\u0010p\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010mR\u0016\u0010r\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010m¨\u0006|"}, d2 = {"Lcom/avito/android/lib/design/radio/RadioGroup;", "Landroid/widget/LinearLayout;", "", "id", "", "isChecked", "", AuthSource.BOOKING_ORDER, "(IZ)V", "viewId", "checked", "c", "Landroid/widget/TextView;", "", "text", "startMargin", "endMargin", AuthSource.SEND_ABUSE, "(Landroid/widget/TextView;Ljava/lang/String;II)V", "d", "(Landroid/widget/TextView;II)V", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, FirebaseAnalytics.Param.INDEX, "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "onFinishInflate", "()V", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "enabled", "setEnabled", "(Z)V", "p", "checkLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Z", "Landroid/util/AttributeSet;", "attrs", "Landroid/widget/LinearLayout$LayoutParams;", "generateLayoutParams", "(Landroid/util/AttributeSet;)Landroid/widget/LinearLayout$LayoutParams;", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnHierarchyChangeListener", "(Landroid/view/ViewGroup$OnHierarchyChangeListener;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "setPadding", "(IIII)V", "clearChecked", CheckTrackerModule.NAME, "(I)V", "getCheckedRadioButtonId", "()I", "title", "setTitle", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "getSubtitle", "hint", "setHint", "getHint", "color", "setHintColorRes", "setHintColor", "removeAllRadioButtons", "Lcom/avito/android/lib/design/radio/RadioGroup$OnCheckedChangeListener;", "k", "Lcom/avito/android/lib/design/radio/RadioGroup$OnCheckedChangeListener;", "getOnCheckedChangeListener", "()Lcom/avito/android/lib/design/radio/RadioGroup$OnCheckedChangeListener;", "setOnCheckedChangeListener", "(Lcom/avito/android/lib/design/radio/RadioGroup$OnCheckedChangeListener;)V", "onCheckedChangeListener", "Lcom/avito/android/lib/design/radio/RadioGroup$b;", g.a, "Lcom/avito/android/lib/design/radio/RadioGroup$b;", "passThroughListener", "Landroid/widget/TextView;", "hintTextView", "titleTextView", "Lcom/avito/android/lib/design/radio/RadioCheckable$OnCheckedChangeListener;", "h", "Lcom/avito/android/lib/design/radio/RadioCheckable$OnCheckedChangeListener;", "childOnCheckedChangeListener", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "f", "Ljava/util/HashMap;", "radioChildrenMap", "e", "Z", "protectFromCheckedChange", "i", "I", "childrenStartPadding", "subtitleTextView", "checkedId", "j", "childrenEndPadding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OnCheckedChangeListener", "SavedState", "components_release"}, k = 1, mv = {1, 4, 2})
public final class RadioGroup extends LinearLayout {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    @IdRes
    public int d;
    public boolean e;
    public final HashMap<Integer, View> f;
    public final b g;
    public final RadioCheckable.OnCheckedChangeListener h;
    public int i;
    public int j;
    @Nullable
    public OnCheckedChangeListener k;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/lib/design/radio/RadioGroup$OnCheckedChangeListener;", "", "Lcom/avito/android/lib/design/radio/RadioGroup;", "radioGroup", "Lcom/avito/android/lib/design/radio/RadioButton;", "radioButton", "", "isChecked", "", "onCheckedChanged", "(Lcom/avito/android/lib/design/radio/RadioGroup;Lcom/avito/android/lib/design/radio/RadioButton;Z)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public interface OnCheckedChangeListener {
        void onCheckedChanged(@NotNull RadioGroup radioGroup, @NotNull RadioButton radioButton, boolean z);
    }

    public final class a implements RadioCheckable.OnCheckedChangeListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.avito.android.lib.design.radio.RadioCheckable.OnCheckedChangeListener
        public void onCheckedChanged(@NotNull View view, boolean z) {
            Intrinsics.checkNotNullParameter(view, "buttonView");
            if (!RadioGroup.this.e) {
                RadioGroup.this.e = true;
                if (RadioGroup.this.d != -1) {
                    RadioGroup radioGroup = RadioGroup.this;
                    radioGroup.c(radioGroup.d, false);
                }
                RadioGroup.this.e = false;
                RadioGroup.this.b(view.getId(), true);
            }
        }
    }

    public final class b implements ViewGroup.OnHierarchyChangeListener {
        @Nullable
        public ViewGroup.OnHierarchyChangeListener a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(@NotNull View view, @NotNull View view2) {
            Intrinsics.checkNotNullParameter(view, "parent");
            Intrinsics.checkNotNullParameter(view2, VKApiUserFull.RelativeType.CHILD);
            if (Intrinsics.areEqual(view, RadioGroup.this) && (view2 instanceof RadioCheckable)) {
                int id = view2.getId();
                if (id == -1) {
                    id = View.generateViewId();
                    view2.setId(id);
                }
                ((RadioCheckable) view2).addOnCheckChangeListener(RadioGroup.this.h);
                RadioGroup.this.f.put(Integer.valueOf(id), view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(@NotNull View view, @NotNull View view2) {
            Intrinsics.checkNotNullParameter(view, "parent");
            Intrinsics.checkNotNullParameter(view2, VKApiUserFull.RelativeType.CHILD);
            RadioGroup radioGroup = RadioGroup.this;
            if (view == radioGroup && (view2 instanceof RadioCheckable)) {
                ((RadioCheckable) view2).removeOnCheckChangeListener(radioGroup.h);
            }
            RadioGroup.this.f.remove(Integer.valueOf(view2.getId()));
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RadioGroup(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(TextView textView, String str, int i2, int i3) {
        TextViews.bindText$default(textView, str, false, 2, null);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.leftMargin = i2;
        layoutParams2.rightMargin = i3;
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View view, int i2, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (view != null) {
            if (view instanceof RadioCheckable) {
                if (((RadioCheckable) view).isChecked()) {
                    this.e = true;
                    int i3 = this.d;
                    if (i3 != -1) {
                        c(i3, false);
                    }
                    this.e = false;
                    b(view.getId(), true);
                }
                view.setPadding(this.i, view.getPaddingTop(), this.j, view.getPaddingBottom());
            }
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalArgumentException("Cannot add a null child view to a ViewGroup");
    }

    public final void b(@IdRes int i2, boolean z) {
        OnCheckedChangeListener onCheckedChangeListener;
        this.d = i2;
        View view = this.f.get(Integer.valueOf(i2));
        if (!(view instanceof RadioButton)) {
            view = null;
        }
        RadioButton radioButton = (RadioButton) view;
        if (radioButton != null && (onCheckedChangeListener = this.k) != null) {
            onCheckedChangeListener.onCheckedChanged(this, radioButton, z);
        }
    }

    public final void c(int i2, boolean z) {
        View view = this.f.get(Integer.valueOf(i2));
        if (view == null && (view = findViewById(i2)) != null) {
            this.f.put(Integer.valueOf(i2), view);
        }
        if (view != null && (view instanceof RadioCheckable)) {
            ((RadioCheckable) view).setChecked(z);
        }
    }

    public final void check(@IdRes int i2) {
        if (i2 == -1 || i2 != this.d) {
            int i3 = this.d;
            if (i3 != -1) {
                c(i3, false);
            }
            if (i2 != -1) {
                c(i2, true);
            }
            b(i2, true);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "p");
        return layoutParams instanceof LinearLayout.LayoutParams;
    }

    public final void clearChecked() {
        check(-1);
    }

    public final void d(TextView textView, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.leftMargin = i2;
        layoutParams2.rightMargin = i3;
    }

    @IdRes
    public final int getCheckedRadioButtonId() {
        return this.d;
    }

    @NotNull
    public final String getHint() {
        return this.c.getText().toString();
    }

    @Nullable
    public final OnCheckedChangeListener getOnCheckedChangeListener() {
        return this.k;
    }

    @NotNull
    public final String getSubtitle() {
        return this.b.getText().toString();
    }

    @NotNull
    public final String getTitle() {
        return this.a.getText().toString();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.d;
        if (i2 != -1) {
            this.e = true;
            c(i2, true);
            this.e = false;
            b(this.d, true);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        if (!isEnabled()) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.d = savedState.getCheckedId();
    }

    @Override // android.view.View
    @NotNull
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "super.onSaveInstanceState()!!");
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.setCheckedId(this.d);
        return savedState;
    }

    public final void removeAllRadioButtons() {
        Collection<View> values = this.f.values();
        Intrinsics.checkNotNullExpressionValue(values, "radioChildrenMap.values");
        for (View view : CollectionsKt___CollectionsKt.toList(values)) {
            removeView(view);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (Map.Entry<Integer, View> entry : this.f.entrySet()) {
            entry.getValue().setEnabled(z);
        }
    }

    public final void setHint(@Nullable String str) {
        TextViews.bindText$default(this.c, str, false, 2, null);
    }

    public final void setHintColor(@ColorInt int i2) {
        this.c.setTextColor(i2);
    }

    public final void setHintColorRes(@ColorRes int i2) {
        setHintColor(ContextCompat.getColor(getContext(), i2));
    }

    public final void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener onCheckedChangeListener) {
        this.k = onCheckedChangeListener;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(@NotNull ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        Intrinsics.checkNotNullParameter(onHierarchyChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.g.a = onHierarchyChangeListener;
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(0, i3, 0, i5);
        TextView textView = this.a;
        if (textView != null) {
            d(textView, i2, i4);
        }
        TextView textView2 = this.b;
        if (textView2 != null) {
            d(textView2, i2, i4);
        }
        TextView textView3 = this.c;
        if (textView3 != null) {
            d(textView3, i2, i4);
        }
    }

    public final void setSubtitle(@Nullable String str) {
        TextViews.bindText$default(this.b, str, false, 2, null);
    }

    public final void setTitle(@Nullable String str) {
        TextViews.bindText$default(this.a, str, false, 2, null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/avito/android/lib/design/radio/RadioGroup$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", VKApiConst.OUT, "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "I", "getCheckedId", "()I", "setCheckedId", "(I)V", "checkedId", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends View.BaseSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        public int a = -1;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/lib/design/radio/RadioGroup$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/lib/design/radio/RadioGroup$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
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
                return new SavedState(parcel2, null);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcelable parcelable) {
            super(parcelable);
            Intrinsics.checkNotNullParameter(parcelable, "superState");
        }

        public final int getCheckedId() {
            return this.a;
        }

        public final void setCheckedId(int i) {
            this.a = i;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, VKApiConst.OUT);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }

        public SavedState(Parcel parcel, j jVar) {
            super(parcel);
            this.a = parcel.readInt();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RadioGroup(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    @NotNull
    public LinearLayout.LayoutParams generateLayoutParams(@NotNull AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        return new LinearLayout.LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @SuppressLint({"CustomViewStyleable"})
    public RadioGroup(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.design_radio_group_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        TextView textView = (TextView) findViewById;
        this.a = textView;
        View findViewById2 = findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.subtitle)");
        TextView textView2 = (TextView) findViewById2;
        this.b = textView2;
        View findViewById3 = findViewById(R.id.hint);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.hint)");
        TextView textView3 = (TextView) findViewById3;
        this.c = textView3;
        this.d = -1;
        this.f = new HashMap<>();
        b bVar = new b();
        this.g = bVar;
        this.h = new a();
        setOrientation(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DesignRadioGroup);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, Navigation.ATTRIBUTES);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.design_radio_group_default_child_horizontal_padding);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.DesignRadioGroup_android_padding, -1);
        if (layoutDimension > 0) {
            this.i = layoutDimension;
            this.j = layoutDimension;
            setPadding(0, layoutDimension, 0, layoutDimension);
        } else {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DesignRadioGroup_android_paddingStart, 0);
            this.i = dimensionPixelSize == 0 ? obtainStyledAttributes.getDimensionPixelSize(R.styleable.DesignRadioGroup_android_paddingLeft, dimensionPixelOffset) : dimensionPixelSize;
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DesignRadioGroup_android_paddingEnd, 0);
            this.j = dimensionPixelSize2 == 0 ? obtainStyledAttributes.getDimensionPixelSize(R.styleable.DesignRadioGroup_android_paddingRight, dimensionPixelOffset) : dimensionPixelSize2;
            setPadding(0, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DesignRadioGroup_android_paddingTop, 0), 0, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DesignRadioGroup_android_paddingBottom, 0));
        }
        CharSequence text = obtainStyledAttributes.getText(R.styleable.DesignRadioGroup_radio_group_title);
        String str = null;
        a(textView, text != null ? text.toString() : null, this.i, this.j);
        CharSequence text2 = obtainStyledAttributes.getText(R.styleable.DesignRadioGroup_radio_group_subtitle);
        a(textView2, text2 != null ? text2.toString() : null, this.i, this.j);
        CharSequence text3 = obtainStyledAttributes.getText(R.styleable.DesignRadioGroup_radio_group_hint);
        a(textView3, text3 != null ? text3.toString() : str, this.i, this.j);
        setEnabled(obtainStyledAttributes.getBoolean(R.styleable.DesignRadioGroup_android_enabled, true));
        obtainStyledAttributes.recycle();
        super.setOnHierarchyChangeListener(bVar);
    }
}
