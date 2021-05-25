package com.google.android.gms.vision.face;

import com.google.android.apps.common.proguard.UsedByNative;
@UsedByNative("wrapper.cc")
public class NativeFaceSettings {
    public boolean classifyEyesOpen;
    public boolean classifySmiling;
    public float confidenceThreshold;
    public int detectionType;
    public int fastDetectorAggressiveness;
    public int landmarkType;
    public int maxNumFaces;
    public int numThreads;
    public float proportionalMinFaceSize;
    public boolean trackingEnabled;
}
