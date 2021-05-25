package com.avito.android.advert_core.feature_teasers.common.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider;
import com.avito.android.advert_core.feature_teasers.common.di.AdvertDetailsFeatureTeaser;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogInfo;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B-\b\u0007\u0012\b\b\u0001\u0010\u001a\u001a\u00020\u0017\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/dialog/CommonFeatureTeaserDialogFactory;", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/FeatureTeaserDialogFactory;", "", "getDialogLayout", "()I", "Landroid/content/Context;", "context", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;", "dialogInfo", "Landroid/app/Dialog;", "create", "(Landroid/content/Context;Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;)Landroid/app/Dialog;", "", "isApplyButtonVisible", "(Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;)Z", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", "setUpDialog", "(Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;)Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogItemsAdapter;", "d", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogItemsAdapter;", "dialogItemsAdapter", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "c", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/konveyor/ItemBinder;Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogItemsAdapter;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public class CommonFeatureTeaserDialogFactory implements FeatureTeaserDialogFactory {
    public final ItemBinder a;
    public final SimpleAdapterPresenter b;
    public final FeatureTeaserResourceProvider c;
    public final AdvertDetailsFeatureTeaserDialogItemsAdapter d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BottomSheetDialog a;

        public a(BottomSheetDialog bottomSheetDialog, AdvertDetailsFeatureTeaserDialogInfo advertDetailsFeatureTeaserDialogInfo) {
            this.a = bottomSheetDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.cancel();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ BottomSheetDialog a;

        public b(BottomSheetDialog bottomSheetDialog, CommonFeatureTeaserDialogFactory commonFeatureTeaserDialogFactory, BottomSheetDialog bottomSheetDialog2, AdvertDetailsFeatureTeaserDialogInfo advertDetailsFeatureTeaserDialogInfo) {
            this.a = bottomSheetDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.cancel();
        }
    }

    @Inject
    public CommonFeatureTeaserDialogFactory(@AdvertDetailsFeatureTeaser @NotNull ItemBinder itemBinder, @AdvertDetailsFeatureTeaser @NotNull SimpleAdapterPresenter simpleAdapterPresenter, @NotNull FeatureTeaserResourceProvider featureTeaserResourceProvider, @NotNull AdvertDetailsFeatureTeaserDialogItemsAdapter advertDetailsFeatureTeaserDialogItemsAdapter) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(simpleAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(featureTeaserResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserDialogItemsAdapter, "dialogItemsAdapter");
        this.a = itemBinder;
        this.b = simpleAdapterPresenter;
        this.c = featureTeaserResourceProvider;
        this.d = advertDetailsFeatureTeaserDialogItemsAdapter;
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.dialog.FeatureTeaserDialogFactory
    @NotNull
    public Dialog create(@NotNull Context context, @NotNull AdvertDetailsFeatureTeaserDialogInfo advertDetailsFeatureTeaserDialogInfo) {
        List<Item> list;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserDialogInfo, "dialogInfo");
        BottomSheetDialog upDialog = setUpDialog(new BottomSheetDialog(context, 0, 2, null), advertDetailsFeatureTeaserDialogInfo);
        if (advertDetailsFeatureTeaserDialogInfo instanceof AdvertDetailsFeatureTeaserDialogInfo.CheckedByAvito) {
            View findViewById = upDialog.findViewById(R.id.apply_btn);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
            Button button = (Button) findViewById;
            button.setOnClickListener(new a(upDialog, advertDetailsFeatureTeaserDialogInfo));
            AdvertDetailsFeatureTeaserDialogInfo.CheckedByAvito checkedByAvito = (AdvertDetailsFeatureTeaserDialogInfo.CheckedByAvito) advertDetailsFeatureTeaserDialogInfo;
            button.setText(checkedByAvito.getBtnText());
            list = this.d.createCheckedByAvitoItems(checkedByAvito);
        } else if (advertDetailsFeatureTeaserDialogInfo instanceof AdvertDetailsFeatureTeaserDialogInfo.FeaturesList) {
            View findViewById2 = upDialog.findViewById(R.id.advert_details_features_dialog_title);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
            AdvertDetailsFeatureTeaserDialogInfo.FeaturesList featuresList = (AdvertDetailsFeatureTeaserDialogInfo.FeaturesList) advertDetailsFeatureTeaserDialogInfo;
            ((TextView) findViewById2).setText(featuresList.getTitle());
            list = this.d.createFeatureListItems(featuresList);
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        this.b.onDataSourceChanged(new ListDataSource(list));
        return upDialog;
    }

    public int getDialogLayout() {
        return R.layout.advert_details_feature_teaser_dialog;
    }

    public boolean isApplyButtonVisible(@NotNull AdvertDetailsFeatureTeaserDialogInfo advertDetailsFeatureTeaserDialogInfo) {
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserDialogInfo, "dialogInfo");
        return advertDetailsFeatureTeaserDialogInfo instanceof AdvertDetailsFeatureTeaserDialogInfo.CheckedByAvito;
    }

    @NotNull
    public final BottomSheetDialog setUpDialog(@NotNull BottomSheetDialog bottomSheetDialog, @NotNull AdvertDetailsFeatureTeaserDialogInfo advertDetailsFeatureTeaserDialogInfo) {
        Intrinsics.checkNotNullParameter(bottomSheetDialog, "dialog");
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserDialogInfo, "dialogInfo");
        bottomSheetDialog.setContentView(getDialogLayout(), true);
        bottomSheetDialog.setFitContentPeekHeight(true);
        View findViewById = bottomSheetDialog.findViewById(R.id.recycler);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new SimpleRecyclerAdapter(this.b, this.a));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(linearLayoutManager, this, bottomSheetDialog, advertDetailsFeatureTeaserDialogInfo) { // from class: com.avito.android.advert_core.feature_teasers.common.dialog.CommonFeatureTeaserDialogFactory$setUpDialog$$inlined$with$lambda$1
            public final View a;
            public final /* synthetic */ LinearLayoutManager b;
            public final /* synthetic */ BottomSheetDialog c;

            {
                this.b = r1;
                this.c = r3;
                View findViewById2 = r3.findViewById(R.id.advert_details_features_dialog_header_background);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
                this.a = findViewById2;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrolled(recyclerView2, i, i2);
                if (this.b.findFirstVisibleItemPosition() > 0) {
                    this.a.setAlpha(1.0f);
                    return;
                }
                View childAt = recyclerView2.getChildAt(0);
                Intrinsics.checkNotNullExpressionValue(childAt, "firstView");
                this.a.setAlpha(((float) (childAt.getHeight() - childAt.getBottom())) / ((float) childAt.getHeight()));
            }
        });
        View findViewById2 = bottomSheetDialog.findViewById(R.id.advert_details_features_dialog_close_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
        findViewById2.setOnClickListener(new b(bottomSheetDialog, this, bottomSheetDialog, advertDetailsFeatureTeaserDialogInfo));
        Views.setVisible(findViewById2, true ^ (advertDetailsFeatureTeaserDialogInfo instanceof AdvertDetailsFeatureTeaserDialogInfo.CheckedByAvito));
        View findViewById3 = bottomSheetDialog.findViewById(R.id.apply_btn_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(id)");
        Views.setVisible(findViewById3, isApplyButtonVisible(advertDetailsFeatureTeaserDialogInfo));
        if (this.c.isTablet()) {
            View findViewById4 = bottomSheetDialog.findViewById(R.id.advert_details_features_dialog__thumb);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(id)");
            Views.setVisible(findViewById4, false);
        }
        return bottomSheetDialog;
    }
}
