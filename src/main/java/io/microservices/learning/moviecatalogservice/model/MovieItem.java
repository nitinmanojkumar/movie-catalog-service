package io.microservices.learning.moviecatalogservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="movielist")
@Getter
@Setter
@NoArgsConstructor
public class MovieItem {

	@Id
	private Integer movieid;
	private String moviedesc;
	private String moviename; 
	
}
