package io.microservices.learning.moviecatalogservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ratings")
@Getter
@Setter
@NoArgsConstructor
public class RatingOfItem {

	
	@Id
	private Integer id;
	private Integer movieid;
	private Integer rating;
	
	public RatingOfItem(Integer id, Integer movieid, Integer rating) {
		this.id=id;
		this.movieid=movieid;
		this.rating=rating;
	}
	
}
