package com.otaliastudios.cameraview.controls;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraUtils;
import com.otaliastudios.cameraview.R;
public class ControlParser {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    public ControlParser(@NonNull Context context, @NonNull TypedArray typedArray) {
        Facing facing;
        this.a = typedArray.getInteger(R.styleable.CameraView_cameraPreview, Preview.GL_SURFACE.a);
        int i2 = R.styleable.CameraView_cameraFacing;
        if (context == null) {
            facing = Facing.BACK;
        } else {
            Facing facing2 = Facing.BACK;
            if (!CameraUtils.hasCameraFacing(context, facing2)) {
                Facing facing3 = Facing.FRONT;
                if (CameraUtils.hasCameraFacing(context, facing3)) {
                    facing = facing3;
                }
            }
            facing = facing2;
        }
        this.b = typedArray.getInteger(i2, facing.a);
        this.c = typedArray.getInteger(R.styleable.CameraView_cameraFlash, Flash.OFF.a);
        this.d = typedArray.getInteger(R.styleable.CameraView_cameraGrid, Grid.OFF.a);
        this.e = typedArray.getInteger(R.styleable.CameraView_cameraWhiteBalance, WhiteBalance.AUTO.a);
        this.f = typedArray.getInteger(R.styleable.CameraView_cameraMode, Mode.PICTURE.a);
        this.g = typedArray.getInteger(R.styleable.CameraView_cameraHdr, Hdr.OFF.a);
        this.h = typedArray.getInteger(R.styleable.CameraView_cameraAudio, Audio.ON.a);
        this.i = typedArray.getInteger(R.styleable.CameraView_cameraVideoCodec, VideoCodec.DEVICE_DEFAULT.a);
        this.j = typedArray.getInteger(R.styleable.CameraView_cameraAudioCodec, AudioCodec.DEVICE_DEFAULT.a);
        this.k = typedArray.getInteger(R.styleable.CameraView_cameraEngine, Engine.CAMERA1.a);
        this.l = typedArray.getInteger(R.styleable.CameraView_cameraPictureFormat, PictureFormat.JPEG.a);
    }

    @NonNull
    public Audio getAudio() {
        int i2 = this.h;
        Audio[] values = Audio.values();
        for (int i3 = 0; i3 < 4; i3++) {
            Audio audio = values[i3];
            if (audio.a == i2) {
                return audio;
            }
        }
        return Audio.ON;
    }

    @NonNull
    public AudioCodec getAudioCodec() {
        int i2 = this.j;
        AudioCodec[] values = AudioCodec.values();
        for (int i3 = 0; i3 < 4; i3++) {
            AudioCodec audioCodec = values[i3];
            if (audioCodec.a == i2) {
                return audioCodec;
            }
        }
        return AudioCodec.DEVICE_DEFAULT;
    }

    @NonNull
    public Engine getEngine() {
        int i2 = this.k;
        Engine[] values = Engine.values();
        for (int i3 = 0; i3 < 2; i3++) {
            Engine engine = values[i3];
            if (engine.a == i2) {
                return engine;
            }
        }
        return Engine.CAMERA1;
    }

    @NonNull
    public Facing getFacing() {
        int i2 = this.b;
        Facing[] values = Facing.values();
        for (int i3 = 0; i3 < 2; i3++) {
            Facing facing = values[i3];
            if (facing.a == i2) {
                return facing;
            }
        }
        return null;
    }

    @NonNull
    public Flash getFlash() {
        int i2 = this.c;
        Flash[] values = Flash.values();
        for (int i3 = 0; i3 < 4; i3++) {
            Flash flash = values[i3];
            if (flash.a == i2) {
                return flash;
            }
        }
        return Flash.OFF;
    }

    @NonNull
    public Grid getGrid() {
        int i2 = this.d;
        Grid[] values = Grid.values();
        for (int i3 = 0; i3 < 4; i3++) {
            Grid grid = values[i3];
            if (grid.a == i2) {
                return grid;
            }
        }
        return Grid.OFF;
    }

    @NonNull
    public Hdr getHdr() {
        int i2 = this.g;
        Hdr[] values = Hdr.values();
        for (int i3 = 0; i3 < 2; i3++) {
            Hdr hdr = values[i3];
            if (hdr.a == i2) {
                return hdr;
            }
        }
        return Hdr.OFF;
    }

    @NonNull
    public Mode getMode() {
        int i2 = this.f;
        Mode[] values = Mode.values();
        for (int i3 = 0; i3 < 2; i3++) {
            Mode mode = values[i3];
            if (mode.a == i2) {
                return mode;
            }
        }
        return Mode.PICTURE;
    }

    @NonNull
    public PictureFormat getPictureFormat() {
        int i2 = this.l;
        PictureFormat[] values = PictureFormat.values();
        for (int i3 = 0; i3 < 2; i3++) {
            PictureFormat pictureFormat = values[i3];
            if (pictureFormat.a == i2) {
                return pictureFormat;
            }
        }
        return PictureFormat.JPEG;
    }

    @NonNull
    public Preview getPreview() {
        int i2 = this.a;
        Preview[] values = Preview.values();
        for (int i3 = 0; i3 < 3; i3++) {
            Preview preview = values[i3];
            if (preview.a == i2) {
                return preview;
            }
        }
        return Preview.GL_SURFACE;
    }

    @NonNull
    public VideoCodec getVideoCodec() {
        int i2 = this.i;
        VideoCodec[] values = VideoCodec.values();
        for (int i3 = 0; i3 < 3; i3++) {
            VideoCodec videoCodec = values[i3];
            if (videoCodec.a == i2) {
                return videoCodec;
            }
        }
        return VideoCodec.DEVICE_DEFAULT;
    }

    @NonNull
    public WhiteBalance getWhiteBalance() {
        int i2 = this.e;
        WhiteBalance[] values = WhiteBalance.values();
        for (int i3 = 0; i3 < 5; i3++) {
            WhiteBalance whiteBalance = values[i3];
            if (whiteBalance.a == i2) {
                return whiteBalance;
            }
        }
        return WhiteBalance.AUTO;
    }
}
