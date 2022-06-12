package com.cos.book.service;

import com.cos.book.domain.Book;
import com.cos.book.domain.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 단위 테스트 (Service와 관련된 애들만 메모리에 띄우면 됨)
 * BoardRepository => 가짜 객체로 만들 수 있음.
 * @InjectMocks => BookService 객체가 만들어질 때 BookServiceUnitTest 파일에 @Mock로 등록된 모든 데이터를 주입받는다.
 */

@ExtendWith(MockitoExtension.class)
public class BookServiceUnitTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void 저장하기_테스트(){
        // given
        Book book = new Book();
        book.setTitle("책제목1");
        book.setAuthor("책저자1");

        // stub - 동작 지정
        Mockito.when(bookRepository.save(book)).thenReturn(book);

        // test execute
        Book bookEntity = bookService.저장하기(book);

        // then
        assertEquals(bookEntity, book);
    }

}
