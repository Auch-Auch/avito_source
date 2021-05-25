package com.avito.android.ui.widget.tagged_input;

import a2.g.r.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DimenRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.item_temporary.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.widget.tagged_input.TagItem;
import com.avito.android.util.Logs;
import com.avito.android.util.Views;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00011B\u0019\u0012\u0006\u0010(\u001a\u00020%\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b/\u00100J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0006R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0019R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/avito/android/ui/widget/tagged_input/TagsListViewImpl;", "Lcom/avito/android/ui/widget/tagged_input/TagsListView;", "", "singleLined", "", "setTagListStyle", "(Z)V", "", "itemId", "Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;", "tagsViewModel", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "tagListImmutable", "bindTagsListTo", "(Ljava/lang/String;Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;Landroidx/lifecycle/LifecycleOwner;Z)V", "unbindTagsList", "(Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;)V", "visible", AuthSource.SEND_ABUSE, "", g.a, "I", "sidePaddingRes", "Lcom/avito/android/ui/widget/tagged_input/TagsListViewImpl$TagsAdapter;", "Lcom/avito/android/ui/widget/tagged_input/TagsListViewImpl$TagsAdapter;", "adapter", "Lcom/jakewharton/rxrelay2/PublishRelay;", "d", "Lcom/jakewharton/rxrelay2/PublishRelay;", "visibilityRelay", "Lio/reactivex/Observable;", "e", "Lio/reactivex/Observable;", "getTagsVisible", "()Lio/reactivex/Observable;", "tagsVisible", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "TagsAdapter", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class TagsListViewImpl implements TagsListView {
    public final TagsAdapter a;
    public TagsViewModel b;
    public CompositeDisposable c = new CompositeDisposable();
    public final PublishRelay<Boolean> d;
    @NotNull
    public final Observable<Boolean> e;
    public final RecyclerView f;
    public final int g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b#\u0010$J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/avito/android/ui/widget/tagged_input/TagsListViewImpl$TagsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/ui/widget/tagged_input/TagViewHolder;", "holder", "", VKApiConst.POSITION, "", "onBindViewHolder", "(Lcom/avito/android/ui/widget/tagged_input/TagViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/avito/android/ui/widget/tagged_input/TagViewHolder;", "getItemCount", "()I", "", "Lcom/avito/android/ui/widget/tagged_input/TagItem;", "newItems", "updateItems", "(Ljava/util/List;)V", "Lio/reactivex/Observable;", "itemClicks", "()Lio/reactivex/Observable;", "Lcom/jakewharton/rxrelay2/Relay;", "e", "Lcom/jakewharton/rxrelay2/Relay;", "clicks", "c", "Ljava/util/List;", "items", "Landroid/view/LayoutInflater;", "d", "Landroid/view/LayoutInflater;", "inflater", "<init>", "()V", AuthSource.SEND_ABUSE, "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class TagsAdapter extends RecyclerView.Adapter<TagViewHolder> {
        public List<TagItem> c = CollectionsKt__CollectionsKt.emptyList();
        public LayoutInflater d;
        public final Relay<TagItem> e;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                TagItem.Type.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[0] = 1;
                iArr[1] = 2;
            }
        }

        public static final class a extends DiffUtil.Callback {
            public final List<TagItem> a;
            public final List<TagItem> b;

            public a(@NotNull List<TagItem> list, @NotNull List<TagItem> list2) {
                Intrinsics.checkNotNullParameter(list, "oldTags");
                Intrinsics.checkNotNullParameter(list2, "newTags");
                this.a = list;
                this.b = list2;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i, int i2) {
                return Intrinsics.areEqual(this.a.get(i), this.b.get(i2));
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i, int i2) {
                return areContentsTheSame(i, i2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return this.b.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return this.a.size();
            }
        }

        public static final class b extends Lambda implements Function0<Unit> {
            public final /* synthetic */ TagItem a;
            public final /* synthetic */ TagsAdapter b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(TagItem tagItem, TagsAdapter tagsAdapter, int i) {
                super(0);
                this.a = tagItem;
                this.b = tagsAdapter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                this.b.e.accept(this.a);
                return Unit.INSTANCE;
            }
        }

        public TagsAdapter() {
            PublishRelay create = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
            this.e = create;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.c.size();
        }

        @NotNull
        public final Observable<TagItem> itemClicks() {
            return this.e;
        }

        public final void updateItems(@NotNull List<TagItem> list) {
            Intrinsics.checkNotNullParameter(list, "newItems");
            DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new a(this.c, list));
            Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(T…ck(this.items, newItems))");
            this.c = new ArrayList(list);
            calculateDiff.dispatchUpdatesTo(this);
        }

        public void onBindViewHolder(@NotNull TagViewHolder tagViewHolder, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(tagViewHolder, "holder");
            TagItem tagItem = this.c.get(i);
            tagViewHolder.setText(tagItem.getLabel());
            int ordinal = tagItem.getType().ordinal();
            if (ordinal == 0) {
                i2 = R.style.Avito_Tag;
            } else if (ordinal == 1) {
                i2 = R.style.Avito_Tag_Alternative;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            tagViewHolder.setStyle(i2);
            tagViewHolder.setClickListener(new b(tagItem, this, i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public TagViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            LayoutInflater layoutInflater = this.d;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(viewGroup.getContext());
                this.d = layoutInflater;
            }
            View inflate = layoutInflater.inflate(R.layout.tag_button, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ag_button, parent, false)");
            return new TagViewHolderImpl(inflate);
        }
    }

    public static final class a<T> implements Consumer<TagItem> {
        public final /* synthetic */ TagsViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public a(TagsViewModel tagsViewModel, String str, boolean z) {
            this.a = tagsViewModel;
            this.b = str;
            this.c = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(TagItem tagItem) {
            TagItem tagItem2 = tagItem;
            TagsViewModel tagsViewModel = this.a;
            String str = this.b;
            Intrinsics.checkNotNullExpressionValue(tagItem2, "tagItem");
            tagsViewModel.onTagClicked(str, tagItem2, this.c);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error$default("Failed to process tag click " + th, null, 2, null);
        }
    }

    public TagsListViewImpl(@NotNull RecyclerView recyclerView, @DimenRes int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.f = recyclerView;
        this.g = i;
        TagsAdapter tagsAdapter = new TagsAdapter();
        this.a = tagsAdapter;
        PublishRelay<Boolean> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.d = create;
        Observable<Boolean> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "visibilityRelay.hide()");
        this.e = hide;
        recyclerView.setAdapter(tagsAdapter);
    }

    public static final void access$setTagsVisible(TagsListViewImpl tagsListViewImpl, boolean z) {
        Views.setVisible(tagsListViewImpl.f, z);
        tagsListViewImpl.d.accept(Boolean.valueOf(z));
    }

    public static final void access$updateItems(TagsListViewImpl tagsListViewImpl, List list) {
        tagsListViewImpl.a.updateItems(list);
        TagsListViewKt.access$postDecorationsInvalidation(tagsListViewImpl.f);
    }

    public final void a(boolean z) {
        Views.setVisible(this.f, z);
        this.d.accept(Boolean.valueOf(z));
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsListView
    public void bindTagsListTo(@NotNull String str, @NotNull TagsViewModel tagsViewModel, @NotNull LifecycleOwner lifecycleOwner, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(tagsViewModel, "tagsViewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.b = tagsViewModel;
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.a.itemClicks().distinctUntilChanged().subscribe(new a(tagsViewModel, str, z), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "adapter\n            .ite…k $error\")\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        TagsViewModel tagsViewModel2 = this.b;
        if (tagsViewModel2 != null) {
            Boolean value = tagsViewModel2.tagsVisibility(str).getValue();
            if (value != null) {
                Intrinsics.checkNotNullExpressionValue(value, "it");
                a(value.booleanValue());
            }
            tagsViewModel2.tagsVisibility(str).observe(lifecycleOwner, new a2.a.a.g3.c.b.a(this, str, lifecycleOwner));
            List<TagItem> value2 = tagsViewModel2.tagItems(str).getValue();
            if (value2 != null) {
                Intrinsics.checkNotNullExpressionValue(value2, "it");
                this.a.updateItems(value2);
                TagsListViewKt.access$postDecorationsInvalidation(this.f);
            }
            tagsViewModel2.tagItems(str).observe(lifecycleOwner, new a2.a.a.g3.c.b.b(this, str, lifecycleOwner));
        }
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsListView
    @NotNull
    public Observable<Boolean> getTagsVisible() {
        return this.e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a  */
    @Override // com.avito.android.ui.widget.tagged_input.TagsListView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setTagListStyle(boolean r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r5.f
            android.content.res.Resources r0 = r0.getResources()
            int r1 = r5.g
            int r0 = r0.getDimensionPixelSize(r1)
            androidx.recyclerview.widget.RecyclerView r1 = r5.f
            android.content.Context r1 = r1.getContext()
            int r2 = com.avito.android.util.Contexts.getDisplayHeight(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r1 = com.avito.android.util.Contexts.getDisplayWidth(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            kotlin.Pair r1 = kotlin.TuplesKt.to(r2, r1)
            java.lang.Object r2 = r1.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r1 = r1.component2()
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r3 = 1
            if (r2 <= r1) goto L_0x005a
            float r4 = (float) r2
            float r1 = (float) r1
            float r4 = r4 / r1
            r1 = 1072735191(0x3ff0a3d7, float:1.88)
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x004d
            r1 = 2000(0x7d0, float:2.803E-42)
            if (r2 <= r1) goto L_0x004d
            r1 = 3
            goto L_0x005b
        L_0x004d:
            r1 = 1070805811(0x3fd33333, float:1.65)
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x005a
            r1 = 1920(0x780, float:2.69E-42)
            if (r2 <= r1) goto L_0x005a
            r1 = 2
            goto L_0x005b
        L_0x005a:
            r1 = 1
        L_0x005b:
            r2 = 0
            if (r6 != 0) goto L_0x0062
            if (r1 != r3) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r3 = 0
        L_0x0062:
            androidx.recyclerview.widget.RecyclerView r6 = r5.f
            if (r3 == 0) goto L_0x007a
            com.avito.android.ui.widget.tagged_input.ItemMarginDecoration r1 = new com.avito.android.ui.widget.tagged_input.ItemMarginDecoration
            r1.<init>(r0)
            r6.addItemDecoration(r1)
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            androidx.recyclerview.widget.RecyclerView r1 = r5.f
            android.content.Context r1 = r1.getContext()
            r0.<init>(r1, r2, r2)
            goto L_0x0084
        L_0x007a:
            com.avito.android.lib.design.chips.MultilineLayoutManager r2 = new com.avito.android.lib.design.chips.MultilineLayoutManager
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.<init>(r0, r0, r1)
            r0 = r2
        L_0x0084:
            r6.setLayoutManager(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.ui.widget.tagged_input.TagsListViewImpl.setTagListStyle(boolean):void");
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsListView
    public void unbindTagsList(@NotNull String str, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.c.clear();
        a(false);
        TagsViewModel tagsViewModel = this.b;
        if (tagsViewModel != null) {
            tagsViewModel.tagsVisibility(str).removeObservers(lifecycleOwner);
            tagsViewModel.tagItems(str).removeObservers(lifecycleOwner);
        }
    }
}
