package com.otaliastudios.cameraview;

import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.AudioCodec;
import com.otaliastudios.cameraview.controls.Control;
import com.otaliastudios.cameraview.controls.Engine;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Grid;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.Preview;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.gesture.GestureAction;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
public abstract class CameraOptions {
    public boolean autoFocusSupported;
    public float exposureCorrectionMaxValue;
    public float exposureCorrectionMinValue;
    public boolean exposureCorrectionSupported;
    public float previewFrameRateMaxValue;
    public float previewFrameRateMinValue;
    public Set<Facing> supportedFacing = new HashSet(2);
    public Set<Flash> supportedFlash = new HashSet(4);
    public Set<Integer> supportedFrameProcessingFormats = new HashSet(2);
    public Set<Hdr> supportedHdr = new HashSet(2);
    public Set<AspectRatio> supportedPictureAspectRatio = new HashSet(4);
    public Set<PictureFormat> supportedPictureFormats = new HashSet(2);
    public Set<Size> supportedPictureSizes = new HashSet(15);
    public Set<AspectRatio> supportedVideoAspectRatio = new HashSet(3);
    public Set<Size> supportedVideoSizes = new HashSet(5);
    public Set<WhiteBalance> supportedWhiteBalance = new HashSet(5);
    public boolean zoomSupported;

    public final float getExposureCorrectionMaxValue() {
        return this.exposureCorrectionMaxValue;
    }

    public final float getExposureCorrectionMinValue() {
        return this.exposureCorrectionMinValue;
    }

    public final float getPreviewFrameRateMaxValue() {
        return this.previewFrameRateMaxValue;
    }

    public final float getPreviewFrameRateMinValue() {
        return this.previewFrameRateMinValue;
    }

    @NonNull
    public final <T extends Control> Collection<T> getSupportedControls(@NonNull Class<T> cls) {
        if (cls.equals(Audio.class)) {
            return Arrays.asList(Audio.values());
        }
        if (cls.equals(Facing.class)) {
            return getSupportedFacing();
        }
        if (cls.equals(Flash.class)) {
            return getSupportedFlash();
        }
        if (cls.equals(Grid.class)) {
            return Arrays.asList(Grid.values());
        }
        if (cls.equals(Hdr.class)) {
            return getSupportedHdr();
        }
        if (cls.equals(Mode.class)) {
            return Arrays.asList(Mode.values());
        }
        if (cls.equals(VideoCodec.class)) {
            return Arrays.asList(VideoCodec.values());
        }
        if (cls.equals(AudioCodec.class)) {
            return Arrays.asList(AudioCodec.values());
        }
        if (cls.equals(WhiteBalance.class)) {
            return getSupportedWhiteBalance();
        }
        if (cls.equals(Engine.class)) {
            return Arrays.asList(Engine.values());
        }
        if (cls.equals(Preview.class)) {
            return Arrays.asList(Preview.values());
        }
        if (cls.equals(PictureFormat.class)) {
            return getSupportedPictureFormats();
        }
        return Collections.emptyList();
    }

    @NonNull
    public final Collection<Facing> getSupportedFacing() {
        return Collections.unmodifiableSet(this.supportedFacing);
    }

    @NonNull
    public final Collection<Flash> getSupportedFlash() {
        return Collections.unmodifiableSet(this.supportedFlash);
    }

    @NonNull
    public final Collection<Integer> getSupportedFrameProcessingFormats() {
        return Collections.unmodifiableSet(this.supportedFrameProcessingFormats);
    }

    @NonNull
    public final Collection<Hdr> getSupportedHdr() {
        return Collections.unmodifiableSet(this.supportedHdr);
    }

    @NonNull
    public final Collection<AspectRatio> getSupportedPictureAspectRatios() {
        return Collections.unmodifiableSet(this.supportedPictureAspectRatio);
    }

    @NonNull
    public final Collection<PictureFormat> getSupportedPictureFormats() {
        return Collections.unmodifiableSet(this.supportedPictureFormats);
    }

    @NonNull
    public final Collection<Size> getSupportedPictureSizes() {
        return Collections.unmodifiableSet(this.supportedPictureSizes);
    }

    @NonNull
    public final Collection<AspectRatio> getSupportedVideoAspectRatios() {
        return Collections.unmodifiableSet(this.supportedVideoAspectRatio);
    }

    @NonNull
    public final Collection<Size> getSupportedVideoSizes() {
        return Collections.unmodifiableSet(this.supportedVideoSizes);
    }

    @NonNull
    public final Collection<WhiteBalance> getSupportedWhiteBalance() {
        return Collections.unmodifiableSet(this.supportedWhiteBalance);
    }

    public final boolean isAutoFocusSupported() {
        return this.autoFocusSupported;
    }

    public final boolean isExposureCorrectionSupported() {
        return this.exposureCorrectionSupported;
    }

    public final boolean isZoomSupported() {
        return this.zoomSupported;
    }

    public final boolean supports(@NonNull Control control) {
        return getSupportedControls(control.getClass()).contains(control);
    }

    public final boolean supports(@NonNull GestureAction gestureAction) {
        int ordinal = gestureAction.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return isAutoFocusSupported();
            }
            if (ordinal != 2) {
                if (ordinal == 4) {
                    return isZoomSupported();
                }
                if (ordinal == 5) {
                    return isExposureCorrectionSupported();
                }
                if (ordinal != 6 && ordinal != 7) {
                    return false;
                }
            }
        }
        return true;
    }
}
