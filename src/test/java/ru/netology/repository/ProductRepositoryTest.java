package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book book1 = new Book(1, "Игла", 10, "Артемьева");
    Book book2 = new Book(2, "Гроза", 20, "Островский");
    Book book3 = new Book(3, "Мать", 30, "Горький");
    Smartphone smartphone1 = new Smartphone(1, "версия 11", 80_000, "Apple");
    Smartphone smartphone2 = new Smartphone(1, "версия 10", 20_000, "Xiaomi");// вместо "Xiaomi"
    Smartphone smartphone3 = new Smartphone(1, "версия 7", 30_000, "Samsung");


    @Test
    public void shouldSaveOneItem() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);


        Product[] actual = manager.searchBy("Игла");

        Product[] expected = new Product[]{book1};

        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSaveOneSmart() {

        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);

        Product[] actual = manager.searchBy("версия 11");

        Product[] expected = new Product[]{smartphone1};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSaveAuthor() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);


        Product[] actual = manager.searchBy("Артемьева");

        Product[] expected = new Product[]{book1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveManufacturer() {
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);


        Product[] actual = manager.searchBy("Xiaomi");

        Product[] expected = new Product[]{smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveNullSmart() {
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);


        Product[] actual = manager.searchBy("smartphone4");

        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }
}