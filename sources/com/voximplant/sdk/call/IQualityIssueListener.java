package com.voximplant.sdk.call;
public interface IQualityIssueListener {
    void onCodecMismatch(ICall iCall, QualityIssueLevel qualityIssueLevel, String str);

    void onHighMediaLatency(ICall iCall, QualityIssueLevel qualityIssueLevel, double d);

    void onIceDisconnected(ICall iCall, QualityIssueLevel qualityIssueLevel);

    void onLocalVideoDegradation(ICall iCall, QualityIssueLevel qualityIssueLevel, int i, int i2, int i3, int i4);

    void onLowBandwidth(ICall iCall, QualityIssueLevel qualityIssueLevel, double d, double d2);

    void onNoAudioSignal(ICall iCall, QualityIssueLevel qualityIssueLevel);

    void onPacketLoss(ICall iCall, QualityIssueLevel qualityIssueLevel, double d);
}
