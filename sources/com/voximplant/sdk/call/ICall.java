package com.voximplant.sdk.call;

import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.voximplant.sdk.hardware.ICustomVideoSource;
import java.util.List;
import java.util.Map;
public interface ICall {
    void addCallListener(ICallListener iCallListener);

    void answer(CallSettings callSettings) throws CallException;

    long getCallDuration();

    String getCallId();

    Map<QualityIssue, QualityIssueLevel> getCurrentQualityIssues();

    List<IEndpoint> getEndpoints();

    List<IAudioStream> getLocalAudioStreams();

    List<IVideoStream> getLocalVideoStreams();

    void hangup(@Nullable Map<String, String> map);

    void hold(boolean z, @Nullable ICallCompletionHandler iCallCompletionHandler);

    boolean isVideoEnabled();

    void receiveVideo(@Nullable ICallCompletionHandler iCallCompletionHandler);

    void reject(RejectMode rejectMode, @Nullable Map<String, String> map) throws CallException;

    void removeCallListener(ICallListener iCallListener);

    void sendAudio(boolean z);

    void sendDTMF(String str);

    void sendInfo(String str, String str2, @Nullable Map<String, String> map);

    void sendMessage(String str);

    void sendVideo(boolean z, @Nullable ICallCompletionHandler iCallCompletionHandler);

    void setQualityIssueListener(IQualityIssueListener iQualityIssueListener);

    void start() throws CallException;

    @RequiresApi(api = 21)
    void startScreenSharing(Intent intent, @Nullable ICallCompletionHandler iCallCompletionHandler);

    void useCustomVideoSource(ICustomVideoSource iCustomVideoSource);
}
