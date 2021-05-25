package com.google.android.exoplayer2.source.chunk;

import java.util.NoSuchElementException;
public abstract class BaseMediaChunkIterator implements MediaChunkIterator {
    public final long a;
    public final long b;
    public long c;

    public BaseMediaChunkIterator(long j, long j2) {
        this.a = j;
        this.b = j2;
        reset();
    }

    public final void checkInBounds() {
        long j = this.c;
        if (j < this.a || j > this.b) {
            throw new NoSuchElementException();
        }
    }

    public final long getCurrentIndex() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public boolean isEnded() {
        return this.c > this.b;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public boolean next() {
        this.c++;
        return !isEnded();
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public void reset() {
        this.c = this.a - 1;
    }
}
