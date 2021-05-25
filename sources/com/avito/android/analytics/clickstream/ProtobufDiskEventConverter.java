package com.avito.android.analytics.clickstream;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import proto.events.apps.EventOuterClass;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics/clickstream/ProtobufDiskEventConverter;", "Lcom/avito/android/analytics/clickstream/ProtobufDiskConverter;", "Lproto/events/apps/EventOuterClass$Event;", "", AuthSource.BOOKING_ORDER, "I", "getBinaryFormatVersion", "()I", "binaryFormatVersion", "<init>", "()V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public final class ProtobufDiskEventConverter extends ProtobufDiskConverter<EventOuterClass.Event> {
    public final int b = 2;

    /* JADX WARNING: Illegal instructions before constructor call */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ProtobufDiskEventConverter() {
        /*
            r2 = this;
            proto.events.apps.EventOuterClass$Event$Builder r0 = proto.events.apps.EventOuterClass.Event.newBuilder()
            java.lang.String r1 = "Event.newBuilder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r0)
            r0 = 2
            r2.b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.analytics.clickstream.ProtobufDiskEventConverter.<init>():void");
    }

    @Override // com.avito.android.analytics.inhouse_transport.DiskStorageConverter
    public int getBinaryFormatVersion() {
        return this.b;
    }
}
