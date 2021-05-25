package com.avito.android.verification.verifications_list.list;

import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fRD\u0010\u0016\u001a0\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00040\u0004 \u0012*\u0017\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0011¢\u0006\u0002\b\u00130\u0011¢\u0006\u0002\b\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/verification/verifications_list/list/VerificationsListItemPresenterImpl;", "Lcom/avito/android/verification/verifications_list/list/VerificationsListItemPresenter;", "Lcom/avito/android/verification/verifications_list/list/VerificationsListView;", "view", "Lcom/avito/android/verification/verifications_list/list/VerificationOptionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/verification/verifications_list/list/VerificationsListView;Lcom/avito/android/verification/verifications_list/list/VerificationOptionItem;I)V", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getClicks", "()Lio/reactivex/rxjava3/core/Observable;", "clicks", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "clicksRelay", "<init>", "()V", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationsListItemPresenterImpl implements VerificationsListItemPresenter {
    public final PublishRelay<VerificationOptionItem> a;
    @NotNull
    public final Observable<VerificationOptionItem> b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ VerificationsListItemPresenterImpl a;
        public final /* synthetic */ VerificationOptionItem b;

        public a(VerificationsListItemPresenterImpl verificationsListItemPresenterImpl, VerificationOptionItem verificationOptionItem) {
            this.a = verificationsListItemPresenterImpl;
            this.b = verificationOptionItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.a.accept(this.b);
        }
    }

    @Inject
    public VerificationsListItemPresenterImpl() {
        PublishRelay<VerificationOptionItem> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "clicksRelay");
        this.b = create;
    }

    @Override // com.avito.android.verification.verifications_list.list.VerificationsListItemPresenter
    @NotNull
    public Observable<VerificationOptionItem> getClicks() {
        return this.b;
    }

    public void bindView(@NotNull VerificationsListView verificationsListView, @NotNull VerificationOptionItem verificationOptionItem, int i) {
        Intrinsics.checkNotNullParameter(verificationsListView, "view");
        Intrinsics.checkNotNullParameter(verificationOptionItem, "item");
        verificationsListView.setTitle(verificationOptionItem.getTitle());
        verificationsListView.setSubTitle(verificationOptionItem.getSubtitle());
        verificationsListView.setStatus(verificationOptionItem.getStatus());
        verificationsListView.setClickListener(new a(this, verificationOptionItem));
    }
}
