package com.avito.android.advert;

import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.util.Kundle;
import com.vk.sdk.api.model.VKAttachments;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ+\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0010H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0010H&¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/avito/android/advert/AdvertDetailsToolbarPresenter;", "", "Lcom/avito/android/advert/AdvertDetailsToolbarView;", "toolbarView", "", "attachView", "(Lcom/avito/android/advert/AdvertDetailsToolbarView;)V", "detachView", "()V", "Lcom/avito/android/advert/AdvertDetailsToolbarRouter;", "router", "attachRouter", "(Lcom/avito/android/advert/AdvertDetailsToolbarRouter;)V", "detachRouter", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "", "updateFavoriteState", "", "context", "onAdvertLoaded", "(Lcom/avito/android/remote/model/AdvertDetails;ZLjava/lang/String;)V", VKAttachments.TYPE_NOTE, "updateNoteMenuItemTitle", "(Ljava/lang/String;)V", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "fromActionBar", "handleBackPressed", "(Z)V", PanelStateKt.PANEL_EXPANDED, "toggleToolbarIcons", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsToolbarPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onAdvertLoaded$default(AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter, AdvertDetails advertDetails, boolean z, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str = null;
                }
                advertDetailsToolbarPresenter.onAdvertLoaded(advertDetails, z, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAdvertLoaded");
        }
    }

    void attachRouter(@NotNull AdvertDetailsToolbarRouter advertDetailsToolbarRouter);

    void attachView(@NotNull AdvertDetailsToolbarView advertDetailsToolbarView);

    void detachRouter();

    void detachView();

    void handleBackPressed(boolean z);

    void onAdvertLoaded(@NotNull AdvertDetails advertDetails, boolean z, @Nullable String str);

    @NotNull
    Kundle onSaveState();

    void toggleToolbarIcons(boolean z);

    void updateFavoriteState(@NotNull AdvertDetails advertDetails);

    void updateNoteMenuItemTitle(@Nullable String str);
}
