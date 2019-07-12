package cp_info.bean;

import java.io.DataInputStream;
import java.io.IOException;

public class NameAndTypeInfo extends CpInfo {
    private short nameIndex;
    private short descriptorIndex;

    public short getNameIndex() {
        return nameIndex;
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        nameIndex = in.readShort();
        descriptorIndex = in.readShort();
    }
}
