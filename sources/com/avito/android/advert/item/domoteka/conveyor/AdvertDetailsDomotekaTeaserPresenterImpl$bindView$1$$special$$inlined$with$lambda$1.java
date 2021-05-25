package com.avito.android.advert.item.domoteka.conveyor;

import com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenter;
import com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenterImpl;
import com.avito.android.advert.item.teaser.AdvertDetailsTeaserView;
import com.avito.android.remote.DomotekaTeaserType;
import com.avito.android.remote.model.teaser.ReportLink;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenterImpl$bindView$1$1$3", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "", "onClickGetReport", "()V", "onClickDialogButton", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsDomotekaTeaserPresenterImpl$bindView$1$$special$$inlined$with$lambda$1 implements AdvertDetailsTeaserView.Listener {
    public final /* synthetic */ AdvertDetailsDomotekaTeaserPresenterImpl.a a;
    public final /* synthetic */ List b;
    public final /* synthetic */ ReportLink c;
    public final /* synthetic */ DomotekaTeaserType d;

    public AdvertDetailsDomotekaTeaserPresenterImpl$bindView$1$$special$$inlined$with$lambda$1(AdvertDetailsDomotekaTeaserPresenterImpl.a aVar, String str, String str2, List list, ReportLink reportLink, DomotekaTeaserType domotekaTeaserType) {
        this.a = aVar;
        this.b = list;
        this.c = reportLink;
        this.d = domotekaTeaserType;
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView.Listener
    public void onClickDialogButton() {
        this.a.a.f.sendDomotekaFlatNumberRequestClick();
        AdvertDetailsDomotekaTeaserPresenterImpl.a aVar = this.a;
        AdvertDetailsDomotekaTeaserPresenterImpl.access$requestFlatNumber(aVar.a, aVar.c.getAdvertId());
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView.Listener
    public void onClickGetReport() {
        int ordinal = this.d.ordinal();
        if (ordinal == 0) {
            this.a.a.f.sendDomotekaTeaserButtonClick();
            AdvertDetailsDomotekaTeaserPresenter.Router router = this.a.a.getRouter();
            if (router != null) {
                router.openDomotekaReport(this.c.getUrl());
            }
        } else if (ordinal == 1) {
            if (this.a.a.g.isAuthorized()) {
                this.a.a.showFlatNumberRequestDialog();
                return;
            }
            AdvertDetailsDomotekaTeaserPresenter.Router router2 = this.a.a.getRouter();
            if (router2 != null) {
                router2.loginForDomotekaFlatNumberRequest();
            }
        }
    }
}
