package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import l6.q.a;
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AudioAttributesImplApi21 implements a {
    public static Method a;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public AudioAttributes mAudioAttributes;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int mLegacyStreamType = -1;

    public AudioAttributesImplApi21() {
    }

    public static a fromBundle(Bundle bundle) {
        AudioAttributes audioAttributes;
        if (bundle == null || (audioAttributes = (AudioAttributes) bundle.getParcelable("androidx.media.audio_attrs.FRAMEWORKS")) == null) {
            return null;
        }
        return new AudioAttributesImplApi21(audioAttributes, bundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.mAudioAttributes.equals(((AudioAttributesImplApi21) obj).mAudioAttributes);
    }

    @Override // l6.q.a
    public Object getAudioAttributes() {
        return this.mAudioAttributes;
    }

    @Override // l6.q.a
    public int getContentType() {
        return this.mAudioAttributes.getContentType();
    }

    @Override // l6.q.a
    public int getFlags() {
        return this.mAudioAttributes.getFlags();
    }

    @Override // l6.q.a
    public int getLegacyStreamType() {
        Method method;
        int i = this.mLegacyStreamType;
        if (i != -1) {
            return i;
        }
        try {
            if (a == null) {
                a = AudioAttributes.class.getMethod("toLegacyStreamType", AudioAttributes.class);
            }
            method = a;
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method == null) {
            return -1;
        }
        try {
            return ((Integer) method.invoke(null, this.mAudioAttributes)).intValue();
        } catch (IllegalAccessException | InvocationTargetException unused2) {
            return -1;
        }
    }

    @Override // l6.q.a
    public int getRawLegacyStreamType() {
        return this.mLegacyStreamType;
    }

    @Override // l6.q.a
    public int getUsage() {
        return this.mAudioAttributes.getUsage();
    }

    @Override // l6.q.a
    public int getVolumeControlStream() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mAudioAttributes.getVolumeControlStream();
        }
        return AudioAttributesCompat.a(true, getFlags(), getUsage());
    }

    public int hashCode() {
        return this.mAudioAttributes.hashCode();
    }

    @Override // l6.q.a
    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("androidx.media.audio_attrs.FRAMEWORKS", this.mAudioAttributes);
        int i = this.mLegacyStreamType;
        if (i != -1) {
            bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i);
        }
        return bundle;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("AudioAttributesCompat: audioattributes=");
        L.append(this.mAudioAttributes);
        return L.toString();
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this.mAudioAttributes = audioAttributes;
        this.mLegacyStreamType = -1;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes, int i) {
        this.mAudioAttributes = audioAttributes;
        this.mLegacyStreamType = i;
    }
}
