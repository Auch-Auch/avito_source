package com.avito.android.advert.item.description;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.advert.DescriptionListener;
import com.avito.android.advert_core.advert.ExpandablePanelLayout;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionView;", "Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionItem;", "item", "Lcom/avito/android/advert_core/advert/DescriptionListener;", "expandListener", "", "showDescription", "(Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionItem;Lcom/avito/android/advert_core/advert/DescriptionListener;)V", "applyClosedAdvert", "()V", "Landroid/os/Parcelable;", "onSaveState", "()Landroid/os/Parcelable;", "Lcom/avito/android/advert_core/advert/ExpandablePanelLayout;", "s", "Lcom/avito/android/advert_core/advert/ExpandablePanelLayout;", "getDescriptionPanel", "()Lcom/avito/android/advert_core/advert/ExpandablePanelLayout;", "descriptionPanel", "", "t", "I", "closedAdvertColor", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsDescriptionViewImpl extends BaseViewHolder implements AdvertDetailsDescriptionView {
    @NotNull
    public final ExpandablePanelLayout s;
    public final int t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsDescriptionViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.description_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(advert…re_R.id.description_root)");
        this.s = (ExpandablePanelLayout) findViewById;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.t = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray48);
    }

    @Override // com.avito.android.advert.item.description.AdvertDetailsDescriptionView
    public void applyClosedAdvert() {
        this.s.setTextColor(this.t);
        this.s.expand(false);
    }

    @NotNull
    public final ExpandablePanelLayout getDescriptionPanel() {
        return this.s;
    }

    @Override // com.avito.android.advert.item.description.AdvertDetailsDescriptionView
    @Nullable
    public Parcelable onSaveState() {
        return this.s.onSaveState();
    }

    @Override // com.avito.android.advert.item.description.AdvertDetailsDescriptionView
    public void showDescription(@Nullable AdvertDetailsDescriptionItem advertDetailsDescriptionItem, @Nullable DescriptionListener descriptionListener) {
        Parcelable expandPanelState;
        if (!(advertDetailsDescriptionItem == null || (expandPanelState = advertDetailsDescriptionItem.getExpandPanelState()) == null)) {
            this.s.onRestoreState(expandPanelState);
        }
        this.s.setCollapsedLineCount(advertDetailsDescriptionItem != null ? Integer.valueOf(advertDetailsDescriptionItem.getCollapsedLinesCount()) : null);
        this.s.setOnExpandListener(new ExpandablePanelLayout.ExpandLayoutListener(this, descriptionListener, advertDetailsDescriptionItem) { // from class: com.avito.android.advert.item.description.AdvertDetailsDescriptionViewImpl$showDescription$2
            public final /* synthetic */ AdvertDetailsDescriptionViewImpl a;
            public final /* synthetic */ DescriptionListener b;
            public final /* synthetic */ AdvertDetailsDescriptionItem c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // com.avito.android.advert_core.advert.ExpandablePanelLayout.ExpandLayoutListener
            public void onCollapse(@Nullable View view, @NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, "content");
            }

            @Override // com.avito.android.advert_core.advert.ExpandablePanelLayout.ExpandLayoutListener
            public void onCopyText() {
                DescriptionListener descriptionListener2 = this.b;
                if (descriptionListener2 != null) {
                    descriptionListener2.onDescriptionCopy();
                }
            }

            @Override // com.avito.android.advert_core.advert.ExpandablePanelLayout.ExpandLayoutListener
            public void onExpand(@Nullable View view, @NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, "content");
                if (view != null) {
                    view.setVisibility(8);
                }
                DescriptionListener descriptionListener2 = this.b;
                if (descriptionListener2 != null) {
                    AdvertDetailsDescriptionItem advertDetailsDescriptionItem2 = this.c;
                    descriptionListener2.onDescriptionExpanded(advertDetailsDescriptionItem2 != null ? advertDetailsDescriptionItem2.getCategoryName() : null);
                }
                Views.changePadding(this.a.getDescriptionPanel(), this.a.getDescriptionPanel().getPaddingLeft(), this.a.getDescriptionPanel().getPaddingTop(), this.a.getDescriptionPanel().getPaddingRight(), Views.dpToPx(this.a.getDescriptionPanel(), 3) + this.a.getDescriptionPanel().getPaddingBottom());
                this.a.getDescriptionPanel().invalidate();
            }

            @Override // com.avito.android.advert_core.advert.ExpandablePanelLayout.ExpandLayoutListener
            public void onExpandExist() {
                DescriptionListener descriptionListener2 = this.b;
                if (descriptionListener2 != null) {
                    descriptionListener2.onDescriptionExpandExist();
                }
            }
        });
        if (advertDetailsDescriptionItem != null && advertDetailsDescriptionItem.getShowDivider()) {
            this.s.showDivider();
        }
        ExpandablePanelLayout.setText$default(this.s, advertDetailsDescriptionItem != null ? advertDetailsDescriptionItem.getDescription() : null, false, 2, null);
    }
}
