package com.avito.android.advert.item.sellerprofile;

import com.avito.android.component.profile_snippet.ProfileSnippetData;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfileView;", "", "Lcom/avito/android/component/profile_snippet/ProfileSnippetData;", "data", "", "isClickable", "", "showProfileSnippet", "(Lcom/avito/android/component/profile_snippet/ProfileSnippetData;Z)V", "Lio/reactivex/rxjava3/core/Observable;", "profileClicks", "()Lio/reactivex/rxjava3/core/Observable;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertSellerProfileView {
    @NotNull
    Observable<Unit> profileClicks();

    void showProfileSnippet(@NotNull ProfileSnippetData profileSnippetData, boolean z);
}
