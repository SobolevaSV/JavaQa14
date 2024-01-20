package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(01, "Роза", 100);
    Product product2 = new Product(02, "Хризантема", 80);
    Product product3 = new Product(03, "Тюльпан", 50);

    @Test
    public void shoulRemoveExistentProduct() {
        ShopRepository repository = new ShopRepository();
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        Product[] expected = {product1, product3};
        Product[] actual = repository.removeById(02);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shoulRemoveNonExistentProduct() {
        ShopRepository repository = new ShopRepository();
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(04);
        });
    }

    @Test
    public void shoulAddNonExistentProduct() {
        ShopRepository repository = new ShopRepository();
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        Product[] expected = {product1, product2, product3};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shoulAddExistentProduct() {
        ShopRepository repository = new ShopRepository();
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.add(product3);
        });
    }
}