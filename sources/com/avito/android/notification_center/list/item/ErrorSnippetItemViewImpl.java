package com.avito.android.notification_center.list.item;

import android.view.View;
import com.avito.android.component.load_snippet.LoadSnippet;
import com.avito.android.component.load_snippet.LoadSnippetImpl;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000b\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0010\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0012\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0013\u0010\u0006R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/avito/android/notification_center/list/item/ErrorSnippetItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/notification_center/list/item/ErrorSnippetItemView;", "Lcom/avito/android/component/load_snippet/LoadSnippet;", "", "onUnbind", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "hide", "", "message", "setMessage", "(Ljava/lang/CharSequence;)V", "setRefreshListener", "refreshText", "setRefreshText", "show", "s", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "notification_release"}, k = 1, mv = {1, 4, 2})
public final class ErrorSnippetItemViewImpl extends BaseViewHolder implements ErrorSnippetItemView, LoadSnippet {
    public Function0<Unit> s;
    public final /* synthetic */ LoadSnippetImpl t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ErrorSnippetItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.t = new LoadSnippetImpl(view);
    }

    @Override // com.avito.android.component.load_snippet.LoadSnippet
    public void hide() {
        this.t.hide();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.s;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.component.load_snippet.LoadSnippet
    public void setMessage(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        this.t.setMessage(charSequence);
    }

    @Override // com.avito.android.component.load_snippet.LoadSnippet
    public void setRefreshListener(@Nullable Function0<Unit> function0) {
        this.t.setRefreshListener(function0);
    }

    @Override // com.avito.android.component.load_snippet.LoadSnippet
    public void setRefreshText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "refreshText");
        this.t.setRefreshText(charSequence);
    }

    @Override // com.avito.android.notification_center.list.item.ErrorSnippetItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }

    @Override // com.avito.android.component.load_snippet.LoadSnippet
    public void show() {
        this.t.show();
    }
}
