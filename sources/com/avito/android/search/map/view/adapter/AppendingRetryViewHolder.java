package com.avito.android.search.map.view.adapter;

import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.component.load_snippet.LoadSnippet;
import com.avito.android.component.load_snippet.LoadSnippetImpl;
import com.avito.android.search.map.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/avito/android/search/map/view/adapter/AppendingRetryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/avito/android/search/map/view/adapter/AppendingState;", "appendingState", "", "bindItem", "(Lcom/avito/android/search/map/view/adapter/AppendingState;)V", "Lcom/avito/android/component/load_snippet/LoadSnippet;", "t", "Lcom/avito/android/component/load_snippet/LoadSnippet;", "getLoadSnippet", "()Lcom/avito/android/component/load_snippet/LoadSnippet;", "loadSnippet", "Landroid/view/View;", "s", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "loadingView", "itemView", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "appendingRetryListener", "<init>", "(Landroid/view/View;Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class AppendingRetryViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    public final View s;
    @NotNull
    public final LoadSnippet t;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AppendingRetryListener a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AppendingRetryListener appendingRetryListener) {
            super(0);
            this.a = appendingRetryListener;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.onRetry();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppendingRetryViewHolder(@NotNull View view, @NotNull AppendingRetryListener appendingRetryListener) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(appendingRetryListener, "appendingRetryListener");
        View findViewById = view.findViewById(R.id.progress_bar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.s = findViewById;
        View findViewById2 = view.findViewById(R.id.retry_layout);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        LoadSnippetImpl loadSnippetImpl = new LoadSnippetImpl(findViewById2);
        this.t = loadSnippetImpl;
        Resources resources = view.getResources();
        CharSequence text = resources.getText(com.avito.android.ui_components.R.string.try_again);
        Intrinsics.checkNotNullExpressionValue(text, "resources.getText(ui_R.string.try_again)");
        loadSnippetImpl.setRefreshText(text);
        CharSequence text2 = resources.getText(R.string.items_load_error);
        Intrinsics.checkNotNullExpressionValue(text2, "resources.getText(R.string.items_load_error)");
        loadSnippetImpl.setMessage(text2);
        loadSnippetImpl.setRefreshListener(new a(appendingRetryListener));
    }

    public final void bindItem(@NotNull AppendingState appendingState) {
        Intrinsics.checkNotNullParameter(appendingState, "appendingState");
        if (appendingState == AppendingState.CAN_LOAD || appendingState == AppendingState.LOADING) {
            this.s.setVisibility(0);
            this.t.hide();
            return;
        }
        this.s.setVisibility(8);
        this.t.show();
    }

    @NotNull
    public final LoadSnippet getLoadSnippet() {
        return this.t;
    }

    @NotNull
    public final View getLoadingView() {
        return this.s;
    }
}
