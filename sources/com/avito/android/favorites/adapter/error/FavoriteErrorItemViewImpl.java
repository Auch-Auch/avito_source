package com.avito.android.favorites.adapter.error;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u000f\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u000f\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0011\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0012\u0010\nR\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/favorites/adapter/error/FavoriteErrorItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/favorites/adapter/error/FavoriteErrorItemView;", "Lcom/avito/android/component/load_snippet/LoadSnippet;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "hide", "()V", "", "message", "setMessage", "(Ljava/lang/CharSequence;)V", "setRefreshListener", "refreshText", "setRefreshText", "show", "s", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteErrorItemViewImpl extends BaseViewHolder implements FavoriteErrorItemView, LoadSnippet {
    public Function0<Unit> s;
    public final View t;
    public final /* synthetic */ LoadSnippetImpl u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FavoriteErrorItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = new LoadSnippetImpl(view);
        this.t = view;
    }

    @Override // com.avito.android.component.load_snippet.LoadSnippet
    public void hide() {
        this.u.hide();
    }

    @Override // com.avito.android.component.load_snippet.LoadSnippet
    public void setMessage(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        this.u.setMessage(charSequence);
    }

    @Override // com.avito.android.component.load_snippet.LoadSnippet
    public void setRefreshListener(@Nullable Function0<Unit> function0) {
        this.u.setRefreshListener(function0);
    }

    @Override // com.avito.android.component.load_snippet.LoadSnippet
    public void setRefreshText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "refreshText");
        this.u.setRefreshText(charSequence);
    }

    @Override // com.avito.android.favorites.adapter.error.FavoriteErrorItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }

    @Override // com.avito.android.component.load_snippet.LoadSnippet
    public void show() {
        this.u.show();
    }
}
