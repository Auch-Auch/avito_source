package com.yandex.mobile.ads.impl;

import android.support.annotation.Nullable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
public final class td extends SSLSocketFactory {
    private final SSLSocketFactory a;

    private td(SSLSocketFactory sSLSocketFactory) {
        this.a = sSLSocketFactory;
    }

    @Nullable
    public static SSLSocketFactory a() {
        try {
            SSLContext instance = SSLContext.getInstance("TLSv1");
            try {
                instance.init(null, null, null);
            } catch (KeyManagementException e) {
                e.getMessage();
            }
            return new td(instance.getSocketFactory());
        } catch (NoSuchAlgorithmException e2) {
            e2.getMessage();
            return null;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException {
        Socket createSocket = this.a.createSocket(str, i);
        ((SSLSocket) createSocket).setEnabledCipherSuites(a(this.a));
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return a(this.a);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        ArrayList arrayList = new ArrayList(Arrays.asList(this.a.getSupportedCipherSuites()));
        arrayList.remove("TLS_RSA_WITH_AES_128_CBC_SHA");
        arrayList.add(0, "TLS_RSA_WITH_AES_128_CBC_SHA");
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket createSocket = this.a.createSocket(inetAddress, i);
        ((SSLSocket) createSocket).setEnabledCipherSuites(a(this.a));
        return createSocket;
    }

    private static String[] a(SSLSocketFactory sSLSocketFactory) {
        ArrayList arrayList = new ArrayList(Arrays.asList(sSLSocketFactory.getDefaultCipherSuites()));
        arrayList.remove("TLS_RSA_WITH_AES_128_CBC_SHA");
        arrayList.add(0, "TLS_RSA_WITH_AES_128_CBC_SHA");
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = this.a.createSocket(socket, str, i, z);
        ((SSLSocket) createSocket).setEnabledCipherSuites(a(this.a));
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        Socket createSocket = this.a.createSocket(str, i, inetAddress, i2);
        ((SSLSocket) createSocket).setEnabledCipherSuites(a(this.a));
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket createSocket = this.a.createSocket(inetAddress, i, inetAddress2, i2);
        ((SSLSocket) createSocket).setEnabledCipherSuites(a(this.a));
        return createSocket;
    }
}
