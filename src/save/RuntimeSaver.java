package save;

import entity.Brand;
import entity.Device;

import java.util.ArrayList;
import java.util.List;

public class RuntimeSaver implements ISaver{
    List<Device> devices = new ArrayList<Device>();
    @Override
    public void save(Device device) {
        devices.add(device);
    }

    @Override
    public void drop(Device device) {
        devices.remove(device);
    }

    @Override
    public void dropByPosition(int pos) {
        devices.remove( pos);
    }

    @Override
    public void dropAll() {
        devices.clear();
    }

    @Override
    public List<Device> getAll() {
        return devices;
    }

    @Override
    public List<Device> getByBrand(Brand brand) {
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
        List<Device> currentDevices = new ArrayList<>();
        for(Device device : devices) {
            if (device.getPrice() >= startPrice && device.getPrice() <= finishPrice) {
                currentDevices.add(device);
            }
        }
        return currentDevices;
    }
}
