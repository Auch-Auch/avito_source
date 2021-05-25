package com.avito.android.settings.adapter;

import android.view.View;
import androidx.annotation.StringRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.clickable_element.ClickableElementImpl;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0017\u001a\u00020\u00052\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0001¢\u0006\u0004\b\u0019\u0010\rJ\u001a\u0010\u0019\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0019\u0010\u0010J\u0010\u0010\u001a\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u001a\u0010\tR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/settings/adapter/InfoSettingsItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/settings/adapter/InfoSettingsItemView;", "Lcom/avito/android/component/clickable_element/ClickableElement;", "Lio/reactivex/rxjava3/core/Observable;", "", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "hide", "()V", "", "text", "setDescription", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "", "enabled", "setEnabled", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setText", "show", "Landroid/view/View;", "s", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class InfoSettingsItemViewImpl extends BaseViewHolder implements InfoSettingsItemView, ClickableElement {
    public final View s;
    public final /* synthetic */ ClickableElementImpl t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfoSettingsItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.t = new ClickableElementImpl(view);
        this.s = view;
    }

    @Override // com.avito.android.component.clickable_element.ClickableElement
    @NotNull
    public Observable<Unit> clicks() {
        return this.t.clicks();
    }

    @Override // ru.avito.component.text.Text
    public void hide() {
        this.t.hide();
    }

    @Override // com.avito.android.component.clickable_element.ClickableElement
    public void setDescription(@StringRes int i) {
        this.t.setDescription(i);
    }

    @Override // com.avito.android.component.clickable_element.ClickableElement
    public void setDescription(@Nullable CharSequence charSequence) {
        this.t.setDescription(charSequence);
    }

    @Override // com.avito.android.component.clickable_element.ClickableElement
    public void setEnabled(boolean z) {
        this.t.setEnabled(z);
    }

    @Override // com.avito.android.component.clickable_element.ClickableElement
    public void setOnClickListener(@Nullable Function0<Unit> function0) {
        this.t.setOnClickListener(function0);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@StringRes int i) {
        this.t.setText(i);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@Nullable CharSequence charSequence) {
        this.t.setText(charSequence);
    }

    @Override // ru.avito.component.text.Text
    public void show() {
        this.t.show();
    }
}
