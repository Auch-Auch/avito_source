package com.avito.android.advert.item.autodeal;

import android.view.View;
import com.avito.android.advert.item.AdvertDetailsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert/item/autodeal/AdvertDetailsAutodealPresenterImpl;", "Lcom/avito/android/advert/item/autodeal/AdvertDetailsAutodealPresenter;", "Lcom/avito/android/advert/item/autodeal/AdvertDetailsAutodealView;", "view", "Lcom/avito/android/advert/item/autodeal/AdvertDetailsAutodealItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/autodeal/AdvertDetailsAutodealView;Lcom/avito/android/advert/item/autodeal/AdvertDetailsAutodealItem;I)V", "Lcom/avito/android/advert/item/AdvertDetailsPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/AdvertDetailsPresenter;", "presenter", "<init>", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAutodealPresenterImpl implements AdvertDetailsAutodealPresenter {
    public final AdvertDetailsPresenter a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AdvertDetailsAutodealPresenterImpl a;
        public final /* synthetic */ AdvertDetailsAutodealItem b;

        public a(AdvertDetailsAutodealPresenterImpl advertDetailsAutodealPresenterImpl, AdvertDetailsAutodealItem advertDetailsAutodealItem) {
            this.a = advertDetailsAutodealPresenterImpl;
            this.b = advertDetailsAutodealItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AdvertDetailsPresenter advertDetailsPresenter = this.a.a;
            String uri = this.b.getAutoDeal().getAction().getUri().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "item.autoDeal.action.uri.toString()");
            advertDetailsPresenter.handleAutoDealClick(uri);
        }
    }

    @Inject
    public AdvertDetailsAutodealPresenterImpl(@NotNull AdvertDetailsPresenter advertDetailsPresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsPresenter, "presenter");
        this.a = advertDetailsPresenter;
    }

    public void bindView(@NotNull AdvertDetailsAutodealView advertDetailsAutodealView, @NotNull AdvertDetailsAutodealItem advertDetailsAutodealItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsAutodealView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsAutodealItem, "item");
        advertDetailsAutodealView.setListener(new a(this, advertDetailsAutodealItem));
        advertDetailsAutodealView.showAutodeal(advertDetailsAutodealItem.getAutoDeal());
    }
}
