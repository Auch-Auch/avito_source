package com.avito.android.item_map.view;

import android.app.Activity;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.item_map.view.ItemMapView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\bJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\b\u001e\u0010\bJ\u001b\u0010!\u001a\u00020\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fH&¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H&¢\u0006\u0004\b#\u0010\bJ\u000f\u0010$\u001a\u00020\u0004H&¢\u0006\u0004\b$\u0010\b¨\u0006&"}, d2 = {"Lcom/avito/android/item_map/view/ItemMapPresenter;", "", "Lcom/avito/android/item_map/view/ItemMapView;", "view", "", "attachView", "(Lcom/avito/android/item_map/view/ItemMapView;)V", "detachView", "()V", "Lcom/avito/android/item_map/view/ItemMapPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/item_map/view/ItemMapPresenter$Router;)V", "detachRouter", "Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "onSaveState", "()Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "point", "", "zoomToBounds", "addUserMarker", "(Lcom/avito/android/avito_map/AvitoMapPoint;Z)V", "onStartMap", "onStopMap", "onDestroyMap", "Landroid/app/Activity;", "activity", "subscribeFindLocation", "(Landroid/app/Activity;)V", "subscribeOnPermissionResult", "", "messageError", "findLocationError", "(Ljava/lang/String;)V", "sendScreenExitAfterCoordinatesResolve", "subscribeOnNotPermissionGranted", "Router", "item-map_release"}, k = 1, mv = {1, 4, 2})
public interface ItemMapPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void addUserMarker$default(ItemMapPresenter itemMapPresenter, AvitoMapPoint avitoMapPoint, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                itemMapPresenter.addUserMarker(avitoMapPoint, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addUserMarker");
        }

        public static /* synthetic */ void findLocationError$default(ItemMapPresenter itemMapPresenter, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                itemMapPresenter.findLocationError(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findLocationError");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/item_map/view/ItemMapPresenter$Router;", "", "", "finishScreen", "()V", "openOsmUrl", "Lcom/avito/android/avito_map/AvitoMapPoint;", "itemCoordinates", "createRoute", "(Lcom/avito/android/avito_map/AvitoMapPoint;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void createRoute(@NotNull AvitoMapPoint avitoMapPoint);

        void finishScreen();

        void openOsmUrl();
    }

    void addUserMarker(@NotNull AvitoMapPoint avitoMapPoint, boolean z);

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull ItemMapView itemMapView);

    void detachRouter();

    void detachView();

    void findLocationError(@Nullable String str);

    void onDestroyMap();

    @NotNull
    ItemMapView.ItemMapState onSaveState();

    void onStartMap();

    void onStopMap();

    void sendScreenExitAfterCoordinatesResolve();

    void subscribeFindLocation(@NotNull Activity activity);

    void subscribeOnNotPermissionGranted();

    void subscribeOnPermissionResult();
}
