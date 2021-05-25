package pl.droidsonroids.relinker.elf;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.UShort;
import okhttp3.internal.ws.WebSocketProtocol;
import org.spongycastle.asn1.cmc.BodyPartID;
import pl.droidsonroids.relinker.elf.Elf;
public class ElfParser implements Closeable, Elf {
    public final FileChannel a;

    public ElfParser(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.a = new FileInputStream(file).getChannel();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    public Elf.Header parseHeader() throws IOException {
        this.a.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (readWord(allocate, 0) == 1179403647) {
            short readByte = readByte(allocate, 4);
            boolean z = readByte(allocate, 5) == 2;
            if (readByte == 1) {
                return new Elf32Header(z, this);
            }
            if (readByte == 2) {
                return new Elf64Header(z, this);
            }
            throw new IllegalStateException("Invalid class type!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    public List<String> parseNeededDependencies() throws IOException {
        long j;
        long j2;
        this.a.position(0L);
        ArrayList arrayList = new ArrayList();
        Elf.Header parseHeader = parseHeader();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(parseHeader.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j3 = (long) parseHeader.phnum;
        int i = 0;
        if (j3 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j3 = parseHeader.getSectionHeader(0).info;
        }
        long j4 = 0;
        while (true) {
            j = 1;
            if (j4 >= j3) {
                j2 = 0;
                break;
            }
            Elf.ProgramHeader programHeader = parseHeader.getProgramHeader(j4);
            if (programHeader.type == 2) {
                j2 = programHeader.offset;
                break;
            }
            j4++;
        }
        if (j2 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j5 = 0;
        while (true) {
            Elf.DynamicStructure dynamicStructure = parseHeader.getDynamicStructure(j2, i);
            long j6 = dynamicStructure.tag;
            if (j6 == 1) {
                arrayList2.add(Long.valueOf(dynamicStructure.val));
            } else if (j6 == 5) {
                j5 = dynamicStructure.val;
            }
            i++;
            if (dynamicStructure.tag == 0) {
                break;
            }
            j2 = j2;
        }
        if (j5 != 0) {
            for (long j7 = 0; j7 < j3; j7 += j) {
                Elf.ProgramHeader programHeader2 = parseHeader.getProgramHeader(j7);
                if (programHeader2.type == j) {
                    long j8 = programHeader2.vaddr;
                    if (j8 > j5) {
                        continue;
                    } else if (j5 <= programHeader2.memsz + j8) {
                        long j9 = (j5 - j8) + programHeader2.offset;
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(readString(allocate, ((Long) it.next()).longValue() + j9));
                        }
                        return arrayList;
                    } else {
                        j = 1;
                    }
                }
            }
            throw new IllegalStateException("Could not map vma to file offset!");
        }
        throw new IllegalStateException("String table offset not found!");
    }

    public void read(ByteBuffer byteBuffer, long j, int i) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < ((long) i)) {
            int read = this.a.read(byteBuffer, j + j2);
            if (read != -1) {
                j2 += (long) read;
            } else {
                throw new EOFException();
            }
        }
        byteBuffer.position(0);
    }

    public short readByte(ByteBuffer byteBuffer, long j) throws IOException {
        read(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }

    public int readHalf(ByteBuffer byteBuffer, long j) throws IOException {
        read(byteBuffer, j, 2);
        return byteBuffer.getShort() & UShort.MAX_VALUE;
    }

    public long readLong(ByteBuffer byteBuffer, long j) throws IOException {
        read(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    public String readString(ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short readByte = readByte(byteBuffer, j);
            if (readByte == 0) {
                return sb.toString();
            }
            sb.append((char) readByte);
            j = j2;
        }
    }

    public long readWord(ByteBuffer byteBuffer, long j) throws IOException {
        read(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & BodyPartID.bodyIdMax;
    }
}
