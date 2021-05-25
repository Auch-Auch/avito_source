package a2.j.b.b.z0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
public final class l {
    public final ExtractorsFactory a;
    @Nullable
    public Extractor b;
    @Nullable
    public ExtractorInput c;

    public l(ExtractorsFactory extractorsFactory) {
        this.a = extractorsFactory;
    }

    public long a() {
        ExtractorInput extractorInput = this.c;
        if (extractorInput != null) {
            return extractorInput.getPosition();
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r6.getPosition() != r11) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0062, code lost:
        if (r6.getPosition() != r11) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
        r1 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.google.android.exoplayer2.upstream.DataReader r8, android.net.Uri r9, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10, long r11, long r13, com.google.android.exoplayer2.extractor.ExtractorOutput r15) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.exoplayer2.extractor.DefaultExtractorInput r6 = new com.google.android.exoplayer2.extractor.DefaultExtractorInput
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.c = r6
            com.google.android.exoplayer2.extractor.Extractor r8 = r7.b
            if (r8 == 0) goto L_0x0010
            return
        L_0x0010:
            com.google.android.exoplayer2.extractor.ExtractorsFactory r8 = r7.a
            com.google.android.exoplayer2.extractor.Extractor[] r8 = r8.createExtractors(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L_0x0020
            r8 = r8[r13]
            r7.b = r8
            goto L_0x0075
        L_0x0020:
            int r10 = r8.length
            r0 = 0
        L_0x0022:
            if (r0 >= r10) goto L_0x0071
            r1 = r8[r0]
            boolean r2 = r1.sniff(r6)     // Catch:{ EOFException -> 0x0057, all -> 0x0042 }
            if (r2 == 0) goto L_0x0035
            r7.b = r1     // Catch:{ EOFException -> 0x0057, all -> 0x0042 }
            com.google.android.exoplayer2.util.Assertions.checkState(r14)
            r6.resetPeekPosition()
            goto L_0x0071
        L_0x0035:
            com.google.android.exoplayer2.extractor.Extractor r1 = r7.b
            if (r1 != 0) goto L_0x0067
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0065
            goto L_0x0067
        L_0x0042:
            r8 = move-exception
            com.google.android.exoplayer2.extractor.Extractor r9 = r7.b
            if (r9 != 0) goto L_0x004f
            long r9 = r6.getPosition()
            int r14 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r14 != 0) goto L_0x0050
        L_0x004f:
            r13 = 1
        L_0x0050:
            com.google.android.exoplayer2.util.Assertions.checkState(r13)
            r6.resetPeekPosition()
            throw r8
        L_0x0057:
            com.google.android.exoplayer2.extractor.Extractor r1 = r7.b
            if (r1 != 0) goto L_0x0067
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r1 = 0
            goto L_0x0068
        L_0x0067:
            r1 = 1
        L_0x0068:
            com.google.android.exoplayer2.util.Assertions.checkState(r1)
            r6.resetPeekPosition()
            int r0 = r0 + 1
            goto L_0x0022
        L_0x0071:
            com.google.android.exoplayer2.extractor.Extractor r10 = r7.b
            if (r10 == 0) goto L_0x007b
        L_0x0075:
            com.google.android.exoplayer2.extractor.Extractor r8 = r7.b
            r8.init(r15)
            return
        L_0x007b:
            com.google.android.exoplayer2.source.UnrecognizedInputFormatException r10 = new com.google.android.exoplayer2.source.UnrecognizedInputFormatException
            java.lang.String r11 = "None of the available extractors ("
            java.lang.StringBuilder r11 = a2.b.a.a.a.L(r11)
            java.lang.String r8 = com.google.android.exoplayer2.util.Util.getCommaDelimitedSimpleClassNames(r8)
            java.lang.String r12 = ") could read the stream."
            java.lang.String r8 = a2.b.a.a.a.t(r11, r8, r12)
            java.lang.Object r9 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            r10.<init>(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.z0.l.b(com.google.android.exoplayer2.upstream.DataReader, android.net.Uri, java.util.Map, long, long, com.google.android.exoplayer2.extractor.ExtractorOutput):void");
    }
}
