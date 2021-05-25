package com.yandex.runtime.view;

import android.view.View;
import com.yandex.runtime.NativeObject;
public interface PlatformGLView {
    void destroyNativePlatformView();

    NativeObject getNativePlatformView();

    View getView();

    void onMemoryWarning();

    void pause();

    void resume();

    void setNoninteractive(boolean z);

    void start();

    void stop();
}
