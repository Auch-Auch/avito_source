package com.avito.android.util;

import androidx.annotation.FontRes;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000f\u001a\u00020\n8\u0007@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/util/TypefaceType;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "", AuthSource.BOOKING_ORDER, "I", "getFontResId", "()I", "fontResId", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "Companion", "Bold", "Medium", "Regular", "android_release"}, k = 1, mv = {1, 4, 2})
public enum TypefaceType {
    Bold("avito_bold.ttf", R.font.avito_bold),
    Medium("avito_medium.ttf", R.font.avito_medium),
    Regular("avito_regular.ttf", R.font.avito_regular);
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    public final int b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/util/TypefaceType$Companion;", "", "", "name", "Lcom/avito/android/util/TypefaceType;", "fromString", "(Ljava/lang/String;)Lcom/avito/android/util/TypefaceType;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        @Nullable
        public final TypefaceType fromString(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            TypefaceType typefaceType = TypefaceType.Regular;
            if (Intrinsics.areEqual(str, typefaceType.getPath())) {
                return typefaceType;
            }
            TypefaceType typefaceType2 = TypefaceType.Medium;
            if (Intrinsics.areEqual(str, typefaceType2.getPath())) {
                return typefaceType2;
            }
            TypefaceType typefaceType3 = TypefaceType.Bold;
            if (Intrinsics.areEqual(str, typefaceType3.getPath())) {
                return typefaceType3;
            }
            return null;
        }

        public Companion(j jVar) {
        }
    }

    /* access modifiers changed from: public */
    TypefaceType(String str, int i) {
        this.a = str;
        this.b = i;
    }

    @JvmStatic
    @Nullable
    public static final TypefaceType fromString(@NotNull String str) {
        return Companion.fromString(str);
    }

    @Deprecated(message = "Use @FontRes parameter instead")
    public static /* synthetic */ void getPath$annotations() {
    }

    @FontRes
    public final int getFontResId() {
        return this.b;
    }

    @NotNull
    public final String getPath() {
        return this.a;
    }
}
