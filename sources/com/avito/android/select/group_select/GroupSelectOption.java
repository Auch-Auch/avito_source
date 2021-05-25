package com.avito.android.select.group_select;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.lib.design.toggle.Checkbox;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.R;
import com.avito.android.select.group_select.SelectableView;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J#\u0010\u0007\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/avito/android/select/group_select/GroupSelectOption;", "Landroid/widget/LinearLayout;", "Lcom/avito/android/select/group_select/SelectableView;", "Lkotlin/Function1;", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSelectionListener", "(Lkotlin/jvm/functions/Function1;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "isSelected", "notify", "select", "(ZZ)V", "c", "Z", "isViewSelected", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "d", "Lkotlin/jvm/functions/Function1;", "selectionListener", "Lcom/avito/android/lib/design/toggle/Checkbox;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/toggle/Checkbox;", "checkbox", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class GroupSelectOption extends LinearLayout implements SelectableView {
    public final Checkbox a;
    public final TextView b;
    public boolean c;
    public Function1<? super Boolean, Unit> d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ GroupSelectOption a;

        public a(GroupSelectOption groupSelectOption) {
            this.a = groupSelectOption;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GroupSelectOption.access$toggle(this.a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroupSelectOption(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
        setMinimumHeight(Views.dpToPx(this, 52));
        setGravity(16);
        int dpToPx = Views.dpToPx(this, 16);
        setPadding(dpToPx, 0, dpToPx, 0);
        LayoutInflater.from(context).inflate(R.layout.group_select_option, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.checkbox);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.checkbox)");
        this.a = (Checkbox) findViewById;
        View findViewById2 = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.title)");
        this.b = (TextView) findViewById2;
        setOnClickListener(new a(this));
    }

    public static final void access$toggle(GroupSelectOption groupSelectOption) {
        SelectableView.DefaultImpls.select$default(groupSelectOption, !groupSelectOption.c, false, 2, null);
    }

    @Override // com.avito.android.select.group_select.SelectableView
    public void select(boolean z, boolean z2) {
        Function1<? super Boolean, Unit> function1;
        if (this.c != z) {
            this.c = z;
            this.a.setChecked(z);
            if (z2 && (function1 = this.d) != null) {
                function1.invoke(Boolean.valueOf(z));
            }
        }
    }

    public final void setSelectionListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.d = function1;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.b.setText(str);
    }
}
