package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
public class DashManifest implements FilterableManifest<DashManifest> {
    public final List<Period> a;
    public final long availabilityStartTimeMs;
    public final long durationMs;
    public final boolean dynamic;
    @Nullable
    public final Uri location;
    public final long minBufferTimeMs;
    public final long minUpdatePeriodMs;
    @Nullable
    public final ProgramInformation programInformation;
    public final long publishTimeMs;
    public final long suggestedPresentationDelayMs;
    public final long timeShiftBufferDepthMs;
    @Nullable
    public final UtcTimingElement utcTiming;

    @Deprecated
    public DashManifest(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, @Nullable UtcTimingElement utcTimingElement, @Nullable Uri uri, List<Period> list) {
        this(j, j2, j3, z, j4, j5, j6, j7, null, utcTimingElement, uri, list);
    }

    public final Period getPeriod(int i) {
        return this.a.get(i);
    }

    public final int getPeriodCount() {
        return this.a.size();
    }

    public final long getPeriodDurationMs(int i) {
        if (i != this.a.size() - 1) {
            return this.a.get(i + 1).startMs - this.a.get(i).startMs;
        }
        long j = this.durationMs;
        if (j == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        return j - this.a.get(i).startMs;
    }

    public final long getPeriodDurationUs(int i) {
        return C.msToUs(getPeriodDurationMs(i));
    }

    public DashManifest(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, @Nullable ProgramInformation programInformation2, @Nullable UtcTimingElement utcTimingElement, @Nullable Uri uri, List<Period> list) {
        this.availabilityStartTimeMs = j;
        this.durationMs = j2;
        this.minBufferTimeMs = j3;
        this.dynamic = z;
        this.minUpdatePeriodMs = j4;
        this.timeShiftBufferDepthMs = j5;
        this.suggestedPresentationDelayMs = j6;
        this.publishTimeMs = j7;
        this.programInformation = programInformation2;
        this.utcTiming = utcTimingElement;
        this.location = uri;
        this.a = list == null ? Collections.emptyList() : list;
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public final DashManifest copy(List<StreamKey> list) {
        long j;
        DashManifest dashManifest = this;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j2 = 0;
        int i = 0;
        while (true) {
            int periodCount = getPeriodCount();
            j = C.TIME_UNSET;
            if (i >= periodCount) {
                break;
            }
            if (((StreamKey) linkedList.peek()).periodIndex != i) {
                long periodDurationMs = dashManifest.getPeriodDurationMs(i);
                if (periodDurationMs != C.TIME_UNSET) {
                    j2 += periodDurationMs;
                }
            } else {
                Period period = dashManifest.getPeriod(i);
                List<AdaptationSet> list2 = period.adaptationSets;
                StreamKey streamKey = (StreamKey) linkedList.poll();
                int i2 = streamKey.periodIndex;
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    int i3 = streamKey.groupIndex;
                    AdaptationSet adaptationSet = list2.get(i3);
                    List<Representation> list3 = adaptationSet.representations;
                    ArrayList arrayList3 = new ArrayList();
                    do {
                        arrayList3.add(list3.get(streamKey.trackIndex));
                        streamKey = (StreamKey) linkedList.poll();
                        if (streamKey.periodIndex != i2) {
                            break;
                        }
                    } while (streamKey.groupIndex == i3);
                    arrayList2.add(new AdaptationSet(adaptationSet.id, adaptationSet.type, arrayList3, adaptationSet.accessibilityDescriptors, adaptationSet.essentialProperties, adaptationSet.supplementalProperties));
                    if (streamKey.periodIndex != i2) {
                        break;
                    }
                    list2 = list2;
                }
                linkedList.addFirst(streamKey);
                arrayList.add(new Period(period.id, period.startMs - j2, arrayList2, period.eventStreams));
            }
            i++;
            dashManifest = this;
        }
        long j3 = dashManifest.durationMs;
        if (j3 != C.TIME_UNSET) {
            j = j3 - j2;
        }
        return new DashManifest(dashManifest.availabilityStartTimeMs, j, dashManifest.minBufferTimeMs, dashManifest.dynamic, dashManifest.minUpdatePeriodMs, dashManifest.timeShiftBufferDepthMs, dashManifest.suggestedPresentationDelayMs, dashManifest.publishTimeMs, dashManifest.programInformation, dashManifest.utcTiming, dashManifest.location, arrayList);
    }
}
