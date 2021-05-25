package pl.droidsonroids.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import pl.droidsonroids.relinker.elf.Elf;
public class Program32Header extends Elf.ProgramHeader {
    public Program32Header(ElfParser elfParser, Elf.Header header, long j) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(header.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = (j * ((long) header.phentsize)) + header.phoff;
        this.type = elfParser.readWord(allocate, j2);
        this.offset = elfParser.readWord(allocate, 4 + j2);
        this.vaddr = elfParser.readWord(allocate, 8 + j2);
        this.memsz = elfParser.readWord(allocate, j2 + 20);
    }
}
