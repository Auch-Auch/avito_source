package com.yandex.runtime.testview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.Runtime;
import com.yandex.runtime.view.PlatformGLView;
import com.yandex.runtime.view.PlatformGLViewFactory;
public class TestViewActivity extends Activity {
    private static final String DELEGATE_PARAMS_EXTRA = "DELEGATE_PARAMS_EXTRA";
    private static final String LOG_TAG = "yandex.maps";
    private PlatformGLView platformGLView;

    public static void start(NativeObject nativeObject) {
        Context applicationContext = Runtime.getApplicationContext();
        Intent intent = new Intent(applicationContext, TestViewActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(DELEGATE_PARAMS_EXTRA, nativeObject.release());
        applicationContext.startActivity(intent);
    }

    private native void startTestView(NativeObject nativeObject, NativeObject nativeObject2, TestViewActivity testViewActivity);

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NativeObject nativeObject = new NativeObject(getIntent().getLongExtra(DELEGATE_PARAMS_EXTRA, 0));
        PlatformGLView platformGLView2 = PlatformGLViewFactory.getPlatformGLView(this, null);
        this.platformGLView = platformGLView2;
        startTestView(platformGLView2.getNativePlatformView(), nativeObject, this);
        setContentView(this.platformGLView.getView());
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        PlatformGLView platformGLView2 = this.platformGLView;
        if (platformGLView2 != null) {
            platformGLView2.pause();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        PlatformGLView platformGLView2 = this.platformGLView;
        if (platformGLView2 != null) {
            platformGLView2.resume();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        PlatformGLView platformGLView2 = this.platformGLView;
        if (platformGLView2 != null) {
            platformGLView2.start();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        PlatformGLView platformGLView2 = this.platformGLView;
        if (platformGLView2 != null) {
            platformGLView2.stop();
        }
    }

    public void stop() throws Throwable {
        ((ViewGroup) this.platformGLView.getView().getParent()).removeView(this.platformGLView.getView());
        this.platformGLView.getNativePlatformView().finalize();
        this.platformGLView = null;
        finish();
    }
}
