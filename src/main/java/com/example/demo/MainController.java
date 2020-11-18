package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Authors;
import com.example.demo.entities.Books;
import com.example.demo.repository.AuthorsRepository;
import com.example.demo.repository.BooksRepository;

@Controller 
@RequestMapping(path="/demo")
public class MainController {

	@Autowired 
	private AuthorsRepository authorsRepository;
	
	@Autowired 
	private BooksRepository booksRepository;

	@PostMapping(path="/author/add")
	public @ResponseBody String addNewAuthor (@RequestParam String country, @RequestParam String firstName, @RequestParam String lastName) {
		Authors a = new Authors();
		a.setCountry(country);
		a.setFirstName(firstName);
		a.setLastName(lastName);
		authorsRepository.save(a);
		return "Saved";
	}

	@GetMapping(path="/author/all")
	public @ResponseBody Iterable<Authors> getAllAuthors() {
		return authorsRepository.findAll();
	}

	@PutMapping("/author/update")
	public @ResponseBody String updateOneAuthor(@RequestParam Integer id, @RequestParam String country) {
		Optional<Authors> foundAuthor = authorsRepository.findById(id);
		if (!foundAuthor.isPresent())
			throw new IllegalArgumentException();
		Authors author = foundAuthor.get();
		author.setCountry(country);
		authorsRepository.save(author);
		return "Updated";
	}

	@DeleteMapping(path="/author/remove")
	public @ResponseBody String removeOneAuthor(@RequestParam Integer id) {
		authorsRepository.deleteById(id);
		return "Deleted";
	}
	
	
	
	@GetMapping(path="/book/all")
	public @ResponseBody Iterable<Books> getAllBooks() {
		return booksRepository.findAll();
	}
	
	@DeleteMapping(path="/book/remove")
	public @ResponseBody String removeOneBook(@RequestParam String isbn) {
		booksRepository.deleteById(isbn);
		return "Deleted";
	}
	
	@PutMapping(path="/book/update")
	public @ResponseBody String updateOneBook(@RequestParam String isbn, @RequestParam String title, @RequestParam String yearPub) {
		Optional<Books> foundBook = booksRepository.findById(isbn);
		if (!foundBook.isPresent())
			throw new IllegalArgumentException();
		Books book = foundBook.get();
		book.setTitle(title);
		book.setYearPub(yearPub);
		booksRepository.save(book);
		return "Updated";
	}
	
	@PostMapping(path="/book/add")
	public @ResponseBody String addNewBook (@RequestParam Integer authorId, @RequestParam String description, @RequestParam String isbn, @RequestParam String title, @RequestParam String yearPub) {
		Optional<Authors> foundAuthor = authorsRepository.findById(authorId);
		if (!foundAuthor.isPresent())
			throw new IllegalArgumentException();
		Authors author = foundAuthor.get();
		Books b = new Books();
		b.setAuthor(author);
		b.setDescription(description);
		b.setIsbn(isbn);
		b.setTitle(title);
		b.setYearPub(yearPub);
		booksRepository.save(b);
		return "Saved";
	}

}
