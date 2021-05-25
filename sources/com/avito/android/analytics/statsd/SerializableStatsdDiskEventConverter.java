package com.avito.android.analytics.statsd;

import com.avito.android.analytics.inhouse_transport.SerializableDiskConverter;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics/statsd/SerializableStatsdDiskEventConverter;", "Lcom/avito/android/analytics/inhouse_transport/SerializableDiskConverter;", "Lcom/avito/android/analytics/statsd/StatsdRecord;", "", AuthSource.SEND_ABUSE, "I", "getBinaryFormatVersion", "()I", "binaryFormatVersion", "<init>", "()V", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
public final class SerializableStatsdDiskEventConverter extends SerializableDiskConverter<StatsdRecord> {
    public final int a = 1;

    @Override // com.avito.android.analytics.inhouse_transport.DiskStorageConverter
    public int getBinaryFormatVersion() {
        return this.a;
    }
}
