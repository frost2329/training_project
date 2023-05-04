package save;

import entity.Brand;
import entity.Device;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileSaver implements ISaver{
    List<Device> devices = new ArrayList<>();

    private void getDevicesFromFile() {
        try (FileInputStream fis = new FileInputStream("devices.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            devices = (List<Device>) ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void sentDevicesToFile() {
        try (FileOutputStream fos = new FileOutputStream("devices.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(devices);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Device device) {
        getDevicesFromFile();
        devices.add(device);
        sentDevicesToFile();
    }

    @Override
    public void drop(Device device) {
        getDevicesFromFile();
        devices.remove(device);
        sentDevicesToFile();
    }

    @Override
    public void dropByPosition(int pos) {
        getDevicesFromFile();
        devices.remove( pos);
        sentDevicesToFile();
    }

    @Override
    public void dropAll() {
        devices.clear();
        sentDevicesToFile();
    }

    @Override
    public List<Device> getAll() {
        getDevicesFromFile();
        return devices;
    }

    @Override
    public List<Device> getByBrand(Brand brand) {
        getDevicesFromFile();
        List<Device> currentDevices = new ArrayList<>();
        for(Device device : devices) {
            if (device.getBrand().equals(brand)) {
                currentDevices.add(device);
            }
        }
        return currentDevices;
    }

    @Override
    public List<Device> getByPriceRange(Integer startPrice, Integer finishPrice) {
        getDevicesFromFile();
        List<Device> currentDevices = new ArrayList<>();
        for(Device device : devices) {
            if (device.getPrice() >= startPrice && device.getPrice() <= finishPrice) {
                currentDevices.add(device);
            }
        }
        return currentDevices;
    }
}
