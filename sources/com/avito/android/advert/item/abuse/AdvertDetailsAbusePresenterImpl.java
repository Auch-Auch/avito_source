package com.avito.android.advert.item.abuse;

import android.view.View;
import com.avito.android.advert.item.abuse.AdvertDetailsAbusePresenter;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert/item/abuse/AdvertDetailsAbusePresenterImpl;", "Lcom/avito/android/advert/item/abuse/AdvertDetailsAbusePresenter;", "Lcom/avito/android/advert/item/abuse/AdvertDetailsAbuseView;", "view", "Lcom/avito/android/advert/item/abuse/AdvertDetailsAbuseItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/abuse/AdvertDetailsAbuseView;Lcom/avito/android/advert/item/abuse/AdvertDetailsAbuseItem;I)V", "Lcom/avito/android/advert/item/abuse/AdvertDetailsAbusePresenter$Listener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/abuse/AdvertDetailsAbusePresenter$Listener;", "abuseLister", "<init>", "(Lcom/avito/android/advert/item/abuse/AdvertDetailsAbusePresenter$Listener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAbusePresenterImpl implements AdvertDetailsAbusePresenter {
    public final AdvertDetailsAbusePresenter.Listener a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AdvertDetailsAbusePresenterImpl a;

        public a(AdvertDetailsAbusePresenterImpl advertDetailsAbusePresenterImpl) {
            this.a = advertDetailsAbusePresenterImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.a.onAbuseButtonClick();
        }
    }

    @Inject
    public AdvertDetailsAbusePresenterImpl(@NotNull AdvertDetailsAbusePresenter.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "abuseLister");
        this.a = listener;
    }

    public void bindView(@NotNull AdvertDetailsAbuseView advertDetailsAbuseView, @NotNull AdvertDetailsAbuseItem advertDetailsAbuseItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsAbuseView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsAbuseItem, "item");
        advertDetailsAbuseView.setListener(new a(this));
    }
}
