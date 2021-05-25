package com.yandex.mapkit.map.internal;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.Callback;
import com.yandex.mapkit.map.CompositeIcon;
import com.yandex.mapkit.map.IconStyle;
import com.yandex.mapkit.map.ModelStyle;
import com.yandex.mapkit.map.PlacemarkAnimation;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.image.ImageProvider;
import com.yandex.runtime.model.ModelProvider;
import com.yandex.runtime.ui_view.ViewProvider;
import java.util.List;
public class PlacemarkMapObjectBinding extends MapObjectBinding implements PlacemarkMapObject {
    public PlacemarkMapObjectBinding(NativeObject nativeObject) {
        super(nativeObject);
    }

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native float getDirection();

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    @NonNull
    public native Point getGeometry();

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native float getOpacity();

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setDirection(float f);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setGeometry(@NonNull Point point);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setIcon(@NonNull ImageProvider imageProvider);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setIcon(@NonNull ImageProvider imageProvider, @NonNull Callback callback);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setIcon(@NonNull ImageProvider imageProvider, @NonNull IconStyle iconStyle);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setIcon(@NonNull ImageProvider imageProvider, @NonNull IconStyle iconStyle, @NonNull Callback callback);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setIconStyle(@NonNull IconStyle iconStyle);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setModel(@NonNull ModelProvider modelProvider, @NonNull ModelStyle modelStyle);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setModel(@NonNull ModelProvider modelProvider, @NonNull ModelStyle modelStyle, @NonNull Callback callback);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setModelStyle(@NonNull ModelStyle modelStyle);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setOpacity(float f);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setScaleFunction(@NonNull List<PointF> list);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setView(@NonNull ViewProvider viewProvider);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setView(@NonNull ViewProvider viewProvider, @NonNull Callback callback);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setView(@NonNull ViewProvider viewProvider, @NonNull IconStyle iconStyle);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    public native void setView(@NonNull ViewProvider viewProvider, @NonNull IconStyle iconStyle, @NonNull Callback callback);

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    @NonNull
    public native PlacemarkAnimation useAnimation();

    @Override // com.yandex.mapkit.map.PlacemarkMapObject
    @NonNull
    public native CompositeIcon useCompositeIcon();
}
