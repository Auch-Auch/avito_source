package com.avito.android.advert.item.autoteka;

import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaView;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0014J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaView;", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaItem;", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaView$Listener;", "view", "", "attachView", "(Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaView;)V", "detachView", "()V", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter$Router;)V", "detachRouter", "loadAutoteka", "", "isRequestDisposed", "()Z", "Router", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsAutotekaPresenter extends ItemPresenter<AdvertDetailsAutotekaView, AdvertDetailsAutotekaItem>, AdvertDetailsAutotekaView.Listener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter$Router;", "", "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "autotekaDetails", "", "showAutoteka", "(Lcom/avito/android/remote/model/AutotekaDetailsResponse;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void showAutoteka(@Nullable AutotekaDetailsResponse autotekaDetailsResponse);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull AdvertDetailsAutotekaView advertDetailsAutotekaView);

    void detachRouter();

    void detachView();

    boolean isRequestDisposed();

    void loadAutoteka();
}
