package com.avito.android.publish.details.adapter.date_interval;

import android.view.View;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.list_item.CompoundButtonListItem;
import com.avito.android.lib.design.list_item.SwitcherListItem;
import com.avito.android.publish.R;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001*\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0007J\u001f\u0010\u0014\u001a\u00020\u00052\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00052\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ%\u0010!\u001a\u00020\u00052\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010 H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b#\u0010\u0007J\u0019\u0010$\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b$\u0010\u0007J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\u001eR\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R$\u00104\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u00100¨\u0006?"}, d2 = {"Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "visible", "setStartSelectVisible", "(Z)V", "setEndSelectVisible", "setPresentTimeCheckboxVisibility", "isChecked", "setPresentTimeCheckboxValue", "text", "setPresentTimeCheckboxText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setStartSelectClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setEndSelectClickListener", "", "error", "setStartSelectStateToError", "(Ljava/lang/CharSequence;)V", "setEndSelectStateToError", "setAllStatesToError", "setStartSelectStateToNormal", "()V", "setEndSelectStateToNormal", "Lkotlin/Function1;", "setPresentTimeCheckboxListener", "(Lkotlin/jvm/functions/Function1;)V", "setStartSelectText", "setEndSelectText", "onUnbind", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "t", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "container", "com/avito/android/publish/details/adapter/date_interval/DateIntervalItemViewImpl$presentTimeCheckboxListener$1", "x", "Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemViewImpl$presentTimeCheckboxListener$1;", "presentTimeCheckboxListener", "Lcom/avito/android/lib/design/input/Input;", "u", "Lcom/avito/android/lib/design/input/Input;", "startSelect", "w", "Lkotlin/jvm/functions/Function1;", "presentTimeCheckChangeListener", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "s", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "presentTimeSwitcher", VKApiConst.VERSION, "endSelect", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class DateIntervalItemViewImpl extends BaseViewHolder implements DateIntervalItemView {
    public final SwitcherListItem s;
    public final ComponentContainer t;
    public final Input u;
    public final Input v;
    public Function1<? super Boolean, Unit> w;
    public DateIntervalItemViewImpl$presentTimeCheckboxListener$1 x;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DateIntervalItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.till_present_switcher);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.list_item.SwitcherListItem");
        SwitcherListItem switcherListItem = (SwitcherListItem) findViewById;
        this.s = switcherListItem;
        View findViewById2 = view.findViewById(R.id.period_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.component_container.ComponentContainer");
        ComponentContainer componentContainer = (ComponentContainer) findViewById2;
        this.t = componentContainer;
        View findViewById3 = componentContainer.findViewById(R.id.start_date_select);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        this.u = (Input) findViewById3;
        View findViewById4 = componentContainer.findViewById(R.id.end_date_select);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        this.v = (Input) findViewById4;
        DateIntervalItemViewImpl$presentTimeCheckboxListener$1 dateIntervalItemViewImpl$presentTimeCheckboxListener$1 = new CompoundButtonListItem.OnCheckedChangeListener(this) { // from class: com.avito.android.publish.details.adapter.date_interval.DateIntervalItemViewImpl$presentTimeCheckboxListener$1
            public final /* synthetic */ DateIntervalItemViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.lib.design.list_item.CompoundButtonListItem.OnCheckedChangeListener
            public void onCheckedChanged(@NotNull CompoundButtonListItem compoundButtonListItem, boolean z) {
                Intrinsics.checkNotNullParameter(compoundButtonListItem, "view");
                Function1 function1 = this.a.w;
                if (function1 != null) {
                    Unit unit = (Unit) function1.invoke(Boolean.valueOf(z));
                }
            }
        };
        this.x = dateIntervalItemViewImpl$presentTimeCheckboxListener$1;
        switcherListItem.addOnCheckedChangeListener(dateIntervalItemViewImpl$presentTimeCheckboxListener$1);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.w = null;
        this.u.setOnClickListener(null);
        this.v.setOnClickListener(null);
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setAllStatesToError(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "error");
        ComponentContainer.showErrorForAll$default(this.t, charSequence, null, 2, null);
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setEndSelectClickListener(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            this.v.setOnClickListener(new a(function0));
        } else {
            this.v.setOnClickListener(null);
        }
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setEndSelectStateToError(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "error");
        ComponentContainer.showError$default(this.t, new int[]{this.v.getId()}, charSequence, null, 4, null);
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setEndSelectStateToNormal() {
        ComponentContainer.showNormal$default(this.t, new int[]{this.v.getId()}, null, 2, null);
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setEndSelectText(@Nullable String str) {
        Input.setText$default(this.v, str, false, 2, null);
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setEndSelectVisible(boolean z) {
        Views.setVisible(this.v, z);
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setPresentTimeCheckboxListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.w = function1;
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setPresentTimeCheckboxText(@Nullable String str) {
        this.s.setTitle(str);
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setPresentTimeCheckboxValue(boolean z) {
        this.s.setChecked(z);
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setPresentTimeCheckboxVisibility(boolean z) {
        Views.setVisible(this.s, z);
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setStartSelectClickListener(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            this.u.setOnClickListener(new b(function0));
        } else {
            this.u.setOnClickListener(null);
        }
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setStartSelectStateToError(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "error");
        ComponentContainer.showError$default(this.t, new int[]{this.u.getId()}, charSequence, null, 4, null);
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setStartSelectStateToNormal() {
        ComponentContainer.showNormal$default(this.t, new int[]{this.u.getId()}, null, 2, null);
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setStartSelectText(@Nullable String str) {
        Input.setText$default(this.u, str, false, 2, null);
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setStartSelectVisible(boolean z) {
        Views.setVisible(this.u, z);
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setTitle(str);
    }
}
