package com.yandex.mapkit.map;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Point;
import com.yandex.runtime.image.ImageProvider;
import com.yandex.runtime.model.ModelProvider;
import com.yandex.runtime.ui_view.ViewProvider;
import java.util.List;
public interface PlacemarkMapObject extends MapObject {
    float getDirection();

    @NonNull
    Point getGeometry();

    float getOpacity();

    void setDirection(float f);

    void setGeometry(@NonNull Point point);

    void setIcon(@NonNull ImageProvider imageProvider);

    void setIcon(@NonNull ImageProvider imageProvider, @NonNull Callback callback);

    void setIcon(@NonNull ImageProvider imageProvider, @NonNull IconStyle iconStyle);

    void setIcon(@NonNull ImageProvider imageProvider, @NonNull IconStyle iconStyle, @NonNull Callback callback);

    void setIconStyle(@NonNull IconStyle iconStyle);

    void setModel(@NonNull ModelProvider modelProvider, @NonNull ModelStyle modelStyle);

    void setModel(@NonNull ModelProvider modelProvider, @NonNull ModelStyle modelStyle, @NonNull Callback callback);

    void setModelStyle(@NonNull ModelStyle modelStyle);

    void setOpacity(float f);

    void setScaleFunction(@NonNull List<PointF> list);

    void setView(@NonNull ViewProvider viewProvider);

    void setView(@NonNull ViewProvider viewProvider, @NonNull Callback callback);

    void setView(@NonNull ViewProvider viewProvider, @NonNull IconStyle iconStyle);

    void setView(@NonNull ViewProvider viewProvider, @NonNull IconStyle iconStyle, @NonNull Callback callback);

    @NonNull
    PlacemarkAnimation useAnimation();

    @NonNull
    CompositeIcon useCompositeIcon();
}
