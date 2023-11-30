import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    ShopRepository service = new ShopRepository();

    Product prod1 = new Product(5, "Хлеб", 22);
    Product prod2 = new Product(10, "Спички", 11);
    Product prod3 = new Product(15, "Сахар", 33);

    @Test
    public void idHaveProduct() {
        service.add(prod1);
        service.add(prod2);
        service.add(prod3);
        service.removeById(10);


        Product[] expected = {prod1, prod3};
        Product[] actual = service.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void idNowHaveProduct() {
        service.add(prod1);
        service.add(prod2);
        service.add(prod3);
        //service.removeById(19);


        Assertions.assertThrows(NotFoundException.class, () -> {
            service.removeById(19);
        });

    }

    @Test
    public void addRecurringId() {
        service.add(prod1);
        service.add(prod2);
        service.add(prod3);
        //service.add(prod1);


        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            service.add(prod1);
        });

    }

    @Test
    public void idNewProduct() {
        service.add(prod1);
        service.add(prod2);
        service.add(prod3);


        Product[] expected = {prod1, prod2, prod3};
        Product[] actual = service.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

}