package org.spongycastle.x509;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Collection;
import org.spongycastle.x509.util.StreamParser;
import org.spongycastle.x509.util.StreamParsingException;
import x6.e.g.e;
public class X509StreamParser implements StreamParser {
    public Provider a;
    public X509StreamParserSpi b;

    public X509StreamParser(Provider provider, X509StreamParserSpi x509StreamParserSpi) {
        this.a = provider;
        this.b = x509StreamParserSpi;
    }

    public static X509StreamParser getInstance(String str) throws NoSuchParserException {
        try {
            e.a f = e.f("X509StreamParser", str);
            return new X509StreamParser(f.b, (X509StreamParserSpi) f.a);
        } catch (NoSuchAlgorithmException e) {
            throw new NoSuchParserException(e.getMessage());
        }
    }

    public Provider getProvider() {
        return this.a;
    }

    public void init(InputStream inputStream) {
        this.b.engineInit(inputStream);
    }

    @Override // org.spongycastle.x509.util.StreamParser
    public Object read() throws StreamParsingException {
        return this.b.engineRead();
    }

    @Override // org.spongycastle.x509.util.StreamParser
    public Collection readAll() throws StreamParsingException {
        return this.b.engineReadAll();
    }

    public void init(byte[] bArr) {
        this.b.engineInit(new ByteArrayInputStream(bArr));
    }

    public static X509StreamParser getInstance(String str, String str2) throws NoSuchParserException, NoSuchProviderException {
        return getInstance(str, e.h(str2));
    }

    public static X509StreamParser getInstance(String str, Provider provider) throws NoSuchParserException {
        try {
            e.a g = e.g("X509StreamParser", str, provider);
            return new X509StreamParser(g.b, (X509StreamParserSpi) g.a);
        } catch (NoSuchAlgorithmException e) {
            throw new NoSuchParserException(e.getMessage());
        }
    }
}
