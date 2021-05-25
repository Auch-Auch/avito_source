package com.google.android.exoplayer2.upstream;

import a2.j.b.b.d1.e;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Map;
public abstract class BaseDataSource implements DataSource {
    public final boolean a;
    public final ArrayList<TransferListener> b = new ArrayList<>(1);
    public int c;
    @Nullable
    public DataSpec d;

    public BaseDataSource(boolean z) {
        this.a = z;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        if (!this.b.contains(transferListener)) {
            this.b.add(transferListener);
            this.c++;
        }
    }

    public final void bytesTransferred(int i) {
        DataSpec dataSpec = (DataSpec) Util.castNonNull(this.d);
        for (int i2 = 0; i2 < this.c; i2++) {
            this.b.get(i2).onBytesTransferred(this, dataSpec, this.a, i);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public /* synthetic */ Map getResponseHeaders() {
        return e.$default$getResponseHeaders(this);
    }

    public final void transferEnded() {
        DataSpec dataSpec = (DataSpec) Util.castNonNull(this.d);
        for (int i = 0; i < this.c; i++) {
            this.b.get(i).onTransferEnd(this, dataSpec, this.a);
        }
        this.d = null;
    }

    public final void transferInitializing(DataSpec dataSpec) {
        for (int i = 0; i < this.c; i++) {
            this.b.get(i).onTransferInitializing(this, dataSpec, this.a);
        }
    }

    public final void transferStarted(DataSpec dataSpec) {
        this.d = dataSpec;
        for (int i = 0; i < this.c; i++) {
            this.b.get(i).onTransferStart(this, dataSpec, this.a);
        }
    }
}
