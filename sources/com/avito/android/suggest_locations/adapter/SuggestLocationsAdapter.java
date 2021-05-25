package com.avito.android.suggest_locations.adapter;

import a2.g.r.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.model.location_picker.AddressSuggestion;
import com.avito.android.suggest_locations.R;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u000f\u0012\u0006\u00106\u001a\u000203¢\u0006\u0004\b7\u00108J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001fR\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010)R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00130!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010#R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u0006:"}, d2 = {"Lcom/avito/android/suggest_locations/adapter/SuggestLocationsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", VKApiConst.POSITION, "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "", "Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", "newData", "updateAddressesList", "(Ljava/util/List;)V", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;", "updateLocationsList", "getItemViewType", "(I)I", "clearList", "()V", "getItemCount", "()I", "Lio/reactivex/rxjava3/core/Observable;", "h", "Lio/reactivex/rxjava3/core/Observable;", "getClicks", "()Lio/reactivex/rxjava3/core/Observable;", "clicks", "Lio/reactivex/rxjava3/subjects/PublishSubject;", g.a, "Lio/reactivex/rxjava3/subjects/PublishSubject;", "suggestAddressClicks", "i", "getAddressClicks", "addressClicks", "c", "Ljava/util/List;", "suggestionsList", "d", "addressesList", "f", "suggestClicks", "Landroid/view/LayoutInflater;", "e", "Landroid/view/LayoutInflater;", "layoutInflater", "", "j", "Z", "suggestAddress", "<init>", "(Z)V", "Companion", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_ADDRESS = 1;
    public static final int TYPE_LOCATION = 2;
    public List<SuggestLocationItem> c = CollectionsKt__CollectionsKt.emptyList();
    public List<AddressSuggestion> d = CollectionsKt__CollectionsKt.emptyList();
    public LayoutInflater e;
    public final PublishSubject<SuggestLocationItem> f;
    public final PublishSubject<AddressSuggestion> g;
    @NotNull
    public final Observable<SuggestLocationItem> h;
    @NotNull
    public final Observable<AddressSuggestion> i;
    public final boolean j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/suggest_locations/adapter/SuggestLocationsAdapter$Companion;", "", "", "TYPE_ADDRESS", "I", "TYPE_LOCATION", "<init>", "()V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Predicate<Integer> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public final boolean test(Integer num) {
            int i = this.a;
            if (i == 0) {
                Integer num2 = num;
                int size = ((SuggestLocationsAdapter) this.b).c.size();
                Intrinsics.checkNotNullExpressionValue(num2, "it");
                int intValue = num2.intValue();
                if (intValue >= 0 && size > intValue) {
                    return true;
                }
                return false;
            } else if (i == 1) {
                Integer num3 = num;
                int size2 = ((SuggestLocationsAdapter) this.b).d.size();
                Intrinsics.checkNotNullExpressionValue(num3, "it");
                int intValue2 = num3.intValue();
                if (intValue2 >= 0 && size2 > intValue2) {
                    return true;
                }
                return false;
            } else {
                throw null;
            }
        }
    }

    public static final class b<T, R> implements Function<Integer, SuggestLocationItem> {
        public final /* synthetic */ SuggestLocationsAdapter a;

        public b(SuggestLocationsAdapter suggestLocationsAdapter) {
            this.a = suggestLocationsAdapter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SuggestLocationItem apply(Integer num) {
            Integer num2 = num;
            List list = this.a.c;
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            return (SuggestLocationItem) list.get(num2.intValue());
        }
    }

    public static final class c<T, R> implements Function<Integer, AddressSuggestion> {
        public final /* synthetic */ SuggestLocationsAdapter a;

        public c(SuggestLocationsAdapter suggestLocationsAdapter) {
            this.a = suggestLocationsAdapter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public AddressSuggestion apply(Integer num) {
            Integer num2 = num;
            List list = this.a.d;
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            return (AddressSuggestion) list.get(num2.intValue());
        }
    }

    public SuggestLocationsAdapter(boolean z) {
        this.j = z;
        PublishSubject<SuggestLocationItem> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.f = create;
        PublishSubject<AddressSuggestion> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishSubject.create()");
        this.g = create2;
        this.h = create;
        this.i = create2;
    }

    public final void clearList() {
        if (this.j) {
            this.d = CollectionsKt__CollectionsKt.emptyList();
        } else {
            this.c = CollectionsKt__CollectionsKt.emptyList();
        }
        notifyDataSetChanged();
    }

    @NotNull
    public final Observable<AddressSuggestion> getAddressClicks() {
        return this.i;
    }

    @NotNull
    public final Observable<SuggestLocationItem> getClicks() {
        return this.h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return (this.j ? this.d : this.c).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return this.j ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i2) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (this.j) {
            if (!(viewHolder instanceof SuggestAddressHolder)) {
                viewHolder = null;
            }
            SuggestAddressHolder suggestAddressHolder = (SuggestAddressHolder) viewHolder;
            if (suggestAddressHolder != null) {
                suggestAddressHolder.bind(this.d.get(i2));
                return;
            }
            return;
        }
        if (!(viewHolder instanceof SuggestLocationsHolder)) {
            viewHolder = null;
        }
        SuggestLocationsHolder suggestLocationsHolder = (SuggestLocationsHolder) viewHolder;
        if (suggestLocationsHolder != null) {
            suggestLocationsHolder.bind(this.c.get(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater layoutInflater = this.e;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
            this.e = layoutInflater;
        }
        View inflate = layoutInflater.inflate(R.layout.suggest_locations_item, viewGroup, false);
        if (i2 == 2) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            SuggestLocationsHolder suggestLocationsHolder = new SuggestLocationsHolder(inflate);
            suggestLocationsHolder.getClicks().filter(new a(0, this)).map(new b(this)).subscribe(this.f);
            return suggestLocationsHolder;
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        SuggestAddressHolder suggestAddressHolder = new SuggestAddressHolder(inflate);
        suggestAddressHolder.getClicks().filter(new a(1, this)).map(new c(this)).subscribe(this.g);
        return suggestAddressHolder;
    }

    public final void updateAddressesList(@NotNull List<AddressSuggestion> list) {
        Intrinsics.checkNotNullParameter(list, "newData");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new SuggestAddressDiffCallback(this.d, list));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(diffCallback)");
        this.d = list;
        calculateDiff.dispatchUpdatesTo(this);
    }

    public final void updateLocationsList(@NotNull List<SuggestLocationItem> list) {
        Intrinsics.checkNotNullParameter(list, "newData");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new SuggestLocationsDiffCallback(this.c, list));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(diffCallback)");
        this.c = list;
        calculateDiff.dispatchUpdatesTo(this);
    }
}
