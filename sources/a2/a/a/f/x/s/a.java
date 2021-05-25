package a2.a.a.f.x.s;

import android.view.View;
import com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserViewImpl;
import com.avito.android.advert_details.R;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends AdvertDetailsDomotekaTeaserViewImpl {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(@NotNull View view) {
        super(view, null);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserViewImpl, com.avito.android.advert.item.teaser.AdvertDetailsTeaserViewImpl
    public int getInsightLayoutId() {
        return R.layout.advert_details_cre_geo_report_teaser_insight;
    }
}
