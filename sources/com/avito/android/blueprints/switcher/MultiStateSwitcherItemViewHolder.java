package com.avito.android.blueprints.switcher;

import android.view.View;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\b\u0010\tJ$\u0010\r\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0001¢\u0006\u0004\b\u0016\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0012H\u0001¢\u0006\u0004\b\u0017\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0019\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemView;", "", "value", "", "bindHeader", "(Ljava/lang/String;)V", "onUnbind", "()V", "Lkotlin/Function1;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCheckListener", "(Lkotlin/jvm/functions/Function1;)V", "isChecked", "setChecked", "(Z)V", "", "message", "setErrorState", "(Ljava/lang/CharSequence;)V", "setNormalState", "setSubTitle", "setTitle", "setWarningState", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class MultiStateSwitcherItemViewHolder extends BaseViewHolder implements MultiStateSwitcherItemView {
    public final /* synthetic */ MultiStateSwitcherItemViewImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiStateSwitcherItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new MultiStateSwitcherItemViewImpl(view);
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void bindHeader(@Nullable String str) {
        this.s.bindHeader(str);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.s.onUnbind();
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void setCheckListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setCheckListener(function1);
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void setChecked(boolean z) {
        this.s.setChecked(z);
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void setErrorState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        this.s.setErrorState(charSequence);
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void setNormalState(@Nullable CharSequence charSequence) {
        this.s.setNormalState(charSequence);
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void setSubTitle(@Nullable CharSequence charSequence) {
        this.s.setSubTitle(charSequence);
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.s.setTitle(str);
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void setWarningState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        this.s.setWarningState(charSequence);
    }
}
