package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.Animation;
public interface MapObject {
    void addTapListener(@NonNull MapObjectTapListener mapObjectTapListener);

    @NonNull
    MapObjectCollection getParent();

    @Nullable
    Object getUserData();

    float getZIndex();

    boolean isDraggable();

    boolean isValid();

    boolean isVisible();

    void removeTapListener(@NonNull MapObjectTapListener mapObjectTapListener);

    void setDragListener(@Nullable MapObjectDragListener mapObjectDragListener);

    void setDraggable(boolean z);

    void setUserData(@Nullable Object obj);

    void setVisible(boolean z);

    void setVisible(boolean z, @NonNull Animation animation, @Nullable Callback callback);

    void setZIndex(float f);
}
