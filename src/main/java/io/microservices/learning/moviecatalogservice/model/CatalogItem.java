package io.microservices.learning.moviecatalogservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
public class CatalogItem {

	/*@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name")
	private String name;
	private String email;
	private String phone;
	private String gender;
	private String city;
	private String state;
	private String country;*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "movie_name")
	private String movieName;
	@Column(name = "movie_desc")
	private String movieDesc;
	@Column(name = "movie_rating")
	private Integer movieRating;

	public CatalogItem(Integer id,String movieName,String movieDesc,Integer movieRating) {
		this.id=id;
		this.movieName=movieName;
		this.movieDesc=movieDesc;
		this.movieRating=movieRating;
	}
	
}
