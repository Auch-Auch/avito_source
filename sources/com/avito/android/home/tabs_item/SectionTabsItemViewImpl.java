package com.avito.android.home.tabs_item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.home.tabs_item.SectionTabsItemView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.R;
import com.avito.android.util.preferences.Preferences;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.popup.BlackInfoPopup;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002-.B\u0017\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u00020\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006/"}, d2 = {"Lcom/avito/android/home/tabs_item/SectionTabsItemViewImpl;", "Lcom/avito/android/home/tabs_item/SectionTabsItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "Lcom/avito/android/home/tabs_item/TabItem;", "items", "", "setItems", "(Ljava/util/List;)V", "", VKApiConst.POSITION, "", "invokeListener", "setSelectedPosition", "(IZ)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSelectedItemListener", "(Lkotlin/jvm/functions/Function1;)V", "t", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "s", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "La2/a/a/a1/d0/a;", VKApiConst.VERSION, "La2/a/a/a1/d0/a;", "smoothScroller", "Lcom/avito/android/home/tabs_item/SectionTabsItemViewImpl$b;", "Lcom/avito/android/home/tabs_item/SectionTabsItemViewImpl$b;", "adapter", "Landroidx/recyclerview/widget/LinearLayoutManager;", "u", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "w", "Lkotlin/jvm/functions/Function1;", "selectedItemListener", "Landroid/view/View;", "view", "Lcom/avito/android/util/preferences/Preferences;", "defaultPreferences", "<init>", "(Landroid/view/View;Lcom/avito/android/util/preferences/Preferences;)V", AuthSource.BOOKING_ORDER, "c", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class SectionTabsItemViewImpl extends BaseViewHolder implements SectionTabsItemView {
    public final RecyclerView s;
    public final b t;
    public final LinearLayoutManager u;
    public final a2.a.a.a1.d0.a v;
    public Function1<? super Integer, Unit> w;

    public static final class a extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ SectionTabsItemViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SectionTabsItemViewImpl sectionTabsItemViewImpl) {
            super(1);
            this.a = sectionTabsItemViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            int intValue = num.intValue();
            if (this.a.t.c != intValue) {
                SectionTabsItemView.DefaultImpls.setSelectedPosition$default(this.a, intValue, false, 2, null);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends RecyclerView.Adapter<c> {
        public int c;
        @NotNull
        public List<? extends TabItem> d = CollectionsKt__CollectionsKt.emptyList();
        @Nullable
        public Function1<? super Integer, Unit> e;
        public LayoutInflater f;
        public final Preferences g;

        public b(@NotNull Preferences preferences) {
            Intrinsics.checkNotNullParameter(preferences, "defaultPreferences");
            this.g = preferences;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return ((TabItem) this.d.get(i)).getId();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, int] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(c cVar, int i) {
            c cVar2 = cVar;
            Intrinsics.checkNotNullParameter(cVar2, "holder");
            String title = ((TabItem) this.d.get(i)).getTitle();
            Objects.requireNonNull(cVar2);
            Intrinsics.checkNotNullParameter(title, "title");
            cVar2.s.setText(title);
            cVar2.s.setChecked(i == this.c);
            a2.a.a.a1.d0.b bVar = new a2.a.a.a1.d0.b(this, i);
            Intrinsics.checkNotNullParameter(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            cVar2.itemView.setOnClickListener(new a2.a.a.a1.d0.c(bVar));
            String tooltip = ((TabItem) this.d.get(i)).getTooltip();
            String tooltipId = ((TabItem) this.d.get(i)).getTooltipId();
            if (tooltipId != null && tooltip != null && !cVar2.t.contains(tooltipId)) {
                Context context = cVar2.s.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "title.context");
                new BlackInfoPopup(context).setText(tooltip).show(cVar2.s, false);
                cVar2.t.putBoolean(tooltipId, true);
            }
        }

        /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$ViewHolder' to match base method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public c onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            LayoutInflater layoutInflater = this.f;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(viewGroup.getContext());
                this.f = layoutInflater;
            }
            View inflate = layoutInflater.inflate(R.layout.tab_item, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layout.tab_item, parent, false)");
            return new c(inflate, this.g);
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public final CheckedTextView s;
        public final Preferences t;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(@NotNull View view, @NotNull Preferences preferences) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(preferences, "defaultPreferences");
            this.t = preferences;
            View findViewById = view.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
            this.s = (CheckedTextView) findViewById;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SectionTabsItemViewImpl(@NotNull View view, @NotNull Preferences preferences) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(preferences, "defaultPreferences");
        View findViewById = view.findViewById(R.id.section_tabs);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.s = recyclerView;
        recyclerView.setItemAnimator(null);
        b bVar = new b(preferences);
        this.t = bVar;
        bVar.setHasStableIds(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        this.u = linearLayoutManager;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(bVar);
        bVar.e = new a(this);
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "recycler.context");
        this.v = new a2.a.a.a1.d0.a(context);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        SectionTabsItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.home.tabs_item.SectionTabsItemView
    public void setItems(@NotNull List<? extends TabItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        b bVar = this.t;
        Objects.requireNonNull(bVar);
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        bVar.d = list;
        this.t.notifyDataSetChanged();
    }

    @Override // com.avito.android.home.tabs_item.SectionTabsItemView
    public void setSelectedItemListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.w = function1;
    }

    @Override // com.avito.android.home.tabs_item.SectionTabsItemView
    public void setSelectedPosition(int i, boolean z) {
        b bVar;
        int i2;
        Function1<? super Integer, Unit> function1;
        if (i < 0 || (i2 = (bVar = this.t).c) == i) {
            t();
            return;
        }
        bVar.notifyItemChanged(i2);
        this.t.notifyItemChanged(i);
        this.t.c = i;
        t();
        if (z && (function1 = this.w) != null) {
            function1.invoke(Integer.valueOf(i));
        }
    }

    public final void t() {
        this.v.setTargetPosition(this.t.c);
        this.v.l = this.s.computeHorizontalScrollOffset();
        this.v.m = this.s.computeHorizontalScrollRange();
        this.u.startSmoothScroll(this.v);
    }
}
