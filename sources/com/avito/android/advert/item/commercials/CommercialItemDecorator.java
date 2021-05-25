package com.avito.android.advert.item.commercials;

import a2.g.r.g;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.component.ads.adfox.AdfoxImageViewHolder;
import com.avito.android.component.ads.mytarget.AdMyTargetAppInstallViewHolder;
import com.avito.android.component.ads.mytarget.AdMyTargetContentViewHolder;
import com.avito.android.component.ads.yandex.AdYandexAppInstall;
import com.avito.android.component.ads.yandex.AdYandexContent;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallItemViewImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentItemViewImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedItemViewImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubItemView;
import com.avito.android.ui_components.R;
import com.avito.android.util.DeviceMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u000fR\u0016\u0010\u001d\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u000fR\u0016\u0010\u001f\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u000f¨\u0006&"}, d2 = {"Lcom/avito/android/advert/item/commercials/CommercialItemDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "f", "I", "advertColumns", "h", "Ljava/lang/Integer;", "bottomCommercialPosition", "d", "bottomYandexCommercialMargin", AuthSource.SEND_ABUSE, "itemSpacing", g.a, "topCommercialPosition", AuthSource.BOOKING_ORDER, "sideOffset", "c", "topYandexCommercialMargin", "e", "screenWidth", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "<init>", "(ILjava/lang/Integer;Ljava/lang/Integer;Landroid/content/res/Resources;Lcom/avito/android/util/DeviceMetrics;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class CommercialItemDecorator extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final Integer g;
    public final Integer h;

    public CommercialItemDecorator(int i, @Nullable Integer num, @Nullable Integer num2, @NotNull Resources resources, @NotNull DeviceMetrics deviceMetrics) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        this.f = i;
        this.g = num;
        this.h = num2;
        this.a = resources.getDimensionPixelSize(R.dimen.rds_column_offset);
        this.b = resources.getDimensionPixelSize(R.dimen.content_horizontal_padding);
        this.c = resources.getDimensionPixelSize(R.dimen.rds_yandex_commercial_margin_top);
        this.d = resources.getDimensionPixelSize(R.dimen.rds_grid_row_offset) / 2;
        this.e = deviceMetrics.getDisplayWidth();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        if ((childViewHolder instanceof AdYandexContent) || (childViewHolder instanceof AdYandexAppInstall) || (childViewHolder instanceof NotLoadAdStubItemView) || (childViewHolder instanceof AdfoxImageViewHolder) || (childViewHolder instanceof AdMyTargetContentViewHolder) || (childViewHolder instanceof AdMyTargetAppInstallViewHolder) || (childViewHolder instanceof DfpContentItemViewImpl) || (childViewHolder instanceof DfpAppInstallItemViewImpl) || (childViewHolder instanceof DfpUnifiedItemViewImpl)) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            Integer num = this.g;
            if (num != null && childAdapterPosition == num.intValue()) {
                i = this.c;
            } else {
                Integer num2 = this.h;
                i = (num2 != null && childAdapterPosition == num2.intValue()) ? this.d : 0;
            }
            int i2 = this.b;
            rect.left = i2;
            int i3 = this.e;
            int i4 = this.f;
            float f2 = (float) i4;
            int i5 = i3 - (i2 * 2);
            int i6 = this.a;
            rect.right = (int) (((((float) (i3 * 2)) / f2) - ((float) i2)) - (((((float) (i5 - ((i4 - 1) * i6))) / f2) * ((float) 2)) + ((float) i6)));
            rect.top = i;
            rect.bottom = 0;
        }
    }
}
