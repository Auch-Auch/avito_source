package com.avito.android.favorite_sellers.adapter.error;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\t\u0010\nJ \u0010\r\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0011\u0010\u0006R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/error/ErrorItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/favorite_sellers/adapter/error/ErrorItemView;", "Lcom/avito/android/component/load_snippet/LoadSnippet;", "", "hide", "()V", "", "message", "setMessage", "(Ljava/lang/CharSequence;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRefreshListener", "(Lkotlin/jvm/functions/Function0;)V", "refreshText", "setRefreshText", "show", "Landroid/view/View;", "s", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class ErrorItemViewImpl extends BaseViewHolder implements ErrorItemView, LoadSnippet {
    public final View s;
    public final /* synthetic */ LoadSnippetImpl t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ErrorItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = new LoadSnippetImpl(view);
        this.s = view;
    }

    @Override // com.avito.android.component.load_snippet.LoadSnippet
    public void hide() {
        this.t.hide();
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

    @Override // com.avito.android.component.load_snippet.LoadSnippet
    public void show() {
        this.t.show();
    }
}
