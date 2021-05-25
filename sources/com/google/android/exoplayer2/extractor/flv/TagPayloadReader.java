package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
public abstract class TagPayloadReader {
    public final TrackOutput a;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str);
        }
    }

    public TagPayloadReader(TrackOutput trackOutput) {
        this.a = trackOutput;
    }

    public final boolean a(ParsableByteArray parsableByteArray, long j) throws ParserException {
        return b(parsableByteArray) && c(parsableByteArray, j);
    }

    public abstract boolean b(ParsableByteArray parsableByteArray) throws ParserException;

    public abstract boolean c(ParsableByteArray parsableByteArray, long j) throws ParserException;
}
