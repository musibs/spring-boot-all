package io.codefountain.spring.boot.ad.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Getter
@EqualsAndHashCode
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Who is the owner of the Ad?")
    public String owner;

    @NotNull(message = "You need to provide a title for the ad")
    @Size(min = 5, max = 140, message = "Title must be {min} and {max} characters long")
    public String title;

    @NotNull(message = "You need to provide a description for the ad")
    @Size(min = 5, max = 2000, message = "Description must be {min} and {max} characters long")
    public String description;

    @Min(message = "Price must be more than 0", value = 0)
    public BigDecimal price;

    protected Ad(){}

    public Ad(String owner, String title, String description, BigDecimal price) {
        this.owner = owner;
        this.title = title;
        this.description = description;
        this.price = price;
    }
}
