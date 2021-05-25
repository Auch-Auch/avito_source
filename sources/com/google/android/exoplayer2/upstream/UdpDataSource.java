package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
public final class UdpDataSource extends BaseDataSource {
    public static final int DEFAULT_MAX_PACKET_SIZE = 2000;
    public static final int DEFAULT_SOCKET_TIMEOUT_MILLIS = 8000;
    public final int e;
    public final byte[] f;
    public final DatagramPacket g;
    @Nullable
    public Uri h;
    @Nullable
    public DatagramSocket i;
    @Nullable
    public MulticastSocket j;
    @Nullable
    public InetAddress k;
    @Nullable
    public InetSocketAddress l;
    public boolean m;
    public int n;

    public static final class UdpDataSourceException extends IOException {
        public UdpDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public UdpDataSource() {
        this(2000);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.h = null;
        MulticastSocket multicastSocket = this.j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.k);
            } catch (IOException unused) {
            }
            this.j = null;
        }
        DatagramSocket datagramSocket = this.i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.i = null;
        }
        this.k = null;
        this.l = null;
        this.n = 0;
        if (this.m) {
            this.m = false;
            transferEnded();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws UdpDataSourceException {
        Uri uri = dataSpec.uri;
        this.h = uri;
        String host = uri.getHost();
        int port = this.h.getPort();
        transferInitializing(dataSpec);
        try {
            this.k = InetAddress.getByName(host);
            this.l = new InetSocketAddress(this.k, port);
            if (this.k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(this.l);
                this.j = multicastSocket;
                multicastSocket.joinGroup(this.k);
                this.i = this.j;
            } else {
                this.i = new DatagramSocket(this.l);
            }
            try {
                this.i.setSoTimeout(this.e);
                this.m = true;
                transferStarted(dataSpec);
                return -1;
            } catch (SocketException e2) {
                throw new UdpDataSourceException(e2);
            }
        } catch (IOException e3) {
            throw new UdpDataSourceException(e3);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i2, int i3) throws UdpDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        if (this.n == 0) {
            try {
                this.i.receive(this.g);
                int length = this.g.getLength();
                this.n = length;
                bytesTransferred(length);
            } catch (IOException e2) {
                throw new UdpDataSourceException(e2);
            }
        }
        int length2 = this.g.getLength();
        int i4 = this.n;
        int min = Math.min(i4, i3);
        System.arraycopy(this.f, length2 - i4, bArr, i2, min);
        this.n -= min;
        return min;
    }

    public UdpDataSource(int i2) {
        this(i2, 8000);
    }

    public UdpDataSource(int i2, int i3) {
        super(true);
        this.e = i3;
        byte[] bArr = new byte[i2];
        this.f = bArr;
        this.g = new DatagramPacket(bArr, 0, i2);
    }
}
