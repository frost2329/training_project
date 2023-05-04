package print;

import entity.Device;

import java.io.*;
import java.util.List;

public class FilePrinter implements IPrinter{
    @Override
    public void print(Device device) {
        File file = new File("print_devices.txt");
        try (PrintStream stream = new PrintStream(file)) {
            stream.println(device.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void print(List<Device> devices) {
        File file = new File("print_devices.txt");
        try (PrintStream stream = new PrintStream(file)) {
            for(Device device : devices) {
                stream.println(device.toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
