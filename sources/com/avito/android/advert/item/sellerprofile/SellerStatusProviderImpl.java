package com.avito.android.advert.item.sellerprofile;

import android.content.res.Resources;
import com.avito.android.advert_core.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertSeller;
import com.avito.android.remote.model.SellerReplySpeed;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/advert/item/sellerprofile/SellerStatusProviderImpl;", "Lcom/avito/android/advert/item/sellerprofile/SellerStatusProvider;", "Lcom/avito/android/remote/model/AdvertSeller;", "seller", "", "getSellerStatusMessage", "(Lcom/avito/android/remote/model/AdvertSeller;)Ljava/lang/String;", "sellerHashId", "", "initialStatus", "Lio/reactivex/rxjava3/core/Observable;", "observeSellerOnlineStatus", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerStatusInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerStatusInteractor;", "interactor", "<init>", "(Lcom/avito/android/advert/item/sellerprofile/AdvertSellerStatusInteractor;Landroid/content/res/Resources;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SellerStatusProviderImpl implements SellerStatusProvider {
    public final AdvertSellerStatusInteractor a;
    public final Resources b;

    @Inject
    public SellerStatusProviderImpl(@NotNull AdvertSellerStatusInteractor advertSellerStatusInteractor, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(advertSellerStatusInteractor, "interactor");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = advertSellerStatusInteractor;
        this.b = resources;
    }

    @Override // com.avito.android.advert.item.sellerprofile.SellerStatusProvider
    @Nullable
    public String getSellerStatusMessage(@Nullable AdvertSeller advertSeller) {
        SellerReplySpeed replySpeed;
        String text;
        if (advertSeller != null ? advertSeller.getOnline() : false) {
            return this.b.getString(R.string.advert_contact_bar_online);
        }
        if (advertSeller == null || (replySpeed = advertSeller.getReplySpeed()) == null || (text = replySpeed.getText()) == null) {
            return null;
        }
        String lowerCase = text.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    @Override // com.avito.android.advert.item.sellerprofile.SellerStatusProvider
    @NotNull
    public Observable<Boolean> observeSellerOnlineStatus(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "sellerHashId");
        return this.a.observeSellerOnlineStatus(str, z);
    }
}
