package com.avito.android.component.switch_list_element;

import a2.g.r.g;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010>\u001a\u00020+¢\u0006\u0004\b?\u0010@J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ%\u0010\u001f\u001a\u00020\u00042\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\u00020\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040!H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0013H\u0016¢\u0006\u0004\b$\u0010\u0015J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0013H\u0016¢\u0006\u0004\b&\u0010\u001bR\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010-R$\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010)R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006A"}, d2 = {"Lcom/avito/android/component/switch_list_element/SwitchListElementImpl;", "Lcom/avito/android/component/switch_list_element/SwitchListElement;", "", "resId", "", "setIcon", "(I)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", MessengerShareContentUtility.SUBTITLE, "Landroid/text/method/MovementMethod;", "movementMethod", "setSubtitle", "(Ljava/lang/CharSequence;Landroid/text/method/MovementMethod;)V", "showToggle", "()V", "hideToggle", "", "isChecked", "()Z", "withAnimation", "setChecked", "(ZZ)V", "isEnabled", "setEnabled", "(Z)V", "setSwitchEnabled", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCheckedChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "isSaveEnabled", "enabled", "setSaveEnabled", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "e", "Landroid/view/View;", "switchViewContainer", AuthSource.SEND_ABUSE, "containerView", g.a, "Lkotlin/jvm/functions/Function1;", "switchListener", "Landroidx/appcompat/widget/SwitchCompat;", "f", "Landroidx/appcompat/widget/SwitchCompat;", "switchView", "d", "subtitleView", "Landroid/widget/ImageView;", AuthSource.BOOKING_ORDER, "Landroid/widget/ImageView;", "iconView", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SwitchListElementImpl implements SwitchListElement {
    public final View a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final View e;
    public final SwitchCompat f;
    public Function1<? super Boolean, Unit> g;

    public static final class a implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ SwitchListElementImpl a;

        public a(SwitchListElementImpl switchListElementImpl) {
            this.a = switchListElementImpl;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Function1 function1 = this.a.g;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(Boolean.valueOf(z));
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SwitchListElementImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SwitchListElementImpl switchListElementImpl) {
            super(0);
            this.a = switchListElementImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (this.a.f.isClickable()) {
                this.a.f.toggle();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public c(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public SwitchListElementImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        this.b = (ImageView) view.findViewById(R.id.icon);
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.toggle_container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById4;
        View findViewById5 = view.findViewById(R.id.toggle);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type androidx.appcompat.widget.SwitchCompat");
        SwitchCompat switchCompat = (SwitchCompat) findViewById5;
        this.f = switchCompat;
        switchCompat.setOnCheckedChangeListener(new a(this));
        setClickListener(new b(this));
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void hideToggle() {
        Views.hide(this.e);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public boolean isChecked() {
        return this.f.isChecked();
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public boolean isSaveEnabled() {
        return this.f.isSaveEnabled();
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setChecked(boolean z, boolean z2) {
        this.f.setChecked(z);
        if (!z2) {
            this.f.jumpDrawablesToCurrentState();
        }
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setCheckedChangeListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.g = function1;
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a.setOnClickListener(new c(function0));
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setEnabled(boolean z) {
        this.a.setClickable(z);
        this.f.setClickable(z);
        if (z) {
            this.a.setAlpha(1.0f);
        } else {
            this.a.setAlpha(0.4f);
        }
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setIcon(int i) {
        ImageView imageView = this.b;
        if (imageView != null) {
            Views.show(imageView);
        }
        ImageView imageView2 = this.b;
        if (imageView2 != null) {
            imageView2.setImageResource(i);
        }
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setSaveEnabled(boolean z) {
        this.f.setSaveEnabled(z);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setSubtitle(@Nullable CharSequence charSequence, @Nullable MovementMethod movementMethod) {
        TextView textView = this.d;
        TextViews.bindText$default(textView, charSequence, false, 2, null);
        textView.setMovementMethod(movementMethod);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setSwitchEnabled(boolean z) {
        this.f.setClickable(z);
        if (z) {
            this.f.setAlpha(1.0f);
        } else {
            this.f.setAlpha(0.4f);
        }
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.c.setText(charSequence);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void showToggle() {
        Views.show(this.e);
    }
}
