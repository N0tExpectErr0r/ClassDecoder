package constantpool;

import java.io.DataInputStream;
import java.io.IOException;

public class ClazzInfo extends CpInfo {
    private short nameIndex;

    public short getNameIndex() {
        return nameIndex;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        nameIndex = in.readShort();
    }

    @Override
    public String toString(CpInfo[] constantPool) {
        return "\t#"+nameIndex+"\t//"+constantPool[nameIndex];
    }
}
