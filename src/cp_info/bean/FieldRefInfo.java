package cp_info.bean;

import java.io.DataInputStream;
import java.io.IOException;

public class FieldRefInfo extends CpInfo{
    private short clazzIndex;
    private short nameAndTypeIndex;

    public short getClazzIndex() {
        return clazzIndex;
    }

    public short getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        clazzIndex = in.readShort();
        nameAndTypeIndex = in.readShort();
    }
}
