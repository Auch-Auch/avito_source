package com.avito.android.tariff.edit_info.item.alert_dialog;

import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR:\u0010\u0010\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/alert_dialog/AlertDialogPresenterImpl;", "Lcom/avito/android/tariff/edit_info/item/alert_dialog/AlertDialogPresenter;", "Lcom/avito/android/tariff/edit_info/item/alert_dialog/AlertDialogItemView;", "view", "Lcom/avito/android/tariff/edit_info/item/alert_dialog/AlertDialogItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/tariff/edit_info/item/alert_dialog/AlertDialogItemView;Lcom/avito/android/tariff/edit_info/item/alert_dialog/AlertDialogItem;I)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/tariff/edit_info/item/alert_dialog/TariffAlertActionItem;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "clicksObservable", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getButtonClicks", "()Lio/reactivex/Observable;", "buttonClicks", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class AlertDialogPresenterImpl implements AlertDialogPresenter {
    public final PublishRelay<TariffAlertActionItem> a;
    @NotNull
    public final Observable<TariffAlertActionItem> b;

    public static final class a extends Lambda implements Function1<TariffAlertActionItem, Unit> {
        public final /* synthetic */ AlertDialogPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AlertDialogPresenterImpl alertDialogPresenterImpl, AlertDialogItem alertDialogItem) {
            super(1);
            this.a = alertDialogPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(TariffAlertActionItem tariffAlertActionItem) {
            TariffAlertActionItem tariffAlertActionItem2 = tariffAlertActionItem;
            Intrinsics.checkNotNullParameter(tariffAlertActionItem2, "it");
            this.a.a.accept(tariffAlertActionItem2);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public AlertDialogPresenterImpl() {
        PublishRelay<TariffAlertActionItem> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "clicksObservable");
        this.b = create;
    }

    @Override // com.avito.android.tariff.edit_info.item.alert_dialog.AlertDialogPresenter
    @NotNull
    public Observable<TariffAlertActionItem> getButtonClicks() {
        return this.b;
    }

    public void bindView(@NotNull AlertDialogItemView alertDialogItemView, @NotNull AlertDialogItem alertDialogItem, int i) {
        Intrinsics.checkNotNullParameter(alertDialogItemView, "view");
        Intrinsics.checkNotNullParameter(alertDialogItem, "item");
        alertDialogItemView.setOnButtonClickListener(new a(this, alertDialogItem));
        alertDialogItemView.bindAlert(alertDialogItem);
    }
}
