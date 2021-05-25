package com.avito.android.location_picker.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.location_picker.R;
import com.avito.android.remote.model.SearchRadius;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J\u0013\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/location_picker/view/RadiusAdapterImpl;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/location_picker/view/RadiusViewHolder;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/SearchRadius;", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "newData", "", "updateData", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/avito/android/location_picker/view/RadiusViewHolder;", "getItemCount", "()I", "holder", VKApiConst.POSITION, "onBindViewHolder", "(Lcom/avito/android/location_picker/view/RadiusViewHolder;I)V", "", "isDataEmpty", "()Z", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "e", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "subjectClicks", "Landroid/view/LayoutInflater;", "d", "Landroid/view/LayoutInflater;", "layoutInflater", "c", "Ljava/util/List;", "data", "<init>", "()V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class RadiusAdapterImpl extends RecyclerView.Adapter<RadiusViewHolder> {
    public List<SearchRadius> c = CollectionsKt__CollectionsKt.emptyList();
    public LayoutInflater d;
    public final PublishSubject<SearchRadius> e;

    public static final class a<T, R> implements Function<Integer, SearchRadius> {
        public final /* synthetic */ RadiusAdapterImpl a;

        public a(RadiusAdapterImpl radiusAdapterImpl) {
            this.a = radiusAdapterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SearchRadius apply(Integer num) {
            Integer num2 = num;
            List list = this.a.c;
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            return (SearchRadius) list.get(num2.intValue());
        }
    }

    public RadiusAdapterImpl() {
        PublishSubject<SearchRadius> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.e = create;
    }

    @NotNull
    public final Observable<SearchRadius> clicks() {
        return this.e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    public final boolean isDataEmpty() {
        return this.c.isEmpty();
    }

    public final void updateData(@NotNull List<SearchRadius> list) {
        Intrinsics.checkNotNullParameter(list, "newData");
        this.c = list;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull RadiusViewHolder radiusViewHolder, int i) {
        Intrinsics.checkNotNullParameter(radiusViewHolder, "holder");
        radiusViewHolder.bind(this.c.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RadiusViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater layoutInflater = this.d;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
            this.d = layoutInflater;
        }
        View inflate = layoutInflater.inflate(R.layout.location_picker_search_radius_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        RadiusViewHolder radiusViewHolder = new RadiusViewHolder(inflate);
        radiusViewHolder.getClicks().map(new a(this)).subscribe(this.e);
        return radiusViewHolder;
    }
}
