package constantpool;

import java.io.DataInputStream;
import java.io.IOException;

public class Utf8Info extends CpInfo {
    private short length;
    private String string;

    public short getLength() {
        return length;
    }

    public String getString() {
        return string;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        short length = in.readShort();
        byte[] bytes = new byte[length];
        int len = in.read(bytes, 0, length);
        if (len != length) {
            throw new IOException("read Utf-8 String error");
        }
        string = new String(bytes);
    }

    @Override
    public String toString(CpInfo[] constantPool) {
        return "Utf8Info\t"+string;
    }

    @Override
    public String toString() {
        return string;
    }
}
