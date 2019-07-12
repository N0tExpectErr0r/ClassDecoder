package cp_info.bean;

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
}
