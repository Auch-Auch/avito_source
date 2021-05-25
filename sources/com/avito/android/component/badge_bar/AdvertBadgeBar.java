package com.avito.android.component.badge_bar;

import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.component.badge_bar.badge.BadgeItem;
import com.avito.android.component.badge_bar.badge.BadgeItemBlueprint;
import com.avito.android.component.badge_bar.badge.BadgeItemPresenter;
import com.avito.android.component.badge_bar.title.TitleItem;
import com.avito.android.component.badge_bar.title.TitleItemBlueprint;
import com.avito.android.component.badge_bar.title.TitleItemPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.section.GravitySnapHelper;
import com.avito.android.ui_components.R;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010K\u001a\u00020J\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L\u0012\b\b\u0002\u0010N\u001a\u00020\u0005\u0012\b\b\u0002\u0010O\u001a\u00020\u0005¢\u0006\u0004\bP\u0010QJ/\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\t2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR*\u0010'\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058\u0006@FX\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010-R$\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R$\u00105\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058\u0002@BX\u000e¢\u0006\f\n\u0004\b3\u0010\"\"\u0004\b4\u0010&R$\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003060\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006R"}, d2 = {"Lcom/avito/android/component/badge_bar/AdvertBadgeBar;", "Landroid/widget/FrameLayout;", "", "Lcom/avito/android/component/badge_bar/badge/BadgeItem;", "items", "", "preloadCount", "", "expandTitle", "", "setItems", "(Ljava/util/List;ILjava/lang/String;)V", "Lkotlin/Function1;", "badgeClickListener", "setOnBadgeClickListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "expandButtonClickListener", "setExpandButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", PanelStateKt.PANEL_EXPANDED, "setExpanded", "(Z)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", AuthSource.SEND_ABUSE, "()V", "value", "j", "I", "getOrientation", "()I", "setOrientation", "(I)V", "orientation", "Lcom/avito/android/component/badge_bar/ExpandableDataSource;", "f", "Lcom/avito/android/component/badge_bar/ExpandableDataSource;", "dataSource", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", g.a, "Lkotlin/jvm/functions/Function1;", "h", "Lkotlin/jvm/functions/Function0;", "i", "setColumnCount", "columnCount", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "supportedBlueprints", "Lcom/avito/android/component/badge_bar/BadgeSpanProvider;", "c", "Lcom/avito/android/component/badge_bar/BadgeSpanProvider;", "badgeSpanProvider", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "d", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/component/badge_bar/BadgeBarDecoration;", "e", "Lcom/avito/android/component/badge_bar/BadgeBarDecoration;", "itemDecoration", "", "k", "F", "horizontalBadgeRatio", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertBadgeBar extends FrameLayout {
    public final RecyclerView a;
    public final List<ItemBlueprint<?, ?>> b;
    public final BadgeSpanProvider c;
    public final AdapterPresenter d;
    public BadgeBarDecoration e;
    public ExpandableDataSource f;
    public Function1<? super BadgeItem, Unit> g;
    public Function0<Unit> h;
    public int i;
    public int j;
    public float k;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdvertBadgeBar a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertBadgeBar advertBadgeBar) {
            super(0);
            this.a = advertBadgeBar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            AdvertBadgeBar.access$expandItems(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<BadgeItem, Unit> {
        public final /* synthetic */ AdvertBadgeBar a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AdvertBadgeBar advertBadgeBar) {
            super(1);
            this.a = advertBadgeBar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(BadgeItem badgeItem) {
            BadgeItem badgeItem2 = badgeItem;
            Intrinsics.checkNotNullParameter(badgeItem2, "badge");
            AdvertBadgeBar.access$onBadgeClicked(this.a, badgeItem2);
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    public AdvertBadgeBar(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public AdvertBadgeBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public AdvertBadgeBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertBadgeBar(Context context, AttributeSet attributeSet, int i2, int i3, int i4, j jVar) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? R.attr.advertBadgeBar : i2, (i4 & 8) != 0 ? R.style.Widget_Avito_AdvertBadgeBar : i3);
    }

    public static final void access$expandItems(AdvertBadgeBar advertBadgeBar) {
        ExpandableDataSource expandableDataSource = advertBadgeBar.f;
        if (expandableDataSource != null) {
            expandableDataSource.setExpanded(true);
            advertBadgeBar.c.onDataSourceChanged(expandableDataSource);
            advertBadgeBar.d.onDataSourceChanged(expandableDataSource);
            RecyclerView.Adapter adapter = advertBadgeBar.a.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        Function0<Unit> function0 = advertBadgeBar.h;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void access$onBadgeClicked(AdvertBadgeBar advertBadgeBar, BadgeItem badgeItem) {
        Function1<? super BadgeItem, Unit> function1 = advertBadgeBar.g;
        if (function1 != null) {
            function1.invoke(badgeItem);
        }
    }

    /* access modifiers changed from: private */
    public final void setColumnCount(int i2) {
        if (this.i != i2) {
            this.i = i2;
            a();
        }
    }

    public static /* synthetic */ void setItems$default(AdvertBadgeBar advertBadgeBar, List list, int i2, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = list.size();
        }
        if ((i3 & 4) != 0) {
            str = "";
        }
        advertBadgeBar.setItems(list, i2, str);
    }

    public final void a() {
        if (this.j == 1) {
            RecyclerView recyclerView = this.a;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), this.i, this.j, false);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) { // from class: com.avito.android.component.badge_bar.AdvertBadgeBar$updateRecyclerParams$$inlined$apply$lambda$1
                public final /* synthetic */ AdvertBadgeBar e;

                {
                    this.e = r1;
                }

                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i2) {
                    return this.e.c.getSpan(i2, this.e.i);
                }
            });
            Unit unit = Unit.INSTANCE;
            recyclerView.setLayoutManager(gridLayoutManager);
        } else {
            this.a.setLayoutManager(new BadgeLayoutManager(getContext(), 0, false, this.k, 6, null));
        }
        this.a.removeItemDecoration(this.e);
        this.e.setOrientation(this.j);
        this.e.setColumnCount(this.i);
        this.a.addItemDecoration(this.e);
    }

    public final int getOrientation() {
        return this.j;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        boolean z = bundle.getBoolean(PanelStateKt.PANEL_EXPANDED);
        ExpandableDataSource expandableDataSource = this.f;
        if (expandableDataSource != null) {
            expandableDataSource.setExpanded(z);
        }
        super.onRestoreInstanceState(bundle.getParcelable("superState"));
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", onSaveInstanceState);
        ExpandableDataSource expandableDataSource = this.f;
        bundle.putBoolean(PanelStateKt.PANEL_EXPANDED, expandableDataSource != null ? expandableDataSource.getExpanded() : false);
        return bundle;
    }

    public final void setExpandButtonClickListener(@Nullable Function0<Unit> function0) {
        this.h = function0;
    }

    public final void setExpanded(boolean z) {
        ExpandableDataSource expandableDataSource = this.f;
        if (expandableDataSource != null) {
            expandableDataSource.setExpanded(z);
            this.c.onDataSourceChanged(expandableDataSource);
            this.d.onDataSourceChanged(expandableDataSource);
            RecyclerView.Adapter adapter = this.a.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    public final void setItems(@NotNull List<BadgeItem> list, int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(str, "expandTitle");
        ExpandableDataSource expandableDataSource = new ExpandableDataSource(list, new TitleItem("title", str), i2);
        this.c.onDataSourceChanged(expandableDataSource);
        this.d.onDataSourceChanged(expandableDataSource);
        this.f = expandableDataSource;
    }

    public final void setOnBadgeClickListener(@NotNull Function1<? super BadgeItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "badgeClickListener");
        this.g = function1;
    }

    public final void setOrientation(int i2) {
        if (this.j != i2) {
            this.j = i2;
            a();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdvertBadgeBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        int i4;
        Intrinsics.checkNotNullParameter(context, "context");
        List<ItemBlueprint<?, ?>> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ItemBlueprint[]{new TitleItemBlueprint(new TitleItemPresenter(new a(this))), new BadgeItemBlueprint(new BadgeItemPresenter(new b(this)))});
        this.b = listOf;
        this.c = new BadgeSpanProviderImpl();
        this.f = new ExpandableDataSource(CollectionsKt__CollectionsKt.emptyList(), new TitleItem("", ""), 0, 4, null);
        this.i = 1;
        View findViewById = LayoutInflater.from(context).inflate(R.layout.advert_badge_bar, (ViewGroup) this, true).findViewById(R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recycler_view)");
        this.a = (RecyclerView) findViewById;
        Iterator<ItemBlueprint<?, ?>> it = listOf.iterator();
        int i5 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            } else if (it.next() instanceof TitleItemBlueprint) {
                i4 = i5;
                break;
            } else {
                i5++;
            }
        }
        BadgeBarDecoration badgeBarDecoration = new BadgeBarDecoration(context, attributeSet, i2, i3, i4);
        this.e = badgeBarDecoration;
        this.a.addItemDecoration(badgeBarDecoration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AdvertBadgeBar, i2, i3);
        setColumnCount(obtainStyledAttributes.getInteger(R.styleable.AdvertBadgeBar_spanCount, this.i));
        this.k = obtainStyledAttributes.getFloat(R.styleable.AdvertBadgeBar_horizontalBadgeRatio, this.k);
        obtainStyledAttributes.recycle();
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it2 = this.b.iterator();
        while (it2.hasNext()) {
            builder.registerItem(it2.next());
        }
        ItemBinder build = builder.build();
        SimpleAdapterPresenter simpleAdapterPresenter = new SimpleAdapterPresenter(build, build);
        this.d = simpleAdapterPresenter;
        this.a.setAdapter(new SimpleRecyclerAdapter(simpleAdapterPresenter, build));
        new GravitySnapHelper(GravityCompat.START, 0, 2, null).attachToRecyclerView(this.a);
        a();
    }
}
