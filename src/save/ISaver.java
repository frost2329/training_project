package save;

import entity.Brand;
import entity.Device;

import java.util.List;

public interface ISaver {
    void save(Device device);
    void drop(Device device);
    void dropByPosition(int pos);
    void dropAll();
    List<Device> getAll();
    List<Device> getByBrand(Brand brand);
    List<Device> getByPriceRange(Integer startPrice, Integer finishPrice);
}
