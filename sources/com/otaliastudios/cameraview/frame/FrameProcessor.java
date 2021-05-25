package com.otaliastudios.cameraview.frame;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
public interface FrameProcessor {
    @WorkerThread
    void process(@NonNull Frame frame);
}
