package a2.j.b.a.c;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Set;
public final class g implements TransportFactory {
    public final Set<Encoding> a;
    public final TransportContext b;
    public final j c;

    public g(Set<Encoding> set, TransportContext transportContext, j jVar) {
        this.a = set;
        this.b = transportContext;
        this.c = jVar;
    }

    @Override // com.google.android.datatransport.TransportFactory
    public <T> Transport<T> getTransport(String str, Class<T> cls, Transformer<T, byte[]> transformer) {
        return getTransport(str, cls, Encoding.of("proto"), transformer);
    }

    @Override // com.google.android.datatransport.TransportFactory
    public <T> Transport<T> getTransport(String str, Class<T> cls, Encoding encoding, Transformer<T, byte[]> transformer) {
        if (this.a.contains(encoding)) {
            return new i(this.b, str, encoding, transformer, this.c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", encoding, this.a));
    }
}
