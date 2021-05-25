package com.avito.android.component.check_box;

import a2.g.r.g;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
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
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010:\u001a\u000207\u0012\b\b\u0002\u0010?\u001a\u00020\u000f¢\u0006\u0004\bM\u0010NJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J%\u0010\f\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u00020\u00052\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0014\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\u001dRD\u0010(\u001a0\u0012\f\u0012\n $*\u0004\u0018\u00010\u000f0\u000f $*\u0017\u0012\f\u0012\n $*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010#¢\u0006\u0002\b%0#¢\u0006\u0002\b%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R$\u00101\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f8V@VX\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f8V@VX\u000e¢\u0006\f\u001a\u0004\b5\u00102\"\u0004\b6\u00104R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010?\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010\u0017\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010\b\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010\u0004\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010L¨\u0006O"}, d2 = {"Lcom/avito/android/component/check_box/CheckBoxImpl;", "Lcom/avito/android/component/check_box/CheckBox;", "Lcom/avito/android/design/widget/lifecycle_view/AttachListener;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "", "setOnCheckedChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "", "resId", "setIcon", "(I)V", "Landroid/graphics/drawable/Drawable;", "icon", "(Landroid/graphics/drawable/Drawable;)V", "tint", "setIconTint", "(Ljava/lang/Integer;)V", "onAttach", "()V", "onDetach", "Lio/reactivex/rxjava3/core/Observable;", "toggles", "()Lio/reactivex/rxjava3/core/Observable;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "i", "Lcom/jakewharton/rxrelay3/PublishRelay;", "toggleRelay", "h", "Lkotlin/jvm/functions/Function1;", "clickListener", "Lcom/avito/android/util/DelegateGlobalLayoutListener;", g.a, "Lcom/avito/android/util/DelegateGlobalLayoutListener;", "layoutListener", "value", "isChecked", "()Z", "setChecked", "(Z)V", "isEnabled", "setEnabled", "Landroid/view/View;", "j", "Landroid/view/View;", "view", "d", "container", "k", "Z", "useAutomateMargin", "Landroid/widget/CheckBox;", "c", "Landroid/widget/CheckBox;", "checkBox", "f", "I", VKApiConst.POSITION, "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "<init>", "(Landroid/view/View;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CheckBoxImpl implements CheckBox, AttachListener {
    public final TextView a;
    public final TextView b;
    public final CheckBox c;
    public final View d;
    public final ImageView e;
    public int f;
    public final DelegateGlobalLayoutListener g;
    public Function1<? super CheckBox, Unit> h;
    public final PublishRelay<Boolean> i;
    public final View j;
    public final boolean k;

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
                ((CheckBoxImpl) this.b).c.toggle();
                Function1 function1 = ((CheckBoxImpl) this.b).h;
                if (function1 != null) {
                    Unit unit = (Unit) function1.invoke((CheckBoxImpl) this.b);
                }
            } else if (i == 1) {
                Function1 function12 = ((CheckBoxImpl) this.b).h;
                if (function12 != null) {
                    Unit unit2 = (Unit) function12.invoke((CheckBoxImpl) this.b);
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<ViewTreeObserver, Unit> {
        public final /* synthetic */ CheckBoxImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CheckBoxImpl checkBoxImpl) {
            super(1);
            this.a = checkBoxImpl;
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
        public final /* synthetic */ CheckBoxImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(CheckBoxImpl checkBoxImpl) {
            super(0);
            this.a = checkBoxImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a();
            return Unit.INSTANCE;
        }
    }

    public static final class d implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ CheckBoxImpl a;
        public final /* synthetic */ Function2 b;

        public d(CheckBoxImpl checkBoxImpl, Function2 function2) {
            this.a = checkBoxImpl;
            this.b = function2;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.b.invoke(this.a, Boolean.valueOf(z));
        }
    }

    public static final class e extends Lambda implements Function2<CheckBox, Boolean, Unit> {
        public final /* synthetic */ CheckBoxImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(CheckBoxImpl checkBoxImpl) {
            super(2);
            this.a = checkBoxImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(CheckBox checkBox, Boolean bool) {
            boolean booleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(checkBox, "checkBox");
            this.a.i.accept(Boolean.valueOf(booleanValue));
            return Unit.INSTANCE;
        }
    }

    public CheckBoxImpl(@NotNull View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.j = view;
        this.k = z;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.checkbox);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.CheckBox");
        CheckBox checkBox = (CheckBox) findViewById3;
        this.c = checkBox;
        View findViewById4 = view.findViewById(R.id.container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById4;
        View findViewById5 = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        this.e = (ImageView) findViewById5;
        this.g = new DelegateGlobalLayoutListener();
        this.i = PublishRelay.create();
        View findViewById6 = view.findViewById(R.id.lifecycle);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.avito.android.design.widget.lifecycle_view.LifecycleView");
        LifecycleView lifecycleView = (LifecycleView) findViewById6;
        lifecycleView.setAttachListener(this);
        view.setOnClickListener(new a(0, this));
        checkBox.setOnClickListener(new a(1, this));
        a();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "view.viewTreeObserver");
        ViewTreeObservers.ifAlive(viewTreeObserver, new b(this));
        if (ViewCompat.isAttachedToWindow(lifecycleView)) {
            onAttach();
        }
    }

    public final void a() {
        int i2;
        if (this.k) {
            int i3 = (this.c.getHeight() == 0 || this.d.getHeight() == 0) ? 0 : this.d.getHeight() > this.c.getHeight() ? 2 : 1;
            if (i3 != this.f) {
                this.f = i3;
                if (i3 != 2) {
                    i2 = this.j.getResources().getDimensionPixelSize(R.dimen.check_box_default_top_margin);
                } else {
                    i2 = this.j.getResources().getDimensionPixelSize(R.dimen.check_box_increased_top_margin);
                }
                CheckBox checkBox = this.c;
                ViewGroup.LayoutParams layoutParams = checkBox.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i2;
                checkBox.requestLayout();
                ImageView imageView = this.e;
                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = i2;
                imageView.requestLayout();
            }
        }
    }

    @Override // com.avito.android.component.check_box.CheckBox
    public boolean isChecked() {
        return this.c.isChecked();
    }

    @Override // com.avito.android.component.check_box.CheckBox
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

    @Override // com.avito.android.component.check_box.CheckBox
    public void setChecked(boolean z) {
        this.c.setChecked(z);
    }

    @Override // com.avito.android.component.check_box.CheckBox
    public void setEnabled(boolean z) {
        Views.setViewHierarchyEnabled(this.j, z);
    }

    @Override // com.avito.android.component.check_box.CheckBox
    public void setIcon(int i2) {
        this.e.setImageResource(i2);
        Views.setVisible(this.e, i2 != 0);
    }

    @Override // com.avito.android.component.check_box.CheckBox
    public void setIconTint(@Nullable Integer num) {
        if (num != null) {
            this.e.setColorFilter(num.intValue());
        } else {
            this.e.setColorFilter((ColorFilter) null);
        }
    }

    @Override // com.avito.android.component.check_box.CheckBox
    public void setOnCheckedChangeListener(@Nullable Function2<? super CheckBox, ? super Boolean, Unit> function2) {
        if (function2 != null) {
            this.c.setOnCheckedChangeListener(new d(this, function2));
        } else {
            this.c.setOnCheckedChangeListener(null);
        }
    }

    @Override // com.avito.android.component.check_box.CheckBox
    public void setOnClickListener(@Nullable Function1<? super CheckBox, Unit> function1) {
        this.h = function1;
    }

    @Override // com.avito.android.component.check_box.CheckBox
    public void setSubtitle(@Nullable String str) {
        TextViews.bindText$default(this.b, str, false, 2, null);
    }

    @Override // com.avito.android.component.check_box.CheckBox
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a.setText(str);
    }

    @Override // com.avito.android.component.check_box.CheckBox
    @NotNull
    public Observable<Boolean> toggles() {
        setOnCheckedChangeListener(new e(this));
        PublishRelay<Boolean> publishRelay = this.i;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "toggleRelay");
        return publishRelay;
    }

    @Override // com.avito.android.component.check_box.CheckBox
    public void setIcon(@Nullable Drawable drawable) {
        this.e.setImageDrawable(drawable);
        Views.setVisible(this.e, drawable != null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckBoxImpl(View view, boolean z, int i2, j jVar) {
        this(view, (i2 & 2) != 0 ? true : z);
    }
}
