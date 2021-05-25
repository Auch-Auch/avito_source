package com.otaliastudios.cameraview.engine.options;

import a2.b.a.a.a;
import android.graphics.ImageFormat;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.mappers.Camera2Mapper;
import com.otaliastudios.cameraview.internal.CamcorderProfiles;
import com.otaliastudios.cameraview.size.AspectRatio;
@RequiresApi(21)
public class Camera2Options extends CameraOptions {
    public Camera2Options(@NonNull CameraManager cameraManager, @NonNull String str, boolean z, int i) throws CameraAccessException {
        Facing unmapFacing;
        Camera2Mapper camera2Mapper = Camera2Mapper.get();
        CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
        for (String str2 : cameraManager.getCameraIdList()) {
            Integer num = (Integer) cameraManager.getCameraCharacteristics(str2).get(CameraCharacteristics.LENS_FACING);
            if (!(num == null || (unmapFacing = camera2Mapper.unmapFacing(num.intValue())) == null)) {
                this.supportedFacing.add(unmapFacing);
            }
        }
        for (int i2 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES)) {
            WhiteBalance unmapWhiteBalance = camera2Mapper.unmapWhiteBalance(i2);
            if (unmapWhiteBalance != null) {
                this.supportedWhiteBalance.add(unmapWhiteBalance);
            }
        }
        this.supportedFlash.add(Flash.OFF);
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool != null && bool.booleanValue()) {
            for (int i3 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES)) {
                this.supportedFlash.addAll(camera2Mapper.unmapFlash(i3));
            }
        }
        this.supportedHdr.add(Hdr.OFF);
        for (int i4 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES)) {
            Hdr unmapHdr = camera2Mapper.unmapHdr(i4);
            if (unmapHdr != null) {
                this.supportedHdr.add(unmapHdr);
            }
        }
        Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        boolean z2 = true;
        if (f != null) {
            this.zoomSupported = f.floatValue() > 1.0f;
        }
        Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        Integer num3 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        Integer num4 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        this.autoFocusSupported = (num2 != null && num2.intValue() > 0) || (num3 != null && num3.intValue() > 0) || (num4 != null && num4.intValue() > 0);
        Range range = (Range) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        Rational rational = (Rational) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        if (!(range == null || rational == null || rational.floatValue() == 0.0f)) {
            this.exposureCorrectionMinValue = ((float) ((Integer) range.getLower()).intValue()) / rational.floatValue();
            this.exposureCorrectionMaxValue = ((float) ((Integer) range.getUpper()).intValue()) / rational.floatValue();
        }
        this.exposureCorrectionSupported = (this.exposureCorrectionMinValue == 0.0f || this.exposureCorrectionMaxValue == 0.0f) ? false : true;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            int[] outputFormats = streamConfigurationMap.getOutputFormats();
            int length = outputFormats.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    z2 = false;
                    break;
                } else if (outputFormats[i5] == i) {
                    break;
                } else {
                    i5++;
                }
            }
            if (z2) {
                Size[] outputSizes = streamConfigurationMap.getOutputSizes(i);
                for (Size size : outputSizes) {
                    int height = z ? size.getHeight() : size.getWidth();
                    int width = z ? size.getWidth() : size.getHeight();
                    this.supportedPictureSizes.add(new com.otaliastudios.cameraview.size.Size(height, width));
                    this.supportedPictureAspectRatio.add(AspectRatio.of(height, width));
                }
                CamcorderProfile camcorderProfile = CamcorderProfiles.get(str, new com.otaliastudios.cameraview.size.Size(Integer.MAX_VALUE, Integer.MAX_VALUE));
                com.otaliastudios.cameraview.size.Size size2 = new com.otaliastudios.cameraview.size.Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
                Size[] outputSizes2 = streamConfigurationMap.getOutputSizes(MediaRecorder.class);
                for (Size size3 : outputSizes2) {
                    if (size3.getWidth() <= size2.getWidth() && size3.getHeight() <= size2.getHeight()) {
                        int height2 = z ? size3.getHeight() : size3.getWidth();
                        int width2 = z ? size3.getWidth() : size3.getHeight();
                        this.supportedVideoSizes.add(new com.otaliastudios.cameraview.size.Size(height2, width2));
                        this.supportedVideoAspectRatio.add(AspectRatio.of(height2, width2));
                    }
                }
                Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                if (rangeArr != null) {
                    this.previewFrameRateMinValue = Float.MAX_VALUE;
                    this.previewFrameRateMaxValue = -3.4028235E38f;
                    for (Range range2 : rangeArr) {
                        this.previewFrameRateMinValue = Math.min(this.previewFrameRateMinValue, (float) ((Integer) range2.getLower()).intValue());
                        this.previewFrameRateMaxValue = Math.max(this.previewFrameRateMaxValue, (float) ((Integer) range2.getUpper()).intValue());
                    }
                } else {
                    this.previewFrameRateMinValue = 0.0f;
                    this.previewFrameRateMaxValue = 0.0f;
                }
                this.supportedPictureFormats.add(PictureFormat.JPEG);
                int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
                if (iArr != null) {
                    for (int i6 : iArr) {
                        if (i6 == 3) {
                            this.supportedPictureFormats.add(PictureFormat.DNG);
                        }
                    }
                }
                this.supportedFrameProcessingFormats.add(35);
                int[] outputFormats2 = streamConfigurationMap.getOutputFormats();
                for (int i7 : outputFormats2) {
                    if (ImageFormat.getBitsPerPixel(i7) > 0) {
                        this.supportedFrameProcessingFormats.add(Integer.valueOf(i7));
                    }
                }
                return;
            }
            throw new IllegalStateException(a.M2("Picture format not supported: ", i));
        }
        throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
    }
}
