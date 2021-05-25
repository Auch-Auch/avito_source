package com.avito.android.payment.top_up.form;

import a2.a.a.t1.e.a.j;
import a2.g.r.g;
import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.deprecated_design.R;
import com.avito.android.payment.ModalErrorView;
import com.avito.android.payment.PaymentTabletViewsKt;
import com.avito.android.payment.top_up.form.ScreenState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.RecyclerViewsKt;
import com.avito.android.util.Views;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.animator.ExtensibleItemAnimator;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010#\u001a\u00020 \u0012\n\u0010)\u001a\u0006\u0012\u0002\b\u00030(¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/avito/android/payment/top_up/form/TopUpFormViewImpl;", "Lcom/avito/android/payment/top_up/form/TopUpFormView;", "Lcom/avito/android/payment/ModalErrorView;", "", "message", "", "showModalError", "(Ljava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "d", "Ljava/util/List;", "decorators", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroidx/recyclerview/widget/LinearLayoutManager;", "e", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/payment/top_up/form/ScreenState;", "f", "Lio/reactivex/functions/Consumer;", "getScreenBinding", "()Lio/reactivex/functions/Consumer;", "screenBinding", "Landroid/view/View;", g.a, "Landroid/view/View;", "root", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "<init>", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class TopUpFormViewImpl implements TopUpFormView, ModalErrorView {
    public final Context a;
    public final Toolbar b;
    public final RecyclerView c;
    public final List<RecyclerView.ItemDecoration> d = new ArrayList();
    public final LinearLayoutManager e;
    @NotNull
    public final Consumer<ScreenState> f;
    public final View g;

    public static final class a<T> implements Consumer<ScreenState> {
        public final /* synthetic */ TopUpFormViewImpl a;

        public a(TopUpFormViewImpl topUpFormViewImpl) {
            this.a = topUpFormViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ScreenState screenState) {
            ScreenState screenState2 = screenState;
            if (screenState2 instanceof ScreenState.Content) {
                ScreenState.Content content = (ScreenState.Content) screenState2;
                TopUpFormViewImpl.access$replaceDecorationsWith(this.a, content.getDecoratedItems().getDecorations());
                this.a.b.setTitle(content.getTitle());
                if (content.getForceKeyboard()) {
                    RecyclerViewsKt.onFocusedViewSafely$default(this.a.c, null, 0, j.a, 3, null);
                }
            }
        }
    }

    public TopUpFormViewImpl(@NotNull View view, @NotNull RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(view, "root");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.g = view;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        this.a = context;
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.b = (Toolbar) findViewById;
        View findViewById2 = view.findViewById(com.avito.android.payment.R.id.recycler_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.c = recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.e = linearLayoutManager;
        new AppBarView(view);
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new ExtensibleItemAnimator(false, 1, null));
        PaymentTabletViewsKt.setDynamicTabletPaddingsForChild(view, recyclerView);
        this.f = new a(this);
    }

    public static final void access$replaceDecorationsWith(TopUpFormViewImpl topUpFormViewImpl, List list) {
        Iterator<T> it = topUpFormViewImpl.d.iterator();
        while (it.hasNext()) {
            topUpFormViewImpl.c.removeItemDecoration(it.next());
        }
        topUpFormViewImpl.d.clear();
        h.addAll(topUpFormViewImpl.d, list);
        Iterator<T> it2 = topUpFormViewImpl.d.iterator();
        while (it2.hasNext()) {
            topUpFormViewImpl.c.addItemDecoration(it2.next());
        }
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormView
    @NotNull
    public Consumer<ScreenState> getScreenBinding() {
        return this.f;
    }

    @Override // com.avito.android.payment.ModalErrorView
    public void showModalError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.g, str, 0, (String) null, 3, (Function0) null, (Function0) null, 0, 118, (Object) null);
    }
}
