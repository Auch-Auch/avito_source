package com.avito.android.component.selectable_list_element;

import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ%\u0010\u0011\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0003\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0018R$\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010#¨\u0006)"}, d2 = {"Lcom/avito/android/component/selectable_list_element/SelectableListElementImpl;", "Lcom/avito/android/component/selectable_list_element/SelectableListElement;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "(I)V", "", "checked", "setChecked", "(Z)V", "enabled", "setEnabled", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCheckedChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "checkedIcon", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "f", "view", "e", "Lkotlin/jvm/functions/Function1;", "changeListener", "c", "Z", "isChecked", "d", "isEnabled", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SelectableListElementImpl implements SelectableListElement {
    public final TextView a;
    public final View b;
    public boolean c;
    public boolean d;
    public Function1<? super Boolean, Unit> e;
    public final View f;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SelectableListElementImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SelectableListElementImpl selectableListElementImpl) {
            super(0);
            this.a = selectableListElementImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            SelectableListElementImpl.access$toggleChecked(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ SelectableListElementImpl b;

        public b(Function0 function0, SelectableListElementImpl selectableListElementImpl) {
            this.a = function0;
            this.b = selectableListElementImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.b.d) {
                this.a.invoke();
            }
        }
    }

    public SelectableListElementImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f = view;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.checked_icon);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
    }

    public static final void access$toggleChecked(SelectableListElementImpl selectableListElementImpl) {
        selectableListElementImpl.setChecked(!selectableListElementImpl.c);
        Function1<? super Boolean, Unit> function1 = selectableListElementImpl.e;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(selectableListElementImpl.c));
        }
    }

    @Override // com.avito.android.component.selectable_list_element.SelectableListElement
    public void setChecked(boolean z) {
        this.c = z;
        Views.setVisible(this.b, z);
    }

    @Override // com.avito.android.component.selectable_list_element.SelectableListElement
    public void setCheckedChangeListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.e = function1;
        setOnClickListener(new a(this));
    }

    @Override // com.avito.android.component.selectable_list_element.SelectableListElement
    public void setEnabled(boolean z) {
        this.d = z;
        float f2 = z ? 1.0f : 0.4f;
        this.b.setAlpha(f2);
        this.a.setAlpha(f2);
        this.f.setBackgroundResource(z ? R.drawable.bg_btn_flat : 0);
        int dimensionPixelSize = this.f.getResources().getDimensionPixelSize(R.dimen.component_horizontal_padding);
        Views.changePadding$default(this.f, dimensionPixelSize, 0, dimensionPixelSize, 0, 10, null);
    }

    @Override // com.avito.android.component.selectable_list_element.SelectableListElement
    public void setOnClickListener(@Nullable Function0<Unit> function0) {
        this.f.setOnClickListener(function0 != null ? new b(function0, this) : null);
    }

    @Override // com.avito.android.component.selectable_list_element.SelectableListElement
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a.setText(str);
    }

    @Override // com.avito.android.component.selectable_list_element.SelectableListElement
    public void setTitle(int i) {
        this.a.setText(i);
    }
}
