package constantpool;

import java.io.DataInputStream;
import java.io.IOException;

public class StringInfo extends CpInfo{
    private short stringIndex;

    public short getStringIndex() {
        return stringIndex;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        stringIndex = in.readShort();
    }

    @Override
    public String toString(CpInfo[] constantPool) {
        return "StringInfo\t#"+stringIndex+"\t// "+constantPool[stringIndex-1];
    }
}
