package com.avito.android.inline_filters.dialog.select;

import a2.a.a.g1.e.d.n;
import a2.a.a.g1.e.d.o;
import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.inline_filters.dialog.InlineFiltersView;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogHeadingItemBlueprint;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogImageSelectItemBlueprint;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemPresenter;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogMultiSelectItemBlueprint;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogSelectItemBlueprint;
import com.avito.android.lib.design.input.Input;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp_core.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.SimpleTextWatcher;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.jakewharton.rxrelay2.PublishRelay;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0001lB\u000f\u0012\u0006\u0010i\u001a\u00020B¢\u0006\u0004\bj\u0010kJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J)\u0010\u0016\u001a\u00020\u00052\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0002\u0012\u0004\u0012\u00020\u00050\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ3\u0010\u001e\u001a&\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00030\u0003 \u001d*\u0012\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u001c0\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0018H\u0016¢\u0006\u0004\b!\u0010\u001bJ\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\"\u0010\u001bJ\u0017\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0018H\u0016¢\u0006\u0004\b$\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\bH\u0016¢\u0006\u0004\b*\u0010\u000bJ\u001d\u0010,\u001a\u00020\u00052\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0004\b,\u0010\u0011J\u001d\u0010.\u001a\u00020\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b.\u0010\u0007R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u00101R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u00101R\u0018\u0010K\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010@R(\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bL\u0010G\u001a\u0004\bM\u0010N\"\u0004\bO\u0010\u0007R\u0016\u0010S\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR.\u0010Z\u001a\u0004\u0018\u00010X2\b\u0010Y\u001a\u0004\u0018\u00010X8V@VX\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0016\u0010a\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010RR:\u0010d\u001a&\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00030\u0003 \u001d*\u0012\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010g¨\u0006m"}, d2 = {"Lcom/avito/android/inline_filters/dialog/select/SelectFilterView;", "Lcom/avito/android/inline_filters/dialog/InlineFiltersView;", "", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "items", "", "setItemsView", "(Ljava/util/List;)V", "", "titleText", "setTitle", "(Ljava/lang/String;)V", "resetActionHint", "setResetActionHint", "Lkotlin/Function0;", "resetAction", "setResetAction", "(Lkotlin/jvm/functions/Function0;)V", "closeAction", "setCloseAction", "Lkotlin/Function1;", "applyAction", "setApplyAction", "(Lkotlin/jvm/functions/Function1;)V", "", "visible", "setApplyBtnVisible", "(Z)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "selectAction", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "clickable", "setResetActionClickable", "setResetActionVisibility", "enabled", "setBackButtonEnabled", "", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "setSearchInputVisibility", "(I)V", "text", "setApplyBtnText", "exposeAction", "setImageFilterExposeAction", "newItems", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "emptyView", "Lcom/avito/android/lib/design/input/Input;", "e", "Lcom/avito/android/lib/design/input/Input;", "searchFilterInput", "title", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "n", "Lkotlin/jvm/functions/Function0;", "Landroid/graphics/drawable/Drawable;", "i", "Landroid/graphics/drawable/Drawable;", "closeIcon", "Landroid/view/View;", "c", "Landroid/view/View;", "closeButton", "k", "Ljava/util/List;", AuthSource.BOOKING_ORDER, "resetButton", "j", "backIcon", "l", "getVisibleItems", "()Ljava/util/List;", "setVisibleItems", "visibleItems", "h", "I", "gray28Color", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "p", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "adapterPresenter", "Landroid/os/Parcelable;", "value", "state", "Landroid/os/Parcelable;", "getState", "()Landroid/os/Parcelable;", "setState", "(Landroid/os/Parcelable;)V", g.a, "blueColor", AuthSource.OPEN_CHANNEL_LIST, "Lcom/jakewharton/rxrelay2/PublishRelay;", "clickRelay", "Lcom/avito/konveyor/ItemBinder;", "o", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "rootView", "<init>", "(Landroid/view/View;)V", "State", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public class SelectFilterView implements InlineFiltersView {
    public final TextView a;
    public final TextView b;
    public final View c;
    public final RecyclerView d;
    public final Input e;
    public final TextView f;
    public final int g;
    public final int h;
    public final Drawable i;
    public final Drawable j;
    public List<InlineFiltersDialogItem> k;
    @NotNull
    public List<InlineFiltersDialogItem> l;
    public final PublishRelay<InlineFiltersDialogItem> m = PublishRelay.create();
    public Function0<Unit> n;
    public final ItemBinder o;
    public final SimpleAdapterPresenter p;

    @Parcelize
    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new Creator();
        @Nullable
        public final String a;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<State> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new State(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State[] newArray(int i) {
                return new State[i];
            }
        }

        public State(@Nullable String str) {
            this.a = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
        }
    }

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

    public SelectFilterView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.inline_filter_dialog_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…line_filter_dialog_title)");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.reset_action_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.close_inline_filter_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById3;
        View findViewById4 = view.findViewById(R.id.filter_options_recycler_view);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.d = recyclerView;
        View findViewById5 = view.findViewById(R.id.search_edit_text);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        Input input = (Input) findViewById5;
        this.e = input;
        View findViewById6 = view.findViewById(R.id.empty_view_hint);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById6;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.g = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.blue);
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "rootView.context");
        this.h = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.gray28);
        this.i = ContextCompat.getDrawable(view.getContext(), com.avito.android.ui_components.R.drawable.ic_close_24_black);
        this.j = ContextCompat.getDrawable(view.getContext(), com.avito.android.ui_components.R.drawable.ic_back_24_black);
        List<InlineFiltersDialogItem> emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.k = emptyList;
        this.l = emptyList;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);
        InlineFiltersDialogItemPresenter inlineFiltersDialogItemPresenter = new InlineFiltersDialogItemPresenter(new n(this), new o(this));
        InlineFiltersDialogSelectItemBlueprint inlineFiltersDialogSelectItemBlueprint = new InlineFiltersDialogSelectItemBlueprint(inlineFiltersDialogItemPresenter);
        InlineFiltersDialogHeadingItemBlueprint inlineFiltersDialogHeadingItemBlueprint = new InlineFiltersDialogHeadingItemBlueprint(inlineFiltersDialogItemPresenter);
        InlineFiltersDialogMultiSelectItemBlueprint inlineFiltersDialogMultiSelectItemBlueprint = new InlineFiltersDialogMultiSelectItemBlueprint(inlineFiltersDialogItemPresenter);
        ItemBinder build = new ItemBinder.Builder().registerItem(inlineFiltersDialogSelectItemBlueprint).registerItem(inlineFiltersDialogHeadingItemBlueprint).registerItem(inlineFiltersDialogMultiSelectItemBlueprint).registerItem(new InlineFiltersDialogImageSelectItemBlueprint(inlineFiltersDialogItemPresenter)).build();
        this.o = build;
        this.p = new SimpleAdapterPresenter(build, build);
        input.addTextChangedListener(new SimpleTextWatcher() { // from class: com.avito.android.inline_filters.dialog.select.SelectFilterView$setupSearchInput$1
            @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence charSequence, int i2, int i3, int i4) {
                Intrinsics.checkNotNullParameter(charSequence, "s");
                SelectFilterView.access$handleTextChanges(SelectFilterView.this, charSequence);
            }
        });
    }

    public static final void access$handleTextChanges(SelectFilterView selectFilterView, CharSequence charSequence) {
        int size = selectFilterView.l.size();
        if (charSequence.length() == 0) {
            selectFilterView.l = selectFilterView.k;
            Views.hide(selectFilterView.f);
            Views.show(selectFilterView.d);
            selectFilterView.a(selectFilterView.l);
            return;
        }
        List<InlineFiltersDialogItem> list = selectFilterView.k;
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            T t2 = t;
            if (!t2.isHeading() && StringsKt__StringsKt.contains(t2.getText(), charSequence, true)) {
                arrayList.add(t);
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (hashSet.add(((InlineFiltersDialogItem) next).getText())) {
                arrayList2.add(next);
            }
        }
        selectFilterView.l = arrayList2;
        if (arrayList2.isEmpty()) {
            Views.hide(selectFilterView.d);
            TextView textView = selectFilterView.f;
            textView.setText(textView.getContext().getString(R.string.empty_search_hint, charSequence.toString()));
            Views.show(selectFilterView.f);
        }
        if (size == 0 && (!selectFilterView.l.isEmpty())) {
            Views.hide(selectFilterView.f);
            Views.show(selectFilterView.d);
        }
        selectFilterView.a(selectFilterView.l);
    }

    public static final void access$onItemClicked(SelectFilterView selectFilterView, int i2) {
        if ((!selectFilterView.l.isEmpty()) && i2 >= 0 && i2 < selectFilterView.l.size()) {
            selectFilterView.m.accept(selectFilterView.l.get(i2));
        }
    }

    public final void a(List<InlineFiltersDialogItem> list) {
        this.p.onDataSourceChanged(new ListDataSource(list));
        if (this.d.getAdapter() == null) {
            this.d.setAdapter(new SimpleRecyclerAdapter(this.p, this.o));
            return;
        }
        RecyclerView.Adapter adapter = this.d.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    @Nullable
    public Parcelable getState() {
        return new State(this.e.getDeformattedText());
    }

    @NotNull
    public final List<InlineFiltersDialogItem> getVisibleItems() {
        return this.l;
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setApplyAction(@NotNull Function1<? super List<String>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "applyAction");
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setApplyBtnText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        throw new NotImplementedError(a2.b.a.a.a.c3("An operation is not implemented: ", "not implemented"));
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setApplyBtnVisible(boolean z) {
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setBackButtonEnabled(boolean z) {
        this.c.setBackground(z ? this.j : this.i);
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setCloseAction(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "closeAction");
        this.c.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setImageFilterExposeAction(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "exposeAction");
        this.n = function0;
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setItemsView(@NotNull List<InlineFiltersDialogItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.k = list;
        this.l = list;
        a(list);
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setResetAction(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "resetAction");
        this.b.setOnClickListener(new b(function0));
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setResetActionClickable(boolean z) {
        this.b.setClickable(z);
        if (z) {
            this.b.setTextColor(this.g);
        } else {
            this.b.setTextColor(this.h);
        }
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setResetActionHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "resetActionHint");
        this.b.setText(str);
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setResetActionVisibility(boolean z) {
        Views.setVisible(this.b, z);
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setSearchInputVisibility(int i2) {
        this.e.setVisibility(i2);
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setState(@Nullable Parcelable parcelable) {
        if (parcelable instanceof State) {
            Input.setText$default(this.e, ((State) parcelable).a, false, 2, null);
        }
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "titleText");
        this.a.setText(str);
        this.e.setHint(str);
    }

    public final void setVisibleItems(@NotNull List<InlineFiltersDialogItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.l = list;
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public PublishRelay<InlineFiltersDialogItem> selectAction() {
        return this.m;
    }
}
