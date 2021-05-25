package com.avito.android.analytics.clickstream;

import a2.a.a.i.d.b;
import a2.a.a.i.d.c;
import a2.a.a.i.d.d;
import a2.g.r.g;
import com.avito.android.analytics.clickstream.ClickStreamSender;
import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.facebook.internal.ServerProtocol;
import com.google.protobuf.GeneratedMessageLite;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import proto.events.apps.BatchOuterClass;
import proto.events.apps.EventOuterClass;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0016\u0010&\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0019¨\u0006+"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamSenderImpl;", "Lcom/avito/android/analytics/clickstream/ClickStreamSender;", "Lio/reactivex/Single;", "Lcom/avito/android/analytics/clickstream/ClickStreamSender$UploadResult;", "send", "()Lio/reactivex/Single;", "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "Lproto/events/apps/EventOuterClass$Event;", "f", "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "storage", "Lcom/avito/android/util/BuildInfo;", "i", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/clickstream/ClickStreamApi;", "e", "Lcom/avito/android/analytics/clickstream/ClickStreamApi;", "api", "Lcom/avito/android/analytics/clickstream/ClickStreamSender$CommonParametersProvider;", "h", "Lcom/avito/android/analytics/clickstream/ClickStreamSender$CommonParametersProvider;", "commonParametersProvider", "", "d", "Ljava/lang/String;", "srcId", "Lcom/avito/android/util/SchedulersFactory;", g.a, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/analytics/clickstream/FieldConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/clickstream/FieldConverter;", "fieldConverter", AuthSource.SEND_ABUSE, "runId", "c", "buildUid", "Lcom/avito/android/remote/DeviceIdProvider;", "deviceIdProvider", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/DeviceIdProvider;Lcom/avito/android/analytics/clickstream/ClickStreamApi;Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/clickstream/ClickStreamSender$CommonParametersProvider;Lcom/avito/android/util/BuildInfo;)V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public final class ClickStreamSenderImpl implements ClickStreamSender {
    public final String a = a2.b.a.a.a.I2("UUID.randomUUID().toString()");
    public final FieldConverter b = new FieldConverter(new AnalyticMetricsFormatter());
    public final String c;
    public final String d;
    public final ClickStreamApi e;
    public final InHouseEventStorage<EventOuterClass.Event> f;
    public final SchedulersFactory g;
    public final ClickStreamSender.CommonParametersProvider h;
    public final BuildInfo i;

    public static final class a<T, R> implements Function<List<? extends EventOuterClass.Event>, SingleSource<? extends ClickStreamSender.UploadResult>> {
        public final /* synthetic */ ClickStreamSenderImpl a;

        public a(ClickStreamSenderImpl clickStreamSenderImpl) {
            this.a = clickStreamSenderImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ClickStreamSender.UploadResult> apply(List<? extends EventOuterClass.Event> list) {
            List<? extends EventOuterClass.Event> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "events");
            return ClickStreamSenderImpl.access$uploadEvents(this.a, list2).doOnSuccess(new b(this, list2));
        }
    }

    public ClickStreamSenderImpl(@NotNull String str, @NotNull DeviceIdProvider deviceIdProvider, @NotNull ClickStreamApi clickStreamApi, @NotNull InHouseEventStorage<EventOuterClass.Event> inHouseEventStorage, @NotNull SchedulersFactory schedulersFactory, @NotNull ClickStreamSender.CommonParametersProvider commonParametersProvider, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(str, "srcId");
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(clickStreamApi, "api");
        Intrinsics.checkNotNullParameter(inHouseEventStorage, "storage");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(commonParametersProvider, "commonParametersProvider");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.d = str;
        this.e = clickStreamApi;
        this.f = inHouseEventStorage;
        this.g = schedulersFactory;
        this.h = commonParametersProvider;
        this.i = buildInfo;
        this.c = deviceIdProvider.getValue();
    }

    public static final void access$handleUploadResult(ClickStreamSenderImpl clickStreamSenderImpl, ClickStreamSender.UploadResult uploadResult, List list) {
        Objects.requireNonNull(clickStreamSenderImpl);
        if (uploadResult instanceof ClickStreamSender.UploadResult.RecoverableError) {
            clickStreamSenderImpl.f.addAll(list);
        }
    }

    public static final Single access$uploadEvents(ClickStreamSenderImpl clickStreamSenderImpl, List list) {
        Objects.requireNonNull(clickStreamSenderImpl);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((EventOuterClass.Event) it.next()).getEventId()));
        }
        if (list.isEmpty()) {
            return Singles.toSingle(new ClickStreamSender.UploadResult.Success(arrayList));
        }
        GeneratedMessageLite build = BatchOuterClass.Envelope.newBuilder().setVersion(1).putMeta(ServerProtocol.DIALOG_PARAM_SDK_VERSION, "android/0.0.0").putMeta("build_uid", clickStreamSenderImpl.c).putMeta("src_id", clickStreamSenderImpl.d).putMeta("software_version", clickStreamSenderImpl.i.getVersionName()).putMeta("build", String.valueOf(clickStreamSenderImpl.i.getVersionCode())).putAllCommon(clickStreamSenderImpl.b.convertFields(clickStreamSenderImpl.h.parameters())).putCommon("src_id", clickStreamSenderImpl.d).putCommon("software_version", clickStreamSenderImpl.i.getVersionName()).putCommon("build", String.valueOf(clickStreamSenderImpl.i.getVersionCode())).putCommon("run_id", clickStreamSenderImpl.a).addAllEvents(list).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …nts)\n            .build()");
        Single<R> onErrorReturn = clickStreamSenderImpl.e.sendEvents((BatchOuterClass.Envelope) build).subscribeOn(clickStreamSenderImpl.g.io()).map(new c(arrayList)).onErrorReturn(d.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.sendEvents(envelope)…          }\n            }");
        return onErrorReturn;
    }

    @Override // com.avito.android.analytics.clickstream.ClickStreamSender
    @NotNull
    public Single<ClickStreamSender.UploadResult> send() {
        StringBuilder L = a2.b.a.a.a.L("Send events: uid=");
        L.append(this.c);
        Logs.verbose$default(ClickStreamEventTrackerKt.CS_LOG_TAG, L.toString(), null, 4, null);
        Single fromCallable = Single.fromCallable(new a2.a.a.i.d.a(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …torage.extractAll()\n    }");
        return a2.b.a.a.a.V1(this.g, fromCallable.flatMap(new a(this)), "extractEvents()\n        …scribeOn(schedulers.io())");
    }
}
