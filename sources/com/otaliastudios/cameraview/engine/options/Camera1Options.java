package com.otaliastudios.cameraview.engine.options;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.mappers.Camera1Mapper;
import com.otaliastudios.cameraview.internal.CamcorderProfiles;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
import java.util.List;
import kotlinx.coroutines.DebugKt;
public class Camera1Options extends CameraOptions {
    public Camera1Options(@NonNull Camera.Parameters parameters, int i, boolean z) {
        Camera1Mapper camera1Mapper = Camera1Mapper.get();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            Facing unmapFacing = camera1Mapper.unmapFacing(cameraInfo.facing);
            if (unmapFacing != null) {
                this.supportedFacing.add(unmapFacing);
            }
        }
        List<String> supportedWhiteBalance = parameters.getSupportedWhiteBalance();
        if (supportedWhiteBalance != null) {
            for (String str : supportedWhiteBalance) {
                WhiteBalance unmapWhiteBalance = camera1Mapper.unmapWhiteBalance(str);
                if (unmapWhiteBalance != null) {
                    this.supportedWhiteBalance.add(unmapWhiteBalance);
                }
            }
        }
        this.supportedFlash.add(Flash.OFF);
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            for (String str2 : supportedFlashModes) {
                Flash unmapFlash = camera1Mapper.unmapFlash(str2);
                if (unmapFlash != null) {
                    this.supportedFlash.add(unmapFlash);
                }
            }
        }
        this.supportedHdr.add(Hdr.OFF);
        List<String> supportedSceneModes = parameters.getSupportedSceneModes();
        if (supportedSceneModes != null) {
            for (String str3 : supportedSceneModes) {
                Hdr unmapHdr = camera1Mapper.unmapHdr(str3);
                if (unmapHdr != null) {
                    this.supportedHdr.add(unmapHdr);
                }
            }
        }
        this.zoomSupported = parameters.isZoomSupported();
        this.autoFocusSupported = parameters.getSupportedFocusModes().contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        this.exposureCorrectionMinValue = ((float) parameters.getMinExposureCompensation()) * exposureCompensationStep;
        this.exposureCorrectionMaxValue = ((float) parameters.getMaxExposureCompensation()) * exposureCompensationStep;
        this.exposureCorrectionSupported = (parameters.getMinExposureCompensation() == 0 && parameters.getMaxExposureCompensation() == 0) ? false : true;
        for (Camera.Size size : parameters.getSupportedPictureSizes()) {
            int i3 = z ? size.height : size.width;
            int i4 = z ? size.width : size.height;
            this.supportedPictureSizes.add(new Size(i3, i4));
            this.supportedPictureAspectRatio.add(AspectRatio.of(i3, i4));
        }
        CamcorderProfile camcorderProfile = CamcorderProfiles.get(i, new Size(Integer.MAX_VALUE, Integer.MAX_VALUE));
        Size size2 = new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        if (supportedVideoSizes != null) {
            for (Camera.Size size3 : supportedVideoSizes) {
                if (size3.width <= size2.getWidth() && size3.height <= size2.getHeight()) {
                    int i5 = z ? size3.height : size3.width;
                    int i6 = z ? size3.width : size3.height;
                    this.supportedVideoSizes.add(new Size(i5, i6));
                    this.supportedVideoAspectRatio.add(AspectRatio.of(i5, i6));
                }
            }
        } else {
            for (Camera.Size size4 : parameters.getSupportedPreviewSizes()) {
                if (size4.width <= size2.getWidth() && size4.height <= size2.getHeight()) {
                    int i7 = z ? size4.height : size4.width;
                    int i8 = z ? size4.width : size4.height;
                    this.supportedVideoSizes.add(new Size(i7, i8));
                    this.supportedVideoAspectRatio.add(AspectRatio.of(i7, i8));
                }
            }
        }
        this.previewFrameRateMinValue = Float.MAX_VALUE;
        this.previewFrameRateMaxValue = -3.4028235E38f;
        for (int[] iArr : parameters.getSupportedPreviewFpsRange()) {
            this.previewFrameRateMinValue = Math.min(this.previewFrameRateMinValue, ((float) iArr[0]) / 1000.0f);
            this.previewFrameRateMaxValue = Math.max(this.previewFrameRateMaxValue, ((float) iArr[1]) / 1000.0f);
        }
        this.supportedPictureFormats.add(PictureFormat.JPEG);
        this.supportedFrameProcessingFormats.add(17);
    }
}
