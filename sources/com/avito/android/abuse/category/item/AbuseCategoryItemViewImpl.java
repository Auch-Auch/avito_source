package com.avito.android.abuse.category.item;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0012\u0010\u0006J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0015\u001a\u00020\u00042\b\b\u0001\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0015\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u001e\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u001e\u0010\nJ\u001a\u0010\u001f\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0001¢\u0006\u0004\b\u001f\u0010\u0016J\u001a\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001f\u0010\u0019J\u0010\u0010 \u001a\u00020\u0004H\u0001¢\u0006\u0004\b \u0010\u0006R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/abuse/category/item/AbuseCategoryItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/abuse/category/item/AbuseCategoryItemView;", "Lcom/avito/android/component/clickable_element/ClickableElement;", "", "onUnbind", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "", "tag", "setTag", "(Ljava/lang/String;)V", "Lio/reactivex/rxjava3/core/Observable;", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "hide", "", "text", "setDescription", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "", "enabled", "setEnabled", "(Z)V", "setOnClickListener", "setText", "show", "s", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AbuseCategoryItemViewImpl extends BaseViewHolder implements AbuseCategoryItemView, ClickableElement {
    public Function0<Unit> s;
    public final View t;
    public final /* synthetic */ ClickableElementImpl u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbuseCategoryItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = new ClickableElementImpl(view);
        this.t = view;
    }

    @Override // com.avito.android.component.clickable_element.ClickableElement
    @NotNull
    public Observable<Unit> clicks() {
        return this.u.clicks();
    }

    @Override // ru.avito.component.text.Text
    public void hide() {
        this.u.hide();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.s;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.component.clickable_element.ClickableElement
    public void setDescription(@StringRes int i) {
        this.u.setDescription(i);
    }

    @Override // com.avito.android.component.clickable_element.ClickableElement
    public void setDescription(@Nullable CharSequence charSequence) {
        this.u.setDescription(charSequence);
    }

    @Override // com.avito.android.component.clickable_element.ClickableElement
    public void setEnabled(boolean z) {
        this.u.setEnabled(z);
    }

    @Override // com.avito.android.component.clickable_element.ClickableElement
    public void setOnClickListener(@Nullable Function0<Unit> function0) {
        this.u.setOnClickListener(function0);
    }

    @Override // com.avito.android.abuse.category.item.AbuseCategoryItemView
    public void setTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        this.t.setTag(str);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@StringRes int i) {
        this.u.setText(i);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@Nullable CharSequence charSequence) {
        this.u.setText(charSequence);
    }

    @Override // com.avito.android.abuse.category.item.AbuseCategoryItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }

    @Override // ru.avito.component.text.Text
    public void show() {
        this.u.show();
    }
}
