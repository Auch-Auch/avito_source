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
import androidx.annotation.DimenRes;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.radio.RadioCheckable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001QB\u0011\b\u0016\u0012\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bJ\u0010KB\u001b\b\u0016\u0012\u0006\u0010I\u001a\u00020H\u0012\b\u0010M\u001a\u0004\u0018\u00010L¢\u0006\u0004\bJ\u0010NB#\b\u0017\u0012\u0006\u0010I\u001a\u00020H\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u0012\u0006\u0010O\u001a\u00020-¢\u0006\u0004\bJ\u0010PJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0012J\u000f\u0010\u001a\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u001f¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b&\u0010\"J\r\u0010'\u001a\u00020\u001f¢\u0006\u0004\b'\u0010$J#\u0010*\u001a\u00020\u0005*\u00020(2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b*\u0010+J\u001d\u0010/\u001a\u00020\u0005*\u00020,2\b\b\u0001\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u00105R\u0016\u00108\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00107R\u0016\u0010:\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u00105R\u0016\u0010=\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00130A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006R"}, d2 = {"Lcom/avito/android/lib/design/radio/RadioButton;", "Landroid/widget/LinearLayout;", "Lcom/avito/android/lib/design/radio/RadioCheckable;", "Landroid/view/View$OnClickListener;", "l", "", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/View$OnTouchListener;", "setOnTouchListener", "(Landroid/view/View$OnTouchListener;)V", "", "checked", "setChecked", "(Z)V", "isChecked", "()Z", "toggle", "()V", "Lcom/avito/android/lib/design/radio/RadioCheckable$OnCheckedChangeListener;", "onCheckedChangeListener", "addOnCheckChangeListener", "(Lcom/avito/android/lib/design/radio/RadioCheckable$OnCheckedChangeListener;)V", "removeOnCheckChangeListener", "clearOnCheckChangeListener", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "getSubtitle", "Landroidx/appcompat/widget/AppCompatRadioButton;", "withAnimation", AuthSource.SEND_ABUSE, "(Landroidx/appcompat/widget/AppCompatRadioButton;ZZ)V", "Landroid/view/View;", "", "verticalMargin", "c", "(Landroid/view/View;I)V", "d", "Landroid/widget/LinearLayout;", "container", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "titleTextView", "Landroidx/appcompat/widget/AppCompatRadioButton;", "radioButton", AuthSource.BOOKING_ORDER, "subtitleTextView", "e", "Z", "onDown", g.a, "Landroid/view/View$OnTouchListener;", "onTouchListener", "", "h", "Ljava/util/List;", "onCheckedChangeListeners", "f", "Landroid/view/View$OnClickListener;", "onClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SavedState", "components_release"}, k = 1, mv = {1, 4, 2})
public final class RadioButton extends LinearLayout implements RadioCheckable {
    public final TextView a;
    public final TextView b;
    public final AppCompatRadioButton c;
    public final LinearLayout d;
    public boolean e;
    public View.OnClickListener f;
    public View.OnTouchListener g;
    public final List<RadioCheckable.OnCheckedChangeListener> h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/lib/design/radio/RadioButton$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", VKApiConst.OUT, "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Z", "getChecked", "()Z", "setChecked", "(Z)V", "checked", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends View.BaseSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        public boolean a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/lib/design/radio/RadioButton$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/lib/design/radio/RadioButton$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
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

        public final boolean getChecked() {
            return this.a;
        }

