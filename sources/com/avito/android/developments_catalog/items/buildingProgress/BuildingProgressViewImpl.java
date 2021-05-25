package com.avito.android.developments_catalog.items.buildingProgress;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.design.widget.tab.CommonTab;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.developments_catalog.R;
import com.avito.android.developments_catalog.items.buildingProgress.BuildingProgressView;
import com.avito.android.developments_catalog.items.buildingProgress.image_list.PhotoBlueprint;
import com.avito.android.developments_catalog.items.buildingProgress.image_list.PhotoClickListener;
import com.avito.android.developments_catalog.items.buildingProgress.image_list.PhotoItem;
import com.avito.android.developments_catalog.items.buildingProgress.image_list.PhotoPresenter;
import com.avito.android.remote.model.BuildingProgress;
import com.avito.android.remote.model.BuildingProgressStage;
import com.avito.android.remote.model.Image;
import com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.TabLayoutsKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.tabs.TabLayout;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010,\u001a\u00020'¢\u0006\u0004\b7\u00108J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000e\u001a\u00020\u00062\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u00060\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010%R\u0019\u0010,\u001a\u00020'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00104\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R.\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u00060\t8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/avito/android/developments_catalog/items/buildingProgress/BuildingProgressViewImpl;", "Lcom/avito/android/developments_catalog/items/buildingProgress/BuildingProgressView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/developments_catalog/items/buildingProgress/image_list/PhotoClickListener;", "Lcom/avito/android/remote/model/BuildingProgress;", "progress", "", "setData", "(Lcom/avito/android/remote/model/BuildingProgress;)V", "Lkotlin/Function2;", "", "", "Lcom/avito/android/remote/model/Image;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setBuildingProgressImageClickListener", "(Lkotlin/jvm/functions/Function2;)V", VKApiConst.POSITION, "onPhotoClick", "(I)V", "t", "()V", "w", "I", "currentTabPosition", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "z", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroid/content/Context;", "s", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView;", VKApiConst.VERSION, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Lcom/google/android/material/tabs/TabLayout;", "u", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Lcom/avito/android/remote/model/BuildingProgressStage;", "x", "Ljava/util/List;", "stages", "y", "Lkotlin/jvm/functions/Function2;", "<init>", "(Landroid/view/View;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class BuildingProgressViewImpl extends BaseViewHolder implements BuildingProgressView, PhotoClickListener {
    @NotNull
    public final View A;
    public final Context s;
    public final TextView t;
    public final TabLayout u;
    public final RecyclerView v;
    public int w;
    public List<BuildingProgressStage> x;
    public Function2<? super Integer, ? super List<Image>, Unit> y;
    public AdapterPresenter z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BuildingProgressViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.A = view;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.s = context;
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
        this.t = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tabs);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.tabs)");
        this.u = (TabLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.image_list);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.image_list)");
        this.v = (RecyclerView) findViewById3;
    }

    @NotNull
    public final View getView() {
        return this.A;
    }

    @Override // com.avito.android.developments_catalog.items.buildingProgress.image_list.PhotoClickListener
    public void onPhotoClick(int i) {
        BuildingProgressStage buildingProgressStage;
        List<BuildingProgressStage> list = this.x;
        List<Image> images = (list == null || (buildingProgressStage = list.get(this.w)) == null) ? null : buildingProgressStage.getImages();
        if (images != null && (!images.isEmpty())) {
            Function2<? super Integer, ? super List<Image>, Unit> function2 = this.y;
            if (function2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            }
            function2.invoke(Integer.valueOf(i), images);
        }
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        BuildingProgressView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.developments_catalog.items.buildingProgress.BuildingProgressView
    public void setBuildingProgressImageClickListener(@NotNull Function2<? super Integer, ? super List<Image>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.y = function2;
    }

    @Override // com.avito.android.developments_catalog.items.buildingProgress.BuildingProgressView
    public void setData(@NotNull BuildingProgress buildingProgress) {
        Intrinsics.checkNotNullParameter(buildingProgress, "progress");
        this.t.setText(buildingProgress.getTitle());
        this.x = buildingProgress.getStages();
        this.v.setLayoutManager(new LinearLayoutManager(this.s, 0, false));
        ItemBinder build = new ItemBinder.Builder().registerItem(new PhotoBlueprint(new PhotoPresenter(this))).build();
        SimpleAdapterPresenter simpleAdapterPresenter = new SimpleAdapterPresenter(build, build);
        this.z = simpleAdapterPresenter;
        this.v.setAdapter(new SimpleRecyclerAdapter(simpleAdapterPresenter, build));
        List<BuildingProgressStage> list = this.x;
        ArrayList arrayList = null;
        if (list != null) {
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(new CommonTab(it.next().getTitle(), null, 2, null));
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            TabsDataProvider tabsDataProvider = new TabsDataProvider();
            tabsDataProvider.onDataSourceChanged(new ListDataSource(arrayList));
            TabLayoutsKt.setAdapter(this.u, new TabLayoutAdapter(tabsDataProvider, this.s, 0, 4, null));
        }
        this.u.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new SimpleOnTabSelectedListener() { // from class: com.avito.android.developments_catalog.items.buildingProgress.BuildingProgressViewImpl$initTabs$2
            @Override // com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(@NotNull TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                BuildingProgressViewImpl.this.w = tab.getPosition();
                BuildingProgressViewImpl.this.t();
            }
        });
        t();
    }

    public final void t() {
        BuildingProgressStage buildingProgressStage;
        List<Image> images;
        List<BuildingProgressStage> list = this.x;
        if (!(list == null || (buildingProgressStage = list.get(this.w)) == null || (images = buildingProgressStage.getImages()) == null)) {
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(images, 10));
            int i = 0;
            for (T t2 : images) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new PhotoItem((long) i, t2));
                i = i2;
            }
            ListDataSource listDataSource = new ListDataSource(arrayList);
            AdapterPresenter adapterPresenter = this.z;
            if (adapterPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
            }
            adapterPresenter.onDataSourceChanged(listDataSource);
            RecyclerView.Adapter adapter = this.v.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }
}
