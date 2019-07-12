package cp_info.bean;

import java.io.DataInputStream;
import java.io.IOException;

public class LongInfo extends CpInfo {
    private long value;

    public long getValue() {
        return value;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        value = in.readLong();
    }
}
