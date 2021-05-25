package com.otaliastudios.cameraview.video;

import android.location.Location;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.VideoResult;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.AudioCodec;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.internal.DeviceEncoders;
import com.otaliastudios.cameraview.size.Size;
import com.otaliastudios.cameraview.video.VideoRecorder;
import java.io.File;
import java.io.FileDescriptor;
public abstract class FullVideoRecorder extends VideoRecorder {
    public static final CameraLogger LOG = CameraLogger.create(FullVideoRecorder.class.getSimpleName());
    public CamcorderProfile f;
    public boolean g;
    public MediaRecorder mMediaRecorder;

    public class a implements MediaRecorder.OnInfoListener {
        public a() {
        }

        @Override // android.media.MediaRecorder.OnInfoListener
        public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
            boolean z;
            CameraLogger cameraLogger = FullVideoRecorder.LOG;
            cameraLogger.i("OnInfoListener:", "Received info", Integer.valueOf(i), Integer.valueOf(i2), "Thread: ", Thread.currentThread());
            switch (i) {
                case 800:
                    FullVideoRecorder.this.a.endReason = 2;
                    z = true;
                    break;
                case 801:
                case 802:
                    FullVideoRecorder.this.a.endReason = 1;
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                cameraLogger.i("OnInfoListener:", "Stopping");
                FullVideoRecorder.this.stop(false);
            }
        }
    }

    public class b implements MediaRecorder.OnErrorListener {
        public b() {
        }

        @Override // android.media.MediaRecorder.OnErrorListener
        public void onError(MediaRecorder mediaRecorder, int i, int i2) {
            CameraLogger cameraLogger = FullVideoRecorder.LOG;
            cameraLogger.e("OnErrorListener: got error", Integer.valueOf(i), Integer.valueOf(i2), ". Stopping.");
            FullVideoRecorder fullVideoRecorder = FullVideoRecorder.this;
            fullVideoRecorder.a = null;
            fullVideoRecorder.mError = new RuntimeException(a2.b.a.a.a.R2("MediaRecorder error: ", i, " ", i2));
            cameraLogger.i("OnErrorListener:", "Stopping");
            FullVideoRecorder.this.stop(false);
        }
    }

    public FullVideoRecorder(@Nullable VideoRecorder.VideoResultListener videoResultListener) {
        super(videoResultListener);
    }

    public final boolean a(@NonNull VideoResult.Stub stub, boolean z) {
        int i;
        DeviceEncoders.VideoException e;
        DeviceEncoders.AudioException e2;
        int supportedVideoFrameRate;
        char c = 2;
        LOG.i("prepareMediaRecorder:", "Preparing on thread", Thread.currentThread());
        this.mMediaRecorder = new MediaRecorder();
        this.f = getCamcorderProfile(stub);
        applyVideoSource(stub, this.mMediaRecorder);
        Audio audio = stub.audio;
        if (audio == Audio.ON) {
            i = this.f.audioChannels;
        } else if (audio == Audio.MONO) {
            i = 1;
        } else {
            i = audio == Audio.STEREO ? 2 : 0;
        }
        boolean z2 = i > 0;
        if (z2) {
            this.mMediaRecorder.setAudioSource(0);
        }
        VideoCodec videoCodec = stub.videoCodec;
        if (videoCodec == VideoCodec.H_264) {
            CamcorderProfile camcorderProfile = this.f;
            camcorderProfile.videoCodec = 2;
            camcorderProfile.fileFormat = 2;
        } else if (videoCodec == VideoCodec.H_263) {
            CamcorderProfile camcorderProfile2 = this.f;
            camcorderProfile2.videoCodec = 1;
            camcorderProfile2.fileFormat = 2;
        }
        AudioCodec audioCodec = stub.audioCodec;
        char c2 = 4;
        if (audioCodec == AudioCodec.AAC) {
            this.f.audioCodec = 3;
        } else if (audioCodec == AudioCodec.HE_AAC) {
            this.f.audioCodec = 4;
        } else if (audioCodec == AudioCodec.AAC_ELD) {
            this.f.audioCodec = 5;
        }
        this.mMediaRecorder.setOutputFormat(this.f.fileFormat);
        if (stub.videoFrameRate <= 0) {
            stub.videoFrameRate = this.f.videoFrameRate;
        }
        if (stub.videoBitRate <= 0) {
            stub.videoBitRate = this.f.videoBitRate;
        }
        if (stub.audioBitRate <= 0 && z2) {
            stub.audioBitRate = this.f.audioBitRate;
        }
        if (z) {
            CamcorderProfile camcorderProfile3 = this.f;
            int i2 = camcorderProfile3.audioCodec;
            String str = MimeTypes.AUDIO_AMR_NB;
            switch (i2) {
                case 2:
                    str = MimeTypes.AUDIO_AMR_WB;
                    break;
                case 3:
                case 4:
                case 5:
                    str = MimeTypes.AUDIO_AAC;
                    break;
                case 6:
                    str = MimeTypes.AUDIO_VORBIS;
                    break;
            }
            int i3 = camcorderProfile3.videoCodec;
            String str2 = MimeTypes.VIDEO_H264;
            if (i3 == 1) {
                str2 = MimeTypes.VIDEO_H263;
            } else if (i3 != 2) {
                if (i3 == 3) {
                    str2 = MimeTypes.VIDEO_MP4V;
                } else if (i3 == 4) {
                    str2 = MimeTypes.VIDEO_VP8;
                } else if (i3 == 5) {
                    str2 = MimeTypes.VIDEO_H265;
                }
            }
            boolean z3 = stub.rotation % 180 != 0;
            if (z3) {
                stub.size = stub.size.flip();
            }
            int i4 = 0;
            Size size = null;
            boolean z4 = false;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (!z4) {
                CameraLogger cameraLogger = LOG;
                Object[] objArr = new Object[6];
                objArr[0] = "prepareMediaRecorder:";
                objArr[1] = "Checking DeviceEncoders...";
                objArr[c] = "videoOffset:";
                objArr[3] = Integer.valueOf(i7);
                objArr[c2] = "audioOffset:";
                objArr[5] = Integer.valueOf(i8);
                cameraLogger.i(objArr);
                try {
                    DeviceEncoders deviceEncoders = new DeviceEncoders(0, str2, str, i7, i8);
                    try {
                        size = deviceEncoders.getSupportedVideoSize(stub.size);
                        try {
                            i4 = deviceEncoders.getSupportedVideoBitRate(stub.videoBitRate);
                            supportedVideoFrameRate = deviceEncoders.getSupportedVideoFrameRate(size, stub.videoFrameRate);
                        } catch (DeviceEncoders.VideoException e3) {
                            e = e3;
                            LOG.i("prepareMediaRecorder:", "Got VideoException:", e.getMessage());
                            i7++;
                            c = 2;
                            c2 = 4;
                        } catch (DeviceEncoders.AudioException e4) {
                            e2 = e4;
                            LOG.i("prepareMediaRecorder:", "Got AudioException:", e2.getMessage());
                            i8++;
                            c = 2;
                            c2 = 4;
                        }
                        try {
                            deviceEncoders.tryConfigureVideo(str2, size, supportedVideoFrameRate, i4);
                            if (z2) {
                                int supportedAudioBitRate = deviceEncoders.getSupportedAudioBitRate(stub.audioBitRate);
                                try {
                                    deviceEncoders.tryConfigureAudio(str, supportedAudioBitRate, this.f.audioSampleRate, i);
                                    i5 = supportedAudioBitRate;
                                } catch (DeviceEncoders.VideoException e5) {
                                    e = e5;
                                    i6 = supportedVideoFrameRate;
                                    i5 = supportedAudioBitRate;
                                    LOG.i("prepareMediaRecorder:", "Got VideoException:", e.getMessage());
                                    i7++;
                                    c = 2;
                                    c2 = 4;
                                } catch (DeviceEncoders.AudioException e6) {
                                    e2 = e6;
                                    i6 = supportedVideoFrameRate;
                                    i5 = supportedAudioBitRate;
                                    LOG.i("prepareMediaRecorder:", "Got AudioException:", e2.getMessage());
                                    i8++;
                                    c = 2;
                                    c2 = 4;
                                }
                            }
                            i6 = supportedVideoFrameRate;
                            z4 = true;
                        } catch (DeviceEncoders.VideoException e7) {
                            e = e7;
                            i6 = supportedVideoFrameRate;
                            LOG.i("prepareMediaRecorder:", "Got VideoException:", e.getMessage());
                            i7++;
                            c = 2;
                            c2 = 4;
                        } catch (DeviceEncoders.AudioException e8) {
                            e2 = e8;
                            i6 = supportedVideoFrameRate;
                            LOG.i("prepareMediaRecorder:", "Got AudioException:", e2.getMessage());
                            i8++;
                            c = 2;
                            c2 = 4;
                        }
                    } catch (DeviceEncoders.VideoException e9) {
                        e = e9;
                        size = size;
                        LOG.i("prepareMediaRecorder:", "Got VideoException:", e.getMessage());
                        i7++;
                        c = 2;
                        c2 = 4;
                    } catch (DeviceEncoders.AudioException e10) {
                        e2 = e10;
                        size = size;
                        LOG.i("prepareMediaRecorder:", "Got AudioException:", e2.getMessage());
                        i8++;
                        c = 2;
                        c2 = 4;
                    }
                    c = 2;
                    c2 = 4;
                } catch (RuntimeException unused) {
                    LOG.w("prepareMediaRecorder:", "Could not respect encoders parameters.", "Trying again without checking encoders.");
                    return a(stub, false);
                }
            }
            stub.size = size;
            stub.videoBitRate = i4;
            stub.audioBitRate = i5;
            stub.videoFrameRate = i6;
            if (z3) {
                stub.size = size.flip();
            }
        }
        boolean z5 = stub.rotation % 180 != 0;
        this.mMediaRecorder.setVideoSize(z5 ? stub.size.getHeight() : stub.size.getWidth(), z5 ? stub.size.getWidth() : stub.size.getHeight());
        this.mMediaRecorder.setVideoFrameRate(stub.videoFrameRate);
        this.mMediaRecorder.setVideoEncoder(this.f.videoCodec);
        this.mMediaRecorder.setVideoEncodingBitRate(stub.videoBitRate);
        if (z2) {
            this.mMediaRecorder.setAudioChannels(i);
            this.mMediaRecorder.setAudioSamplingRate(this.f.audioSampleRate);
            this.mMediaRecorder.setAudioEncoder(this.f.audioCodec);
            this.mMediaRecorder.setAudioEncodingBitRate(stub.audioBitRate);
        }
        Location location = stub.location;
        if (location != null) {
            this.mMediaRecorder.setLocation((float) location.getLatitude(), (float) stub.location.getLongitude());
        }
        File file = stub.file;
        if (file != null) {
            this.mMediaRecorder.setOutputFile(file.getAbsolutePath());
        } else {
            FileDescriptor fileDescriptor = stub.fileDescriptor;
            if (fileDescriptor != null) {
                this.mMediaRecorder.setOutputFile(fileDescriptor);
            } else {
                throw new IllegalStateException("file and fileDescriptor are both null.");
            }
        }
        this.mMediaRecorder.setOrientationHint(stub.rotation);
        MediaRecorder mediaRecorder = this.mMediaRecorder;
        long j = stub.maxSize;
        if (j > 0) {
            j = Math.round(((double) j) / 0.9d);
        }
        mediaRecorder.setMaxFileSize(j);
        LOG.i("prepareMediaRecorder:", "Increased max size from", Long.valueOf(stub.maxSize), "to", Long.valueOf(Math.round(((double) stub.maxSize) / 0.9d)));
        this.mMediaRecorder.setMaxDuration(stub.maxDuration);
        this.mMediaRecorder.setOnInfoListener(new a());
        this.mMediaRecorder.setOnErrorListener(new b());
        try {
            this.mMediaRecorder.prepare();
            this.g = true;
            this.mError = null;
            return true;
        } catch (Exception e11) {
            LOG.w("prepareMediaRecorder:", "Error while preparing media recorder.", e11);
            this.g = false;
            this.mError = e11;
            return false;
        }
    }

    public abstract void applyVideoSource(@NonNull VideoResult.Stub stub, @NonNull MediaRecorder mediaRecorder);

    @NonNull
    public abstract CamcorderProfile getCamcorderProfile(@NonNull VideoResult.Stub stub);

    @Override // com.otaliastudios.cameraview.video.VideoRecorder
    public void onStart() {
        if (!prepareMediaRecorder(this.a)) {
            this.a = null;
            stop(false);
            return;
        }
        try {
            this.mMediaRecorder.start();
            dispatchVideoRecordingStart();
        } catch (Exception e) {
            LOG.w("start:", "Error while starting media recorder.", e);
            this.a = null;
            this.mError = e;
            stop(false);
        }
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder
    public void onStop(boolean z) {
        if (this.mMediaRecorder != null) {
            dispatchVideoRecordingEnd();
            try {
                CameraLogger cameraLogger = LOG;
                cameraLogger.i("stop:", "Stopping MediaRecorder...");
                this.mMediaRecorder.stop();
                cameraLogger.i("stop:", "Stopped MediaRecorder.");
            } catch (Exception e) {
                this.a = null;
                if (this.mError == null) {
                    LOG.w("stop:", "Error while closing media recorder.", e);
                    this.mError = e;
                }
            }
            try {
                CameraLogger cameraLogger2 = LOG;
                cameraLogger2.i("stop:", "Releasing MediaRecorder...");
                this.mMediaRecorder.release();
                cameraLogger2.i("stop:", "Released MediaRecorder.");
            } catch (Exception e2) {
                this.a = null;
                if (this.mError == null) {
                    LOG.w("stop:", "Error while releasing media recorder.", e2);
                    this.mError = e2;
                }
            }
        }
        this.f = null;
        this.mMediaRecorder = null;
        this.g = false;
        dispatchResult();
    }

    public final boolean prepareMediaRecorder(@NonNull VideoResult.Stub stub) {
        if (this.g) {
            return true;
        }
        return a(stub, true);
    }
}
