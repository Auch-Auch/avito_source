package com.avito.android.autoteka_details;

import android.net.Uri;
import com.avito.android.booking.info.BookingInfoActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetailsPresenter;", "", "Lcom/avito/android/autoteka_details/AutotekaDetailsView;", "view", "", "attachView", "(Lcom/avito/android/autoteka_details/AutotekaDetailsView;)V", "detachView", "()V", "Lcom/avito/android/autoteka_details/AutotekaDetailsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/autoteka_details/AutotekaDetailsPresenter$Router;)V", "detachRouter", "Router", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
public interface AutotekaDetailsPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetailsPresenter$Router;", "", "", "onBackClicked", "()V", "Landroid/net/Uri;", "url", "reportExampleClicked", "(Landroid/net/Uri;)V", "receiveReportClicked", "", BookingInfoActivity.EXTRA_ITEM_ID, "utmQuery", "(Ljava/lang/String;Ljava/lang/String;)V", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void onBackClicked();

        void receiveReportClicked(@NotNull Uri uri);

        void receiveReportClicked(@NotNull String str, @NotNull String str2);

        void reportExampleClicked(@NotNull Uri uri);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull AutotekaDetailsView autotekaDetailsView);

    void detachRouter();

    void detachView();
}
