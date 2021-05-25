package com.avito.android.spare_parts.bottom_sheet;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.models.SparePartsResponse;
import com.avito.android.spare_parts.SparePartsFormatter;
import com.avito.android.spare_parts.SparePartsItemClickListener;
import com.avito.android.spare_parts.SparePartsResourceProvider;
import com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetPresenter;
import com.avito.android.spare_parts.bottom_sheet.item.SparePartsTextItem;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010(\u001a\u00020 \u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenterImpl;", "Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenter;", "Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetView;", "view", "", "attachView", "(Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetView;)V", "popGroupsStack", "()V", "Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenter$Router;)V", "detachView", "detachRouter", "", "shouldAnimate", "reversed", AuthSource.SEND_ABUSE, "(ZZ)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "d", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapter", "Lcom/avito/android/spare_parts/SparePartsFormatter;", "e", "Lcom/avito/android/spare_parts/SparePartsFormatter;", "formatter", AuthSource.BOOKING_ORDER, "Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenter$Router;", "Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetView;", "Lkotlin/collections/ArrayDeque;", "Lcom/avito/android/remote/models/SparePartsResponse$SparePartsGroup;", "c", "Lkotlin/collections/ArrayDeque;", "groups", "Lcom/avito/android/spare_parts/SparePartsResourceProvider;", "f", "Lcom/avito/android/spare_parts/SparePartsResourceProvider;", "resourceProvider", "rootGroup", "<init>", "(Lcom/avito/android/remote/models/SparePartsResponse$SparePartsGroup;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/spare_parts/SparePartsFormatter;Lcom/avito/android/spare_parts/SparePartsResourceProvider;)V", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
public final class SparePartsBottomSheetPresenterImpl implements SparePartsBottomSheetPresenter {
    public SparePartsBottomSheetView a;
    public SparePartsBottomSheetPresenter.Router b;
    public ArrayDeque<SparePartsResponse.SparePartsGroup> c;
    public final AdapterPresenter d;
    public final SparePartsFormatter e;
    public final SparePartsResourceProvider f;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SparePartsBottomSheetPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SparePartsBottomSheetPresenterImpl sparePartsBottomSheetPresenterImpl) {
            super(0);
            this.a = sparePartsBottomSheetPresenterImpl;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.popGroupsStack();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public SparePartsBottomSheetPresenterImpl(@NotNull SparePartsResponse.SparePartsGroup sparePartsGroup, @NotNull AdapterPresenter adapterPresenter, @NotNull SparePartsFormatter sparePartsFormatter, @NotNull SparePartsResourceProvider sparePartsResourceProvider) {
        Intrinsics.checkNotNullParameter(sparePartsGroup, "rootGroup");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapter");
        Intrinsics.checkNotNullParameter(sparePartsFormatter, "formatter");
        Intrinsics.checkNotNullParameter(sparePartsResourceProvider, "resourceProvider");
        this.d = adapterPresenter;
        this.e = sparePartsFormatter;
        this.f = sparePartsResourceProvider;
        ArrayDeque<SparePartsResponse.SparePartsGroup> arrayDeque = new ArrayDeque<>();
        this.c = arrayDeque;
        arrayDeque.add(sparePartsGroup);
    }

    public final void a(boolean z, boolean z2) {
        int i;
        List list;
        SparePartsBottomSheetView sparePartsBottomSheetView = this.a;
        if (sparePartsBottomSheetView != null) {
            SparePartsResponse.SparePartsGroup last = this.c.last();
            boolean z3 = true;
            if (this.c.size() > 1) {
                i = this.f.getBottomSheetBackButtonResId();
            } else {
                i = this.f.getBottomSheetCloseButtonResId();
            }
            sparePartsBottomSheetView.setDialogHeaderParams(last.getGroupTitle(), i, new a(this));
            SparePartsBottomSheetPresenterImpl$updateView$itemClickListener$1 sparePartsBottomSheetPresenterImpl$updateView$itemClickListener$1 = new SparePartsItemClickListener(this) { // from class: com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetPresenterImpl$updateView$itemClickListener$1
                public final /* synthetic */ SparePartsBottomSheetPresenterImpl a;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.a = r1;
                }

                @Override // com.avito.android.spare_parts.SparePartsItemClickListener
                public void onItemClicked(@NotNull SparePartsResponse.SparePartsGroup sparePartsGroup) {
                    Intrinsics.checkNotNullParameter(sparePartsGroup, Navigation.GROUP);
                    SparePartsBottomSheetPresenterImpl.access$getGroups$p(this.a).add(sparePartsGroup);
                    this.a.a(true, false);
                }
            };
            List<SparePartsResponse.SparePartsGroup> groups = last.getGroups();
            if (groups == null || groups.isEmpty()) {
                z3 = false;
            }
            List<CharSequence> format = this.e.format(sparePartsBottomSheetView.getContext(), last.getGroups(), last.getSpecifications(), sparePartsBottomSheetPresenterImpl$updateView$itemClickListener$1);
            if (format != null) {
                list = new ArrayList(e.collectionSizeOrDefault(format, 10));
                Iterator<T> it = format.iterator();
                while (it.hasNext()) {
                    list.add(new SparePartsTextItem(null, it.next(), z3, 1, null));
                }
            } else {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            this.d.onDataSourceChanged(new ListDataSource(list));
            sparePartsBottomSheetView.onDataChanged(z, z2);
        }
    }

    @Override // com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetPresenter
    public void attachRouter(@NotNull SparePartsBottomSheetPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetPresenter
    public void attachView(@NotNull SparePartsBottomSheetView sparePartsBottomSheetView) {
        Intrinsics.checkNotNullParameter(sparePartsBottomSheetView, "view");
        this.a = sparePartsBottomSheetView;
        a(false, false);
    }

    @Override // com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetPresenter
    public void detachView() {
        SparePartsBottomSheetView sparePartsBottomSheetView = this.a;
        if (sparePartsBottomSheetView != null) {
            sparePartsBottomSheetView.onDetach();
        }
        this.a = null;
    }

    @Override // com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetPresenter
    public void popGroupsStack() {
        this.c.removeLast();
        if (this.c.isEmpty()) {
            SparePartsBottomSheetPresenter.Router router = this.b;
            if (router != null) {
                router.finish();
                return;
            }
            return;
        }
        a(true, true);
    }
}
