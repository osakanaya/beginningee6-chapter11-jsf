package org.beginningee6.book.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.beginningee6.book.ejb.BookEJB;
import org.beginningee6.book.jpa.Book;

/**
 * 書籍情報登録ページの画面表示、および、
 * この画面からの登録実行を処理するマネージドBean。
 */
@ManagedBean
@RequestScoped
public class BookController {
	
	@EJB						// EJBの注入
	private BookEJB bookEJB;
	
	// 画面表示および画面入力に用いるデータ
	private Book book = new Book();
	private List<Book> bookList = new ArrayList<Book>();
	
	/**
	 * 書籍登録画面（newBook.xhtml）でフォームをサブミットした時に
	 * 実行されるアクションメソッド。
	 */
	public String doCreateBook() {
		
		book = bookEJB.createBook(book);
		bookList = bookEJB.findBooks();
		
		return "listBooks.xhtml";
	}

	/**
	 * bookプロパティの取得。
	 */
	public Book getBook() {
		
		return book;
	}

	/**
	 * bookプロパティの設定。
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * bookListプロパティの取得。
	 */
	public List<Book> getBookList() {
		return bookList;
	}

	/**
	 * bookListプロパティの設定。
	 */
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
}
