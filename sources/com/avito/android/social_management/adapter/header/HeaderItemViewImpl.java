package com.avito.android.social_management.adapter.header;

import android.view.View;
import androidx.annotation.StringRes;
import com.avito.android.component.subheader.Subheader;
import com.avito.android.component.subheader.SubheaderImpl;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u000e\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0011\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0011\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0016\u0010\rR\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/social_management/adapter/header/HeaderItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/social_management/adapter/header/HeaderItemView;", "Lcom/avito/android/component/subheader/Subheader;", "Lio/reactivex/Observable;", "", "clicks", "()Lio/reactivex/Observable;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "hide", "", "text", "setText", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "show", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "s", "Lkotlin/jvm/functions/Function0;", "unbindListener", "<init>", "(Landroid/view/View;)V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderItemViewImpl extends BaseViewHolder implements HeaderItemView, Subheader {
    public Function0<Unit> s;
    public final View t;
    public final /* synthetic */ SubheaderImpl u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeaderItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = new SubheaderImpl(view);
        this.t = view;
    }

    @Override // com.avito.android.social_management.adapter.header.HeaderItemView
    @NotNull
    public Observable<Unit> clicks() {
        return RxView.clicks(this.t);
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

    @Override // ru.avito.component.text.Text
    public void setText(@StringRes int i) {
        this.u.setText(i);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@Nullable CharSequence charSequence) {
        this.u.setText(charSequence);
    }

    @Override // com.avito.android.social_management.adapter.header.HeaderItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }

    @Override // ru.avito.component.text.Text
    public void show() {
        this.u.show();
    }
}
