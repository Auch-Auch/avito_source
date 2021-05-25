package com.yandex.runtime.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import com.yandex.runtime.R;
import java.util.HashSet;
import java.util.Set;
public class PlatformGLViewFactory {

    public enum Attribute {
        MOVABLE,
        NONINTERACTIVE,
        RENDER_DEBUG,
        VULKAN_ENABLED
    }

    public static final Set<Attribute> convertAttributeSet(Context context, AttributeSet attributeSet) {
        HashSet hashSet = new HashSet();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PlatformView, 0, 0);
        try {
            if (obtainStyledAttributes.getBoolean(R.styleable.PlatformView_movable, false)) {
                hashSet.add(Attribute.MOVABLE);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.PlatformView_noninteractive, false)) {
                hashSet.add(Attribute.NONINTERACTIVE);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.PlatformView_renderDebug, false)) {
                hashSet.add(Attribute.RENDER_DEBUG);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.PlatformView_vulkanEnabled, false)) {
                hashSet.add(Attribute.VULKAN_ENABLED);
            }
            return hashSet;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static PlatformGLView getPlatformGLView(Context context, Set<Attribute> set) {
        PlatformGLView platformGLView;
        if (set == null) {
            set = new HashSet<>();
        }
        boolean contains = set.contains(Attribute.RENDER_DEBUG);
        if ((Build.VERSION.SDK_INT >= 24) && set.contains(Attribute.VULKAN_ENABLED)) {
            platformGLView = new PlatformVulkanSurfaceView(context, contains);
        } else if (set.contains(Attribute.MOVABLE)) {
            platformGLView = new PlatformGLTextureView(context, contains);
        } else {
            platformGLView = new PlatformGLSurfaceView(context, contains);
        }
        if (set.contains(Attribute.NONINTERACTIVE)) {
            platformGLView.setNoninteractive(true);
        }
        return platformGLView;
    }
}
