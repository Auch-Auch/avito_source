package com.avito.android.component.radio_button;

import a2.g.r.g;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.core.view.ViewCompat;
import com.avito.android.design.widget.lifecycle_view.AttachListener;
import com.avito.android.design.widget.lifecycle_view.LifecycleView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.DelegateGlobalLayoutListener;
import com.avito.android.util.TextViews;
import com.avito.android.util.ViewTreeObservers;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010?\u001a\u00020#¢\u0006\u0004\bC\u0010DJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J+\u0010\r\u001a\u00020\u00052\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0010\u001a\u00020\u00052\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0014\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010\u001dJ\u0019\u0010!\u001a\u00020\u00122\b\b\u0001\u0010 \u001a\u00020\u0012H\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u0004\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010(R\u0016\u0010\u0017\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\b\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010(R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R$\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b8V@VX\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b8V@VX\u000e¢\u0006\f\u001a\u0004\b5\u00102\"\u0004\b6\u00104R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R$\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010%R\u0016\u0010B\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lcom/avito/android/component/radio_button/RadioButtonImpl;", "Lcom/avito/android/component/radio_button/RadioButton;", "Lcom/avito/android/design/widget/lifecycle_view/AttachListener;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "Lkotlin/Function2;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnCheckedChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "", "resId", "setIcon", "(I)V", "Landroid/graphics/drawable/Drawable;", "icon", "(Landroid/graphics/drawable/Drawable;)V", "tint", "setIconTint", "(Ljava/lang/Integer;)V", "onAttach", "()V", "onDetach", AuthSource.BOOKING_ORDER, "id", AuthSource.SEND_ABUSE, "(I)I", "Landroid/view/View;", "d", "Landroid/view/View;", "container", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "Lcom/avito/android/util/DelegateGlobalLayoutListener;", g.a, "Lcom/avito/android/util/DelegateGlobalLayoutListener;", "layoutListener", "value", "isChecked", "()Z", "setChecked", "(Z)V", "isEnabled", "setEnabled", "Landroid/widget/RadioButton;", "c", "Landroid/widget/RadioButton;", "radioButton", "h", "Lkotlin/jvm/functions/Function1;", "clickListener", "i", "view", "f", "I", VKApiConst.POSITION, "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class RadioButtonImpl implements RadioButton, AttachListener {
    public final TextView a;
    public final TextView b;
    public final RadioButton c;
    public final View d;
    public final ImageView e;
    public int f;
    public final DelegateGlobalLayoutListener g = new DelegateGlobalLayoutListener();
    public Function1<? super RadioButton, Unit> h;
    public final View i;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((RadioButtonImpl) this.b).c.toggle();
                Function1 function1 = ((RadioButtonImpl) this.b).h;
                if (function1 != null) {
                    Unit unit = (Unit) function1.invoke((RadioButtonImpl) this.b);
                }
            } else if (i == 1) {
                Function1 function12 = ((RadioButtonImpl) this.b).h;
                if (function12 != null) {
                    Unit unit2 = (Unit) function12.invoke((RadioButtonImpl) this.b);
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<ViewTreeObserver, Unit> {
        public final /* synthetic */ RadioButtonImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(RadioButtonImpl radioButtonImpl) {
            super(1);
            this.a = radioButtonImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ViewTreeObserver viewTreeObserver) {
            ViewTreeObserver viewTreeObserver2 = viewTreeObserver;
            Intrinsics.checkNotNullParameter(viewTreeObserver2, "it");
            viewTreeObserver2.addOnGlobalLayoutListener(this.a.g);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ RadioButtonImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(RadioButtonImpl radioButtonImpl) {
            super(0);
            this.a = radioButtonImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.b();
            return Unit.INSTANCE;
        }
    }

    public static final class d implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ RadioButtonImpl a;
        public final /* synthetic */ Function2 b;

        public d(RadioButtonImpl radioButtonImpl, Function2 function2) {
            this.a = radioButtonImpl;
            this.b = function2;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.b.invoke(this.a, Boolean.valueOf(z));
        }
    }

    public RadioButtonImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.i = view;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.radio_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.RadioButton");
        RadioButton radioButton = (RadioButton) findViewById3;
        this.c = radioButton;
        View findViewById4 = view.findViewById(R.id.container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById4;
        View findViewById5 = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        this.e = (ImageView) findViewById5;
        View findViewById6 = view.findViewById(R.id.lifecycle);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.avito.android.design.widget.lifecycle_view.LifecycleView");
        LifecycleView lifecycleView = (LifecycleView) findViewById6;
        lifecycleView.setAttachListener(this);
        view.setOnClickListener(new a(0, this));
        radioButton.setOnClickListener(new a(1, this));
        b();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "view.viewTreeObserver");
        ViewTreeObservers.ifAlive(viewTreeObserver, new b(this));
        if (ViewCompat.isAttachedToWindow(lifecycleView)) {
            onAttach();
        }
    }

    public final int a(@DimenRes int i2) {
        return this.i.getResources().getDimensionPixelSize(i2);
    }

    public final void b() {
        int i2 = (this.c.getHeight() == 0 || this.d.getHeight() == 0) ? 0 : this.d.getHeight() > this.c.getHeight() ? 1 : 2;
        if (i2 != this.f) {
            this.f = i2;
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (i2 != 1) {
                layoutParams2.topMargin = a(R.dimen.radio_button_aligned_to_center_top_margin);
                layoutParams2.bottomMargin = a(R.dimen.radio_button_aligned_to_center_bottom_margin);
                layoutParams2.gravity = 16;
            } else {
                layoutParams2.topMargin = a(R.dimen.radio_button_aligned_to_top_top_margin);
                layoutParams2.bottomMargin = a(R.dimen.radio_button_aligned_to_top_bottom_margin);
                layoutParams2.gravity = 48;
            }
            this.c.requestLayout();
        }
    }

    @Override // com.avito.android.component.radio_button.RadioButton
    public boolean isChecked() {
        return this.c.isChecked();
    }

    @Override // com.avito.android.component.radio_button.RadioButton
    public boolean isEnabled() {
        return this.c.isEnabled();
    }

    @Override // com.avito.android.design.widget.lifecycle_view.AttachListener
    public void onAttach() {
        this.g.setDelegate(new c(this));
    }

    @Override // com.avito.android.design.widget.lifecycle_view.AttachListener
    public void onDetach() {
        this.g.setDelegate(null);
    }

    @Override // com.avito.android.component.radio_button.RadioButton
    public void setChecked(boolean z) {
        this.c.setChecked(z);
    }

    @Override // com.avito.android.component.radio_button.RadioButton
    public void setEnabled(boolean z) {
        Views.setViewHierarchyEnabled(this.i, z);
    }

    @Override // com.avito.android.component.radio_button.RadioButton
    public void setIcon(int i2) {
        this.e.setImageResource(i2);
        Views.setVisible(this.e, i2 != 0);
    }

    @Override // com.avito.android.component.radio_button.RadioButton
    public void setIconTint(@Nullable Integer num) {
        if (num != null) {
            this.e.setColorFilter(num.intValue());
        } else {
            this.e.setColorFilter((ColorFilter) null);
        }
    }

    @Override // com.avito.android.component.radio_button.RadioButton
    public void setOnCheckedChangeListener(@Nullable Function2<? super RadioButton, ? super Boolean, Unit> function2) {
        if (function2 != null) {
            this.c.setOnCheckedChangeListener(new d(this, function2));
        } else {
            this.c.setOnCheckedChangeListener(null);
        }
    }

    @Override // com.avito.android.component.radio_button.RadioButton
    public void setOnClickListener(@Nullable Function1<? super RadioButton, Unit> function1) {
        this.h = function1;
    }

    @Override // com.avito.android.component.radio_button.RadioButton
    public void setSubtitle(@Nullable String str) {
        TextViews.bindText$default(this.b, str, false, 2, null);
    }

    @Override // com.avito.android.component.radio_button.RadioButton
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a.setText(str);
    }

    @Override // com.avito.android.component.radio_button.RadioButton
    public void setIcon(@Nullable Drawable drawable) {
        this.e.setImageDrawable(drawable);
        Views.setVisible(this.e, drawable != null);
    }
}
