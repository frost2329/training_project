package print;

import entity.Device;

import java.util.ArrayList;
import java.util.List;

public class ConsolePrinter implements IPrinter {
    @Override
    public void print(Device device) {
        System.out.println(device);
    }

    @Override
    public void print(List<Device> devices) {
        for(Device device : devices) {
            System.out.println(device);
        }
    }
}
