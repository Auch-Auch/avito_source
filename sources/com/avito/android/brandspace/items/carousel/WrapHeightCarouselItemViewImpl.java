package com.avito.android.brandspace.items.carousel;

import a2.a.a.w.b.a.a;
import a2.a.a.w.b.a.b;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.brandspace.R;
import com.avito.android.brandspace.items.carousel.CarouselItemView;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.RecyclerWrapHeightCalculator;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b'\u0010(J5\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/avito/android/brandspace/items/carousel/WrapHeightCarouselItemViewImpl;", "Lcom/avito/android/brandspace/items/carousel/CarouselItemViewImpl;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "items", "", VKApiConst.POSITION, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Lcom/avito/android/brandspace/items/carousel/CarouselItemView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "bind", "(Ljava/util/List;IILcom/avito/android/brandspace/items/carousel/CarouselItemView$Listener;)V", "onUnbind", "()V", "Lio/reactivex/rxjava3/disposables/Disposable;", "B", "Lio/reactivex/rxjava3/disposables/Disposable;", "requestHeightByHighestItem", "C", "Lcom/avito/android/brandspace/items/carousel/CarouselItemView$Listener;", "Landroidx/recyclerview/widget/RecyclerView;", "z", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/brandspace/presenter/RecyclerWrapHeightCalculator;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/brandspace/presenter/RecyclerWrapHeightCalculator;", "recyclerWrapHeightCalculator", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroid/view/View;", "view", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "viewHolderProvider", "", "hasSnapHelper", "itemFixedWidth", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Landroid/view/View;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;ZLjava/lang/Integer;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class WrapHeightCarouselItemViewImpl extends CarouselItemViewImpl {
    public RecyclerWrapHeightCalculator A;
    public Disposable B;
    public CarouselItemView.Listener C;
    public final RecyclerView z;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WrapHeightCarouselItemViewImpl(AdapterPresenter adapterPresenter, View view, ViewHolderBuilder viewHolderBuilder, boolean z2, Integer num, int i, j jVar) {
        this(adapterPresenter, view, viewHolderBuilder, z2, (i & 16) != 0 ? null : num);
    }

    @Override // com.avito.android.brandspace.items.carousel.CarouselItemViewImpl, com.avito.android.brandspace.items.carousel.CarouselItemView
    public void bind(@NotNull List<? extends BrandspaceItem> list, int i, int i2, @NotNull CarouselItemView.Listener listener) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
        Integer valueOf = Integer.valueOf(i2);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        layoutParams.height = valueOf != null ? valueOf.intValue() : -2;
        super.bind(list, i, i2, listener);
        this.C = listener;
        if (i2 <= 0) {
            this.B = this.A.requestHeightByHighestItemAsync(this.z).subscribe(new a(this), b.a);
        }
    }

    @Override // com.avito.android.brandspace.items.carousel.CarouselItemViewImpl, com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        super.onUnbind();
        Disposable disposable = this.B;
        if (disposable != null) {
            disposable.dispose();
        }
        this.B = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WrapHeightCarouselItemViewImpl(@NotNull AdapterPresenter adapterPresenter, @NotNull View view, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, boolean z2, @Nullable Integer num) {
        super(adapterPresenter, view, viewHolderBuilder, 0, z2, num, 8, null);
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderProvider");
        View findViewById = view.findViewById(R.id.recycler);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.z = (RecyclerView) findViewById;
        this.A = new RecyclerWrapHeightCalculator();
    }
}
