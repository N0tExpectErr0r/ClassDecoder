package cp_info.bean;

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
}
