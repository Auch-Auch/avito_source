package com.yandex.mapkit.map.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.map.Callback;
import com.yandex.mapkit.map.MapObject;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.map.MapObjectDragListener;
import com.yandex.mapkit.map.MapObjectTapListener;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.subscription.Subscription;
public class MapObjectBinding implements MapObject {
    private Subscription<MapObjectDragListener> mapObjectDragListenerSubscription = new Subscription<MapObjectDragListener>() { // from class: com.yandex.mapkit.map.internal.MapObjectBinding.1
        public NativeObject createNativeListener(MapObjectDragListener mapObjectDragListener) {
            return MapObjectBinding.createMapObjectDragListener(mapObjectDragListener);
        }
    };
    private Subscription<MapObjectTapListener> mapObjectTapListenerSubscription = new Subscription<MapObjectTapListener>() { // from class: com.yandex.mapkit.map.internal.MapObjectBinding.2
        public NativeObject createNativeListener(MapObjectTapListener mapObjectTapListener) {
            return MapObjectBinding.createMapObjectTapListener(mapObjectTapListener);
        }
    };
    private final NativeObject nativeObject;

    public MapObjectBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    /* access modifiers changed from: private */
    public static native NativeObject createMapObjectDragListener(MapObjectDragListener mapObjectDragListener);

    /* access modifiers changed from: private */
    public static native NativeObject createMapObjectTapListener(MapObjectTapListener mapObjectTapListener);

    @Override // com.yandex.mapkit.map.MapObject
    public native void addTapListener(@NonNull MapObjectTapListener mapObjectTapListener);

    @Override // com.yandex.mapkit.map.MapObject
    @NonNull
    public native MapObjectCollection getParent();

    @Override // com.yandex.mapkit.map.MapObject
    @Nullable
    public native Object getUserData();

    @Override // com.yandex.mapkit.map.MapObject
    public native float getZIndex();

    @Override // com.yandex.mapkit.map.MapObject
    public native boolean isDraggable();

    @Override // com.yandex.mapkit.map.MapObject
    public native boolean isValid();

    @Override // com.yandex.mapkit.map.MapObject
    public native boolean isVisible();

    @Override // com.yandex.mapkit.map.MapObject
    public native void removeTapListener(@NonNull MapObjectTapListener mapObjectTapListener);

    @Override // com.yandex.mapkit.map.MapObject
    public native void setDragListener(@Nullable MapObjectDragListener mapObjectDragListener);

    @Override // com.yandex.mapkit.map.MapObject
    public native void setDraggable(boolean z);

    @Override // com.yandex.mapkit.map.MapObject
    public native void setUserData(@Nullable Object obj);

    @Override // com.yandex.mapkit.map.MapObject
    public native void setVisible(boolean z);

    @Override // com.yandex.mapkit.map.MapObject
    public native void setVisible(boolean z, @NonNull Animation animation, @Nullable Callback callback);

    @Override // com.yandex.mapkit.map.MapObject
    public native void setZIndex(float f);
}
