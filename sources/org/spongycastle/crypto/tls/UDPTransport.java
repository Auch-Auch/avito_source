package org.spongycastle.crypto.tls;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class UDPTransport implements DatagramTransport {
    public static final int MAX_IP_OVERHEAD = 84;
    public static final int MIN_IP_OVERHEAD = 20;
    public static final int UDP_OVERHEAD = 8;
    public final int receiveLimit;
    public final int sendLimit;
    public final DatagramSocket socket;

    public UDPTransport(DatagramSocket datagramSocket, int i) throws IOException {
        if (!datagramSocket.isBound() || !datagramSocket.isConnected()) {
            throw new IllegalArgumentException("'socket' must be bound and connected");
        }
        this.socket = datagramSocket;
        this.receiveLimit = (i - 20) - 8;
        this.sendLimit = (i - 84) - 8;
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public void close() throws IOException {
        this.socket.close();
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public int getReceiveLimit() {
        return this.receiveLimit;
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public int getSendLimit() {
        return this.sendLimit;
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public int receive(byte[] bArr, int i, int i2, int i3) throws IOException {
        this.socket.setSoTimeout(i3);
        DatagramPacket datagramPacket = new DatagramPacket(bArr, i, i2);
        this.socket.receive(datagramPacket);
        return datagramPacket.getLength();
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public void send(byte[] bArr, int i, int i2) throws IOException {
        if (i2 <= getSendLimit()) {
            this.socket.send(new DatagramPacket(bArr, i, i2));
            return;
        }
        throw new TlsFatalAlert(80);
    }
}
