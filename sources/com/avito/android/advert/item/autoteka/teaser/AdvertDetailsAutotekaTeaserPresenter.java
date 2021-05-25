package com.avito.android.advert.item.autoteka.teaser;

import android.net.Uri;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserView;
import com.avito.android.remote.model.AutotekaTeaserResponse;
import com.avito.android.remote.model.CpoDescription;
import com.avito.android.util.LoadingState;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0014J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\u0007J#\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserView;", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserItem;", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserView$Listener;", "", "detachView", "()V", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter$Router;)V", "detachRouter", "", "itemId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/AutotekaTeaserResponse;", "loadAutotekaTeaser", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Router", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsAutotekaTeaserPresenter extends ItemPresenter<AdvertDetailsAutotekaTeaserView, AdvertDetailsAutotekaTeaserItem>, AdvertDetailsAutotekaTeaserView.Listener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onClickDialogButton(@NotNull AdvertDetailsAutotekaTeaserPresenter advertDetailsAutotekaTeaserPresenter) {
            AdvertDetailsAutotekaTeaserView.Listener.DefaultImpls.onClickDialogButton(advertDetailsAutotekaTeaserPresenter);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter$Router;", "", "Landroid/net/Uri;", "url", "", "openAutotekaTeaser", "(Landroid/net/Uri;)V", "Lcom/avito/android/remote/model/CpoDescription;", "data", "openAutotekaCpoProgramScreen", "(Lcom/avito/android/remote/model/CpoDescription;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void openAutotekaCpoProgramScreen(@NotNull CpoDescription cpoDescription);

        void openAutotekaTeaser(@NotNull Uri uri);
    }

    void attachRouter(@NotNull Router router);

    void detachRouter();

    void detachView();

    @NotNull
    Observable<LoadingState<AutotekaTeaserResponse>> loadAutotekaTeaser(@NotNull String str);
}
