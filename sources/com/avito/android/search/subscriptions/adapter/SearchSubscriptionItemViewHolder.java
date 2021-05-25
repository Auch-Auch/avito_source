package com.avito.android.search.subscriptions.adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.model.Sort;
import com.avito.android.search.subscriptions.R;
import com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemView;
import com.avito.android.util.TextViews;
import com.avito.android.util.TypefaceType;
import com.avito.android.util.Typefaces;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010)\u001a\u00020&¢\u0006\u0004\b,\u0010-J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0007J\u001d\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010\u001a¨\u0006."}, d2 = {"Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemViewHolder;", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "bold", "setTitleInBold", "(Z)V", "show", "showUpdatesIndicator", "description", "setDescription", Sort.DATE, "setDate", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setOnRemoveClickListener", "setOnMoreClickListener", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "titleView", "Landroid/view/MenuInflater;", "s", "Landroid/view/MenuInflater;", "menuInflater", "u", "descriptionView", "Lcom/avito/android/lib/design/button/Button;", "w", "Lcom/avito/android/lib/design/button/Button;", "moreButton", "Landroid/view/View;", "x", "Landroid/view/View;", "rootView", VKApiConst.VERSION, "dateView", "<init>", "(Landroid/view/View;)V", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public final class SearchSubscriptionItemViewHolder extends BaseViewHolder implements SearchSubscriptionItemView {
    public final MenuInflater s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final Button w;
    public final View x;

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

    public static final class c implements View.OnCreateContextMenuListener {
        public final /* synthetic */ SearchSubscriptionItemViewHolder a;
        public final /* synthetic */ Function0 b;

        public static final class a implements MenuItem.OnMenuItemClickListener {
            public final /* synthetic */ c a;

            public a(c cVar) {
                this.a = cVar;
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.a.b.invoke();
                return true;
            }
        }

        public c(SearchSubscriptionItemViewHolder searchSubscriptionItemViewHolder, Function0 function0) {
            this.a = searchSubscriptionItemViewHolder;
            this.b = function0;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            this.a.s.inflate(R.menu.item_context_menu, contextMenu);
            contextMenu.findItem(R.id.delete_favorite_item).setOnMenuItemClickListener(new a(this));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchSubscriptionItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.x = view;
        this.s = new MenuInflater(view.getContext());
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.view_description);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.date);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.saved_search_btn_more);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.saved_search_btn_more)");
        this.w = (Button) findViewById4;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        SearchSubscriptionItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemView
    public void setDate(@Nullable String str) {
        TextViews.bindText$default(this.v, str, false, 2, null);
    }

    @Override // com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemView
    public void setDescription(@Nullable String str) {
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    @Override // com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemView
    public void setOnItemClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.x.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemView
    public void setOnMoreClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.w.setOnClickListener(new b(function0));
    }

    @Override // com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemView
    public void setOnRemoveClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.x.setOnCreateContextMenuListener(new c(this, function0));
    }

    @Override // com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemView
    public void setTitle(@Nullable String str) {
        if (str != null) {
            this.t.setText(str);
        }
    }

    @Override // com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemView
    public void setTitleInBold(boolean z) {
        if (z) {
            TextView textView = this.t;
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "titleView.context");
            textView.setTypeface(Typefaces.getTypeface(context, TypefaceType.Bold));
            return;
        }
        TextView textView2 = this.t;
        Context context2 = textView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "titleView.context");
        textView2.setTypeface(Typefaces.getTypeface(context2, TypefaceType.Regular));
    }

    @Override // com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemView
    public void showUpdatesIndicator(boolean z) {
        if (z) {
            this.t.setCompoundDrawablesWithIntrinsicBounds(com.avito.android.ui_components.R.drawable.circle_blue, 0, 0, 0);
        } else {
            this.t.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }
}
