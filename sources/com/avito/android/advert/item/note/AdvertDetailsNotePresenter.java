package com.avito.android.advert.item.note;

import com.avito.android.remote.model.AdvertDetails;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.model.VKAttachments;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H&¢\u0006\u0004\b\u0017\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/note/AdvertDetailsNoteView;", "Lcom/avito/android/advert/item/note/AdvertDetailsNoteItem;", "view", "", "attachView", "(Lcom/avito/android/advert/item/note/AdvertDetailsNoteView;)V", "detachView", "()V", "Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter$Router;)V", "detachRouter", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "onAdvertLoaded", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "", VKAttachments.TYPE_NOTE, "updateNote", "(Ljava/lang/String;)V", "updateCurrentNote", "Router", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsNotePresenter extends ItemPresenter<AdvertDetailsNoteView, AdvertDetailsNoteItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter$Router;", "", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "", "editNoteClick", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        @Override // com.avito.android.advert.AdvertDetailsToolbarRouter
        void editNoteClick(@NotNull AdvertDetails advertDetails);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull AdvertDetailsNoteView advertDetailsNoteView);

    void detachRouter();

    void detachView();

    void onAdvertLoaded(@NotNull AdvertDetails advertDetails);

    void updateCurrentNote();

    void updateNote(@Nullable String str);
}
