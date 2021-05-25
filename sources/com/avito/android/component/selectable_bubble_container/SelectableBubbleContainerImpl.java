package com.avito.android.component.selectable_bubble_container;

import a2.g.r.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u001e/%B\u000f\u0012\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\nJ+\u0010\u000f\u001a\u00020\u00042\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0012\u001a\u00020\u00042\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0003\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R*\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00066"}, d2 = {"Lcom/avito/android/component/selectable_bubble_container/SelectableBubbleContainerImpl;", "Lcom/avito/android/component/selectable_bubble_container/SelectableBubbleContainer;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", VKApiConst.POSITION, "setSelectedItem", "(I)V", "scrollToPosition", "Lkotlin/Function2;", "Lcom/avito/android/component/selectable_bubble_container/SelectableBubbleContainer$Item;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSelectedItemListener", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "setOnScrollPositionChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "", "items", "setItems", "(Ljava/util/List;)V", "getSelectedPosition", "()I", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/LinearLayoutManager;", "e", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "d", "Lkotlin/jvm/functions/Function2;", "selectedItemListener", "f", "Lkotlin/jvm/functions/Function1;", "scrollChangeListener", "Lcom/avito/android/component/selectable_bubble_container/SelectableBubbleContainerImpl$b;", g.a, "Lcom/avito/android/component/selectable_bubble_container/SelectableBubbleContainerImpl$b;", "adapter", "c", "I", "selectedPosition", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SelectableBubbleContainerImpl implements SelectableBubbleContainer {
    public final TextView a;
    public final RecyclerView b;
    public int c;
    public Function2<? super Integer, ? super SelectableBubbleContainer.Item, Unit> d;
    public final LinearLayoutManager e;
    public Function1<? super Integer, Unit> f;
    public final b g;

    public static final class a extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ SelectableBubbleContainerImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SelectableBubbleContainerImpl selectableBubbleContainerImpl) {
            super(1);
            this.a = selectableBubbleContainerImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            this.a.setSelectedItem(num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class b extends RecyclerView.Adapter<d> {
        @NotNull
        public List<? extends SelectableBubbleContainer.Item> c = CollectionsKt__CollectionsKt.emptyList();
        @Nullable
        public Function1<? super Integer, Unit> d;
        public LayoutInflater e;
        public int f;

        public b(int i) {
            this.f = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.c.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return ((SelectableBubbleContainer.Item) this.c.get(i)).getId();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, int] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(d dVar, int i) {
            d dVar2 = dVar;
            Intrinsics.checkNotNullParameter(dVar2, "holder");
            String title = ((SelectableBubbleContainer.Item) this.c.get(i)).getTitle();
            Objects.requireNonNull(dVar2);
            Intrinsics.checkNotNullParameter(title, "title");
            dVar2.s.setText(title);
            dVar2.s.setChecked(i == this.f);
            a2.a.a.a.g.a aVar = new a2.a.a.a.g.a(this, i);
            Intrinsics.checkNotNullParameter(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            dVar2.itemView.setOnClickListener(new a2.a.a.a.g.b(aVar));
        }

        /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$ViewHolder' to match base method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public d onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            LayoutInflater layoutInflater = this.e;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(viewGroup.getContext());
                this.e = layoutInflater;
            }
            View inflate = layoutInflater.inflate(R.layout.bubble_container_item, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…iner_item, parent, false)");
            return new d(inflate);
        }
    }

    public final class c extends RecyclerView.OnScrollListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                int findFirstVisibleItemPosition = SelectableBubbleContainerImpl.this.e.findFirstVisibleItemPosition();
                if (findFirstVisibleItemPosition == -1) {
                    findFirstVisibleItemPosition = 0;
                }
                Function1 function1 = SelectableBubbleContainerImpl.this.f;
                if (function1 != null) {
                    Unit unit = (Unit) function1.invoke(Integer.valueOf(findFirstVisibleItemPosition));
                }
            }
        }
    }

    public static final class d extends RecyclerView.ViewHolder {
        public final CheckedTextView s;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
            this.s = (CheckedTextView) findViewById;
        }
    }

    public SelectableBubbleContainerImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.b = recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        this.e = linearLayoutManager;
        b bVar = new b(this.c);
        this.g = bVar;
        recyclerView.setLayoutManager(linearLayoutManager);
        new BubbleSnapHelper().attachToRecyclerView(recyclerView);
        bVar.setHasStableIds(true);
        bVar.d = new a(this);
        recyclerView.addOnScrollListener(new c());
    }

    @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer
    public int getSelectedPosition() {
        return this.c;
    }

    @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer
    public void scrollToPosition(int i) {
        this.e.scrollToPositionWithOffset(i, 0);
    }

    @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer
    public void setItems(@NotNull List<? extends SelectableBubbleContainer.Item> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        b bVar = this.g;
        Objects.requireNonNull(bVar);
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        bVar.c = list;
        if (this.b.getAdapter() == null) {
            this.b.setAdapter(this.g);
        } else {
            this.g.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer
    public void setOnScrollPositionChangeListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.f = function1;
    }

    @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer
    public void setSelectedItem(int i) {
        if (this.c != i) {
            this.e.scrollToPositionWithOffset(i, 0);
            b bVar = this.g;
            bVar.f = i;
            bVar.notifyItemChanged(this.c);
            this.g.notifyItemChanged(i);
            this.c = i;
            Function2<? super Integer, ? super SelectableBubbleContainer.Item, Unit> function2 = this.d;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(i), this.g.c.get(i));
            }
        }
    }

    @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer
    public void setSelectedItemListener(@Nullable Function2<? super Integer, ? super SelectableBubbleContainer.Item, Unit> function2) {
        this.d = function2;
    }

    @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a.setText(str);
    }
}
