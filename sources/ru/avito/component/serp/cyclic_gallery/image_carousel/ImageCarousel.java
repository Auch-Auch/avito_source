package ru.avito.component.serp.cyclic_gallery.image_carousel;

import a2.g.r.g;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Video;
import com.avito.android.section.GravitySnapHelper;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.ListDataSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.PhoneLoadingState;
import ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItem;
import ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.SellerInfoParams;
import t6.n.e;
import t6.n.y;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010g\u001a\u00020f\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010h\u0012\b\b\u0002\u0010j\u001a\u00020\u0002\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bl\u0010mJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0004\b\u0011\u0010\u000eJ\u001d\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001b\u001a\u00020\u00072\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001d\u001a\u00020\u00072\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018¢\u0006\u0004\b\u001d\u0010\u001cJ\u0015\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010!J#\u0010#\u001a\u00020\u00072\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018¢\u0006\u0004\b#\u0010\u001cJ\u001b\u0010'\u001a\u00020\u00072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$¢\u0006\u0004\b'\u0010(J\u001d\u0010-\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u001f\u00103\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u0015\u00106\u001a\u00020\u00072\u0006\u0010,\u001a\u000205¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\u0007¢\u0006\u0004\b8\u00109J\u001d\u0010=\u001a\u00020\u00072\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:H\u0014¢\u0006\u0004\b=\u0010\u000eJ\u000f\u0010>\u001a\u00020\u0007H\u0004¢\u0006\u0004\b>\u00109R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0015\u0010,\u001a\u0004\u0018\u00010D8F@\u0006¢\u0006\u0006\u001a\u0004\bE\u0010FR$\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR$\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010@R\u001b\u0010a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010d¨\u0006n"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarousel;", "", "", AuthSource.SEND_ABUSE, "()Z", "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "setHeight", "(I)V", "", "Lcom/avito/android/image_loader/Picture;", "pictures", "setPictures", "(Ljava/util/List;)V", "Lcom/avito/android/remote/model/Video;", "videos", "setVideos", VKApiConst.POSITION, "smoothScroll", "setCurrentPicture", "(IZ)V", "getCurrentPosition", "()I", "Lkotlin/Function1;", "Landroidx/recyclerview/widget/RecyclerView;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnScrollChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "setPictureChangeListener", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "decoration", "addItemDecoration", "(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V", "removeItemDecoration", "setOnClickListener", "", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionData;", "actions", "setActions", "(Ljava/util/Set;)V", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionType;", "actionType", "Lru/avito/component/serp/PhoneLoadingState;", "state", "setLoadingState", "(Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionType;Lru/avito/component/serp/PhoneLoadingState;)V", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;", "sellerItem", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams$SellerInfoBlockPosition;", "blockPosition", "setSellerInfo", "(Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams$SellerInfoBlockPosition;)V", "Landroid/os/Parcelable;", "restoreState", "(Landroid/os/Parcelable;)V", "resetState", "()V", "", "Lcom/avito/konveyor/blueprint/Item;", "items", "collectData", "updateDataSource", "d", "Ljava/util/List;", "images", "c", "Ljava/util/Set;", "Landroid/os/Bundle;", "getState", "()Landroid/os/Bundle;", "i", "Lkotlin/jvm/functions/Function1;", "pictureChangedListener", "h", "onScrollChangedListener", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "k", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "f", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;", "sellerInfo", g.a, "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams$SellerInfoBlockPosition;", "sellerBlockPosition", "Landroidx/recyclerview/widget/RecyclerView;", "gallery", "Landroid/view/View;", "j", "Landroid/view/View;", "view", "e", "l", "Ljava/lang/Integer;", "getVideoPosition", "()Ljava/lang/Integer;", "videoPosition", "Landroidx/recyclerview/widget/LinearLayoutManager;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "isBigGallery", "itemGap", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;ZLjava/lang/Integer;Ljava/lang/Integer;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public class ImageCarousel {
    public final RecyclerView a;
    public final LinearLayoutManager b;
    public Set<ActionData> c;
    public List<? extends Picture> d;
    public List<Video> e;
    public CarouselSellerItem f;
    public SellerInfoParams.SellerInfoBlockPosition g;
    public Function1<? super RecyclerView, Unit> h;
    public Function1<? super Integer, Unit> i;
    public final View j;
    public final AdapterPresenter k;
    @Nullable
    public final Integer l;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function1 a;

        public a(ImageCarousel imageCarousel, Function1 function1) {
            this.a = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke(0);
        }
    }

    public ImageCarousel(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @Nullable RecyclerView.RecycledViewPool recycledViewPool, boolean z, @Nullable Integer num, @Nullable Integer num2) {
        int i2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.j = view;
        this.k = adapterPresenter;
        this.l = num2;
        Objects.requireNonNull(view, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) view;
        this.a = recyclerView;
        this.c = y.emptySet();
        this.d = CollectionsKt__CollectionsKt.emptyList();
        this.e = CollectionsKt__CollectionsKt.emptyList();
        this.g = SellerInfoParams.SellerInfoBlockPosition.NONE;
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        simpleRecyclerAdapter.setHasStableIds(true);
        recyclerView.setItemAnimator(null);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        this.b = linearLayoutManager;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(simpleRecyclerAdapter);
        if (num != null) {
            i2 = num.intValue();
        } else if (z) {
            i2 = view.getResources().getDimensionPixelSize(R.dimen.advert_details_gallery_padding);
        } else {
            i2 = view.getResources().getDimensionPixelSize(R.dimen.serp_gallery_padding);
        }
        Views.changePadding$default(recyclerView, 0, 0, recyclerView.getPaddingRight() - i2, 0, 11, null);
        recyclerView.addItemDecoration(new GalleryItemDecoration(i2));
        recyclerView.setScrollingTouchSlop(1);
        recyclerView.setRecycledViewPool(recycledViewPool);
        recyclerView.setHasFixedSize(true);
        new GravitySnapHelper(GravityCompat.START, 0, 2, null).attachToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarousel.1
            public final /* synthetic */ ImageCarousel a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView2, int i3) {
                Function1 function1;
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                if (!this.a.a() && (function1 = this.a.i) != null) {
                    function1.invoke(Integer.valueOf(this.a.b.findFirstCompletelyVisibleItemPosition()));
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int i3, int i4) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrolled(recyclerView2, i3, i4);
                Function1 function1 = this.a.h;
                if (function1 != null) {
                    function1.invoke(recyclerView2);
                }
            }
        });
    }

    public final boolean a() {
        return this.a.getScrollState() != 0;
    }

    public final void addItemDecoration(@NotNull RecyclerView.ItemDecoration itemDecoration) {
        Intrinsics.checkNotNullParameter(itemDecoration, "decoration");
        this.a.addItemDecoration(itemDecoration);
    }

    public void collectData(@NotNull List<Item> list) {
        int i2;
        Intrinsics.checkNotNullParameter(list, "items");
        if (!this.d.isEmpty() || !this.e.isEmpty()) {
            if (this.l == null) {
                i2 = this.d.size();
            } else {
                i2 = Math.min(this.d.size(), this.l.intValue());
            }
            List<? extends Picture> list2 = this.d;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
            for (T t : list2) {
                arrayList.add(new ImageCarouselItem(t.toString(), t, null, 4, null));
            }
            list.addAll(arrayList);
            List<Video> list3 = this.e;
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list3, 10));
            for (T t2 : list3) {
                arrayList2.add(new ImageCarouselItem(t2.toString(), AvitoPictureKt.pictureOf$default(t2.getPreviewImage(), false, 0.0f, 0.0f, null, 28, null), t2.getVideoUrl()));
            }
            list.addAll(i2, arrayList2);
        } else {
            list.add(new ImageCarouselItem("empty_image_id", null, null, 4, null));
        }
        int size = list.size() - 1;
        Set<ActionData> set = this.c;
        ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(set, 10));
        for (T t3 : set) {
            arrayList3.add(new CarouselActionItem(t3.toString(), t3));
        }
        list.addAll(arrayList3);
        Item item = this.f;
        if (item != null) {
            SellerInfoParams.SellerInfoBlockPosition sellerInfoBlockPosition = this.g;
            if (sellerInfoBlockPosition == SellerInfoParams.SellerInfoBlockPosition.BEFORE_ACTIONS) {
                list.add(size + 1, item);
            } else if (sellerInfoBlockPosition == SellerInfoParams.SellerInfoBlockPosition.AFTER_ACTIONS) {
                list.add(item);
            }
        }
    }

    public final int getCurrentPosition() {
        return this.b.findFirstCompletelyVisibleItemPosition();
    }

    @Nullable
    public final Bundle getState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_scroll_state", this.b.onSaveInstanceState());
        return bundle;
    }

    @Nullable
    public final Integer getVideoPosition() {
        return this.l;
    }

    public final void removeItemDecoration(@NotNull RecyclerView.ItemDecoration itemDecoration) {
        Intrinsics.checkNotNullParameter(itemDecoration, "decoration");
        this.a.removeItemDecoration(itemDecoration);
    }

    public final void resetState() {
        if (!a()) {
            this.b.scrollToPosition(0);
        }
    }

    public final void restoreState(@NotNull Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "state");
        if (!a() && (parcelable instanceof Bundle)) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(getClass().getClassLoader());
            this.b.onRestoreInstanceState(bundle.getParcelable("key_scroll_state"));
        }
    }

    public final void setActions(@NotNull Set<ActionData> set) {
        Intrinsics.checkNotNullParameter(set, "actions");
        if (!Intrinsics.areEqual(this.c, set)) {
            this.c = set;
            updateDataSource();
        }
    }

    public final void setCurrentPicture(int i2, boolean z) {
        if (z) {
            this.a.smoothScrollToPosition(i2);
        } else {
            this.a.scrollToPosition(i2);
        }
    }

    public final void setHeight(int i2) {
        this.j.getLayoutParams().height = i2;
    }

    public final void setLoadingState(@NotNull ActionType actionType, @NotNull PhoneLoadingState phoneLoadingState) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(phoneLoadingState, "state");
        Iterator<T> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.getActionType() == actionType) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null && t2.getLoadingState() != phoneLoadingState) {
            t2.setLoadingState(phoneLoadingState);
            updateDataSource();
        }
    }

    public final void setOnClickListener(@Nullable Function1<? super Integer, Unit> function1) {
        if (function1 != null) {
            this.a.setOnClickListener(new a(this, function1));
        } else {
            this.j.setOnClickListener(null);
        }
    }

    public final void setOnScrollChangedListener(@Nullable Function1<? super RecyclerView, Unit> function1) {
        this.h = function1;
    }

    public final void setPictureChangeListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.i = function1;
    }

    public final void setPictures(@NotNull List<? extends Picture> list) {
        Intrinsics.checkNotNullParameter(list, "pictures");
        if ((!Intrinsics.areEqual(this.d, list)) || this.k.isEmpty()) {
            this.d = list;
            updateDataSource();
        }
    }

    public final void setSellerInfo(@Nullable CarouselSellerItem carouselSellerItem, @NotNull SellerInfoParams.SellerInfoBlockPosition sellerInfoBlockPosition) {
        Intrinsics.checkNotNullParameter(sellerInfoBlockPosition, "blockPosition");
        if (!Intrinsics.areEqual(this.f, carouselSellerItem)) {
            this.f = carouselSellerItem;
            this.g = sellerInfoBlockPosition;
            updateDataSource();
        }
    }

    public final void setVideos(@NotNull List<Video> list) {
        Intrinsics.checkNotNullParameter(list, "videos");
        if (!Intrinsics.areEqual(this.e, list)) {
            this.e = list;
            updateDataSource();
        }
    }

    public final void updateDataSource() {
        ArrayList arrayList = new ArrayList();
        collectData(arrayList);
        AdapterPresenter adapterPresenter = this.k;
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (hashSet.add(Long.valueOf(((Item) obj).getId()))) {
                arrayList2.add(obj);
            }
        }
        adapterPresenter.onDataSourceChanged(new ListDataSource(arrayList2));
        RecyclerView.Adapter adapter = this.a.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageCarousel(View view, AdapterPresenter adapterPresenter, ItemBinder itemBinder, RecyclerView.RecycledViewPool recycledViewPool, boolean z, Integer num, Integer num2, int i2, j jVar) {
        this(view, adapterPresenter, itemBinder, (i2 & 8) != 0 ? null : recycledViewPool, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? null : num, (i2 & 64) != 0 ? null : num2);
    }
}
