package ru.avito.android.persistence.messenger;

import androidx.annotation.Keep;
import androidx.room.TypeConverter;
import com.avito.android.payment.SberbankOnlineKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lru/avito/android/persistence/messenger/TransferStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Converter", "NONE", "IN_PROGRESS", "ERROR", SberbankOnlineKt.RESULT_SUCCESS, "messenger_release"}, k = 1, mv = {1, 4, 2})
public enum TransferStatus {
    NONE,
    IN_PROGRESS,
    ERROR,
    SUCCESS;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lru/avito/android/persistence/messenger/TransferStatus$Converter;", "", "Lru/avito/android/persistence/messenger/TransferStatus;", "transferStatus", "", "transferStatusToString", "(Lru/avito/android/persistence/messenger/TransferStatus;)Ljava/lang/String;", "transferStatusStr", "stringToTransferStatus", "(Ljava/lang/String;)Lru/avito/android/persistence/messenger/TransferStatus;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Converter {
        @NotNull
        public static final Converter INSTANCE = new Converter();

        @JvmStatic
        @TypeConverter
        @NotNull
        public static final TransferStatus stringToTransferStatus(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "transferStatusStr");
            return TransferStatus.valueOf(str);
        }

        @JvmStatic
        @TypeConverter
        @NotNull
        public static final String transferStatusToString(@NotNull TransferStatus transferStatus) {
            Intrinsics.checkNotNullParameter(transferStatus, "transferStatus");
            return transferStatus.name();
        }
    }
}
