package com.otaliastudios.cameraview;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.AudioCodec;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.size.Size;
import java.io.File;
import java.io.FileDescriptor;
public class VideoResult {
    public static final int REASON_MAX_DURATION_REACHED = 2;
    public static final int REASON_MAX_SIZE_REACHED = 1;
    public static final int REASON_USER = 0;
    public final boolean a;
    public final Location b;
    public final int c;
    public final Size d;
    public final File e;
    public final FileDescriptor f;
    public final Facing g;
    public final VideoCodec h;
    public final AudioCodec i;
    public final Audio j;
    public final long k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;

    public static class Stub {
        public Audio audio;
        public int audioBitRate;
        public AudioCodec audioCodec;
        public int endReason;
        public Facing facing;
        public File file;
        public FileDescriptor fileDescriptor;
        public boolean isSnapshot;
        public Location location;
        public int maxDuration;
        public long maxSize;
        public int rotation;
        public Size size;
        public int videoBitRate;
        public VideoCodec videoCodec;
        public int videoFrameRate;
    }

    public VideoResult(@NonNull Stub stub) {
        this.a = stub.isSnapshot;
        this.b = stub.location;
        this.c = stub.rotation;
        this.d = stub.size;
        this.e = stub.file;
        this.f = stub.fileDescriptor;
        this.g = stub.facing;
        this.h = stub.videoCodec;
        this.i = stub.audioCodec;
        this.j = stub.audio;
        this.k = stub.maxSize;
        this.l = stub.maxDuration;
        this.m = stub.endReason;
        this.n = stub.videoBitRate;
        this.o = stub.videoFrameRate;
        this.p = stub.audioBitRate;
    }

    @NonNull
    public Audio getAudio() {
        return this.j;
    }

    public int getAudioBitRate() {
        return this.p;
    }

    @NonNull
    public AudioCodec getAudioCodec() {
        return this.i;
    }

    @NonNull
    public Facing getFacing() {
        return this.g;
    }

    @NonNull
    public File getFile() {
        File file = this.e;
        if (file != null) {
            return file;
        }
        throw new RuntimeException("File is only available when takeVideo(File) is used.");
    }

    @NonNull
    public FileDescriptor getFileDescriptor() {
        FileDescriptor fileDescriptor = this.f;
        if (fileDescriptor != null) {
            return fileDescriptor;
        }
        throw new RuntimeException("FileDescriptor is only available when takeVideo(FileDescriptor) is used.");
    }

    @Nullable
    public Location getLocation() {
        return this.b;
    }

    public int getMaxDuration() {
        return this.l;
    }

    public long getMaxSize() {
        return this.k;
    }

    public int getRotation() {
        return this.c;
    }

    @NonNull
    public Size getSize() {
        return this.d;
    }

    public int getTerminationReason() {
        return this.m;
    }

    public int getVideoBitRate() {
        return this.n;
    }

    @NonNull
    public VideoCodec getVideoCodec() {
        return this.h;
    }

    public int getVideoFrameRate() {
        return this.o;
    }

    public boolean isSnapshot() {
        return this.a;
    }
}
