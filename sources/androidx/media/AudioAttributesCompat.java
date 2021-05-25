package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import l6.q.a;
public class AudioAttributesCompat implements VersionedParcelable {
    public static final int CONTENT_TYPE_MOVIE = 3;
    public static final int CONTENT_TYPE_MUSIC = 2;
    public static final int CONTENT_TYPE_SONIFICATION = 4;
    public static final int CONTENT_TYPE_SPEECH = 1;
    public static final int CONTENT_TYPE_UNKNOWN = 0;
    public static final int FLAG_AUDIBILITY_ENFORCED = 1;
    public static final int FLAG_HW_AV_SYNC = 16;
    public static final int USAGE_ALARM = 4;
    public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
    public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
    public static final int USAGE_ASSISTANT = 16;
    public static final int USAGE_GAME = 14;
    public static final int USAGE_MEDIA = 1;
    public static final int USAGE_NOTIFICATION = 5;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
    public static final int USAGE_NOTIFICATION_EVENT = 10;
    public static final int USAGE_NOTIFICATION_RINGTONE = 6;
    public static final int USAGE_UNKNOWN = 0;
    public static final int USAGE_VOICE_COMMUNICATION = 2;
    public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;
    public static final SparseIntArray a;
    public static boolean b;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public a mImpl;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AttributeContentType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AttributeUsage {
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        a = sparseIntArray;
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    public AudioAttributesCompat() {
    }

    public static int a(boolean z, int i, int i2) {
        if ((i & 1) == 1) {
            return z ? 1 : 7;
        }
        if ((i & 4) == 4) {
            return z ? 0 : 6;
        }
        switch (i2) {
            case 0:
                return z ? Integer.MIN_VALUE : 3;
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return z ? 0 : 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            case 15:
            default:
                if (!z) {
                    return 3;
                }
                throw new IllegalArgumentException(a2.b.a.a.a.Q2("Unknown usage value ", i2, " in audio attributes"));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static AudioAttributesCompat fromBundle(Bundle bundle) {
        a fromBundle = AudioAttributesImplApi21.fromBundle(bundle);
        if (fromBundle == null) {
            return null;
        }
        return new AudioAttributesCompat(fromBundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setForceLegacyBehavior(boolean z) {
        b = z;
    }

    @Nullable
    public static AudioAttributesCompat wrap(@NonNull Object obj) {
        if (b) {
            return null;
        }
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21((AudioAttributes) obj);
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.mImpl = audioAttributesImplApi21;
        return audioAttributesCompat;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        a aVar = this.mImpl;
        if (aVar != null) {
            return aVar.equals(audioAttributesCompat.mImpl);
        }
        if (audioAttributesCompat.mImpl == null) {
            return true;
        }
        return false;
    }

    public int getContentType() {
        return this.mImpl.getContentType();
    }

    public int getFlags() {
        return this.mImpl.getFlags();
    }

    public int getLegacyStreamType() {
        return this.mImpl.getLegacyStreamType();
    }

    public int getUsage() {
        return this.mImpl.getUsage();
    }

    public int getVolumeControlStream() {
        return this.mImpl.getVolumeControlStream();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Bundle toBundle() {
        return this.mImpl.toBundle();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.getAudioAttributes();
    }

    public AudioAttributesCompat(a aVar) {
        this.mImpl = aVar;
    }

    public static class Builder {
        public int a = 0;
        public int b = 0;
        public int c = 0;
        public int d = -1;

        public Builder() {
        }

        public AudioAttributesCompat build() {
            a aVar;
            if (!AudioAttributesCompat.b) {
                AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.b).setFlags(this.c).setUsage(this.a);
                int i = this.d;
                if (i != -1) {
                    usage.setLegacyStreamType(i);
                }
                aVar = new AudioAttributesImplApi21(usage.build(), this.d);
            } else {
                aVar = new AudioAttributesImplBase(this.b, this.c, this.a, this.d);
            }
            return new AudioAttributesCompat(aVar);
        }

        public Builder setContentType(int i) {
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
                this.b = i;
            } else {
                this.a = 0;
            }
            return this;
        }

        public Builder setFlags(int i) {
            this.c = (i & 1023) | this.c;
            return this;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public Builder setLegacyStreamType(int i) {
            if (i != 10) {
                this.d = i;
                int i2 = 2;
                switch (i) {
                    case 0:
                        this.b = 1;
                        break;
                    case 1:
                        this.b = 4;
                        break;
                    case 2:
                        this.b = 4;
                        break;
                    case 3:
                        this.b = 2;
                        break;
                    case 4:
                        this.b = 4;
                        break;
                    case 5:
                        this.b = 4;
                        break;
                    case 6:
                        this.b = 1;
                        this.c |= 4;
                        break;
                    case 7:
                        this.c |= 1;
                        this.b = 4;
                        break;
                    case 8:
                        this.b = 4;
                        break;
                    case 9:
                        this.b = 4;
                        break;
                    case 10:
                        this.b = 1;
                        break;
                }
                int i3 = AudioAttributesCompat.CONTENT_TYPE_UNKNOWN;
                switch (i) {
                    case 0:
                    case 6:
                        break;
                    case 1:
                    case 7:
                        i2 = 13;
                        break;
                    case 2:
                        i2 = 6;
                        break;
                    case 3:
                        i2 = 1;
                        break;
                    case 4:
                        i2 = 4;
                        break;
                    case 5:
                        i2 = 5;
                        break;
                    case 8:
                        i2 = 3;
                        break;
                    case 9:
                    default:
                        i2 = 0;
                        break;
                    case 10:
                        i2 = 11;
                        break;
                }
                this.a = i2;
                return this;
            }
            throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        }

        public Builder setUsage(int i) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    this.a = i;
                    break;
                case 16:
                    if (!AudioAttributesCompat.b && Build.VERSION.SDK_INT > 25) {
                        this.a = i;
                        break;
                    } else {
                        this.a = 12;
                        break;
                    }
                default:
                    this.a = 0;
                    break;
            }
            return this;
        }

        public Builder(AudioAttributesCompat audioAttributesCompat) {
            this.a = audioAttributesCompat.getUsage();
            this.b = audioAttributesCompat.getContentType();
            this.c = audioAttributesCompat.getFlags();
            this.d = audioAttributesCompat.mImpl.getRawLegacyStreamType();
        }
    }
}
