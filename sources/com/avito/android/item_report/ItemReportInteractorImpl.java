package com.avito.android.item_report;

import com.avito.android.item_report.remote.ItemReportApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertReport;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/item_report/ItemReportInteractorImpl;", "Lcom/avito/android/item_report/ItemReportInteractor;", "", "itemId", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/AdvertReport;", "getReport", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/item_report/remote/ItemReportApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/item_report/remote/ItemReportApi;", "api", "<init>", "(Lcom/avito/android/item_report/remote/ItemReportApi;)V", "item-report_release"}, k = 1, mv = {1, 4, 2})
public final class ItemReportInteractorImpl implements ItemReportInteractor {
    public final ItemReportApi a;

    public ItemReportInteractorImpl(@NotNull ItemReportApi itemReportApi) {
        Intrinsics.checkNotNullParameter(itemReportApi, "api");
        this.a = itemReportApi;
    }

    @Override // com.avito.android.item_report.ItemReportInteractor
    @NotNull
    public Observable<AdvertReport> getReport(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return InteropKt.toV2(this.a.getItemReport(str));
    }
}
