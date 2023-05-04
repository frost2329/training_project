package print;

import entity.Brand;
import entity.Device;

import java.util.ArrayList;
import java.util.List;

public interface IPrinter {
    void print(Device device);
    void print(List<Device> devices);
}
