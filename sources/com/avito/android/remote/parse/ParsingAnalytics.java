package com.avito.android.remote.parse;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.parse.adapter.stream_gson.StreamParsing;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/parse/ParsingAnalytics;", "", "Ljava/lang/reflect/Type;", "type", "", "elapsed", "", "send", "(Ljava/lang/reflect/Type;J)V", "Impl", "api_release"}, k = 1, mv = {1, 4, 2})
public interface ParsingAnalytics {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/parse/ParsingAnalytics$Impl;", "Lcom/avito/android/remote/parse/ParsingAnalytics;", "Ljava/lang/reflect/Type;", "type", "", "elapsed", "", "send", "(Ljava/lang/reflect/Type;J)V", "", "", "d", "[Ljava/lang/annotation/Annotation;", "annotations", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "graphitePrefix", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/grafana/GraphitePrefix;Lcom/avito/android/Features;[Ljava/lang/annotation/Annotation;)V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements ParsingAnalytics {
        public final Analytics a;
        public final GraphitePrefix b;
        public final Features c;
        public final Annotation[] d;

        public Impl(@NotNull Analytics analytics, @NotNull GraphitePrefix graphitePrefix, @NotNull Features features, @NotNull Annotation[] annotationArr) {
            Intrinsics.checkNotNullParameter(analytics, "analytics");
            Intrinsics.checkNotNullParameter(graphitePrefix, "graphitePrefix");
            Intrinsics.checkNotNullParameter(features, "features");
            Intrinsics.checkNotNullParameter(annotationArr, "annotations");
            this.a = analytics;
            this.b = graphitePrefix;
            this.c = features;
            this.d = annotationArr;
        }

        @Override // com.avito.android.remote.parse.ParsingAnalytics
        public void send(@NotNull Type type, long j) {
            boolean z;
            Intrinsics.checkNotNullParameter(type, "type");
            if (this.c.getSendMethodsPerformanceStats().invoke().booleanValue()) {
                String replace = new Regex("[^a-zA-Z0-9_-]").replace(type.toString(), "_");
                Annotation[] annotationArr = this.d;
                int length = annotationArr.length;
                boolean z2 = false;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    } else if (Intrinsics.areEqual(JvmClassMappingKt.getAnnotationClass(annotationArr[i]), Reflection.getOrCreateKotlinClass(StreamParsing.class))) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    Analytics analytics = this.a;
                    analytics.track(new StatsdEvent.TimeEvent(this.b.getVersionsPrefix() + ".performance.stream_gson." + replace, Long.valueOf(j)));
                    return;
                }
                Annotation[] annotationArr2 = this.d;
                int length2 = annotationArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        break;
                    } else if (Intrinsics.areEqual(JvmClassMappingKt.getAnnotationClass(annotationArr2[i2]), Reflection.getOrCreateKotlinClass(NonStreamParsing.class))) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    Analytics analytics2 = this.a;
                    analytics2.track(new StatsdEvent.TimeEvent(this.b.getVersionsPrefix() + ".performance.non_stream_gson." + replace, Long.valueOf(j)));
                }
            }
        }
    }

    void send(@NotNull Type type, long j);
}
