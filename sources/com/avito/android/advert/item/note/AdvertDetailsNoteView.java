package com.avito.android.advert.item.note;

import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.model.VKAttachments;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert/item/note/AdvertDetailsNoteView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", VKAttachments.TYPE_NOTE, "", "updateNote", "(Ljava/lang/String;)V", "", "visible", "setContentVisible", "(Z)V", "hideBottomDivider", "()V", "Lio/reactivex/rxjava3/core/Observable;", "getEditNoteButtonClick", "()Lio/reactivex/rxjava3/core/Observable;", "editNoteButtonClick", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsNoteView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsNoteView advertDetailsNoteView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsNoteView);
        }
    }

    @NotNull
    Observable<Unit> getEditNoteButtonClick();

    void hideBottomDivider();

    void setContentVisible(boolean z);

    void updateNote(@NotNull String str);
}
