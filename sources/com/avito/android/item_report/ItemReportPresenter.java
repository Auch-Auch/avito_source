package com.avito.android.item_report;

import com.avito.android.legacy_mvp.Presenter;
import com.avito.android.remote.model.AdvertReport;
import com.avito.android.util.BundlePersistable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0007J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/item_report/ItemReportPresenter;", "Lcom/avito/android/util/BundlePersistable;", "Lcom/avito/android/legacy_mvp/Presenter;", "Lcom/avito/android/item_report/ItemReportPresenter$Subscriber;", "", "load", "()V", "Subscriber", "item-report_release"}, k = 1, mv = {1, 4, 2})
public interface ItemReportPresenter extends BundlePersistable, Presenter<Subscriber> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/item_report/ItemReportPresenter$Subscriber;", "", "", "message", "", "onFatalError", "(Ljava/lang/String;)V", "onNetworkError", "()V", "Lcom/avito/android/remote/model/AdvertReport;", "report", "onFinish", "(Lcom/avito/android/remote/model/AdvertReport;)V", "showProgress", "item-report_release"}, k = 1, mv = {1, 4, 2})
    public interface Subscriber {
        void onFatalError(@NotNull String str);

        void onFinish(@NotNull AdvertReport advertReport);

        void onNetworkError();

        void showProgress();
    }

    void load();
}
