package com.google.android.exoplayer2.analytics;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
public final class DefaultPlaybackSessionManager implements PlaybackSessionManager {
    public static final Supplier<String> DEFAULT_SESSION_ID_GENERATOR = a2.j.b.b.q0.a.a;
    public static final Random h = new Random();
    public final Timeline.Window a;
    public final Timeline.Period b;
    public final HashMap<String, a> c;
    public final Supplier<String> d;
    public PlaybackSessionManager.Listener e;
    public Timeline f;
    @Nullable
    public String g;

    public final class a {
        public final String a;
        public int b;
        public long c;
        public MediaSource.MediaPeriodId d;
        public boolean e;
        public boolean f;

        public a(String str, int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            long j;
            this.a = str;
            this.b = i;
            if (mediaPeriodId == null) {
                j = -1;
            } else {
                j = mediaPeriodId.windowSequenceNumber;
            }
            this.c = j;
            if (mediaPeriodId != null && mediaPeriodId.isAd()) {
                this.d = mediaPeriodId;
            }
        }

        public boolean a(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (mediaPeriodId == null) {
                return i == this.b;
            }
            MediaSource.MediaPeriodId mediaPeriodId2 = this.d;
            if (mediaPeriodId2 == null) {
                if (mediaPeriodId.isAd() || mediaPeriodId.windowSequenceNumber != this.c) {
                    return false;
                }
                return true;
            } else if (mediaPeriodId.windowSequenceNumber == mediaPeriodId2.windowSequenceNumber && mediaPeriodId.adGroupIndex == mediaPeriodId2.adGroupIndex && mediaPeriodId.adIndexInAdGroup == mediaPeriodId2.adIndexInAdGroup) {
                return true;
            } else {
                return false;
            }
        }

