package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;
public final class zzbdx extends SSLSocketFactory {
    private SSLSocketFactory zzejm = ((SSLSocketFactory) SSLSocketFactory.getDefault());
    private final /* synthetic */ zzbdu zzejn;

    public zzbdx(zzbdu zzbdu) {
        this.zzejn = zzbdu;
    }

    private final Socket zzb(Socket socket) throws SocketException {
        if (zzbdu.zza(this.zzejn) > 0) {
            socket.setReceiveBufferSize(zzbdu.zza(this.zzejn));
        }
        zzbdu.zza(this.zzejn, socket);
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return zzb(this.zzejm.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.zzejm.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.zzejm.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException {
        return zzb(this.zzejm.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return zzb(this.zzejm.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return zzb(this.zzejm.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return zzb(this.zzejm.createSocket(inetAddress, i, inetAddress2, i2));
    }
}
