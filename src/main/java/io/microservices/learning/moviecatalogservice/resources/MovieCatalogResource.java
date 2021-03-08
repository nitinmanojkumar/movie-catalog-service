package io.microservices.learning.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.microservices.learning.moviecatalogservice.dao.movieCatalogRepository;
import io.microservices.learning.moviecatalogservice.model.CatalogItem;
import io.microservices.learning.moviecatalogservice.model.MovieItem;
import io.microservices.learning.moviecatalogservice.model.RatingOfItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private movieCatalogRepository repo;

	@Autowired
	private RestTemplate rest;

	@Autowired
	private WebClient.Builder webClientBuilder; 
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> getCatalog(@PathVariable("userId") Integer userId) {
		
		try {

			CatalogItem item1;
			// get all the movie id related to this user
			List<RatingOfItem> rating = Arrays.asList(new RatingOfItem(1, 1000, 5), new RatingOfItem(1, 1001, 3),
					new RatingOfItem(2, 1001, 5));
			// get the movie id from above step and get the movie details
			List<CatalogItem> list = new ArrayList<>();
			for (RatingOfItem r : rating) {
				System.out.println(r.getId());
				System.out.println(r.getMovieid());
				System.out.println(r.getRating());
				MovieItem item = rest.getForObject("http://localhost:7778/movieItem/" + r.getMovieid(),
						MovieItem.class);
				// item1 = repo.findById(r.getId()).get();
				list.add(new CatalogItem(r.getId(), item.getMoviename(), item.getMoviedesc(), r.getRating()));
			}

			// display all them together
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			return ResponseEntity.status(404).body(null);
		}
	}
	
	@GetMapping("/webClientway/{userId}")
	public ResponseEntity<?> getCatalog1(@PathVariable("userId") Integer userId) {
		
		try {

			CatalogItem item1;
			// get all the movie id related to this user
			List<RatingOfItem> rating = Arrays.asList(new RatingOfItem(1, 1000, 5), new RatingOfItem(1, 1001, 3),
					new RatingOfItem(2, 1001, 5));
			// get the movie id from above step and get the movie details
			List<CatalogItem> list = new ArrayList<>();
			for (RatingOfItem r : rating) {
				System.out.println(r.getId());
				System.out.println(r.getMovieid());
				System.out.println(r.getRating());
				MovieItem item=webClientBuilder.build()
						.get()
						.uri("http://localhost:7778/movieItem/" + r.getMovieid())
						.retrieve()
						.bodyToMono(MovieItem.class)
						.block();
				
				// item1 = repo.findById(r.getId()).get();
				list.add(new CatalogItem(r.getId(), item.getMoviename(), item.getMoviedesc(), r.getRating()));
			}

			// display all them together
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			return ResponseEntity.status(404).body(null);
		}
	}

}
