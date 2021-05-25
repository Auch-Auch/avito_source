package com.avito.android.profile.edit.refactoring.adapter;

import android.view.View;
import androidx.annotation.StringRes;
import com.avito.android.component.selectable_single_line.SelectableSingleLine;
import com.avito.android.component.selectable_single_line.SelectableSingleLineImpl;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u000b\u0010\nJ\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0011\u0010\u000fJ\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0013\u0010\u000fJ\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0016\u001a\u00020\u00052\b\b\u0001\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u0016\u0010\u001aJ\u001e\u0010\u001d\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0001¢\u0006\u0004\b\u001f\u0010\u001eJ\u001a\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010 H\u0001¢\u0006\u0004\b\"\u0010#J\u001e\u0010&\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020 0$H\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0005H\u0001¢\u0006\u0004\b(\u0010\n¨\u0006-"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/SelectItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/profile/edit/refactoring/adapter/SelectableSinleLineItemView;", "Lcom/avito/android/component/selectable_single_line/SelectableSingleLine;", "Lio/reactivex/rxjava3/core/Observable;", "", "clearClicks", "()Lio/reactivex/rxjava3/core/Observable;", "clicks", "hide", "()V", "removeOnClickListener", "", "visible", "setClearButtonVisible", "(Z)V", "enabled", "setEnabled", "hasError", "setHasError", "", "hint", "setHint", "(Ljava/lang/CharSequence;)V", "", "hintRes", "(I)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClearClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setOnClickListener", "", "value", "setValue", "(Ljava/lang/String;)V", "", ResidentialComplexModuleKt.VALUES, "setValues", "(Ljava/util/List;)V", "show", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SelectItemViewImpl extends BaseViewHolder implements SelectableSinleLineItemView, SelectableSingleLine {
    public final /* synthetic */ SelectableSingleLineImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.s = new SelectableSingleLineImpl(view);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    @NotNull
    public Observable<Unit> clearClicks() {
        return this.s.clearClicks();
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    @NotNull
    public Observable<Unit> clicks() {
        return this.s.clicks();
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void hide() {
        this.s.hide();
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void removeOnClickListener() {
        this.s.removeOnClickListener();
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setClearButtonVisible(boolean z) {
        this.s.setClearButtonVisible(z);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setEnabled(boolean z) {
        this.s.setEnabled(z);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setHasError(boolean z) {
        this.s.setHasError(z);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setHint(@StringRes int i) {
        this.s.setHint(i);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setHint(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "hint");
        this.s.setHint(charSequence);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setOnClearClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClearClickListener(function0);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(function0);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setValue(@Nullable String str) {
        this.s.setValue(str);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setValues(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        this.s.setValues(list);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void show() {
        this.s.show();
    }
}
