package cp_info.bean;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodTypeInfo extends CpInfo {
    private short descriptorIndex;

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        descriptorIndex = in.readShort();
    }
}
