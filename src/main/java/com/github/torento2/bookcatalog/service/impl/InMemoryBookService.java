package com.github.torento2.bookcatalog.service.impl;

import com.github.torento2.bookcatalog.service.BookService;
import com.github.torento2.bookcatalog.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InMemoryBookService implements BookService {
    private Map<Long, Book> bookList;

    {
        bookList = new HashMap<>();

        bookList.put(1L, new Book(1L, "Dawson Michael",

                "Python dla każdego. Podstawy programowania",

                "45234523",

                "Chcesz się nauczyć programować? Świetna decyzja! Wybierz język obiektowy, łatwy w użyciu, " +

                        "z przejrzystą składnią. Python będzie wprost doskonały! Rozwijany od ponad 20 lat, " +

                        "jest dojrzałym językiem, pozwalającym tworzyć zaawansowane aplikacje dla różnych systemów " +

                        "operacyjnych. Ponadto posiada system automatycznego zarządzania pamięcią, który zdejmuje " +

                        "z programisty obowiązek panowania nad tym skomplikowanym obszarem.",

                2014));


        bookList.put(2L, new Book(2L,

                "Robert C. Martin", "Czysty kod. Podręcznik dobrego programisty",

                "54325342",

                "Poznaj najlepsze metody tworzenia doskonałego kodu",

                2014));

        bookList.put(3L, new Book(3L,

                "Althoff Cory", "Programista samouk. Profesjonalny przewodnik do samodzielnej nauki kodowania",

                "634565",

                "Nie wystarczy znajomość jednego języka programowania, aby zostać programistą. " +

                        "W rzeczywistości trzeba opanować dość szeroki zakres pojęć i paradygmatów, a także zrozumieć " +

                        "zagadnienia związane z algorytmami. Trzeba być na bieżąco z nowymi technologiami i narzędziami. " +

                        "Należy również poznać i zacząć stosować dobre praktyki programistyczne i przyswoić sobie zasady " +

                        "pracy w zespole. Przede wszystkim jednak priorytetem jest sama praktyka, ponieważ wielu programistów " +

                        "wciąż ma problem z pisaniem poprawnego kodu.",

                2017));

    }

    @Override
    public List<Book> getBooks() {
        return new ArrayList<>(bookList.values());
    }

    @Override
    public Book getBook(Long id) {
        return bookList.get(id);
    }

    @Override
    public void saveBook(Book book) {
        Long id = generateId();
        book.setId(id);
        bookList.put(id, book);
    }

    @Override
    public void addBook(Book book) {

    }

    private Long generateId() {
        return Collections.max(bookList.keySet()) + 1;
    }
}


