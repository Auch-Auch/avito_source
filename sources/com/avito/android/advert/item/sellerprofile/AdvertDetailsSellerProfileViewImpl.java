package com.avito.android.advert.item.sellerprofile;

import android.view.View;
import com.avito.android.component.profile_snippet.ProfileSnippetData;
import com.avito.konveyor.adapter.BaseViewHolder;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert/item/sellerprofile/AdvertDetailsSellerProfileViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/sellerprofile/AdvertDetailsSellerProfileView;", "Lcom/avito/android/component/profile_snippet/ProfileSnippetData;", "data", "", "isClickable", "", "showProfileSnippet", "(Lcom/avito/android/component/profile_snippet/ProfileSnippetData;Z)V", "Lio/reactivex/rxjava3/core/Observable;", "profileClicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfileViewImpl;", "s", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfileViewImpl;", "sellerProfileView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSellerProfileViewImpl extends BaseViewHolder implements AdvertDetailsSellerProfileView {
    public final AdvertSellerProfileViewImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsSellerProfileViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new AdvertSellerProfileViewImpl(view);
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerProfileView
    @NotNull
    public Observable<Unit> profileClicks() {
        return this.s.profileClicks();
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerProfileView
    public void showProfileSnippet(@NotNull ProfileSnippetData profileSnippetData, boolean z) {
        Intrinsics.checkNotNullParameter(profileSnippetData, "data");
        this.s.showProfileSnippet(profileSnippetData, z);
    }
}