        public final void setChecked(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, VKApiConst.OUT);
            super.writeToParcel(parcel, i);
            ParcelsKt.writeBool(parcel, this.a);
        }

        public SavedState(Parcel parcel, j jVar) {
            super(parcel);
            this.a = ParcelsKt.readBool(parcel);
        }
    }

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ RadioButton a;

        public a(RadioButton radioButton) {
            this.a = radioButton;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
            int action = motionEvent.getAction();
            if (action == 0) {
                this.a.e = true;
            } else if (action == 1) {
                if (this.a.e && RadioButton.b(this.a, motionEvent.getX(), motionEvent.getY(), 0.0f, 4)) {
                    this.a.setChecked(true);
                }
                this.a.e = false;
            } else if (action != 2) {
                if (action == 3) {
                    this.a.e = false;
                }
            } else if (!RadioButton.b(this.a, motionEvent.getX(), motionEvent.getY(), 0.0f, 4)) {
                this.a.e = false;
            }
            View.OnTouchListener onTouchListener = this.a.g;
            if (onTouchListener != null) {
                onTouchListener.onTouch(view, motionEvent);
            }
            return this.a.onTouchEvent(motionEvent);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ AppCompatRadioButton a;
        public final /* synthetic */ boolean b;

        public b(AppCompatRadioButton appCompatRadioButton, boolean z) {
            this.a = appCompatRadioButton;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setChecked(this.b);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RadioButton(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static boolean b(RadioButton radioButton, float f2, float f3, float f4, int i) {
        if ((i & 4) != 0) {
            f4 = 0.0f;
        }
        Objects.requireNonNull(radioButton);
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) (radioButton.getRight() - radioButton.getLeft())) + f4 && f3 < ((float) (radioButton.getBottom() - radioButton.getTop())) + f4;
    }

    public final void a(AppCompatRadioButton appCompatRadioButton, boolean z, boolean z2) {
        if (z) {
            appCompatRadioButton.setScaleX(0.0f);
            appCompatRadioButton.setScaleY(0.0f);
            appCompatRadioButton.setChecked(z2);
            appCompatRadioButton.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
            return;
        }
        appCompatRadioButton.post(new b(appCompatRadioButton, z2));
    }

    @Override // com.avito.android.lib.design.radio.RadioCheckable
    public void addOnCheckChangeListener(@NotNull RadioCheckable.OnCheckedChangeListener onCheckedChangeListener) {
        Intrinsics.checkNotNullParameter(onCheckedChangeListener, "onCheckedChangeListener");
        this.h.add(onCheckedChangeListener);
    }

    public final void c(View view, @DimenRes int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
            layoutParams = null;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(i);
            layoutParams2.topMargin = dimensionPixelSize;
            layoutParams2.bottomMargin = dimensionPixelSize;
        }
    }

    @Override // com.avito.android.lib.design.radio.RadioCheckable
    public void clearOnCheckChangeListener() {
        this.h.clear();
    }

    @NotNull
    public final String getSubtitle() {
        return this.b.getText().toString();
    }

    @NotNull
    public final String getTitle() {
        return this.a.getText().toString();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.c.isChecked();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        a(this.c, false, savedState.getChecked());
    }

    @Override // android.view.View
    @NotNull
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "super.onSaveInstanceState()!!");
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.setChecked(isChecked());
        return savedState;
    }

    @Override // com.avito.android.lib.design.radio.RadioCheckable
    public void removeOnCheckChangeListener(@NotNull RadioCheckable.OnCheckedChangeListener onCheckedChangeListener) {
        Intrinsics.checkNotNullParameter(onCheckedChangeListener, "onCheckedChangeListener");
        this.h.remove(onCheckedChangeListener);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            Iterator<T> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().onCheckedChanged(this, z);
            }
            a(this.c, z, z);
        }
        View.OnClickListener onClickListener = this.f;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(@Nullable View.OnTouchListener onTouchListener) {
        this.g = onTouchListener;
    }

    public final void setSubtitle(@Nullable String str) {
        TextViews.bindText$default(this.b, str, false, 2, null);
        if (!Views.isVisible(this.b)) {
            AppCompatRadioButton appCompatRadioButton = this.c;
            int i = R.dimen.design_radio_button_vertical_margin_without_subtitle;
            c(appCompatRadioButton, i);
            c(this.d, i);
        }
    }

    public final void setTitle(@Nullable String str) {
        TextViews.bindText$default(this.a, str, false, 2, null);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RadioButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @SuppressLint({"CustomViewStyleable", "ClickableViewAccessibility"})
    public RadioButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.design_radio_button_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.radio_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.radio_button)");
        AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) findViewById;
        this.c = appCompatRadioButton;
        View findViewById2 = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.title)");
        this.a = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.subtitle)");
        this.b = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.container)");
        this.d = (LinearLayout) findViewById4;
        setClickable(true);
        setFocusable(true);
        Views.setBackgroundCompat(this, Views.getDrawable(this, R.drawable.design_radio_ripple));
        this.h = new ArrayList();
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DesignRadioButton);
        CharSequence text = obtainStyledAttributes.getText(R.styleable.DesignRadioButton_radio_button_title);
        String str = null;
        setTitle(text != null ? text.toString() : null);
        CharSequence text2 = obtainStyledAttributes.getText(R.styleable.DesignRadioButton_radio_button_subtitle);
        setSubtitle(text2 != null ? text2.toString() : str);
        setEnabled(obtainStyledAttributes.getBoolean(R.styleable.DesignRadioButton_android_enabled, true));
        appCompatRadioButton.setChecked(obtainStyledAttributes.getBoolean(R.styleable.DesignRadioButton_radio_button_checked, false));
        obtainStyledAttributes.recycle();
        super.setOnTouchListener(new a(this));
    }
}
