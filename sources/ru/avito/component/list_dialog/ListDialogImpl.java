package ru.avito.component.list_dialog;

import a2.g.r.g;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextsKt;
import com.avito.android.util.ViewTreeObservers;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.data_source.DataSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button_panel.ButtonPanel;
import ru.avito.component.button_panel.ButtonPanelImpl;
import ru.avito.component.text.Text;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001+B%\u0012\u0006\u0010A\u001a\u00020-\u0012\u0014\u0010D\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030C0B¢\u0006\u0004\bE\u0010FJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\nJ\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0018\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0018\u0010\nJ \u0010\u001c\u001a\u00020\u00052\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001aH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u001e\u0010\u0015J\u001a\u0010\u001f\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0004\b\u001f\u0010\u0019J\u001a\u0010\u001f\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u001f\u0010\nJ\u0018\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0012H\u0001¢\u0006\u0004\b!\u0010\u0015J \u0010\"\u001a\u00020\u00052\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001aH\u0001¢\u0006\u0004\b\"\u0010\u001dR\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u0004\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u001c\u00108\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\f\n\u0004\b4\u00105\u0012\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006G"}, d2 = {"Lru/avito/component/list_dialog/ListDialogImpl;", "Lru/avito/component/list_dialog/ListDialog;", "Lru/avito/component/button_panel/ButtonPanel;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "textId", "(I)V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "dataSource", "setDataSource", "(Lcom/avito/konveyor/data_source/DataSource;)V", VKApiConst.POSITION, "notifyItemChanged", "", "enabled", "setPrimaryButtonEnabled", "(Z)V", "", "text", "setPrimaryButtonText", "(Ljava/lang/CharSequence;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPrimaryClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setSecondaryButtonEnabled", "setSecondaryButtonText", "visible", "setSecondaryButtonVisible", "setSecondaryClickListener", "Landroidx/recyclerview/widget/LinearLayoutManager;", "d", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "f", "Z", "canShowBottomDivider", "Lru/avito/component/text/Text;", AuthSource.SEND_ABUSE, "Lru/avito/component/text/Text;", "Landroid/view/View;", "c", "Landroid/view/View;", "bottomDivider", AuthSource.BOOKING_ORDER, "topDivider", "Lcom/avito/konveyor/ItemBinder;", g.a, "Lcom/avito/konveyor/ItemBinder;", "getItemBinder$annotations", "()V", "itemBinder", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "h", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "view", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "blueprints", "<init>", "(Landroid/view/View;Ljava/util/List;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ListDialogImpl implements ListDialog, ButtonPanel {
    public final Text a;
    public final View b;
    public final View c;
    public final LinearLayoutManager d;
    public final RecyclerView e;
    public boolean f;
    public final ItemBinder g;
    public final AdapterPresenter h;
    public final /* synthetic */ ButtonPanelImpl i;

    public final class a extends RecyclerView.OnScrollListener {
        public int a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            int i3 = this.a + i2;
            this.a = i3;
            if (i3 == 0) {
                Views.conceal(ListDialogImpl.this.b);
                return;
            }
            Views.show(ListDialogImpl.this.b);
            Views.setVisible(ListDialogImpl.this.c, ListDialogImpl.this.f && !ListDialogImpl.access$isEndOfList(ListDialogImpl.this));
        }
    }

    public ListDialogImpl(@NotNull View view, @NotNull List<? extends ItemBlueprint<?, ?>> list) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(list, "blueprints");
        View findViewById = view.findViewById(R.id.button_panel);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.i = new ButtonPanelImpl(findViewById);
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.a = new TextImpl(findViewById2);
        View findViewById3 = view.findViewById(R.id.top_divider);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById3;
        View findViewById4 = view.findViewById(R.id.bottom_divider);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById4;
        View findViewById5 = view.findViewById(R.id.recycler_view);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.e = (RecyclerView) findViewById5;
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            builder.registerItem(it.next());
        }
        Unit unit = Unit.INSTANCE;
        ItemBinder build = builder.build();
        this.g = build;
        this.h = new SimpleAdapterPresenter(build, build);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        this.d = linearLayoutManager;
        this.e.setLayoutManager(linearLayoutManager);
        this.e.addOnScrollListener(new a());
    }

    public static final boolean access$isEndOfList(ListDialogImpl listDialogImpl) {
        return listDialogImpl.d.findLastCompletelyVisibleItemPosition() == listDialogImpl.d.getItemCount() - 1;
    }

    @Override // ru.avito.component.list_dialog.ListDialog
    public void notifyItemChanged(int i2) {
        RecyclerView.Adapter adapter = this.e.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i2);
        }
    }

    @Override // ru.avito.component.list_dialog.ListDialog
    public void setDataSource(@NotNull DataSource<? extends Item> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.h.onDataSourceChanged(dataSource);
        if (this.e.getAdapter() == null) {
            this.e.setAdapter(new SimpleRecyclerAdapter(this.h, this.g));
        } else {
            RecyclerView.Adapter adapter = this.e.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        ViewTreeObserver viewTreeObserver = this.e.getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "recycler.viewTreeObserver");
        if (viewTreeObserver.isAlive()) {
            this.e.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ru.avito.component.list_dialog.ListDialogImpl$checkIfCanShowDivider$1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ViewTreeObserver viewTreeObserver2 = ListDialogImpl.this.e.getViewTreeObserver();
                    Intrinsics.checkNotNullExpressionValue(viewTreeObserver2, "recycler.viewTreeObserver");
                    ViewTreeObservers.removeGlobalLayoutListener(viewTreeObserver2, this);
                    int findLastCompletelyVisibleItemPosition = ListDialogImpl.this.d.findLastCompletelyVisibleItemPosition();
                    ListDialogImpl listDialogImpl = ListDialogImpl.this;
                    boolean z = true;
                    if (listDialogImpl.d.getItemCount() - 1 <= findLastCompletelyVisibleItemPosition) {
                        z = false;
                    }
                    listDialogImpl.f = z;
                    if (ListDialogImpl.this.f) {
                        Views.show(ListDialogImpl.this.c);
                    }
                }
            });
        }
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryButtonEnabled(boolean z) {
        this.i.setPrimaryButtonEnabled(z);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryButtonText(@StringRes int i2) {
        this.i.setPrimaryButtonText(i2);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryButtonText(@Nullable CharSequence charSequence) {
        this.i.setPrimaryButtonText(charSequence);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryClickListener(@Nullable Function0<Unit> function0) {
        this.i.setPrimaryClickListener(function0);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonEnabled(boolean z) {
        this.i.setSecondaryButtonEnabled(z);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonText(@StringRes int i2) {
        this.i.setSecondaryButtonText(i2);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonText(@Nullable CharSequence charSequence) {
        this.i.setSecondaryButtonText(charSequence);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonVisible(boolean z) {
        this.i.setSecondaryButtonVisible(z);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryClickListener(@Nullable Function0<Unit> function0) {
        this.i.setSecondaryClickListener(function0);
    }

    @Override // ru.avito.component.list_dialog.ListDialog
    public void setTitle(@Nullable String str) {
        TextsKt.bindText(this.a, str);
    }

    @Override // ru.avito.component.list_dialog.ListDialog
    public void setTitle(int i2) {
        this.a.show();
        this.a.setText(i2);
    }
}