        public boolean b(AnalyticsListener.EventTime eventTime) {
            long j = this.c;
            if (j == -1) {
                return false;
            }
            MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
            if (mediaPeriodId == null) {
                if (this.b != eventTime.windowIndex) {
                    return true;
                }
                return false;
            } else if (mediaPeriodId.windowSequenceNumber > j) {
                return true;
            } else {
                if (this.d == null) {
                    return false;
                }
                int indexOfPeriod = eventTime.timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
                int indexOfPeriod2 = eventTime.timeline.getIndexOfPeriod(this.d.periodUid);
                MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.mediaPeriodId;
                if (mediaPeriodId2.windowSequenceNumber < this.d.windowSequenceNumber || indexOfPeriod < indexOfPeriod2) {
                    return false;
                }
                if (indexOfPeriod > indexOfPeriod2) {
                    return true;
                }
                if (mediaPeriodId2.isAd()) {
                    MediaSource.MediaPeriodId mediaPeriodId3 = eventTime.mediaPeriodId;
                    int i = mediaPeriodId3.adGroupIndex;
                    int i2 = mediaPeriodId3.adIndexInAdGroup;
                    MediaSource.MediaPeriodId mediaPeriodId4 = this.d;
                    int i3 = mediaPeriodId4.adGroupIndex;
                    if (i > i3 || (i == i3 && i2 > mediaPeriodId4.adIndexInAdGroup)) {
                        return true;
                    }
                    return false;
                }
                int i4 = eventTime.mediaPeriodId.nextAdGroupIndex;
                if (i4 == -1 || i4 > this.d.adGroupIndex) {
                    return true;
                }
                return false;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000d, code lost:
            if (r0 < r5.getWindowCount()) goto L_0x003f;
         */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0044 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0045  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean c(com.google.android.exoplayer2.Timeline r4, com.google.android.exoplayer2.Timeline r5) {
            /*
                r3 = this;
                int r0 = r3.b
                int r1 = r4.getWindowCount()
                r2 = -1
                if (r0 < r1) goto L_0x0012
                int r4 = r5.getWindowCount()
                if (r0 >= r4) goto L_0x0010
                goto L_0x003f
            L_0x0010:
                r0 = -1
                goto L_0x003f
            L_0x0012:
                com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager r1 = com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.this
                com.google.android.exoplayer2.Timeline$Window r1 = r1.a
                r4.getWindow(r0, r1)
                com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager r0 = com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.this
                com.google.android.exoplayer2.Timeline$Window r0 = r0.a
                int r0 = r0.firstPeriodIndex
            L_0x001f:
                com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager r1 = com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.this
                com.google.android.exoplayer2.Timeline$Window r1 = r1.a
                int r1 = r1.lastPeriodIndex
                if (r0 > r1) goto L_0x0010
                java.lang.Object r1 = r4.getUidOfPeriod(r0)
                int r1 = r5.getIndexOfPeriod(r1)
                if (r1 == r2) goto L_0x003c
                com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager r4 = com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.this
                com.google.android.exoplayer2.Timeline$Period r4 = r4.b
                com.google.android.exoplayer2.Timeline$Period r4 = r5.getPeriod(r1, r4)
                int r0 = r4.windowIndex
                goto L_0x003f
            L_0x003c:
                int r0 = r0 + 1
                goto L_0x001f
            L_0x003f:
                r3.b = r0
                r4 = 0
                if (r0 != r2) goto L_0x0045
                return r4
            L_0x0045:
                com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r3.d
                r1 = 1
                if (r0 != 0) goto L_0x004b
                return r1
            L_0x004b:
                java.lang.Object r0 = r0.periodUid
                int r5 = r5.getIndexOfPeriod(r0)
                if (r5 == r2) goto L_0x0054
                r4 = 1
            L_0x0054:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.a.c(com.google.android.exoplayer2.Timeline, com.google.android.exoplayer2.Timeline):boolean");
        }
    }

    public DefaultPlaybackSessionManager() {
        this(DEFAULT_SESSION_ID_GENERATOR);
    }

    public final a a(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        int i2;
        a aVar = null;
        long j = Long.MAX_VALUE;
        for (a aVar2 : this.c.values()) {
            if (aVar2.c == -1 && i == aVar2.b && mediaPeriodId != null) {
                aVar2.c = mediaPeriodId.windowSequenceNumber;
            }
            if (aVar2.a(i, mediaPeriodId)) {
                long j2 = aVar2.c;
                if (j2 == -1 || j2 < j) {
                    aVar = aVar2;
                    j = j2;
                } else if (!(i2 != 0 || ((a) Util.castNonNull(aVar)).d == null || aVar2.d == null)) {
                    aVar = aVar2;
                }
            }
        }
        if (aVar != null) {
            return aVar;
        }
        String str = this.d.get();
        a aVar3 = new a(str, i, mediaPeriodId);
        this.c.put(str, aVar3);
        return aVar3;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized boolean belongsToSession(AnalyticsListener.EventTime eventTime, String str) {
        a aVar = this.c.get(str);
        if (aVar == null) {
            return false;
        }
        int i = eventTime.windowIndex;
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if (aVar.c == -1 && i == aVar.b && mediaPeriodId != null) {
            aVar.c = mediaPeriodId.windowSequenceNumber;
        }
        return aVar.a(i, mediaPeriodId);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public void finishAllSessions(AnalyticsListener.EventTime eventTime) {
        PlaybackSessionManager.Listener listener;
        this.g = null;
        Iterator<a> it = this.c.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            it.remove();
            if (next.e && (listener = this.e) != null) {
                listener.onSessionFinished(eventTime, next.a, false);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized String getSessionForMediaPeriodId(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        return a(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.b).windowIndex, mediaPeriodId).a;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public void setListener(PlaybackSessionManager.Listener listener) {
        this.e = listener;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r3.windowSequenceNumber < r5) goto L_0x0031;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d2  */
    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateSessions(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime r25) {
        /*
        // Method dump skipped, instructions count: 241
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.updateSessions(com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0091, code lost:
        if (r9.adIndexInAdGroup == r3.adIndexInAdGroup) goto L_0x00ad;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0079  */
    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateSessionsWithDiscontinuity(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime r8, int r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r0 = r7.e     // Catch:{ all -> 0x00af }
            com.google.android.exoplayer2.util.Assertions.checkNotNull(r0)     // Catch:{ all -> 0x00af }
            r0 = 0
            r1 = 1
            if (r9 == 0) goto L_0x0010
            r2 = 3
            if (r9 != r2) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r9 = 0
            goto L_0x0011
        L_0x0010:
            r9 = 1
        L_0x0011:
            java.util.HashMap<java.lang.String, com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$a> r2 = r7.c     // Catch:{ all -> 0x00af }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x00af }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00af }
        L_0x001b:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00af }
            if (r3 == 0) goto L_0x0054
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00af }
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$a r3 = (com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.a) r3     // Catch:{ all -> 0x00af }
            boolean r4 = r3.b(r8)     // Catch:{ all -> 0x00af }
            if (r4 == 0) goto L_0x001b
            r2.remove()     // Catch:{ all -> 0x00af }
            boolean r4 = r3.e     // Catch:{ all -> 0x00af }
            if (r4 == 0) goto L_0x001b
            java.lang.String r4 = r3.a     // Catch:{ all -> 0x00af }
            java.lang.String r5 = r7.g     // Catch:{ all -> 0x00af }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00af }
            if (r9 == 0) goto L_0x0046
            if (r4 == 0) goto L_0x0046
            boolean r5 = r3.f     // Catch:{ all -> 0x00af }
            if (r5 == 0) goto L_0x0046
            r5 = 1
            goto L_0x0047
        L_0x0046:
            r5 = 0
        L_0x0047:
            if (r4 == 0) goto L_0x004c
            r4 = 0
            r7.g = r4     // Catch:{ all -> 0x00af }
        L_0x004c:
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r4 = r7.e     // Catch:{ all -> 0x00af }
            java.lang.String r3 = r3.a     // Catch:{ all -> 0x00af }
            r4.onSessionFinished(r8, r3, r5)     // Catch:{ all -> 0x00af }
            goto L_0x001b
        L_0x0054:
            java.util.HashMap<java.lang.String, com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$a> r9 = r7.c     // Catch:{ all -> 0x00af }
            java.lang.String r0 = r7.g     // Catch:{ all -> 0x00af }
            java.lang.Object r9 = r9.get(r0)     // Catch:{ all -> 0x00af }
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$a r9 = (com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.a) r9     // Catch:{ all -> 0x00af }
            int r0 = r8.windowIndex     // Catch:{ all -> 0x00af }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r8.mediaPeriodId     // Catch:{ all -> 0x00af }
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$a r0 = r7.a(r0, r1)     // Catch:{ all -> 0x00af }
            java.lang.String r1 = r0.a     // Catch:{ all -> 0x00af }
            r7.g = r1     // Catch:{ all -> 0x00af }
            r7.updateSessions(r8)     // Catch:{ all -> 0x00af }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r8.mediaPeriodId     // Catch:{ all -> 0x00af }
            if (r1 == 0) goto L_0x00ad
            boolean r1 = r1.isAd()     // Catch:{ all -> 0x00af }
            if (r1 == 0) goto L_0x00ad
            if (r9 == 0) goto L_0x0093
            long r1 = r9.c     // Catch:{ all -> 0x00af }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r8.mediaPeriodId     // Catch:{ all -> 0x00af }
            long r4 = r3.windowSequenceNumber     // Catch:{ all -> 0x00af }
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0093
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r9 = r9.d     // Catch:{ all -> 0x00af }
            if (r9 == 0) goto L_0x0093
            int r1 = r9.adGroupIndex     // Catch:{ all -> 0x00af }
            int r2 = r3.adGroupIndex     // Catch:{ all -> 0x00af }
            if (r1 != r2) goto L_0x0093
            int r9 = r9.adIndexInAdGroup     // Catch:{ all -> 0x00af }
            int r1 = r3.adIndexInAdGroup     // Catch:{ all -> 0x00af }
            if (r9 == r1) goto L_0x00ad
        L_0x0093:
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r9 = new com.google.android.exoplayer2.source.MediaSource$MediaPeriodId     // Catch:{ all -> 0x00af }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r8.mediaPeriodId     // Catch:{ all -> 0x00af }
            java.lang.Object r2 = r1.periodUid     // Catch:{ all -> 0x00af }
            long r3 = r1.windowSequenceNumber     // Catch:{ all -> 0x00af }
            r9.<init>(r2, r3)     // Catch:{ all -> 0x00af }
            int r1 = r8.windowIndex     // Catch:{ all -> 0x00af }
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$a r9 = r7.a(r1, r9)     // Catch:{ all -> 0x00af }
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r1 = r7.e     // Catch:{ all -> 0x00af }
            java.lang.String r9 = r9.a     // Catch:{ all -> 0x00af }
            java.lang.String r0 = r0.a     // Catch:{ all -> 0x00af }
            r1.onAdPlaybackStarted(r8, r9, r0)     // Catch:{ all -> 0x00af }
        L_0x00ad:
            monitor-exit(r7)
            return
        L_0x00af:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.updateSessionsWithDiscontinuity(com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime, int):void");
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized void updateSessionsWithTimelineChange(AnalyticsListener.EventTime eventTime) {
        Assertions.checkNotNull(this.e);
        Timeline timeline = this.f;
        this.f = eventTime.timeline;
        Iterator<a> it = this.c.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.c(timeline, this.f)) {
                it.remove();
                if (next.e) {
                    if (next.a.equals(this.g)) {
                        this.g = null;
                    }
                    this.e.onSessionFinished(eventTime, next.a, false);
                }
            }
        }
        updateSessionsWithDiscontinuity(eventTime, 4);
    }

    public DefaultPlaybackSessionManager(Supplier<String> supplier) {
        this.d = supplier;
        this.a = new Timeline.Window();
        this.b = new Timeline.Period();
        this.c = new HashMap<>();
        this.f = Timeline.EMPTY;
    }
}
