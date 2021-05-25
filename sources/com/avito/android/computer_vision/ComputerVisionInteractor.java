package com.avito.android.computer_vision;

import android.net.Uri;
import com.avito.android.remote.model.ParamKeyValue;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H&¢\u0006\u0004\b\u0019\u0010\u0018J\u001b\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aH&¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "", "", "count", "", "setSuggestMaxImages", "(Ljava/lang/Integer;)V", "", "isEnabled", "enable", "(Z)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "processPhoto", "(Landroid/net/Uri;)V", "", "photoId", "updateIds", "(Ljava/lang/String;Landroid/net/Uri;)V", "removePhoto", "(Ljava/lang/String;)V", "reset", "()V", "needTimeToUploading", "()Z", "needRecognize", "Lio/reactivex/Observable;", "", "Lcom/avito/android/remote/model/ParamKeyValue;", "recognitionResults", "()Lio/reactivex/Observable;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface ComputerVisionInteractor {
    void enable(boolean z);

    boolean needRecognize();

    boolean needTimeToUploading();

    void processPhoto(@NotNull Uri uri);

    @NotNull
    Observable<List<ParamKeyValue>> recognitionResults();

    void removePhoto(@NotNull String str);

    void reset();

    void setSuggestMaxImages(@Nullable Integer num);

    void updateIds(@NotNull String str, @NotNull Uri uri);
}
