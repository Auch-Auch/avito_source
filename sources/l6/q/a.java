package l6.q;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.versionedparcelable.VersionedParcelable;
public interface a extends VersionedParcelable {
    Object getAudioAttributes();

    int getContentType();

    int getFlags();

    int getLegacyStreamType();

    int getRawLegacyStreamType();

    int getUsage();

    int getVolumeControlStream();

    @NonNull
    Bundle toBundle();
}
