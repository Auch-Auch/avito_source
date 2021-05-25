package ru.avito.component.floating_add_advert;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.design.widget.add_advert.AddAdvertView;
import com.avito.android.design.widget.lifecycle_view.AttachListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H&¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H&¢\u0006\u0004\b\u000b\u0010\u0007J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H&¢\u0006\u0004\b\r\u0010\u0007J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\u0007J\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH&¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\bH&¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\bH&¢\u0006\u0004\b\u0016\u0010\u0013J\u001f\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lru/avito/component/floating_add_advert/FloatingAddAdvert;", "", "", "handleBack", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "addAdvertOpenCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "", "aboutToBeExpandedCallbacks", "Lcom/avito/android/deep_linking/links/DeepLink;", "addAdvertClicks", "Lcom/avito/android/design/widget/add_advert/AddAdvertView$FinishReason;", "addAdvertFinishCallbacks", "expandCallback", "resizeButton", "setResizeButton", "(Z)V", "expandAddAdvertWithDraftCheck", "()V", "continueExpandAddAdvert", "showAddAdvert", "hideAddAdvert", "show", "animate", "animateFloatingAddAdvert", "(ZZ)V", "Lru/avito/component/floating_add_advert/FloatingAddAdvert$EventListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lru/avito/component/floating_add_advert/FloatingAddAdvert$EventListener;)V", "EventListener", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface FloatingAddAdvert {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lru/avito/component/floating_add_advert/FloatingAddAdvert$EventListener;", "Lcom/avito/android/design/widget/lifecycle_view/AttachListener;", "Lru/avito/component/floating_add_advert/AdvertShortcut;", "advertShortcut", "", "onPublishVerticalChosen", "(Lru/avito/component/floating_add_advert/AdvertShortcut;)V", "onNewAdvertIntent", "()V", "onButtonsShowed", "onUserAuntificationRequested", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public interface EventListener extends AttachListener {
        void onButtonsShowed();

        void onNewAdvertIntent();

        void onPublishVerticalChosen(@NotNull AdvertShortcut advertShortcut);

        void onUserAuntificationRequested();
    }

    @NotNull
    Observable<Unit> aboutToBeExpandedCallbacks();

    @NotNull
    Observable<DeepLink> addAdvertClicks();

    @NotNull
    Observable<AddAdvertView.FinishReason> addAdvertFinishCallbacks();

    @NotNull
    Observable<Boolean> addAdvertOpenCallbacks();

    void animateFloatingAddAdvert(boolean z, boolean z2);

    void continueExpandAddAdvert();

    void expandAddAdvertWithDraftCheck();

    @NotNull
    Observable<Boolean> expandCallback();

    boolean handleBack();

    void hideAddAdvert();

    void setListener(@Nullable EventListener eventListener);

    void setResizeButton(boolean z);

    void showAddAdvert();
}
